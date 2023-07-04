USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, NOW(), NOW(), 'End Game', 9.7, 4, NOW(), 200, 9);

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13, NOW(), NOW(), 'Deportes', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 10 OR id = 19;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp AS SELECT * FROM movies;
SELECT * FROM movies_temp;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name
FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.id, g.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.id, a.first_name, m.title, m.awards
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies_name ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies WHERE key_name = 'idx_movies_name';

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- No encontré ninguna diferencia ya que el query cost es el mismo con indice y sin el, por lo menos con uno solo en el atributo title.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la de episodes, tambien por el atributo title, ya que se busca por este con frecuencia.