package org.kosta.madfortaste.taste.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.Restaurant;
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
}
