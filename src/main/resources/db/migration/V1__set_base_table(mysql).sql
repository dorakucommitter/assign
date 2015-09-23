-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema assign
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema assign
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `assign` DEFAULT CHARACTER SET utf8 ;
USE `assign` ;

-- -----------------------------------------------------
-- Table `assign`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`employee` (
  `employee_id` INT(11) NOT NULL AUTO_INCREMENT,
  `employee_code` CHAR(6) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `nickname` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` DATE NULL,
  `gender` TINYINT(1) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` DATE NULL DEFAULT NULL,
  `leave_date` DATE NULL DEFAULT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `roll` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`) ,
  UNIQUE INDEX `EMPLOYEE_CODE_UNIQUE` (`employee_code` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `assign`.`qualification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`qualification` (
  `qualification_id` INT(11) NOT NULL,
  `qualification_section` CHAR(3) NOT NULL,
  `qualification_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`qualification_id`) ,
  UNIQUE INDEX `QUALIFICATION_SECTION_UNIQUE` (`qualification_section` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `assign`.`holding_qualification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`holding_qualification` (
  `employee_employee_id` INT(11) NOT NULL,
  `qualification_qualification_id` INT(11) NOT NULL,
  PRIMARY KEY (`employee_employee_id`, `qualification_qualification_id`) ,
  INDEX `fk_HOLDING_QUALIFICATION_EMPLOYEE_idx` (`employee_employee_id` ASC) ,
  INDEX `fk_HOLDING_QUALIFICATION_QUALIFICATION1_idx` (`qualification_qualification_id` ASC) ,
  CONSTRAINT `fk_HOLDING_QUALIFICATION_EMPLOYEE`
    FOREIGN KEY (`employee_employee_id`)
    REFERENCES `assign`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HOLDING_QUALIFICATION_QUALIFICATION1`
    FOREIGN KEY (`qualification_qualification_id`)
    REFERENCES `assign`.`qualification` (`qualification_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
