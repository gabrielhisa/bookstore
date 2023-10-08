DROP DATABASE bookstore;
CREATE DATABASE IF NOT EXISTS bookstore;
USE bookstore;

-- ALTER TABLE Book
-- DROP FOREIGN KEY book_ibfk_1;

DROP TABLE IF EXISTS Client CASCADE;
DROP TABLE IF EXISTS Book CASCADE;

-- Create the 'Client' table
CREATE TABLE Client (
    ClientID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Document VARCHAR(255)
);

-- Create the 'Book' table
CREATE TABLE Book (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    Year INT NOT NULL,
    Publisher VARCHAR(255) NOT NULL,
    Genre VARCHAR(255) NOT NULL,
    Status ENUM('new', 'semi-used', 'used') NOT NULL,
    Weight DECIMAL(10, 2) NOT NULL,
    NumPages INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    ClientID INT,
    FOREIGN KEY (ClientID) REFERENCES Client(ClientID)
);

-- Insert data into the 'Client' table
INSERT INTO Client (Name, Address, DateOfBirth, Document) VALUES
('Alice Johnson', '123 Main St', '1990-05-15', 'ABC123456'),
('Bob Smith', '456 Elm St', '1985-08-20', 'XYZ789012'),
('Carol Davis', '789 Oak St', '1978-03-10', NULL),
('David Wilson', '101 Pine St', '1995-11-25', 'DEF345678'),
('Eva Brown', '222 Cedar St', '1980-07-03', 'GHI901234'),
('Frank Miller', '333 Maple St', '1992-01-15', 'JKL567890'),
('Grace Lee', '444 Birch St', '1987-09-08', 'MNO123456'),
('Helen Clark', '555 Redwood St', '1998-04-30', NULL),
('Ian White', '666 Sequoia St', '1983-12-22', 'PQR789012'),
('John Turner', '777 Sycamore St', '1993-06-05', 'STU345678');

-- Insert data into the 'Book' table
INSERT INTO Book (Name, Author, Year, Publisher, Genre, Status, Weight, NumPages, Price, ClientID) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, 'Scribner', 'Classics', 'new', 1.8, 180, 11.50, 3),
('To Kill a Mockingbird', 'Harper Lee', 1960, 'HarperCollins', 'Fiction', 'semi-used', 1.5, 281, 12.99, 1),
('1984', 'George Orwell', 1949, 'Penguin Books', 'Dystopian', 'used', 1.2, 328, 9.95, 2),
('The Catcher in the Rye', 'J.D. Salinger', 1951, 'Little, Brown', 'Coming-of-age', 'new', 1.4, 214, 13.25, 4),
('Pride and Prejudice', 'Jane Austen', 1813, 'Penguin Classics', 'Romance', 'new', 1.6, 336, 7.99, 5),
('The Hobbit', 'J.R.R. Tolkien', 1937, 'Houghton Mifflin', 'Fantasy', 'semi-used', 1.3, 320, 19.99, 1),
('The Da Vinci Code', 'Dan Brown', 2003, 'Doubleday', 'Mystery', 'used', 1.1, 454, 14.75, 6),
('The Girl on the Train', 'Paula Hawkins', 2015, 'Riverhead Books', 'Thriller', 'used', 1.2, 323, 10.99, 2),
('Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 2011, 'Harper', 'History', 'new', 1.7, 443, 22.00, 7),
('The Martian', 'Andy Weir', 2011, 'Crown Publishing', 'Science Fiction', 'semi-used', 1.5, 369, 16.75, 8);