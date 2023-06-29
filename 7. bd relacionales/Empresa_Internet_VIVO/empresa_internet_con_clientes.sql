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

-- Datos de prueba adicionales para la tabla Cliente
use empresa_internet;
INSERT INTO Cliente (Id, Dni, Nombre, Apellido, Fecha_Nacimiento, Provincia, Ciudad)
VALUES
  (1, 12345678, 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'Capital Federal'),
  (2, 98765432, 'María', 'Gómez', '1985-07-20', 'Córdoba', 'Córdoba'),
  (3, 45678912, 'Carlos', 'López', '1995-03-10', 'Santa Fe', 'Rosario'),
  (4, 65432109, 'Laura', 'García', '1992-06-25', 'Buenos Aires', 'La Plata'),
  (5, 78901234, 'Pedro', 'Rodríguez', '1988-09-10', 'Córdoba', 'Villa María'),
  (6, 23456789, 'Ana', 'Fernández', '1996-12-03', 'Santa Fe', 'Santa Fe'),
  (7, 90123456, 'Martín', 'López', '1993-03-18', 'Buenos Aires', 'Morón'),
  (8, 34567890, 'Carolina', 'Martínez', '1990-11-20', 'Córdoba', 'Río Cuarto'),
  (9, 87654321, 'Lucas', 'González', '1987-08-05', 'Buenos Aires', 'Tigre'),
  (10, 43210987, 'Marcela', 'Díaz', '1994-04-12', 'Santa Fe', 'Rosario');
-- Datos de prueba adicionales para la tabla Plan
INSERT INTO Servicio
VALUES
  (1, 50, 39.99, 0),
  (2, 100, 59.99, 0),
  (3, 200, 79.99, 10),
  (4, 150, 49.99, 0),
  (5, 300, 89.99, 5);
-- Datos de prueba adicionales para la tabla Contrato
INSERT INTO Cliente_Servicio
VALUES
  (1, 1, 1),
  (2, 1, 3),
  (3, 2, 2),
  (4, 3, 3),
  (5, 4, 4),
  (6, 5, 5),
  (7, 6, 1),
  (8, 7, 2),
  (9, 8, 3),
  (10, 9, 4);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
