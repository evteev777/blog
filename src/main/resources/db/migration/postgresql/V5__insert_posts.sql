INSERT INTO posts(is_active, moderation_status, moderator_id, text, time, title, user_id,
                  view_count)
VALUES ('1', 'ACCEPTED', '0', 'Hi! Greetings to everyone in our blog!', '2020-09-30 00:01:00',
        'Greetings', '1', '2');

INSERT INTO posts(is_active, moderation_status, moderator_id, text, time, title, user_id,
                  view_count)
VALUES ('1', 'NEW', '0', 'Post1 post1 post1', '2020-09-29 22:00:00-01'::timestamptz,
        'Title of Post1', '2', '0');

INSERT INTO posts(is_active, moderation_status, moderator_id, text, time, title, user_id,
                  view_count)
VALUES ('0', 'NEW', '0', 'Post2 post2 post2', '2020-09-30 01:00:00+01'::timestamptz,
        'Title of Post2', '3', '0');

INSERT INTO posts(is_active, moderation_status, moderator_id, text, time, title, user_id,
                  view_count)
VALUES ('1', 'ACCEPTED', '0', 'Post3 post3 post3', '2020-09-29 22:22:22-01'::timestamptz,
        'Title of Post3', '2', '10');

INSERT INTO posts(is_active, moderation_status, moderator_id, text, time, title, user_id,
                  view_count)
VALUES ('1', 'DECLINED', '0', 'Post4 post4 post4', '2020-09-30 01:33:33+01'::timestamptz,
        'Title of Post4', '3', '0');
