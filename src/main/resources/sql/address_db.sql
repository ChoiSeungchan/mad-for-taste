drop table address
create table address (
     addr_no varchar2(10) primary key,
     u_id varchar2(10) not null,
     si varchar2(20),
     gu varchar2(20),
     dong varchar2(20),
     ri varchar2(20),
     add_no1 varchar2(2),
     add_no2 varchar2(2)
);
select *from address
