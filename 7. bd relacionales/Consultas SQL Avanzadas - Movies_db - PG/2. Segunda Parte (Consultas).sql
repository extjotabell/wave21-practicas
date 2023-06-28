-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name
FROM series se INNER JOIN genres ge
WHERE se.genre_id = ge.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, act.first_name, act.last_name 
FROM episodes ep
INNER JOIN actor_episode act_ep
INNER JOIN actors act
WHERE ep.id = act_ep.episode_id
AND act.id = act_ep.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, COUNT(*) "total_seasons"
FROM series ser INNER JOIN seasons sea
WHERE ser.id = sea.serie_id
GROUP BY title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, COUNT(*) "total_movies"
FROM movies mo INNER JOIN genres gen
WHERE mo.genre_id = gen.id
GROUP BY gen.name
HAVING COUNT(*) >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT act.first_name, act.last_name 
FROM movies mo 
INNER JOIN actor_movie act_mo
INNER JOIN actors act
WHERE act_mo.movie_id = mo.id
AND act_mo.actor_id = act.id
AND mo.title LIKE "%Guerra de las galaxias%"
GROUP BY act.first_name, act.last_name;

