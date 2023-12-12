--liquibase formatted sql
--changeset magarusik:insert-user_entities
insert into user_entity (username, password, email, first_name, last_name, patronymic, role_id)
values ('Студент', '$2a$10$BYaBtbuOxtz0DIO0PoYrW.j7k/69ocY0SI4ZVSmuwM0yed9DrF11e', 'student@example.com', 'Иван', 'Иванов', 'Иванович', 1),
       ('Преподаватель', '$2a$10$BYaBtbuOxtz0DIO0PoYrW.j7k/69ocY0SI4ZVSmuwM0yed9DrF11e', 'teacher@example.com', 'Иван', 'Иванов', 'Иванович', 2),
       ('Администратор', '$2a$10$BYaBtbuOxtz0DIO0PoYrW.j7k/69ocY0SI4ZVSmuwM0yed9DrF11e', 'admin@example.com', 'Иван', 'Иванов', 'Иванович', 3);