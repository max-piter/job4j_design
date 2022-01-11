create table crossover(
    id serial primary key,
    brand varchar(255),
    model text,
    hp text
    );
insert into crossover(brand, model, hp) values ('Land Rover', 'Discovery 3', '190');
insert into crossover(brand, model, hp) values ('Ford', 'Escape', '131');
insert into crossover(brand, model, hp) values ('Nissan', 'X-Trail', '144');
select * from crossover;
update crossover set brand = 'Honda';
select * from crossover;
delete from crossover;
select * from crossover;
insert into crossover(brand, model, hp) values ('Land Rover', 'Discovery 4', '245');
insert into crossover(brand, model, hp) values ('Land Rover', 'Discovery 3', '190');
insert into crossover(brand, model, hp) values ('Nissan', 'X-Trail', '144');
select * from crossover;
insert into crossover(brand, model, hp) values ('Ford', 'Escape', '131');
select * from crossover;