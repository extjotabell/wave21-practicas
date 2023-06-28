create database biblioteca;

CREATE TABLE `biblioteca`.`autor` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `biblioteca`.`libroautor` (
  `id` INT NOT NULL,
  `idautor` INT NULL,
  `idlibro` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `biblioteca`.`libro` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `editorial` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `biblioteca`.`prestamo` (
  `id` INT NOT NULL,
  `idlector` INT NULL,
  `idlibro` INT NULL,
  `fechaprestamo` DATETIME NULL,
  `fechadevolucion` DATETIME NULL,
  `devuelto` TINYINT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `biblioteca`.`estudiante` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `carrera` VARCHAR(45) NULL,
  `edad` INT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `biblioteca`.`autor` (`id`, `nombre`, `nacionalidad`) VALUES
(1, 'Gabriel García Márquez', 'Colombiana'),
(2, 'Jorge Luis Borges', 'Argentina'),
(3, 'Jane Austen', 'Inglesa'),
(4, 'Haruki Murakami', 'Japonesa'),
(5, 'Isabel Allende', 'Chilena'),
(6, 'Mario Vargas Llosa', 'Peruana'),
(7, 'Ernest Hemingway', 'Estadounidense'),
(8, 'Virginia Woolf', 'Británica'),
(9, 'Octavio Paz', 'Mexicana'),
(10, 'Emily Brontë', 'Inglesa');

INSERT INTO `biblioteca`.`libroautor` (`id`, `idautor`, `idlibro`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10);

INSERT INTO `biblioteca`.`libro` (`id`, `titulo`, `editorial`, `area`) VALUES
(1, 'Cien años de soledad', 'Sudamericana', 'Ficción'),
(2, 'El Aleph', 'Emece', 'Ficción'),
(3, 'Orgullo y prejuicio', 'Alianza Editorial', 'Ficción'),
(4, 'Tokio Blues', 'Tusquets Editores', 'Ficción'),
(5, 'La casa de los espíritus', 'Plaza & Janés', 'Ficción'),
(6, 'La ciudad y los perros', 'Alfaguara', 'Ficción'),
(7, 'El viejo y el mar', 'Scribner', 'Ficción'),
(8, 'La señora Dalloway', 'Hogarth Press', 'Ficción'),
(9, 'El laberinto de la soledad', 'Fondo de Cultura Económica', 'Ensayo'),
(10, 'Cumbres borrascosas', 'Penguin Classics', 'Ficción');

INSERT INTO `biblioteca`.`prestamo` (`id`, `idlector`, `idlibro`, `fechaprestamo`, `fechadevolucion`, `devuelto`) VALUES
(1, 1, 1, '2023-06-01 10:00:00', '2023-06-15 10:00:00', 1),
(2, 2, 2, '2023-06-02 09:30:00', '2023-06-16 09:30:00', 1),
(3, 3, 3, '2023-06-03 14:45:00', '2023-06-17 14:45:00', 1),
(4, 4, 4, '2023-06-04 11:20:00', '2023-06-18 11:20:00', 1),
(5, 5, 5, '2023-06-05 12:10:00', '2023-06-19 12:10:00', 1),
(6, 6, 6, '2023-06-06 15:00:00', '2023-06-20 15:00:00', 1),
(7, 7, 7, '2023-06-07 10:30:00', '2023-06-21 10:30:00', 1),
(8, 8, 8, '2023-06-08 09:15:00', '2023-06-22 09:15:00', 1),
(9, 9, 9, '2023-06-09 13:45:00', '2023-06-23 13:45:00', 1),
(10, 10, 10, '2023-06-10 11:40:00', '2023-06-24 11:40:00', 1);

INSERT INTO `biblioteca`.`estudiante` (`id`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES
(1, 'Juan', 'Gómez', 'Calle Principal 123', 'Informática', 21),
(2, 'María', 'Rodríguez', 'Avenida Central 456', 'Medicina', 22),
(3, 'Carlos', 'López', 'Calle Secundaria 789', 'Derecho', 20),
(4, 'Laura', 'García', 'Avenida Principal 234', 'Administración', 23),
(5, 'Pedro', 'Martínez', 'Calle Central 567', 'Ingeniería Civil', 24),
(6, 'Ana', 'Hernández', 'Avenida Secundaria 890', 'Psicología', 21),
(7, 'Luis', 'Fernández', 'Calle Principal 345', 'Arquitectura', 22),
(8, 'Sofía', 'Torres', 'Avenida Central 678', 'Economía', 20),
(9, 'Diego', 'Díaz', 'Calle Secundaria 901', 'Ciencias Políticas', 23),
(10, 'Carolina', 'Sánchez', 'Avenida Principal 456', 'Comunicación', 24);

-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre,edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera='Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad='Francesa' or nacionalidad='Italiana';

-- ¿Qué libros no son del área de internet?
select * from libro where not area='Internet';

-- Listar los libros de la editorial salamandra
select * from libro where editoril='Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad>(select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select * from estudiante where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select nombre 
from autor a join libroautor la on a.id=la.idautor join libro l on l.id=la.idlibro
where titulo='El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.* 
from libro l join prestamo p on p.idlibro=l.id join estudiante e on e.id=p.idlector
where e.nombre='Filippo' and e.apellido='Galli';

-- Listar el nombre del estudiante de menor edad.
select nombre
from estudiante e
where edad=(select min(edad) from estudiante);

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select titulo 
from autor a join libroautor la on a.id=la.idautor join libro l on l.id=la.idlibro
where nombre='J.K. Rowling';
