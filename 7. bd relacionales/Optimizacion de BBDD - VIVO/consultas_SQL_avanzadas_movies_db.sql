-- 1. Agregar una película a la tabla movies.
INSERT INTO movies VALUES (1,'2022-01-01 00:00:00', '2023-01-01 00:00:00','Harry Potter', 8.5, 15, '2001-20-09 00:00:00', 200, 2);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUES (2, '2019-01-01 00:00:00', '2023-01-01 00:00:00', 'Fantasy', 13, 1);

-- 3.Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 
	(SELECT id FROM genres WHERE name = 'Fantasy')
WHERE title = 'Harry Potter';

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET favorite_movie_id = 1 
WHERE first_name = 'Leonardo' AND last_name = 'Di Caprio';

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp 
	SELECT * FROM movies;
    
-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT genres.id, genres.name, count(*) as movies 
FROM genres, movies
WHERE genres.id = movies.genre_id
GROUP BY genres.id
HAVING movies >= 1;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.first_name, actors.last_name, movies.awards 
FROM actors ,movies 
WHERE awards > 3;
    
-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_name_idx ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- R: 

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- R.: Crearia un indice en la tabla actors en la comuna awards, ya que se uso en algunas consultas de otros ejercicios tambien.
