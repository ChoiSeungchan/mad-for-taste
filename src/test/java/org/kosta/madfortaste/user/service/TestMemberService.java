package org.kosta.madfortaste.user.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMemberService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MemberService memberService;
	
	@Before
	public void setUp() {
		assertNotNull(memberService);
	}
	
	@Resource
	LevelTable levelTable;

	@Test
	public void testSelectMemberById() {
		String id = "hs9923";
		Member member = memberService.selectMemberById(id);
		assertThat(member.getId(), is(id));
		log.info(member.toString());
	}

	
	@Test
	public void testSelectTotalCount(){
		int totalCount = memberService.selectTotalCount();
		log.info("MEMBER 테이블에 있는 데이터의 갯수는 "+totalCount + "개 입니다");
	}
	
	@Test
	public void testSelectMemberListOrderByExp() {
		int totalCount = memberService.selectTotalCount();
		List<Member> memberList = memberService.selectMemberListOrderByExp(1);
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
