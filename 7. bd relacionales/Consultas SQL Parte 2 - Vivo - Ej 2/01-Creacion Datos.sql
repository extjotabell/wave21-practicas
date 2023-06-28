use empresa_internet;

-- Generar 10 clientes
INSERT INTO Cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
  (12345678, 'Juan', 'Perez', '1990-01-01', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires'),
  (23456789, 'María', 'Gómez', '1985-05-10', 'Buenos Aires', 'La Plata'),
  (34567890, 'Carlos', 'Rodríguez', '1992-07-15', 'Córdoba', 'Córdoba'),
  (45678901, 'Ana', 'López', '1988-03-20', 'Santa Fe', 'Rosario'),
  (56789012, 'Pedro', 'García', '1995-09-05', 'Buenos Aires', 'San Isidro'),
  (67890123, 'Laura', 'Fernández', '1998-12-12', 'Buenos Aires', 'Quilmes'),
  (78901234, 'Martín', 'Sánchez', '1993-06-25', 'Mendoza', 'Mendoza'),
  (89012345, 'Lucía', 'Torres', '1991-04-30', 'Buenos Aires', 'Tigre'),
  (90123456, 'Diego', 'Ramírez', '1987-08-17', 'Buenos Aires', 'Lomas de Zamora'),
  (01234567, 'Carolina', 'Giménez', '1997-11-28', 'Córdoba', 'Villa María');

-- Generar 5 planes de Internet
INSERT INTO PlanInternet (velocidad, precio, descuento, id_cliente)
VALUES
  (10, 50.00, 0.00, 1),
  (20, 70.00, 5.00, 2),
  (50, 100.00, 10.00, 3),
  (30, 60.00, 0.00, 4),
  (40, 80.00, 0.00, 5);
