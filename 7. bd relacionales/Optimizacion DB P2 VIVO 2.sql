CREATE TEMPORARY TABLE TTM SELECT * FROM movies;

SELECT * FROM TTM;

DELETE FROM TTM 
WHERE awards < 5;

SELECT * FROM TTM;

SELECT genres.name FROM TTM
INNER JOIN genres ON TTM.genre_id = genres.id
WHERE TTM.genre_id > 1;

SELECT actors.first_name, actors.last_name FROM TTM
INNER JOIN actor_movie ON TTM.id = actor_movie.movie_id
INNER JOIN actors ON actor_movie.actor_id = actors.id
WHERE awards > 3;

SHOW INDEX FROM movies;
