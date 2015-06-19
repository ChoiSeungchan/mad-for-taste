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

-- 페이징 쿼리 --
select * from (
	select rownum as rnum, t.*, m.*
	from (select * from taste_board order by good-bad desc) t, member m
	where t.writer=m.id
) where rnum between 1 and 30

delete from taste_board

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
	reply number default 0,
	good number default 0,
	bad number default 0,
	hits number default 0,
	constraint writer_fk foreign key(writer) references member(id)
)
select *from taste_board
insert into taste_board(article_no,location,writer,title,contents)
values(taste_board_sequence.nextval,'서울','member','testTitle','testContents')

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

-- 맛집 게시판 좋아요/싫어요 투표 여부 --
select * from taste_board_vote

drop table taste_board_vote
create table taste_board_vote(
	article_no number not null,
	member_id varchar(20) not null
)

insert into taste_board_vote(article_no,member_id) values(27,'member')
-- 맛집 게시판 댓글 좋아요/싫어요 투표 여부 --
drop table taste_board_reply_vote
create table taste_board_reply_vote(
	reply_no number not null,
	member_id varchar(20) not null,
	constraint reply_vote_no_fk foreign key(reply_no) references taste_board_reply(reply_no),
	constraint reply_vote_id_fk foreign key(member_id) references member(id)
)
-- 맛집 게시판 댓글 --

select * from taste_board_reply

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



select *from member
create table tasty_place_mark(
	br_no number references tasty_place(br_no) on delete cascade,
	id varchar2(20) references member(id) on delete cascade,
	mark number not null,
	primary key(br_no,id)
)
select birth from member where id='java123'
select *from tasty_place_mark
select ceil(months_between(sysdate,to_date(birth,'yyyy-mm-dd'))/12) from member where id='java123'
delete from tasty_place_mark
select *from member
select count(*) as totalCnt,sum(mark) as totalMark from tasty_place_mark
select count(m.birth) from tasty_place_mark t,member m where m.id=t.id and birth between '1987' and '1997'
select count(m.birth) from tasty_place_mark t,member m where m.id=t.id and birth between '1977' and '1987'
select count(m.birth) from tasty_place_mark t,member m where m.id=t.id and birth between '1967' and '1977'
 create table tasty_place_reply(
 	reply_no number,
 	br_no number references tasty_place(br_no) on delete cascade,
 	id varchar2(20) default null references member(id) on delete cascade,
 	owner_id varchar2(20) default null references owner(owner_id) on delete cascade,
 	reg_date date default sysdate,
 	contents long not null,
 	primary key(reply_no,br_no)
 )
 create sequence tasty_place_reply_seq nocache
 select *from tasty_place_reply
 delete from tasty_place_reply
 insert into tasty_place_reply(reply_no,br_no,owner_id,contents) values(13,777,'kostajjang','하이 방가요!')
  insert into tasty_place_reply(reply_no,br_no,id,contents) values(12,777,'java1234','하이 방가요!')
select *from	(select t.*,rownum numrow from tasty_place_reply t,member m where m.id=t.id)b where b.numrow between 1 and 3
select b.numrow from	(select a.*,rownum numrow from (select * from tasty_place_reply t,member m where m.id=t.id order by t.reply_no desc)a)b where b.numrow between 1 and 3
select reply,name,id,joinDate,profileImg from (select *from (select rownum numrow,t.reply_no reply,o.name name,o.owner_id id,o.join_date joinDate,o.profile_img profileImg from tasty_place_reply t,owner o where o.owner_id=t.owner_id)a order by reply desc)b where b.numrow between  1 and 3
select *from (select rownum numrow,t.reply_no,o.name from tasty_place_reply t,owner o where o.owner_id=t.owner_id)a where a.numrow between  1 and 3
select *from member

select reply,name,id,joinDate,profileImg from (select *from (select rownum numrow,t.reply_no reply,m.name name,m.id id,m.join_date joinDate,m.profile_img profileImg from tasty_place_reply t,member m where m.id=t.id)a order by reply desc)b where b.numrow between  1 and 3
drop table tasty_place_reply 
