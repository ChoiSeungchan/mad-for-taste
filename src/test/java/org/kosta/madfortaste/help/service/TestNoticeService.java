package org.kosta.madfortaste.help.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.dao.NoticeDao;
import org.kosta.madfortaste.help.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestNoticeService {
	
	@Autowired
	private NoticeService noticeService;

	@Before
	public void setUp() {
		assertNotNull(noticeService);
	}
	
    @Test
    public void loadNoticeList() {
		String pageNo = "1";
	   noticeService.loadNoticeList(pageNo);
	    
	}
    @Test
	public void getContents(){
		Notice notice = noticeService.getContents("1");
		System.out.println(notice);
	}
    
    @Test
	public void insert(){
		noticeService.insert(new Notice("java", "test1", "test1"));
	}
    
    @Test
	public void update(){
    	noticeService.update(new Notice("1", "java", "test1", "testupdate", 0, null));
    }
//	public void delete(String no);

}
