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
-- Table `assign`.`field`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`field` (
  `field_id` INT(11) NOT NULL,
  `field_name` VARCHAR(40) NULL,
  PRIMARY KEY (`field_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `assign`.`qualification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`qualification` (
  `qualification_id` INT(11) NOT NULL,
  `qualification_name` VARCHAR(40) NOT NULL,
  `field_id` INT NOT NULL,
  PRIMARY KEY (`qualification_id`) ,
  INDEX `fk_qualification_field1_idx` (`field_id` ASC),
  CONSTRAINT `fk_qualification_field1`
    FOREIGN KEY (`field_id`)
    REFERENCES `assign`.`field` (`field_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `assign`.`holding_qualification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`holding_qualification` (
  `employee_id` INT(11) NOT NULL,
  `qualification_id` INT(11) NOT NULL,
  `date_of_acquisition` DATE,
  `years_of_experience` INT(2),
  PRIMARY KEY (`employee_id`, `qualification_id`) ,
  INDEX `fk_HOLDING_QUALIFICATION_EMPLOYEE_idx` (`employee_id` ASC) ,
  INDEX `fk_HOLDING_QUALIFICATION_QUALIFICATION1_idx` (`qualification_id` ASC) ,
  CONSTRAINT `fk_HOLDING_QUALIFICATION_EMPLOYEE`
    FOREIGN KEY (`employee_id`)
    REFERENCES `assign`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HOLDING_QUALIFICATION_QUALIFICATION1`
    FOREIGN KEY (`qualification_id`)
    REFERENCES `assign`.`qualification` (`qualification_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `assign`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`project` (
  `project_id` INT NOT NULL ,
  `project_name` VARCHAR(45) NULL ,
  `start_of_project` DATE NULL ,
  `end_of_project` DATE NULL ,
  `wanted_start` DATE NULL ,
  `wanted_end` DATE NULL ,
  `outline` VARCHAR(128) NULL ,
  `scale` VARCHAR(45) NULL ,
  PRIMARY KEY (`project_id`)  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `assign`.`request_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`request_skills` (
  `request_skills_id` INT NOT NULL ,
  `qualification_id` INT NOT NULL ,
  `project_id` INT NOT NULL ,
  PRIMARY KEY (`request_skills_id`, `qualification_id`, `project_id`)  ,
  INDEX `fk_request_skills_qualification1_idx` (`qualification_id` ASC)  ,
  INDEX `fk_request_skills_project1_idx` (`project_id` ASC)  ,
  CONSTRAINT `fk_request_skills_qualification1`
    FOREIGN KEY (`qualification_id`)
    REFERENCES `assign`.`qualification` (`qualification_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_skills_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `assign`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `assign`.`engaged_in`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assign`.`engaged_in` (
  `engaged_in_id` INT NOT NULL ,
  `engaged_in_start` DATE NULL ,
  `engaged_in_end` DATE NULL ,
  `exit_prospects` DATE NULL ,
  `employee_id` INT NOT NULL ,
  `project_id` INT NOT NULL ,
  PRIMARY KEY (`engaged_in_id`, `employee_id`, `project_id`)  ,
  INDEX `fk_engaged_in_employee1_idx` (`employee_id` ASC)  ,
  INDEX `fk_engaged_in_project1_idx` (`project_id` ASC)  ,
  CONSTRAINT `fk_engaged_in_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `assign`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_engaged_in_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `assign`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
