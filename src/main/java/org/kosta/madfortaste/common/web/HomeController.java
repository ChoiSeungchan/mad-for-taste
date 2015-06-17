package org.kosta.madfortaste.common.web;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.service.TasteBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private TasteBoardService tasteBoardService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		Page page = new Page(tasteBoardService.getTotalCount());
		model.addAttribute("tasteBoard", tasteBoardService
				.getArticles(page));
		model.addAttribute("page", page);
		return "home";
	}
}
