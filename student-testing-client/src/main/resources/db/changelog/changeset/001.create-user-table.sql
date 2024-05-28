--liquibase formatted sql
--changeset magarusik:create-table-user

create table "user"
(
    id       bigint primary key not null generated by default as identity,
    username varchar            not null unique,
    password varchar
)