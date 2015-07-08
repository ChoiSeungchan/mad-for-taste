package org.kosta.madfortaste.help.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.ArticleReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestReportDao {

	@Autowired
	private ReportDao reportDao;
	
	@Before
	public void setUp() {
		assertNotNull(reportDao);
	}
	
	@Test
	public void testGetArticleReportTotalCount(){
		int count = reportDao.getArticleReportTotalCount();
		System.out.println(count);
	}
	
	@Test
	public void testInsertArticleReport() {
		ArticleReport report= new ArticleReport("TASTEBOARD", 1, "member", "광고");
		reportDao.insertArticleReport(report);
	}
	
	@Test
	public void testSelectArticleReport() {
		ArticleReport report = reportDao.selectArticleReport(1);
		System.out.println(report);
	}
	
	@Test
	public void testSelectArticleReportsByPaging() {
		Page page = new Page(reportDao.getArticleReportTotalCount());
		List<ArticleReport> list = reportDao.selectArticleReportsByPaging(page);
		for (ArticleReport articleReport : list) {
			System.out.println(articleReport);
		}
	}
	
	@Transactional
	@Test
	public void testDeleteArticleReport() {
		int i = reportDao.deleteArticleReport(1);
		System.out.println(i);
	}
	
}
