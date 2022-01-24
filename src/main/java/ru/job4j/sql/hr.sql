1. Создать таблицы и заполнить их начальными данными
create table departments(
id serial primary key,
n_name varchar(255)
)


create table employees (
id serial primary key,
n_name varchar(255),
department_id int references departments(id)
);


insert into departments (n_name) values ('IT'), ('SALES'), ('LOGISTIC');
insert into employees(n_name, department_id)
 values
 ('Max', 1), ('Kirill', 2), ('Mike', 1), ('Olga', 1),
 ('Maria', 2), ('Mark', 2), ('Timur', 2), ('Savva', 1),
 ('Jane', 1), ('Phill', 2), ('Kate', 2), ('David', 1);
 insert into employees (n_name) values ('Cristopher');

select  * from departments;
select * from employees;

2. Выполнить запросы с left, rigth, full, cross соединениями
select e.n_name, d.n_name from
employees e left join departments d on department_id = d.id;

select e.n_name, d.n_name from
employees e right join departments d on department_id = d.id;

select e.n_name, d.n_name from
employees e cross join departments d;

3. Используя left join найти департаменты, у которых нет работников
select e.n_name worker, d.n_name depertment from
departments d left join employees e on department_id = d.id
where e.n_name is null;

4. Используя left и right join написать запросы,
которые давали бы одинаковый результат
(порядок вывода колонок в эти запросах также должен быть идентичный).
select e.n_name worker, d.n_name depertment from
departments d left join employees e on department_id = d.id
where e.n_name is not null;

select e.n_name worker, d.n_name depertment from
departments d right join  employees e on department_id = d.id
where d.n_name is not null;



