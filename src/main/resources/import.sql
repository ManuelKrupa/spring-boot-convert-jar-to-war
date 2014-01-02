-- Sample datas for tests

insert into users(USER_ID, USER_LOGIN, USER_PWD, USER_1ST_NAME, USER_LAST_NAME) values (1, 'test', 'test', 'Test', '');
insert into users(USER_ID, USER_LOGIN, USER_PWD, USER_1ST_NAME, USER_LAST_NAME) values (2, 'admin', 'admin', 'Admin', '');
insert into users(USER_ID, USER_LOGIN, USER_PWD, USER_1ST_NAME, USER_LAST_NAME) values (3, 'mkrupa', 'mkrupa', 'KRUPA', 'Manuel');
insert into users(USER_ID, USER_LOGIN, USER_PWD, USER_1ST_NAME, USER_LAST_NAME) values (4, 'glevilain', 'glevilain', 'LEVILAIN', 'Gregory');

insert into roles(ROLE_ID, ROLE_LABEL) values (1, 'CREATE');
insert into roles(ROLE_ID, ROLE_LABEL) values (2, 'READ');
insert into roles(ROLE_ID, ROLE_LABEL) values (3, 'UPDATE');
insert into roles(ROLE_ID, ROLE_LABEL) values (4, 'DELETE');

-- Test user can only read
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (1, 2);
-- Admin user can make all
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (2, 1);
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (2, 2);
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (2, 3);
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (2, 4);
-- KRUPA Manuel user can create, read, update 
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (3, 1);
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (3, 2);
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (3, 3);
-- LEVILAIN Gregory user can read, update 
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (4, 2);
insert into user_role(ASS_USER_ID, ASS_ROLE_ID) values (4, 3);
