use movies_db;

select * from movies;

select first_name, last_name, rating from actors;

select title as titulo from series;

select first_name, last_name from actors where rating >7.5;

select title, rating, awards from movies where rating>7.5 and awards>2;

select title, rating from movies order by rating;

select title from movies limit 3;

select * from movies order by rating desc limit 5;

select * from actors limit 10;

select title, rating from movies where title like "Toy Story";

select * from actors where first_name like "sam%"; 

select title from movies where release_date between "2004-01-01" and "2008-12-31";

select title from movies where rating >3 
and awards >1 
and release_date between "1988-01-01" and "2009-12-31" 
order by rating;

-- Parte 2 - PG
select title, g.name from series s
inner join genres g on s.genre_id = g.id;

select e.title, a.first_name, a.last_name from episodes e
inner join actor_episode ae on e.id = ae.episode_id
inner join actors a on ae.actor_id = a.id;

select series.title, count(serie_id) totalSeasons from series 
inner join seasons on seasons.serie_id = series.id
group by series.id;

select g.name, count(m.id) from genres g
inner join movies m on g.id = m.genre_id
group by genre_id
having count(m.id) >= 3;

select distinct a.first_name, a.last_name from actors a
inner join actor_movie am on am.actor_id = a.id
inner join movies m on am.movie_id = m.id
where m.title like "La guerra de las galaxias%";
