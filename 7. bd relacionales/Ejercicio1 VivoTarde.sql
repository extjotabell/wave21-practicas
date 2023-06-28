CREATE DATABASE EMPLEADOS_DEPARTAMENTO;
USE EMPLEADOS_DEPARTAMENTO;

CREATE TABLE departamentos (
  depto_nro VARCHAR(8) PRIMARY KEY,
  nombre_depto VARCHAR(50),
  localidad VARCHAR(50)
);

INSERT INTO departamentos (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


CREATE TABLE empleados (
  cod_emp VARCHAR(6) PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  puesto VARCHAR(50),
  fecha_alta DATE,
  salario DECIMAL(10, 2),
  comision DECIMAL(10, 2),
  depto_nro VARCHAR(8),
  FOREIGN KEY(DEPTO_NRO) REFERENCES DEPARTAMENTOS(DEPTO_NRO)
);

INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0008', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1'),
('E-0009', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0010', 'Mito', 'Barchuk', 'Vendedor', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0011', 'Emilio', 'Galarza', 'Vendedor', '2014-08-02', 60000, 0, 'D-000-1');
SELECT * FROM EMPLEADOS;
-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT E.NOMBRE, E.PUESTO, D.LOCALIDAD 
FROM EMPLEADOS E 
INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE E.PUESTO = "VENDEDOR"; 

-- Visualizar los departamentos con más de cinco empleados.
SELECT D.NOMBRE_DEPTO, COUNT(E.DEPTO_NRO) AS CANTIDAD_EMPLEADOS 
FROM DEPARTAMENTOS D INNER JOIN EMPLEADOS E ON E.DEPTO_NRO = D.DEPTO_NRO
GROUP BY D.NOMBRE_DEPTO
HAVING CANTIDAD_EMPLEADOS > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT E.NOMBRE, E.SALARIO, D.NOMBRE_DEPTO
FROM EMPLEADOS E INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE E.PUESTO IN 
(SELECT E.PUESTO FROM EMPLEADOS E WHERE E.NOMBRE = "MITO" AND E.APELLIDO = "Barchuk")
AND E.NOMBRE != "MITO";

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT E.*
FROM EMPLEADOS E INNER JOIN DEPARTAMENTOS D ON E.DEPTO_NRO = D.DEPTO_NRO
WHERE D.NOMBRE_DEPTO = "CONTABILIDAD"
ORDER BY E.NOMBRE;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT E.NOMBRE
FROM EMPLEADOS E
ORDER BY SALARIO 
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT E.*
FROM EMPLEADOS E
ORDER BY SALARIO DESC 
LIMIT 1

