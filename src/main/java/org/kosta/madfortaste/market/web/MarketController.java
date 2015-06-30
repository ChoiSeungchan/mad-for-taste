package org.kosta.madfortaste.market.web;

import java.util.ArrayList;
import java.util.List;

import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.service.MerketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarketController {
	@Autowired
	private MerketService merketService;
	
	@RequestMapping("marketService")
	public String marketService(String currPage,Model model){
		model.addAttribute("itemList", merketService.marketService(currPage));
		return "user/marketService";
	}
	
	@RequestMapping("findItemByNoAjax")
	@ResponseBody
	public Item findItemByNo(String no){
		return merketService.findItemByNo(no);
	}
}
