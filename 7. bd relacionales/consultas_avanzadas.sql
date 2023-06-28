CREATE DATABASE empresas;

use empresa;

CREATE TABLE departamentos (
depto_nro VARCHAR(10) PRIMARY KEY,
nombre_depto VARCHAR(15),
localidad VARCHAR(15)
);

CREATE TABLE empleados (
cod_emp VARCHAR(10) PRIMARY KEY NOT NULL,
nombre VARCHAR(15) NOT NULL,
apellido VARCHAR(15) NOT NULL,
puesto VARCHAR(15),
fecha_alta DATE,
salario DOUBLE,
comision DOUBLE,
depto_nro VARCHAR(15),
FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, d.localidad, e.puesto 
FROM empleados AS e 
JOIN departamentos AS d ON d.depto_nro=e.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, COUNT(e.cod_emp) as total_empleados
FROM empleados 
JOIN departamentos AS d ON d.depto_nro=e.depto_nro 
GROUP BY d.depto_nro
HAVING total_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados
JOIN departamenotos as d ON d.depto_nro=e.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleados WHERE nombre= "Mito" AND apellido="Barchuk" LIMIT 1)
AND nombre <> "Mito"
AND apellido <> "Barchuk";

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* 
FROM empleados as e
JOIN departamentos AS d ON d.depto_nro=e.depto_nro
WHERE d.nombre_depto="contabilidad"
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleados
ORDER BY salario ASC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.nombre
FROM empleados AS e
JOIN departamentos AS d ON d.depto_nro=e.depto_nro
WHERE d.nombre_depto="Ventas"
ORDER BY e.salario DESC
LIMIT 1;