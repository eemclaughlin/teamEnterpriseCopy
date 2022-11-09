CREATE DATABASE IF NOT EXISTS `team_enterprise` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT ENCRYPTION='N';

DROP TABLE IF EXISTS users_books;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;

-- tables
-- Table: books
CREATE TABLE books (
                       id bigint NOT NULL,
                       isbnTen varchar(20) NOT NULL,
                       isbnThirteen varchar(20) NOT NULL,
                       title varchar(100) NOT NULL,
                       author varchar(50) NOT NULL,
                       description text NOT NULL,
                       location varchar(50) NOT NULL,
                       publisher varchar(100) NOT NULL,
                       publishedDate date NOT NULL,
                       pageCount int NOT NULL,
                       language varchar(5) NOT NULL,
                       smallImageLink varchar(1024) NOT NULL,
                       medImageLink varchar(1024) NOT NULL,
                       CONSTRAINT books_pk PRIMARY KEY (id)
);

-- Table: users
CREATE TABLE IF NOT EXISTS users (
                                     id bigint NOT NULL,
                                     cardNumber bigint NOT NULL,
                                     firstName varchar(30) NOT NULL,
                                     lastName varchar(30) NOT NULL,
                                     email varchar(75) NOT NULL,
                                     phone varchar(20) NOT NULL,
                                     UNIQUE INDEX users_ak_1 (cardNumber),
                                     CONSTRAINT users_pk PRIMARY KEY (id)
);

-- Table: users_books
CREATE TABLE IF NOT EXISTS users_books (
                                           users_id bigint NOT NULL,
                                           books_id bigint NOT NULL,
                                           CONSTRAINT users_books_pk PRIMARY KEY (users_id,books_id)
);

-- foreign keys
-- Reference: Table_3_books (table: users_books)
ALTER TABLE users_books ADD CONSTRAINT Table_3_books FOREIGN KEY Table_3_books (books_id)
    REFERENCES books (id);

-- Reference: Table_3_users (table: users_books)
ALTER TABLE users_books ADD CONSTRAINT Table_3_users FOREIGN KEY Table_3_users (users_id)
    REFERENCES users (id);