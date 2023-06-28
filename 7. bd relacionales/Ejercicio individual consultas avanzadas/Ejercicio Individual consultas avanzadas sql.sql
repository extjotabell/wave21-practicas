USE movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title AS Titulo, g.name AS 'Nombre Género'
FROM series as s
INNER JOIN genres as g 
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, ac.first_name, ac.last_name
FROM episodes e
INNER JOIN actor_episode ae ON ae.episode_id = e.id
INNER JOIN actors ac ON ac.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title AS Titulo, MAX(sea.number) AS 'Total de temporadas'
FROM series ser
INNER JOIN seasons sea ON sea.serie_id = ser.id
GROUP BY ser.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
-- siempre que sea mayor o igual a 3.
SELECT g.name AS 'Género', COUNT(m.id) AS `Cantidad de Peliculas`
FROM movies m
INNER JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING `Cantidad de Peliculas` >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name AS 'Nombre', ac.last_name AS 'Apellido'
FROM movies m
INNER JOIN actor_movie am ON m.id = am.movie_id
INNER JOIN actors ac ON ac.id = am.actor_id
WHERE m.title LIKE 'La Guerra de las galaxias%';
