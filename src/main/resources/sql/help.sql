-------- notice----------
create table notice_board(
	article_no number primary key,
	writer varchar2(20) not null,
	title varchar2(50) not null,
	content clob not null,
	hits number default 0,
    reg_date date default sysdate,
	constraint noticewriter_fk foreign key (writer) references member(id) on delete cascade
)
drop table notice_board;
create sequence notice_no_seq nocache;
drop sequence notice_no_seq;

select * from notice_board order by article_no desc;

insert into notice_board values(notice_no_seq.currval,'',#{title},#{content})

insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트1','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트2','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트3','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트4','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트5','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트6','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트7','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트8','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트9','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트10','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트11','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트12','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트13','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트14','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트15','테스트');
insert into notice_board(article_no,writer, title, content)
values(notice_no_seq.nextval,'java','테스트16','테스트');
select * from notice_board
select * from (select rownum,n.* from notice_board n order by article_no desc) where rownum between #{beginRow} and #{endRow}
select * from member;
drop table member;

