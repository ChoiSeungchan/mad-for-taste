package org.kosta.madfortaste.taste.service;

import java.util.List;

import org.kosta.madfortaste.taste.domain.Reply;

public interface ReplyService {
	
	public void insertReply(Reply reply);

	public List<Reply> getReplies(int articleNo);

	public Reply selectReply(int replyNo);

	public void updateReply(Reply reply);

	public void deleteReply(int replyNo);

	public void upGood(int replyNo);

	public void upBad(int replyNo);
	
}
