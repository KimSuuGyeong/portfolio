create table ad(
custno number(6) not null primary key,
id varchar2(30)not null,
pw varchar2(30)not null,
name varchar2(20)not null,
phone varchar2(20)not null,
joindate date default sysdate,
grade char(1)
)

drop table ad

select * from ad 

ALTER TABLE ad ADD note varchar2(200)

select max(CUSTNO)+1 as maxNum from ad

insert into ad values(1001,'admin','1234','관리자','010-1234-5678','2022-01-01','C');

