-- Mostrar el título y el nombre del género de todas las series.

SELECT s.title as Titulo, g.name as Genero FROM series s JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT ep.title, ac.first_name, ac.last_name FROM episodes ep 
	JOIN actor_episode acep ON ep.id = acep.episode_id
    JOIN actors ac ON ac.id = acep.actor_id;
    
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT s.title as titulo, se.number as cta_temporadas FROM series s 
	JOIN seasons se ON s.id = se.serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT ge.name, COUNT(mo.title) as total FROM genres ge
	JOIN movies mo ON mo.genre_id = ge.id
    GROUP BY ge.name
    HAVING total >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
-- y que estos no se repitan.

SELECT ac.first_name, ac.last_name FROM actors ac 
	JOIN actor_movie amo ON amo.actor_id = ac.id
    JOIN movies mo ON mo.id = amo.movie_id
    GROUP BY ac.first_name, ac.last_name, mo.title
	HAVING mo.title LIKE "La Guerra de las galaxias%";


