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
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente` (
  `Id` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `Dni` VARCHAR(45) NULL,
  `Fecha_Nacimiento` DATETIME NULL,
  `Provincia` VARCHAR(45) NULL,
  `Ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Servicio` (
  `Id` INT NOT NULL,
  `Velocidad` INT NULL,
  `Precio` DECIMAL(2) NULL,
  `Descuento` INT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Cliente_Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente_Servicio` (
  `idCliente_Servicio` INT NOT NULL,
  `idCliente` INT NULL,
  `idServicio` INT NULL,
  PRIMARY KEY (`idCliente_Servicio`),
  INDEX `idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `idServicio_idx` (`idServicio` ASC) VISIBLE,
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `empresa_internet`.`Cliente` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idServicio`
    FOREIGN KEY (`idServicio`)
    REFERENCES `empresa_internet`.`Servicio` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
