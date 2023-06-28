USE empresa_internet;

-- Consulta 1: Obtener el nombre y apellido de aquellos clientes que no tengan un plan contratado
SELECT first_name AS Nombre, last_name AS Apellido
FROM client
WHERE plan_id IS NULL;

-- Consulta 2: Obtener el nombre y apellido de los clientes que tengan el plan Extremo
SELECT first_name AS Nombre, last_name AS Apellido
FROM client
WHERE plan_id = 5;

-- Consulta 3: Obtener nombre de plan de los planes con descuento
SELECT name AS 'Nombre Plan'
FROM Plan
WHERE discount IS NOT NULL;

-- Consulta 4: Obtener nombre y apellido de los clientes que sean de Montevideo
SELECT first_name AS Nombre, last_name AS Apellido
FROM client
WHERE city = 'Montevideo';

-- Consulta 5: Obtener nombre y apellido y fecha de nacimiento de los clientes nacidos despues de 1990
SELECT first_name AS Nombre, last_name AS Apellido, birthday AS 'Fecha de nacimiento'
FROM client
WHERE birthday > '1990-01-01';

-- Consulta 6: Obtener los nombres y costos de los planes que no tengan descuento
-- ordenados por costo de manera descendente
SELECT name AS 'Nombre Plan', price AS 'Precio'
FROM Plan
WHERE discount IS NULL
ORDER BY price DESC;

-- Consulta 7: Obtener la cantidad de ventas por plan
SELECT plan_id, COUNT(*) AS 'Ventas por plan'
FROM client
WHERE plan_id IS NOT NULL
GROUP BY plan_id;

-- Consulta 8: Obtener el plan mas vendido
SELECT plan_id, COUNT(*) AS 'Ventas por plan'
FROM client
WHERE plan_id IS NOT NULL
GROUP BY plan_id
ORDER BY COUNT(*) DESC
LIMIT 1;

-- Consulta 9: Obtener nombre y apellido de los clientes de Solymar nacidos entre 1990 y 2000 con dni terminado en 3
SELECT dni AS DNI, 
first_name AS Nombre,
last_name AS Apellido,
birthday AS 'Fecha de nacimiento'
FROM client
WHERE city = 'Solymar' 
AND birthday BETWEEN '1990-01-01' AND '2000-01-01'
AND dni LIKE '%3';

-- Consulta 10: Obtener el nombre, la velocidad y el precio de los planes con velocidad mayor a 500 de manera descendente por precio
SELECT name AS 'Nombre Plan', speed_connection AS 'Velocidad de conexión', price AS 'Precio'
FROM plan
WHERE speed_connection > 500
ORDER BY price DESC;
