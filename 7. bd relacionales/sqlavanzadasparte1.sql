-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select nombre,puesto,localidad
from empleado e join departamento d on e.depto_nro=d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select nombre_depto,count(e.cod_emp) as cantidad_empleados
from empleado e join departamento d on e.depto_nro=d.depto_nro
group by d.depto_nro
having cantidad_empleados>5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select nombre,salario,nombre_depto
from empleado e join departamento d on e.depto_nro=d.depto_nro
where e.puesto=(select puesto from empleado where nombre='Mito' and apellido='Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.*
from empleado e join departamento d on e.depto_nro=d.depto_nro
where nombre_depto='Contabilidad'
order by nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre
from empleado e
where salario=(select min(salario) from empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select nombre
from empleado e
where salario=(select max(salario) from empleado e inner join departamento d on e.depto_nro=d.depto_nro where nombre_depto='Ventas');
