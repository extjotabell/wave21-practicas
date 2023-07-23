CREATE SCHEMA IF NOT EXISTS `BibliotecaDB` DEFAULT CHARACTER SET utf8 ;
USE `BibliotecaDB` ;

DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Nacionalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idAutor`)
) 

INSERT INTO `autor` VALUES 
(1,'Maria Perez','Uruguaya'),
(2,'Liam Payne','China'),
(3,'Camilo Rodriguez','Argentina'),
(4,'William Shake','Americana'),
(5,'Julio Equis','Francesa'),
(6,'J.K. Rowling','Inglesa');


DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `idLector` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) 

INSERT INTO `estudiante` VALUES 
(1,'Camila','Perez','París 32','informática',28),
(2,'Joaquín','Montilla','Da Teresa 28','Diseñador',24),
(3,'José Antonio','Cayama','Carmanía 15','Enfermero',30),
(4,'Ricardo','Pabón','San Luis 24','Abogado',15),
(5,'Gary','Theran','Beatriz 04','Vendedor',25),
(6,'Daniel','Morales','Carvajal 190','Analista',38),
(7,'Filippo','Galli','Roma 88','informática',55);

DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `editorial` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  PRIMARY KEY (`idLibro`)
) 

INSERT INTO `libro` VALUES 
(1,'El Lobo Estepario','Salamandra','Novela'),
(2,'Cien años de soledad','Universo','Novela'),
(3,'Romeo y Julieta','Planeta','Romance'),
(4,'Rayuela','Salamandra','Novela'),
(5,'El Universo: Guía de viaje','Planeta','internet'),
(6,'Siddhartha','Universo','Espiritual'),
(7,'Harry Potter 1','Salamandra','Fantasía');

DROP TABLE IF EXISTS `libro_autor`;
CREATE TABLE `libro_autor` (
  `idAutor` int NOT NULL,
  `idLibro` int NOT NULL,
  `idLibroAutor` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idLibroAutor`),
  KEY `idAutor_idx` (`idAutor`),
  KEY `idLibro_idx` (`idLibro`),
  CONSTRAINT `idAutor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`)
)

INSERT INTO `libro_autor` VALUES 
(1,5,1),(2,2,2),(3,1,3),(3,6,4),(4,3,5),(5,4,6),(6,7,7);

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE `prestamo` (
  `idLector` int NOT NULL,
  `idLibro` int NOT NULL,
  `fecha_prestamo` datetime DEFAULT NULL,
  `fecha_devolucion` datetime DEFAULT NULL,
  `devuelto` varchar(10) DEFAULT NULL,
  `idPrestamo` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPrestamo`),
  KEY `idLector_idx` (`idLector`),
  KEY `idLibro_idx` (`idLibro`),
  CONSTRAINT `idLector` FOREIGN KEY (`idLector`) REFERENCES `estudiante` (`idLector`),
  CONSTRAINT `idLibro` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) 

INSERT INTO `prestamo` VALUES 
(1,1,'2022-01-01 00:00:00','2022-01-30 00:00:00','SI',1),
(2,2,'2023-01-01 00:00:00','2023-01-30 00:00:00','NO',2),
(3,3,'2021-01-01 00:00:00','2021-01-30 00:00:00','SI',3),
(4,4,'2020-01-01 00:00:00','2020-01-30 00:00:00','SI',4),
(5,4,'2019-01-01 00:00:00','2019-01-30 00:00:00','NO',5),
(6,6,'2018-01-01 00:00:00','2018-01-30 00:00:00','SI',6),
(7,1,'2023-03-01 00:00:00','2023-03-30 00:00:00','NO',7),
(7,7,'2023-03-01 00:00:00','2023-03-30 00:00:00','NO',8);
