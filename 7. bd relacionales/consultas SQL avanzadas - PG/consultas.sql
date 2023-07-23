-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s, genres g
WHERE s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT epi.title, act.first_name, act.last_name 
FROM episodes epi, actor_episode act_ep, actors act
WHERE epi.id = act_ep.episode_id AND act.id = act_ep.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(*) "total_seasons"
FROM series s, seasons sea
WHERE s.id = sea.serie_id
GROUP BY title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, COUNT(*) "total_movies"
FROM movies m, genres gen
WHERE m.genre_id = gen.id
GROUP BY gen.name
HAVING COUNT(*) >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT act.first_name, act.last_name 
FROM movies m, actor_movie act_mo, actors act
WHERE act_mo.movie_id = m.id AND act_mo.actor_id = act.id 
AND m.title LIKE "%Guerra de las galaxias%"
GROUP BY act.first_name, act.last_name;