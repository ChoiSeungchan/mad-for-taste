package org.kosta.madfortaste.taste.service;

import java.util.List;

import org.kosta.madfortaste.taste.dao.ReplyDao;
import org.kosta.madfortaste.taste.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyDao replyDao;

	@Override
	public void insertReply(Reply reply) {
		replyDao.insertReply(reply);
	}

	@Override
	public List<Reply> getReplies(int articleNo) {
		return replyDao.getReplies(articleNo);
	}

	@Override
	public Reply selectReply(int replyNo) {
		return replyDao.selectReply(replyNo);
	}

	@Override
	public void updateReply(Reply reply) {
		replyDao.updateReply(reply);
	}

	@Override
	public void deleteReply(int replyNo) {
		replyDao.deleteReply(replyNo);
	}

	@Override
	public void upGood(int replyNo) {
		replyDao.upGood(replyNo);
	}

	@Override
	public void upBad(int replyNo) {
		replyDao.upBad(replyNo);
	}

}
