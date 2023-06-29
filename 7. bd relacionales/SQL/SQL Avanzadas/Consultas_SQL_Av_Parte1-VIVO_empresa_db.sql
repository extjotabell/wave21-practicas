-- Listar los datos de los autores.
SELECT *
FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido, carrera
FROM estudiante
WHERE carrera = "Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE nacionalidad = "Francia" OR nacionalidad = "Italy";

-- ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE area != "Internet";

-- Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (
	SELECT AVG(edad)
    FROM estudiante ) ;

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre
FROM (autor a JOIN libro_autor la ON a.idAutor = la.idAutor) JOIN libro l ON la.idLibro = l.idLibro
WHERE l.titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM (prestamo p JOIN libro l ON p.idLibro = l.idLibro) JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = "Filippo" and e.apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT *
FROM estudiante
ORDER BY edad ASC limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM (prestamo p JOIN libro l ON p.idLibro = l.idLibro) JOIN estudiante e ON p.idLector = e.idLector
WHERE l.titulo LIKE "%SQL%";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo, l.editorial, l.area
FROM (autor a JOIN libro_autor la ON a.idAutor = la.idAutor) JOIN libro l ON la.idLibro = l.idLibro
WHERE a.nombre ="J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 2023-06-26.
SELECT *
FROM prestamo p JOIN libro l ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion LIKE "2023-06-26";