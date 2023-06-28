-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM (episodes e JOIN actor_episode ae ON e.id = ae.episode_id) JOIN actors a ON a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, count(sea.id) as SeasonCount
FROM seasons sea JOIN series ser ON sea.serie_id = ser.id
GROUP BY ser.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(m.id) as MovieCount
FROM movies m JOIN genres g ON m.genre_id = g.id
GROUP BY g.id
HAVING count(m.id) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
-- Mediante Doble Negacion
SELECT a.first_name, a.last_name
FROM actors a
WHERE NOT EXISTS (
  SELECT m.id
  FROM movies m
  WHERE m.title LIKE '%La Guerra %'
    AND NOT EXISTS (
      SELECT am.actor_id
      FROM actor_movie am
      WHERE am.movie_id = m.id
        AND am.actor_id = a.id
    )
);

-- Mediante subconsults y count
SELECT DISTINCT actors.first_name, actors.last_name
FROM actors 
WHERE actors.id in (
	SELECT actor_movie.actor_id
	FROM actor_movie JOIN movies ON actor_movie.movie_id = movies.id
	WHERE movies.title LIKE "%guerra de las galaxias%"
	GROUP BY actor_id
	HAVING count(actor_id) = count(movies.id)
);
