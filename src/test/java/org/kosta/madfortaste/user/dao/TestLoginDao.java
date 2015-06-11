package org.kosta.madfortaste.user.dao;

import static org.junit.Assert.assertNotNull;

import java.security.acl.Owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestLoginDao {

private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	
	@Before
	public void setUp() {
		assertNotNull(loginDao);
	}
	
	@Transactional
	@Test
	public void testIsExistUser() {
		String userId = "hs9923";
		User user = loginDao.isExistUser(userId);
		log.info(user.toString());
	}
	
	@Test
	public void testGetMemberInfo() {
		String userId = "hs9923";
		Member member = loginDao.getMemberInfo(userId);
		System.out.println(member);
	}
	
	@Test
	public void testGetOwnerInfo() {
		String userId = "hs9923";
		Owner owner = loginDao.getOwnerInfo(userId);
		System.out.println(owner);
	}

}
