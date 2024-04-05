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
-- Table structure for table `salesterritory`
--

DROP TABLE IF EXISTS `salesterritory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesterritory` (
  `SalesTerritoryID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `CountryRegionCode` varchar(3) NOT NULL,
  `Group` varchar(50) NOT NULL,
  `SalesYTD` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `SalesLastYear` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `CostYTD` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `CostLastYear` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`SalesTerritoryID`),
  UNIQUE KEY `TerritoryID` (`SalesTerritoryID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesterritory`
--

LOCK TABLES `salesterritory` WRITE;
/*!40000 ALTER TABLE `salesterritory` DISABLE KEYS */;
INSERT INTO `salesterritory` VALUES (1,'NorthWest','US','North America',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:23:34'),(2,'NorthEast','US','North America',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(3,'Central','US','North America',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(4,'SouthWest','US','North America',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(5,'SouthEast','US','North America',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(6,'Canada','CA','North America',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(7,'France','FR','Europe',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(8,'Germany','DE','Europe',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(9,'Australia','AU','Pacific',0.0000,0.0000,0.0000,0.0000,'2021-12-22 17:24:42'),(10,'United Kingdom','GB','Europe',0.0000,0.0000,0.0000,0.0000,'2021-12-30 11:13:37');
/*!40000 ALTER TABLE `salesterritory` ENABLE KEYS */;
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
