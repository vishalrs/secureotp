--data for ROLES table
INSERT into ROLES (id, role_name) values (1,'ROLE_USER')
INSERT into ROLES (id, role_name) values (2, 'ROLE_ADMIN')

--data for USERS table
INSERT into USERS (id, email, first_name, last_name, username, password) values (1, 'vishalrs@gmail.com', 'Vishal','S', 'vishalrs', '{noop}password')
INSERT into USERS (id, email, first_name, last_name, username, password) values (2, 'scott@gmail.com', 'Scott','S', 'scotts', '{noop}password')

--data for USER_ROLE table
INSERT into USER_ROLES values (1,1)
INSERT into USER_ROLES values (2,1)
INSERT into USER_ROLES values (2,1)


