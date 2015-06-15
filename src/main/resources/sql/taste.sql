create table tasty_place(
	br_no number primary key,
	business_name varchar2(20)not null,
	address varchar2(50)not null,
	tel varchar2(20)not null,
	contract_flag varchar2(10) default 'N',
	owner_id varchar2(20) not null,
	constraint owner_id_fk foreign key (owner_id) references owner(owner_id) on delete cascade
)
select t.br_no as brNo,t.business_name as businessName,t.address,t.tel as tastyTel,t.contract_flag as contractFlag,o.name as ownerId from owner o,tasty_place t where o.owner_id=t.owner_id and t.br_no='7777777'
delete from owner
delete from tasty_place
select *from tasty_place t,owner o where o.owner_id=t.owner_id and o.owner_id='kostajjang'
drop table tasty_place
select *from owner
update tasty_place set contract_flag='Y' where br_no='777'
create sequence tasty_place_seq nocache
drop sequence tp_seq


-- 맛집게시판 --
select * from taste_board

select * from taste_board_reply

select * from taste_board_img

drop table taste_board
create table taste_board (
	article_no number primary key,
	location varchar2(20) not null,
	writer varchar2(20) not null,
	title varchar2(50) not null,
	contents clob not null,
	reg_date date default sysdate,
	good number default 0,
	bad number default 0,
	hits number default 0,
	constraint writer_fk foreign key(writer) references member(id)
)
insert into taste_board(article_no,location,writer,title,contents)
values(taste_board_sequence.nextval,'서울','hs9923','testTitle','testContents')

drop sequence taste_board_sequence
create sequence taste_board_sequence nocache

drop table taste_board_img
create table taste_board_img (
	img_no number primary key,
	article_no number not null,
	file_name varchar(30) not null,
	constraint article_no_fk foreign key(article_no) references taste_board(article_no)
)

drop sequence taste_board_img_sequence
create sequence taste_board_img_sequence nocache

-- 맛집 게시판 댓글 --

drop table taste_board_reply
create table taste_board_reply(
	reply_no number primary key,
	article_no number not null,
	writer varchar2(20) not null,
	contents clob not null,
	good number default 0,
	bad number default 0,
	reg_date date default sysdate,
	constraint r_article_no_fk foreign key(article_no) references taste_board(article_no),
	constraint r_writer_fk foreign key(writer) references member(id)
)

drop sequence taste_board_reply_sequence
create sequence taste_board_reply_sequence nocache
