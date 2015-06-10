package org.kosta.madfortaste.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import javax.inject.Inject;

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
		Owner owner=new Owner("java", "1234", "강동원", "01033832281", "tgoo@yahoo.com",null,null);
		assertThat(owner, is(ownerDao.insertOwner(owner)));
		TastyPlace tastyPlace=new TastyPlace(null, "홍콩반점", "경기도 일산시", "1566-7777", null,"java");
		assertEquals(1, tastyPlaceDao.insertTastyPlace(tastyPlace));
	
	}
}
