 -- DROP DATABASE employees;
CREATE DATABASE IF NOT EXISTS employees;
USE employees;

DROP TABLE IF EXISTS User CASCADE;
DROP TABLE IF EXISTS Authorization CASCADE;

CREATE TABLE User (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled TINYINT NOT NULL
);

CREATE TABLE Authorization (
	username VARCHAR(50) NOT NULL,
    auth VARCHAR(50) NOT NULL,
	UNIQUE KEY authorities_idx_1 (username, auth),
	CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES user (username)
);

INSERT INTO User (username, password, enabled) VALUES
('john_doe', 'password123', 1),   -- John Doe (employee)
('jane_smith', 'securepass', 1),  -- Jane Smith (employee)
('admin_user', 'adminpass', 1),   -- Admin User (admin)
('susan_jones', 'secretword', 0); -- Susan Jones (employee)

INSERT INTO Authorization (username, auth) VALUES
('john_doe', 'ROLE_EMPLOYEE'),
('jane_smith', 'ROLE_EMPLOYEE'),
('admin_user', 'ROLE_ADMIN'),
('susan_jones', 'ROLE_EMPLOYEE');