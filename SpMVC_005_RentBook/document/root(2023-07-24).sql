-- RentBook root (2023-07-24)

create database rentBookDB;
use rentBookdb;

create table tbl_books (
	B_CODE		VARCHAR(13)		PRIMARY KEY,
	B_NAME		VARCHAR(125)	NOT NULL,	
	B_AUTHOR	VARCHAR(125)	NOT NULL,	
	B_COMP		VARCHAR(125),		
	B_YEAR		INT				NOT NULL,	
	B_IPRICE	INT,		
	B_RPRICE	INT				NOT NULL	
);

desc tbl_books;
drop table tbl_books;

show tables;

insert into tbl_books(
B_CODE,B_NAME,B_AUTHOR,B_COMP,B_YEAR,B_IPRICE,B_RPRICE
) values (
	'001','자바야 놀자','야놀자','놀자출판',2010,20000,2000
);

select * from tbl_books;

