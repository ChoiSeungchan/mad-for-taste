package org.kosta.madfortaste.help.dao;

import static org.junit.Assert.assertNotNull;

import org.aspectj.weaver.NewParentTypeMunger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestNoticeDao {
	
	
	@Autowired
	private NoticeDao noticeDAO;

	@Before
	public void setUp() {
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void getContents(){
		Notice notice = noticeDAO.getContents("4");
		System.out.println(notice);
	}
	
	/*@Test
	public void testInsertNotice() {
		int result = noticeDAO.insert(new Notice("java", "test", "test"));
		System.out.println(result);
	}*/
	
//	@Test
//	public void update(){
//		noticeDAO.update(new Notice("4", null, "업데이트", "업데이트테스트", 0, null));
//	}
	
//	@Test
//	public void delete(){
//		noticeDAO.delete("4");
//	}
//	
	
//	@Test public void list(){
//		noticeDAO.loadNoticeList(new Page(1,10,5,1234));
//	}
//	
	
}
