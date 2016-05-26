CREATE SCHEMA IF NOT EXISTS `cinema_database` ;

drop table if exists`cinema_database`.`movie`;
drop table if exists`cinema_database`.`user`;
drop table if exists`cinema_database`.`cinema`;
drop table if exists`cinema_database`.`orders`;
drop table if exists`cinema_database`.`session`;
drop table if exists`cinema_database`.`ticket`;
drop table if exists`cinema_database`.`seat`;

CREATE TABLE `cinema_database`.`movie` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `movieName` VARCHAR(45) NOT NULL ,
  `url` TEXT DEFAULT NULL ,
  `introduction` TEXT DEFAULT NULL ,
  `score` FLOAT NOT NULL ,
  `start_time` LONG NOT NULL,
  `end_time` LONG NOT NULL,
  `type` TEXT,
  `director` TEXT NOT NULL,
  `actor` TEXT NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE `cinema_database`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `telephone` VARCHAR(11) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cinema_database`.`cinema` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `cinemaName` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cinema_database`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `userID` INT NOT NULL ,
  `cinemaID` INT NOT NULL ,
  `time` LONG NOT NULL ,
  `prices` FLOAT NOT NULL ,
  /*0代表已付款，1代表未付款，2代表已失效*/
  `state` enum('0', '1', '2') NOT NULL, 
  PRIMARY KEY(`id`),
  CONSTRAINT `user_orders_id`
    FOREIGN KEY(`userID`)
    REFERENCES `cinema_database`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE ,
  CONSTRAINT `cinema_orders_id`
    FOREIGN KEY(`cinemaID`)
    REFERENCES `cinema_database`.`cinema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cinema_database`.`session` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `cinemaID` INT NOT NULL ,
  `hall` INT NOT NULL ,
  `movieName` VARCHAR(45) NOT NULL ,
  `start_time` LONG NOT NULL ,
  `end_time` LONG NOT NULL ,
  `language` VARCHAR(45) NOT NULL ,
  `price` FLOAT NOT NULL ,
  PRIMARY KEY(`id`) ,
  CONSTRAINT `cinema_session_id`
    FOREIGN KEY (`cinemaID`)
    REFERENCES `cinema_database`.`cinema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cinema_database`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `orderID` INT NOT NULL ,
  `seat` INT NOT NULL ,
  `price` FLOAT NOT NULL ,
  `sessionID` INT NOT NULL ,
  PRIMARY KEY(`id`) ,
  CONSTRAINT `order_ticket_id`
    FOREIGN KEY (`orderID`)
    REFERENCES `cinema_database`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE ,
  CONSTRAINT `session_ticket_id`
    FOREIGN KEY (`sessionID`)
    REFERENCES `cinema_database`.`session` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cinema_database`.`seat` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `sessionID` INT NOT NULL ,
  `sold_list` TEXT DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `session_seat_id`
    FOREIGN KEY (`sessionID`)
    REFERENCES `cinema_database`.`session` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
