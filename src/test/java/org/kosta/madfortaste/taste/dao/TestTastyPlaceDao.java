package org.kosta.madfortaste.taste.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.domain.TastyPlace;
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
}
