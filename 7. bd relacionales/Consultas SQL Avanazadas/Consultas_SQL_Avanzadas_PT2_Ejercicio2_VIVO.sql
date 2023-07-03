-- Crear la base de datos "biblioteca"
CREATE DATABASE biblioteca;

-- Usar la base de datos "biblioteca"
USE biblioteca;


-- Crear la tabla "Libro"
CREATE TABLE Libro (
  id_libro INT PRIMARY KEY,
  titulo VARCHAR(100),
  editorial VARCHAR(100),
  area VARCHAR(50)
);

-- Crear la tabla "Autor"
CREATE TABLE Autor (
  id_autor INT PRIMARY KEY,
  nombre VARCHAR(100),
  nacionalidad VARCHAR(100)
);

-- Crear la tabla "LibroAutor"
CREATE TABLE LibroAutor (
  id_libro INT,
  id_autor INT,
  PRIMARY KEY (id_libro, id_autor),
  FOREIGN KEY (id_libro) REFERENCES Libro(id_libro),
  FOREIGN KEY (id_autor) REFERENCES Autor(id_autor)
);

-- Crear la tabla "Estudiante"
CREATE TABLE Estudiante (
  id_estudiante INT PRIMARY KEY,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  direccion VARCHAR(255),
  carrera VARCHAR(100),
  edad INT
);

-- Crear la tabla "Préstamo"
CREATE TABLE Prestamo (
  prestamo_id INT PRIMARY KEY,
  id_estudiante INT,
  id_libro INT,
  fecha_prestamo DATE,
  fecha_devolucion DATE,
  devuelto BIT,
  FOREIGN KEY (id_libro) REFERENCES Libro(id_libro),
  FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante)
);


-- Insertando registros
INSERT INTO Libro (id_libro, titulo, editorial, area)
VALUES
  (1, 'Libro 1', 'Editorial 1', 'Informatica'),
  (2, 'Libro 2', 'Editorial 2', 'Lengua'),
  (3, 'Libro 3', 'Editorial 1', 'Matematicas'),
  (4, 'Libro 4', 'Editorial 3', 'lengua'),
  (5, 'Libro 5', 'Editorial 2', 'Historia');

INSERT INTO Autor (id_autor, nombre, nacionalidad)
VALUES
  (1, 'Autor 1', 'Nacionalidad 1'),
  (2, 'Autor 2', 'Nacionalidad 2'),
  (3, 'Autor 3', 'Nacionalidad 3'),
  (4, 'Autor 4', 'Nacionalidad 1'),
  (5, 'Autor 5', 'Nacionalidad 2');

INSERT INTO LibroAutor (id_libro, id_autor)
VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 2),
  (4, 4);

INSERT INTO Estudiante (id_estudiante, nombre, apellido, direccion, carrera, edad)
VALUES
  (1, 'Estudiante 1', 'Apellido 1', 'Direccion 1', 'Informática', 20),
  (2, 'Estudiante 2', 'Apellido 2', 'Direccion 2', 'Biología', 22),
  (3, 'Estudiante 3', 'Apellido 3', 'Direccion 3', 'Arquitectura', 21),
  (4, 'Estudiante 4', 'Apellido 4', 'Direccion 4', 'Informática', 23),
  (5, 'Estudiante 5', 'Apellido 5', 'Direccion 5', 'Historia', 24);
  
INSERT INTO Prestamo (prestamo_id, id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES
  (1, 1, 1, '2023-06-01', '2023-06-01', 1),
  (2, 2, 2, '2023-06-15', null, 0),
  (3, 3, 3, '2023-06-20', '2022-08-12', 1),
  (4, 4, 4, '2023-06-25', '2021-02-17', 1),
  (5, 5, 5, '2023-06-30', '2021-07-22', 1);
  
-- Algunas consultas
-- Listar los datos de los autores.
SELECT * FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM Estudiante WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad Nacionalidad 1 o Nacionalidad 3?
SELECT * FROM Autor WHERE nacionalidad IN ('Nacionalidad 1', 'Nacionalidad 3');

-- ¿Qué libros no son del área de internet?
SELECT * FROM Libro WHERE area <> 'nternet';

  
  