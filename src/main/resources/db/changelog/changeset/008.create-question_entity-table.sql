--liquibase formatted sql
--changeset magarusik:create-question_entity-table
create table question_entity
(
    id      bigserial primary key not null,
    content varchar               not null unique,
    test_id bigint                not null
);