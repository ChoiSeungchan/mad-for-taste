package org.kosta.madfortaste.help.domain;

public class Qna {
	private String articleNo;
	private String writer;
	private String title;
	private String content;
	private int viewCount;
	private String regDate;
	private int ref;// 원 게시물 번호 , 글묶음 
	private int restep;// ref 글묶음내의 글순서 
	private int relevel;// 답변의 단계 
	
	public Qna(String articleNo, String writer, String title, String content,
			int viewCount, String regDate, int ref, int restep, int relevel) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.regDate = regDate;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
	}
	public Qna(String articleNo, String writer, String title, String content,
			int viewCount, String regDate) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.regDate = regDate;
	}
	
	public Qna(String writer, String title, String content, int ref,
			int restep, int relevel) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
	}
	
	public Qna() {
		super();
	}
	
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Qna [articleNo=" + articleNo + ", writer=" + writer
				+ ", title=" + title + ", content=" + content + ", viewCount="
				+ viewCount + ", regDate=" + regDate + ", ref=" + ref
				+ ", restep=" + restep + ", relevel=" + relevel + "]";
	}
	
	
}
