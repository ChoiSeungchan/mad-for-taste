package org.kosta.madfortaste.help.web;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;
import org.kosta.madfortaste.help.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticelist")
	public ModelAndView loadNoticeList(String pageNo){
		Page page = null;
		System.out.println(pageNo);
		ModelAndView mv = new ModelAndView("help/notice");
		List<Notice> list = noticeService.loadNoticeList(pageNo);
		mv.addObject("boardList",list);
		mv.addObject("pageInfo",page);
		return mv;
		
	}
	
/*	public ModelAndView insert(Notice notice){
		noticeService.insert(notice);
		return new ModelAndView("redirect:help/notice");
	}*/
}
































