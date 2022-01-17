insert into users(id, n_name, login, password, phone) values(2, 'Kirill', 'Kor', '321', '123-45-67');

insert into role(role_type, role_discription, user_id) values('editor', 'edit/delete/add', 1);
insert into role(role_type, role_discription, user_id) values('admin', 'edit', 1);
insert into role(role_type, role_discription, user_id) values('user', 'read', 1);

insert into rule(rule_type, rule_description) values('editor rules', 'some editor description..');
insert into rule(rule_type, rule_description) values('admin rules', 'some admin description..');
insert into rule(rule_type, rule_description) values('user rules', 'some user description..');

insert into role_rule(role_type, rule_type) values ('editor', 'editor rules');
insert into role_rule(role_type, rule_type) values ('admin', 'admin rules');
insert into role_rule(role_type, rule_type) values ('user', 'user rules');

insert into category(category_type, category_discription) values('offers', 'some offers discription...');
insert into category(category_type, category_discription) values('info', 'some info...');
insert into category(category_type, category_discription) values('application', 'some application info...');

insert into state(status_type, type_discription) values('acp', 'accepted');
insert into state(status_type, type_discription) values('wt', 'waiting');
insert into state(status_type, type_discription) values('dn', 'denied');

insert into item(item_id, iten_name, item_date, user_id, category_type, status_type)
                      values(1, 'credit', '1997-01-31 09:26:50.12', 1, 'application', 'dn');
insert into item(item_id, iten_name, item_date, user_id, category_type, status_type)
                      values(2, 'credit', '2022-01-31 09:26:50.12', 2, 'application', 'wt');

insert into users_item(item_id, user_id) values (1, 1);
insert into users_item(item_id, user_id) values (2, 2);

insert into comments(comment_id, item_id, comment_text, comment_date) values(1, 1, 'some text', '1997-01-31 09:26:50.12');
insert into comments(comment_id, item_id, comment_text, comment_date) values(2, 2, 'some text', '2022-01-31 09:26:50.12');

insert into attachs(attach_id, item_id) values(1, 1);




