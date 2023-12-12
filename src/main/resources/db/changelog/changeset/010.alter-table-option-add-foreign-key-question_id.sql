--liquibase formatted sql
--changeset magarusik:add-foreign-key-constraint-option-question_id
ALTER TABLE option_entity
    ADD CONSTRAINT fk_option_entity_question_id
        FOREIGN KEY (question_id)
            REFERENCES question_entity (id)
            ON DELETE CASCADE;