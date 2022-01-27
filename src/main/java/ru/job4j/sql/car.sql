create table body(
id serial primary key,
type varchar(255)
);

create table engine(
id serial primary key,
type varchar(255)
);

create table transmission(
id serial primary key,
type varchar(255)
);

create table car(
id serial primary key,
n_name varchar(255),
body_type int references body(id),
engine_type int references engine(id),
transmission_type int references transmission(id)
);

insert into body(type) values('wagon'), ('hatchback'), ('sedan'), ('coupe'), ('crossover'), ('off-roader');
insert into engine(type) values('petrol'), ('diesel'), ('hybrid'), ('electro');
insert into engine(type) values('gas');
insert into transmission(type) values ('automatic'), ('manual'), ('robot'), ('CVT');

insert into car(n_name, body_type, engine_type, transmission_type)
values
('Mazda Tribute', 5, 1, 1), ('Land Rover Disco', 6, 2, 2), ('Lada Calina', 3, 1, 2),
('Chevrolet Orlando', 1, 1, 3), ('Volkswagen Polo', 4, 1, 4), ('Opel astra', 2, 1, 1),
('Fiat Coupe', 4, 1, 2);

select c.n_name name, b.type "body configuration", e.type "engine configuration", t.type "gearbox"
from
car c  left join body b on c.body_type = b.id
left join engine e on c.engine_type = e.id
left join transmission t on c.transmission_type = t.id;

select type, c.n_name name
from
body b left join car c on c.body_type = b.id
where c.body_type is null;

select type, c.n_name name
from
transmission t left join car c on c.transmission_type = t.id
where c.transmission_type is null;

select type, c.n_name name
from
engine e  left join car c on c.engine_type = e.id
where c.engine_type is null;
