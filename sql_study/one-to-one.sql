create table people(
    id serial primary key,
    n_name varchar(255)
);

create table fanID(
    id serial primary key,
    number int,
	people_id int references people(id) unique
);


insert into fanID(number) values(123);
insert into fanID(number) values(124);
insert into fanID(number) values(125);
insert into people(n_name) values('Max');
insert into people(n_name) values('Kirill');
insert into people(n_name) values('Andrew');

select * from fanID;

