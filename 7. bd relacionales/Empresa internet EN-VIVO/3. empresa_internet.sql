-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (x86_64)
--
-- Host: localhost    Database: empresa_internet
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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `provincia` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'30123453','Juan','Pérez','1990-05-15','Buenos Aires','La Plata'),(2,'30123434','María','González','1985-09-22','Córdoba','Córdoba'),(3,'30122434','Carlos','López','1992-07-10','Mendoza','Mendoza'),(4,'30123451','Ana','Rodríguez','1988-03-02','Santa Fe','Rosario'),(5,'30123458','Pedro','Martínez','1995-11-18','Tucumán','San Miguel de Tucumán'),(6,'31123425','Laura','Fernández','1991-12-07','Salta','Salta'),(7,'32123453','Diego','Torres','1987-08-25','Entre Ríos','Paraná'),(8,'35123453','Silvia','Sánchez','1994-02-12','Chubut','Rawson'),(9,'38123453','Federico','Gómez','1993-06-30','Neuquén','Neuquén'),(10,'39123453','Valeria','López','1990-04-08','San Juan','San Juan');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `precio` decimal(2,0) NOT NULL,
  `descuento` decimal(2,0) NOT NULL,
  `cliente_id` int NOT NULL,
  `tipo_plan_id` int NOT NULL,
  PRIMARY KEY (`plan_id`),
  KEY `cliente_id_idx` (`cliente_id`),
  KEY `tipo_plan_id_idx` (`tipo_plan_id`),
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`),
  CONSTRAINT `tipo_plan_id` FOREIGN KEY (`tipo_plan_id`) REFERENCES `tipo_plan` (`tipo_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,10,0,1,1),(2,20,5,2,1),(3,30,10,3,2),(4,40,15,4,3),(5,50,20,5,4);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_plan`
--

DROP TABLE IF EXISTS `tipo_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_plan` (
  `tipo_plan_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `velocidad` int NOT NULL,
  PRIMARY KEY (`tipo_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_plan`
--

LOCK TABLES `tipo_plan` WRITE;
/*!40000 ALTER TABLE `tipo_plan` DISABLE KEYS */;
INSERT INTO `tipo_plan` VALUES (1,'Básico',10),(2,'Estándar',50),(3,'Avanzado',100),(4,'Premium',250),(5,'Ultra',500);
/*!40000 ALTER TABLE `tipo_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 12:47:23
