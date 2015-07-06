package org.kosta.madfortaste.user.dao;


import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public void grantPointToMember() {
		String memberId = "java1";
		memberDao.upPoint(memberId, 1000);
	}
	
	@Test
	public void grantExpToMember() {
		String memberId = "java1";
		memberDao.upExp(memberId, 500);
	}
	
	@Test
	public void updateMemberToAdmin() {
		memberDao.upExp("admin", 10000000);
	}
	
	@Test
	public void testInsertDailyCheckTime() {
		String id = "member";
		memberDao.insertDailyCheckTime(id);
	}

	@Test
	public void testGetDailyCheckedMember() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		Date date2 = new Date(System.currentTimeMillis()+60*60*24*1000);
		String today = format.format(date1);
		String tomorrow = format.format(date2);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "member");
		map.put("today", today);
		map.put("tomorrow", tomorrow);
		memberDao.GetDailyCheckedMember(map);
	}
	
	@Test
	public void testUpdateDailyCheck() {
		String id = "member";
		memberDao.updateDailyCheck(id);
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
		Member member = new Member("member", "1234", "정현승", "경기도", "성남시 분당구", "서현동", "우리집", "male", "1989-02-04", "01089909923");
		member.setProfileImg("default.jpg");
		Member insertedMember = memberDao.insertMember(member);
		assertThat(insertedMember.getId(), is(member.getId()));
	}

	@Test
	public void testSelectMemberById() {
		String id = "member";
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
		page.setPageSize(1);
		page.setCurrentPage(2);
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
	
	@Test
	public void testSelectMemberListOrderByExp() {
		int totalCount = memberDao.selectTotalCount();
		Page page = new Page(totalCount);
		List<Member> memberList = memberDao.selectMemberListOrderByExp(page);
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
