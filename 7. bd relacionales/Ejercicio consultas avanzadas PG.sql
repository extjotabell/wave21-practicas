use movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT S.TITLE, G.NAME FROM SERIES S INNER JOIN GENRES G ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT E.TITLE, A.FIRST_NAME, A.LAST_NAME 
FROM ACTOR_EPISODE AE INNER JOIN ACTORS A ON AE.ACTOR_ID= A.ID 
INNER JOIN EPISODES E ON AE.EPISODE_ID = E.ID;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT S.TITLE, COUNT(SEA.SERIE_ID) AS TOTAL_TEMPORADAS 
FROM SERIES S INNER JOIN SEASONS SEA ON S.ID= SEA.SERIE_ID 
GROUP BY S.TITLE;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT G.NAME, COUNT(M.GENRE_ID) AS TOTAL_PELICULAS 
FROM GENRES G INNER JOIN MOVIES M ON G.ID = M.GENRE_ID
GROUP BY G.NAME 
HAVING TOTAL_PELICULAS > 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT A.FIRST_NAME, A.LAST_NAME
FROM ACTOR_MOVIE AM INNER JOIN ACTORS A ON AM.ACTOR_ID= A.ID INNER JOIN MOVIES M ON AM.MOVIE_ID = M.ID
WHERE M.TITLE LIKE'%LA GUERRA DE LAS GALAXIAS%';