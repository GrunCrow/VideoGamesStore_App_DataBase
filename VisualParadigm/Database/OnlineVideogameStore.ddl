CREATE TABLE `Game_ShoppingCartItem` (
  `GameGameID`                         int(10) NOT NULL, 
  `ShoppingCartItemShoppingCartItemID` int(10) NOT NULL, 
  PRIMARY KEY (`GameGameID`, 
  `ShoppingCartItemShoppingCartItemID`));
CREATE TABLE `Game` (
  `GameID`        int(10) NOT NULL, 
  `Name`          varchar(255) NOT NULL UNIQUE, 
  `Game Number`   int(10) NOT NULL UNIQUE, 
  `StandardCost`  int(10) NOT NULL, 
  `ListPrice`     int(10), 
  `Storage`       int(5) NOT NULL, 
  `GenreID`       int(10), 
  `SellStartDate` date NOT NULL, 
  `SellEndDate`   date, 
  `LaunchDate`    date NOT NULL, 
  `PlatformID`    int(10) NOT NULL, 
  `Description`   varchar(255), 
  `SagaID`        int(10) NOT NULL, 
  `ModifiedDate`  date NOT NULL, 
  `GameReviewID`  int(10), 
  PRIMARY KEY (`GameID`));
CREATE TABLE `Genre` (
  `GenreID`     int(10) NOT NULL AUTO_INCREMENT, 
  `Name`        varchar(255) NOT NULL UNIQUE, 
  `Description` varchar(255), 
  PRIMARY KEY (`GenreID`));
CREATE TABLE `Saga` (
  `SagaID`   int(10) NOT NULL AUTO_INCREMENT, 
  `Name`     varchar(255), 
  `Quantity` int(3), 
  PRIMARY KEY (`SagaID`));
CREATE TABLE `ShoppingCartItem` (
  `ShoppingCartItemID` int(10) NOT NULL AUTO_INCREMENT, 
  `ShoppingCartID`     int(10), 
  `GameID`             int(10) NOT NULL, 
  `DateCreated`        date, 
  `ModifiedDate`       date, 
  PRIMARY KEY (`ShoppingCartItemID`));
CREATE TABLE `SpecialOffer` (
  `SpecialOfferID` int(10) NOT NULL AUTO_INCREMENT, 
  `Description`    varchar(255), 
  `Discount`       int(10), 
  `Type`           varchar(255), 
  `Category`       varchar(255), 
  `StartDate`      date, 
  `EndDate`        date, 
  `ModifiedDate`   date, 
  PRIMARY KEY (`SpecialOfferID`));
CREATE TABLE `SpecialOfferGame` (
  `SpecialOfferID` int(10) NOT NULL, 
  `GameID`         int(10) NOT NULL, 
  `ModifiedDate`   date NOT NULL, 
  PRIMARY KEY (`SpecialOfferID`, 
  `GameID`), 
  INDEX (`SpecialOfferID`));
CREATE TABLE `SalesOrderDetail` (
  `SalesOrderID`       int(10) NOT NULL, 
  `SalesOrderDetailID` int(10) NOT NULL, 
  `TrackingNumber`     int(10), 
  `OrderQnty`          int(10), 
  `GameID`             int(10) NOT NULL, 
  `SpecialOfferID`     int(10) NOT NULL, 
  `UnitPrice`          int(10), 
  `UnitPriceDiscount`  int(10), 
  `LineTotal`          int(10), 
  `ModifiedDate`       date, 
  PRIMARY KEY (`SalesOrderID`, 
  `SalesOrderDetailID`));
CREATE TABLE `CardType` (
  `CardTypeID` int(10) NOT NULL AUTO_INCREMENT, 
  `Name`       varchar(255), 
  PRIMARY KEY (`CardTypeID`));
CREATE TABLE `CreditCard` (
  `CreditCardID` int(10) NOT NULL AUTO_INCREMENT, 
  `CardTypeID`   int(10) NOT NULL, 
  `CardNumber`   int(10), 
  `ExpMonth`     int(2), 
  `ExpYear`      int(2), 
  `ModifiedDate` date, 
  PRIMARY KEY (`CreditCardID`));
CREATE TABLE `Currency` (
  `CurrencyCode` int(10) NOT NULL AUTO_INCREMENT, 
  `Name`         varchar(255) NOT NULL UNIQUE, 
  `ModifiedDate` date NOT NULL, 
  PRIMARY KEY (`CurrencyCode`));
CREATE TABLE `CurrencyRate` (
  `CurrencyRateID`   int(10) NOT NULL AUTO_INCREMENT, 
  `CurrencyRateDate` date NOT NULL, 
  `FromCurrencyCode` int(10) NOT NULL, 
  `ToCurrencyCode`   int(10) NOT NULL, 
  `AverageRate`      int(10) NOT NULL, 
  `EndOfDayRate`     int(10) NOT NULL, 
  `ModifiedDate`     date NOT NULL, 
  PRIMARY KEY (`CurrencyRateID`), 
  UNIQUE INDEX (`CurrencyRateID`));
CREATE TABLE `SalesTerritory` (
  `TerritoryID`       int(10) NOT NULL AUTO_INCREMENT, 
  `Name`              varchar(255) NOT NULL UNIQUE, 
  `CountryRegionCode` int(5) NOT NULL, 
  `Group`             int(10) NOT NULL, 
  `SalesYTD`          int(10) NOT NULL, 
  `SalesLastYear`     int(10) NOT NULL, 
  `CostYTD`           int(10) NOT NULL, 
  `CostLastYear`      int(10) NOT NULL, 
  `ModifiedDate`      date NOT NULL, 
  PRIMARY KEY (`TerritoryID`), 
  UNIQUE INDEX (`TerritoryID`));
CREATE TABLE `ContactCreditCard` (
  `ContactID`    int(10) NOT NULL, 
  `CreditCardID` int(10) NOT NULL, 
  `ModifiedDate` date, 
  PRIMARY KEY (`ContactID`, 
  `CreditCardID`), 
  UNIQUE INDEX (`ContactID`), 
  INDEX (`CreditCardID`));
CREATE TABLE `Customer` (
  `CustomerID`    int(10) NOT NULL AUTO_INCREMENT, 
  `TerritoryID`   int(10) NOT NULL, 
  `AccountNumber` int(10) NOT NULL UNIQUE, 
  `ContactID`     int(10) NOT NULL, 
  `Demographics`  int(10) NOT NULL, 
  `ModifiedDate`  date NOT NULL, 
  PRIMARY KEY (`CustomerID`));
CREATE TABLE `Territory` (
  `TerritoryID`       int(10) NOT NULL AUTO_INCREMENT, 
  `Name`              varchar(255) NOT NULL UNIQUE, 
  `CountryRegionCode` int(5) NOT NULL, 
  `ModifiedDate`      date NOT NULL, 
  PRIMARY KEY (`TerritoryID`));
CREATE TABLE `CountryRegion` (
  `CountryRegionCode` int(5) NOT NULL, 
  `Name`              varchar(255) NOT NULL, 
  `ModifiedDate`      date NOT NULL, 
  PRIMARY KEY (`CountryRegionCode`));
CREATE TABLE `Contact` (
  `ContactID`             int(10) NOT NULL AUTO_INCREMENT, 
  `TitleID`               int(1) NOT NULL, 
  `FirstName`             varchar(255) NOT NULL, 
  `MiddleName`            varchar(255), 
  `LastName`              varchar(255) NOT NULL, 
  `EmailAdress`           varchar(255) NOT NULL UNIQUE, 
  `Phone`                 int(11) NOT NULL, 
  `Password`              int(10) NOT NULL, 
  `AdditionalContactInfo` varchar(255), 
  `ModifiedDate`          date NOT NULL, 
  `AddressID`             int(10) NOT NULL, 
  PRIMARY KEY (`ContactID`));
CREATE TABLE `Title` (
  `TitleID` int(1) NOT NULL AUTO_INCREMENT, 
  `Name`    varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (`TitleID`));
CREATE TABLE `Address` (
  `AddressID`       int(10) NOT NULL, 
  `AddressTypeID`   int(2) NOT NULL, 
  `AddressLine1`    varchar(255), 
  `AddressLine2`    varchar(255), 
  `City`            varchar(255) NOT NULL, 
  `StateProvinceID` int(5) NOT NULL, 
  `PostalCode`      int(6) NOT NULL, 
  `ModifiedDate`    date NOT NULL, 
  PRIMARY KEY (`AddressID`));
CREATE TABLE `AddressType` (
  `AddressTypeID` int(2) NOT NULL AUTO_INCREMENT, 
  `Name`          varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (`AddressTypeID`));
CREATE TABLE `StateProvince` (
  `StateProvinceID`         int(5) NOT NULL, 
  `CountryRegionCode`       int(5) NOT NULL, 
  `IsOnlyStateProvinceFlag` binary(1) NOT NULL, 
  `Name`                    varchar(255) NOT NULL, 
  `TerritoryID`             int(10) NOT NULL, 
  `ModifiedDate`            date NOT NULL, 
  PRIMARY KEY (`StateProvinceID`));
CREATE TABLE `SalesOrderHeader` (
  `SalesOrderID`            int(10) NOT NULL, 
  `RevisionNumber`          int(10) NOT NULL, 
  `OrderDate`               date NOT NULL, 
  `DueDate`                 date NOT NULL, 
  `Status`                  int(1) NOT NULL, 
  `SalesOrderNumber`        int(10) NOT NULL, 
  `AccountNumber`           int(10) NOT NULL, 
  `CustomerID`              int(10) NOT NULL, 
  `ContactID`               int(10) NOT NULL, 
  `TerritoryID`             int(10) NOT NULL, 
  `BillToAddressID`         int(10) NOT NULL, 
  `CreditCartdApprovalCode` int(10) NOT NULL, 
  `SubTotal`                int(10) NOT NULL, 
  `TaxAmt`                  int(10) NOT NULL, 
  `Comment`                 varchar(255), 
  `ModifiedDate`            date NOT NULL, 
  `CreditCardID`            int(10) NOT NULL, 
  `CurrencyRateID`          int(10) NOT NULL, 
  PRIMARY KEY (`SalesOrderID`), 
  UNIQUE INDEX (`SalesOrderID`));
CREATE TABLE `GamePhoto` (
  `GamePhotoID`  int(10) NOT NULL AUTO_INCREMENT, 
  `Icon`         varchar(255), 
  `WallPaper`    varchar(255), 
  `Header`       varchar(255), 
  `Preview`      varchar(255), 
  `ModifiedDate` date, 
  PRIMARY KEY (`GamePhotoID`));
CREATE TABLE `GameVideo` (
  `GameVideoID`  int(10) NOT NULL AUTO_INCREMENT, 
  `ReviewVideo`  varchar(255), 
  `PreviewVideo` varchar(255), 
  `ModifiedDate` date, 
  PRIMARY KEY (`GameVideoID`));
CREATE TABLE `GameAudiovisuals` (
  `GameID`       int(10) NOT NULL AUTO_INCREMENT, 
  `GamePhotoID`  int(10) NOT NULL, 
  `GameVideoID`  int(10) NOT NULL, 
  `ModifiedDate` date, 
  PRIMARY KEY (`GameID`));
CREATE TABLE `GameListPriceHistory` (
  `GameID`       int(10) NOT NULL UNIQUE, 
  `StartDate`    date NOT NULL, 
  `EndDate`      date NOT NULL, 
  `ListPrice`    int(10) NOT NULL, 
  `ModifiedDate` date NOT NULL, 
  PRIMARY KEY (`GameID`, 
  `StartDate`));
CREATE TABLE `GameReview` (
  `GameReviewID` int(10) NOT NULL AUTO_INCREMENT, 
  `GameID`       int(10) NOT NULL, 
  `ReviewerName` varchar(255) NOT NULL, 
  `ReviewDate`   date NOT NULL, 
  `EmailAddress` varchar(255) NOT NULL, 
  `Rating`       int(2) NOT NULL, 
  `Comments`     varchar(255) UNIQUE, 
  `ModifiedDate` date NOT NULL, 
  PRIMARY KEY (`GameReviewID`));
ALTER TABLE `Game_ShoppingCartItem` ADD CONSTRAINT `FKGame_Shopp872730` FOREIGN KEY (`GameGameID`) REFERENCES `Game` (`GameID`);
ALTER TABLE `Game` ADD CONSTRAINT `FKGame310189` FOREIGN KEY (`GenreID`) REFERENCES `Genre` (`GenreID`);
ALTER TABLE `Game` ADD CONSTRAINT `FKGame744551` FOREIGN KEY (`SagaID`) REFERENCES `Saga` (`SagaID`);
ALTER TABLE `Game_ShoppingCartItem` ADD CONSTRAINT `FKGame_Shopp333691` FOREIGN KEY (`ShoppingCartItemShoppingCartItemID`) REFERENCES `ShoppingCartItem` (`ShoppingCartItemID`);
ALTER TABLE `SalesOrderDetail` ADD CONSTRAINT `FKSalesOrder128416` FOREIGN KEY (`SpecialOfferID`, `GameID`) REFERENCES `SpecialOfferGame` (`SpecialOfferID`, `GameID`);
ALTER TABLE `CreditCard` ADD CONSTRAINT `FKCreditCard796345` FOREIGN KEY (`CardTypeID`) REFERENCES `CardType` (`CardTypeID`);
ALTER TABLE `ContactCreditCard` ADD CONSTRAINT `FKContactCre846439` FOREIGN KEY (`CreditCardID`) REFERENCES `CreditCard` (`CreditCardID`);
ALTER TABLE `Customer` ADD CONSTRAINT `FKCustomer275717` FOREIGN KEY (`TerritoryID`) REFERENCES `Territory` (`TerritoryID`);
ALTER TABLE `Territory` ADD CONSTRAINT `FKTerritory739494` FOREIGN KEY (`CountryRegionCode`) REFERENCES `CountryRegion` (`CountryRegionCode`);
ALTER TABLE `Contact` ADD CONSTRAINT `FKContact161749` FOREIGN KEY (`TitleID`) REFERENCES `Title` (`TitleID`);
ALTER TABLE `Contact` ADD CONSTRAINT `FKContact228830` FOREIGN KEY (`AddressID`) REFERENCES `Address` (`AddressID`);
ALTER TABLE `Address` ADD CONSTRAINT `FKAddress537779` FOREIGN KEY (`AddressTypeID`) REFERENCES `AddressType` (`AddressTypeID`);
ALTER TABLE `Address` ADD CONSTRAINT `FKAddress970307` FOREIGN KEY (`StateProvinceID`) REFERENCES `StateProvince` (`StateProvinceID`);
ALTER TABLE `StateProvince` ADD CONSTRAINT `FKStateProvi487864` FOREIGN KEY (`CountryRegionCode`) REFERENCES `CountryRegion` (`CountryRegionCode`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder350628` FOREIGN KEY (`SalesOrderID`) REFERENCES `SalesOrderDetail` (`SalesOrderID`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder8647` FOREIGN KEY (`ContactID`) REFERENCES `Contact` (`ContactID`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder690159` FOREIGN KEY (`ContactID`, `CreditCardID`) REFERENCES `ContactCreditCard` (`ContactID`, `CreditCardID`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder424361` FOREIGN KEY (`TerritoryID`) REFERENCES `Territory` (`TerritoryID`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder917879` FOREIGN KEY (`TerritoryID`) REFERENCES `SalesTerritory` (`TerritoryID`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder546661` FOREIGN KEY (`CurrencyRateID`) REFERENCES `CurrencyRate` (`CurrencyRateID`);
ALTER TABLE `GameListPriceHistory` ADD CONSTRAINT `FKGameListPr483336` FOREIGN KEY (`GameID`) REFERENCES `Game` (`GameID`);
ALTER TABLE `GameReview` ADD CONSTRAINT `FKGameReview699943` FOREIGN KEY (`GameID`) REFERENCES `Game` (`GameID`);
ALTER TABLE `Game` ADD CONSTRAINT `FKGame20560` FOREIGN KEY (`GameID`) REFERENCES `GameAudiovisuals` (`GameID`);
ALTER TABLE `GameAudiovisuals` ADD CONSTRAINT `FKGameAudiov597889` FOREIGN KEY (`GamePhotoID`) REFERENCES `GamePhoto` (`GamePhotoID`);
ALTER TABLE `GameAudiovisuals` ADD CONSTRAINT `FKGameAudiov655028` FOREIGN KEY (`GameVideoID`) REFERENCES `GameVideo` (`GameVideoID`);
ALTER TABLE `SalesOrderHeader` ADD CONSTRAINT `FKSalesOrder501173` FOREIGN KEY (`CustomerID`) REFERENCES `Customer` (`CustomerID`);
ALTER TABLE `SpecialOfferGame` ADD CONSTRAINT `FKSpecialOff633120` FOREIGN KEY (`GameID`) REFERENCES `Game` (`GameID`);
ALTER TABLE `SpecialOfferGame` ADD CONSTRAINT `FKSpecialOff961126` FOREIGN KEY (`SpecialOfferID`) REFERENCES `SpecialOffer` (`SpecialOfferID`);
ALTER TABLE `ContactCreditCard` ADD CONSTRAINT `FKContactCre2048` FOREIGN KEY (`ContactID`) REFERENCES `Contact` (`ContactID`);
ALTER TABLE `CurrencyRate` ADD CONSTRAINT `FROM` FOREIGN KEY (`FromCurrencyCode`) REFERENCES `Currency` (`CurrencyCode`);
ALTER TABLE `CurrencyRate` ADD CONSTRAINT `TO` FOREIGN KEY (`ToCurrencyCode`) REFERENCES `Currency` (`CurrencyCode`);