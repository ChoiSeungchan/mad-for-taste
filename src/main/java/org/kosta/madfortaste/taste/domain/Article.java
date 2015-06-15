package org.kosta.madfortaste.taste.domain;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Article {
	
	private int articleNo;
	private String location;
	private String writer;
	private String title;
	private String contents;
	private Date regDate;
	private int good;
	private int bad;
	private int hits;
	private List<MultipartFile> files;
	private List<String> fileNameList;
	
	public Article() {
		super();
	}

	public Article(String location, String writer, String title,
			String contents, List<MultipartFile> files) {
		super();
		this.location = location;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.files = files;
	}

	public Article(int articleNo, String location, String writer,
			String title, String contents, Date regDate, int good, int bad,
			int hits, List<String> fileNameList) {
		super();
		this.articleNo = articleNo;
		this.location = location;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.good = good;
		this.bad = bad;
		this.hits = hits;
		this.fileNameList = fileNameList;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
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

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<String> getFileNameList() {
		return fileNameList;
	}

	public void setFileNameList(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}

	@Override
	public String toString() {
		return "Article [articleNo=" + articleNo + ", location=" + location
				+ ", writer=" + writer + ", title=" + title + ", contents="
				+ contents + ", regDate=" + regDate + ", good=" + good
				+ ", bad=" + bad + ", hits=" + hits + ", files=" + files
				+ ", fileNameList=" + fileNameList + "]";
	}
	
}
