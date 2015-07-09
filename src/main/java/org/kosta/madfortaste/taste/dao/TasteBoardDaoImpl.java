package org.kosta.madfortaste.taste.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TasteBoardDaoImpl implements TasteBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("getTotalCount");
	}

	@Override
	public int getDynamicTotalCount(Map<String,String> map) {
		return sqlSessionTemplate.selectOne("getDynamicTotalCount", map);
	}

	@Override
	public Article insertArticle(Article article) {
		sqlSessionTemplate.insert("insertArticle", article);
		return article;
	}

	@Override
	public void updateArticle(Article article) {
		sqlSessionTemplate.update("updateArticle", article);
	}

	@Override
	public void deleteArticle(int articleNo) {
		sqlSessionTemplate.delete("deleteArticle", articleNo);
	}
	
	@Override
	public Article getArticleByNo(int articleNo) {
		return sqlSessionTemplate.selectOne("getArticleByNo", articleNo);
	}

	@Override
	public List<Article> getArticles(Page page) {
		return sqlSessionTemplate.selectList("getArticles",page);
	}

	@Override
	public List<Article> getArticlesByLocation(Page page, String location) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("location", location);
		return sqlSessionTemplate.selectList("getArticlesByLocation", map);
	}

	@Override
	public List<Article> getArticlesByWriter(Page page, String writer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("writer", writer);
		return sqlSessionTemplate.selectList("getArticlesByWriter", map);
	}

	@Override
	public void upHits(int articleNo) {
		sqlSessionTemplate.update("tasteBoard.upHits", articleNo);
	}

	@Override
	public void upGood(int articleNo) {
		sqlSessionTemplate.update("tasteBoard.upGood", articleNo);
	}
	
	@Override
	public void upBad(int articleNo) {
		sqlSessionTemplate.update("tasteBoard.upBad", articleNo);
	}

	@Override
	public List<Article> getArticlesOrderByHits(Page page) {
		return sqlSessionTemplate.selectList("getArticlesOrderByHits", page);
	}

	@Override
	public List<Article> getArticlesOredrByRank(Page page) {
		return sqlSessionTemplate.selectList("testGetArticlesOredrByRank", page);
	}

	@Override
	public void insertVote(int articleNo, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articleNo", articleNo);
		map.put("id", id);
		sqlSessionTemplate.insert("insertVote", map);
		
	}

	@Override
	public List<String> selectVotedList(int articleNo) {
		return sqlSessionTemplate.selectList("selectVotedList", articleNo);
	}

	@Override
	public List<Article> selectBoardByAddress(Restaurant restaurant) {
		return sqlSessionTemplate.selectList("selectBoardByAddress",restaurant);
	}

	@Override
	public List<Article> selectBoardByResNo(Map<String, String> map) {
		return sqlSessionTemplate.selectList("selectBoardByResNo",map);
	}

	@Override
	public int selectTotalCntBoardByResNo(String string) {
		return sqlSessionTemplate.selectOne("selectTotalCntBoardByResNo",string);
	}

	@Override
	public List<Article> selectByWriter(String string) {
		return sqlSessionTemplate.selectList("selectByWriter",string);
	}

	@Override
	public List<Article> selectByTitle(String string) {
		return sqlSessionTemplate.selectList("selectByTitle",string);
	}

	@Override
	public List<Article> selectByWriterApplicationPaging(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("selectByWriterApplicationPaging",map);
	}

	@Override
	public List<Article> selectByTitleApplicationPaging(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("selectByTitleApplicationPaging",map);
	}

}
