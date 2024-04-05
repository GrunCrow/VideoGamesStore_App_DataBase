-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: onlinevideogamestore
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `stateprovince`
--

DROP TABLE IF EXISTS `stateprovince`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stateprovince` (
  `StateProvinceID` int NOT NULL AUTO_INCREMENT,
  `StateProvinceCode` char(3) DEFAULT NULL,
  `CountryRegionCode` varchar(3) NOT NULL,
  `IsOnlyStateProvinceFlag` binary(1) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `TerritoryID` int NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`StateProvinceID`),
  UNIQUE KEY `StateProvinceID` (`StateProvinceID`),
  KEY `FKStateProvince_CountryRegion` (`CountryRegionCode`),
  CONSTRAINT `FKStateProvince_CountryRegion` FOREIGN KEY (`CountryRegionCode`) REFERENCES `countryregion` (`CountryRegionCode`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stateprovince`
--

LOCK TABLES `stateprovince` WRITE;
/*!40000 ALTER TABLE `stateprovince` DISABLE KEYS */;
INSERT INTO `stateprovince` VALUES (1,'ENG','GB',_binary '1','England',13,'2021-12-22 15:18:16'),(2,'HU','ES',_binary '0','Huelva',15,'2021-12-22 15:26:03'),(3,'MAD','ES',_binary '0','Madrid',15,'2021-12-22 15:26:03'),(4,'BA','ES',_binary '0','Barcelona',15,'2021-12-22 15:26:03'),(5,'WRO','PL',_binary '0','Wroclaw',16,'2021-12-22 15:26:44'),(6,'WAR','PL',_binary '0','Warsaw',16,'2021-12-22 15:26:44'),(7,'KRA','PL',_binary '0','Krakov',16,'2021-12-22 15:26:44'),(8,'AB','CA',_binary '0','Alberta',6,'2021-12-22 15:27:08');
/*!40000 ALTER TABLE `stateprovince` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-22 18:49:29
