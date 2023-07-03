-- Mostrar el título y el nombre del género de todas las series.
select 
	s.title, 
    g.name
from 
	series s,
    genres g
where
	g.id = s.genre_id;
    
    
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select
	e.title,
    a.first_name,
    a.last_name
from 
	episodes e,
    actor_episode ae,
    actors a
where
	ae.actor_id = a.id
    and ae.episode_id = e.id;
    
    
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select
	s.title,
    count(*)
from
	series s,
    seasons ss
where
	ss.serie_id = s.id
group by s.title;


-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select
	g.name,
    count(*)
from 
	movies m,
    genres g
where
	g.id = m.genre_id
group by g.name having count(*) > 2;

    
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select
	a.first_name,
    a.last_name
from
	movies m,
    actor_movie am,
    actors a
where 
	m.title like '%la guerra de las galaxias%'
    and am.movie_id = m.id
    and am.actor_id = a.id
group by a.first_name, a.last_name having count(*) = count(distinct m.id)
    
