package org.kosta.madfortaste.market.web;

import java.util.List;

import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return "market/popup/item_popup";
	}
	
	@ResponseBody
	@RequestMapping(value="itemList.json")
	public List<Item> itemListJson(int page) {
		List<Item> itemList = marketService.getItemsByPaging(page);
		return itemList;
	}
	
}
