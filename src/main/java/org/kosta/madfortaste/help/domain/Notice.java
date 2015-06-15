package org.kosta.madfortaste.help.domain;

public class Notice {
	private String articleNo;
	private String writer;
	private String title;
	private String content;
	private int viewCount;
	private String regDate;
	public Notice(String articleNo, String writer, String title,
			String content, int viewCount, String regDate) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.regDate = regDate;
	}
	public Notice() {
		super();
	}
	public String getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getregDate() {
		return regDate;
	}
	public void setregDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Notice [articleNo=" + articleNo + ", writer=" + writer
				+ ", title=" + title + ", content=" + content + ", viewCount="
				+ viewCount + ", regDate=" + regDate + "]";
	}
	
	
	
}
