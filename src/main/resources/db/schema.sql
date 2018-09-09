create table Todo
(
  id integer not null auto_increment,
  title varchar(60) not null,
  desc varchar(255),
  primary key (id)
);

create table Account
(
  id integer not null auto_increment,
  username varchar(60) not null,
  password varchar(255) not null,
  token varchar(64),
  primary key (id)
);
