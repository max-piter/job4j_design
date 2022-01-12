create table club(
    id serial primary key,
    n_name varchar(255)
);

create table players(
    id serial primary key,
    n_name varchar(255),
	surname varchar(255),
	club_id int references club(id)
);

insert into club(n_name) values('Zenit');
insert into club(n_name) values ('Dynamo');
insert into club(n_name) values ('Sochy');
insert into players(n_name, surname, club_id) values('Serdar', 'Azmun', 1);
insert into players(n_name, surname, club_id) values('Anton', 'Shunin', 2);
insert into players(n_name, surname, club_id) values('Denis', 'Adamov', 3);
insert into players(n_name, surname, club_id) values('Nikolay', 'Zabolotnyi', 3);
insert into players(n_name, surname, club_id) values('Christian', 'Noboa', 3);
insert into players(n_name, surname, club_id) values('Feodor', 'Smolov', 2);

select *from players;
select * from club where id in (select id from players);
