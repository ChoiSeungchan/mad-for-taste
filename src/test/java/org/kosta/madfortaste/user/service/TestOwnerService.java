package org.kosta.madfortaste.user.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.user.dao.OwnerDao;
import org.kosta.madfortaste.user.domain.Owner;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestOwnerService {
	@Autowired
	private OwnerDao ownerDao;
	@Transactional
	@Test
	public void insertOwner() {
		Owner owner=new Owner("java", "1234", "강동원", "01033832281", "tgoo@yahoo.com",null,null);
		assertThat(owner, is(ownerDao.insertOwner(owner)));
	}

}
