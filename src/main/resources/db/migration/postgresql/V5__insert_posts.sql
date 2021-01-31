INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-28 00:01:00', '1', 'ACCEPTED', '1', '1', '0',
        'Greetings', 'Hi! Greetings to everyone in our blog!');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-29 22:00:00-01'::timestamptz, '1', 'NEW', '1', '2', '0',
        'Title of Post2', 'Post2 post2 post2');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-30 01:00:00+01'::timestamptz, '0', 'NEW', '1', '3', '0',
        'Title of Post3', 'Post3 post3 post3');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-29 11:11:11-01'::timestamptz, '1', 'ACCEPTED', '1', '1', '0',
        'Title of Post4', 'Post4 post4 post4');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-29 22:22:22-01'::timestamptz, '1', 'DECLINED', '1', '2', '0',
        'Title of Post5', 'Post5 post5 post5');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-30 01:33:33+01'::timestamptz, '1', 'ACCEPTED', '1', '3', '0',
        'Title of Post6', 'Post6 post6 post6');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-30 01:44:44+01'::timestamptz, '1', 'ACCEPTED', '1', '1', '0',
        'Title of Post7', 'Post7 post7 post7');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-09-30 01:55:55+01'::timestamptz, '1', 'ACCEPTED', '1', '2', '0',
        'Title of Post8', 'Post8 post8 post8');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-03-01 10:00:00+01'::timestamptz, '1', 'ACCEPTED', '1', '3', '0',
        'Future Post9', 'Post9 post9 post9');
