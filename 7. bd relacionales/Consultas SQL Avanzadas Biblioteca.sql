/* Listar los datos de los autores. */
SELECT * FROM Autor;

/* ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT * FROM Estudiante
WHERE Carrera = "Informatica";

/* Listar los libros de la editorial Salamandra. */
SELECT * FROM Libro
WHERE Editorial = "Salamandra";

/* Listar el nombre del estudiante de menor edad. */
SELECT * FROM Estudiante
ORDER BY Edad ASC
LIMIT 1;

/* Listar títulos de los libros que debían devolverse el 16/07/2021. */
SELECT * FROM Libro
INNER JOIN Prestamo ON Libro.idLibro = Prestamo.idLibro
WHERE FechaDevolucion > "2021-07-16";