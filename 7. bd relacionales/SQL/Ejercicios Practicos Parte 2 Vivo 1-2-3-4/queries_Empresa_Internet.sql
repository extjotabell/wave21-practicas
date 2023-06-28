-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

SELECT dni, nombre, apellido
FROM Cliente;

SELECT dni, nombre, apellido
FROM Cliente
WHERE fechaNac > "1998-01-01";

SELECT dni
FROM Cliente
WHERE provincia = "BsAs" AND ciudad = "Moron";

SELECT dni, nombre, apellido
FROM Cliente
ORDER BY fechaNac desc limit 5;

SELECT dni, nombre, apellido
FROM Cliente
WHERE nombre LIKE "J%";

SELECT *
FROM Plan_Internet;

SELECT nombrePlan
FROM Plan_Internet
WHERE velocidadEnMb < 151;

SELECT nombrePlan, velodidadEnMb, precio
FROM Plan_Internet
WHERE descuento > 2;

SELECT nombrePlan
FROM Plan_Internet
ORDER BY precio ASC;

SELECT nombrePlan
FROM Plan_Internet
WHERE precio BETWEEN 499 AND 799;
