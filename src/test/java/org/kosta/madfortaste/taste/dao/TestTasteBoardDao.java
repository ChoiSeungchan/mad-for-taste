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
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestTasteBoardDao {

	@Autowired
	private TasteBoardDao dao;
	private Logger log=LoggerFactory.getLogger(getClass());
	
	@Before
	public void setUp() {
		assertNotNull(dao);
	}
	
	@Test
	public void testInsertArticle() {
		String [] location = {"서울","경기","대전","대구","부산","울산"};
		for(int i = 0; i<30; i++) {
		Article article = dao.insertArticle(new Article( "hs9923", "testTitle", "testContents"));
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
	
	@Test
	public void testInsertVote() {
		dao.insertVote(1, "member");
	}
	
	@Test
	public void testSelectVotedList() {
		List<String> list = dao.selectVotedList(1);
		for (String id : list) {
			System.out.println(id);
		}
	}
	
	/*
	 * 테이블에 있는 글중 하나를 무작위로 선정해 조회수, 좋아요, 싫어요를 무작위로 1 올린다. 
	 */
	@Test
	public void randomUpdate() {
		for (int x = 0; x < 300; x++) {
			int articleNo = new Random().nextInt(dao.getTotalCount());
			int i = new Random().nextInt(3);
			if (i == 0) {
				dao.upHits(articleNo);
			} else if (i == 1) {
				dao.upGood(articleNo);
			} else {
				dao.upBad(articleNo);
			}
		}
	}
	
	/**
	 * 주소와 가게이름으로 해당 게시글 리스트 검색
	 */
	@Test
	public void testSelectBoardByAddress(){
		List<Article> list=null;
		Map<String, String> map=new HashMap<String, String>();
		Restaurant restaurant=new Restaurant();
		restaurant.setCity("  서울특별시");
		restaurant.setSigungu("  강남구");
		restaurant.setEupmyeondong("  대치동");
		restaurant.setResName("파파이스");
		list=dao.selectBoardByAddress(restaurant);
		System.out.println(list);
	}
	/**
	 * ResNo 으로 해당 게시글 리스트 검색
	 */
	@Test
	public void testSelectBoardByResNo(){
		List<Article> list=null;
		Map<String, String> map=new HashMap<String, String>();
		Page page=new Page(dao.selectTotalCntBoardByResNo("60"));
		page.setPageGroupSize(3);
		page.setPageSize(3);
		page.setCurrentPage(4);
		map.put("resNo", "60");
		map.put("beginRow", Integer.toString(page.getBeginRow()));
		map.put("endRow", Integer.toString(page.getEndRow()));
		list=dao.selectBoardByResNo(map);
		assertNotNull(list); //Success Case: null이 아니면 통과
		System.out.println(list);
	}
	
	/**
	 * 메인게시판 검색 서비스
	 */
	@Test //작성자로 검색
	public void testSelectByWriter(){
		List<Article> list=null;
		list=dao.selectByWriter("YOU"); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		System.out.println(list);
	}
	
	@Test //제목으로 검색
	public void testSelectByTitle(){
		List<Article> list=null;
		list=dao.selectByTitle("우하하"); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		System.out.println(list);
	}
	
	@Test //작성자로 검색(페이징 적용)
	public void testSelectByWriterApplicationPaging(){
		List<Article> list=null;
		Map<String, Object> map=new HashMap<String, Object>();
		Page page=new Page(dao.selectByWriter("fuck").size());
		page.setPageGroupSize(3);
		page.setPageSize(3);
		page.setCurrentPage(1);
		map.put("name", "fuck");
		map.put("beginRow", page.getBeginRow());
		map.put("endRow", page.getEndRow());
		list=dao.selectByWriterApplicationPaging(map); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		log.info(Integer.toString(list.size())); //원하는 페이징 사이즈 출력확인
		System.out.println(list);
	}
	
	@Test //제목으로 검색(페이징 적용)
	public void testSelectByTitleApplicationPaging(){
		List<Article> list=null;
		Map<String, Object> map=new HashMap<String, Object>();
		Page page=new Page(dao.selectByTitle("fuck").size());
		page.setPageGroupSize(3);
		page.setPageSize(3);
		page.setCurrentPage(1);
		map.put("title", "ㅎㅎㅎ");
		map.put("beginRow", page.getBeginRow());
		map.put("endRow", page.getEndRow());
		list=dao.selectByTitleApplicationPaging(map); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		log.info(Integer.toString(list.size())); //원하는 페이징 사이즈 출력확인
		System.out.println(list);
	}
}
