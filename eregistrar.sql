CREATE TABLE Student (
                         studentId INT AUTO_INCREMENT PRIMARY KEY,
                         studentNumber VARCHAR(20) NOT NULL UNIQUE,
                         firstName VARCHAR(50) NOT NULL,
                         middleName VARCHAR(50),
                         lastName VARCHAR(50) NOT NULL,
                         cgpa DECIMAL(4, 2),
                         enrollmentDate DATE NOT NULL,
                         isInternational BOOLEAN NOT NULL
);

INSERT INTO Student (studentNumber, firstName, middleName, lastName, cgpa, enrollmentDate, isInternational)
VALUES
    ('000-61-0001', 'Anna', NULL, 'Smith', 3.78, '2019-05-12', 'Yes'),
    ('000-61-0002', 'John', 'Michael', 'Doe', 3.90, '2020-01-15', 'No'),
    ('000-61-0003', 'Emily', NULL, 'Johnson', 3.65, '2018-09-03', 'Yes'),
    ('000-61-0004', 'Daniel', 'James', 'Wilson', 3.55, '2019-11-28', 'No');