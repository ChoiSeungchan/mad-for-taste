package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.kosta.madfortaste.common.config.ExpConfig;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.dao.ReplyDao;
import org.kosta.madfortaste.taste.dao.RestaurantDao;
import org.kosta.madfortaste.taste.dao.TasteBoardDao;
import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.kosta.madfortaste.user.dao.MemberDao;
import org.kosta.madfortaste.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TasteBoardServiceImpl implements TasteBoardService {

	@Autowired
	private TasteBoardDao tasteBoardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public Article insertArticle(Article article,Map<String, String> map) {
		memberDao.upExp(article.getWriter(), 30);
		String resNo=restaurantDao.SelectRestaurantByAddress(map);
		if(resNo!=null)
			article.setResNo(resNo);
		else{
			Restaurant restaurant=new Restaurant(map.get("name"), map.get("si"), map.get("gu"), map.get("dong"));
			restaurantDao.insertRestaurant(restaurant);
			article.setResNo(restaurant.getResNo());
		}
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
	public void upHits(int articleNo, Cookie cookie, HttpServletResponse res) {
		String getArticleLog = null;
		if (cookie!=null) {
			getArticleLog = cookie.getValue();
			if(getArticleLog.contains("|"+articleNo+"|")==false) {
				tasteBoardDao.upHits(articleNo);
				getArticleLog += "|" + articleNo + "|";
				cookie.setValue(getArticleLog);
				cookie.setMaxAge(60*60*24);
			}
			res.addCookie(cookie);
		} else {
			getArticleLog = "|"+articleNo+"|";
			cookie = new Cookie("getArticleLog", getArticleLog);
			cookie.setMaxAge(60*60*24);
			res.addCookie(cookie);
		}
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
//			restaurantDao.upGood(resNo);
			tasteBoardDao.insertVote(articleNo, id);
			memberDao.upExp(id.trim(), ExpConfig.GOOD_BAD);
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
//			restaurantDao.upBad(resNo);
			tasteBoardDao.insertVote(articleNo, id);
			memberDao.upExp(id.trim(), ExpConfig.GOOD_BAD);
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
