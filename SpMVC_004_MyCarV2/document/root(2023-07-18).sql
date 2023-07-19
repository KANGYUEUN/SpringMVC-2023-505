-- root차계부(2023-07-18)
create database mycarDb;
use mycardb;

create table tbl_carmanager (
	c_seq		BIGINT			PRIMARY 	KEY	AUTO_INCREMENT,
	c_carnum	VARCHAR(15)		NOT NULL,		
	c_qty		VARCHAR(10)		NOT NULL,		
	c_username	VARCHAR(25)		NOT NULL,		
	c_sdate		VARCHAR(10)		NOT NULL,		
	c_stime		VARCHAR(10)		NOT NULL,		
	c_goal		VARCHAR(30),			
	c_edate		VARCHAR(10),		
	c_etime		VARCHAR(10),			
	c_skm		INT,			
	c_ekm		INT,			
	c_cost		INT			
);

insert into tbl_carmanager(
c_carnum, c_qty, c_username, c_sdate, c_stime,
c_skm, c_ekm)
values
('001','출근','루랑이','2023-07-18','08:57','3000','3010');

insert into tbl_carmanager(
c_carnum, c_qty, c_username, c_sdate, c_stime,
c_skm, c_ekm)
values
('001','퇴근','루랑이','2023-07-18','18:00','3010','3020');

insert into tbl_carmanager(
c_carnum, c_qty, c_username, c_sdate, c_stime,
c_skm, c_ekm)
values
('002','출장','루랑이','2023-07-19','08:57','10000','10300');

insert into tbl_carmanager(
c_carnum, c_qty, c_username, c_sdate, c_stime,
c_skm, c_ekm)
values
('002','복귀','루랑이','2023-07-20','18:00','10300','10600');

-- 가장 마지막 운행기록 보기 
commit;
select * from tbl_carmanager
where c_carnum = '002'
order by c_sdate desc, c_stime desc
limit 1;
