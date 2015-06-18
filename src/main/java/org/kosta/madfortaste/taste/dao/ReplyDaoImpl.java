package org.kosta.madfortaste.taste.dao;

import java.util.List;

import org.kosta.madfortaste.taste.domain.Reply;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertReply(Reply reply) {
		sqlSessionTemplate.insert("insertReply", reply);
	}

	@Override
	public List<Reply> getReplies(int articleNo) {
		return sqlSessionTemplate.selectList("getReplies", articleNo);
	}

	@Override
	public Reply selectReply(int replyNo) {
		return sqlSessionTemplate.selectOne("selectReply", replyNo);
	}

	@Override
	public void updateReply(Reply reply) {
		sqlSessionTemplate.update("updateReply", reply);
	}

	@Override
	public void deleteReply(int replyNo) {
		sqlSessionTemplate.delete("deleteReply", replyNo);
	}

	@Override
	public void upGood(int replyNo) {
		sqlSessionTemplate.update("replyUpGood", replyNo);
	}
	
	@Override
	public void upBad(int replyNo) {
		sqlSessionTemplate.update("replyUpBad", replyNo);
	}

	@Override
	public int getReplyCount(int articleNo) {
		return sqlSessionTemplate.selectOne("getReplyCount", articleNo);
	}

}
