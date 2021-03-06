package org.kosta.madfortaste.help.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;
import org.kosta.madfortaste.help.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="noticelist")
	public ModelAndView loadNoticeList(String pageNo){
		Page page = null;
		System.out.println(pageNo);
		ModelAndView mv = new ModelAndView("help/notice");
		List<Notice> list = noticeService.loadNoticeList(pageNo);
		mv.addObject("boardList",list);
		mv.addObject("pageInfo",page);
		return mv;
		
	}
	@RequestMapping("showContentView")
	public ModelAndView showContentView(String no){
		System.out.println(no);
		Notice notice = noticeService.getContents(no);
		return new ModelAndView("help/contentView","content",notice);
	}
	
	@RequestMapping("insertView")
	public String insertView(){
		return "help/insertView";
	}
	
	@RequestMapping("insert")
	public ModelAndView insert(Notice notice){
		noticeService.insert(notice);
		return new ModelAndView("redirect:noticelist");
	}
	
	@RequestMapping("updateView")
	public ModelAndView updateView(Notice notice){
		System.out.println("updateView Controller : "+notice.getTitle());
		return new ModelAndView("help/updateView","updateElement",notice);
	}
	
	@RequestMapping("update")
	public ModelAndView update(Notice notice){
		System.out.println("Controller update : "+notice.getArticleNo());
		noticeService.update(notice);
		return new ModelAndView("redirect:showContentView?no="+notice.getArticleNo());
	}
	
	
}
































