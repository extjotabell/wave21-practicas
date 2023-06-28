-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT dep.nombre_depto, emp.puesto, dep.localidad
FROM departamento dep INNER JOIN empleado emp
WHERE emp.depto_nro = dep.depto_nro
AND emp.puesto = "vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT dep.*
FROM departamento dep INNER JOIN empleado emp
WHERE dep.depto_nro = emp.depto_nro
GROUP BY depto_nro
HAVING COUNT(*) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp.nombre, emp.salario, dep.nombre_depto
FROM empleado emp INNER JOIN departamento dep
WHERE emp.puesto IN(
	SELECT puesto
    FROM empleado
    WHERE nombre = "Mito"
    AND apellido = "Barchuk"
)
AND emp.depto_nro = dep.depto_nro;

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.*
FROM empleado INNER JOIN departamento
WHERE empleado.depto_nro IN (
	SELECT depto_nro
    FROM departamento
    WHERE departamento.nombre_depto = "Contabilidad"
)
AND empleado.depto_nro = departamento.depto_nro
ORDER BY empleado.nombre DESC, empleado.apellido DESC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado
ORDER BY salario
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empleado INNER JOIN departamento
WHERE departamento.depto_nro = empleado.depto_nro
AND departamento.nombre_depto = "Ventas"
ORDER BY empleado.salario DESC
LIMIT 1;