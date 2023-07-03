-- Agregar una película a la tabla movies.

INSERT INTO MOVIES 
VALUES (99, null, null, 'Pelicula nueva agregada', 9.0, 1, '2023-06-04 00:00:00', 3, null);

-- Agregar un género a la tabla genres.

INSERT INTO GENRES
VALUES(99, null, null, 'nuevo genero', 100, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE MOVIES
SET genre_id = 99
WHERE id=99;

-- Modificar la tabla actors para que al menos un actor tenga como 
-- favorita la película agregada en el punto 1.


UPDATE Actors
SET favorite_movie_id = 99
WHERE id=1;

-- Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE tabla_temporal_movies
AS
SELECT *
FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM tabla_temporal_movies mt
WHERE mt.awards < 5;


-- Obtener la lista de todos los géneros que tengan al menos una película.

Select distinct g.name from movies m join genres g on g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.first_name FROM Actors a join movies m on m.id = a.favorite_movie_id 
where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX idx_nombre_movies
ON movies (title);
-- chequee que el índice fue creado correctamente.
-- se creo correctamente 

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? 
-- Analizar y justificar la respuesta.
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta


-- Creería que no ya que no es una base muy grande. 


