create table crossover(
    id serial primary key,
    brand varchar(255),
    model text,
    hp text
    );

insert into cars(name, model, hp) values ('Land Rover', 'Discovery 3', '190');
insert into cars(name, model, hp) values ('Ford', 'Escape', '131');
insert into cars(name, model, hp) values ('Nissan', 'X-Trail', '144');	
select * from cars;
update cars set name = 'Honda';
select * from cars;
delete from cars;
select * from cars;
insert into cars(name, model, hp) values ('Land Rover', 'Discovery 4', '245');
insert into cars(name, model, hp) values ('Land Rover', 'Discovery 3', '190');
insert into cars(name, model, hp) values ('Nissan', 'X-Trail', '144');
select * from cars;
insert into cars(name, model, hp) values ('Ford', 'Escape', '131');
select * from cars;