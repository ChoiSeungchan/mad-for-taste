create table tasty_place(
	br_no number primary key,
	business_name varchar2(20)not null,
	address varchar2(50)not null,
	tel varchar2(20)not null,
	contract_flag varchar2(10) default 'N',
	owner_id varchar2(20) not null,
	constraint owner_id_fk foreign key (owner_id) references owner(owner_id) on delete cascade
)
delete from owner
delete from tasty_place
select *from tasty_place
drop table tasty_place
select *from owner
create sequence tasty_place_seq nocache
drop sequence tp_seq