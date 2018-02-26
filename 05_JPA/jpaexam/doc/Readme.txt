CREATE TABLE board (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  content text,
  regdate datetime,
  read_count int,
  PRIMARY KEY (id)
);


CREATE TABLE log (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  ip varchar(255) NOT NULL,
  method varchar(10) NOT NULL,
  regdate datetime,
  PRIMARY KEY (id)
);

