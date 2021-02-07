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

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2020-12-31 23:59:59+01'::timestamptz, '1', 'ACCEPTED', '1', '1', '0',
        'Title of Post10', 'Post10 post10 post10');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-01 00:00:01+01'::timestamptz, '1', 'ACCEPTED', '1', '2', '11',
        'Title of Post11', 'Post11 post11 post11');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-14 02:59:55+01'::timestamptz, '1', 'ACCEPTED', '1', '3', '12',
        'Title of Post12', 'Post12 post12 post12');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-18 09:34:11+01'::timestamptz, '1', 'ACCEPTED', '1', '1', '13',
        'Title of Post13', 'Post13 post13 post13');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-18 19:39:43+01'::timestamptz, '1', 'ACCEPTED', '1', '2', '14',
        'Title of Post14', 'Post14 post14 post14');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-22 14:00:40+01'::timestamptz, '1', 'ACCEPTED', '1', '3', '15',
        'Title of Post15', 'Post15 post15 post15');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-19 11:30:30+01'::timestamptz, '1', 'ACCEPTED', '1', '1', '16',
        'Title of Post16', 'Post6 post16 post16');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-01-22 19:39:43+01'::timestamptz, '1', 'ACCEPTED', '1', '2', '17',
        'Title of Post17', 'Post17 post17 post17');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-02-06 09:10:24+01'::timestamptz, '1', 'ACCEPTED', '1', '3', '18',
        'Title of Post18', 'Post18 post18 post18');

INSERT INTO posts(time, is_active, moderation_status, moderator_id, user_id, view_count,
                  title, text)
VALUES ('2021-02-07 03:51:52+01'::timestamptz, '1', 'ACCEPTED', '1', '1', '19',
        'Title of Post19', 'Post19 post95 post19');
