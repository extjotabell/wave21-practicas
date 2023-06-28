-- Mostrar el título y el nombre del género de todas las series.
select series.title "Título", genres.name "Género"
from series inner join genres
on series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select episodes.title "Título", actors.first_name "Nombre", actors.last_name "Apellido"
from episodes inner join actor_episode inner join actors
on episodes.id = actor_episode.episode_id 
and actors.id = actor_episode.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select series.title as "Título", count(serie_id) as "Total de temporadas"
from series inner join seasons
on series.id = seasons.serie_id
group by serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select genres.name, count(genre_id) as movies_amount
from genres inner join movies
on genres.id = movies.genre_id
group by genre_id
having movies_amount >= 3;


-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct actors.first_name, actors.last_name
from actors 
where actors.id in (
	select actor_movie.actor_id
	from actor_movie inner join movies
	on actor_movie.movie_id = movies.id
	where movies.title like "%guerra de las galaxias%"
	group by actor_id
	having count(actor_id) = count(movies.id)
); 
    
