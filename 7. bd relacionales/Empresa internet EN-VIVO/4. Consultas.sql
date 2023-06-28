-- GROUP 1

-- Mostrar todos los clientes
SELECT * FROM cliente;

-- Mostrar nombre, apellido y fecha nacimiento de los clientes de Buenos aires
SELECT
nombre
,apellido
,fecha_nacimiento
FROM cliente
WHERE provincia = 'Buenos Aires';

-- Mostrar nombre y apellido de cada cliente con el nombre y velocidad de plan asociado plan asociado
SELECT
c.nombre
,c.apellido
,tp.nombre
,tp.velocidad
,p.precio
FROM cliente as c
INNER JOIN plan as p ON c.cliente_id = p.cliente_id
INNER JOIN tipo_plan as tp ON p.tipo_plan_id = tp.tipo_plan_id;

-- Mostrar clientes ordenados por provincia y ciudad
SELECT * FROM Cliente ORDER BY provincia ASC, ciudad ASC;

-- Mostrar clientes con año de nacimiento mayor a 1990
select nombre "Nombre", fecha_nacimiento "Fecha de Nacimiento"
from cliente
where year(fecha_nacimiento) > 1990
order by nombre;

-- Contar la cantidad de clientes
SELECT COUNT(*) AS total_clientes FROM cliente;

-- Mostrar los tipos de planes disponibles ordenados por velocidad del mas rapido al mas lento
SELECT * FROM tipo_plan order by velocidad DESC;

-- Mostrar los clientes de Buenos Aires con mas de 30 años
SELECT * FROM cliente WHERE provincia = 'Buenos Aires' AND fecha_nacimiento < DATE_SUB(CURDATE(), INTERVAL 20 YEAR);

-- Mostrar los planes con mas de 100 megas
select *
from tipo_plan
where velocidad >= 100;