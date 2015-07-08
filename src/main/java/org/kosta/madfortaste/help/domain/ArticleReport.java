package org.kosta.madfortaste.help.domain;

import java.util.Date;

public class ArticleReport {

	private int reportNo;
	private String boardName;
	private int articleNo;
	private String accuserId;
	private String reportReason;
	private Date reportDate;
	private String calDate;

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
		this.setCalDate();
	}
	
	public String getCalDate() {
		return calDate;
	}

	public void setCalDate() {
		long currentD = System.currentTimeMillis();
		long createD = reportDate.getTime();
		long resultS = ((currentD - createD) / 1000);
		String result = null;

		if (resultS >= 60 * 60 * 24 * 365) {
			result = resultS / (60 * 60 * 24 * 365) + "년 전";
		} else if (resultS >= 60 * 60 * 24 * 30) {
			result = resultS / (60 * 60 * 24 * 30) + "개월 전";
		} else if (resultS >= 60 * 60 * 24) {
			result = resultS / (60 * 60 * 24) + "일 전";
		} else if (resultS >= 60 * 60) {
			result = resultS / (60 * 60) + "시간 전";
		} else if (resultS >= 60) {
			result = resultS / (60) + "분 전";
		} else {
			result = resultS + "초 전";
		}
		this.calDate = result;
	}

	@Override
	public String toString() {
		return "ArticleReport [reportNo=" + reportNo + ", boardName="
				+ boardName + ", articleNo=" + articleNo + ", accuserId="
				+ accuserId + ", reportReason=" + reportReason + ", reportDate="
				+ reportDate + "]";
	}

}
