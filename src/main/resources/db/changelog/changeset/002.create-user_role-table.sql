--liquibase formatted sql
--changeset magarusik:create-user_role-table
create table user_role
(
    id   bigserial primary key not null,
    name varchar            not null unique
);