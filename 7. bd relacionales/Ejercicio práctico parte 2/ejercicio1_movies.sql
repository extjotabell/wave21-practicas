use movies_db;

-- consultas

-- Mostrar todos los registros de la tabla de movies. 
select * from movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
select first_name,last_name,rating from actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select title as titulo from series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
select first_name,last_name from actors where rating>7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
select title,rating,awards from movies where rating>7.5 and awards>2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select title, rating from movies order by rating asc;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
select title from movies limit 3;

-- Mostrar el top 5 de las películas con mayor rating.
select title from movies order by rating desc limit 5;

-- Listar los primeros 10 actores.
select first_name, last_name from actors limit 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select title,rating from movies where title='Toy Story';

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
select first_name, last_name from actors where first_name like 'Sam%';


-- SQL AVANZADO

-- Mostrar el título y el nombre del género de todas las series.
select s.title,g.name
from series as s
join genres as g
on s.genre_id=g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title as episodio,a.first_name as 'nombre actor',a.last_name as 'apellido actor'
from episodes as e
join actor_episode as ae
join actors as a
on ae.episode_id=e.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title as serie,COUNT(se.title) as temporadas
from series as s
join seasons as se
on s.id=se.serie_id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name as genero,COUNT(m.title) as peliculas
from movies as m
join genres as g
on m.genre_id=g.id
group by g.name;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select ac.first_name, ac.last_name,m.title
from actor_movie as am
join movies as m
join actors as ac
on am.movie_id=m.id and ac.id=am.actor_id
where m.title LIKE '%Guerra de las galaxias%';

-- Consultas SQL Avanzadas 2

-- Agregar una película a la tabla movies.
insert into movies (title,rating,awards,release_date,genre_id) values ('Siempre a tu lado',9.5,1,'2010-03-12',3);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
-- no entiendo

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id=(select id from movies where title='Siempre a tu lado') where id=5;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table copy_movies select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from copy_movies where awards<5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select * from genres where id in (select genre_id from movies group by genre_id);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select * from actors where favorite_movie_id in (select id from movies where awards>3);

-- Crear un índice sobre el nombre en la tabla movies.
create unique index id_nombre on movies(title);

-- Chequee que el índice fue creado correctamente.
show index from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- creo qe no es necesario, ya que la base de datos es pequeña y las consultas ya se pueden realizar a través del id
-- no le veo la necesidad de estar buscando por el nombre
-- de pronto en una base de datos como netflix si sería de gran ayuda ya que la mayoría de los usuarios buscamos las películas por el nombre
-- o para realizar análisis de datos de inteligencia artificial para generar estadísticas si sería útil

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- si la base de datos fuera grande crearía uno también para el nombre de las series, otro dato que es muy buscado por usuarios


