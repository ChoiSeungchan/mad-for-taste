package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.ArticleReport;

public interface ReportService {

	public int getArticleReportTotalCount();

	public void insertArticleReport(ArticleReport report);

	public ArticleReport selectArticleReport(int reportNo);

	public List<ArticleReport> selectArticleReportsByPaging(Page page);

	public int deleteArticleReport(int reportNo);

	public void blindArticle(ArticleReport report);
}
