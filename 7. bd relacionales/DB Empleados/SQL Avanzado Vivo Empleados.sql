-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT 
e.nombre, e.puesto, d.localidad 
FROM empleados AS e
INNER JOIN departamentos AS d ON e.depto_nro = d.depto_nro
WHERE e.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT
d.nombre_depto
FROM departamentos d
INNER JOIN empleados e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING count(e.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT 
e.nombre, e.salario, d.nombre_depto
FROM empleados AS e
INNER JOIN departamentos AS d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleados WHERE (nombre = "Mito" AND apellido = "Barchuk"));

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT 
e.*
FROM empleados AS e
INNER JOIN departamentos AS d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT 
CONCAT(e.nombre," ",e.apellido) AS "Nombre Completo"
FROM empleados AS e
WHERE e.salario = (SELECT MIN(salario) FROM empleados);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT 
e.*
FROM empleados AS e
INNER JOIN departamentos AS d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Ventas"
AND e.salario = (SELECT MAX(salario) FROM empleados AS sub_e WHERE sub_e.depto_nro = e.depto_nro)