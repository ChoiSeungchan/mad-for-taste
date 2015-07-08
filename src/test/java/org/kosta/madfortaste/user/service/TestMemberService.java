package org.kosta.madfortaste.user.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.kosta.madfortaste.taste.service.RestaurantService;
import org.kosta.madfortaste.user.domain.LevelTable;
import org.kosta.madfortaste.user.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMemberService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MemberService memberService;
	
	@Resource
	private RestaurantService restaurantService;
	
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
	/**
	 * 회원의 주소로 근처에 있는 맛집 서비스를 제공
	 */
	@Test
	public void testMemberAddressNearbyRestaurant(){
		Member member=null;
		List<Restaurant> list=null;
		member=memberService.selectMemberById("member");
		assertNotNull(member); //Success Case: null이 아니면 통과
		String city=member.getCity();
		String sigungu="  ";
		sigungu+=member.getSigungu();
		String eupmyeondong="  ";
		eupmyeondong+=member.getEupmyeondong();
		Map<String, String> map=new HashMap<String, String>();
		map.put("si", city);	//파라미터 넘어올 회원의 주소 정보
		map.put("gu", sigungu);
		map.put("dong", eupmyeondong);
		Page page=new Page(restaurantService.selectRestaurantTotalCnt(map));
		page.setPageSize(3); //페이징 테스트
		page.setPageGroupSize(3);
		page.setCurrentPage(7);
		System.out.println(page);
		page.preview(); //페이지 처리 미리보기
		String beginRow=Integer.toString(page.getBeginRow());
		String endRow=Integer.toString(page.getEndRow());
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
		list=restaurantService.selectRestaurantNearByAddress(map);
		assertNotNull(list); //Success Case: null 이 아니면 통과
		System.out.println(list);
	}
}
