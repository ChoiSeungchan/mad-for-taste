package org.kosta.madfortaste.taste.web;

import org.kosta.madfortaste.taste.domain.Reply;
import org.kosta.madfortaste.taste.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="registerTasteBoardReply")
	public String registerReply(@RequestParam Reply reply) {
		replyService.insertReply(reply);
		return "redirect:article/"+reply.getArticleNo();
	}
}
