package org.kosta.madfortaste.taste.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.dao.TastyPlaceDao;
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
public class TestTastyPlaceService {
	@Autowired
	private TastyPlaceService tastyPlaceService;
	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
	
	@Transactional
	@Test
	public void testInsertTastyPlace() {
		TastyPlace tastyPlace=new TastyPlace(null, "홍콩반점", "경기도 일산시", "1566-7777", null,"owner1234");
		assertEquals(1, tastyPlaceService.insertTastyPlace(tastyPlace));
	}
	
	@Transactional
	@Test
	public void testDeleteTastyPlace(){
		assertEquals(1, tastyPlaceService.deleteTastyPlace("777"));
	}
	
	@Transactional
	@Test
	public void testInsertTastyPlaceMark(){
		assertEquals(1,	tastyPlaceService.insertTastyPlaceMark(new TastyPlaceMark("777", "member", "3")));
	}
	
	@Test
	public void testSelectTastyPlaceMarkByDoublePk(){
		assertEquals(0,	tastyPlaceService.selectTastyPlaceMarkByDoublePk(new TastyPlaceMark("777", "member", "3")));
	}
	@Test
	public void testSelectTastyPlaceMarkTotalPrice(){
		Map<String, String> map=null;
		map=tastyPlaceService.selectTastyPlaceMarkTotalPrice("777");
		assertNotNull(map);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge20(){
		String str=null;
		str=tastyPlaceService.selectTastyPlaceMarkAge20("777");
		assertNotNull(str);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge30(){
		String str=null;
		str=tastyPlaceService.selectTastyPlaceMarkAge30("777");
		assertNotNull(str);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge40(){
		String str=null;
		str=tastyPlaceService.selectTastyPlaceMarkAge40("777");
		assertNotNull(str);
	}
	@Transactional
	@Test
	public void testInsertTastyPlaceReplyMember(){
		assertEquals(1, tastyPlaceService.insertTastyPlaceReplyMember(new TastyPlaceBoard(null, "777", null, "안녕하세요", null, null, "member")));
	}
	@Transactional
	@Test
	public void testInsertTastyPlaceReplyOwner(){
		assertEquals(1, tastyPlaceService.insertTastyPlaceReplyOwner(new TastyPlaceBoard(null, "777", null, "안녕하세요", null, null, "owner1234")));
	}
}
