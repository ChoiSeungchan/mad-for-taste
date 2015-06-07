package org.kosta.madfortaste.user.dao;


import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.user.domain.LevelTable;
import org.kosta.madfortaste.user.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMemberDao {

	private Logger log = LoggerFactory.getLogger(getClass());
	@Resource
	MemberDaoImpl memberDao;

	@Test
	public void setUp() {
		assertNotNull(memberDao);
	}
	
	@Test
	public void testPaging() {
		int totalCount = memberDao.selectTotalCount();
		Page page = new Page(totalCount);
		log.info(page.toString());
		page.preview();
	}

	@Test
	public void testInsertMemberTest() {
		Member member = new Member("hs9923", "1234", "정현승", "성남시 분당구 서현동", "남", "1989-02-04", "01089909923");
		Member insertedMember = memberDao.insertMember(member);
		assertThat(insertedMember.getId(), is(member.getId()));
	}

	@Test
	public void testSelectMemberById() {
		String id = "hs9923";
		Member member = memberDao.selectMemberById(id);
		assertThat(member.getId(), is(id));
		log.info(member.toString());
	}
	
	@Transactional
	@Test
	public void testUpdateMember() {
		int totalCount = memberDao.selectTotalCount();
		assertThat(totalCount, greaterThan(0));
		List<Member> memberList = memberDao.selectMemberList(new Page(totalCount));
		Member member = memberList.get(totalCount-1);
		int beforeExp = member.getExp();
		member.setExp(member.getExp()+50);
		memberDao.updateMember(member);
		Member afterMember = memberList.get(totalCount-1);
		int afterExp = afterMember.getExp();
		log.info("업데이트 전 EXP: " + beforeExp);
		log.info("업데이트 후 EXP: " + afterExp);
		assertNotEquals(beforeExp, afterExp);
	}
	
	@Transactional
	@Test
	public void testDeleteMember() {
		Page page = new Page(memberDao.selectTotalCount());
		List<Member> memberList = memberDao.selectMemberList(page);
		int expectedListSize = page.getEndRow()-page.getBeginRow() + 1;
		assertThat(memberList.size(), is(expectedListSize));
		Member beforeMember = memberList.get(expectedListSize -1);
		memberDao.deleteMember(beforeMember.getId());
		Member afterMember = memberDao.selectMemberById(beforeMember.getId());
		assertNull(afterMember);
		log.info("아이디가 {}인 회원이 성공적으로 삭제되었습니다.", beforeMember.getId());
	}
	
	@Test
	public void testSelectTotalCount(){
		int totalCount = memberDao.selectTotalCount();
		log.info("MEMBER 테이블에 있는 데이터의 갯수는 "+totalCount + "개 입니다");
	}
	
	@Test
	public void testSelectMemberList() {
		int totalCount = memberDao.selectTotalCount();
		Page page = new Page(totalCount);
		List<Member> memberList = memberDao.selectMemberList(page);
		if(totalCount==0) {
			assertThat(memberList.size(), is(0));
			log.info("회원이 없습니다.");
		} else {
			assertThat(memberList.size(), greaterThan(0));
			for (Member member : memberList) {
				log.info(member.toString());
			}
		}
	}
}
