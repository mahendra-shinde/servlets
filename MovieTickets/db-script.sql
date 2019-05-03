CREATE TABLE movies (
	movieid number(4) primary key, 
	title varchar2(20), 
	r_year number(4), 
	ava_tks number(4)
);

insert into movies values(1001, 'Avengers',2012,100);
insert into movies values(1002, 'Thor',2013, 10);
insert into movies values (1003, 'Avengers: EndGame',2019, 5);
commit;