package org.kosta.madfortaste.help.web;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;
import org.kosta.madfortaste.help.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QnaController {
	
	@Resource(name="qnaServiceImpl")
	private QnaService qnaService;
	
	@RequestMapping(value="qnalist")
	public ModelAndView loadQnaList(String pageNo){
		ModelAndView mv = new ModelAndView("help/qna");
		Page page = new Page(qnaService.totalQnaContentCount());
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		page.setCurrentPage(Integer.parseInt(pageNo));
		List<Qna> list = qnaService.loadQnaList(page);
		System.out.println(list);
		mv.addObject("qnaBoardList",list);
		mv.addObject("qnaPageInfo",page);
		return mv;
		
	}
	@RequestMapping(value="qnaShowContentView")
	public ModelAndView qnaShowContentView(String no){
		System.out.println("qnaShowContentView : "+no);
		Qna qna = qnaService.getQnaContents(no);
		return new ModelAndView("help/qnacontentView","qnaContent",qna);
	}
	
	@RequestMapping(value="insertQnaView")
	public String insertQnaView(){
		return "help/insertQnaView";
	}
	
	@RequestMapping(value="insertQna")
	public ModelAndView insertQna(Qna qna){
		qnaService.insertQna(qna);
		return new ModelAndView("redirect:qnalist");
	}
	
	@RequestMapping(value="qnaUpdateView")
	public ModelAndView qnaUpdateView(Qna qna){
		qna = qnaService.getQnaContents(qna.getArticleNo());
		return new ModelAndView("help/qnaUpdateView","qnaUpdateElement",qna);
	}
	
	@RequestMapping(value="updateQna")
	public ModelAndView updateQna(Qna qna){
		System.out.println("Controller update : "+qna.getArticleNo());
		qnaService.updateQna(qna);
		return new ModelAndView("redirect:qnaShowContentView?no="+qna.getArticleNo());
	}
	
	@RequestMapping(value="deleteQna")
	public String deleteQna(Qna qna){
		String no = qna.getArticleNo();
		System.out.println("delete : "+no);
		qnaService.deleteQna(no);
		return "redirect:qnalist";
	}
	
	@RequestMapping(value="qnaReplyInsertView")
	public ModelAndView replyView(String articleNo){
		System.out.println("replyView : "+articleNo);
		Qna qna = qnaService.noCountGetContentsQna(articleNo);
		System.out.println(qna);
		return new ModelAndView("help/qnaReplyInsertView","insertReply",qna);
	}
	
	@RequestMapping(value="insertRefContent")
	public ModelAndView reply(Qna qna) throws Exception{		
		qnaService.reply(qna);		
		return new ModelAndView("redirect:qnalist");
	}
	
	
}
