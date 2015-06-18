package org.kosta.madfortaste.taste.dao;

import java.util.List;

import org.kosta.madfortaste.taste.domain.Reply;

public interface ReplyDao {

	public void insertReply(Reply reply);

	public List<Reply> getReplies(int articleNo);

	public Reply selectReply(int replyNo);

	public void updateReply(Reply reply);

	public void deleteReply(int replyNo);

}
