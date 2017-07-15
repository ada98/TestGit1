
create table users1(
	id int ,
	password varchar(100)
);

select * from users1;
insert into users1(id,password)values(1,"a");
insert into users1(id,password)values(2,"a");
insert into users1(id,password)values(3,"a");

select * from users1 where id=1 and password="a";