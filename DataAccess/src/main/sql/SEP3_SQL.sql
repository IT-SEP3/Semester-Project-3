DROP SCHEMA IF EXISTS "sep3";
CREATE SCHEMA sep3;

USE sep3;

-- -- -- User Table -- -- --

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (

                       username varchar (255),
                       password varchar (255),
                       Id serial,
                       PRIMARY KEY (Id)
);

INSERT INTO users (username, password) VALUE('admin', 'admin');
INSERT INTO users (username, password) VALUE('Anders', '1234');
INSERT INTO users (username, password) VALUE('David', '4321');
INSERT INTO users (username, password) VALUE('Niklas', '549190650');
INSERT INTO users (username, password) VALUE('Rokas', 'password');

SELECT * FROM users;

-- -- -- Calendar Table -- -- --

DROP TABLE IF EXISTS calendar CASCADE;
CREATE TABLE calendar (
                          user_Id integer references users (Id),
                          month varchar(50),
                          Id serial,
                          primary key (Id)
);

INSERT INTO calendar (user_Id, month) VALUE (1 ,'May');
INSERT INTO calendar (user_Id, month) VALUE (1 ,'December');
INSERT INTO calendar (user_Id, month) VALUE (2 ,'April');
INSERT INTO calendar (user_Id, month) VALUE (3 ,'June');
INSERT INTO calendar (user_Id, month) VALUE (3 ,'July');

SELECT * FROM calendar;
/* -- Test purposes, can be deleted at anytime
SELECT user_Id, month, Id
FROM calendar
WHERE user_Id = 1;

SELECT Id FROM users;
 */

-- -- -- xxx -- -- --