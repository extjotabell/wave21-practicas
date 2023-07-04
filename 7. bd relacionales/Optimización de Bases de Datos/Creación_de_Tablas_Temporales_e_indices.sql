USE movies_db;

CREATE TEMPORARY TABLE TWD (title VARCHAR(50), season_id INT, season_name VARCHAR(50), season_number INT);

INSERT INTO TWD SELECT e.title, e.season_id, sS.title, ss.number
FROM episodes e
JOIN seasons ss ON e.season_id = ss.id
JOIN series s ON ss.serie_id = s.id
WHERE s.title = 'The Walking Dead';

SELECT title FROM TWD WHERE season_number = 1;
