USE movies_db;


-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s
JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM episodes e
JOIN actor_episode ae ON e.id = ae.episode_id
JOIN actors a ON ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(ss.id) total_temporadas FROM series s
LEFT JOIN seasons ss ON s.id = ss.serie_id
GROUP BY s.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.id) as cantidad_peliculas
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING cantidad_peliculas >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE 'La Guerra de las galaxias%'
GROUP BY a.id
HAVING COUNT(DISTINCT m.id) = (
	SELECT COUNT(DISTINCT movie_id)
    FROM actor_movie
    JOIN movies ON actor_movie.movie_id = movies.id
    WHERE movies.title LIKE 'La Guerra de las galaxias%'
);

