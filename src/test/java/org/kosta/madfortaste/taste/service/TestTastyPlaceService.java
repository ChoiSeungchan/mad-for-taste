package org.kosta.madfortaste.taste.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.dao.TastyPlaceDao;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestTastyPlaceService {
	@Autowired
	private TastyPlaceDao tastyPlaceDao;
	
	@Transactional
	@Test
	public void testInsertTastyPlace() {
		TastyPlace tastyPlace=new TastyPlace(null, "홍콩반점", "경기도 일산시", "1566-7777", null,"java");
		assertEquals(1, tastyPlaceDao.insertTastyPlace(tastyPlace));
	}
	
	@Transactional
	@Test
	public void testDeleteTastyPlace(){
		assertEquals(1, tastyPlaceDao.deleteTastyPlace("777"));
	}
}
