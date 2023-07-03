use movies_db;

select * from movies;

select first_name, last_name, rating from actors;

select title as titulo from series;

select first_name, last_name from actors where rating >7.5;

select title, rating, awards from movies where rating>7.5 and awards>2;

select title, rating from movies order by rating;

select title from movies limit 3;

select * from movies order by rating desc limit 5;

select * from actors limit 10;

select title, rating from movies where title like "Toy Story";

select * from actors where first_name like "sam%"; 

select title from movies where release_date between "2004-01-01" and "2008-12-31";

select title from movies where rating >3 
and awards >1 
and release_date between "1988-01-01" and "2009-12-31" 
order by rating;

-- Parte 2 - PG
select title, g.name from series s
inner join genres g on s.genre_id = g.id;

select e.title, a.first_name, a.last_name from episodes e
inner join actor_episode ae on e.id = ae.episode_id
inner join actors a on ae.actor_id = a.id;

select series.title, count(serie_id) totalSeasons from series 
inner join seasons on seasons.serie_id = series.id
group by series.id;

select g.name, count(m.id) from genres g
inner join movies m on g.id = m.genre_id
group by genre_id
having count(m.id) >= 3;

select distinct a.first_name, a.last_name from actors a
inner join actor_movie am on am.actor_id = a.id
inner join movies m on am.movie_id = m.id
where m.title like "La guerra de las galaxias%";

-- Parte 2 - Vivo
-- Tablas temporales - vistas
create temporary table twd(
episodeTitle varchar(50),
seasonTitle varchar(50),
serieTitle varchar(50)
);
insert into twd 
select e.title, s.title, series.title from episodes e 
inner join seasons s on e.season_id = s.id
inner join series on s.serie_id = series.id
where series.title = "The Walking Dead";

select * from twd;
select * from twd
where seasonTitle = "Primer Temporada";

create index series_idx
on series (id);

show index from series;
-- Se elige una tabla de consulta frecuente. 
-- En las consultas anteriores, se utilizaron varias veces los inner join con los id de series. 
-- Creando un index sobre esta columna se reduciran los tiempos, optimizando la consulta.

-- Agregar una película a la tabla movies.
SELECT* FROM MOVIES;
insert into movies values (null, null, null, "Harry Potter y el prisionero de Azkaban", 10.0, 3, "2010-08-04", 150, null); 

-- Agregar un género a la tabla genres.
SELECT * FROM genres;
insert into genres values (null, "2023-07-03", null, "Magico", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies set genre_id= 13 where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
select * from actors;
UPDATE actors set favorite_movie_id = 22 where id = 47;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table moviesCopy(
id int,
created_at datetime,
updated_at datetime,
title varchar(100),
rating decimal,
awards int,
release_date datetime,
length int,
genre_id int
);
ALTER TABLE moviesCopy MODIFY title varchar(100);

insert into moviesCopy 
select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM moviesCopy
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT distinct name FROM genres
inner join movies on genres.id = movies.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.first_name, actors.last_name, movies.title, movies.awards FROM actors
INNER JOIN actor_movie as am on actors.id = am.actor_id
INNER JOIN movies on movies.id = am.movie_id
where movies.awards > 3; -- duration 0.00086

-- Crear un índice sobre el nombre en la tabla movies.
create index movies_awardsx
on movies (id);

-- Chequee que el índice fue creado correctamente.
show index from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
SELECT actors.first_name, actors.last_name, movies.title, movies.awards FROM actors
INNER JOIN actor_movie as am on actors.id = am.actor_id
INNER JOIN movies on movies.id = am.movie_id
where movies.awards > 3; -- con indice sobre movie.id duration 0.00040
-- Al crear el indice sobre la columna id la duracion bajó de 86 a 40 observandose que se optimizó la consulta.
-- Le es mas fácil buscar los id, disminuyendo el tiempo.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- podría ser sobre series id por la misma razon.


