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
	public Article getArticleById(int articleNo) {
		return sqlSessionTemplate.selectOne("getArticleById", articleNo);
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
}
