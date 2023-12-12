--liquibase formatted sql
--changeset magarusik:create-option_entity-table
create table option_entity
(
    id          bigserial primary key not null,
    answer      varchar               not null unique,
    correct     boolean,
    question_id bigint                not null
);