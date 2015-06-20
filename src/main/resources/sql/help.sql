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


