5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
Используя cross join составить все возможные разнополые пары

create table teens(
id serial primary key,
n_name varchar(255),
gender char(1)
);

insert into teens(n_name, gender)
 values
 ('Max', 'M'), ('Olga', 'W'), ('Kirill', 'M'), ('Andrew', 'M'),
 ('Steve', 'M'), ('Vera', 'W'), ('Mary', 'W'), ('John', 'M');

select * from teens;
select t1.n_name, t2.n_name from
teens t1 cross join teens t2
where t1.gender != t2.gender;