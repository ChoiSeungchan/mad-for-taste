package org.kosta.madfortaste.help.domain;

import java.util.Date;

public class ArticleReport {

	private int reportNo;
	private String boardName;
	private int articleNo;
	private String accuserId;
	private String reportReason;
	private Date reportDate;

	public ArticleReport() {
		super();
	}

	public ArticleReport(String boardName, int articleNo, String accuserId,
			String reportReason) {
		super();
		this.boardName = boardName;
		this.articleNo = articleNo;
		this.accuserId = accuserId;
		this.reportReason = reportReason;
	}

	public ArticleReport(int reportNo, String boardName, int articleNo,
			String accuserId, String reportReason, Date reportDate) {
		super();
		this.reportNo = reportNo;
		this.boardName = boardName;
		this.articleNo = articleNo;
		this.accuserId = accuserId;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getAccuserId() {
		return accuserId;
	}

	public void setAccuserId(String accuserId) {
		this.accuserId = accuserId;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public String toString() {
		return "ArticleReport [reportNo=" + reportNo + ", boardName="
				+ boardName + ", articleNo=" + articleNo + ", accuserId="
				+ accuserId + ", reportReason=" + reportReason + ", reportDate="
				+ reportDate + "]";
	}

}
