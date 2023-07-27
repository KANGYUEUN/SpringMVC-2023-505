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

select * from tbl_members;

use rentBookDB;
create table tbl_members(
	m_CODE	VARCHAR(6)		PRIMARY KEY,
	m_NAME	VARCHAR(125)	NOT NULL,	
	m_TEL	VARCHAR(15)		NOT NULL,	
	m_ADDR	VARCHAR(125)	NOT NULL	
);

DROP table Tbl_members;

create table tbl_rent_book(
	RENT_SEQ			BIGINT			PRIMARY KEY		AUTO_INCREMENT,
	RENT_DATE			VARCHAR(10)		NOT NULL,		
	RENT_RETURN_DATE	VARCHAR(10)		NOT NULL,		
	RENT_BCODE			VARCHAR(13)		NOT NULL,		
	RENT_MCODE			VARCHAR(6)		NOT NULL,		
	RENT_RETURN_YN		VARCHAR(1),			
	RENT_POINT			INT,			
	RENT_PRICE			INT			
);

select * from tbl_rent_book;

-- (2023-07-26)
use rentBookDB;
select count(*) from tbl_books;
select * from tbl_books;

select count(*) from tbl_members;

select * from tbl_rent_book R
left join tbl_members M
ON R.rent_mcode = M.m_code
left join tbl_books B
on R.rent_bcode = B.b_code;

-- 2023-07-27

-- 처음시작에서 10개를 건너뛰고 : offset 10
-- 그 위치부터 10개를 SELECT 해라
use rentbookdb;
select * from tbl_books
order by b_code
Limit 10 offset 1; 

-- 전체 데이터 중에서 5페이지 10개를 보고싶다.
-- 전체 데이터 중에서 1페이지의 10개 : 0 ~ 9번 까지 보여주기
-- 1페이지 일 경우 시작값 1이 될려면 (page - 1) * 10 + 1
-- 전체 데이터 중에서 2페이지 10 개 : 10번~19번까지 
-- 2페이지 일 경우 시작값이 10이 되려면 (page - 1) * 10
-- 3페이지에서 10개를 보기 : (page - 1) * 10

