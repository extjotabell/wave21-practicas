-- Creacion de 10 consultas SQL.
use empresa_internet;

-- 1) Obtener todos los clientes de la base de datos:
SELECT * FROM Cliente;

-- 2) Obtener el nombre y apellido de los clientes que viven en la provincia de Buenos Aires:
SELECT nombre, apellido FROM Cliente WHERE provincia = 'Buenos Aires';

-- 3) Obtener los planes de Internet con un descuento aplicado:
SELECT * FROM PlanInternet WHERE descuento > 0;

-- 4) Obtener el número de clientes registrados por ciudad:
SELECT ciudad, COUNT(*) AS num_clientes FROM Cliente GROUP BY ciudad;

-- 5) Obtener los planes de Internet ordenados por velocidad de forma descendente:
SELECT * FROM PlanInternet ORDER BY velocidad DESC;

-- 6)Obtener el precio promedio de los planes de Internet:
SELECT AVG(precio) AS precio_promedio FROM PlanInternet;

-- 7) Obtener los clientes cuyo apellido comienza con la letra "S":
SELECT * FROM Cliente WHERE apellido LIKE 'S%';

-- 8)Obtener los clientes que tienen más de 30 años de edad:
SELECT * FROM Cliente WHERE fecha_nacimiento <= DATE_SUB(CURDATE(), INTERVAL 30 YEAR);

-- 9) Obtener la cantidad de planes de Internet contratados por cada cliente:
SELECT c.id_cliente, c.nombre, c.apellido, COUNT(p.identificacion_plan) AS num_planes
FROM Cliente c
LEFT JOIN PlanInternet p ON c.id_cliente = p.id_cliente
GROUP BY c.id_cliente, c.nombre, c.apellido;

-- 10) Obtener los clientes que tienen un plan de Internet con un precio superior a $80:
SELECT c.* FROM Cliente c
INNER JOIN PlanInternet p ON c.id_cliente = p.id_cliente
WHERE p.precio > 80.00;