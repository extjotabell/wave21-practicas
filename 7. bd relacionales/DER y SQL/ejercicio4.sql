USE empresa_internet;

-- 1. Obtener todos los clientes con sus planes correspondientes
SELECT c.dni, c.nombre, p.velocidad FROM Clientes as c
JOIN Planes as p ON c.plan_id = p.id;


-- 2. Obtener el plan de un ciente en especifico
SELECT p.* FROM Clientes as c
JOIN Planes as p ON c.plan_id = p.id
WHERE c.dni = '1234567890';


-- 3. Obtener nombre de todos los clientes que adquirieron un plan en especifico
SELECT c.nombre FROM Clientes as c
JOIN Planes as p ON c.plan_id = p.id
WHERE p.id = 1;


-- 4. Obtener obetener id del plant y el numero total de clientes de este plan
SELECT p.id, COUNT(c.dni) as total_clientes FROM Clientes as c
JOIN Planes as p ON c.plan_id = p.id
GROUP BY p.id;


-- 5. Obtener nombre del cliente y velociad del plan de todos los clientes cuya velocidad de plan sea mayor a 100
SELECT c.nombre, p.velocidad FROM Clientes as c
JOIN Planes as p ON c.plan_id = p.id
WHERE p.velocidad > 100;


-- 6. Obtener nombre y fecha de nacimiento de los clientes que nacieron entre 1990 y 2000
SELECT nombre, fecha_nac FROM Clientes WHERE fecha_nac BETWEEN '1990-01-01' AND '2000-12-31';


-- 7. Obetener nombre y fecha de nacimiento de los clientes con la fecha ordenada descendentemente
SELECT nombre, fecha_nac FROM Clientes ORDER BY fecha_nac DESC;


-- 8. Obtener nombre y provincia de los clientes de la provincia Antioquia o Caldas
SELECT nombre, provincia FROM Clientes WHERE provincia = 'Antioquia' OR provincia = 'Caldas';


-- 9. Obtener dni y nombre de un cliente por id
SELECT dni, nombre FROM Clientes WHERE dni = '7765432188';


-- 10. Obtener un plan por id
SELECT * FROM Planes WHERE id = 1;

 