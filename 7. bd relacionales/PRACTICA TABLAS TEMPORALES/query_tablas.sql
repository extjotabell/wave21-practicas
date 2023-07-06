CREATE TEMPORARY TABLE TWD (episodes varchar(45) , season varchar(45))
	SELECT ep.title as episodes, se.title as season FROM episodes ep
		JOIN seasons se ON (ep.season_id = se.id)
        JOIN series s ON (se.serie_id = s.id)
        WHERE s.id = 3;

DROP TABLE TWD;
SELECT * FROM TWD;
SELECT * FROM TWD WHERE season LIKE "%Primer%";


-- Se Crea un indice en el titulo de los episodios, ya que es muy comun buscar por el nombre del episodio.
EXPLAIN SELECT * FROM movies_db.episodes WHERE title Like "Valar";

-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES (999,null, null, "SAW I", 9.5, 2, "2012-09-01", 420, null);

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES (98, null, null, "Gore", 55, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 98 WHERE id = 999;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 999 WHERE id = 2;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copia_movies (
	id int,
    created_at timestamp,
    updated_at timestamp,
    title varchar(500),
    rating decimal(3,1),
    awards int,
    release_date datetime,
    length int,
    genre_id int
)
	SELECT * FROM movies;

SELECT * FROM copia_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0; -- Deshabilita el modo seguro de MySql
DELETE FROM copia_movies WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
-- Crear un índice sobre el nombre en la tabla movies.
-- Chequee que el índice fue creado correctamente.
