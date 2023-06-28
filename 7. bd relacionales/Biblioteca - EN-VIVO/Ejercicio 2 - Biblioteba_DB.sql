-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Nacionalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'José Luis','Venezolana'),(2,'Gabriel García','francesa'),(3,'Hermann Hesse','Alemana'),(4,'William','Inglesa'),(5,'Julio Cortazar','italiana'),(6,'J.K. Rowling','Inglesa');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `idLector` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'José Luis','González','París 33','informática',28),(2,'Joaquín','Montilla','Da Teresa 28','Diseñador',24),(3,'José Antonio','Cayama','Carmanía 15','Enfermero',30),(4,'Ricardo','Pabón','San Luis 24','Abogado',15),(5,'Gary','Theran','Beatriz 04','Vendedor',25),(6,'Daniel','Morales','Carvajal 190','Analista',38),(7,'Filippo','Galli','Roma 88','informática',55);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `editorial` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'El Lobo Estepario','Salamandra','Novela'),(2,'Cien años de soledad','Universo','Novela'),(3,'Romeo y Julieta','Planeta','Romance'),(4,'Rayuela','Salamandra','Novela'),(5,'El Universo: Guía de viaje','Planeta','internet'),(6,'Siddhartha','Universo','Espiritual'),(7,'Harry Potter 1','Salamandra','Fantasía');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro_autor`
--

DROP TABLE IF EXISTS `libro_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro_autor` (
  `idAutor` int NOT NULL,
  `idLibro` int NOT NULL,
  `idLibroAutor` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idLibroAutor`),
  KEY `idAutor_idx` (`idAutor`),
  KEY `idLibro_idx` (`idLibro`),
  CONSTRAINT `idAutor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_autor`
--

LOCK TABLES `libro_autor` WRITE;
/*!40000 ALTER TABLE `libro_autor` DISABLE KEYS */;
INSERT INTO `libro_autor` VALUES (1,5,1),(2,2,2),(3,1,3),(3,6,4),(4,3,5),(5,4,6),(6,7,7);
/*!40000 ALTER TABLE `libro_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,1,'2022-01-01 00:00:00','2022-01-30 00:00:00','SI',1),(2,2,'2023-01-01 00:00:00','2023-01-30 00:00:00','NO',2),(3,3,'2021-01-01 00:00:00','2021-01-30 00:00:00','SI',3),(4,4,'2020-01-01 00:00:00','2020-01-30 00:00:00','SI',4),(5,4,'2019-01-01 00:00:00','2019-01-30 00:00:00','NO',5),(6,6,'2018-01-01 00:00:00','2018-01-30 00:00:00','SI',6),(7,1,'2023-03-01 00:00:00','2023-03-30 00:00:00','NO',7),(7,7,'2023-03-01 00:00:00','2023-03-30 00:00:00','NO',8);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 19:38:36
