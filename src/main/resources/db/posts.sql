CREATE TABLE
IF NOT EXISTS posts(
post_id INTEGER primary key auto_increment,
title varchar(200)   default null,
content text  default null,
author_id INTEGER default null,
visits_num INTEGER  default 0,
fav_num INTEGER  default 0,
status tinyint(1) zerofill NULL DEFAULT 0,
create_time BIGINT ,
update_time BIGINT 
)ENGINE=InnoDB  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;