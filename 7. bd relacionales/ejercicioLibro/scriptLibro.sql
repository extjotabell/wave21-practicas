-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Bibliotecadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Bibliotecadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Bibliotecadb` DEFAULT CHARACTER SET utf8 ;
USE `Bibliotecadb` ;

-- -----------------------------------------------------
-- Table `Bibliotecadb`.`LIBRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bibliotecadb`.`LIBRO` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(255) NOT NULL,
  `Editorial` VARCHAR(255) NOT NULL,
  `Area` INT NOT NULL,
  PRIMARY KEY (`idLibro`));


-- -----------------------------------------------------
-- Table `Bibliotecadb`.`AUTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bibliotecadb`.`AUTOR` (
  `IdAutor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(60) NOT NULL,
  `Nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdAutor`));


-- -----------------------------------------------------
-- Table `Bibliotecadb`.`LIBROAUTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bibliotecadb`.`LIBROAUTOR` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `LIBRO_idLibro` INT NOT NULL,
  `AUTOR_IdAutor` INT NOT NULL,
  INDEX `fk_LIBROAUTOR_LIBRO1_idx` (`LIBRO_idLibro` ASC) VISIBLE,
  INDEX `fk_LIBROAUTOR_AUTOR1_idx` (`AUTOR_IdAutor` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_LIBROAUTOR_LIBRO1`
    FOREIGN KEY (`LIBRO_idLibro`)
    REFERENCES `Bibliotecadb`.`LIBRO` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIBROAUTOR_AUTOR1`
    FOREIGN KEY (`AUTOR_IdAutor`)
    REFERENCES `Bibliotecadb`.`AUTOR` (`IdAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Bibliotecadb`.`ESTUDIANTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bibliotecadb`.`ESTUDIANTE` (
  `IdLector` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(60) NOT NULL,
  `Apellido` VARCHAR(60) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Carrera` VARCHAR(45) NOT NULL,
  `Edad` INT NOT NULL,
  PRIMARY KEY (`IdLector`));


-- -----------------------------------------------------
-- Table `Bibliotecadb`.`PRESTAMO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bibliotecadb`.`PRESTAMO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FechaPrestamo` DATE NOT NULL,
  `FechaDevolucion` DATE NOT NULL,
  `Devuelto` TINYINT NOT NULL DEFAULT 0,
  `LIBRO_idLibro` INT NOT NULL,
  `ESTUDIANTE_IdLector` INT NOT NULL,
  INDEX `fk_PRESTAMO_LIBRO_idx` (`LIBRO_idLibro` ASC) VISIBLE,
  INDEX `fk_PRESTAMO_ESTUDIANTE1_idx` (`ESTUDIANTE_IdLector` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_PRESTAMO_LIBRO`
    FOREIGN KEY (`LIBRO_idLibro`)
    REFERENCES `Bibliotecadb`.`LIBRO` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRESTAMO_ESTUDIANTE1`
    FOREIGN KEY (`ESTUDIANTE_IdLector`)
    REFERENCES `Bibliotecadb`.`ESTUDIANTE` (`IdLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
