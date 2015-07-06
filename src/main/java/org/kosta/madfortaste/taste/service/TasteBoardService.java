package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;

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

	public boolean upGood(int articleNo, String id);

	public boolean upBad(int articleNo, String id);

	public List<Article> getArticlesOrderByHits(Page page);

	public List<Article> getArticlesOredrByRank(Page page);

}
