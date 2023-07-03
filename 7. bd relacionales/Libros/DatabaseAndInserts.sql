
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
(1, " Alan", "Brado","Calle Falsa 123","Ingenieria",22),
(2, " Elba", "Rtulo","Calle Falsa 321","Ingenieria",32),
(3, " Jose", "Zito","Calle Falseta 123","Ingenieria",42),
(4, " Sara", "Tera","Calle Falsa 123","Matematica",25),
(5, " Roman", "Tristelme","Bonita","Contabilidad",26);



INSERT INTO Libro (id_libro, titulo, editorial, area) VALUES
(1, 'El gran Gatsby', 'Scribner', 'Ficción'),
(2, 'Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
(3, 'Orgullo y prejuicio', 'Tapa blanda', 'Clásico'),
(4, '1984', 'Secker & Warburg', 'Ciencia ficción'),
(5, 'Matar a un ruiseñor', 'J. B. Lippincott & Co.', 'Drama');




