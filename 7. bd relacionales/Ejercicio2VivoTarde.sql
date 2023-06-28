-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiantes;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiantes where carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM AUTOR WHERE NACIONALIDAD IN('FRANCESA','ITALIANA');

-- ¿Qué libros no son del área de internet?
SELECT * FROM LIBRO WHERE AREA = 'INTERNET';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM LIBROS WHERE EDITORIAL = 'SALAMANDRA';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM ESTUDIANTE WHERE EDAD >
(SELECT AVG(EDAD) EDAD_PROMEDIO FROM ESTUDIANTES);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM ESTUDIANTE WHERE NOMBRE LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT A.NOMBRE FROM LIBROAUTOR LA INNER JOIN AUTOR A ON A.IDAUTOR = LA.IDAUTOR 
INNER JOIN LIBRO L ON LA.IDLIBRO = L.IDLIBRO
WHERE L.TITULO = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”? 
SELECT L.* FROM PRESTAMO P INNER JOIN LIBRO L ON L.IDLIBRO = P.IDLIBRO 
INNER JOIN ESTUDIANTE E ON P.IDLECTOR = E.IDESTUDIANTE
WHERE E.NOMBRE = 'Filippo Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT E.NOMBRE 
FROM ESTUDIANTE E
ORDER BY EDAD ASC
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select E.NOMBRE
FROM PRESTAMO P INNER JOIN LIBRO L ON L.IDLIBRO = P.IDLIBRO 
INNER JOIN ESTUDIANTE E ON P.IDLECTOR = E.IDESTUDIANTE
WHERE L.AREA = 'BASE DE DATOS';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * 
FROM LIBROAUTOR LA INNER JOIN LIBRO L ON L.IDLIBRO = LA.IDLIBRO
INNER JOIN AUTOR A ON A.IDAUTOR = LA.IDAUTOR
where a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021
select L.titulo
from libros l inner join prestamo on l.idlibro = idlibro
where p.fechadevolucion = "2021-07-16";