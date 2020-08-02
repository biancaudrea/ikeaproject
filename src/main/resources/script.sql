-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `project` ;

-- -----------------------------------------------------
-- Table `project`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`room` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`category` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `room_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKoyp748low3567crsdk0s3qt9i` (`room_id` ASC) VISIBLE,
  CONSTRAINT `FKoyp748low3567crsdk0s3qt9i`
    FOREIGN KEY (`room_id`)
    REFERENCES `project`.`room` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`user` (
  `id` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `date_of_birth` VARCHAR(255) NULL DEFAULT NULL,
  `date_of_registration` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project`.`order_placed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`order_placed` (
  `id` INT(11) NOT NULL,
  `date_of_creation` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKnrct1eiqxbadc8ra6fe658an1` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKnrct1eiqxbadc8ra6fe658an1`
    FOREIGN KEY (`user_id`)
    REFERENCES `project`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project`.`object`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`object` (
  `id` INT(11) NOT NULL,
  `manufacturer` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  `order_placed_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK9j4go4k5m0i9lvdx62l3m6lrg` (`category_id` ASC) VISIBLE,
  INDEX `FK1v9a45yl8vda33bo4nhigxt74` (`order_placed_id` ASC) VISIBLE,
  CONSTRAINT `FK1v9a45yl8vda33bo4nhigxt74`
    FOREIGN KEY (`order_placed_id`)
    REFERENCES `project`.`order_placed` (`id`),
  CONSTRAINT `FK9j4go4k5m0i9lvdx62l3m6lrg`
    FOREIGN KEY (`category_id`)
    REFERENCES `project`.`category` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT:
insert into user ( address,age,date_of_birth,date_of_registration,email,first_name,last_name,password ,type,username,phone_number) values ('Socului 99','03.04.1998','12.04.2020', 'bianca.udrea@gmail.com','Bianca','Udrea','biancaudrea',0,'biancaudrea','0756722983');

insert into order_placed(price,date_of_creation) values (1288,'10.05.2020');

insert into room(id,name) values (3,'Bedroom');

insert into category(id,room_id,name) values (4,3,'Bed');

insert into object(category_id,manufacturer,name,price) values (4,'Platska','Platska White Frame Bed',1399);