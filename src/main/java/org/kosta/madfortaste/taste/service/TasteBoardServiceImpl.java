package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.dao.TasteBoardDao;
import org.kosta.madfortaste.taste.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasteBoardServiceImpl implements TasteBoardService {

	@Autowired
	private TasteBoardDao tasteBoardDao;
	
	@Override
	public Article insertArticle(Article article) {
		return tasteBoardDao.insertArticle(article);
	}

	@Override
	public void updateArticle(Article article) {
		tasteBoardDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleNo) {
		tasteBoardDao.deleteArticle(articleNo);
	}

	@Override
	public Article getArticleByNo(int articleNo) {
		return tasteBoardDao.getArticleByNo(articleNo);
	}

	@Override
	public int getTotalCount() {
		return tasteBoardDao.getTotalCount();
	}

	@Override
	public int getDynamicTotalCount(Map<String, String> map) {
		return tasteBoardDao.getDynamicTotalCount(map);
	}

	@Override
	public List<Article> getArticles(Page page) {
		return tasteBoardDao.getArticles(page);
	}

	@Override
	public List<Article> getArticlesByLocation(Page page, String location) {
		return tasteBoardDao.getArticlesByLocation(page, location);
	}

	@Override
	public List<Article> getArticlesByWriter(Page page, String writer) {
		return tasteBoardDao.getArticlesByWriter(page, writer);
	}

	@Override
	public void upHits(int articleNo) {
		tasteBoardDao.upHits(articleNo);
	}

	@Override
	public void upGood(int articleNo) {
		tasteBoardDao.upGood(articleNo);
	}

	@Override
	public void upBad(int articleNo) {
		tasteBoardDao.upBad(articleNo);
	}

	@Override
	public List<Article> getArticlesOrderByHits(Page page) {
		return tasteBoardDao.getArticlesOrderByHits(page);
	}

	@Override
	public List<Article> getArticlesOredrByRank(Page page) {
		return tasteBoardDao.getArticlesOredrByRank(page);
	}

}
