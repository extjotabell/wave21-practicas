CREATE DATABASE internet_plan;
use internet_plan;
drop table plan;
CREATE TABLE PLAN(
	id_plan INT NOT NULL primary key,
    velocidad_megas DOUBLE,
    precio DOUBLE,
    descuento DOUBLE);

CREATE TABLE CLIENTE(
	id_cliente INT NOT NULL,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
    plan_id int,
    FOREIGN KEY(plan_id) REFERENCES PLAN(id_plan));
    
INSERT INTO PLAN (id_plan, velocidad_megas, precio, descuento) VALUES
(1, 50, 29.99, 0),
(2, 100, 39.99, 0),
(3, 200, 49.99, 0),
(4, 500, 59.99, 10),
(5, 1000, 69.99, 10);

INSERT INTO CLIENTE VALUES(1, "JUAN", "PERDOMO", "2000-05-04","MONTEVIDEO","MONTEVIDEO",2);
INSERT INTO CLIENTE VALUES(2, "FRANCO", "LEITES", "2000-05-04","SALTO","CIUDAD DE SALTO",1);
INSERT INTO CLIENTE VALUES(3, "CARLOS", "FLORES", "1998-05-03","FLORIDA","MERCEDES",3);
INSERT INTO CLIENTE VALUES(4, "MARTINA", "MARICHAL", "1995-10-04","SAN JOSE","TACUARI",4);
INSERT INTO CLIENTE VALUES(5, "FRANCISCO", "MACHADO", "1950-12-15","CANELONES","LAGOMAR",5);
INSERT INTO CLIENTE VALUES(6, "PABLO", "CASTRO", "2000-05-04","MONTEVIDEO","MONTEVIDEO",1);
INSERT INTO CLIENTE VALUES(7, "FRANCISCA", "MARTINEZ", "1998-05-03","FLORIDA","MERCEDES",2);
INSERT INTO CLIENTE VALUES(8, "JUAN", "PASOS", "2021-1-04","SAN JOSE","TACUARI",1);
INSERT INTO CLIENTE VALUES(9, "JORGE", "ZEBALLOS", "2022-12-25","CERRO LARGO","MELO",4);
INSERT INTO CLIENTE VALUES(10, "MARIO", "RODRIGUEZ", "2015-05-04","MONTEVIDEO","MONTEVIDEO",2);

-- Obtener todos los planes con una velocidad mayor a 100
select * from plan where velocidad_megas > 100;

-- Obtener el plan con mayor precio 
SELECT * FROM PLAN WHERE precio = (SELECT MAX(precio) FROM PLAN);

-- Obtener todos los clientes de Montevideo
select * from cliente where provincia = "MONTEVIDEO";

-- Obtener los clientes menores de edad
SELECT * FROM CLIENTE WHERE FECHA_NACIMIENTO > '2004-01-01';

-- Obtener los clientes que hayan contratado el plan 2
SELECT * FROM CLIENTE WHERE PLAN_ID = 2;

-- Obtener los clientes que hayan nacido entre 1990 y 2022
SELECT * FROM CLIENTE WHERE FECHA_NACIMIENTO BETWEEN '1990-01-01' AND '2023-01-01';

-- Obtener la cantidad total de clientes hasta el momento
SELECT COUNT(ID_CLIENTE) AS CANTIDAD_CLIENTE FROM CLIENTE;

-- Obtener la suma total de precios de los planes
SELECT SUM(PRECIO) AS TOTAL_PRECIO_PLANES FROM PLAN;

-- Obtener todos los clientes nacidos en Montevideo y despues del 2000 ordenados de forma ascendente por nombre
SELECT * FROM CLIENTE WHERE PROVINCIA = 'MONTEVIDEO' AND FECHA_NACIMIENTO > '2000-01-01' ORDER BY NOMBRE;

-- Obtener los 5 primeros clientes
SELECT * FROM CLIENTE LIMIT 5;
