CREATE DATABASE IF NOT EXISTS `team_enterprise_new` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT ENCRYPTION='N';

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;

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

INSERT INTO team_enterprise_new.users (id, cardNumber, firstName, lastName, email, phone) VALUES (1, 123, 'Johnny', 'Cash', 'jcash@yahoo.com', 5551234);
INSERT INTO team_enterprise_new.users (id, cardNumber, firstName, lastName, email, phone) VALUES (2, 456, 'Bob', 'Hamelin', 'bobh@yahoo.com', 5555678);
INSERT INTO team_enterprise_new.users (id, cardNumber, firstName, lastName, email, phone) VALUES (3, 789, 'Peggy', 'Curbs', 'pcurbs@gmail.com', 5551357);
INSERT INTO team_enterprise_new.users (id, cardNumber, firstName, lastName, email, phone) VALUES (4, 086, 'Bill', 'Nye', 'billnye@scienceguy.com', 5559876);
INSERT INTO team_enterprise_new.books (id, isbnTen, isbnThirteen, title, author, description, pageCount, users_id) VALUES (1, '1234567890', '1234567890123', 'Cool Book 1', 'Tiberius Kirk', 'Book about stuff', 199, 1);
INSERT INTO team_enterprise_new.books (id, isbnTen, title, author, description, pageCount, users_id) VALUES (2, '0987654321', 'Awesome Book', 'Capt Picard', 'Interesting Read', 1001, 1);
INSERT INTO team_enterprise_new.books (id, isbnThirteen, title, author) VALUES (3, '0987654321123', 'Book 3', 'Capt Archer');
-- End of file.