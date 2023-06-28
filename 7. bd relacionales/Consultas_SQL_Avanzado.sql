/* Mostrar el título y el nombre del género de todas las series. */
SELECT series.title,genres.name FROM genres
INNER JOIN series ON genre_id = genres.id;

/* Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */
SELECT episodes.title,actors.first_name,actors.last_name FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

/* Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
SELECT series.title,COUNT(seasons.serie_id) as total_temporadas FROM seasons
INNER JOIN series ON seasons.serie_id = series.id
GROUP BY series.title;

/* Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. */
SELECT genres.name, COUNT(movies.genre_id) as total_peliculas FROM movies
INNER JOIN genres ON movies.genre_id = genres.id
GROUP BY genres.id
HAVING total_peliculas >= 3;

/* Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan. */
SELECT DISTINCT actors.first_name,actors.last_name FROM actor_movie
INNER JOIN actors ON actor_movie.actor_id = actors.id 
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE title LIKE "%La guerra%"



