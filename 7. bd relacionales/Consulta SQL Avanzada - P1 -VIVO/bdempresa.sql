-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: bdempresa
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
-- Table structure for table `Departamento`
--

DROP TABLE IF EXISTS `Departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Departamento` (
  `depto_nro` varchar(20) NOT NULL,
  `nombre_depto` varchar(45) NOT NULL,
  `localidad` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departamento`
--

LOCK TABLES `Departamento` WRITE;
/*!40000 ALTER TABLE `Departamento` DISABLE KEYS */;
INSERT INTO `Departamento` VALUES ('D-000-1','Software','Los Tigres'),('D-000-2','Sistemas','Guadalupe'),('D-000-3','Contabilidad','La Roca'),('D-000-4','Ventas','Plata');
/*!40000 ALTER TABLE `Departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Empleado` (
  `cod_emp` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `puesto` varchar(50) NOT NULL,
  `fecha_alta` date NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `comision` decimal(10,2) NOT NULL,
  `depto_nro` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
INSERT INTO `Empleado` VALUES ('E-0001','César','Piñero','Vendedor','2018-05-12',80000.00,15000.00,'D-000-4'),('E-0002','Yosep','Kowaleski','Analista','2015-07-14',140000.00,0.00,'D-000-2'),('E-0003','Mariela','Barrios','Director','2014-06-05',185000.00,0.00,'D-000-3'),('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000.00,10000.00,'D-000-4'),('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',83000.00,10000.00,'D-000-4'),('E-0006','Mito','Barchuk','Presidente','2014-06-05',190000.00,0.00,'D-000-3'),('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000.00,0.00,'D-000-1'),('E-0001','César','Piñero','Vendedor','2018-05-12',80000.00,15000.00,'D-000-4'),('E-0002','Yosep','Kowaleski','Analista','2015-07-14',140000.00,0.00,'D-000-2'),('E-0003','Mariela','Barrios','Director','2014-06-05',185000.00,0.00,'D-000-3'),('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000.00,10000.00,'D-000-4'),('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',83000.00,10000.00,'D-000-4'),('E-0006','Mito','Barchuk','Presidente','2014-06-05',190000.00,0.00,'D-000-3'),('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000.00,0.00,'D-000-1');
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 21:16:01
