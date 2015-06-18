package org.kosta.madfortaste.taste.domain;

import java.util.Date;

import org.kosta.madfortaste.user.domain.Member;

public class Reply {
	
	private int replyNo;
	private int articleNo;
	private String writer;
	private String contents;
	private int good;
	private int bad;
	private Date regDate;
	private Member member;
	
	public Reply() {
		super();
	}

	public Reply(int articleNo, String writer, String contents) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.contents = contents;
	}

	public Reply(int replyNo, int articleNo, String writer,
			String contents, int good, int bad, Date regDate, Member member) {
		super();
		this.replyNo = replyNo;
		this.articleNo = articleNo;
		this.writer = writer;
		this.contents = contents;
		this.good = good;
		this.bad = bad;
		this.regDate = regDate;
		this.member = member;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "TasteBoardReply [replyNo=" + replyNo + ", articleNo="
				+ articleNo + ", writer=" + writer + ", contents=" + contents
				+ ", good=" + good + ", bad=" + bad + ", regDate=" + regDate
				+ ", member=" + member + "]";
	}

}
