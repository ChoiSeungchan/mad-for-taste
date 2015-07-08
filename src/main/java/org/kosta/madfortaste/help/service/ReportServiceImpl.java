package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.dao.ReportDao;
import org.kosta.madfortaste.help.domain.ArticleReport;
import org.kosta.madfortaste.taste.dao.TasteBoardDao;
import org.kosta.madfortaste.taste.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDao reportDao;

	@Autowired
	private TasteBoardDao tasteBoardDao;
	
	@Override
	public int getArticleReportTotalCount() {
		return reportDao.getArticleReportTotalCount();
	}

	@Override
	public void insertArticleReport(ArticleReport report) {
		reportDao.insertArticleReport(report);
	}

	@Override
	public ArticleReport selectArticleReport(int reportNo) {
		return reportDao.selectArticleReport(reportNo);
	}

	@Override
	public List<ArticleReport> selectArticleReportsByPaging(Page page) {
		return reportDao.selectArticleReportsByPaging(page);
	}

	@Override
	public int deleteArticleReport(int reportNo) {
		return reportDao.deleteArticleReport(reportNo);
	}
	
	@Override
	public void blindArticle(String boardName, int articleNo) {
		if(boardName!=null && articleNo>0) {
			if(boardName.equals("TASTEBOARD")) {
				Article article = tasteBoardDao.getArticleByNo(articleNo);
				article.setTitle("관리자에 의해 블라인드 처리 된 게시물 입니다.");
				article.setContents("관리자에 의해 블라인드 처리 된 게시물 입니다.");
				tasteBoardDao.updateArticle(article);
				article = tasteBoardDao.getArticleByNo(articleNo);
				System.out.println(article);
			} else if (boardName.equals("QNA")) {
			}
		}
	}

}
