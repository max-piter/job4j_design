create table devices(
    id serial primary key,
    n_name varchar(255),
    price real
);

create table new_people(
    id serial primary key,
    n_name varchar(255)
);

create table devices_new_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (n_name, price) values ('Samsung A52', 32000.5);
insert into devices (n_name, price) values ('iphone 12', 84000.5);
insert into devices (n_name, price) values ('macbook pro 13', 122000.45);
insert into devices (n_name, price) values ('laptop LP', 84000.2);
insert into devices (n_name, price) values ('Samsung A32', 18000.99);
insert into devices (n_name, price) values ('TAB A12', 67000.99);

insert into new_people(n_name) values ('Max');
insert into new_people(n_name) values ('Kirill');
insert into new_people(n_name) values ('Andrew');

insert into devices_new_people (device_id, people_id) values(1, 3);
insert into devices_new_people (device_id, people_id) values(2, 1);
insert into devices_new_people (device_id, people_id) values(3, 1);
insert into devices_new_people (device_id, people_id) values(4, 3);
insert into devices_new_people (device_id, people_id) values(5, 1);
insert into devices_new_people (device_id, people_id) values(6, 2);


select round(avg(price)) "average price" from devices;

select d_p.people_id name, avg(price)
from devices_new_people d_p
join devices d on d_p.device_id = d.id
group by d_p.people_id;



select np.n_name name, round(avg(price)/76), '$' "usd"
from devices_new_people d_p
join new_people np on d_p.people_id = np.id
join devices d on d_p.device_id = d.id
group by np.n_name
having avg(price) > 5000;





select np.n_name, max(price) "max price", min(price) "min price",
round(avg(price)) "average price", count(*) devices
from devices_new_people d_p
join new_people np on d_p.people_id = np.id
join devices d on d_p.device_id = d.id
group by np.n_name
having count(*)> 1
order by np.n_name;


