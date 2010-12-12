create table if not exists user_group (
  group_id int(11) not null auto_increment,
  group_name varchar(40) not null,
  update_date datetime not null,
  primary key (group_id)
) engine=innodb auto_increment=1 default charset=utf8
;

create table if not exists user (
  user_id int(11) not null auto_increment,
  group_id int(11) not null,
  user_name varchar(40) not null,
  update_date datetime not null,
  primary key (user_id),
  index user_idx_01 (user_name),
  constraint user_fk_01 foreign key (group_id) references user_group (group_id)
) engine=innodb auto_increment=1 default charset=utf8
;