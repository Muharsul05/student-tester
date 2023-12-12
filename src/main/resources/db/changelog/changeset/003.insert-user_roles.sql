--liquibase formatted sql
--changeset magarusik:insert-user_roles
insert into user_role (name)
values ('Студент'),
       ('Преподаватель'),
       ('Администратор');