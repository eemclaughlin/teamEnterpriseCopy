-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-13 11:22:00.322

-- foreign keys
ALTER TABLE books
    DROP FOREIGN KEY books_users;

-- tables
DROP TABLE books;

DROP TABLE users;

-- End of file.

