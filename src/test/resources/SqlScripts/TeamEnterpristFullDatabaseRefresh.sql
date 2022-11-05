-- foreign keys
ALTER TABLE users_books
    DROP FOREIGN KEY Table_3_books;
ALTER TABLE users_books
    DROP FOREIGN KEY Table_3_users;

-- drop tables
DROP TABLE users_books;
DROP TABLE books;
DROP TABLE users;

-- create tables
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
                       pageCount int NULL,
                       language varchar(5) NULL,
                       smallImageLink varchar(1024) NULL,
                       medImageLink varchar(1024) NULL,
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

-- Table: users_books
CREATE TABLE users_books (
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

-- DATA REFRESH STUFF
INSERT INTO TeamEnterprise.users (id, cardNumber, firstName, lastName, email, phone) VALUES (1, 123, 'Johnny', 'Cash', 'jcash@yahoo.com', 5551234);
INSERT INTO TeamEnterprise.users (id, cardNumber, firstName, lastName, email, phone) VALUES (2, 456, 'Bob', 'Hamelin', 'bobh@yahoo.com', 5555678);
INSERT INTO TeamEnterprise.users (id, cardNumber, firstName, lastName, email, phone) VALUES (3, 789, 'Peggy', 'Curbs', 'pcurbs@gmail.com', 5551357);
INSERT INTO TeamEnterprise.users (id, cardNumber, firstName, lastName, email, phone) VALUES (4, 086, 'Bill', 'Nye', 'billnye@scienceguy.com', 5559876);
INSERT INTO TeamEnterprise.books (id, isbnTen, isbnThirteen, title, author, description, pageCount) VALUES (1, '1234567890', '1234567890123', 'Cool Book 1', 'Tiberius Kirk', 'Book about stuff', 199);
INSERT INTO TeamEnterprise.books (id, isbnTen, title, author, description, pageCount) VALUES (2, '0987654321', 'Awesome Book', 'Capt Picard', 'Interesting Read', 1001);
INSERT INTO TeamEnterprise.books (id, isbnThirteen, title, author) VALUES (3, '0987654321123', 'Book 3', 'Capt Archer');
INSERT INTO TeamEnterprise.users_books (users_id, books_id) VALUES (1, 2);
INSERT INTO TeamEnterprise.users_books (users_id, books_id) VALUES (1, 1);
INSERT INTO TeamEnterprise.users_books (users_id, books_id) VALUES (4, 3);
-- End of file.