use empresa_internet;
CREATE TABLE Cliente (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  dni INT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  fecha_nacimiento DATE,
  provincia VARCHAR(50),
  ciudad VARCHAR(50)
);

CREATE TABLE PlanInternet (
  identificacion_plan INT PRIMARY KEY AUTO_INCREMENT,
  velocidad INT,
  precio DECIMAL(10, 2),
  descuento DECIMAL(10, 2),
  id_cliente INT,
  FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);