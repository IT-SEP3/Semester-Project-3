DROP SCHEMA IF EXISTS "sep3";
CREATE SCHEMA sep3;

USE sep3;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (

                       username varchar (255),
                       password varchar (255),
                       Id serial
);

INSERT INTO users (username, password) VALUE('admin', 'admin');
INSERT INTO users (username, password) VALUE('Anders', '1234');
INSERT INTO users (username, password) VALUE('David', '4321');
INSERT INTO users (username, password) VALUE('Niklas', 'emma');
INSERT INTO users (username, password) VALUE('Rokas', 'password');

SELECT * FROM users;