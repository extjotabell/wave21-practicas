-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT emp.nombre, emp.apellido, emp.puesto, dep.localidad
FROM departamentos dep JOIN empleados emp ON dep.depto_nro = emp.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT dep.*, count(dep.depto_nro)
FROM departamentos dep JOIN empleados emp ON dep.depto_nro = emp.depto_nro
GROUP BY emp.depto_nro
HAVING count(dep.depto_nro) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp.nombre, emp.apellido, emp.salario, dep.nombre_depto
FROM departamentos dep JOIN empleados emp ON dep.depto_nro = emp.depto_nro
WHERE emp.puesto = 
	(SELECT puesto
	FROM empleados
	WHERE nombre = "Mito" AND apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT emp.*
FROM departamentos dep JOIN empleados emp ON dep.depto_nro = emp.depto_nro
WHERE dep.nombre_depto="Contabilidad" 
ORDER BY dep.nombre_depto;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
	-- Usando Limit
	SELECT nombre
	FROM empleados
	ORDER BY salario ASC
	LIMIT 1;
    
	-- Usando Subconsulta
	SELECT em.nombre
	FROM  empleados AS em
	WHERE em.salario IN 
		(SELECT MIN(salario) 
		FROM empleados);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT emp.*
FROM departamentos dep JOIN empleados emp ON dep.depto_nro = emp.depto_nro
WHERE dep.nombre_depto="Ventas" 
ORDER BY salario DESC
LIMIT 1;