
-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title AS Titulo FROM series AS Series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies ORDER BY rating ASC;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating.
SELECT title FROM movies ORDER BY rating DESC LIMIT 5;

-- Listar los primeros 10 actores.
SELECT first_name, last_name FROM actors LIMIT 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT first_name FROM actors WHERE first_name LIKE 'Sam%';

-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-01-01';

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1998-01-01' AND '2009-01-01' ORDER BY rating;

-- Mostrar el título y el nombre del género de todas las series.
SELECT 
	movies.title AS Titulo , 
    genres.name AS Genero 
    FROM movies 
    INNER JOIN genres 
    ON  movies.genre_id = genres.id;
    
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
WITH EPISODES_SUB AS (
	SELECT 
		episodes.title as episode_title, 
		actor_episode.actor_id,
        actor_episode.episode_id 
		FROM episodes INNER JOIN actor_episode 
		ON episodes.id = actor_episode.episode_id
	)

SELECT 
	EPISODES_SUB.episode_title,
    actors.first_name, 
    actors.last_name 
    FROM actors 
    INNER JOIN EPISODES_SUB 
    ON EPISODES_SUB.actor_id = actors.id;
    
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT 
	series.title, 
    count(seasons.title) AS total_seasons
    FROM series 
    INNER JOIN seasons 
    ON series.id = seasons.serie_id
    GROUP BY 1;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT 
	genres.name, 
    COUNT(movies.title) AS total_movies 
    FROM genres 
    INNER JOIN movies 
    ON genres.id= movies.genre_id 
    GROUP BY 1;
    
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
WITH MOVIES_SUB AS (
	SELECT 
		movies.title as movie_title, 
		actor_movie.actor_id,
        actor_movie.movie_id 
		FROM movies 
        INNER JOIN actor_movie
		ON movies.id = actor_movie.movie_id
	)

SELECT 
	DISTINCT
	actors.first_name, 
    actors.last_name
    FROM actors 
    INNER JOIN MOVIES_SUB 
    ON MOVIES_SUB.actor_id = actors.id
    WHERE MOVIES_SUB.movie_title LIKE 'La guerra de las galaxias%';
    
