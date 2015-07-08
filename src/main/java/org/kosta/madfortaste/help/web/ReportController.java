package org.kosta.madfortaste.help.web;

import java.util.HashMap;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.ArticleReport;
import org.kosta.madfortaste.help.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@ResponseBody
	@RequestMapping(value="articleReport.ajax")
	public Map<String, Object> tasteBoardReport(ArticleReport report) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			reportService.insertArticleReport(report);
		} catch (Exception e) {
			map.put("message", "이미 신고하신 게시물 입니다.");
		}
		return map;
	}
	
	@RequestMapping(value="reportAdmin/{pageNo}") 
	public String reportAdmin(@PathVariable int pageNo, Model model) {
		Page page = new Page(reportService.getArticleReportTotalCount());
		model.addAttribute("reportList", reportService.selectArticleReportsByPaging(page));
		model.addAttribute("page", page);
		return "help/admin/reportAdmin";
	}
	
	@RequestMapping(value="reportAdmin/blindArticle")
	public String blindArticle(ArticleReport report) {
		if(report!=null) {
			reportService.blindArticle(report);
		}
		return "redirect:/reportAdmin/1";
	}
}
