-- Listar los datos de los autores.
select id_autor, nombre, nacionalidad from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select id_lector,
       nombre,
       apellido,
       direccion,
	   carrera,
       edad
  from estudiante
 where carrera = 'Informatica';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select id_autor, 
	   nombre, 
       nacionalidad 
  from autor
 where nacionalidad = 'Francesa' or nacionalidad = 'Italiana';

-- ¿Qué libros no son del área de internet?
select id_libro, 
	   titulo, 
       editorial, 
       area 
  from libro 
 where area <> 'Software';

-- Listar los libros de la editorial Salamandra.
select id_libro, 
	   titulo, 
       editorial, 
       area 
  from libro 
 where editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select id_lector,
       nombre,
       apellido,
       direccion,
	   carrera,
       edad
  from estudiante
 where edad >= (select avg(edad) 
				  from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre,
       apellido
  from estudiante
 where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select tbl_au.nombre
  from libro_autor tbl_li_au 
 inner join autor tbl_au on tbl_li_au.fk_id_autor = tbl_au.id_autor  
 inner join libro tbl_li on tbl_li_au.fk_id_libro = tbl_li.id_libro
 where tbl_li.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select tbl_li.titulo,
	   tbl_li.editorial,
       tbl_li.area
  from prestamo tbl_pres 
 inner join estudiante tbl_es on tbl_pres.fk_id_lector = tbl_es.id_lector  
 inner join libro tbl_li on tbl_pres.fk_id_libro = tbl_li.id_libro
 where tbl_es.nombre = 'Filippo'
   and tbl_es.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
select nombre,
       apellido
  from estudiante
 where edad = (select min(edad) from estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select tbl_es.nombre
  from prestamo tbl_pres 
 inner join estudiante tbl_es on tbl_pres.fk_id_lector = tbl_es.id_lector  
 inner join libro tbl_li on tbl_pres.fk_id_libro = tbl_li.id_libro
 where tbl_li.area = 'Software';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select tbl_li.titulo
  from libro_autor tbl_li_au 
 inner join autor tbl_au on tbl_li_au.fk_id_autor = tbl_au.id_autor  
 inner join libro tbl_li on tbl_li_au.fk_id_libro = tbl_li.id_libro
 where tbl_au.nombre like '%J%K%Rowling%';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select tbl_li.titulo
  from prestamo tbl_pres   
 inner join libro tbl_li on tbl_pres.fk_id_libro = tbl_li.id_libro
 where tbl_pres.fecha_devolucion = '2021-07-16'
 group by tbl_li.titulo;


