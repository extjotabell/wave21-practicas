-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libro` (
  `idlibro` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `editorial` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  PRIMARY KEY (`idlibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`autor` (
  `idautor` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idautor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`libroautor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libroautor` (
  `libro_idlibro` INT NOT NULL,
  `autor_idautor` INT NOT NULL,
  PRIMARY KEY (`libro_idlibro`, `autor_idautor`),
  INDEX `fk_libro_has_autor_autor1_idx` (`autor_idautor` ASC) VISIBLE,
  INDEX `fk_libro_has_autor_libro_idx` (`libro_idlibro` ASC) VISIBLE,
  CONSTRAINT `fk_libro_has_autor_libro`
    FOREIGN KEY (`libro_idlibro`)
    REFERENCES `biblioteca`.`libro` (`idlibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_has_autor_autor1`
    FOREIGN KEY (`autor_idautor`)
    REFERENCES `biblioteca`.`autor` (`idautor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`estudiante` (
  `idLector` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `carrera` VARCHAR(45) NULL,
  `edad` INT NULL,
  PRIMARY KEY (`idLector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamo` (
  `idLibro` INT NOT NULL,
  `idLector` INT NOT NULL,
  `fechaPrestamo` DATETIME NULL,
  `fechaDevolucion` DATETIME NULL,
  `devuelto` TINYINT NULL,
  PRIMARY KEY (`idLibro`, `idLector`),
  INDEX `fk_libro_has_estudiante_estudiante1_idx` (`idLector` ASC) VISIBLE,
  INDEX `fk_libro_has_estudiante_libro1_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_libro_has_estudiante_libro1`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`libro` (`idlibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_has_estudiante_estudiante1`
    FOREIGN KEY (`idLector`)
    REFERENCES `biblioteca`.`estudiante` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERCIONES

-- Inserciones en la tabla "autor"
INSERT INTO autor (idautor, nombre, nacionalidad) VALUES (1, 'Gabriel García Márquez', 'Colombiana');
INSERT INTO autor (idautor, nombre, nacionalidad) VALUES  (2, 'Antoine Farmer', 'Francesa');
INSERT INTO autor (idautor, nombre, nacionalidad) VALUES  (3, 'Jorge Luis Borges', 'Argentina'); 
INSERT INTO autor (idautor, nombre, nacionalidad) VALUES  (4, 'J.K. Rowling', 'Británica'); 
INSERT INTO autor (idautor, nombre, nacionalidad) VALUES  (5, 'Pablo Goretti', 'Italiana');

-- Inserciones en la tabla "libro"
INSERT INTO libro (idlibro, titulo, editorial, area) VALUES (1, 'Cien años de soledad', 'Editorial Sudamericana', 'Ficción');
INSERT INTO libro (idlibro, titulo, editorial, area) VALUES (2, 'La ciudad y los perros', 'Seix Barral', 'Ficción');
INSERT INTO libro (idlibro, titulo, editorial, area) VALUES (3, 'El Aleph', 'Emecé Editores', 'Base de Datos');
INSERT INTO libro (idlibro, titulo, editorial, area) VALUES (4, 'La casa de los espíritus', 'Plaza & Janés', 'Internet');
INSERT INTO libro (idlibro, titulo, editorial, area) VALUES (5, 'El laberinto de la soledad', 'Salamandra', 'Ensayo');
INSERT INTO libro (idlibro, titulo, editorial, area) VALUES (6, 'El Universo: Guía de viaje', 'Seix Barral', 'Ficción');

-- Inserciones en la tabla "libroautor"
INSERT INTO libroautor (libro_idlibro, autor_idautor) VALUES (1, 1),(2, 2),(3, 3),(4, 4),(5, 5),(6,2);

-- Inserciones en la tabla "estudiante"
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (1, 'Juan', 'Pérez', 'Calle Principal 123', 'Ingeniería', 20);
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (2, 'María', 'Gómez', 'Avenida Central 456', 'Medicina', 22); 
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (3, 'Filippo', 'Galli', 'Calle Secundaria 789', 'Informática', 21); 
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (4, 'Laura', 'Torres', 'Avenida Principal 987', 'Arquitectura', 23);
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES (5, 'Pedro', 'Sánchez', 'Calle Central 654', 'Economía', 24);

-- Inserciones en la tabla "préstamo"
INSERT INTO prestamo (idLibro, idLector, fechaPrestamo, fechaDevolucion, devuelto) VALUES (1, 1, '2023-06-20', '2023-07-10', 1),
(2, 2, '2023-06-22', '2023-07-05', 1),
(3, 3, '2023-06-25', '2023-07-02', 1),
(4, 4, '2023-06-27', '2023-07-09', 0),
(5, 5, '2023-06-30', '2023-07-07', 1),
(1, 2, '2023-07-02', '2023-07-09', 1),
(2, 3, '2023-07-04', '2023-07-11', 0),
(3, 4, '2023-07-07', '2023-07-14', 0),
(4, 5, '2023-07-09', '2021-07-16', 1),
(5, 1, '2023-07-11', '2023-07-18', 0);

-- CONSULTAS

-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre,edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera='Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad='Francesa' or nacionalidad='Italiana';

-- ¿Qué libros no son del área de internet?
select * from libro where area='Internet';

-- Listar los libros de la editorial Salamandra.
select * from libro where editorial like 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad>(select SUM(edad)/COUNT(*) as sumaEdad from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select * from estudiante where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre
from autor as a
join libroautor as la
join libro as l
on a.idautor=la.autor_idautor and l.idlibro=la.libro_idlibro
where l.titulo='El Universo: Guía de viaje';


-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.titulo
from prestamo as p
join estudiante as e
join libro as l
on p.idLector=e.idLector and p.idLibro=l.idLibro
where e.nombre like 'Filippo' and e.apellido like 'Galli'
group by l.titulo;

-- Listar el nombre del estudiante de menor edad.
select min(edad) from estudiante;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre
from prestamo as p
join estudiante as e
join libro as l
on p.idLector=e.idLector and p.idLibro=l.idLibro
where l.area='Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.titulo
from libro as l
join autor as a
join libroautor la
on l.idlibro=la.libro_idlibro and la.autor_idautor=a.idautor
where a.nombre='J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo
from libro as l
join prestamo as p
on l.idlibro=p.idlibro
where p.fechaDevolucion='2021-07-16';
