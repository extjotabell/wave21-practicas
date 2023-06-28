USE movies_db;
-- Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name 
FROM series se 
INNER JOIN genres ge
ON se.genre_id = ge.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT e.title, ac.first_name, ac.last_name
FROM actor_episode ae
INNER JOIN episodes e
ON ae.episode_id = e.id
INNER JOIN actors ac
ON ae.actor_id = ac.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT se.title, COUNT(*) AS total_temporadas
FROM series se 
INNER JOIN seasons sa
ON se.id = sa.serie_id
GROUP BY se.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT ge.name, COUNT(*) AS cantidad
FROM genres ge 
INNER JOIN movies mo
ON ge.id = mo.genre_id
GROUP BY ge.name 
HAVING cantidad >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac
INNER JOIN  actor_movie am
ON ac.id = am.actor_id
WHERE am.movie_id IN (SELECT id FROM movies WHERE title LIKE "La Guerra %" );

SELECT title FROM movies