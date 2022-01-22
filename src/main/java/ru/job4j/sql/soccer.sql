create table seria_A(
club_name varchar(255) primary key,
year_of_foundation int,
salary_score varchar(255)
);


create table player(
id serial primary key,
n_name varchar(255),
club_name varchar(255) references seria_a(club_name),
salary varchar(255)
);



insert into seria_a(club_name, year_of_foundation, salary_score) values ('Inter', 1908, '149_mln');
insert into seria_a(club_name, year_of_foundation, salary_score) values ('Milan', 1899, '90_mln');
insert into seria_a(club_name, year_of_foundation, salary_score) values ('Juventus', 1897, '236_mln');
insert into seria_a(club_name, year_of_foundation, salary_score) values ('Napoli', 1926, '105_mln');
insert into seria_a(club_name, year_of_foundation, salary_score) values ('Roma', 1926, '112_mln');

insert into player(n_name, club_name, salary) values ('Ronaldu', 'Juventus', '31_mln');
insert into player(n_name, club_name, salary) values ('De Ligt', 'Juventus', '8_mln');
insert into player(n_name, club_name, salary) values ('Lukaku', 'Inter', '7.5_mln');
insert into player(n_name, club_name, salary) values ('Jeko', 'Roma', '7.5_mln');
insert into player(n_name, club_name, salary) values ('Eriksen', 'Inter', '7.5_mln');
insert into player(n_name, club_name, salary) values ('Dibala', 'Juventus', '7.3_mln');
insert into player(n_name, club_name, salary) values ('Ibrahimovich', 'Milan', '7_mln');
insert into player(n_name, club_name, salary) values ('Sanchez', 'Inter', '7_mln');
insert into player(n_name, club_name, salary) values ('Ramsey', 'Juventus', '7_mln');
insert into player(n_name, club_name, salary) values ('Rabio', 'Juventus', '7_mln');
insert into player(n_name, club_name) values ('Cuadrado', 'Juventus');


select * from seria_a;
select * from player;

select * from player p join seria_a s on p.club_name = s.club_name;

select * from seria_a s join player p on s.club_name = p.club_name
where year_of_foundation > 1900
order by salary_score  desc;

select p.n_name player, s.club_name club
from seria_a s join player p on s.club_name = p.club_name
order by salary;

select p.n_name player, s.club_name club, p.salary s
from seria_a s  join player p on s.club_name = p.club_name
where year_of_foundation < 1900
order by s desc nulls last ;

select p.n_name player, s.club_name club
from seria_a s  JOIN player p
ON (s.club_name = p.club_name AND year_of_foundation between 1899 AND 1901);





