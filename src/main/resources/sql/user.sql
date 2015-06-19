
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
delete from owner where owner_id = 'owner1234'
--- admin 계정 생성 ---
delete from member
insert into member(id,password,name,address,gender,birth,tel,exp) 
values('admin','1234','관리자','none','none','none','none',10000000)
update tasty_place set contract_flag = 'Y' where br_no = '77777'
-- notice fk 로 인한 계정 추가(최승찬)--
insert into member(id,password,name,address,gender,birth,tel,exp) 
values('java','1234','최승찬','오산','남성','none','none',10000000)

insert into member(id,password,name,address,gender,birth,tel) 
values('member','1234','정현승','판교','남성','1989-02-04','01089909923')

delete from member where id='admin'

create table owner(
	owner_id varchar2(20) primary key,
	password varchar2(20)not null,
	name varchar2(20)not null,
	tel varchar2(20)not null,
	email varchar2(50)not null,
	join_date date not null,
	profile_img varchar2(30)
)
update owner set password='123123' where owner_id='kostajjang'
select owner_id as ownerId,password,name,tel,email,join_date as joinDate,profile_img as profileImg from owner
drop table tasty_place
select * from member
select *from owner where owner_id='kostajjang111'
delete  from owner
