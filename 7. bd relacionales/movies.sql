CREATE DATABASE isp;

CREATE TABLE plan(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    speed_connection DOUBLE,
    price DOUBLE NOT NULL,
    discount DOUBLE
);

CREATE TABLE clients (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni INT NOT NULL,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    birthday DATE,
    city VARCHAR(25),
    id_plan INT,
    FOREIGN KEY (id_plan) REFERENCES plan(id)
);

DELIMITER ;;
CREATE FUNCTION totalize (price DOUBLE, discount DOUBLE)
RETURNS DECIMAL
DETERMINISTIC
BEGIN
	RETURN price - (price*(discount/100));
END;;
DELIMITER ;

USE isp;

INSERT INTO plan (name, speed_connection, price, discount) VALUES ("plan lindo", 15.5, 1500, 15.5);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ("plan feo", 5.6, 1500, 5.5);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ("plan economico", 10.5, 800, 5.5);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ("plan belleza", 100.5, 5500, 6.5);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ("plan ricos", 300.5, 9500, 10.5);

INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677566, "Nahuel", "De Bellis", "2000-12-15", "buenos aires", 1);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677567, "Fabri", "De Bellis", "2000-01-15", "buenos aires", 1);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677568, "Adrian", "De Bellis", "2000-03-15", "buenos aires", 1);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677569, "Jose", "De Bellis", "2000-04-15", "buenos aires", 3);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677570, "Orne", "De Bellis", "2000-05-15", "buenos aires", 3);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677571, "Tato", "De Bellis", "2000-06-15", "buenos aires", 3);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677572, "Juanma", "De Bellis", "2000-07-15", "buenos aires", 4);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677573, "Flavio", "De Bellis", "2000-08-15", "buenos aires", 4);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677574, "Gaston", "De Bellis", "2000-09-15", "buenos aires", 6);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (45677575, "Mercedes", "De Bellis", "2000-10-15", "buenos aires", 6);


SHOW TABLES;

SELECT * FROM plan;
SELECT * FROM clients;

-- muestra el pago por cliente
SELECT c.dni, p.price FROM clients c JOIN plan p ON c.id_plan=p.id;

-- muetra el pago por cliente (con descuento)
SELECT c.dni, totalize(p.price, p.discount) as total_with_discount 
FROM clients c 
JOIN plan p ON c.id_plan=p.id;

-- muestra el total de todos los clientes por plan (cuenta descuento)
SELECT p.name, SUM(totalize(p.price, p.discount)) as total_all_clients 
FROM clients c 
JOIN plan p ON c.id_plan=p.id 
GROUP BY p.name;

-- muestra la cantidad de clientes por planes
SELECT COUNT(c.dni), p.name
FROM clients c 
JOIN plan p ON c.id_plan=p.id
GROUP BY p.name;

-- muestro los planes ordenados segun el descuento de manera ascendente
SELECT id, name, discount
FROM plan
ORDER BY discount;

-- muestro los planes ordenados segun el precio de manera ascendente
SELECT id, name, price
FROM plan
ORDER BY price;



