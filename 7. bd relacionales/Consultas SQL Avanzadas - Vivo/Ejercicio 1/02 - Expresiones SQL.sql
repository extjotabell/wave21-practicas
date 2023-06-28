use empresa;

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select 
	e.nombre,
    e.apellido,
    e.puesto,
    d.localidad
from empleados e
inner join departamentos d
on e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select 
	count(e.cod_emp) as contador,
    d.depto_nro,
    d.nombre_depto
from departamentos d
inner join empleados e
on d.depto_nro = e.depto_nro
group by d.depto_nro
having contador > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select 
	e.nombre,
    e.apellido,
    e.salario,
    d.nombre_depto
from empleados e
inner join departamentos d
on d.depto_nro = e.depto_nro
where e.puesto = (select puesto
				 from empleados
				 where nombre = 'Mito' and apellido = 'Barchuk'
                 limit 1)
	and e.nombre <> 'Mito' and e.apellido <> 'Barchuk';

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select *
from empleados e
inner join departamentos d
on d.depto_nro = e.depto_nro
where d.nombre_depto = 'contabilidad'
order by e.nombre, e.apellido asc;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre
from empleados
order by salario asc
limit 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleados e
inner join departamentos d
on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Ventas'
order by e.salario desc
limit 1;


