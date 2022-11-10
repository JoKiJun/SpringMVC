create table myboard(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(2000),
	writer varchar(30) not null,
	indate date default now(),
	count int default 0,
	primary key(idx)
);

intsert into myboard(title,content,writer) 
values('게시판 연습', '게시판 연습', '조기준');

select * from myboard order by idx desc;