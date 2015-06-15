package org.kosta.madfortaste.help.web;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;
import org.kosta.madfortaste.help.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	public ModelAndView loadNoticeList(String pageNo,Page page){
		ModelAndView mv = new ModelAndView("layout");
		List<Notice> list = noticeService.loadNoticeList(pageNo);
		mv.addObject("boardList",list);
		mv.addObject("pageInfo",page);
		return mv;
		
	}
}
