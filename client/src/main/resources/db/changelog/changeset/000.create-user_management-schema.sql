--liquibase formatted sql
--changeset magarusik:create-schema-user_management

create schema if not exists user_management;