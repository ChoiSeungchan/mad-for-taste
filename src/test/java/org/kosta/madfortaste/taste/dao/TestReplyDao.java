package org.kosta.madfortaste.taste.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestReplyDao {

	@Autowired
	private ReplyDao dao;
	
	@Before
	public void setUp() {
		assertNotNull(dao);
	}
	
	@Test
	public void testInsertReply() {
		dao.insertReply(new Reply(1, "member", "댓글 테스트 입니다"));
	}
	
	@Test
	public void testGetReplies() {
		List<Reply> list = dao.getReplies(1);
		for (Reply reply : list) {
			System.out.println(reply);
		}
	}
	
	@Test
	public void testSelectReply() {
		Reply reply = dao.selectReply(1);
		System.out.println(reply);
	}
	
	@Test
	public void testUpdateReply() {
		Reply reply = dao.selectReply(1);
		System.out.println(reply);
		reply.setContents("업데이트 된 리플 입니다.");
		dao.updateReply(reply);
		reply = dao.selectReply(1);
		System.out.println(reply);
	}
	
	@Transactional
	@Test
	public void testDeleteReply() {
		dao.deleteReply(1);
		Reply reply = dao.selectReply(1);
		System.out.println(reply);
	}
	
	@Test
	public void testReplyUpGood() {
		Reply reply = dao.selectReply(1);
		System.out.println(reply);
		dao.upGood(1);
		reply = dao.selectReply(1);
		System.out.println(reply);
		
	}
	
	@Test
	public void testReplyUpBad() {
		Reply reply = dao.selectReply(1);
		System.out.println(reply);
		dao.upBad(1);
		reply = dao.selectReply(1);
		System.out.println(reply);
	}
	
	@Test
	public void testGetReplyCount() {
		int replyCount = dao.getReplyCount(1);
		System.out.println(replyCount);
	}
}
