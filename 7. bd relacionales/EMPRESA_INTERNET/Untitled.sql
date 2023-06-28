USE Empresa_Internet;

-- Seleccionar todos los clientes
SELECT * FROM Cliente;

-- Seleccionar todos los planes
SELECT * FROM Plan;

-- Seleccionar todos los planes que incluyan servicio de TV
SELECT * FROM Plan WHERE Descripcion LIKE "%TV%";

-- Seleccionar los planes contratados por los clientes

SELECT cli.nombre, pl.descripcion FROM Cliente cli 
INNER JOIN Paquete pa ON cli.idCliente = pa.Cliente_idCliente
INNER JOIN Plan pl ON pa.Plan_idPlan = pl.idPlan