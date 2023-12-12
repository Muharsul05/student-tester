--liquibase formatted sql
--changeset magarusik:alter-table-test_result-add-foreign-key-constraint-test_id
ALTER TABLE test_result
    ADD CONSTRAINT fk_test_result_test_id
        FOREIGN KEY (test_id)
            REFERENCES test_entity (id)
            ON DELETE CASCADE;

--liquibase formatted sql
--changeset magarusik:alter-table-test_result-add-foreign-key-constraint-user_id
ALTER TABLE test_result
    ADD CONSTRAINT fk_test_result_user_id
        FOREIGN KEY (test_id)
            REFERENCES user_entity (id)
            ON DELETE CASCADE;