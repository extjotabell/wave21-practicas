SELECT * FROM movies;

SELECT * FROM actors;

SELECT first_name,last_name,rating FROM actors;

SELECT title AS titulo FROM series;

SELECT first_name, last_name FROM actors WHERE rating >= 7.5;

SELECT title, rating, awards FROM movies WHERE rating >= 7.5 AND awards > 2;

SELECT title, rating FROM movies ORDER BY rating; 

SELECT title FROM movies LIMIT 3;

SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;

SELECT * FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title = "Toy Story";

SELECT first_name, last_name FROM actors WHERE first_name = "Sam";

SELECT title, release_date  FROM movies WHERE release_date BETWEEN "2004-07-04" AND "2008-07-04";

SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN "1988-02-04" AND "2009-08-04";


