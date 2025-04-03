-- Create hardware table
CREATE TABLE hardware (
    device_id INT AUTO_INCREMENT PRIMARY KEY,
    device_name VARCHAR(255) NOT NULL,
    temperature DOUBLE NOT NULL,
    humidity DOUBLE NOT NULL
);

---- Create software table
--CREATE TABLE software (
--    software_id INT AUTO_INCREMENT PRIMARY KEY,
--    software_name VARCHAR(255) NOT NULL,
--    version VARCHAR(100) NOT NULL
--);
--
---- Insert data into hardware table
--INSERT INTO hardware (device_name, current_temperature)
--VALUES ('ALON', '994'), ('DEVICE_X', '850');
--
---- Insert data into software table
--INSERT INTO software (software_name, version)
--VALUES ('Spring Boot', '3.4.4'), ('Angular', '17.0.0');
