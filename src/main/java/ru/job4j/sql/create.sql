create table users (
    id serial primary key,
    n_name varchar(255),
    login varchar(10),
    password varchar(10),
    phone character varying(20)
);

create table role (
role_type varchar(255) primary key,
role_discription varchar(255),
user_id int references users(id)
);

create table rule (
rule_type varchar(255) primary key,
rule_description varchar(255)
);

create table role_rule (
role_type varchar(255) references role(role_type),
rule_type varchar(255) references rule(rule_type)
);

create table category (
category_type varchar(255) primary key,
category_discription varchar(255)
);

create table state (
status_type varchar(255) primary key,
type_discription varchar(512)
);

create table item (
item_id serial primary key,
iten_name varchar(255),
item_date timestamp not null,
user_id int references users(id),
category_type varchar(255) references category(category_type),
status_type varchar(255) references state(status_type)
);

create table users_item (
item_id int references item(item_id),
user_id int references users(id)
);

create table comments (
comment_id serial primary key,
item_id int references item(item_id),
comment_text text,
comment_date timestamp not null
);

create table attachs (
attach_id serial primary key,
item_id int references item(item_id),
file_attach bytea
);


