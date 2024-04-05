UPDATE stateprovince
SET TerritoryID=13
WHERE Name='England';

SELECT * FROM GAMEAUDIOVISUALS ;

UPDATE gameaudiovisuals
SET GameID=3
where gamephotoID=1;

SELECT * FROM SALESORDERDETAIL;
SELECT * FROM SpecialOffer;

UPDATE SALESORDERDETAIL
SET SpecialOfferID=1
where GameID=2;

SELECT * FROM GAME;

UPDATE Game
SET StorageUnitMeasureCode='GB'
where GameID=4;

UPDATE Game
SET Storage=1
where GameID=4;

UPDATE Game
SET GameID=1
where GameID=5;

UPDATE Game
SET Storage=20
where GameID=1;

UPDATE Game
SET StorageUnitMeasureCode='GB'
where GameID=1;

SELECT * FROM address;
SELECT * FROM addresstype;

UPDATE addresstype
SET AddressTypeID=2
where AddressTypeID=6;

UPDATE addresstype
SET AddressTypeID=4
where AddressTypeID=5;

UPDATE addresstype
SET AddressTypeID=5
where AddressTypeID=7;

SELECT * FROM addresstype
Order by addresstypeid;

UPDATE address
SET AddressTypeID=2,
	ModifiedDate = current_timestamp()
where AddressID=2;

SELECT * FROM address;

SELECT * FROM contact;

UPDATE contact
SET ModifiedDate = current_timestamp(),
	AdditionalContactInfo = 'Additional Info updated'
where ContactID = 2;

SELECT * FROM countryregion;
SELECT * FROM countryregioncurrency;

UPDATE countryregioncurrency
SET ModifiedDate = current_timestamp(),
	CurrencyCode = 'EUR'
where CountryRegionCode = 'PL';

UPDATE countryregioncurrency
SET ModifiedDate = current_timestamp(),
	CurrencyCode = 'PLN'
where CountryRegionCode = 'PL';

SELECT * FROM creditcard;

UPDATE creditcard
SET ModifiedDate = current_timestamp(),
	CreditCardID = 2
where CreditCardID = 4;

SELECT * FROM territory;
UPDATE territory
SET ModifiedDate = current_timestamp(),
	TerritoryID = 8
where TerritoryID = 13;

SELECT * FROM gamereview;
UPDATE gamereview
SET ModifiedDate = current_timestamp(),
	Comments = 'Not the best game'
where GameReviewID = 1;

select * from territory;

SELECT * FROM salesterritory;
UPDATE salesterritory
SET ModifiedDate = current_timestamp(),
	SalesTerritoryID = 10
where SalesTerritoryID = 11;
