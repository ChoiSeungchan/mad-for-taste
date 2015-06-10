package org.kosta.madfortaste.user.dao;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Before;
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
	MemberDao memberDao;

	@Before
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
	
	@Resource
	LevelTable levelTable;
	
	@Test
	public void testInsertMemberTest() {
		Member member = new Member("java1234", "1234", "정현승", "성남시 분당구 서현동", "남", "1989-02-04", "01089909923");
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
		member.setExp(beforeExp+50);
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
		String beforeMemberId = beforeMember.getId();
		memberDao.deleteMember(beforeMember.getId());
		Member afterMember = memberDao.selectMemberById(beforeMemberId);
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
	
	@Transactional
	@Test
	public void testUpExp() {
		int totalCount = memberDao.selectTotalCount();
		assertThat(totalCount, greaterThan(0));
		List<Member> memberList = memberDao.selectMemberList(new Page(totalCount));
		Member member = memberList.get(totalCount-1);
		String id = member.getId();
		int exp = member.getExp();
		int acquiredExp = new Random().nextInt(1000);
		memberDao.upExp(id, acquiredExp);
		Member afterMember = memberDao.selectMemberById(id);
		log.info("id = "+ id +" // 경험치 " + acquiredExp +"획득 후 "+ exp +"에서 "  +afterMember.getExp()+"로 변경되었습니다.");
	}
	
	@Transactional
	@Test
	public void testUpPoint() {
		int totalCount = memberDao.selectTotalCount();
		assertThat(totalCount, greaterThan(0));
		List<Member> memberList = memberDao.selectMemberList(new Page(totalCount));
		Member member = memberList.get(totalCount-1);
		String id = member.getId();
		int beforePoint = member.getPoint();
		int acquiredPoint = new Random().nextInt(1000);
		memberDao.upPoint(id, acquiredPoint);
		Member afterMember = memberDao.selectMemberById(id);
		log.info("id = "+ id +" // 포인트 " + acquiredPoint +"획득 후 "+ beforePoint +"에서 "  +afterMember.getPoint() +"로 변경되었습니다.");
	}
	
	@Transactional
	@Test
	public void testDownPoint() {
		int totalCount = memberDao.selectTotalCount();
		assertThat(totalCount, greaterThan(0));
		List<Member> memberList = memberDao.selectMemberList(new Page(totalCount));
		Member member = memberList.get(totalCount-1);
		String id = member.getId();
		int beforePoint = member.getPoint();
		int lostPoint = new Random().nextInt(1000);
		if(beforePoint > lostPoint) {
			memberDao.downPoint(id, lostPoint);
			Member afterMember = memberDao.selectMemberById(id);
			log.info("id = "+ id +" // 포인트 " + lostPoint +"잃은 후 "+ beforePoint +"에서 "  +afterMember.getPoint() +"로 변경되었습니다.");
		} else {
			log.info("잔여 포인트가 없어 명령을 수행하지 못하였습니다.");
		}
	}
}
