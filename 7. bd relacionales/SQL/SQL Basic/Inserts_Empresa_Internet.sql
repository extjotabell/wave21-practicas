-- Insertando Clientes
INSERT INTO Cliente VALUES (1, 1234567, "Flavio", "Rodriguez", "1997-01-01", "BsAs", "Moron");
INSERT INTO Cliente VALUES (null, 893456, "Juan", "Mora", "1999-04-06", "BsAs", "Moron");
INSERT INTO Cliente VALUES (null, 893456, "Juan", "Mora", "1999-04-06", "BsAs", "Moron");
INSERT INTO Cliente VALUES (null, 893456, "Javier", "Rydel", "1998-09-03", "Montevideo", "Montevideo");
INSERT INTO Cliente VALUES (null, 893456, "Martin", "Bistolfi", "1997-04-06", "Cordoba", "Rio Cuarto");
INSERT INTO Cliente VALUES (null, 893456, "Jorge", "Jorgito", "1999-04-06", "Maldonado", "Maldonado");
INSERT INTO Cliente VALUES (null, 893456, "Pepe", "Pepito", "1995-03-08", "Cordoba", "Cordoba");
INSERT INTO Cliente VALUES (null, 893456, "Martin", "Martinez", "2001-08-23", "Cordoba", "Villa Maria");
INSERT INTO Cliente VALUES (null, 893456, "Francisco", "Javier", "1999-04-06", "Salta", "Salta");
INSERT INTO Cliente VALUES (null, 893456, "Javier", "Marquez", "1999-04-06", "Salta", "Cafayate");

-- Insertando Planes
INSERT INTO Plan_Internet VALUES (1, "Plan 1", 50.0, 399.0, 0.0);
INSERT INTO Plan_Internet VALUES (null, "Plan 2", 50.0, 399.0, 1.0);
INSERT INTO Plan_Internet VALUES (null, "Plan 3", 100.0, 499.0, 2.0);
INSERT INTO Plan_Internet VALUES (null, "Plan 4", 150.0, 599.0, 3.5);
INSERT INTO Plan_Internet VALUES (null, "Plan 5", 200.0, 899.0, 5.0);

-- Visualizo
SELECT * FROM Cliente;
SELECT * FROM Plan_Internet;