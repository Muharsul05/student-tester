--liquibase formatted sql
--changeset magarusik:add-foreign-key-constraint-user-role-id
ALTER TABLE user_entity
    ADD CONSTRAINT fk_user_entity_role_id
        FOREIGN KEY (role_id)
            REFERENCES user_role (id)
            ON DELETE CASCADE;