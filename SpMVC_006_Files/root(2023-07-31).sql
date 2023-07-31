create database imageDB;
use imageDB;

create table tbl_bbs (
	b_seq bigint primary key auto_increment,
	b_title	 varchar(125),
	b_content varchar(1000),
	b_nickname varchar(125),
	b_password varchar(125),
	b_ccode varchar(6),
	b_date varchar(10),
	b_viewcount  long,
	b_image varchar(255),
	b_origin_image varchar(255)
);

select * from tbl_bbs;
select * from tbl_files;

drop table tbl_files;
 

show tables;
