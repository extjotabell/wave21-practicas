/* Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */
SELECT empleado.nombre,empleado.puesto, departament.localidad FROM empleado
INNER JOIN departament ON empleado.depto_nro = departament.depto_nro;

/* Visualizar los departamentos con más de cinco empleados. */
SELECT departament.nombre_depto,COUNT(departament.nombre_depto) as total_empleado FROM departament
INNER JOIN empleado ON departament.depto_nro = empleado.depto_nro
GROUP BY departament.nombre_depto
HAVING total_empleado > 2;

/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */
SELECT empleado.nombre,empleado.salario,departament.nombre_depto FROM empleado
INNER JOIN departament ON empleado.depto_nro = departament.depto_nro
WHERE puesto = "vendedor";

/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */
SELECT * FROM empleado
INNER JOIN departament ON empleado.depto_nro = departament.depto_nro
WHERE departament.nombre_depto = "contabilidad";

/* Mostrar el nombre del empleado que tiene el salario más bajo. */
SELECT * FROM empleado
ORDER BY salario ASC
LIMIT 1;

/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */
SELECT * FROM empleado
INNER JOIN departament ON empleado.depto_nro = departament.depto_nro
WHERE departament.nombre_depto = "ventas"
ORDER BY salario DESC
LIMIT 1;
