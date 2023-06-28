use empresa;

-- Creación de la tabla DEPARTAMENTO
CREATE TABLE departamentos (
  depto_nro VARCHAR(10) PRIMARY KEY,
  nombre_depto VARCHAR(50),
  localidad VARCHAR(50)
);

-- Creación de la tabla EMPLEADO
CREATE TABLE empleados (
  cod_emp VARCHAR(10) PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  puesto VARCHAR(50),
  fecha_alta DATE,
  salario DECIMAL(10, 2),
  comision DECIMAL(10, 2),
  depto_nro VARCHAR(10),
  FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

