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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-22 18:49:32
