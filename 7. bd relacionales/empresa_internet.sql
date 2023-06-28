-- MySQL Script generated by MySQL Workbench
-- Wed Jun 28 12:55:26 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(16) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(32) NULL,
  `fechaNac` DATE NULL,
  `provincia` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`));


-- -----------------------------------------------------
-- Table `empresa_internet`.`Plan_Internet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`Plan_Internet` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`Plan_Internet` (
  `idPlan` INT NOT NULL AUTO_INCREMENT,
  `nombrePlan` VARCHAR(45) NULL,
  `velodidadEnMb` FLOAT NULL,
  `precio` FLOAT NULL,
  `descuento` FLOAT NULL,
  PRIMARY KEY (`idPlan`));


-- -----------------------------------------------------
-- Table `empresa_internet`.`Cliente_has_Plan_Internet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empresa_internet`.`Cliente_has_Plan_Internet` ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente_has_Plan_Internet` (
  `Cliente_idCliente` INT NOT NULL,
  `Plan_Internet_idPlan` INT NOT NULL,
  PRIMARY KEY (`Cliente_idCliente`, `Plan_Internet_idPlan`),
  INDEX `fk_Cliente_has_Plan_Internet_Plan_Internet1_idx` (`Plan_Internet_idPlan` ASC) VISIBLE,
  INDEX `fk_Cliente_has_Plan_Internet_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_has_Plan_Internet_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `empresa_internet`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_has_Plan_Internet_Plan_Internet1`
    FOREIGN KEY (`Plan_Internet_idPlan`)
    REFERENCES `empresa_internet`.`Plan_Internet` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
