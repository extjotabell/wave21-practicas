-- Mostrar todas las peliculas
select *
from movies;

-- Mostrar nombre apellido y rating de todos los actores
select first_name, last_name, rating
from actors;

-- Mostrar titulo de las series usando alias para poner el campo y tabla en español
select title "Titulo"
from series;

-- Mostrar nombre y apellido de actores con rating > 7.5
select first_name, last_name
from actors
where rating > 7.5;

-- Mostrar titulos, rating, premios de las peliculas con rating > 7.5 y mas de 2 premios
select title, rating, awards
from movies
where rating > 7.5 
and awards > 2;

-- Mostrar titulo y rating de las peliculas ordenados por rating ASC
select title, rating
from movies
order by rating;

-- Mostrar titulo de las primeras 3 peliculas
select title 
from movies 
limit 3;

-- Mostrar top 5 de las peliculas con el mayor rating
select * 
from movies 
order by rating desc
limit 5;

-- Mostrar primeros 10 actores
select *
from actors
limit 10;

-- Mostrar titulo y rating de todas las peliculas que tengan toy story
select title, rating 
from movies 
where title like "%Toy Story%";

-- Mostrar actores cuyo nombre empieza con sam
select *
from actors 
where first_name like "Sam%";

-- Mostrar titulo de las peliculas que salieron entre 2004 y 2008 
select title
from movies
where year(release_date) between 2004 and 2008;

-- mostar el titulo de las peliculas con rating > 3, premios > 1 y fecha 1988-2009 ordenado por rating
select title
from movies
where year(release_date) between 1988 and 2009
and rating > 3
and awards > 1
order by rating;
