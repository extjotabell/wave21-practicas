-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT em.nombre, em.puesto, de.localidad 
FROM empleados em JOIN departamentos de
ON em.depto_nro = de.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.

SELECT de.* ,COUNT(de.depto_nro)
FROM empleados em JOIN departamentos de
ON em.depto_nro = de.depto_nro
GROUP BY de.nombre_depto
HAVING COUNT(*)>5; 

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, de.nombre_depto
FROM empleados em JOIN departamentos de
ON em.depto_nro = de.depto_nro
WHERE em.puesto IN (SELECT puesto FROM empleados WHERE nombre LIKE "%Mito%");

 
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.-- 
SELECT em.*
FROM empleados em JOIN departamentos de
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = "contabilidad"
ORDER BY em.nombre;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT em.nombre 
FROM empleados AS em
ORDER BY em.salario ASC
LIMIT 1;

SELECT em.nombre
FROM  empleados AS em
WHERE em.salario IN ( SELECT MIN(salario) FROM empleados);
 

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.*
FROM empleados em JOIN departamentos de
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = "ventas"
ORDER BY em.salario DESC
LIMIT 1;

