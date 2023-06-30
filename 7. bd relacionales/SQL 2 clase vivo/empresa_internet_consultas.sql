-- a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
-- el id del cliente ya que como es un dato unico nos aseguramos de tener una identificacion unica en la db.

-- b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
-- el id del plan ya que como es un dato unico nos aseguramos de tener una identificacion unica en la db.

-- c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
-- la relacion es 1 a n, donde un plan puede tener muchos clientes lo cual la tabla de clientes tendra la FK que hace referencia al id del plan.


CREATE DATABASE empresa_internet;

USE empresa_internet;

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

INSERT INTO plan (name, speed_connection, price, discount) VALUES ('Plan 1', 100.0, 50.0, 0.0);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ('Plan 2', 200.0, 70.0, 0.1);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ('Plan 3', 300.0, 90.0, 0.2);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ('Plan 4', 400.0, 110.0, 0.3);
INSERT INTO plan (name, speed_connection, price, discount) VALUES ('Plan 5', 500.0, 130.0, 0.4);

INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (11111111, 'John', 'Doe', '1990-01-01', 'New York', 1);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (22222222, 'Jane', 'Smith', '1985-02-02', 'Los Angeles', 2);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (33333333, 'Mike', 'Johnson', '1992-03-03', 'Chicago', 3);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (44444444, 'Emily', 'Williams', '1988-04-04', 'Houston', 4);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (55555555, 'David', 'Brown', '1994-05-05', 'San Francisco', 5);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (66666666, 'Sarah', 'Davis', '1991-06-06', 'Seattle', 1);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (77777777, 'Michael', 'Anderson', '1987-07-07', 'Miami', 2);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (88888888, 'Jessica', 'Taylor', '1993-08-08', 'Boston', 3);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (99999999, 'Christopher', 'Wilson', '1989-09-09', 'Dallas', 4);
INSERT INTO clients (dni, first_name, last_name, birthday, city, id_plan) VALUES (12345678, 'Amanda', 'Moore', '1995-10-10', 'Austin', 5);

SELECT * FROM clients;
SELECT * FROM plan WHERE speed_connection > 300;
SELECT * FROM clients WHERE city = "Dallas";
SELECT * FROM plan WHERE discount > 0.1 AND discount < 0.4;
SELECT * FROM clients ORDER BY last_name DESC;
SELECT name, price FROM plan;
SELECT COUNT(*) AS total_clientes FROM clients;
SELECT * FROM clients LIMIT 3;
SELECT * FROM clients WHERE birthday > "1993-01-01";
SELECT * FROM clients WHERE first_name LIKE "M%";

