-------- notice----------
drop table notice_board;
create table notice_board(
	article_no number primary key,
	writer varchar2(20) not null,
	title varchar2(50) not null,
	content clob not null,
	hits number default 0,
    reg_date date default sysdate,
	constraint noticewriter_fk foreign key (writer) references member(id) on delete cascade
)

create sequence notice_no_seq nocache;
drop sequence notice_no_seq;

insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트1','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트2','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트3','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트4','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트5','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트6','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트7','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트8','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트9','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트10','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트11','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트12','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트13','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트14','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트15','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'admin','테스트16','테스트');




-------- Qna reply----------
drop table qna_reply;

create table qna_reply(
	article_no number primary key,
	title varchar2(100) not null,
	writer varchar2(100) not null,
	content clob not null,
	hits number default 0,
    reg_date date default sysdate,
	ref number not null, -- 답변글묶음 번호, 원게시글 번호 
	restep number not null, -- 답변글묶음내 글순서(정렬 오름차순)
	relevel number not null -- 답변글레벨 , 답변의 단계 	
)
select * from qna_reply where article_no = '1';

 select * from (
			select rownum as rnum, t.*, m.*
			from (select * from qna_reply order by ref desc,restep asc) t, member m
			where t.writer=m.id and upper(writer) like '%'||upper('admin')||'%' 
		) where rnum between 1 and 100

select article_no,title,writer,content,hits,reg_date,ref,restep,relevel from qna_reply
where writer = upper('Admin') order by ref desc,restep asc 

create sequence qna_reply_seq nocache; 
drop sequence qna_reply_seq;
drop table qna_reply;

insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test2','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test3','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test4','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test5','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test6','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test7','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test8','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test9','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test10','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test11','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test12','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test13','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test14','admin','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test15','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test16','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test17','java','Test',qna_reply_seq.currval,0,0);
insert into qna_reply(article_no,title,writer,content,ref,restep,relevel) 
values(qna_reply_seq.nextval,'test18','java','Test',qna_reply_seq.currval,0,0);

 select * from (
			select rownum as rnum, t.*, m.*
			from (select * from qna_reply order by ref desc, restep asc) t, member m
			where t.writer=m.id
		) where rnum between 1 and 1
		
select * from qna_reply


select * from (
			select rownum as rnum, t.*, m.*
			from (select * from qna_reply order by ref desc,restep asc) t, member m
			where t.writer=m.id and title like '%ad%'
		) where rnum between 1 and 10




--- 신고 ---
select * from article_report
		
drop table article_report
create table article_report (
	report_no number primary key,
	board_name varchar2(20) not null,
	article_no number not null,
	accuser_id varchar2(20) references member(id) on delete cascade, 
	report_reason varchar2(300) not null,
	report_date date default sysdate,
	unique(board_name, article_no, accuser_id)
)

drop sequence article_report_seq
create sequence article_report_seq nocache












