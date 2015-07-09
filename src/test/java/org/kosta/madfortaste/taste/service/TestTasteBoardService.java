package org.kosta.madfortaste.taste.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestTasteBoardService {
	@Autowired
	private TasteBoardService tasteBoardService;
	private Logger log=LoggerFactory.getLogger(getClass());
	
	@Test
	public void testInsertArticle() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "안동찜닭");
		map.put("si", "서울특별시");
		map.put("gu", "종로구");
		map.put("dong", "견지동");
		for (int i = 0; i < 30; i++) {
			tasteBoardService.insertArticle(
					new Article("hs9923", "서현동 병천순대", "test 게시글 입니다."), map);
		}
	}
	
	/**
	 * ResNo 으로 해당 게시글 리스트 검색
	 */
	@Test
	public void testSelectBoardByResNo(){
		List<Article> list=null;
		Map<String, String> map=new HashMap<String, String>();
		Page page=new Page(tasteBoardService.selectTotalCntBoardByResNo("60"));
		page.setPageGroupSize(3);
		page.setPageSize(3);
		page.setCurrentPage(4);
		map.put("resNo", "60");
		map.put("beginRow", Integer.toString(page.getBeginRow()));
		map.put("endRow", Integer.toString(page.getEndRow()));
		list=tasteBoardService.selectBoardByResNo(map);
		assertNotNull(list); //Success Case: null이 아니면 통과
		System.out.println(list);
	}
	
	/**
	 * 메인게시판 검색 서비스
	 */
	@Test //작성자로 검색
	public void testSelectByWriter(){
		List<Article> list=null;
		list=tasteBoardService.selectByWriter("YOU"); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		System.out.println(list);
	}
	
	@Test //제목으로 검색
	public void testSelectByTitle(){
		List<Article> list=null;
		list=tasteBoardService.selectByTitle("우하하"); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		System.out.println(list);
	}
	
	@Test //작성자로 검색(페이징 적용)
	public void testSelectByWriterApplicationPaging(){
		List<Article> list=null;
		Map<String, Object> map=new HashMap<String, Object>();
		Page page=new Page(tasteBoardService.selectByWriter("fuck").size());
		page.setPageGroupSize(3);
		page.setPageSize(3);
		page.setCurrentPage(1);
		map.put("name", "fuck");
		map.put("beginRow", page.getBeginRow());
		map.put("endRow", page.getEndRow());
		list=tasteBoardService.selectByWriterApplicationPaging(map); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		log.info(Integer.toString(list.size())); //원하는 페이징 사이즈 출력확인
		System.out.println(list);
	}
	
	@Test //제목으로 검색(페이징 적용)
	public void testSelectByTitleApplicationPaging(){
		List<Article> list=null;
		Map<String, Object> map=new HashMap<String, Object>();
		Page page=new Page(tasteBoardService.selectByTitle("fuck").size());
		page.setPageGroupSize(3);
		page.setPageSize(3);
		page.setCurrentPage(1);
		map.put("title", "fuck");
		map.put("beginRow", page.getBeginRow());
		map.put("endRow", page.getEndRow());
		list=tasteBoardService.selectByTitleApplicationPaging(map); //대소문자 구분가능
		assertNotNull(list); //Success Case: null 이 아니면 통과
		log.info(Integer.toString(list.size())); //원하는 페이징 사이즈 출력확인
		System.out.println(list);
	}
}
