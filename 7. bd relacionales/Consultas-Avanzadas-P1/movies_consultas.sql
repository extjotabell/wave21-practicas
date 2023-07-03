/*
Mostrar el título y el nombre del género de todas las series.
*/

SELECT s.title, g.name FROM SERIES s join genres g on g.id = s.genre_id;


/*
Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
*/


SELECT a.first_name, a.last_name, e.title FROM actor_episode ae join Actors a on ae.actor_id = a.id 
JOIN Episodes e on e.id = ae.episode_id;


/*
Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
*/
SELECT se.title, count(sea.id) from series se join seasons sea on sea.serie_id = se.id 
group by se.title;


/*
Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
*/

Select g.name, count(m.id) from movies m join genres g on m.genre_id = g.id
group by g.name;

/*
Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas
 de la guerra de las galaxias y que estos no se repitan.
*/
-- acá no faltaría controlar que esté en TODOS?
SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac JOIN  actor_movie am ON ac.id = am.actor_id
WHERE am.movie_id IN (SELECT id FROM movies WHERE title LIKE "La Guerra %" );

SELECT title FROM movies







