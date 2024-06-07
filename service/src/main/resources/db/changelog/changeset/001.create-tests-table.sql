--liquibase formatted sql
--changeset magarusik:create-table-test

create table test
(
    id           bigint primary key not null generated by default as identity,
    title        varchar            not null unique,
    created_date timestamp          not null
);