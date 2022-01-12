create table man(
    id serial primary key,
    n_name varchar(100)
);

create table woman(
    id serial primary key,
    n_name varchar(100)
);

create table man_woman(
    id serial primary key,
    man_id int references woman(id),
    woman_id int references man(id)
);

insert into man(n_name) values('Ivan');
insert into man(n_name) values('Kirill');
insert into man(n_name) values('Andrey');
insert into man(n_name) values('Max');
insert into woman(n_name) values('Olga');
insert into woman(n_name) values('Marina');
insert into woman(n_name) values('Nadezhda');
insert into woman(n_name) values('Alla');
insert into man_woman(man_id, woman_id) values(1,1);
insert into man_woman(man_id, woman_id) values(2,1);
insert into man_woman(man_id, woman_id) values(2,2);
insert into man_woman(man_id, woman_id) values(2,3);
insert into man_woman(man_id, woman_id) values(2,4);
insert into man_woman(man_id, woman_id) values(3,3);
insert into man_woman(man_id, woman_id) values(3,4);

select * from man;
select * from woman;
select * from man_woman;
