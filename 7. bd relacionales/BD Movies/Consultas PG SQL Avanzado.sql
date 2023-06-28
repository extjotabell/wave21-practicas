-- Mostrar el título y el nombre del género de todas las series.
SELECT
title
,g.name
FROM series s
INNER JOIN genres g ON g.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT
ser.title "Serie"
,ep.title "Episodio"
,ac.first_name "Nombre"
,ac.last_name "Apellido"
FROM series ser
INNER JOIN seasons ss ON ser.id = ss.serie_id
INNER JOIN episodes ep ON ss.id = ep.season_id
INNER JOIN actor_episode ae ON ae.episode_id = ep.id
INNER JOIN actors ac ON ac.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT
ser.title "Serie"
,count(ss.id) "Cant. Temporadas"
FROM series ser
INNER JOIN seasons ss ON ser.id = ss.serie_id
GROUP BY ser.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
g.name
,count(m.id) AS "Cant. Peliculas"
FROM genres g
INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.name
HAVING count(m.id)>=3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT
a.first_name
,a.last_name
FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON (m.id = am.movie_id AND LOWER(m.title) like "%guerra de las galaxias%");
 