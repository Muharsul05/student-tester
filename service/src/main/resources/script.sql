set schema 'user_management';

INSERT INTO authority (name)
VALUES ('ADMIN'),
       ('TEACHER'),
       ('STUDENT');

INSERT INTO users (username, password)
VALUES ('magarusik', '$2y$10$ykW6kXOqXh.DctKPKE.Czu7utzgQJr3P9hxGROjLJKH9WbMhgSWXq'),
       ('teacher', '$2y$10$ykW6kXOqXh.DctKPKE.Czu7utzgQJr3P9hxGROjLJKH9WbMhgSWXq'),
       ('student', '$2y$10$ykW6kXOqXh.DctKPKE.Czu7utzgQJr3P9hxGROjLJKH9WbMhgSWXq');

INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

set schema 'testing';

INSERT INTO test (title, created_date)
VALUES ('Java', '2022-01-01'),
       ('Kotlin', '2022-01-02');

INSERT INTO question_type (title)
VALUES ('SINGLE_CHOICE'),
       ('MULTIPLE_CHOICE'),
       ('FILL_IN_THE_BLANK'),
       ('TRUE_OR_FALSE');

INSERT INTO question (title, test_id, question_type_id)
VALUES ('What is Java?', 1, 1),
       ('What is Kotlin?', 2, 1);

INSERT INTO user_profile (user_id, email, first_name, last_name, patronymic, date_of_birth, course, group_name)
VALUES (1, 'magarusik@mail.ru', 'Magaomedrasul', 'Musaev', 'Shah', '2001-02-13', 1, 'Admin'),
       (2, 'teacger@mail.ru', 'Teacher', 'Stich', 'Tiching', null, null, null),
       (3, 'student@mail.ru', 'Sidor', 'Sidorov', 'Sidorovich', '2000-03-03', 3, 'Java');