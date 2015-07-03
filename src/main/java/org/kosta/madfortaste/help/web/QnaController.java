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

	@Resource(name = "qnaServiceImpl")
	private QnaService qnaService;

	@RequestMapping(value = "qnalist")
	public ModelAndView loadQnaList(String pageNo, String searchSelect,
			String input) {
		ModelAndView mv = new ModelAndView("help/qna");
		List<Qna> list = null;
		if (pageNo == null || pageNo == "") {
			pageNo = "1";
		}
		if (input == null){
			input = "";
		}
		if (searchSelect == null){
			searchSelect = "";
		}
		Page page = new Page(qnaService.totalQnaContentCount(input));
		page.setCurrentPage(Integer.parseInt(pageNo));
		if (searchSelect.equals("0")) {
			list = qnaService.loadQnaListByInput(page,searchSelect, input);
		} else if(searchSelect.equals("1")){
			list = qnaService.loadQnaListByInput(page,searchSelect, input);
			/*page.setCurrentPage(Integer.parseInt(pageNo));*/
		}else {
			list = qnaService.loadQnaList(page);
			/*page.setCurrentPage(Integer.parseInt(pageNo));*/
		}
		mv.addObject("qnaBoardList", list);
		mv.addObject("qnaPageInfo", page);
		return mv;

	}

	@RequestMapping(value = "qnaShowContentView")
	public ModelAndView qnaShowContentView(String no) {
//		System.out.println("qnaShowContentView : " + no);
		Qna qna = qnaService.getQnaContents(no);
		return new ModelAndView("help/qnacontentView", "qnaContent", qna);
	}

	@RequestMapping(value = "insertQnaView")
	public String insertQnaView() {
		return "help/insertQnaView";
	}

	@RequestMapping(value = "insertQna")
	public ModelAndView insertQna(Qna qna) {
		qnaService.insertQna(qna);
		return new ModelAndView("redirect:qnalist");
	}

	@RequestMapping(value = "qnaUpdateView")
	public ModelAndView qnaUpdateView(Qna qna) {
		qna = qnaService.getQnaContents(qna.getArticleNo());
		return new ModelAndView("help/qnaUpdateView", "qnaUpdateElement", qna);
	}

	@RequestMapping(value = "updateQna")
	public ModelAndView updateQna(Qna qna) {
		System.out.println("Controller update : " + qna.getArticleNo());
		qnaService.updateQna(qna);
		return new ModelAndView("redirect:qnaShowContentView?no="
				+ qna.getArticleNo());
	}

	@RequestMapping(value = "deleteQna")
	public String deleteQna(Qna qna) {
		String no = qna.getArticleNo();
		System.out.println("delete : " + no);
		qnaService.deleteQna(no);
		return "redirect:qnalist";
	}

	// 답글 버튼 클릭시 답글 등록 창으로 이동
	@RequestMapping(value = "qnaReplyInsertView")
	public ModelAndView replyView(String articleNo) {
		System.out.println("replyView : " + articleNo);
		Qna qna = qnaService.noCountGetContentsQna(articleNo);
		System.out.println(qna);
		return new ModelAndView("help/qnaReplyInsertView", "insertReply", qna);
	}

	// 답글 등록시 답글 처리로직
	@RequestMapping(value = "insertRefContent")
	public ModelAndView reply(Qna qna) throws Exception {
		qnaService.reply(qna);
		System.out.println("답글처리 : " + qna.getRelevel());
		return new ModelAndView("redirect:qnalist");
	}

}
