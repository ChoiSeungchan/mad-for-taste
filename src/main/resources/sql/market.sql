drop table item
create table item(
	item_no number primary key,
	item_stock number not null,
	max_amount_available number default 10,
	item_name varchar(100)not null,
	item_price number not null,
	item_effect varchar2(20)not null,
	item_effect_value number, 	
	item_detail long not null,
	item_img_name varchar(30) not null
)
delete from item
create sequence item_seq nocache
drop sequence item_seq

select * from item
drop table purchase
create table Purchase(
	purchase_no number primary key,
	id references member(id) on delete cascade,
	item_no references item(item_no) on delete cascade,
	purchase_date date default sysdate,
	purchase_amount number not null
)
create sequence purchase_seq nocache
drop sequence purchase_seq

drop table inventory
create table inventory(
	id references member(id) on delete cascade,
	item_no number references item(item_no) on delete cascade,
	item_amount number not null,
	primary key(id,item_no)
)

select * from inventory

