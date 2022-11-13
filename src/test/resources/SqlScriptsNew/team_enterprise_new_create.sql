-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-13 11:22:00.322

-- tables
-- Table: books
CREATE TABLE books (
    id bigint NOT NULL AUTO_INCREMENT,
    isbnTen varchar(20) NULL,
    isbnThirteen varchar(20) NULL,
    title varchar(100) NOT NULL,
    author varchar(50) NULL,
    description text NULL,
    location varchar(50) NULL,
    publisher varchar(100) NULL,
    publishedDate date NULL,
    pageCount varchar(100) NULL,
    language varchar(5) NULL,
    smallImageLink varchar(1024) NULL,
    medImageLink varchar(1024) NULL,
    users_id bigint NULL,
    CONSTRAINT books_pk PRIMARY KEY (id)
);

-- Table: users
CREATE TABLE users (
    id bigint NOT NULL AUTO_INCREMENT,
    cardNumber bigint NOT NULL,
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    email varchar(75) NOT NULL,
    phone varchar(20) NOT NULL,
    UNIQUE INDEX users_ak_1 (cardNumber),
    CONSTRAINT users_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: books_users (table: books)
ALTER TABLE books ADD CONSTRAINT books_users FOREIGN KEY books_users (users_id)
    REFERENCES users (id);

-- End of file.

