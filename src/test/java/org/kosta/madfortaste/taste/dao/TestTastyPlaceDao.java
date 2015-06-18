package org.kosta.madfortaste.taste.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceBoard;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;
import org.kosta.madfortaste.user.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestTastyPlaceDao {
	@Autowired
	private TastyPlaceDao tastyPlaceDao;
	@Transactional
	@Test
	public void testInsertTastyPlace() {
		TastyPlace tastyPlace=new TastyPlace("3235325", "홍콩반점", "경기도 일산시", "1566-7777", null,"kostajjang");
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
		assertEquals(1,	tastyPlaceDao.insertTastyPlaceMark(new TastyPlaceMark("777", "java1234", "3")));
	}
	
	@Test
	public void testSelectTastyPlaceMarkByDoublePk(){
		assertEquals(0,	tastyPlaceDao.selectTastyPlaceMarkByDoublePk(new TastyPlaceMark("777", "java1234", "3")));
	}
	
	@Test
	public void testSelectTastyPlaceMarkTotalPrice(){
		Map<String, String> map=null;
		map=tastyPlaceDao.selectTastyPlaceMarkTotalPrice();
		assertNotNull(map);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge20(){
		String str=null;
		str=tastyPlaceDao.selectTastyPlaceMarkAge20();
		assertNotNull(str);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge30(){
		String str=null;
		str=tastyPlaceDao.selectTastyPlaceMarkAge30();
		assertNotNull(str);
	}
	
	@Test
	public void testSelectTastyPlaceMarkAge40(){
		String str=null;
		str=tastyPlaceDao.selectTastyPlaceMarkAge40();
		assertNotNull(str);
	}
	@Transactional
	@Test
	public void testInsertTastyPlaceReplyMember(){
		assertEquals(1, tastyPlaceDao.insertTastyPlaceReplyMember(new TastyPlaceBoard(null, "777", null, "안녕하세요", null, null, "member1234")));
	}
	@Transactional
	@Test
	public void testInsertTastyPlaceReplyOwner(){
		assertEquals(1, tastyPlaceDao.insertTastyPlaceReplyOwner(new TastyPlaceBoard(null, "777", null, "안녕하세요", null, null, "owner1234")));
	}
	
	
	@Test
	public void testSelectTastyPlaceReplyMember(){
		List<TastyPlaceBoard> list=null;
		assertNotNull((tastyPlaceDao.selectTastyPlaceReplyMember("1")));
	}
	
	@Test
	public void testSelectTastyPlaceReplyOwner(){
		List<TastyPlaceBoard> list=null;
		assertNotNull(tastyPlaceDao.selectTastyPlaceReplyOwner("1"));
	}
}
