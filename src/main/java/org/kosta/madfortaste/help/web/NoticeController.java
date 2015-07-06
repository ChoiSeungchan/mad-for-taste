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
	
	/**
	 * 페이징 처리와 동시에 메인 페이지에서 공지사항 게시글 리스트를
	 * 보여주는 컨트롤러이다. 
	 * 처음 화면을 띄울때는 페이지버튼을 누르지 않은 상태이기 때문에
	 * pageNo가 null처리 될 수 있다. 이경우 1페이지로 초기화 시켜준다.
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="noticelist")
	public ModelAndView loadNoticeList(String pageNo){
		ModelAndView mv = new ModelAndView("help/notice");
		Page page = new Page(noticeService.totalContentCount());
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		page.setCurrentPage(Integer.parseInt(pageNo));
		List<Notice> list = noticeService.loadNoticeList(page);
		mv.addObject("boardList",list);
		mv.addObject("pageInfo",page);
		return mv;
		
	}
	
	/**
	 * notice.jsp에서 tr
	 * @param no
	 * @return
	 */
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
		System.out.println(notice.toString());
		noticeService.insert(notice);
		return new ModelAndView("redirect:noticelist");
	}
	
	@RequestMapping("updateView")
	public ModelAndView updateView(Notice notice){
		notice = noticeService.getContents(notice.getArticleNo());
		return new ModelAndView("help/updateView","updateElement",notice);
	}
	
	@RequestMapping("update")
	public ModelAndView update(Notice notice){
		System.out.println("Controller update : "+notice.getArticleNo());
		noticeService.update(notice);
		return new ModelAndView("redirect:showContentView?no="+notice.getArticleNo());
	}
	
	@RequestMapping("delete")
	public String delete(Notice notice){
		String no = notice.getArticleNo();
		System.out.println("delete : "+no);
		noticeService.delete(no);
		return "redirect:noticelist";
	}
	
}
































