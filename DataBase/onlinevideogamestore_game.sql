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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `GameID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `GameNumber` varchar(25) NOT NULL,
  `StandardCost` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `ListPrice` decimal(13,4) DEFAULT NULL,
  `Storage` varchar(5) DEFAULT NULL,
  `StorageUnitMeasureCode` char(3) DEFAULT NULL,
  `GenreID` int DEFAULT NULL,
  `PlatformID` char(5) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `SagaID` int DEFAULT NULL,
  `GameReviewID` int DEFAULT NULL,
  `SellStartDate` datetime NOT NULL,
  `SellEndDate` datetime DEFAULT NULL,
  `LaunchDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GameID`),
  UNIQUE KEY `GameID` (`GameID`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `GameNumber` (`GameNumber`),
  KEY `FKGame_Genre` (`GenreID`),
  KEY `FKGame_Saga` (`SagaID`),
  KEY `FKunitmeasure` (`StorageUnitMeasureCode`),
  CONSTRAINT `FKGame_Genre` FOREIGN KEY (`GenreID`) REFERENCES `genre` (`GenreID`),
  CONSTRAINT `FKGame_Saga` FOREIGN KEY (`SagaID`) REFERENCES `saga` (`SagaID`),
  CONSTRAINT `FKunitmeasure` FOREIGN KEY (`StorageUnitMeasureCode`) REFERENCES `unitmeasure` (`UnitMeasureCode`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'Rocket League','4',0.0000,NULL,'20','GB',3,'PC','Rocket League combines arcade-style soccer with four-wheel mayhem, easy controls, and fluid, physics-based competition. ',NULL,NULL,'2021-12-30 10:39:48',NULL,NULL,'2021-12-30 10:39:48'),(2,'Just Cause 4 Reloaded','1',32.9900,NULL,'47','GB',1,'PC','Rebel agent Rico Rodríguez arrives in Solís, a vast world located in South America mired in conflict, oppression and extreme weather conditions. Buckle up your wingsuit, equip the customizable hook, and prepare to unleash the tempest! ',1,NULL,'2021-12-22 16:26:33',NULL,NULL,'2021-12-22 16:26:33'),(3,'Minecraft','2',23.9500,NULL,'1','GB',1,'PC','Prepare for an adventure of limitless possibilities as you build, mine, battle creatures and explore the ever-changing landscape of Minecraft ',NULL,NULL,'2021-12-22 16:29:02',NULL,NULL,'2021-12-22 16:29:02'),(4,'Among Us','3',3.9900,NULL,'1','GB',3,'PC','A game for 4 to 15 players online or in local mode via Wi-Fi in which you have to prepare your spaceship for take off. But beware: one or more randomly chosen players from the crew are imposters ready to kill the rest! ',NULL,NULL,'2021-12-22 16:31:12',NULL,NULL,'2021-12-22 16:31:12'),(8,'Just Cause 3','5',19.9900,NULL,'54','GB',1,'PC','The Medici republic, in the Mediterranean, is oppressed by the tyrannical regime of General Di Ravello, a dictator with an insatiable thirst for power. You are Rico Rodriguez and your mission is to overthrow the general no matter what.',1,NULL,'2022-01-21 12:09:19',NULL,NULL,'2022-01-21 12:09:19');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-22 18:49:31
