-- MySQL Workbench 8.0.33
--
-- Host: localhost    Database: laravel-database
-- ------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `id_autor` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nacionalidad` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES 
(101,'J.K. Rowling','Britanica'),
(102,'Oliver Berry','Frances'),
(103,'Paulo Coelho','Brasileño'),
(104,'Gabriel García Márquez','Colombiano'),
(105,'Stephen King','Estadounidense'),
(106,'Francisco Blasco','Colombiano');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `id_lector` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `carrera` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `edad`  int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES 
(1001,'Sam','Worthington','calle 12 # 245-12','Informatica',34),
(1002,'Sigourney','Weaver','diagonal 12b # 245-12','Humanidades',25),
(1003,'Filippo','Galli','calle 12 sur # 245-12','Medicina',18),
(1004,'Kate','Winslet','calle 12 # 245-12 sur','Derecho',28),
(1005,'Billy','Zane','carrera 12 # 245-12','Contabilidad',42);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `id_libro` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8_unicode_ci NOT NULL, 
  `editorial` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `area` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES 
(1,'Harry Potter y la piedra filosofal','Salamandra','Literatura fantástica'),
(2,'Harry Potter y la Orden del Fénix','Salamandra','Literatura fantástica'),
(3,'El Universo: Guía de viaje','GeoPlaneta',' Viaje y aventura'),
(4,'Programación Orientada a Objetos en Java','Ediciones de la U','Software'),
(5,'El resplandor','Doubleday','Novela');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro_autor`
--

DROP TABLE IF EXISTS `libro_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro_autor` (
  `fk_id_autor` int(10) unsigned NOT NULL,
  `fk_id_libro` int(10) unsigned NOT NULL,
  KEY `libro_au_id_autor_foreign` (`fk_id_autor`),
  KEY `libro_au_id_libro_foreign` (`fk_id_libro`),
  CONSTRAINT `libro_au_id_autor_foreign` FOREIGN KEY (`fk_id_autor`) REFERENCES `autor` (`id_autor`),
  CONSTRAINT `libro_au_id_libro_foreign` FOREIGN KEY (`fk_id_libro`) REFERENCES `libro` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_autor`
--

LOCK TABLES `libro_autor` WRITE;
/*!40000 ALTER TABLE `libro_autor` DISABLE KEYS */;
INSERT INTO `libro_autor` VALUES 
(101,1),
(101,2),
(102,3),
(106,4),
(105,5);
/*!40000 ALTER TABLE `libro_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `fk_id_lector` int(10) unsigned NOT NULL,
  `fk_id_libro` int(10) unsigned NOT NULL,
  `fecha_prestamo` timestamp NULL DEFAULT NULL,
  `fecha_devolucion` timestamp NULL DEFAULT NULL,
  `devuelto` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  KEY `prestamo_id_lector_foreign` (`fk_id_lector`),
  KEY `prestamo_id_libro_foreign` (`fk_id_libro`),
  CONSTRAINT `prestamo_id_lector_foreign` FOREIGN KEY (`fk_id_lector`) REFERENCES `autor` (`id_autor`),
  CONSTRAINT `prestamo_id_libro_foreign` FOREIGN KEY (`fk_id_libro`) REFERENCES `libro` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES 
(1001,1,'2018-05-12 00:00:00','2018-05-17 00:00:00','Devuelto'),
(1002,2,'2023-05-12 00:00:00','2023-06-12 00:00:00','Devuelto'),
(1003,3,'2021-07-12 00:00:00','2021-08-29 00:00:00','Devuelto'),
(1004,4,'2022-05-15 00:00:00','2022-05-30 00:00:00','Devuelto'),
(1005,5,'2023-06-12 00:00:00','2018-06-27 00:00:00','Devuelto'),
(1002,1,'2023-05-12 00:00:00','2018-12-17 00:00:00','No Devuelto'),
(1003,2,'2023-05-12 00:00:00','2023-09-12 00:00:00','No Devuelto'),
(1004,3,'2023-06-12 00:00:00','2023-08-29 00:00:00','No Devuelto'),
(1005,4,'2023-05-15 00:00:00','2023-06-30 00:00:00','No Devuelto'),
(1001,5,'2023-06-12 00:00:00','2023-07-12 00:00:00','No Devuelto'),
(1001,1,'2018-05-12 00:00:00','2021-07-16 00:00:00','Devuelto'),
(1002,2,'2023-05-12 00:00:00','2021-07-16 00:00:00','Devuelto'),
(1003,3,'2021-07-12 00:00:00','2021-07-16 00:00:00','Devuelto');
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

-- Dump completed on 2023-06-28 11:09:28
