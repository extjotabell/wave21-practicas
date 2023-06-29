# BD Relacionales

<img width="700" alt="Captura de pantalla 2023-06-28 a la(s) 21 20 46" src="https://github.com/extjotabell/wave21-practicas/assets/133799616/250d4386-5dd4-4afa-aabb-169085a1a729">

<img width="684" alt="Captura de pantalla 2023-06-28 a la(s) 21 21 02" src="https://github.com/extjotabell/wave21-practicas/assets/133799616/406b00c7-2b62-4559-86ca-e9e09bee429b">

1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
```
SELECT d.nombre_depto, e.puesto, d.localidad
FROM Empleado e
JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';
```

2. Visualizar los departamentos con más de cinco empleados
```
SELECT d.nombre_depto, COUNT(*) AS total_empleados
FROM Departamento d
JOIN Empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(*) > 5;
```

3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’ 
```
SELECT e.nombre, e.salario, d.nombre_depto
FROM Empleado e
JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (
  SELECT puesto
  FROM Empleado
  WHERE nombre = 'Mito' AND apellido = 'Barchuk'
)
AND e.nombre != 'Mito' AND e.apellido != 'Barchuk';
```

4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre
```
SELECT *
FROM Empleado e
JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;
```

5. Mostrar el nombre del empleado que tiene el salario más bajo
```
SELECT nombre, apellido
FROM Empleado
WHERE salario = (
  SELECT MIN(salario)
  FROM Empleado
);
```

6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
```
SELECT *
FROM Empleado e
JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;
```
