package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.MostSearched;
import org.kosta.madfortaste.taste.domain.Restaurant;

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
	
	public void insertVote(int articleNo, String id);
	
	public List<String> selectVotedList(int articleNo);

	public List<Article> selectBoardByAddress(Restaurant restaurant);

	public List<Article> selectBoardByResNo(Map<String, String> map);

	public int selectTotalCntBoardByResNo(String string);

	public List<Article> selectByWriter(String string);

	public List<Article> selectByTitle(String string);

	public List<Article> selectByWriterApplicationPaging(Map<String, Object> map);

	public List<Article> selectByTitleApplicationPaging(Map<String, Object> map);

	public List<String> selectRestaurantByWriter(String string);

	public List<String> selectRestaurantByTitle(String string);

	public int insertSearchValue(String string);

	public void updateSearchValue(String string);

	public String selectSearchValue(String string);

	public List<MostSearched> selectSearchValRank();

}
