package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.dao.ReplyDao;
import org.kosta.madfortaste.taste.dao.TasteBoardDao;
import org.kosta.madfortaste.taste.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TasteBoardServiceImpl implements TasteBoardService {

	@Autowired
	private TasteBoardDao tasteBoardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
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
		Article article = tasteBoardDao.getArticleByNo(articleNo);
		article.setReply(replyDao.getReplyCount(articleNo));
		return article;
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
		List<Article> articles = tasteBoardDao.getArticles(page);
		for (Article article : articles) {
			article.setReply(replyDao.getReplyCount(article.getArticleNo()));
		}
		return articles;
	}

	@Override
	public List<Article> getArticlesByLocation(Page page, String location) {
		List<Article> articles = tasteBoardDao.getArticlesByLocation(page, location);
		for (Article article : articles) {
			article.setReply(replyDao.getReplyCount(article.getArticleNo()));
		}
		return articles;
	}

	@Override
	public List<Article> getArticlesByWriter(Page page, String writer) {
		List<Article> articles = tasteBoardDao.getArticlesByWriter(page, writer);
		for (Article article : articles) {
			article.setReply(replyDao.getReplyCount(article.getArticleNo()));
		}
		return articles;
	}

	@Override
	public void upHits(int articleNo) {
		tasteBoardDao.upHits(articleNo);
	}

	@Transactional
	@Override
	public boolean upGood(int articleNo, String id) {
		List<String> votedMemberList = tasteBoardDao.selectVotedList(articleNo);
		boolean isThisMemberVoted = false;;
		if (votedMemberList != null && votedMemberList.size() != 0) {
			for (String memberId : votedMemberList) {
				if (id.equals(memberId)) {
					isThisMemberVoted = true;
					break;
				}
			}
		}
		if(isThisMemberVoted==false) {
			tasteBoardDao.upGood(articleNo);
			tasteBoardDao.insertVote(articleNo, id);
		}
		return isThisMemberVoted;
	}
	
	@Transactional
	@Override
	public boolean upBad(int articleNo, String id) {
		List<String> votedMemberList = tasteBoardDao.selectVotedList(articleNo);
		boolean isThisMemberVoted = false;;
		if (votedMemberList != null && votedMemberList.size() != 0) {
			for (String memberId : votedMemberList) {
				if (id.equals(memberId)) {
					isThisMemberVoted = true;
					break;
				}
			}
		}
		if(isThisMemberVoted==false) {
			tasteBoardDao.upBad(articleNo);
			tasteBoardDao.insertVote(articleNo, id);
		}
		return isThisMemberVoted;
	}

	@Override
	public List<Article> getArticlesOrderByHits(Page page) {
		List<Article> articles = tasteBoardDao.getArticlesOrderByHits(page);
		for (Article article : articles) {
			article.setReply(replyDao.getReplyCount(article.getArticleNo()));
		}
		return articles;
	}

	@Override
	public List<Article> getArticlesOredrByRank(Page page) {
		List<Article> articles = tasteBoardDao.getArticlesOredrByRank(page);
		for (Article article : articles) {
			article.setReply(replyDao.getReplyCount(article.getArticleNo()));
		}
		return articles;
	}

}
