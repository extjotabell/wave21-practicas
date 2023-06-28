CREATE DATABASE biblioteca_db;
USE biblioteca_db;

-- Creacion de Tablas

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

-- Creacion de registros

SELECT * FROM prestamo;

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


INSERT INTO libro (idLibro, titulo, editorial, area)
VALUES (1, 'Introduction to SQL', 'Salamandra', 'Internet');

INSERT INTO libro (idLibro, titulo, editorial, area)
VALUES (2, 'Data Structures and Algorithms', 'XYZ Publications', 'Internet');

INSERT INTO libro (idLibro, titulo, editorial, area)
VALUES (3, 'The Great Gatsby', 'Penguin Books', 'Fiction');

INSERT INTO libro (idLibro, titulo, editorial, area)
VALUES (4, 'Fundamentals of Physics', 'HarperCollins', 'Physics');

INSERT INTO libro (idLibro, titulo, editorial, area)
VALUES (5, 'El Universo: Guía de viaje', 'McGraw-Hill', 'Chemistry');


INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (1, 'J.K. Rowling', 'United States');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (2, 'Maria Garcia', 'Italia');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (3, 'Li Wei', 'Francia');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (4, 'Hiroshi Tanaka', 'Japan');

INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES (5, 'Anna Müller', 'Francia');


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


INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (1, 1, '2023-06-15', '2023-06-22', TRUE);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (2, 3, '2023-06-16', NULL, FALSE);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (3, 2, '2023-06-17', '2023-06-24', TRUE);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (4, 4, '2023-06-18', NULL, FALSE);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (5, 5, '2023-06-19', '2023-06-26', TRUE);
