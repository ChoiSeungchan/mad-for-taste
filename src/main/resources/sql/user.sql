-----출석체크-----

drop table daily_check
create table daily_check (
	id varchar2(20) not null,
	check_time date default sysdate,
	constraint daily_check_id_fk foreign key (id) references member(id) on delete cascade
)

----- Member -----
select * from member;
drop table member
create table member(
	id varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20) not null,
	city varchar2(20) not null,
	sigungu varchar2(20) not null,
	eupmyeondong varchar2(20) not null,
	address varchar2(50) not null,
	gender varchar2(10) not null,
	birth varchar2(20) not null,
	tel varchar2(20) not null,
	exp number default 1 not null,
	point number default 0 not null,
	join_date date default sysdate,
	profile_img varchar2(30)
)
drop table owner
create table owner(
	owner_id varchar2(20) primary key,
	password varchar2(20)not null,
	name varchar2(20)not null,
	tel varchar2(20)not null,
	email varchar2(50)not null,
	join_date date not null,
	profile_img varchar2(30)
)

select *from taste_board
 	select * from (select rownum numrow,reply,name,id,joinDate,profileImg,contents from (select t.reply_no reply,o.name name,o.owner_id id,o.join_date joinDate,o.profile_img profileImg,t.contents contents from tasty_place_reply t,owner o where o.owner_id=t.owner_id order by reply desc)) where numrow between  #{value} and  #{value}+2