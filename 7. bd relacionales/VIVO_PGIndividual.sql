Use EMPLEADOS_DEPARTAMENTO;
-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT em.nombre, em.puesto, dp.localidad 
FROM departamentos dp JOIN empleados em ON dp.depto_nro= em.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.

SELECT  dp.*, COUNT(dp.depto_nro)
FROM departamentos dp JOIN empleados em ON dp.depto_nro= em.depto_nro
GROUP BY em.depto_nro
HAVING COUNT(depto_nro)>5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT em.nombre, em.salario, dp.nombre_depto
FROM departamentos dp JOIN empleados em ON dp.depto_nro= em.depto_nro
WHERE em.puesto = (
			SELECT puesto
            FROM empleados emp
            WHERE nombre = 'Mito' and apellido ='Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT em.*
FROM departamentos dp JOIN empleados em ON dp.depto_nro= em.depto_nro
WHERE dp.nombre_depto = 'Contabilidad'
order by em.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT em.nombre 
FROM empleados em 
ORDER BY em.salario asc
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT em.*
FROM departamentos dp JOIN empleados em ON dp.depto_nro= em.depto_nro
WHERE dp.nombre_depto = 'Ventas'
ORDER BY em.salario desc
LIMIT 1;