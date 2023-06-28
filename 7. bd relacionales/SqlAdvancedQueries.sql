-- Mostrar el título y el nombre del género de todas las series.
select title,name 
from movies 
inner join genres;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select title,first_name,last_name 
from episodes e
inner join actor_episode a on a.episode_id=e.id
inner join actors on actors.id=a.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title,count(number)
from series ser 
inner join seasons sea on ser.id=sea.serie_id
group by title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select gen.name,count(mov.id) 
from genres gen inner join movies mov on gen.id=mov.genre_id
group by name
having count(mov.id)>3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct first_name,last_name
from movies m 
inner join actor_movie am on am.movie_id=m.id
inner join aactor_moviectors a on am.actor_id=a.id
where title like "La Guerra de las galaxias%";