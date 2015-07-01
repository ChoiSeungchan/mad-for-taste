package org.kosta.madfortaste.taste.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceBoard;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestTastyPlaceDao {
	@Autowired
	private TastyPlaceDao tastyPlaceDao;
	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
	
	@Transactional
	@Test
	public void testInsertTastyPlace() {
		TastyPlace tastyPlace=new TastyPlace("3235325", "홍콩반점", "경기도 일산시", "1566-7777", null,"owner1234");
		assertEquals(1, tastyPlaceDao.insertTastyPlace(tastyPlace));
	}
	@Test
	public void testSelectTastyPlaceById(){
		TastyPlace tastyPlace=null;
		tastyPlace=tastyPlaceDao.selectTastyPlaceById("7777777");
		assertNotNull(tastyPlace);
	}
	
	@Transactional
	@Test
	public void testDeleteTastyPlace(){
		assertEquals(1, tastyPlaceDao.deleteTastyPlace("777"));
	}
	
	@Transactional
	@Test
	public void testUpdateTastyPlace(){
		assertEquals(1, tastyPlaceDao.updateTastyPlace(new TastyPlace("777", "냠냠냠", "호호호", "555", null, null)));
	}
	
	@Transactional
	@Test
	public void testInsertTastyPlaceMark(){
		assertEquals(1,	tastyPlaceDao.insertTastyPlaceMark(new TastyPlaceMark("777", "member", "3")));
	}
	
	@Test
	public void testSelectTastyPlaceMarkByDoublePk(){
		assertEquals(0,	tastyPlaceDao.selectTastyPlaceMarkByDoublePk(new TastyPlaceMark("777", "member", "3")));
	}
	
	@Test
	public void testSelectTastyPlaceMarkTotalPrice(){
		Map<String, String> map=null;
		map=tastyPlaceDao.selectTastyPlaceMarkTotalPrice("777");
		assertNotNull(map);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge20(){
		String str=null;
		str=tastyPlaceDao.selectTastyPlaceMarkAge20("777");
		assertNotNull(str);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge30(){
		String str=null;
		str=tastyPlaceDao.selectTastyPlaceMarkAge30("777");
		assertNotNull(str);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge40(){
		String str=null;
		str=tastyPlaceDao.selectTastyPlaceMarkAge40("777");
		assertNotNull(str);
	}
	@Transactional
	@Test
	public void testInsertTastyPlaceReplyMember(){
		assertEquals(1, tastyPlaceDao.insertTastyPlaceReplyMember(new TastyPlaceBoard(null, "777", null, "안녕하세요", null, null, "member")));
	}
	@Transactional
	@Test
	public void testInsertTastyPlaceReplyOwner(){
		assertEquals(1, tastyPlaceDao.insertTastyPlaceReplyOwner(new TastyPlaceBoard(null, "777", null, "안녕하세요", null, null, "owner1234")));
	}
	
	
	@Test
	public void testSelectTastyPlaceReplyMember(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("cnt", "1");map.put("brno", "777");
		assertNotNull((tastyPlaceDao.selectTastyPlaceReplyMember(map)));
	}
	
	@Test
	public void testSelectTastyPlaceReplyOwner(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("cnt", "1");map.put("brno", "777");
		assertNotNull((tastyPlaceDao.selectTastyPlaceReplyOwner(map)));
	}
	
	/**
	 * 레스토랑 등록~
	 */
	@Test
	public void testInsertRestaurant(){
		Restaurant restaurant=new Restaurant("빡촌치킨", "전라도", "포항시", "분당구", "서현동");
		log.info(restaurant.getResNo());
		tastyPlaceDao.insertRestaurant(restaurant);
		assertNotNull(restaurant.getResNo()); //Success Case: null값이 올수 없다.
		log.info(restaurant.getResNo());
	}
	
	/**
	 * 레스토랑 검색~
	 */
	@Test
	public void testSelectRestaurantByAddrDo(){//도별검색
		List<String> restaurant=null;
		restaurant=tastyPlaceDao.selectRestaurantByAddrDo();
		assertNotNull(restaurant);//Success Case: null이 아니면 루프 돌면서 List값 출력
		for(String addrDo : restaurant)
			log.info(addrDo);
	}
	
	@Test
	public void testSelectRestaurantByAddrSi(){//시별검색
		List<String> restaurant=null;
		String addrDo="전라도";//웹에서 넘어올 해당 지역권 도의 값
		//  ↓ 셀레트 박스에서 선택한 addrDo에 해당되는 addrSi의 List 출력
		restaurant=tastyPlaceDao.selectRestaurantByAddrSi(addrDo);
		assertNotNull(restaurant);//Success Case: null이 아니면 루프 돌면서 List값 출력
		for(String addrSi : restaurant)
			log.info(addrSi);
	}
}
