--liquibase formatted sql
--changeset magarusik:create-test_result-table
create table test_result
(
    id      bigserial primary key not null,
    user_id bigint                not null,
    test_id bigint                not null,
    score   float                 not null
);