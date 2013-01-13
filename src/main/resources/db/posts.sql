create table posts(
id integer primary key auto_increment,
name varchar(200) default '',
content text default '',
author_id integer,
author_name varchar(200) default '',
visits_num integer default 0,
fav_num integer default 0,
create_time integer not null,
update_time integer not null
)
engine=innodb;
