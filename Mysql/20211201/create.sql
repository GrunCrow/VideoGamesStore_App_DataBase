DROP TABLE IF EXISTS `onlinevideogamestore`.`address`, `onlinevideogamestore`.`addresstype`, `onlinevideogamestore`.`cardtype`, `onlinevideogamestore`.`contact`, `onlinevideogamestore`.`contactcreditcard`, `onlinevideogamestore`.`countryregion`, `onlinevideogamestore`.`creditcard`, `onlinevideogamestore`.`currency`, `onlinevideogamestore`.`currencyrate`, `onlinevideogamestore`.`customer`, `onlinevideogamestore`.`game`, `onlinevideogamestore`.`game_shoppingcartitem`, `onlinevideogamestore`.`gameaudiovisuals`, `onlinevideogamestore`.`gamelistpricehistory`, `onlinevideogamestore`.`gamephoto`, `onlinevideogamestore`.`gamereview`, `onlinevideogamestore`.`gamevideo`, `onlinevideogamestore`.`genre`, `onlinevideogamestore`.`saga`, `onlinevideogamestore`.`salesorderdetail`, `onlinevideogamestore`.`salesorderheader`, `onlinevideogamestore`.`salesterritory`, `onlinevideogamestore`.`shoppingcartitem`, `onlinevideogamestore`.`specialoffer`, `onlinevideogamestore`.`specialoffergame`, `onlinevideogamestore`.`stateprovince`, `onlinevideogamestore`.`territory`, `onlinevideogamestore`.`title`,`onlinevideogamestore`.`unitmeasure`,`onlinevideogamestore`.`countryregioncurrency`;

/*USE SCHEMA onlinevideogamestore;*/

/*Game*/

CREATE TABLE Game (
	GameID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	Name varchar(50) NOT NULL UNIQUE, 
	GameNumber varchar(25) NOT NULL UNIQUE, 
	StandardCost DECIMAL(13, 4) NOT NULL DEFAULT 0.00, 
	ListPrice Decimal(13,4),
    Storage varchar(5), 
    StorageUnitMeasureCode char(3),
	GenreID int, 
    PlatformID char(5), 
    Description varchar(255), 
	SagaID int, 
    /*GameReviewID int,*/
    SellStartDate datetime NOT NULL, 
	SellEndDate datetime, 
    LaunchDate datetime,
	ModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP	
);

CREATE TABLE UnitMeasure (
	UnitMeasureCode char(3) NOT NULL PRIMARY KEY UNIQUE ,
	Name varchar(50) NOT NULL UNIQUE, 
	ModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP	
);

CREATE TABLE Genre (
	GenreID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	Name varchar(50) NOT NULL UNIQUE, 
	Description varchar(255),
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE GameAudiovisuals (
	GameID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	GamePhotoID int UNIQUE, 
	GameVideoID int UNIQUE, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE GamePhoto (
	GamePhotoID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	Icon varchar(50),
    Wallpaper varchar(50),
    Header varchar(50),
    Preview varchar(50),
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE GameVideo (
	GameVideoID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	ReviewVideo varchar(50),
    PreviewVideo varchar(50),
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE GameReview (
	GameReviewID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	GameID int NOT NULL, 
	ReviewerName varchar(50) NOT NULL, 
	ReviewDate datetime NOT NULL default current_timestamp, 
	EmailAddress varchar(50) NOT NULL, 
	Rating int NOT NULL, 
	Comments varchar(3000), 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

/*CREATE TABLE UnitMeasure (
	UnitMeasureCode char(3) NOT NULL UNIQUE PRIMARY KEY, 
	Name varchar(50) NOT NULL UNIQUE,
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp
    );
*/

CREATE TABLE GameListPriceHistory (
	GameID int NOT NULL, 
	StartDate datetime NOT NULL, 
	EndDate datetime, 
	ListPrice decimal(13,4) NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp,
	Primary key(GameID,StartDate)
);

CREATE TABLE Game_ShoppingCartItem (
	GameID int NOT NULL, 
	ShoppingCartItemID int NOT NULL, 
	PRIMARY KEY (GameID, ShoppingCartItemID));

CREATE TABLE Saga (
	SagaID int NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT, 
	Name varchar(50) NOT NULL, 
	Quantity int NOT NULL,
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

/*Sales*/

CREATE TABLE CountryRegionCurrency(
	CountryRegionCode varchar(3) not null,
    CurrencyCode char(3) not null,
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp,
    PRIMARY KEY (CountryRegionCode, CurrencyCode)
);

CREATE TABLE CreditCard (
	CreditCardID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	CardTypeID int NOT NULL, 
	CardNumber varchar(25) NOT NULL UNIQUE, 
	ExpMonth TINYINT NOT NULL, 
	ExpYear smallint NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE CardType ( 
	CardTypeID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	Name varchar(25) NOT NULL UNIQUE, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE Currency (
	CurrencyCode char(3) PRIMARY KEY NOT NULL, 
	Name varchar(25) NOT NULL UNIQUE, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE CurrencyRate (
	CurrencyRateID int primary KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	CurrencyRateDate datetime NOT NULL, 
	FromCurrencyCode char(3) NOT NULL, 
	ToCurrencyCode char(3) NOT NULL, 
	AverageRate Decimal(13,4) NOT NULL, 
	EndOfDayRate Decimal(13,4) NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp,
	constraint UC_CurrencyRate Unique (CurrencyRateDate,FromCurrencyCode,ToCurrencyCode)
);

CREATE TABLE Customer (
	CustomerID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	TerritoryID int, 
	AccountNumber varchar(10) NOT NULL UNIQUE, 
	ContactID int NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE ContactCreditCard (
	ContactID int NOT NULL, 
	CreditCardID int NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp,
	PRIMARY KEY (ContactID, CreditCardID),
    constraint UC_ContactCreditCard Unique (ContactID,CreditCardID)
);

CREATE TABLE SalesOrderDetail (
	SalesOrderID int NOT NULL auto_increment, 
	SalesOrderDetailID int NOT NULL, 
	TrackingNumber int, 
	OrderQnty int, 
	GameID int NOT NULL, 
	SpecialOfferID int NOT NULL, 
	UnitPrice int, 
	UnitPriceDiscount int, 
	LineTotal int, 
	ModifiedDate DATETIME, 
	PRIMARY KEY (SalesOrderID, SalesOrderDetailID)
);

CREATE TABLE SalesOrderHeader (
	SalesOrderID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	RevisionNumber tinyint NOT NULL DEFAULT 0, 
	OrderDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	DueDate datetime NOT NULL, 
	Status tinyint NOT NULL DEFAULT 1, 
	SalesOrderNumber varchar(25) UNIQUE, 
	AccountNumber varchar(15), 
	CustomerID int NOT NULL, 
	ContactID int NOT NULL, 
	TerritoryID int, 
	BillToAddressID int NOT NULL, 
	CreditCartdApprovalCode varchar(15), 
	SubTotal DECIMAL(13, 4) NOT NULL DEFAULT 0.00,  /*DECIMAL(13, 4) = money*/
	TaxAmt DECIMAL(13, 4) NOT NULL DEFAULT 0.00, 
	Comment varchar(128), 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp, 
	CreditCardID int, 
	CurrencyRateID int, 
	ContactCreditCardCreditCardID int NOT NULL); 
    /*PRIMARY KEY (SalesOrderID), UNIQUE INDEX (SalesOrderID)*/

CREATE TABLE SalesTerritory (
	TerritoryID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	Name varchar(50) NOT NULL UNIQUE, 
	CountryRegionCode varchar(3) NOT NULL, 
	`Group` varchar(50) NOT NULL, 
	SalesYTD DECIMAL(13, 4) NOT NULL default 0, 
	SalesLastYear DECIMAL(13, 4) NOT NULL default 0, 
	CostYTD DECIMAL(13, 4) NOT NULL default 0, 
	CostLastYear DECIMAL(13, 4) NOT NULL default 0, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE ShoppingCartItem (
	ShoppingCartItemID int PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
	ShoppingCartID varchar(50) NOT NULL, 
	GameID int NOT NULL, 
	DateCreated datetime NOT NULL DEFAULT current_timestamp, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE SpecialOffer (
	SpecialOfferID int PRIMARY KEY NOT NULL UNIQUE, 
    Description varchar(255) NOT NULL, 
    Discount DECIMAL(13, 4) NOT NULL default 0, 
    Type varchar(50) NOT NULL, 
    StartDate date NOT NULL, 
    EndDate date NOT NULL, 
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp, 
    SpecialOfferProductGameID int NOT NULL 
);

/*Person*/

CREATE TABLE SpecialOfferGame (
	SpecialOfferID int NOT NULL UNIQUE, 
    GameID int NOT NULL, 
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp, 
    PRIMARY KEY (SpecialOfferID, GameID)
);
    
CREATE TABLE Address (
	AddressID int NOT NULL unique PRIMARY KEY AUTO_INCREMENT, 
    AddressTypeID int NOT NULL, 
    AddressLine1 varchar(60), 
    AddressLine2 varchar(60), 
    City varchar(30) NOT NULL, 
    StateProvinceID int NOT NULL, 
    PostalCode int NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE AddressType (
	AddressTypeID int NOT NULL unique PRIMARY KEY AUTO_INCREMENT,
    Name varchar(255) NOT NULL UNIQUE
);

CREATE TABLE Contact (
	ContactID int NOT NULL unique PRIMARY KEY AUTO_INCREMENT, 
    TitleID int NOT NULL, 
    FirstName varchar(255) NOT NULL, 
    MiddleName varchar(255), 
    LastName varchar(255) NOT NULL, 
    EmailAdress varchar(255) NOT NULL UNIQUE, 
    Phone int NOT NULL, 
    Password int NOT NULL,
    AdditionalContactInfo varchar(255), 
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp, 
    AddressID int NOT NULL
);

CREATE TABLE CountryRegion (
	CountryRegionCode varchar(3) PRIMARY KEY UNIQUE NOT NULL, 
    Name varchar(255) NOT NULL Unique, 
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE StateProvince (
	StateProvinceID inT NOT NULL unique PRIMARY KEY AUTO_INCREMENT,
    CountryRegionCode varchar(3) NOT NULL, 
    IsOnlyStateProvinceFlag binary(1) NOT NULL DEFAULT 0, 
    Name varchar(255) NOT NULL, 
    TerritoryID int NOT NULL, 
    ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE Territory (
	TerritoryID int NOT NULL unique PRIMARY KEY AUTO_INCREMENT, 
    Name varchar(255) NOT NULL UNIQUE, 
    CountryRegionCode varchar(3) NOT NULL, 
	ModifiedDate datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE Title (
	TitleID int NOT NULL unique PRIMARY KEY AUTO_INCREMENT,
    Name varchar(255) NOT NULL UNIQUE
);

    /* -----------------------------------------------------------------------------------------------------------------*/



ALTER TABLE Game_ShoppingCartItem ADD CONSTRAINT FKGame_ShoppingCartItem_Game FOREIGN KEY (GameID) REFERENCES Game (GameID);
ALTER TABLE Game ADD CONSTRAINT FKGame_Genre FOREIGN KEY (GenreID) REFERENCES Genre (GenreID);
ALTER TABLE Game ADD CONSTRAINT FKGame_Saga FOREIGN KEY (SagaID) REFERENCES Saga (SagaID);
ALTER TABLE Game_ShoppingCartItem ADD CONSTRAINT FKGame_ShoppingCartItem FOREIGN KEY (ShoppingCartItemID) REFERENCES ShoppingCartItem (ShoppingCartItemID);
ALTER TABLE CreditCard ADD CONSTRAINT FKCreditCard_CardType FOREIGN KEY (CardTypeID) REFERENCES CardType (CardTypeID);
ALTER TABLE CurrencyRate ADD CONSTRAINT FKCurrencyRate_CurrencyFROM FOREIGN KEY (FromCurrencyCode) REFERENCES Currency (CurrencyCode);
ALTER TABLE CurrencyRate ADD CONSTRAINT FKCurrencyRate_CurrencyTO FOREIGN KEY (ToCurrencyCode) REFERENCES Currency (CurrencyCode);
ALTER TABLE ContactCreditCard ADD CONSTRAINT FKContactCreditCard_CreditCard FOREIGN KEY (CreditCardID) REFERENCES CreditCard (CreditCardID);
ALTER TABLE Customer ADD CONSTRAINT FKCustomer_Territory FOREIGN KEY (TerritoryID) REFERENCES Territory (TerritoryID);
ALTER TABLE Territory ADD CONSTRAINT FKTerritory_CountryRegion FOREIGN KEY (CountryRegionCode) REFERENCES CountryRegion (CountryRegionCode);
ALTER TABLE Customer ADD CONSTRAINT FKCustomer_Contact FOREIGN KEY (ContactID) REFERENCES Contact (ContactID);
ALTER TABLE Contact ADD CONSTRAINT FKContact_Title FOREIGN KEY (TitleID) REFERENCES Title (TitleID);
ALTER TABLE Contact ADD CONSTRAINT FKContact_Address FOREIGN KEY (AddressID) REFERENCES Address (AddressID);
ALTER TABLE Address ADD CONSTRAINT FKAddress_AddressType FOREIGN KEY (AddressTypeID) REFERENCES AddressType (AddressTypeID);
ALTER TABLE Address ADD CONSTRAINT FKAddress_StateProvince FOREIGN KEY (StateProvinceID) REFERENCES StateProvince (StateProvinceID);
ALTER TABLE StateProvince ADD CONSTRAINT FKStateProvince_CountryRegion FOREIGN KEY (CountryRegionCode) REFERENCES CountryRegion (CountryRegionCode);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_SalesOrderDetail FOREIGN KEY (SalesOrderID) REFERENCES SalesOrderDetail (SalesOrderID);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_Contact FOREIGN KEY (ContactID) REFERENCES Contact (ContactID);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_ContactCreditCard2 FOREIGN KEY (ContactID, CreditCardID) REFERENCES ContactCreditCard (ContactID, CreditCardID);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_Territory FOREIGN KEY (TerritoryID) REFERENCES Territory (TerritoryID);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_SalesTerritory FOREIGN KEY (TerritoryID) REFERENCES SalesTerritory (TerritoryID);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_CurrencyRate FOREIGN KEY (CurrencyRateID) REFERENCES CurrencyRate (CurrencyRateID);
ALTER TABLE GameListPriceHistory ADD CONSTRAINT FKGameListPriceHistory_Game FOREIGN KEY (GameID) REFERENCES Game (GameID);
ALTER TABLE GameReview ADD CONSTRAINT FKGameReview_Game FOREIGN KEY (GameID) REFERENCES Game (GameID);
ALTER TABLE GameAudiovisuals ADD CONSTRAINT FKGame_GameAudiovisuals FOREIGN KEY (GameID) REFERENCES Game (GameID);
/*ALTER TABLE Game ADD CONSTRAINT FKGame_GameAudiovisuals FOREIGN KEY (GameID) REFERENCES GameAudiovisuals (GameID);*/
/*ALTER TABLE Game DROP FOREIGN KEY FKGame_GameAudiovisuals;*/
ALTER TABLE GameAudiovisuals ADD CONSTRAINT FKGameAudiovisuals_GamePhoto FOREIGN KEY (GamePhotoID) REFERENCES GamePhoto (GamePhotoID);
ALTER TABLE GameAudiovisuals ADD CONSTRAINT FKGameAudiovisuals_GameVideo FOREIGN KEY (GameVideoID) REFERENCES GameVideo (GameVideoID);
ALTER TABLE SalesOrderHeader ADD CONSTRAINT FKSalesOrderHeader_Customer FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID);
ALTER TABLE SpecialOfferGame ADD CONSTRAINT FKSpecialOfferGame_Game FOREIGN KEY (GameID) REFERENCES Game (GameID);
ALTER TABLE SpecialOfferGame ADD CONSTRAINT FKSpecialOfferGame_SpecialOffer FOREIGN KEY (SpecialOfferID) REFERENCES SpecialOffer (SpecialOfferID);
/*ALTER TABLE SpecialOfferGame DROP FOREIGN KEY FKSpecialOfferGame_SpecialOffer;*/

/*
ALTER TABLE SpecialOffer ADD CONSTRAINT FKSpecialOffer FOREIGN KEY (SpecialOfferID, SpecialOfferProductGameID) REFERENCES SpecialOfferGame (SpecialOfferID, GameID);
ALTER TABLE SpecialOffer DROP FOREIGN KEY FKSpecialOffer;*/
SELECT * FROM specialoffergame;

ALTER TABLE SalesOrderDetail ADD CONSTRAINT FKSalesOrderDetail_SpecialOfferGame FOREIGN KEY (SpecialOfferID, GameID) REFERENCES SpecialOfferGame (SpecialOfferID, GameID);
/*ALTER TABLE SalesOrderDetail DROP FOREIGN KEY FKSalesOrderDetail_SpecialOfferGame;*/

ALTER TABLE ContactCreditCard ADD CONSTRAINT FKContactCreditCard FOREIGN KEY (ContactID) REFERENCES Contact (ContactID);

ALTER TABLE countryregioncurrency ADD CONSTRAINT FKcountryregioncurrency FOREIGN KEY (CountryRegionCode) REFERENCES CountryRegion (CountryRegionCode);
ALTER TABLE gamelistpricehistory ADD CONSTRAINT FKGameListPriceHistory FOREIGN KEY (GameID) REFERENCES Game (GameID);

ALTER TABLE GAME ADD CONSTRAINT FKunitmeasure FOREIGN KEY (StorageUnitMeasureCode) REFERENCES UnitMeasure (UnitMeasureCode);