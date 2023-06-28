USE movies_db;
-- 1
SELECT * FROM movies;
-- 2
SELECT first_name, last_name, rating from actors;
-- 3
SELECT title AS titulo FROM series;
-- 4
SELECT first_name, last_name, rating 
FROM actors 
WHERE rating > 7.5;
-- 5
SELECT title, rating
FROM movies
WHERE rating > 7.5 AND awards > 2;
-- 6
SELECT title, rating
FROM movies
ORDER BY rating ASC;
-- 7
SELECT title FROM movies LIMIT 3;
-- 8
SELECT title 
FROM movies
ORDER BY rating 
LIMIT 5;
-- 9
SELECT * FROM actors LIMIT 10;
-- 10
SELECT title, rating
FROM movies 
WHERE title LIKE "%Toy Story%";
-- 11
SELECT first_name, last_name
FROM actors
WHERE first_name LIKE "Sam%";
-- 12
SELECT title
FROM movies
WHERE release_date > "2004-01-01" 
AND release_date < "2005-12-31";
-- 13
SELECT title 
FROM movies 
WHERE rating > 3.0
AND awards > 1 
AND release_date > "1988-01-01" 
AND release_date < "2009-12-31";
