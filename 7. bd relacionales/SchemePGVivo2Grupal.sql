CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE estudiante (
  idLector INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  direccion VARCHAR (50),
  carrera VARCHAR (50),
  edad INT
);

CREATE TABLE libro (
  idLibro INT PRIMARY KEY,
  titulo VARCHAR(100),
  editorial VARCHAR(50),
  area VARCHAR(50)
);

CREATE TABLE autor (
  idAutor INT PRIMARY KEY,
  nombre VARCHAR(50),
  nacionalidad VARCHAR(50)
);

CREATE TABLE libro_autor (
  idAutor INT,
  idLibro INT,
  PRIMARY KEY (idAutor, idLibro),
  FOREIGN KEY(idAutor) REFERENCES autor(idAutor),
  FOREIGN KEY(idLibro) REFERENCES libro(idLibro)
);

CREATE TABLE prestamo (
  idLector INT,
  idLibro INT,
  fechaPrestamo DATE NOT NULL,
  fechaDevolucion DATE,
  devuelto BOOL ,
  FOREIGN KEY(idLector) REFERENCES estudiante(idLector),
  FOREIGN KEY(idLibro) REFERENCES libro(idLibro),
  PRIMARY KEY (idLector, idLibro) 
);

-- Estudiantes

INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (1, 'Filippo', 'Galli', '123 Main St', 'Computer Science', 20);

INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (2, 'Jane', 'Smith', '456 Elm St', 'Informatica', 22);

INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (3, 'Michael', 'Johnson', '789 Oak St', 'Physics', 19);
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (4, 'Emily', 'Brown', '321 Pine St', 'English Literature', 21);

INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (5, 'David', 'Davis', '654 Cedar St', 'Informatica', 20);
-- Libro

INSERT INTO Libro  VALUES
(1, 'El gran Gatsby', 'Scribner', 'Ficción'),
(2, 'Cien años de soledad', 'Sudamericana', 'Internet'),
(3, 'Orgullo y prejuicio', 'Salamandra', 'Internet'),
(4, '1984', 'Secker & Warburg', 'Ciencia ficción'),
(5, 'El Universo: Guía de viaje', 'J. B. Lippincott & Co.', 'Drama');


-- Autores

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (1, 'J.K. Rowling', 'United States');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (2, 'Maria Garcia', 'Italiana');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (3, 'Li Wei', 'Francia');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (4, 'Hiroshi Tanaka', 'Japan');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (5, 'Anna Müller', 'Francia');

-- Libros y sus autores

INSERT INTO libro_autor (idAutor, idLibro)
VALUES (1, 1);

INSERT INTO libro_autor (idAutor, idLibro)
VALUES (2, 2);

INSERT INTO libro_autor (idAutor, idLibro)
VALUES (3, 3);

INSERT INTO libro_autor (idAutor, idLibro)
VALUES (4, 4);

INSERT INTO libro_autor (idAutor, idLibro)
VALUES (5, 5);

--  Prestamos

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (1, 4, '2021-07-16', NULL, FALSE);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (4, 4, '2023-06-18', NULL, FALSE);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (5, 5, '2023-06-19', '2023-06-26', TRUE);

