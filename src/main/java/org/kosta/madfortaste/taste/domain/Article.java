package org.kosta.madfortaste.taste.domain;

import java.util.Date;
import java.util.List;

import org.kosta.madfortaste.user.domain.Member;
import org.springframework.web.multipart.MultipartFile;

public class Article {

	private int articleNo;
	private String writer;
	private String resNo;
	private String title;
	private String contents;
	private Date regDate;
	private String calDate;
	private int reply;
	private int good;
	private int bad;
	private int hits;
	private Member member;
	private Restaurant restaurant;

	public Article() {
		super();
	}

	public Article(String writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
	}

	public Article(int articleNo, String writer, String title,
			String contents, Date regDate, int reply, int good, int bad,
			int hits) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.reply = reply;
		this.good = good;
		this.bad = bad;
		this.hits = hits;
		this.setCalDate();
	}

	public Article(int articleNo, String writer, String resNo,
			String title, String contents, Date regDate, String calDate,
			int reply, int good, int bad, int hits, Member member,
			Restaurant restaurant) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.resNo = resNo;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.calDate = calDate;
		this.reply = reply;
		this.good = good;
		this.bad = bad;
		this.hits = hits;
		this.member = member;
		this.restaurant = restaurant;
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

	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
		this.setCalDate();
	}

	public String getCalDate() {
		return calDate;
	}

	public void setCalDate() {
		long currentD = System.currentTimeMillis();
		long createD = regDate.getTime();
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

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
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

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Article [articleNo=" + articleNo
				+ ", writer=" + writer + ", resNo=" + resNo + ", title="
				+ title + ", contents=" + contents + ", regDate=" + regDate
				+ ", calDate=" + calDate + ", reply=" + reply + ", good="
				+ good + ", bad=" + bad + ", hits=" + hits + ", member="
				+ member + ", restaurant=" + restaurant + "]";
	}

}
