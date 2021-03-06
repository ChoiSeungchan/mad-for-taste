package org.kosta.madfortaste.taste.web;

import javax.servlet.http.HttpServletRequest;

import org.kosta.madfortaste.taste.domain.Reply;
import org.kosta.madfortaste.taste.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="registerTasteBoardReply")
	public String registerReply(Reply reply, HttpServletRequest request) {
		replyService.insertReply(reply);
		return "redirect:article/"+reply.getArticleNo();
	}
}
