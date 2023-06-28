-- 1. Listar los datos de los autores.
SELECT * FROM autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante
WHERE carrera = "informática";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor
WHERE nacionalidad = "francesa"
OR nacionalidad = "italiana";

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro
WHERE area = "internet";

-- 6. Listar los libros de la editorial Salamandra.
SELECT * FROM libro
WHERE editorial = "Salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante
WHERE apellido LIKE "G%";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.Nombre
FROM autor
INNER JOIN libro
INNER JOIN libro_autor
WHERE libro_autor.idAutor = autor.idAutor
AND libro_autor.idLibro = libro.idLibro
AND libro.titulo = "El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.*
FROM libro
INNER JOIN prestamo
WHERE prestamo.idLector IN (SELECT idLector FROM estudiante WHERE nombre = "Filippo" AND apellido = "Galli")
AND libro.idLibro = prestamo.idLibro;

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante
ORDER BY edad ASC
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT estudiante.nombre
FROM estudiante
INNER JOIN prestamo
WHERE prestamo.idLector IN (SELECT idLector FROM estudiante )
AND prestamo.idLector = estudiante.idLector
GROUP BY estudiante.nombre;

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT libro.*
FROM libro
INNER JOIN autor
INNER JOIN libro_autor
WHERE autor.idAutor = libro_autor.idAutor
AND libro.idLibro = libro_autor.idLibro
AND autor.Nombre = "J.K. Rowling";

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT libro.titulo
FROM libro
INNER JOIN prestamo
WHERE libro.idLibro = prestamo.idLibro
AND prestamo.fecha_devolucion > "2021-07-16"
AND prestamo.fecha_prestamo < "2021-07-16";
