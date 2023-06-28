-- 001 Mostrar todos los registros de la tabla de cliente con alias en el nombre de la tabla.
select cl.id, 
	   cl.dni, 
       cl.first_name, 
       cl.last_name,
       cl.birth_date,
       cl.province,
       cl.city
  from client cl;

-- 002 Mostrar el nombre, apellido y fecha de nacimiento de todos los clientes con alias en el nombre de la tabla.
select cl.first_name, 
	   cl.last_name, 
       cl.birth_date 
  from client cl;
  
-- 003 Mostrar todos los registros de la tabla plan internet.
select plan_code,
	   mb_speed, 
       price, 
       discount 
  from internet_plan;

-- 004 Mostrar el nombre y apellido de los clientes que cumplen años entre el 2000 y 2005.
select first_name, 
	   last_name
  from client
 where birth_date between "2000-01-01" and "2005-12-31";

-- 005 Mostrar el nombe, apellido, precio de los clientes con una velocidad mayor a 100.
select cl.first_name, 
	   cl.last_name, 
       ip.price
  from client cl, internet_plan ip, service sr
 where sr.fk_client_id = cl.id
   and sr.fk_plan_code = ip.plan_code
   and mb_speed > 100;

-- 006 Mostrar el dni, nombre, apellido y ciudad de la tabla de cliente ordenadas por nombre en forma ascendente.
select dni, 
       first_name, 
       last_name,
       city
  from client
 order by first_name asc;

-- 007 Mostrar los nombres de los primeros tres clientes en la base de datos.
select first_name
  from client
 limit 3;
 
 -- 008 Mostrar el nombre, apellido y provincia de todos las clientes cuyo apellido empiezan con W.
select first_name, 
       last_name,
       province
  from client
 where last_name like "W%";










