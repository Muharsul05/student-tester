--liquibase formatted sql
--changeset magarusik:create-test_entity-table
create table test_entity
(
    id    bigserial primary key not null,
    title varchar               not null unique
);