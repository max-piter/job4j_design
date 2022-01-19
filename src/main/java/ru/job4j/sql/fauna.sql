create table fauna (
    id serial primary key,
    n_name text,
    avg_age int,
    discovery_date date
);

insert into fauna(n_name, avg_age, discovery_date) values('Balaena mysticetus', 76650, '01-01-1758');
insert into fauna(n_name, avg_age, discovery_date) values('Ailuropoda melanoleuca', 13870, '01-01-1869');
insert into fauna(n_name, avg_age, discovery_date) values('Capra hircus', 6408, '01-01-1758');
insert into fauna(n_name, avg_age, discovery_date) values('Mus musculus', 1460, '01-01-1758');
insert into fauna(n_name, avg_age, discovery_date) values('Cathartes aura', 43070, '01-01-1758');
insert into fauna(n_name, avg_age, discovery_date) values('Somniosus microcephalus', 109500, '01-01-1801');
insert into fauna(n_name, avg_age, discovery_date) values('Acipenser fulvescens', 55480, '01-01-1817');
insert into fauna(n_name, avg_age, discovery_date) values('Drosophila melanogaster', 30, '01-01-1830');
insert into fauna(n_name, avg_age, discovery_date) values('Gambusia affinis', 1095, '01-01-1853');
insert into fauna(n_name, avg_age, discovery_date) values('Balaena mysticetus', 3285, '01-01-1903');

select * from fauna;
select * from fauna where n_name like 'fish%';
select * from fauna where n_name like 'Drosophila%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date = null;
select * from fauna where discovery_date < '01-01-1950';
