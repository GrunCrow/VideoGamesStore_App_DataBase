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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `AddressID` int NOT NULL AUTO_INCREMENT,
  `AddressTypeID` int NOT NULL,
  `AddressLine1` varchar(255) DEFAULT NULL,
  `AddressLine2` varchar(255) DEFAULT NULL,
  `City` varchar(255) NOT NULL,
  `StateProvinceID` int NOT NULL,
  `PostalCode` int NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`AddressID`),
  UNIQUE KEY `AddressID` (`AddressID`),
  KEY `FKAddress_AddressType` (`AddressTypeID`),
  KEY `FKAddress_StateProvince` (`StateProvinceID`),
  CONSTRAINT `FKAddress_AddressType` FOREIGN KEY (`AddressTypeID`) REFERENCES `addresstype` (`AddressTypeID`),
  CONSTRAINT `FKAddress_StateProvince` FOREIGN KEY (`StateProvinceID`) REFERENCES `stateprovince` (`StateProvinceID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,3,'Avenida Julio Caro Baroja','nº12 4ºA','Huelva',2,21002,'2021-12-22 15:32:21'),(2,2,'Boleslawa Prusa','nº9 410B','Wroclaw',5,50319,'2021-12-30 10:47:08'),(4,2,'Boleslawa Prusa','','Wroclaw',5,50000,'2022-01-20 16:58:33'),(5,2,'Boleslawa Prusa','','Wroclaw',2,50000,'2022-01-20 16:59:01'),(6,2,'Street Test','','Wroclaw',5,50000,'2022-01-20 17:07:02'),(7,2,'Street Test','New Street','Wroclaw',5,50000,'2022-01-21 11:46:11'),(8,2,'Street Test','New Street','Wroclaw',5,50001,'2022-01-21 15:17:00');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresstype`
--

DROP TABLE IF EXISTS `addresstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresstype` (
  `AddressTypeID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`AddressTypeID`),
  UNIQUE KEY `AddressTypeID` (`AddressTypeID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresstype`
--

LOCK TABLES `addresstype` WRITE;
/*!40000 ALTER TABLE `addresstype` DISABLE KEYS */;
INSERT INTO `addresstype` VALUES (5,'Archive'),(1,'Billing'),(3,'Home'),(4,'Main Office'),(2,'Primary');
/*!40000 ALTER TABLE `addresstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardtype`
--

DROP TABLE IF EXISTS `cardtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardtype` (
  `CardTypeID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CardTypeID`),
  UNIQUE KEY `CardTypeID` (`CardTypeID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardtype`
--

LOCK TABLES `cardtype` WRITE;
/*!40000 ALTER TABLE `cardtype` DISABLE KEYS */;
INSERT INTO `cardtype` VALUES (1,'Mastercard','2021-12-22 12:32:27'),(2,'VISA','2021-12-22 12:32:27');
/*!40000 ALTER TABLE `cardtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `ContactID` int NOT NULL AUTO_INCREMENT,
  `TitleID` int NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) NOT NULL,
  `EmailAdress` varchar(255) NOT NULL,
  `Phone` int NOT NULL,
  `Password` int NOT NULL,
  `AdditionalContactInfo` varchar(255) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `AddressID` int NOT NULL,
  PRIMARY KEY (`ContactID`),
  UNIQUE KEY `ContactID` (`ContactID`),
  UNIQUE KEY `EmailAdress` (`EmailAdress`),
  KEY `FKContact_Title` (`TitleID`),
  KEY `FKContact_Address` (`AddressID`),
  CONSTRAINT `FKContact_Address` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`),
  CONSTRAINT `FKContact_Title` FOREIGN KEY (`TitleID`) REFERENCES `title` (`TitleID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,4,'Alba',NULL,'Marquez Rodriguez','albamrqz751@gmail.com',601195832,123456789,NULL,'2021-12-22 15:36:21',1),(2,2,'Joan',NULL,'Rand Om','email@gmail.com',123456789,123456789,'Additional Info updated','2021-12-30 10:50:26',2),(5,1,'Test Name','Mid Name','Test LastName','test',123456678,1234,'Additional Info updated','2022-01-21 15:24:48',8);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactcreditcard`
--

DROP TABLE IF EXISTS `contactcreditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactcreditcard` (
  `ContactID` int NOT NULL,
  `CreditCardID` int NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ContactID`,`CreditCardID`),
  UNIQUE KEY `UC_ContactCreditCard` (`ContactID`,`CreditCardID`),
  KEY `FKContactCreditCard_CreditCard` (`CreditCardID`),
  CONSTRAINT `FKContactCreditCard` FOREIGN KEY (`ContactID`) REFERENCES `contact` (`ContactID`),
  CONSTRAINT `FKContactCreditCard_CreditCard` FOREIGN KEY (`CreditCardID`) REFERENCES `creditcard` (`CreditCardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactcreditcard`
--

LOCK TABLES `contactcreditcard` WRITE;
/*!40000 ALTER TABLE `contactcreditcard` DISABLE KEYS */;
INSERT INTO `contactcreditcard` VALUES (1,1,'2021-12-22 15:41:37');
/*!40000 ALTER TABLE `contactcreditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countryregion`
--

DROP TABLE IF EXISTS `countryregion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countryregion` (
  `CountryRegionCode` varchar(3) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CountryRegionCode`),
  UNIQUE KEY `CountryRegionCode` (`CountryRegionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countryregion`
--

LOCK TABLES `countryregion` WRITE;
/*!40000 ALTER TABLE `countryregion` DISABLE KEYS */;
INSERT INTO `countryregion` VALUES ('AD','Andorra','2021-12-22 13:30:47'),('AR','Argentina','2021-12-22 13:30:47'),('AU','Australia','2021-12-22 13:35:17'),('Be','Belgium','2021-12-22 13:30:47'),('CA','Canada','2021-12-22 13:30:47'),('CN','China','2021-12-22 13:30:47'),('DE','Germany','2021-12-22 15:06:13'),('ES','Spain','2021-12-22 15:16:13'),('FR','France','2021-12-22 13:35:17'),('GB','United Kingdom','2021-12-22 15:06:33'),('PL','Poland','2021-12-22 15:16:09'),('PT','Portugal','2021-12-22 15:16:09'),('US','United States','2021-12-22 13:35:17');
/*!40000 ALTER TABLE `countryregion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countryregioncurrency`
--

DROP TABLE IF EXISTS `countryregioncurrency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countryregioncurrency` (
  `CountryRegionCode` varchar(3) NOT NULL,
  `CurrencyCode` char(3) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CountryRegionCode`,`CurrencyCode`),
  CONSTRAINT `FKcountryregioncurrency` FOREIGN KEY (`CountryRegionCode`) REFERENCES `countryregion` (`CountryRegionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countryregioncurrency`
--

LOCK TABLES `countryregioncurrency` WRITE;
/*!40000 ALTER TABLE `countryregioncurrency` DISABLE KEYS */;
INSERT INTO `countryregioncurrency` VALUES ('AU','AUD','2021-12-22 15:50:11'),('BE','EUR','2021-12-22 15:52:27'),('DE','EUR','2021-12-22 15:52:27'),('ES','EUR','2021-12-22 15:52:27'),('FR','EUR','2021-12-22 15:52:27'),('GB','GBP','2021-12-22 15:52:42'),('PL','PLN','2021-12-30 10:51:59'),('PT','EUR','2021-12-22 15:52:27'),('US','USD','2021-12-22 15:52:27');
/*!40000 ALTER TABLE `countryregioncurrency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcard` (
  `CreditCardID` int NOT NULL AUTO_INCREMENT,
  `CardTypeID` int NOT NULL,
  `CardNumber` varchar(25) NOT NULL,
  `ExpMonth` tinyint NOT NULL,
  `ExpYear` smallint NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CreditCardID`),
  UNIQUE KEY `CreditCardID` (`CreditCardID`),
  UNIQUE KEY `CardNumber` (`CardNumber`),
  KEY `FKCreditCard_CardType` (`CardTypeID`),
  CONSTRAINT `FKCreditCard_CardType` FOREIGN KEY (`CardTypeID`) REFERENCES `cardtype` (`CardTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES (1,1,'1234567898765432',12,2025,'2021-12-22 15:40:24'),(2,2,'120000012348765',7,2028,'2021-12-30 10:54:52');
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `CurrencyCode` char(3) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CurrencyCode`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('AUD','Australian Dollar','2021-12-22 15:49:05'),('EUR','EURO','2021-12-22 15:47:21'),('GBP','United Kingdom Pound','2021-12-22 15:47:53'),('PLN','Zloty','2021-12-22 15:47:21'),('USD','US Dollar','2021-12-22 15:48:44');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currencyrate`
--

DROP TABLE IF EXISTS `currencyrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currencyrate` (
  `CurrencyRateID` int NOT NULL AUTO_INCREMENT,
  `CurrencyRateDate` datetime NOT NULL,
  `FromCurrencyCode` char(3) NOT NULL,
  `ToCurrencyCode` char(3) NOT NULL,
  `AverageRate` decimal(13,4) NOT NULL,
  `EndOfDayRate` decimal(13,4) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CurrencyRateID`),
  UNIQUE KEY `CurrencyRateID` (`CurrencyRateID`),
  UNIQUE KEY `UC_CurrencyRate` (`CurrencyRateDate`,`FromCurrencyCode`,`ToCurrencyCode`),
  KEY `FKCurrencyRate_CurrencyFROM` (`FromCurrencyCode`),
  KEY `FKCurrencyRate_CurrencyTO` (`ToCurrencyCode`),
  CONSTRAINT `FKCurrencyRate_CurrencyFROM` FOREIGN KEY (`FromCurrencyCode`) REFERENCES `currency` (`CurrencyCode`),
  CONSTRAINT `FKCurrencyRate_CurrencyTO` FOREIGN KEY (`ToCurrencyCode`) REFERENCES `currency` (`CurrencyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currencyrate`
--

LOCK TABLES `currencyrate` WRITE;
/*!40000 ALTER TABLE `currencyrate` DISABLE KEYS */;
/*!40000 ALTER TABLE `currencyrate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `TerritoryID` int DEFAULT NULL,
  `AccountNumber` varchar(10) NOT NULL,
  `ContactID` int NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `CustomerID` (`CustomerID`),
  UNIQUE KEY `AccountNumber` (`AccountNumber`),
  KEY `FKCustomer_Territory` (`TerritoryID`),
  KEY `FKCustomer_Contact` (`ContactID`),
  CONSTRAINT `FKCustomer_Contact` FOREIGN KEY (`ContactID`) REFERENCES `contact` (`ContactID`),
  CONSTRAINT `FKCustomer_Territory` FOREIGN KEY (`TerritoryID`) REFERENCES `territory` (`TerritoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,15,'1',1,'2021-12-22 15:54:36');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `game_shoppingcartitem`
--

DROP TABLE IF EXISTS `game_shoppingcartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_shoppingcartitem` (
  `GameID` int NOT NULL,
  `ShoppingCartItemID` int NOT NULL,
  PRIMARY KEY (`GameID`,`ShoppingCartItemID`),
  KEY `FKGame_ShoppingCartItem` (`ShoppingCartItemID`),
  CONSTRAINT `FKGame_ShoppingCartItem` FOREIGN KEY (`ShoppingCartItemID`) REFERENCES `shoppingcartitem` (`ShoppingCartItemID`),
  CONSTRAINT `FKGame_ShoppingCartItem_Game` FOREIGN KEY (`GameID`) REFERENCES `game` (`GameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_shoppingcartitem`
--

LOCK TABLES `game_shoppingcartitem` WRITE;
/*!40000 ALTER TABLE `game_shoppingcartitem` DISABLE KEYS */;
INSERT INTO `game_shoppingcartitem` VALUES (2,1),(3,2);
/*!40000 ALTER TABLE `game_shoppingcartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameaudiovisuals`
--

DROP TABLE IF EXISTS `gameaudiovisuals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameaudiovisuals` (
  `GameAudiovisualsID` int NOT NULL AUTO_INCREMENT,
  `GameID` int NOT NULL,
  `GamePhotoID` int DEFAULT NULL,
  `GameVideoID` int DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GameAudiovisualsID`),
  UNIQUE KEY `GameAudiovisualsID` (`GameAudiovisualsID`),
  UNIQUE KEY `GamePhotoID` (`GamePhotoID`),
  UNIQUE KEY `GameVideoID` (`GameVideoID`),
  KEY `FKGame_GameAudiovisuals` (`GameID`),
  CONSTRAINT `FKGame_GameAudiovisuals` FOREIGN KEY (`GameID`) REFERENCES `game` (`GameID`),
  CONSTRAINT `FKGameAudiovisuals_GamePhoto` FOREIGN KEY (`GamePhotoID`) REFERENCES `gamephoto` (`GamePhotoID`),
  CONSTRAINT `FKGameAudiovisuals_GameVideo` FOREIGN KEY (`GameVideoID`) REFERENCES `gamevideo` (`GameVideoID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameaudiovisuals`
--

LOCK TABLES `gameaudiovisuals` WRITE;
/*!40000 ALTER TABLE `gameaudiovisuals` DISABLE KEYS */;
INSERT INTO `gameaudiovisuals` VALUES (1,2,2,1,'2021-12-22 16:51:23'),(2,3,1,NULL,'2021-12-22 16:49:46');
/*!40000 ALTER TABLE `gameaudiovisuals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamelistpricehistory`
--

DROP TABLE IF EXISTS `gamelistpricehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamelistpricehistory` (
  `GameID` int NOT NULL,
  `StartDate` datetime NOT NULL,
  `EndDate` datetime DEFAULT NULL,
  `ListPrice` decimal(13,4) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GameID`,`StartDate`),
  CONSTRAINT `FKGameListPriceHistory` FOREIGN KEY (`GameID`) REFERENCES `game` (`GameID`),
  CONSTRAINT `FKGameListPriceHistory_Game` FOREIGN KEY (`GameID`) REFERENCES `game` (`GameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamelistpricehistory`
--

LOCK TABLES `gamelistpricehistory` WRITE;
/*!40000 ALTER TABLE `gamelistpricehistory` DISABLE KEYS */;
INSERT INTO `gamelistpricehistory` VALUES (2,'2021-12-22 16:54:26',NULL,32.9900,'2021-12-22 16:54:26');
/*!40000 ALTER TABLE `gamelistpricehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamephoto`
--

DROP TABLE IF EXISTS `gamephoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamephoto` (
  `GamePhotoID` int NOT NULL AUTO_INCREMENT,
  `Icon` varchar(50) DEFAULT NULL,
  `Wallpaper` varchar(50) DEFAULT NULL,
  `Header` varchar(50) DEFAULT NULL,
  `Preview` varchar(50) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GamePhotoID`),
  UNIQUE KEY `GamePhotoID` (`GamePhotoID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamephoto`
--

LOCK TABLES `gamephoto` WRITE;
/*!40000 ALTER TABLE `gamephoto` DISABLE KEYS */;
INSERT INTO `gamephoto` VALUES (1,'url1',NULL,'url2',NULL,'2021-12-22 16:47:55'),(2,'url1',NULL,'url2',NULL,'2021-12-22 16:48:32'),(3,NULL,NULL,'url1','url2','2021-12-22 16:48:32'),(4,'url1',NULL,'url2','url3','2021-12-22 16:48:32');
/*!40000 ALTER TABLE `gamephoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamereview`
--

DROP TABLE IF EXISTS `gamereview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamereview` (
  `GameReviewID` int NOT NULL AUTO_INCREMENT,
  `GameID` int NOT NULL,
  `ReviewerName` varchar(50) NOT NULL,
  `ReviewDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `EmailAddress` varchar(50) NOT NULL,
  `Rating` int NOT NULL,
  `Comments` varchar(3000) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GameReviewID`),
  UNIQUE KEY `GameReviewID` (`GameReviewID`),
  KEY `FKGameReview_Game` (`GameID`),
  CONSTRAINT `FKGameReview_Game` FOREIGN KEY (`GameID`) REFERENCES `game` (`GameID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamereview`
--

LOCK TABLES `gamereview` WRITE;
/*!40000 ALTER TABLE `gamereview` DISABLE KEYS */;
INSERT INTO `gamereview` VALUES (1,4,'Mary','2021-12-22 16:33:00','mary@gmail.com',6,'Not the best game','2021-12-30 11:09:10');
/*!40000 ALTER TABLE `gamereview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamevideo`
--

DROP TABLE IF EXISTS `gamevideo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gamevideo` (
  `GameVideoID` int NOT NULL AUTO_INCREMENT,
  `ReviewVideo` varchar(50) DEFAULT NULL,
  `PreviewVideo` varchar(50) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GameVideoID`),
  UNIQUE KEY `GameVideoID` (`GameVideoID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamevideo`
--

LOCK TABLES `gamevideo` WRITE;
/*!40000 ALTER TABLE `gamevideo` DISABLE KEYS */;
INSERT INTO `gamevideo` VALUES (1,'url1','url2','2021-12-22 16:49:36'),(2,NULL,'url1','2021-12-22 16:49:36'),(3,NULL,'url1','2021-12-22 16:49:36'),(4,'url1',NULL,'2021-12-22 16:49:36');
/*!40000 ALTER TABLE `gamevideo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `GenreID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GenreID`),
  UNIQUE KEY `GenreID` (`GenreID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Fantasy',NULL,'2021-12-22 16:12:58'),(2,'Thriller',NULL,'2021-12-22 16:12:58'),(3,'Casual',NULL,'2021-12-22 16:29:59'),(4,'Action',NULL,'2021-12-22 16:30:10');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saga`
--

DROP TABLE IF EXISTS `saga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saga` (
  `SagaID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Quantity` int NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`SagaID`),
  UNIQUE KEY `SagaID` (`SagaID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saga`
--

LOCK TABLES `saga` WRITE;
/*!40000 ALTER TABLE `saga` DISABLE KEYS */;
INSERT INTO `saga` VALUES (1,'Just Cause',4,'2021-12-22 16:22:10');
/*!40000 ALTER TABLE `saga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderdetail`
--

DROP TABLE IF EXISTS `salesorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesorderdetail` (
  `SalesOrderID` int NOT NULL AUTO_INCREMENT,
  `SalesOrderDetailID` int NOT NULL,
  `TrackingNumber` int DEFAULT NULL,
  `OrderQnty` int DEFAULT NULL,
  `GameID` int NOT NULL,
  `SpecialOfferID` int NOT NULL,
  `UnitPrice` int DEFAULT NULL,
  `UnitPriceDiscount` int DEFAULT NULL,
  `LineTotal` int DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`SalesOrderID`,`SalesOrderDetailID`),
  KEY `FKSalesOrderDetail_SpecialOfferGame` (`SpecialOfferID`,`GameID`),
  CONSTRAINT `FKSalesOrderDetail_SpecialOfferGame` FOREIGN KEY (`SpecialOfferID`, `GameID`) REFERENCES `specialoffergame` (`SpecialOfferID`, `GameID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderdetail`
--

LOCK TABLES `salesorderdetail` WRITE;
/*!40000 ALTER TABLE `salesorderdetail` DISABLE KEYS */;
INSERT INTO `salesorderdetail` VALUES (3,1,NULL,1,2,1,33,NULL,33,NULL);
/*!40000 ALTER TABLE `salesorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderheader`
--

DROP TABLE IF EXISTS `salesorderheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesorderheader` (
  `SalesOrderID` int NOT NULL AUTO_INCREMENT,
  `RevisionNumber` tinyint NOT NULL DEFAULT '0',
  `OrderDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DueDate` datetime NOT NULL,
  `Status` tinyint NOT NULL DEFAULT '1',
  `SalesOrderNumber` varchar(25) DEFAULT NULL,
  `AccountNumber` varchar(15) DEFAULT NULL,
  `CustomerID` int NOT NULL,
  `ContactID` int NOT NULL,
  `TerritoryID` int DEFAULT NULL,
  `BillToAddressID` int NOT NULL,
  `CreditCartdApprovalCode` varchar(15) DEFAULT NULL,
  `SubTotal` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `TaxAmt` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `Comment` varchar(128) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CreditCardID` int DEFAULT NULL,
  `CurrencyRateID` int DEFAULT NULL,
  `ContactCreditCardCreditCardID` int NOT NULL,
  PRIMARY KEY (`SalesOrderID`),
  UNIQUE KEY `SalesOrderID` (`SalesOrderID`),
  UNIQUE KEY `SalesOrderNumber` (`SalesOrderNumber`),
  KEY `FKSalesOrderHeader_ContactCreditCard2` (`ContactID`,`CreditCardID`),
  KEY `FKSalesOrderHeader_SalesTerritory` (`TerritoryID`),
  KEY `FKSalesOrderHeader_CurrencyRate` (`CurrencyRateID`),
  KEY `FKSalesOrderHeader_Customer` (`CustomerID`),
  CONSTRAINT `FKSalesOrderHeader_Contact` FOREIGN KEY (`ContactID`) REFERENCES `contact` (`ContactID`),
  CONSTRAINT `FKSalesOrderHeader_ContactCreditCard2` FOREIGN KEY (`ContactID`, `CreditCardID`) REFERENCES `contactcreditcard` (`ContactID`, `CreditCardID`),
  CONSTRAINT `FKSalesOrderHeader_CurrencyRate` FOREIGN KEY (`CurrencyRateID`) REFERENCES `currencyrate` (`CurrencyRateID`),
  CONSTRAINT `FKSalesOrderHeader_Customer` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  CONSTRAINT `FKSalesOrderHeader_SalesOrderDetail` FOREIGN KEY (`SalesOrderID`) REFERENCES `salesorderdetail` (`SalesOrderID`),
  CONSTRAINT `FKSalesOrderHeader_SalesTerritory` FOREIGN KEY (`TerritoryID`) REFERENCES `salesterritory` (`SalesTerritoryID`),
  CONSTRAINT `FKSalesOrderHeader_Territory` FOREIGN KEY (`TerritoryID`) REFERENCES `territory` (`TerritoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderheader`
--

LOCK TABLES `salesorderheader` WRITE;
/*!40000 ALTER TABLE `salesorderheader` DISABLE KEYS */;
INSERT INTO `salesorderheader` VALUES (3,1,'2021-12-22 17:17:09','2021-12-25 00:00:00',4,NULL,NULL,1,1,NULL,1,NULL,32.9900,0.0000,NULL,'2021-12-22 17:17:09',NULL,NULL,1);
/*!40000 ALTER TABLE `salesorderheader` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `shoppingcartitem`
--

DROP TABLE IF EXISTS `shoppingcartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcartitem` (
  `ShoppingCartItemID` int NOT NULL AUTO_INCREMENT,
  `ShoppingCartID` varchar(50) NOT NULL,
  `GameID` int NOT NULL,
  `DateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ShoppingCartItemID`),
  UNIQUE KEY `ShoppingCartItemID` (`ShoppingCartItemID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcartitem`
--

LOCK TABLES `shoppingcartitem` WRITE;
/*!40000 ALTER TABLE `shoppingcartitem` DISABLE KEYS */;
INSERT INTO `shoppingcartitem` VALUES (1,'1',2,'2021-12-22 16:35:39','2021-12-22 16:35:39'),(2,'1',4,'2021-12-22 16:35:41','2021-12-22 16:35:41'),(3,'2',2,'2021-12-22 16:35:47','2021-12-22 16:35:47'),(4,'3',3,'2021-12-22 16:35:53','2021-12-22 16:35:53');
/*!40000 ALTER TABLE `shoppingcartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialoffer`
--

DROP TABLE IF EXISTS `specialoffer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialoffer` (
  `SpecialOfferID` int NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Discount` decimal(13,4) NOT NULL DEFAULT '0.0000',
  `Type` varchar(50) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `SpecialOfferProductGameID` int NOT NULL,
  PRIMARY KEY (`SpecialOfferID`),
  UNIQUE KEY `SpecialOfferID` (`SpecialOfferID`),
  KEY `FKSpecialOffer` (`SpecialOfferID`,`SpecialOfferProductGameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialoffer`
--

LOCK TABLES `specialoffer` WRITE;
/*!40000 ALTER TABLE `specialoffer` DISABLE KEYS */;
INSERT INTO `specialoffer` VALUES (1,'No Discount',0.0000,'No discount','2021-12-22','2030-11-23','2021-12-22 17:09:38',1),(2,'No Discount',0.0000,'No discount','2021-12-22','2030-11-23','2021-12-22 17:10:22',2),(3,'No Discount',0.0000,'No discount','2021-12-22','2030-11-23','2021-12-22 17:10:30',3);
/*!40000 ALTER TABLE `specialoffer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialoffergame`
--

DROP TABLE IF EXISTS `specialoffergame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialoffergame` (
  `SpecialOfferID` int NOT NULL,
  `GameID` int NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`SpecialOfferID`,`GameID`),
  UNIQUE KEY `SpecialOfferID` (`SpecialOfferID`),
  KEY `FKSpecialOfferGame_Game` (`GameID`),
  CONSTRAINT `FKSpecialOfferGame_Game` FOREIGN KEY (`GameID`) REFERENCES `game` (`GameID`),
  CONSTRAINT `FKSpecialOfferGame_SpecialOffer` FOREIGN KEY (`SpecialOfferID`) REFERENCES `specialoffer` (`SpecialOfferID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialoffergame`
--

LOCK TABLES `specialoffergame` WRITE;
/*!40000 ALTER TABLE `specialoffergame` DISABLE KEYS */;
INSERT INTO `specialoffergame` VALUES (1,2,'2021-12-22 17:05:08'),(2,3,'2021-12-22 17:05:11'),(3,4,'2021-12-22 17:05:13');
/*!40000 ALTER TABLE `specialoffergame` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `territory`
--

DROP TABLE IF EXISTS `territory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `territory` (
  `TerritoryID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `CountryRegionCode` varchar(3) NOT NULL,
  `GroupName` varchar(50) DEFAULT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`TerritoryID`),
  UNIQUE KEY `TerritoryID` (`TerritoryID`),
  UNIQUE KEY `Name` (`Name`),
  KEY `FKTerritory_CountryRegion` (`CountryRegionCode`),
  CONSTRAINT `FKTerritory_CountryRegion` FOREIGN KEY (`CountryRegionCode`) REFERENCES `countryregion` (`CountryRegionCode`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `territory`
--

LOCK TABLES `territory` WRITE;
/*!40000 ALTER TABLE `territory` DISABLE KEYS */;
INSERT INTO `territory` VALUES (1,'NorthWest','US','North America','2021-12-22 13:39:56'),(2,'NorthEast','US','North America','2021-12-22 15:05:41'),(3,'Central','US','North America','2021-12-22 15:05:41'),(4,'SouthWest','US','North America','2021-12-22 15:05:41'),(5,'SouthEast','US','North America','2021-12-22 15:05:41'),(6,'Canada','CA','North America','2021-12-22 15:05:41'),(7,'France','FR','Europe','2021-12-22 15:05:41'),(8,'United Kingdom','GB','Europe','2021-12-30 10:58:52'),(9,'Germany','DE','Europe','2021-12-22 15:06:23'),(10,'Australia','AU','Pacific','2021-12-22 15:06:23'),(15,'Spain','ES','Europe','2021-12-22 15:16:29'),(16,'Poland','PL','Europe','2021-12-22 15:16:34');
/*!40000 ALTER TABLE `territory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `title`
--

DROP TABLE IF EXISTS `title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `title` (
  `TitleID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`TitleID`),
  UNIQUE KEY `TitleID` (`TitleID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title`
--

LOCK TABLES `title` WRITE;
/*!40000 ALTER TABLE `title` DISABLE KEYS */;
INSERT INTO `title` VALUES (5,'Mr.'),(2,'Mrs.'),(4,'Ms.'),(6,'Null'),(1,'Sr.'),(3,'Sra.');
/*!40000 ALTER TABLE `title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unitmeasure`
--

DROP TABLE IF EXISTS `unitmeasure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unitmeasure` (
  `UnitMeasureCode` char(3) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `ModifiedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`UnitMeasureCode`),
  UNIQUE KEY `UnitMeasureCode` (`UnitMeasureCode`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unitmeasure`
--

LOCK TABLES `unitmeasure` WRITE;
/*!40000 ALTER TABLE `unitmeasure` DISABLE KEYS */;
INSERT INTO `unitmeasure` VALUES ('GB','GigaByte','2021-12-22 16:11:27'),('MB','MegaByte','2021-12-22 16:11:40');
/*!40000 ALTER TABLE `unitmeasure` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-22 18:50:25
