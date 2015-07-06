drop table tasty_place
create table tasty_place(
	br_no number primary key,
	business_name varchar2(20)not null,
	address varchar2(50)not null,
	tel varchar2(20)not null,
	contract_flag varchar2(10) default 'N',
	owner_id varchar2(20) not null,
	constraint owner_id_fk foreign key (owner_id) references owner(owner_id) on delete cascade
)

-- 맛집게시판 --


drop table taste_board
create table taste_board (
	article_no number primary key,
	writer varchar2(20) references member(id) on delete cascade,
	res_no number references restaurant(res_no) on delete cascade,
	title varchar2(50) not null,
	contents long not null,
	reg_date date default sysdate,
	reply number default 0,
	good number default 0,
	bad number default 0,
	hits number default 0
)

drop sequence taste_board_sequence
create sequence taste_board_sequence nocache


-- 맛집 게시판 좋아요/싫어요 투표 여부 --

drop table taste_board_vote
create table taste_board_vote(
	article_no number not null,
	member_id varchar(20) not null
)

-- 맛집 게시판 댓글 --

drop table taste_board_reply
create table taste_board_reply(
	reply_no number primary key,
	article_no number not null,
	writer varchar2(20) not null,
	contents long not null,
	good number default 0,
	bad number default 0,
	reg_date date default sysdate,
	constraint r_article_no_fk foreign key(article_no) references taste_board(article_no),
	constraint r_writer_fk foreign key(writer) references member(id)
)
drop sequence taste_board_reply_sequence
create sequence taste_board_reply_sequence nocache

drop table tasty_place_mark
create table tasty_place_mark(
	br_no number references tasty_place(br_no) on delete cascade,
	id varchar2(20) references member(id) on delete cascade,
	mark number not null,
	primary key(br_no,id)
)
insert into tasty_place_mark values('777','member','5')
delete from tasty_place_mark
 drop table tasty_place_reply
 create table tasty_place_reply(
 	reply_no number,
 	br_no number references tasty_place(br_no) on delete cascade,
 	id varchar2(20) default null references member(id) on delete cascade,
 	owner_id varchar2(20) default null references owner(owner_id) on delete cascade,
 	reg_date date default sysdate,
 	contents long not null,
 	primary key(reply_no,br_no)
 )
select * from (select rownum numrow,reply,name,id,joinDate,profileImg,contents,brno from (select t.reply_no reply,m.name name,m.id id,m.join_date joinDate,m.profile_img profileImg,t.contents contents,t.br_no brno from tasty_place_reply t,member m where m.id=t.id order by reply desc)) where brno='77777' and numrow between  1and 1+2
 create sequence tasty_place_reply_seq nocache
 drop sequence tasty_place_reply_seq

 select count(m.birth) from tasty_place_mark t,member m where m.id=t.id and birth between '1987' and '1996' and br_no='7777'


drop table Restaurant
create table Restaurant(
	res_no number primary key,
	res_name varchar2(50) not null,
	city varchar2(20) not null,
	sigungu varchar2(20) not null,
	eupmyeondong varchar2(20) not null,
	good number default 0 not null,
	bad number default 0 not null,
	unique(res_name,city,sigungu,eupmyeondong)
)
create sequence res_seq nocache
drop sequence res_seq

select *from Restaurant
select *from taste_board
select rownum,t.*,m.*,r.city city,r.sigungu sigungu,r.eupmyeondong eupmyeondong,r.good rgood,r.bad rbad from taste_board t, member m,restaurant r where t.writer=m.id and r.res_no=t.res_no and article_no='19'