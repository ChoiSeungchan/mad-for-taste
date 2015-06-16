package org.kosta.madfortaste.help.service;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.help.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestNoticeService {
	@Autowired
	private NoticeDao noticeDAO;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
