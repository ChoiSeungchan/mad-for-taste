package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;

public interface TasteBoardDao {

	public Article insertArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticle(int articleNo);

	public Article getArticleByNo(int articleNo);

	public int getTotalCount();

	public int getDynamicTotalCount(Map<String, String> map);

	public List<Article> getArticles(Page page);

	public List<Article> getArticlesByLocation(Page page, String location);

	public List<Article> getArticlesByWriter(Page page, String writer);

	public void upHits(int articleNo);

	public void upGood(int articleNo);

	public void upBad(int articleNo);

	public List<Article> getArticlesOrderByHits(Page page);

	public List<Article> getArticlesOredrByRank(Page page);


}
