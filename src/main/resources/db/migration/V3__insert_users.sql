INSERT INTO users (code, email, is_moderator, name, password, reg_time)
VALUES ('000001', 'user1@email.com', '1', 'user1', 'pass1', '2020-09-29 00:00:00'::timestamptz);

INSERT INTO users (code, email, is_moderator, name, password, reg_time)
VALUES ('000002', 'user2@email.com', '0', 'user2', 'pass2', '2020-09-29 21:23:45-01'::timestamptz);

INSERT INTO users (code, email, is_moderator, name, password, reg_time)
VALUES ('000003', 'user3@email.com', '0', 'user3', 'pass3', '2020-09-30 00:34:56+01'::timestamptz);