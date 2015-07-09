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
	public void blindArticle(ArticleReport report) {
		String boardName = report.getBoardName();
		int articleNo = report.getArticleNo();
		if(boardName!=null && articleNo>0) {
			if(boardName.equals("TASTEBOARD")) {
				tasteBoardDao.deleteArticle(articleNo);
			} else if (boardName.equals("QNA")) {
			}
			reportDao.deleteSameArticleReports(boardName, articleNo);
		}
		
	}

}
