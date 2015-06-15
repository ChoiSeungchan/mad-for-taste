package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;

public interface TasteBoardDao {

	public Article insertArticle(Article article);

	public Article getArticleById(int articleNo);

	public int getTotalCount();

	public int getDynamicTotalCount(Map<String, String> map);

	public List<Article> getArticles(Page page);

	public List<Article> getArticlesByLocation(Page page, String location);


}
