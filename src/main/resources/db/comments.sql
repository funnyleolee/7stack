CREATE TABLE
IF NOT EXISTS comments (
    id INTEGER PRIMARY KEY auto_increment,
    content VARCHAR (200),
    user_id INTEGER,
    post_id INTEGER,
    create_time BIGINT,
    update_time BIGINT
) ENGINE = INNODB;