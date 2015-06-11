
----- Member -----

drop table member
create table member(
	id varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20) not null,
	address varchar2(50) not null,
	gender varchar2(10) not null,
	birth varchar2(20) not null,
	tel varchar2(20) not null,
	exp number default 1 not null,
	point number default 0 not null,
	join_date date default sysdate,
	profile_img varchar2(30)
)
create table owner(
	owner_id varchar2(20) primary key,
	password varchar2(20)not null,
	name varchar2(20)not null,
	tel varchar2(20)not null,
	email varchar2(50)not null,
	join_date date not null,
	profile_img varchar2(30)
)
select owner_id as ownerId,password,name,tel,email,join_date as joinDate,profile_img as profileImg from owner
drop table member
drop table owner
create sequence 
drop table tasty_place
select *from owner
select *from tasty_place
select * from member
delete from tasty_place
delete from owner
