CREATE TABLE
IF NOT EXISTS users (
    user_id INTEGER PRIMARY KEY auto_increment,
    user_name VARCHAR (200),
    PASSWORD VARCHAR (200),
    email VARCHAR (100),
    address VARCHAR (200),
    mobile VARCHAR (50),
    telephone VARCHAR (50),
    sns VARCHAR (100),
    create_time INTEGER,
    update_time INTEGER
) ENGINE = INNODB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

--ALTER TABLE users CHANGE id user_id INTEGER;