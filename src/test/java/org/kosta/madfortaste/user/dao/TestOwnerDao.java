package org.kosta.madfortaste.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.dao.TastyPlaceDao;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.user.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestOwnerDao {
	@Inject
	private OwnerDao ownerDao;
	@Autowired
	private TastyPlaceDao tastyPlaceDao;
	@Transactional
	@Test
	public void testInsertOwner() {
		Owner owner=new Owner("owner1234", "1234", "강동원", "01033832281", "tgoo@yahoo.com",null,null,"a.jpg");
		assertThat(owner, is(ownerDao.insertOwner(owner)));
		TastyPlace tastyPlace=new TastyPlace("8888888888", "홍콩반점", "경기도 일산시", "1566-7777", null,"owner1234");
		assertEquals(1, tastyPlaceDao.insertTastyPlace(tastyPlace));	
	}
	
	@Test
	public void testSelectOwner(){
		Owner owner=null;
		owner=ownerDao.selectOwnerById("owner1234");
		Assert.assertNotNull(owner);
	}
	@Transactional
	@Test
	public void testDeleteOwner(){
		assertEquals(1, ownerDao.deleteOwnerById("owner1234"));
	}
	
	@Transactional
	@Test
	public void testUpdateOwner(){
		Owner owner=new Owner("owner1234", "12341234", "테스트용", "5555", "3333", null, null, "s.gif");
		assertEquals(1, ownerDao.updateOwnerById(owner));
	}
}
