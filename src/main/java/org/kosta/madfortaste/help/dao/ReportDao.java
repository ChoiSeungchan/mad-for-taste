package org.kosta.madfortaste.help.dao;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.ArticleReport;

public interface ReportDao {

	public int getArticleReportTotalCount();

	public void insertArticleReport(ArticleReport report);

	public ArticleReport selectArticleReport(int reportNo);

	public List<ArticleReport> selectArticleReportsByPaging(Page page);

	public int deleteArticleReport(int reportNo);

}
