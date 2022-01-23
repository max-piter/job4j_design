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


