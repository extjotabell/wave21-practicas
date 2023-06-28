CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE Planes (
	id INT AUTO_INCREMENT PRIMARY KEY,
    velocidad INT,
    precio DECIMAL(10,2),
    descuento DECIMAL(5,2)
);

CREATE TABLE Clientes (
	dni VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    fecha_nac DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
    plan_id INT,
    FOREIGN KEY (plan_id) REFERENCES Planes(id)
);

INSERT INTO PLanes (velocidad, precio, descuento) VALUES
	(120, 120.99, 20),
	(120, 170.99, 25),
	(80, 100, 10),
	(200, 220, 25.5),
    (100, 150.99, 15);
        
INSERT INTO Clientes (dni, nombre, apellido, fecha_nac, provincia, ciudad, plan_id)
VALUES
    ('1234567890', 'Juan', 'Pérez', '1990-05-15', 'Bogota', 'Bogota DC', 1),
    ('9876543210', 'María', 'Gómez', '1988-12-10', 'Vale del cauca', 'Cali', 2),
    ('4567891230', 'Pedro', 'López', '1995-09-22', 'Caldas', 'Manizales', 3),
	('3245678021', 'Carlos', 'Gutierrez', '2010-07-16', 'Antioquia', 'Medellin', 4),
    ('7765432188', 'Marta', 'Torres', '1999-12-23', 'Atlantico', 'Barranquilla', 5),
    ('6543879765', 'Pedro', 'López', '2001-09-22', 'Bolivar', 'Cartagena', 1),
	('1234987654', 'Arnulfo', 'Garcia', '2013-05-25', 'Santander', 'Bucaramanga', 2),
    ('7654993244', 'Karla', 'Castro', '2022-12-31', 'Risaralda', 'Pereira', 3),
    ('3254212673', 'Lola', 'Caicedo', '1995-09-22', 'Magdalena', 'Santa Marta', 4),
    ('9987543212', 'Sasha', 'Higuita', '1994-09-22', 'Meta', 'Villavicencio', 5);
    
    
    
    
