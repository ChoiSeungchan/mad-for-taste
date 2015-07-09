package org.kosta.madfortaste.help.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.ArticleReport;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl implements ReportDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getArticleReportTotalCount() {
		return sqlSessionTemplate.selectOne("report.getArticleReportTotalCount");
	}

	@Override
	public void insertArticleReport(ArticleReport report) {
		sqlSessionTemplate.insert("report.insertArticleReport", report);
	}

	@Override
	public ArticleReport selectArticleReport(int reportNo) {
		return sqlSessionTemplate.selectOne("report.selectArticleReport", reportNo);
	}

	@Override
	public List<ArticleReport> selectArticleReportsByPaging(Page page) {
		return sqlSessionTemplate.selectList("report.selectArticleReportsByPaging", page);
	}

	@Override
	public int deleteArticleReport(int reportNo) {
		return sqlSessionTemplate.delete("report.deleteArticleReport", reportNo);
	}

	@Override
	public void deleteSameArticleReports(String boardName, int articleNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardName", boardName);
		map.put("articleNo", articleNo);
		sqlSessionTemplate.delete("report.deleteSameArticleReports", map);
	}
	
	
}
