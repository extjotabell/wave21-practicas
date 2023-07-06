CREATE DATABASE empresas;

use empresas;

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
FOREIGN KEY (depto_nro) REFERENCES departamentos(depto_nro)
);

INSERT INTO departamentos (depto_nro, nombre_depto, localidad)
VALUES
  ('D-000-1', 'Software', 'Los Tigres'),
  ('D-000-2', 'Sistemas', 'Guadalupe'),
  ('D-000-3', 'Contabilidad', 'La Roca'),
  ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
  ('E-0001', 'C√©sar', 'Pi√±ero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
  ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
  ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
  ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
  ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
  ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
  ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, d.localidad, e.puesto 
FROM empleados AS e 
JOIN departamentos AS d ON d.depto_nro=e.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, COUNT(e.cod_emp) as total_empleados
FROM empleados AS e
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