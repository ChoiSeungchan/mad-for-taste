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