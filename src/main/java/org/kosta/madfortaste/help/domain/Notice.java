package org.kosta.madfortaste.help.domain;

import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.Owner;

public class Notice {
 private String no;
 private String writer;
 private String title;
 private String contents;
 private String hits;
 private String reg_date;
 private Member member;
 private Owner owner;
public Notice() {
	super();
}
public Notice(String no, String writer, String title, String contents,
		String hits, String reg_date, Member member, Owner owner) {
	super();
	this.no = no;
	this.writer = writer;
	this.title = title;
	this.contents = contents;
	this.hits = hits;
	this.reg_date = reg_date;
	this.member = member;
	this.owner = owner;
}
public Notice(Member member, Owner owner) {
	super();
	this.member = member;
	this.owner = owner;
}
public Notice(Member member) {
	super();
	this.member = member;
}
public Notice(Owner owner) {
	super();
	this.owner = owner;
}
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
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
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public String getHits() {
	return hits;
}
public void setHits(String hits) {
	this.hits = hits;
}
public String getReg_date() {
	return reg_date;
}
public void setReg_date(String reg_date) {
	this.reg_date = reg_date;
}
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}
public Owner getOwner() {
	return owner;
}
public void setOwner(Owner owner) {
	this.owner = owner;
}
@Override
public String toString() {
	return "Notice [no=" + no + ", writer=" + writer + ", title=" + title
			+ ", contents=" + contents + ", hits=" + hits + ", reg_date="
			+ reg_date + ", member=" + member + ", owner=" + owner + "]";
}
 
 
}
