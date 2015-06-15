package org.kosta.madfortaste.help.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.help.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestNoticeDao {
	
	@Autowired
	private NoticeDao noticeDao;

	@Before
	public void setUp() {
		assertNotNull(noticeDao);
	}
	
	@Test
	public void testInsertNotice() {
	
	}
}
