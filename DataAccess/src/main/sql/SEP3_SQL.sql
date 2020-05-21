DROP SCHEMA IF EXISTS "sep3";
CREATE SCHEMA sep3;

USE sep3;

-- -- -- User Table -- -- --

DROP TABLE IF EXISTS Users CASCADE;
CREATE TABLE Users (

                       Users_ID SERIAL,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       firstName VARCHAR(255),
                       lastName VARCHAR(255),
                       email VARCHAR(255),
                       status VARCHAR(30),
                       accessLevel VARCHAR(255),
                       employmentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (Users_ID)
);

-- Test purposes, can be deleted at anytime

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel)
    VALUE('admin', 'admin', 'admin', 'admin', 'admin@admin.admin', 'ACTIVE', 'MANAGER'  );

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel)
    VALUE('Anders', '1234', 'Anders', 'Sønderby', '264247@via.dk', 'ACTIVE', 'EMPLOYEE');

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel)
    VALUE('David', '4321', 'David', 'Nguyen', '251771@via.dk', 'INACTIVE', 'EMPLOYEE');

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel)
    VALUE('Niklas', '549190650', 'Niklas', 'Krogh', '281335@via.dk', 'ACTIVE', 'MANAGER');

INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel)
    VALUE('Rokas', '92668751', 'Rokas', 'Barasa', '285047@via.dk', 'ACTIVE', 'EMPLOYEE');

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
                       description VARCHAR(10000),
                       status VARCHAR(255),
                       Manager_ID INTEGER REFERENCES Users(Users_ID),
                       day int,
                       month int,
                       year int,
                       PRIMARY KEY(Shift_ID)

);

-- Test purposes, can be deleted at anytime

INSERT INTO Shift (Users_ID, description, status, Manager_ID)
    VALUE (4, 'This is a test of the shift', 'OPEN', 4);

INSERT INTO Shift (Users_ID, description, status, Manager_ID)
    VALUE (4, 'This is a test of the shift', 'CLOSED', 1);

SELECT * FROM Shift;

-- -- -- xxx -- -- --