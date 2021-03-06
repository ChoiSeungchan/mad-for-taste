package org.kosta.madfortaste.taste.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
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
		sqlSessionTemplate.update("upHits", articleNo);
	}

	@Override
	public void upGood(int articleNo) {
		sqlSessionTemplate.update("upGood", articleNo);
	}
	
	@Override
	public void upBad(int articleNo) {
		sqlSessionTemplate.update("upBad", articleNo);
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

}
