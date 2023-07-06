USE libros_db;
-- Listar los datos de los autores.
SELECT * FROM autor;
-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = "informatica";
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = "Francia";
-- ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != "Internet";
-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante
WHERE edad > (SElECT AVG(edad) FROM estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM estudiante 
WHERE apellido LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM libro_autor la
INNER JOIN autor a ON a.id_autor = la.id_autor
INNER JOIN libro l ON l.id_libro = la.id_libro
WHERE titulo LIKE "El Universo: Guía de viaje";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo ,e.nombre, e.apellido
FROM prestamo AS p 
INNER JOIN libro AS l ON p.id_libro = l.id_libro
INNER JOIN estudiante AS e ON p.id_lector = e.id_lector
WHERE e.nombre LIKE " Fillipo" AND e.apellido LIKE "Galli";
-- Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido,edad FROM estudiante 
WHERE edad IN (SELECT MIN(edad) FROM estudiante);
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

-- Listar los libros que pertenecen a la autora J.K. Rowling.

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo 
FROM prestamo AS pr INNER JOIN libro AS l
ON pr.id_libro = l.id_libro
WHERE pr.fecha_devolucion < '2023-06-23';


