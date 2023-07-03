/*
Mostrar todos los registros de la tabla de movies. 
*/
SELECT * FROM Movies;
/*
Mostrar el nombre, apellido y rating de todos los actores.
*/
Select first_name, last_name, rating from Actors;
/*
Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
*/

Select title as `Título` from Series;

/*Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
*/
SELECT first_name, last_name FROM Actors
where rating >7.5;
/*
Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 
7.5 y con más de dos premios.
*/
select title, rating, awards from Movies 
where rating >7.5 and awards >2;
/*
Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
*/
Select title, rating from Movies
order by rating asc;
/*
Mostrar los títulos de las primeras tres películas en la base de datos.
*/
Select title from Movies
LIMIT 3;
/*
Mostrar el top 5 de las películas con mayor rating.
*/
select * from movies
order by rating desc
limit 5;
/*
Listar los primeros 10 actores.
*/

Select * from Actors
LIMIT 10;
/*
Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
*/
Select title, rating from movies
where title like 'Toy Story';

/*
Mostrar a todos los actores cuyos nombres empiezan con Sam.
*/
select * from Actors
where first_name like 'Sam%';
/*
Mostrar el título de las películas que salieron entre el 2004 y 2008.
*/

Select title from movies
where year(release_date) between 2004 and 2008;
/*
Traer el título de las películas con el rating mayor a 3, 
con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. 
Ordenar los resultados por rating.
*/

Select title from Movies 
where rating < 3
and awards > 1 
and year(release_date) between 1988 and 2009
order by rating;