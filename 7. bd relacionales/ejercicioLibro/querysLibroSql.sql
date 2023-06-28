-- INSERTANDO AUTORES
INSERT INTO Autor VALUES (null, "María López", "Argentina");
INSERT INTO Autor VALUES (null, "Pedro García", "España");
INSERT INTO Autor VALUES (null, "Luisa Rodríguez", "México");
INSERT INTO Autor VALUES (null, "Ana Silva", "Brasil");
INSERT INTO Autor VALUES (null, "Roberto Fernández", "Chile");
INSERT INTO Autor VALUES (null, "Carolina González", "Colombia");
INSERT INTO Autor VALUES (null, "Andrés López", "Perú");
INSERT INTO Autor VALUES (null, "Sofía Martínez", "Argentina");
INSERT INTO Autor VALUES (null, "Ricardo Castro", "México");
INSERT INTO Autor VALUES (null, "Camila Gómez", "Colombia");
INSERT INTO Autor VALUES (null, "Hugo Ramírez", "Uruguay");
INSERT INTO Autor VALUES (null, "Fernanda Torres", "Brasil");

-- INSERTANDO ESTUDIANTE
INSERT INTO Estudiante VALUES (null, "Jorge", "Perez", "Casullo 1030", "Literuta",30);
INSERT INTO Estudiante VALUES (null, "María", "González", "Avenida Libertad 456", "Historia", 28);
INSERT INTO Estudiante VALUES (null, "Carlos", "López", "Calle San Martín 789", "Matemáticas", 25);
INSERT INTO Estudiante VALUES (null, "Laura", "Rodríguez", "Rivadavia 321", "Ciencias Sociales", 29);
INSERT INTO Estudiante VALUES (null, "Juan", "Martínez", "Belgrano 654", "Biología", 27);
INSERT INTO Estudiante VALUES (null, "Ana", "Fernández", "Sarmiento 987", "Física", 26);

-- INSERTANDO LIBRO
INSERT INTO Libro VALUES (null, "Harry Potter", "Salamanca", 1);
INSERT INTO Libro VALUES (null, "Cien Años de soledad", "Planeta", 1);
INSERT INTO Libro VALUES (null, "Harry Potter y la Piedra Filosofal", "Salamanca", 2);
INSERT INTO Libro VALUES (null, "1984", "Debolsillo", 3);
INSERT INTO Libro VALUES (null, "El Gran Gatsby", "Anagrama", 4);
INSERT INTO Libro VALUES (null, "Don Quijote de la Mancha", "Cervantes", 5);
INSERT INTO Libro VALUES (null, "Orgullo y prejuicio", "Austral", 6);

-- INSERTANDO LIBROAUTOR
INSERT INTO LIBROAUTOR VALUES (null,1,1);
INSERT INTO LIBROAUTOR VALUES (null,2,2);
INSERT INTO LIBROAUTOR VALUES (null,3,1);
INSERT INTO LIBROAUTOR VALUES (null,4,5);
INSERT INTO LIBROAUTOR VALUES (null,2,3);

-- INSERTANDO PRESTAMO
INSERT INTO PRESTAMO VALUES (null,'2022-01-01','2022-02-07',0,1,6);
INSERT INTO PRESTAMO VALUES (null,'2022-02-01','2022-05-02',0,2,3);
INSERT INTO PRESTAMO VALUES (null,'2022-03-01','2022-04-05',1,3,5);
INSERT INTO PRESTAMO VALUES (null,'2022-01-30','2022-02-06',1,1,2);
INSERT INTO PRESTAMO VALUES (null,'2022-05-10','2022-07-10',0,2,1);
INSERT INTO PRESTAMO VALUES (null,'2022-02-15','2022-02-20',1,4,3);
INSERT INTO PRESTAMO VALUES (null,'2022-01-07','2022-01-15',1,1,2);

-- Listar los datos de los autores.
SELECT * FROM AUTOR;

-- Listar nombre y edad de los estudiantes
SELECT 
	nombre, 
    edad
	FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT 
	nombre
	FROM Estudiante
    WHERE Carrera IN('Informatica');

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT 
	nombre
	FROM Autor
	WHERE nacionalidad = 'francesa' 
    OR nacionalidad = 'italiana';


-- ¿Qué libros no son del área de internet?

-- Listar los libros de la editorial Salamandra.

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

-- ¿Qué libros se prestaron al lector “Filippo Galli”?

-- Listar el nombre del estudiante de menor edad.

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

-- Listar los libros que pertenecen a la autora J.K. Rowling.

-- Listar títulos de los libros que debían devolverse el 16/07/2021.

