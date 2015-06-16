package org.kosta.madfortaste.taste.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
		String [] location = {"서울","경기","대전","대구","부산","울산"};
		for(int i = 0; i<30; i++) {
		Article article = dao.insertArticle(new Article(location[new Random().nextInt(6)], "hs9923", "testTitle", "testContents", null));
		System.out.println(article);
		}
	}
	
	@Test
	public void testUpdateArticle() {
		Article article = dao.getArticleByNo(1);
		System.out.println("before = " + article);
		article.setContents("updated Contents.");
		dao.updateArticle(article);
		System.out.println("after = " + article);
	}
	
	@Transactional
	@Test
	public void testDeleteArticle() {
		int articleNo = 1;
		dao.deleteArticle(articleNo);
		Article article = dao.getArticleByNo(articleNo);
		assertNull(article);
	}
	
	@Test
	public void testGetTotalCount() {
		int totalCount = dao.getTotalCount();
		System.out.println(totalCount);
	}
	
	@Test
	public void testGetArticleByNo() {
		Article article = dao.getArticleByNo(1);
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
		String location = "대전";
		Map<String, String> map = new HashMap<String, String>();
		map.put("location", location);
		Page page = new Page(dao.getDynamicTotalCount(map));
		List<Article> articles = dao.getArticlesByLocation(page, location);
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	
	@Test
	public void testGetArticlesByWriter() {
		String writer = "hs9923";
		Map<String, String> map = new HashMap<String, String>();
		map.put("writer", writer);
		Page page = new Page(dao.getDynamicTotalCount(map));
		List<Article> articles = dao.getArticlesByWriter(page, writer);
		for (Article article : articles) {
			System.out.println(article);
		}
	}

	@Test
	public void testGetArticlesOredrByHits() {
		Page page = new Page(dao.getTotalCount());
		List<Article> articles = dao.getArticlesOrderByHits(page);
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	
	@Test
	public void testGetArticlesOredrByRank() {
		Page page = new Page(dao.getTotalCount());
		List<Article> articles = dao.getArticlesOredrByRank(page);
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	
	@Test
	public void testUpHits() {
		int articleNo = 1;
		System.out.println(dao.getArticleByNo(articleNo));
		dao.upHits(articleNo);
		System.out.println(dao.getArticleByNo(articleNo));
	}
	
	@Test
	public void testUpGood(){
		int articleNo = 1;
		System.out.println(dao.getArticleByNo(articleNo));
		dao.upGood(articleNo);
		System.out.println(dao.getArticleByNo(articleNo));
	}
	
	@Test
	public void testUpBad() {
		int articleNo = 1;
		System.out.println(dao.getArticleByNo(articleNo));
		dao.upBad(articleNo);
		System.out.println(dao.getArticleByNo(articleNo));
	}
	
	/*
	 * 테이블에 있는 글중 하나를 무작위로 선정해 조회수, 좋아요, 싫어요를 무작위로 1 올린다. 
	 */
//	@Test
//	public void randomUpdate() {
//		for (int x = 0; x < 300; x++) {
//			int articleNo = new Random().nextInt(dao.getTotalCount());
//			int i = new Random().nextInt(3);
//			if (i == 0) {
//				dao.upHits(articleNo);
//			} else if (i == 1) {
//				dao.upGood(articleNo);
//			} else {
//				dao.upBad(articleNo);
//			}
//		}
//	}

}
