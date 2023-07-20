-- root (2023-07-20)
use mycardb;

create table tbl_users (
	username	VARCHAR(15)		PRIMARY KEY,
	password	VARCHAR(255)	NOT NULL,	
	u_name		VARCHAR(20)		NOT NULL,	
	u_nickname	VARCHAR(20),		
	u_tel		VARCHAR(15),		
	u_role		VARCHAR(15)		NOT NULL	
);

drop table tbl_carmanager;
show tables;
drop table tbl_users;
show tables;

select * from tbl_carmanager;alter
insert into tbl_user (username, password, u_name, u_nickname, u_tel, u_role)




