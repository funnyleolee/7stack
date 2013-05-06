CREATE TABLE
IF NOT EXISTS comments (
    comment_id INTEGER PRIMARY KEY auto_increment,
    content VARCHAR (200),
    user_id INTEGER,
    post_id INTEGER,
    create_time BIGINT,
    update_time BIGINT
) ENGINE = INNODB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;
ALTER TABLE comments CHANGE id comment_id INTEGER;