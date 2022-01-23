create table type(
id serial primary key,
n_name varchar(255)
);

create table product (
id serial primary key,
n_name varchar(255),
type_id int references type(id),
expired_date date,
price real
)

insert into type(n_name) values ('СЫР'), ('МОЛОКО'), ('МЯСО'), ('КОЛБАСА'), ('ОВОЩИ'), ('ФРУКТЫ');

insert into product(n_name, type_id, expired_date, price)
values
('моцарелла', 1, '2022-02-02',345.5), ('плавленный', 1, '04-02-2022', 299.9),
('тильзитер', 1, '2022-02-02',521.9), ('эдам', 1, '08-08-2022', 650.4), ('Маасдам', 1, '2022-02-02', 630.5),
('топлёное', 2, '2022-01-01', 56),
 ('пастеризованное', 2, '2022.02.24', 89.3),
('обезжиренное', 2, '2022.01.19', 84),('мороженое', 2, '2022.02.24', 29.9),
('свинина охл', 3, '02.02.2022', 249.7), ('баранина мороженная', 3, '2022.02.24', 780.9),
('кура охл', 3, '2022.02.24', 149.9), ('говядина охл', 3, '2022.01.24', 534.7 ),
('говядина замороженое', 3, '2022.06.24', 349.9),
('салями', 4, '02.02.2023', 459), ('финская', 4, '2022.01.04', 787.0), ('балык', 4, '2022.02.24', 678.9),
('огурцы', 5, '2022.01.20', 129.8), ('помидоры', 5, '12.02.2022', 179.9), ('картофель', 5, '11.02.2022', 39.5),
('яблоки', 6, '10.02.2022', 99.0), ('бананы', 6, '11.01.2022', 59.9);


1.Написать запрос получение всех продуктов с типом "СЫР"
select p.n_name product from product p
join type t on p.type_id = t.id
where t.n_name = 'СЫР';

2.Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select n_name product  from product
where n_name like  '%мороженое%';

3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select t.n_name type,  p.n_name product, expired_date "use before" from product p
join type t on p.type_id = t.id
where expired_date < current_date;

4. Написать запрос, который выводит самый дорогой продукт.
select  n_name, price  from product p
 where price = (select max(price) from product);

5.Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
 В виде имя_типа, количество.
 select t.n_name, count(p.n_name) from type t
 join product p on t.id = p.type_id
 group by t.n_name;

 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
 select  p.n_name from product p
 join type t on t.id = p.type_id
 where t.n_name = 'СЫР' or t.n_name = 'МОЛОКО';

7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
Под количеством подразумевается количество продуктов определенного типа.
Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
select t.n_name from type t
 join product p on t.id = p.type_id
 group by t.n_name
 having count(p.n_name) < 10;

8. Вывести все продукты и их тип.
select p.n_name, t.n_name from  product p
join type t on t.id = p.type_id;


