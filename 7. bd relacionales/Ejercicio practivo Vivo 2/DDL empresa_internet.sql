CREATE DATABASE empresa_internet;

CREATE TABLE Plan(
	plan_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    speed_connection DOUBLE NOT NULL,
    price DOUBLE NOT NULL,
    discount DOUBLE
);

CREATE TABLE Client (
	client_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni VARCHAR(10) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    birthday DATE,
    city VARCHAR(25),
    plan_id INT,
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
);

USE empresa_internet;

INSERT INTO Plan VALUES 
(null,'Plan Basico', 100, 49.99, NULL),
(null,'Plan Intermedio', 500, 249.99, NULL),
(null,'Plan Avanzado', 1000, 349.99, 5.5),
(null,'Plan Muy Avanzado', 5000, 449.99, 10),
(null,'Plan Extremo', 20000, 599.99, 15);

INSERT INTO Client VALUES
(null, '1.123.233', 'Juan', 'Perez', '1996-06-02', 'Montevideo', 1),
(null, '3.123.233', 'Jose', 'Wise', '1997-06-02', 'Solymar', 2),
(null, '4.123.233', 'Gaston', 'Perez', '2000-06-02', 'Solymar', 3),
(null, '5.123.233', 'Carlo', 'Bolson', '1970-06-02', 'Montevideo', 4),
(null, '1.124.233', 'Mauricio', 'Perez', '1956-06-02', 'Solymar', NULL),
(null, '3.125.233', 'Josefina', 'Perez', '1946-06-02', 'Montevideo', 2),
(null, '4.126.235', 'Raquel', 'Rodriguez', '1999-06-02', 'Montevideo', 5),
(null, '5.127.236', 'Julian', 'Perez', '1996-07-02', 'Solymar', 4), 
(null, '5.127.237', 'Sebastian', 'Perez', '1996-02-04', 'Montevideo', 4),
(null, '5.127.238', 'Kratos', 'Aguila', '1996-03-02', 'Montevideo', 5);
