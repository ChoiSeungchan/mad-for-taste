package org.kosta.madfortaste.help.web;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;
import org.kosta.madfortaste.help.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QnaController {
	
	@Autowired
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
		mv.addObject("qnaBoardList",list);
		mv.addObject("qnaPageInfo",page);
		return mv;
		
	}
	@RequestMapping("qnaShowContentView")
	public ModelAndView qnaShowContentView(String no){
		System.out.println(no);
		Qna qna = qnaService.getQnaContents(no);
		return new ModelAndView("help/qnacontentView","qnaContent",qna);
	}
	
	@RequestMapping("qnaInsertView")
	public String qnaInsertView(){
		return "help/qnaInsertView";
	}
	
	@RequestMapping("insertQna")
	public ModelAndView insertQna(Qna qna){
		qnaService.insertQna(qna);
		return new ModelAndView("redirect:qnalist");
	}
	
	@RequestMapping("qnaUpdateView")
	public ModelAndView qnaUpdateView(Qna qna){
		qna = qnaService.getQnaContents(qna.getArticleNo());
		return new ModelAndView("help/qnaUpdateView","qnaUpdateElement",qna);
	}
	
	@RequestMapping("updateQna")
	public ModelAndView updateQna(Qna qna){
		System.out.println("Controller update : "+qna.getArticleNo());
		qnaService.updateQna(qna);
		return new ModelAndView("redirect:qnaShowContentView?no="+qna.getArticleNo());
	}
	
	@RequestMapping("deleteQna")
	public String deleteQna(Qna qna){
		String no = qna.getArticleNo();
		System.out.println("delete : "+no);
		qnaService.deleteQna(no);
		return "redirect:qnalist";
	}
}
