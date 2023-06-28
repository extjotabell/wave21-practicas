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

DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `dni` int(15) unsigned NOT NULL,
  `first_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `birth_date` timestamp NULL DEFAULT NULL,
  `province` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES 
(1001,123456789,'Sam','Worthington','1988-01-01 00:00:00','Alicante','Comunidad Valenciana'),
(1002,123456780,'Sigourney','Weaver','2000-02-11 00:00:00','Cáceres','Extremadura'),
(1003,123456781,'Leonardo','Di Caprio','1974-12-01 00:00:00','Zaragoza','Aragón'),
(1004,123456782,'Kate','Winslet','2003-11-15 00:00:00','Sevilla','Andalucía'),
(1005,123456783,'Billy','Zane','1998-07-30 00:00:00','Buenos Aires','La Plata'),
(1006,123456784,'Mark','Hamill','1992-06-12 00:00:00','Córdoba','Córdoba'),
(1007,123456785,'Harrison','Ford','1976-04-28 00:00:00','La Pampa','Santa Rosa'),
(1008,123456786,'Carrie','Fisher','1999-02-01 00:00:00','San Juan','San Juan'),
(1009,123456787,'Sam','Neill','2000-01-31 00:00:00','Misiones','Posadas'),
(1010,123456788,'Laura','Dern','1990-10-23 00:00:00','Río Negro','Viedma');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internet_plan`
--

DROP TABLE IF EXISTS `internet_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internet_plan` (
  `plan_code` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mb_speed` int(10) unsigned NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `discount` int(10) unsigned NOT NULL,
  PRIMARY KEY (`plan_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internet_plan`
--

LOCK TABLES `internet_plan` WRITE;
/*!40000 ALTER TABLE `internet_plan` DISABLE KEYS */;
INSERT INTO `internet_plan` VALUES 
(1,100,100000,0),
(2,200,145000,5),
(3,300,230000,10),
(4,50,80000,0),
(5,30,65000,0);
/*!40000 ALTER TABLE `internet_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `service_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_client_id` int(10) unsigned DEFAULT NULL,
  `fk_plan_code` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `client_id_foreign` (`fk_client_id`),
  KEY `plan_code_foreign` (`fk_plan_code`),
  CONSTRAINT `client_id_foreign` FOREIGN KEY (`fk_client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `plan_code_foreign` FOREIGN KEY (`fk_plan_code`) REFERENCES `internet_plan` (`plan_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES 
(1,1001,1),
(2,1001,2),
(3,1002,4),
(4,1003,5),
(5,1004,3),
(6,1005,3),
(7,1010,2),
(8,1006,3),
(9,1006,4),
(10,1007,5);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
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
