-- drop schema biblioteca
-- DB Set Up
create schema biblioteca;
use biblioteca;

create table author(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    nationality VARCHAR(20),
    
    PRIMARY KEY (id)
);

insert into 
	author (name, nationality)
values 
	('J.K. Rowling', 'nacionalidad1'),
    ('autor2', 'frances'),
    ('autor3', 'italiano'),
    ('autor4', 'nacionalidad4'),
    ('autor5', 'nacionalidad5');

create table book(
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(30),
    editorial VARCHAR(20),
    area VARCHAR(20),
    
    PRIMARY KEY (id)
);

insert into 
	book (title, editorial, area)
values 
	('libro1', 'editorial1', 'area1'),
    ('Base de Datos', 'editorial2', 'area2'),
    ('El Universo: Guía de viaje', 'editorial3', 'area3'),
    ('libro4', 'Salamandra', 'area4'),
    ('libro5', 'editorial5', 'internet');
    
create table student(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    last_name VARCHAR(30),
    address VARCHAR(50),
    career VARCHAR(20),
    age INT,
    
    PRIMARY KEY (id)
);

insert into
	student (name, last_name, address, career, age)
values
	('Filippo', 'Galli', 'direccion1', 'carrera1', 1),
    ('estudiante2', 'apellido2', 'direccion2', 'carrera2', 2),
    ('estudiante3', 'apellido3', 'direccion3', 'informática', 3),
    ('estudiante4', 'apellido4', 'direccion4', 'carrera4', 4),
    ('estudiante5', 'apellido5', 'direccion5', 'carrera5', 5);

create table author_book(
	id INT NOT NULL AUTO_INCREMENT,
    id_author INT NOT NULL,
    id_book INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (id_author) REFERENCES author(id),
    FOREIGN KEY (id_book) REFERENCES book(id)
);

insert into 
	author_book (id_author, id_book)
values
	(1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

create table book_student(
	id INT NOT NULL AUTO_INCREMENT,
    id_book INT NOT NULL,
    id_student INT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    returned BOOLEAN NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (id_book) REFERENCES book(id),
    FOREIGN KEY (id_student) REFERENCES student(id)
);

insert into
	book_student (id_book, id_student, loan_date, return_date, returned)
values
	(1, 1, STR_TO_DATE('21,5,2013','%d,%m,%Y'), NULL, FALSE),
    (2, 2, STR_TO_DATE('21,5,2014','%d,%m,%Y'), STR_TO_DATE('21,6,2014','%d,%m,%Y'), TRUE),
    (3, 3, STR_TO_DATE('21,5,2015','%d,%m,%Y'), NULL, FALSE),
    (4, 4, STR_TO_DATE('21,5,2016','%d,%m,%Y'), STR_TO_DATE('16,7,2021','%d,%m,%Y'), TRUE),
    (5, 5, STR_TO_DATE('21,5,2017','%d,%m,%Y'), NULL, FALSE);

-- Queries
-- Listar los datos de los autores.
select 
	*
from 
	author;
    
    
-- Listar nombre y edad de los estudiantes
select
	name,
    age
from
	student;
    
    
-- ¿Qué estudiantes pertenecen a la carrera informática?
select
	*
from
	student
where
	career = 'informática';
    
    
-- ¿Qué autores son de nacionalidad francesa o italiana?
select
	*
from
	author
where 
	nationality in ('frances', 'italiano');
    
    
-- ¿Qué libros no son del área de internet?
select 
	*
from
	book
where 
	area = 'internet';
    
    
-- Listar los libros de la editorial Salamandra.
select 
	*
from
	book
where 
	editorial = 'Salamandra';
    
    
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select
	*
from 
	student
where
	age > (select avg(age) from student);
    
    
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select
	*
from 
	student
where 
	last_name like binary 'G%';
    
    
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select
	a.name
from
	author a,
    author_book ab,
    book b
where
	a.id = ab.id_author
    and b.id = ab.id_book
    and b.title = 'El Universo: Guía de viaje';
    
    
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select
	b.*
from
	student s,
    book_student bs,
    book b
where
	s.id = bs.id_student
    and b.id = bs.id_book
    and s.name = 'Filippo'
    and s.last_name = 'Galli';
    
    
-- Listar el nombre del estudiante de menor edad.
select
	*
from 
	student s
where
	not exists (select 1 from student s2 where s2.age < s.age);
    
    
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select
	s.name
from
	student s,
    book_student bs,
    book b
where
	s.id = bs.id_student
    and b.id = bs.id_book
    and b.title = 'Base de Datos';
    
-- Listar los libros que pertenecen a la autora J.K. Rowling.
select
	b.*
from
	author a,
    author_book ab,
    book b
where
	a.id = ab.id_author
    and b.id = ab.id_book
    and a.name = 'J.K. Rowling';
    
    
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select
	b.title
from
	student s,
    book_student bs,
    book b
where
	s.id = bs.id_student
    and b.id = bs.id_book
    and bs.return_date = STR_TO_DATE('16,7,2021','%d,%m,%Y');



