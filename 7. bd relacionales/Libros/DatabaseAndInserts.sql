
DROP DATABASE IF EXISTS libros_db;
CREATE DATABASE libros_db;
USE libros_db;

CREATE TABLE estudiante (
  id_lector INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  direccion VARCHAR (50),
  carrera VARCHAR (50),
  edad INT
);

CREATE TABLE autor (
  id_autor INT PRIMARY KEY,
  nombre VARCHAR(50),
  nacionalidad VARCHAR(50)
);

CREATE TABLE Libro (
  id_libro INT PRIMARY KEY,
  titulo VARCHAR(100),
  editorial VARCHAR(50),
  area VARCHAR(50)
);

CREATE TABLE libro_autor (
  id_autor INT ,
  id_libro INT ,
  FOREIGN KEY(id_autor) REFERENCES autor(id_autor),
  FOREIGN KEY(id_libro) REFERENCES libro(id_libro),
  PRIMARY KEY (id_autor, id_libro)
);

CREATE TABLE prestamo (
  id_lector int ,
  id_libro int ,
  fecha_prestamo date NOT NULL,
  fecha_devolucion date,
  devuelto bool ,
  PRIMARY KEY(id_lector,id_libro),
  FOREIGN KEY(id_lector) REFERENCES estudiante(id_lector),
  FOREIGN KEY(id_libro) REFERENCES libro(id_libro)
);

INSERT INTO estudiante VALUES 
(1, " Fillipo", "Galli","Calle Falsa 123","Ingenieria",22),
(2, " Elba", "Rtulo","Calle Falsa 321","Ingenieria",32),
(3, " Jose", "Zito","Calle Falseta 123","Ingenieria",42),
(4, " Sara", "Tera","Calle Falsa 123","Matematica",25),
(5, " Roman", "Tristelme","Bonita","Contabilidad",26),
(6, 'David', 'Davis', '654 Cedar St', 'Informatica', 20),
(7, 'Pedro', 'Trel', '654 Cedar St', 'Informatica', 20);

INSERT INTO Libro  VALUES
(1, 'El Universo: Guía de viaje', 'Salamandra', 'Ficción'),
(2, 'Cien años de soledad', 'Sudamericana', 'Internet'),
(3, 'Orgullo y prejuicio', 'Tapa blanda', 'Internet'),
(4, '1984', 'Secker & Warburg', 'Ciencia ficción'),
(5, 'Matar a un ruiseñor', 'Salamandra', 'Drama');


INSERT INTO autor VALUES 
(1, 'John Smith', 'USA'),
(2, 'Maria Garcia', 'Italia'),
(3, 'Li Wei', 'Francia'),
(4, 'Hiroshi Tanaka', 'Argentina'),
(5, 'Anna Müller', 'Francia');

INSERT INTO prestamo VALUES 
(1, 1, '2023-06-15', '2023-06-22', TRUE),
(2, 3, '2023-06-16', NULL, FALSE),
(3, 2, '2023-06-17', '2023-06-24', TRUE),
(4, 4, '2023-06-18', NULL, FALSE),
(5, 5, '2023-06-19', '2023-06-26', TRUE),
(1, 4, '2021-07-16', NULL, FALSE);

INSERT INTO libro_autor VALUES 
(1, 1),
(1, 2),
(3, 3),
(4, 4),
(2, 1)
(5, 5);

