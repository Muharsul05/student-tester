--liquibase formatted sql
--changeset magarusik:create-table-test_results

create table test_results
(
    id           bigint primary key not null generated by default as identity,
    test_id      bigint             not null references tests (id),
    user_id      bigint             not null references users (id),
    score        int                not null,
    created_date date               not null
);