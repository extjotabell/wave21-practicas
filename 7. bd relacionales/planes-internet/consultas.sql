/*Plantear 10 posibles consultas*/


-- 1. Obtener todos los clientes:

SELECT * FROM CLIENTE;

-- 2.Obtener la cantidad total de clientes registrados en la base de datos.

SELECT COUNT(*) FROM CLIENTE;

-- 3. Obtener el plan más rápido disponible.

SELECT * FROM PLAN p
ORDER BY p.velocidad_plan desc
limit 1;

-- 4. obtener todos los planes

SELECT * FROM PLAN;

-- 5. Obtener los clientes que tienen descuento en su plan.

SELECT id_cliente, descuento_plan FROM Plan_X_Cliente 
where descuento_plan > 0;

-- 6. Obtener todas las provincias

Select * from Provincia;


-- 7.Obtener los clientes que tienen planes con descuentos superiores al 10%.

SELECT id_cliente, descuento_plan FROM Plan_X_Cliente 
where descuento_plan > 0.1;

-- 8. Obtener todas las ciudades;

Select * from Ciudad;

-- 9. Obtener el cliente más joven.
SELECT *
FROM Cliente
ORDER BY fecha_nac_cliente ASC
LIMIT 1;

-- 10. Obtener el precio promedio de los planes
SELECT AVG(precio_plan) AS precio_promedio
FROM Plan;

