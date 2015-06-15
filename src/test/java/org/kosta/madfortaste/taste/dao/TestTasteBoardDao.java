package org.kosta.madfortaste.taste.dao;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestTasteBoardDao {

	@Autowired
	private TasteBoardDao dao;
	
	@Before
	public void setUp() {
		assertNotNull(dao);
	}
	
	@Test
	public void testInsertArticle() {
		Article article = dao.insertArticle(new Article("서울", "hs9923", "testTitle", "testContents", null));
		System.out.println(article);
	}
	
	@Test
	public void testGetTotalCount() {
		int totalCount = dao.getTotalCount();
		System.out.println(totalCount);
	}
	
	@Test
	public void testGetArticleById() {
		Article article = dao.getArticleById(1);
		System.out.println(article);
	}
	
	@Test
	public void testGetArticles() {
		Page page = new Page(dao.getTotalCount());
		List<Article> articles = dao.getArticles(page);
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	
	@Test
	public void testGetArticlesByLocation() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("location", "서2울");
		System.out.println(dao.getDynamicTotalCount(map));
//		Page page = new Page(dao.getDynamicTotalCount(String ));
//		String location = "서울";
//		List<Article> articles = dao.getArticlesByLocation(page, location);
//		for (Article article : articles) {
//			System.out.println(article);
//		}
	}
//	@Test
//	public void testGetArticlesByWriter() {
//		Page page = new Page(dao.getTotalCount());
//		List<Article> articles = dao.getArticles(page);
//		for (Article article : articles) {
//			System.out.println(article);
//		}
//	}
//	@Test
//	public void testGetArticlesOredrByHits() {
//		Page page = new Page(dao.getTotalCount());
//		List<Article> articles = dao.getArticles(page);
//		for (Article article : articles) {
//			System.out.println(article);
//		}
//	}
//	@Test
//	public void testGetArticlesOredrByRank() {
//		Page page = new Page(dao.getTotalCount());
//		List<Article> articles = dao.getArticles(page);
//		for (Article article : articles) {
//			System.out.println(article);
//		}
//	}

}
