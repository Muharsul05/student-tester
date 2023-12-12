--liquibase formatted sql
--changeset magarusik:add-foreign-key-constraint-question-test_id
ALTER TABLE question_entity
    ADD CONSTRAINT fk_test_entity_test_id
        FOREIGN KEY (test_id)
            REFERENCES test_entity (id)
            ON DELETE CASCADE;