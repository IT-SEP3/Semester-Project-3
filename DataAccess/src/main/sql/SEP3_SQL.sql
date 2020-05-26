-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

DROP SCHEMA IF EXISTS sep3;
CREATE SCHEMA sep3;

USE sep3;

-- -- -- User Table -- -- --

DROP TABLE IF EXISTS Users CASCADE;
CREATE TABLE Users (
                       users_ID SERIAL,
                       manager_ID int NOT NULL,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       firstName VARCHAR(255) NOT NULL,
                       lastName VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       status VARCHAR(30),
                       accessLevel VARCHAR(255) NOT NULL,
                       dayEmployment int,
                       monthEmployment int,
                       yearEmployment int,
                       PRIMARY KEY (Users_ID)
);

-- Test purposes, can be deleted at anytime

INSERT INTO Users (username, manager_ID,  password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('admin', 3, 'admin', 'admin', 'admin', 'admin@admin.admin', 'ACTIVE', 'MANAGER', 16, 03, 2020  );

SELECT * FROM Users;



-- Test end here...

SELECT Users_ID, username FROM Users WHERE username = 'Niklas';

SELECT username, password, accessLevel FROM Users
WHERE accessLevel = 'employee';

-- -- -- Shift Table -- -- --

DROP TABLE IF EXISTS Shift CASCADE;
CREATE TABLE Shift (
                        Shift_ID SERIAL,
                        Users_ID INTEGER REFERENCES Users(Users_ID),
                        Manager_ID INTEGER REFERENCES Users(Users_ID),
                        description VARCHAR(10000),
                        day int NOT NULL,
                        month int NOT NULL,
                        year int NOT NULL,
                        PRIMARY KEY(Shift_ID)

);

-- Test purposes, can be deleted at anytime

INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3, 'This is a test of the shift',   04, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3,'This is a test of the shift',   05, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (6, 3, 'This is a test of the ',   06, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3,'This is a test  the shift',   07, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (9, 3, 'This is a test of the shift',   08, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (6, 3,'This  test of the shift',   11, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (7, 3, 'This is a  of the shift',   12, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (8, 3,'f the shift',   14, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (8, 3, 'This is a test of the shift',   13, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3,'This is a test of the shift',   29, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3,'This is a test of the shift',   06, 05, 2020);
SELECT * FROM Shift;
