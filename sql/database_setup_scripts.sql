drop database inferneon;

create database inferneon;

use inferneon;

-- --
-- Table structure for table `USERS`
--
CREATE TABLE IF NOT EXISTS `users` (id int(10) NOT NULL AUTO_INCREMENT,
uuid varchar(255) NOT NULL,
username varchar(255) NOT NULL,
email varchar(255) NOT NULL,
crypted_password varchar(40) NOT NULL,
salt varchar(40) NOT NULL,
first_name varchar(255) DEFAULT NULL,
last_name varchar(255) DEFAULT NULL,
created_at datetime DEFAULT NULL,
updated_at datetime DEFAULT NULL,
user_type varchar(1) DEFAULT NULL,
user_group varchar(40) DEFAULT NULL,
active varchar(1) DEFAULT NULL,
added_by_user_id int(10) DEFAULT NULL,
address_one varchar(255) DEFAULT NULL,
address_two varchar(255) DEFAULT NULL,
city varchar(40) DEFAULT NULL,
state varchar(40) DEFAULT NULL,
country varchar(40) DEFAULT NULL,
postalcode varchar(10) DEFAULT NULL,
security_question varchar(255) DEFAULT NULL,
security_answer varchar(255),
timezone varchar(255),
personal_phone varchar(40),
work_phone varchar(40),
personal_fax varchar(40),
work_fax varchar(40),
comments varchar(255),

PRIMARY KEY (`ID`)

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into users values(1001, '1001', 'boomerang', 'boomerang@gmail.com','boomerang', '', '', '', null, null, 'U','U', 'A', 1001, '','','','','','','','','','','','','','');

					