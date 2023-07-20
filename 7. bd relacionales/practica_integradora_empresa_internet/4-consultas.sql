-- Consultas

-- Mostrar todos los clientes
SELECT * FROM CLIENTE;

-- Mostrar clientes de Canelones
SELECT * FROM CLIENTE WHERE ciudad = 'CANELONES';

-- Mostrar clientes de Montevideo
SELECT * FROM CLIENTE WHERE ciudad = 'Montevideo';

-- Mostrar nombre y apellido de los clientes con planes asociados y el nombre, velocidad y precio del plan asociado
SELECT c.nombre, c.apellido, tp.nombre, tp.velocidad, p.precio
FROM CLIENTE as c, TIPO_PLAN as tp, PLAN as p
WHERE c.id = p.id AND p.id = tp.id;

-- Mostrar clientes ordenados por provincia y ciudad
SELECT * 
FROM CLIENTE 
ORDER BY provincia ASC, ciudad ASC;

-- Mostrar clientes que nacieron despues del 1995
SELECT nombre, fecha_nacimiento
FROM CLIENTE
WHERE YEAR(fecha_nacimiento) > 1995
ORDER BY nombre;

-- Contar total de clientes
SELECT COUNT(*) AS total_clientes FROM cliente;

-- Mostrar los tipos de planes disponibles ordenados por velocidad del mas lento al mas rapido
SELECT * FROM tipo_plan order by velocidad;

-- Mostrar los tipos de planes disponibles ordenados por velocidad del mas rapido al mas lento
SELECT * FROM tipo_plan order by velocidad DESC;

-- Mostrar los planes con mas de 10 megas
SELECT * FROM tipo_plan WHERE velocidad > 10;
