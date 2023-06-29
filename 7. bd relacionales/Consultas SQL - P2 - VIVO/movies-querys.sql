-- Mostrar todas las peliculas
SELECT *
FROM movies;

-- Mostrar nombre apellido y rating de todos los actores
SELECT first_name, last_name, rating
FROM actors;

-- Mostrar titulo de las series usando alias para poner el campo y tabla en español
SELECT title "Titulo"
FROM series;

-- Mostrar nombre y apellido de actores con rating > 7.5
SELECT first_name, last_name
FROM actors
WHERE rating > 7.5;

-- Mostrar titulos, rating, premios de las peliculas con rating > 7.5 y mas de 2 premios
SELECT title, rating, awards
FROM movies
WHERE rating > 7.5 
AND awards > 2;

-- Mostrar titulo y rating de las peliculas ordenados por rating ASC
SELECT title, rating
FROM movies
ORDER BY rating;

-- Mostrar titulo de las primeras 3 peliculas
SELECT title 
FROM movies 
LIMIT 3;

-- Mostrar top 5 de las peliculas con el mayor rating
SELECT * 
FROM movies 
ORDER BY rating DESC
LIMIT 5;

-- Mostrar primeros 10 actores
SELECT *
FROM actors
LIMIT 10;

-- Mostrar titulo y rating de todas las peliculas que tengan toy story
SELECT title, rating 
FROM movies 
WHERE title LIKE "Toy Story%";

-- Mostrar actores cuyo nombre empieza con sam
SELECT *
FROM actors 
WHERE first_name LIKE "Sam%";

-- Mostrar titulo de las peliculas que salieron entre 2004 y 2008 
SELECT title
FROM movies
WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

-- mostar el titulo de las peliculas con rating > 3, premios > 1 y fecha 1988-2009 ordenado por rating
SELECT title
FROM movies
WHERE YEAR(release_date) BETWEEN 1988 AND 2009
AND rating > 3
AND awards > 1
ORDER BY rating;
