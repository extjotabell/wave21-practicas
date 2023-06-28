-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select tbl_emp.nombre, 
	   tbl_emp.puesto, 
       tbl_dep.localidad
 from empleado tbl_emp
inner join departamento tbl_dep on tbl_emp.depto_nro = tbl_dep.depto_nro;

-- 2. Visualizar los departamentos con más de cinco empleados.
select count(tbl_emp.cod_emp) cod_emp,
	   tbl_dep.nombre_depto 
 from empleado tbl_emp
inner join departamento tbl_dep on tbl_emp.depto_nro = tbl_dep.depto_nro
group by tbl_dep.nombre_depto
having cod_emp > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select tbl_emp.nombre, 
	   tbl_emp.salario, 
       tbl_dep.nombre_depto
 from empleado tbl_emp
inner join departamento tbl_dep on tbl_emp.depto_nro = tbl_dep.depto_nro
where puesto in (select puesto 
				   from empleado 
				  where nombre = 'Mito' 
                    and apellido = 'Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select tbl_emp.cod_emp, 
	   tbl_emp.nombre,
	   tbl_emp.apellido,
	   tbl_emp.fecha_alta,
	   tbl_emp.salario,
	   tbl_emp.comision,
       tbl_emp.depto_nro
 from empleado tbl_emp
inner join departamento tbl_dep on tbl_emp.depto_nro = tbl_dep.depto_nro
where tbl_dep.nombre_depto in (select nombre_depto 
						         from departamento 
						        where nombre_depto = 'Contabilidad')
 order by tbl_emp.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
select tbl_emp.nombre
 from empleado tbl_emp
 where tbl_emp.salario = (select min(salario) 
					        from empleado);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select nombre
  from empleado
 where salario = (select max(tbl_emp.salario) 
					from empleado tbl_emp
				   inner join departamento tbl_dep on tbl_emp.depto_nro = tbl_dep.depto_nro
				  where tbl_dep.nombre_depto = 'Ventas');


