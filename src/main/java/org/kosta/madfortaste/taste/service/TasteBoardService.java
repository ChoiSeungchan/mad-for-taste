package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.MostSearched;

public interface TasteBoardService {
	
	public Article insertArticle(Article article, Map<String, String> map);

	public void updateArticle(Article article);

	public void deleteArticle(int articleNo);

	public Article getArticleByNo(int articleNo);

	public int getTotalCount();

	public int getDynamicTotalCount(Map<String, String> map);

	public List<Article> getArticles(Page page);

	public List<Article> getArticlesByLocation(Page page, String location);

	public List<Article> getArticlesByWriter(Page page, String writer);

	public void upHits(int articleNo, Cookie cookie, HttpServletResponse res);

	public boolean upGood(int articleNo, String id, int resNo);

	public boolean upBad(int articleNo, String id, int resNo);

	public List<Article> getArticlesOrderByHits(Page page);

	public List<Article> getArticlesOredrByRank(Page page);

	public List<Article> selectBoardByResNo(Map<String, String> map);

	public int selectTotalCntBoardByResNo(String string);

	public List<Article> selectByWriter(String string);

	public List<Article> selectByTitle(String string);

	public List<Article> selectByWriterApplicationPaging(Map<String, Object> map);

	public List<Article> selectByTitleApplicationPaging(Map<String, Object> map);

	public List<String> selectRestaurantByWriter(String string);

	public List<String> selectRestaurantByTitle(String string);

	public void insertSearchValue(String string);

	public void updateSearchValue(String string);

	public String selectSearchValue(String string);

	public List<MostSearched> selectSearchValRank();

}
