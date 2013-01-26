CREATE TABLE
IF NOT EXISTS posts(
id INTEGER primary key auto_increment,
title varchar(200)   default null,
content text  default null,
author_id INTEGER default null,
author_name varchar(200)  default null,
visits_num INTEGER  default 0,
fav_num INTEGER  default 0,
create_time BIGINT ,
update_time BIGINT 
)ENGINE=InnoDB  DEFAULT CHARSET=utf8
