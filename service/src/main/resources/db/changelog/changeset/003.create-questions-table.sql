--liquibase formatted sql
--changeset magarusik:create-table-question

create table question
(
    id               bigint primary key not null generated by default as identity,
    title            varchar            not null,
    test_id          bigint             not null references test (id),
    question_type_id bigint             not null references question_type (id)
);