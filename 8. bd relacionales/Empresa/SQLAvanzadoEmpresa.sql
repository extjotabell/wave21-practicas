-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select
	e.nombre,
    e.puesto,
    d.localidad
from
	empleado e,
    departamento d
where
	e.depto_nro = e.depto_nro;
    
    
-- Visualizar los departamentos con más de cinco empleados.
select
	d.depto_nro,
    d.nombre_depto,
    d.localidad
from
	empleado e,
    departamento d
where
	e.depto_nro = e.depto_nro
group by d.depto_nro, d.nombre_depto, d.localidad having count(*) > 5;
    
    
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select
	e.nombre,
    e.salario,
    d.nombre_depto
from
	empleado e,
    departamento d
where
	e.depto_nro = e.depto_nro
    and e.puesto = 'Mito Barchuk';
    
		
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select
	e.*
from
	empleado e,
    departamento d
where
	e.depto_nro = e.depto_nro
    and d.nombre_depto = 'Contabilidad'
order by e.nombre;
    
    
-- Mostrar el nombre del empleado que tiene el salario más bajo.
select
	e.nombre
from
	empleado e
where
	not exists (select 1 from empleado e2 where e.salario > e2.salario);
    
    
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select
	e.*
from
	empleado e,
    departamento d
where
	e.depto_nro = e.depto_nro
    and d.nombre_depto = 'Ventas'
	and not exists (select 1 from empleado e2 where e.salario < e2.salario);

