package org.kosta.madfortaste.market.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.kosta.madfortaste.common.domain.ListContainer;
import org.kosta.madfortaste.market.domain.Inventory;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.exception.PurchaseException;
import org.kosta.madfortaste.market.service.MarketService;
import org.kosta.madfortaste.user.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarketController {
	
	@Autowired
	private MarketService marketService;
	
	@RequestMapping("market")
	public String marketHome(Model model){
		return "market/market";
	}
	
	@RequestMapping("market/item/{itemNo}")
	public String itemDetail(@PathVariable int itemNo, Model model) {
		model.addAttribute("item", marketService.selectItem(itemNo));
		return "market/purchase/item_popup";
	}
	
	@ResponseBody
	@RequestMapping(value="itemList.json")
	public List<Item> itemListJson(int page) {
		List<Item> itemList = marketService.getItemsByPaging(page);
		return itemList;
	}
	
	@RequestMapping(value="itemRegisterForm")
	public String itemRegisterForm(@ModelAttribute Item item) {
		return "market/itemRegisterForm";
	}
	
	@RequestMapping(value="myInventory")
	public String myInventory(HttpSession session, Model model) {
		if(session!=null){
			Member member = (Member) session.getAttribute("member");
			if(member!=null) {
				ListContainer container = marketService.getMyInventory(member.getId());
				model.addAttribute("container", container);
			} else {
				return "redirect:/";
			}
		}
		return "market/inventory";
	}

	@RequestMapping(value="registerItem", method=RequestMethod.POST)
	public String registerItem(@Valid Item item, BindingResult result, HttpServletRequest req, Model model) {
		System.out.println(item.getItemImg());
		if(result.hasErrors()){
			return "market/itemRegisterForm";
		}
		try {
			marketService.registerItem(item, req);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:market";
	}
	
	@RequestMapping(value="market/purchase/{path}")
	public String resultRedirectService(@PathVariable String path) {
		return "market/purchase/"+path;
	}
	
	@ResponseBody
	@RequestMapping(value="purchaseItem.ajax", method=RequestMethod.POST)
	public Map<String, Object> purchaseItem(Inventory inventory, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Member member = (Member) session.getAttribute("member");
		if(member!=null) {
			try{
				marketService.itemPurchaseService(inventory);
				map.put("purchaseResult", "success");
			} catch (PurchaseException e) {
				map.put("purchaseResult", "failure");
				map.put("message", e.getMessage());
			}
		} else {
			map.put("message", "로그인 후에 이용하실 수 있습니다");
		}
		return map;
	}
	
}
