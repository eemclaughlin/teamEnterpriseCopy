-- foreign keys
ALTER TABLE users_books
    DROP FOREIGN KEY Table_3_books;

ALTER TABLE users_books
    DROP FOREIGN KEY Table_3_users;

-- tables
DROP TABLE users_books;

DROP TABLE books;

DROP TABLE users;