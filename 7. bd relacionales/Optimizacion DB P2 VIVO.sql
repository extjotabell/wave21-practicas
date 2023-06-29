CREATE TEMPORARY TABLE TWD (
		episode_name VARCHAR(45) PRIMARY KEY
);

INSERT INTO TWD(episode_name)
SELECT episodes.title FROM episodes
INNER JOIN seasons ON episodes.season_id = seasons.id
INNER JOIN series ON seasons.serie_id = series.id
WHERE serie_id = 3;

SELECT * FROM TWD;