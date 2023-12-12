--liquibase formatted sql
--changeset magarusik:insert-tests
insert into test_entity (title)
values ('Тест No1'),
       ('Тест No2'),
       ('Тест No3'),
       ('Тест No4'),
       ('Тест No5');