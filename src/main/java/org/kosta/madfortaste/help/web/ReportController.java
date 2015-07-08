package org.kosta.madfortaste.help.web;

import org.kosta.madfortaste.help.domain.ArticleReport;
import org.kosta.madfortaste.help.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

	private ReportService reportService;
	
	@RequestMapping(value="tasteBoardReport")
	public String tasteBoardReport(ArticleReport report) {
		System.out.println(report);
		//reportService.insertArticleReport(report);
		return "redirect:article/"+report.getArticleNo();
	}
}
