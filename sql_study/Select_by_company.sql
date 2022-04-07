CREATE TABLE if not exists  company
(
    id integer NOT NULL,
    n_name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    n_name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert  into company values (1, 'Adidas');
insert  into company values (2, 'Nike');
insert  into company values (3, 'Puma');
insert  into company values (4, 'Ecco');
insert  into company values (5, 'Scketchers');
insert  into company values (6, 'Merell');

insert  into person values (1, 'Max', 1);
insert  into person values (2, 'Andrew', 2);
insert  into person values (3, 'Kirill', 3);
insert  into person values (4, 'Marina', 4);
insert  into person values (5, 'Olga', 4);
insert  into person values (6, 'Anna', 5);
insert  into person values (7, 'Nins', 5);
insert  into person values (8, 'Anita', 6);
insert  into person values (9, 'Helen', 6);
insert  into person values (10, 'Oleg', 3);
insert  into person values (11, 'Misha', 3);
insert  into person values (12, 'Serg', 3);
insert  into person values (13, 'Igor', 4);
insert  into person values (14, 'Anna', 4);
insert  into person values (15, 'Mike', 1);
insert  into person values (16, 'Alex', 1);

select p.n_name, c.n_name  from person p
join company c
on p.company_id = c.id
where c.id != 5;


select c.n_name as name, count(p.n_name)  as count
from company c
join person p
on p.company_id = c.id
group by c.n_name
HAVING count(p.n_name) = (select max(sub_table.count) from
(select count (n_name) as count
 from person
 group by company_id) as sub_table);
