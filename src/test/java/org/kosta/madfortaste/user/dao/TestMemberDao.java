package org.kosta.madfortaste.user.dao;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/root-context.xml")
public class TestMemberDao {
	
	@Resource
	MemberDao memberDao;
	
	@Test
	public void setUp() {
		assertNotNull(memberDao);
	}

	@Test
	public void test() {
	}

}
