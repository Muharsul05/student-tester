--liquibase formatted sql
--changeset magarusik:create-table-answers

create table answers
(
    id          bigint primary key not null generated by default as identity,
    question_id bigint             not null references questions (id),
    answer_text varchar            not null
);