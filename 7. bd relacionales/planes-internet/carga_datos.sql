-- Inserción de registros en la tabla Provincia
INSERT INTO empresa_internet.Provincia (id_provincia, nombre_provincia)
VALUES
  (1, 'Buenos Aires'),
  (2, 'Córdoba'),
  (3, 'Santa Fe'),
  (4, 'Mendoza'),
  (5, 'Tucumán');

-- Inserción de registros en la tabla Ciudad
INSERT INTO empresa_internet.Ciudad (id_ciudad, nombre_ciudad, id_provincia)
VALUES
  (1, 'Ciudad Autónoma de Buenos Aires', 1),
  (2, 'La Plata', 1),
  (3, 'Córdoba', 2),
  (4, 'Rosario', 3),
  (5, 'Mendoza', 4);

-- Inserción de registros en la tabla Cliente
INSERT INTO empresa_internet.Cliente (id_cliente, dni_cliente, nombre_cliente, apellido_cliente, fecha_nac_cliente, ciudad_cliente)
VALUES
  (1, '12345678', 'Juan', 'Pérez', '1990-01-01', 1),
  (2, '87654321', 'María', 'González', '1985-05-10', 2),
  (3, '56789012', 'Carlos', 'López', '1992-09-15', 1),
  (4, '98765432', 'Laura', 'Fernández', '1995-03-20', 3),
  (5, '34567890', 'Pedro', 'Martínez', '1988-11-12', 4),
  (6, '78901234', 'Ana', 'Sánchez', '1993-07-08', 2),
  (7, '23456789', 'Lucía', 'Rodríguez', '1991-06-05', 3),
  (8, '90123456', 'Diego', 'Gómez', '1987-02-14', 5),
  (9, '65432109', 'Sofía', 'López', '1994-12-25', 2),
  (10, '01234567', 'Javier', 'Hernández', '1989-10-03', 1);

-- Inserción de registros en la tabla Plan
INSERT INTO empresa_internet.Plan (id_plan, velocidad_plan, precio_plan)
VALUES
  (1, 100, 50.00),
  (2, 200, 75.00),
  (3, 300, 100.00),
  (4, 500, 150.00),
  (5, 1000, 200.00);
  
  
-- Inserción de registros en la tabla Plan_X_Cliente -> acá se genera la vinculación entre tablas 
INSERT INTO empresa_internet.Plan_X_Cliente (id_plan, id_cliente, descuento_plan)
VALUES
  (1, 1, 0.1),  -- Cliente Juan Pérez, Plan 100 con descuento del 10%
  (3, 4, 0.05), -- Cliente Laura Fernández, Plan 300 con descuento del 5%
  (5, 7, 0.2);  -- Cliente Lucía Rodríguez, Plan 1000 con descuento del 20%

  
  
