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

DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `depto_nro` varchar(100) COLLATE utf8_unicode_ci NOT NULL, 
  `nombre_depto` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `localidad` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES 
('D-000-1','Software','Los Tigres'),
('D-000-2','Sistemas','Guadalupe'),
('D-000-3','Contabilidad','La Roca'),
('D-000-4','Ventas','Plata');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `cod_emp` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `puesto` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_alta` timestamp NULL DEFAULT NULL,
  `salario` int(10) unsigned NOT NULL,
  `comision` int(10) unsigned NOT NULL,
  `depto_nro` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `departamento_depto_nro_foreign` (`depto_nro`),
  CONSTRAINT `departamento_depto_nro_foreign` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES 
('E-0001','César','Piñero','Vendedor','2018-05-12 00:00:00',80000,15000,'D-000-4'),
('E-0002','Yosep','Kowaleski','Analista','2015-07-14 00:00:00',140000,0,'D-000-2'),
('E-0003','Mariela','Barrios','Director','2014-06-05 00:00:00',185000,0,'D-000-3'),
('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03 00:00:00',85000,10000,'D-000-4'),
('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03 00:00:00',83000,10000,'D-000-4'),
('E-0006','Mito','Barchuk','Presidente','2014-06-05 00:00:00',190000,0,'D-000-3'),
('E-0007','Emilio','Galarza','Desarrollador','2014-08-02 00:00:00',60000,0,'D-000-1');

/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
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
