--liquibase formatted sql
--changeset magarusik:create-users-table
create table user_entity
(
    id         bigserial primary key not null,
    username   varchar               not null unique,
    password   varchar               not null,
    email      varchar               not null unique,
    first_name varchar               not null,
    last_name  varchar               not null,
    patronymic varchar               not null,
    role_id    bigint                not null
);

