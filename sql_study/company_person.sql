create table position(
    id serial primary key,
    n_name varchar(255)
);

create table employees (
    id serial primary key,
    n_name varchar(255),
    position_id int references position(id)
);

insert into position(n_name) values ('programmer');
insert into position(n_name) values ('project manager');
insert into position(n_name) values ('director');

insert into employees(n_name, position_id) values('Boris', 1);
insert into employees(n_name, position_id) values('Ivan', 1);
insert into employees(n_name, position_id) values('Kiril', 1);
insert into employees(n_name, position_id) values ('Marina', 2);
insert into employees(n_name, position_id) values ('Pers', 3);

insert into employees(n_name) values ('Alexander');



