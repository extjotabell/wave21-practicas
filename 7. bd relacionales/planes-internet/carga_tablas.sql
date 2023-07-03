
-- Creación de la tabla Provincia
CREATE TABLE empresa_internet.Provincia (
  id_provincia INT PRIMARY KEY,
  nombre_provincia VARCHAR(50)
);

-- Creación de la tabla Ciudad
CREATE TABLE empresa_internet.Ciudad (
  id_ciudad INT PRIMARY KEY,
  nombre_ciudad VARCHAR(50),
  id_provincia INT,
  FOREIGN KEY (id_provincia) REFERENCES Provincia(id_provincia)
);

-- Creación de la tabla Cliente
CREATE TABLE empresa_internet.Cliente (
  id_cliente INT PRIMARY KEY,
  dni_cliente VARCHAR(20),
  nombre_cliente VARCHAR(50),
  apellido_cliente VARCHAR(50),
  fecha_nac_cliente DATE,
  ciudad_cliente INT,
  FOREIGN KEY (ciudad_cliente) REFERENCES Ciudad(id_ciudad)
);

-- Creación de la tabla Plan
CREATE TABLE empresa_internet.Plan (
  id_plan INT PRIMARY KEY,
  velocidad_plan INT,
  precio_plan DECIMAL(10, 2)
);

-- Creación de la tabla Plan_X_Cliente
CREATE TABLE empresa_internet.Plan_X_Cliente (
  id_plan INT,
  id_cliente INT,
  descuento_plan DECIMAL(10, 2),
  PRIMARY KEY (id_plan, id_cliente),
  FOREIGN KEY (id_plan) REFERENCES Plan(id_plan),
  FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);
