SELECT * FROM addresstype;
Show columns FROM addresstype;

INSERT INTO addresstype (Name)
VALUES(
	'Billing'
);

INSERT INTO addresstype (Name)
VALUES(
	'Home'
);

INSERT INTO addresstype (Name)
VALUES(
	 'Main Office'
);

INSERT INTO addresstype (Name)
VALUES(
	'Primary'
);

INSERT INTO addresstype (Name)
VALUES(
	'Archive'
);

SELECT * FROM cardtype;

INSERT INTO cardtype (Name)
VALUES(
	'Mastercard'
);

INSERT INTO cardtype (Name)
VALUES(
	'VISA'
);

SELECT * FROM title;

INSERT INTO title (Name)
VALUES(
	'Sr.'
);

INSERT INTO title (Name)
VALUES(
	'Mrs.'
);

INSERT INTO title (Name)
VALUES(
	'Null'
);

INSERT INTO title (Name)
VALUES(
	'Sra.'
);

INSERT INTO title (Name)
VALUES(
	'Ms.'
);

INSERT INTO title (Name)
VALUES(
	'Mr.'
);

SELECT * FROM countryregion;
Show columns FROM countryregion;

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'AD',
    'Andorra'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'AR',
    'Argentina'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'Be',
    'Belgium'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'CA',
    'Canada'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'CN',
    'China'
);

/*INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'AD',
    'bla'
);*/

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'CZ',
    'Czech Republic'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'DE',
    'Germany'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'ES',
    'Spain'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'GB',
    'United Kingdom'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'PL',
    'Poland'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'PT',
    'Portugal'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'US',
    'United States'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'FR',
    'France'
);

INSERT INTO countryregion (CountryRegionCode, Name)
VALUES(
	'AU',
    'Australia'
);

SELECT * FROM territory;
Show columns FROM territory;

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'NorthWest',
    'US',
    'North America'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'NorthEast',
    'US',
    'North America'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'Central',
    'US',
    'North America'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'SouthWest',
    'US',
    'North America'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'SouthEast',
    'US',
    'North America'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'Canada',
    'CA',
    'North America'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'France',
    'FR',
    'Europe'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'Germany',
    'DE',
    'Europe'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'Australia',
    'AU',
    'Pacific'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'United Kingdom',
    'GB', /*GR*/
    'Europe'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'Spain',
    'ES',
    'Europe'
);

INSERT INTO territory (Name, CountryRegionCode, Groupname)
VALUES(
	'Poland',
    'PL', /*GR*/
    'Europe'
);

SELECT * FROM TERRITORY;
SELECT * FROM stateprovince;
Show columns FROM stateprovince;

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'ENG',
    'GB',
    1,
    'England',
    7 /*update to 13*/
);

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'AB',
    'CA',
    0,
    'Alberta',
    6
);


SELECT * FROM TERRITORY;

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'HU',
    'ES',
    0,
    'Huelva',
    15
);

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'MAD',
    'ES',
    0,
    'Madrid',
    15
);

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'BA',
    'ES',
    0,
    'Barcelona',
    15
);

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'WRO',
    'PL',
    0,
    'Wroclaw',
    16
);

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'WAR',
    'PL',
    0,
    'Warsaw',
    16
);

INSERT INTO stateprovince (StateProvinceCode,CountryRegionCode,IsOnlyStateProvinceFlag, Name,TerritoryID)
VALUES(
	'KRA',
    'PL',
    0,
    'Krakov',
    16
);

SELECT * FROM stateprovince;

Show columns FROM address;

INSERT INTO address (AddressTypeID, AddressLine1, AddressLine2,City,StateProvinceID,PostalCode)
VALUES(
	3,
    'Avenida Julio Caro Baroja',
    'nº12 4ºA',
    'Huelva',
	2,
    21002
);

INSERT INTO address (AddressTypeID, AddressLine1, AddressLine2,City,StateProvinceID,PostalCode)
VALUES(
	3,
    'Boleslawa Prusa',
    'nº9 410B',
    'Wroclaw',
	5,
    50319
);

SELECT * FROM contact;
Show columns FROM contact;

INSERT INTO contact (TitleID, FirstName, LastName,EmailAdress,Phone,Password,AddressID)
VALUES(
	4,
    'Alba',
    'Marquez Rodriguez',
    'albamrqz751@gmail.com',
	601195832,
    '123456789',
    1
);

INSERT INTO contact (TitleID, FirstName, LastName,EmailAdress,Phone,Password,AddressID)
VALUES(
	2,
    'Joan',
    'Rand Om',
    'email@gmail.com',
	123456789,
    '123456789',
    2
);

SELECT * FROM creditcard;
Show columns FROM creditcard;
INSERT INTO creditcard (CardTypeID, CardNumber, ExpMonth,ExpYear)
VALUES(
	1,
    1234567898765432,
    12,
    2025
);

INSERT INTO creditcard (CardTypeID, CardNumber, ExpMonth,ExpYear)
VALUES(
	1,
    0000000012348765,/*1234567898765432,*/
    4,
    2022
);

INSERT INTO creditcard (CardTypeID, CardNumber, ExpMonth,ExpYear)
VALUES(
	2,
    0120000012348765,/*1234567898765432,*/
    7,
    2028
);

SELECT * FROM contactcreditcard;
Show columns FROM contactcreditcard;

INSERT INTO contactcreditcard (ContactID, CreditCardID)
VALUES(
	1,
    1
);

/*INSERT INTO contactcreditcard (ContactID, CreditCardID)
VALUES(
	1,
    2
);*/


SELECT * FROM currency;
Show columns FROM currency;
INSERT INTO currency (CurrencyCode, Name)
VALUES(
	'EUR',
    'EURO'
);

INSERT INTO currency (CurrencyCode, Name)
VALUES(
	'PLN',
    'Zloty'
);

INSERT INTO currency (CurrencyCode, Name)
VALUES(
	'GBP',
    'United Kingdom Pound'
);

INSERT INTO currency (CurrencyCode, Name)
VALUES(
	'USD',
    'US Dollar'
);

INSERT INTO currency (CurrencyCode, Name)
VALUES(
	'AUD',
    'Australian Dollar'
);


SELECT * FROM countryregioncurrency;
Show columns FROM countryregioncurrency;

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'AU',
    'AUD'
);

select * from countryregion;

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'AD',
    'EUR'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'ES',
    'EUR'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'BE',
    'EUR'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'DE',
    'EUR'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'FR',
    'EUR'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'PL',
    'PLN'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'PT',
    'EUR'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'US',
    'USD'
);

INSERT INTO countryregioncurrency (CountryRegionCode,CurrencyCode)
VALUES(
	'GB',
    'GBP'
);


SELECT * FROM territory;
Show columns FROM customer;

INSERT INTO customer (TerritoryID,AccountNumber,ContactID)
VALUES(
	15,
    1,
    1
);

SELECT * FROM unitmeasure;
Show columns FROM unitmeasure;
INSERT INTO unitmeasure (UnitMeasureCode,Name)
VALUES(
	'GB',
    'GigaByte'
);

INSERT INTO unitmeasure (UnitMeasureCode,Name)
VALUES(
	'MB',
    'MegaByte'
);

SELECT * FROM genre;
Show columns FROM genre;

INSERT INTO genre (Name)
VALUES(
	'Action'
);

INSERT INTO genre (Name)
VALUES(
	'Fantasy'
);
INSERT INTO genre (Name)
VALUES(
	'Thriller'
);

INSERT INTO genre (Name)
VALUES(
	'Casual'
);

SELECT * FROM saga;
Show columns FROM saga;

INSERT INTO saga (Name,Quantity)
VALUES(
	'Just Cause',
    4
);

SELECT * FROM game;
Show columns FROM game;
INSERT INTO game (Name,GameNumber,StandardCost,Storage,StorageUnitMeasureCode,GenreID,PlatformID,Description,SagaID,SellStartDate)
VALUES(
	'Just Cause 4 Reloaded',
    1,
    32.99,
    47,
    'GB',
    1,
    'PC',
    'Rebel agent Rico Rodríguez arrives in Solís, a vast world located in South America mired in conflict, oppression and extreme weather conditions. Buckle up your wingsuit, equip the customizable hook, and prepare to unleash the tempest! ',
    1,
    current_timestamp()
);

INSERT INTO game (Name,GameNumber,StandardCost,Storage,StorageUnitMeasureCode,GenreID,PlatformID,Description,SellStartDate)
VALUES(
	'Minecraft',
    2,
    23.95,
    1,
    'GB',
    1,
    'PC',
    'Prepare for an adventure of limitless possibilities as you build, mine, battle creatures and explore the ever-changing landscape of Minecraft ',
    current_timestamp()
);

INSERT INTO game (Name,GameNumber,StandardCost,GenreID,PlatformID,Description,SellStartDate)
VALUES(
	'Among Us',
    3,
    3.99,
    3,
    'PC',
    'A game for 4 to 15 players online or in local mode via Wi-Fi in which you have to prepare your spaceship for take off. But beware: one or more randomly chosen players from the crew are imposters ready to kill the rest! ',
    current_timestamp()
);

SELECT * FROM GENRE;

INSERT INTO game (Name,GameNumber,StandardCost,GenreID,PlatformID,Description,SellStartDate)
VALUES(
	'Rocket League',
    4,
    0,
    3,
    'PC',
    'Rocket League combines arcade-style soccer with four-wheel mayhem, easy controls, and fluid, physics-based competition. ',
    current_timestamp()
);

SELECT * FROM game;
Show columns FROM gamereview;

INSERT INTO gamereview (GameID,ReviewerName,EmailAddress,Rating)
VALUES(
	4,
    'Alba',
    'albamrqz751@gmail.com',
    8
);

INSERT INTO gamereview (GameID,ReviewerName,EmailAddress,Rating,Comments)
VALUES(
	4,
    'Mary',
    'mary@gmail.com',
    6,
    'Good Game'
);

/*SELECT * FROM gamelistpricehistory;
Show columns FROM gamelistpricehistory;
INSERT INTO gamelistpricehistory (GameID,StartDate,ListPrice)
VALUES(
	4,
    current_timestamp(),
    32.99
);*/


SELECT * FROM shoppingcartitem;
Show columns FROM shoppingcartitem;
INSERT INTO shoppingcartitem (ShoppingCartID,GameID)
VALUES(
	1,
    2
);

INSERT INTO shoppingcartitem (ShoppingCartID,GameID)
VALUES(
	1,
    4
);

INSERT INTO shoppingcartitem (ShoppingCartID,GameID)
VALUES(
	2,
    2
);

INSERT INTO shoppingcartitem (ShoppingCartID,GameID)
VALUES(
	3,
    3
);


SELECT * FROM game_shoppingcartitem;
Show columns FROM game_shoppingcartitem;

INSERT INTO game_shoppingcartitem (GameID,shoppingcartitemID)
VALUES(
	2,
    1
);

INSERT INTO game_shoppingcartitem (GameID,shoppingcartitemID)
VALUES(
	3,
    2
);

SELECT * FROM gamephoto;
Show columns FROM gamephoto;

INSERT INTO gamephoto (Icon,Header)
VALUES(
	'url1',
    'url2'
);

INSERT INTO gamephoto (Icon,Header)
VALUES(
	'url1',
    'url2'
);

INSERT INTO gamephoto (Header,Preview)
VALUES(
	'url1',
    'url2'
);

INSERT INTO gamephoto (Icon,Header,Preview)
VALUES(
	'url1',
    'url2',
    'url3'
);

SELECT * FROM gamevideo;
Show columns FROM gamevideo;

INSERT INTO gamevideo (ReviewVideo,PreviewVideo)
VALUES(
	'url1',
    'url2'
);

INSERT INTO gamevideo (PreviewVideo)
VALUES(
	'url1'
);

INSERT INTO gamevideo (PreviewVideo)
VALUES(
	'url1'
);

INSERT INTO gamevideo (reviewVideo)
VALUES(
	'url1'
);

SELECT * FROM gameaudiovisuals;
Show columns FROM gameaudiovisuals;

INSERT INTO gameaudiovisuals (GameID,GamePhotoID)
VALUES(
	2,
    1
);

INSERT INTO gameaudiovisuals (GameID,GamePhotoID,GameVideoID)
VALUES(
	1,
    2,
    1
);

SELECT * FROM gamelistpricehistory;
Show columns FROM gamelistpricehistory;

INSERT INTO gamelistpricehistory (GameID,StartDate,ListPrice)
VALUES(
	2,
    current_timestamp(),
    32.99
);

SELECT * FROM specialoffergame;
Show columns FROM specialoffergame;

INSERT INTO specialoffergame (SpecialOfferID,GameID)
VALUES(
	1,
    2
);

INSERT INTO specialoffergame (SpecialOfferID,GameID)
VALUES(
	2,
    3
);

INSERT INTO specialoffergame (SpecialOfferID,GameID)
VALUES(
	3,
    4
);

SELECT * FROM specialoffer;
Show columns FROM specialoffer;

INSERT INTO specialoffer (SpecialOfferID,Description,Discount,Type,StartDate,EndDate,SpecialOfferProductGameID)
VALUES(
	1,
    'No Discount',
    0,
    'No discount',
    current_timestamp(),
    '2030-11-23 00:00:00',
    1
);

INSERT INTO specialoffer (SpecialOfferID,Description,Discount,Type,StartDate,EndDate,SpecialOfferProductGameID)
VALUES(
	2,
    'No Discount',
    0,
    'No discount',
    current_timestamp(),
    '2030-11-23 00:00:00',
    2
);

INSERT INTO specialoffer (SpecialOfferID,Description,Discount,Type,StartDate,EndDate,SpecialOfferProductGameID)
VALUES(
	3,
    'No Discount',
    0,
    'No discount',
    current_timestamp(),
    '2030-11-23 00:00:00',
    3
);

SELECT * FROM salesorderdetail;
Show columns FROM salesorderdetail;

INSERT INTO salesorderdetail (salesorderdetailID,OrderQnty,GameID,UnitPrice,SpecialOfferID,LineTotal)
VALUES(
	1,
    1,
    2,
    32.99,
    0,
    32.99
);

SELECT * FROM salesorderheader;
Show columns FROM salesorderheader;

INSERT INTO salesorderheader (SalesOrderID,RevisionNumber,DueDate,Status,CustomerID,ContactID,BillToAddressID,SubTotal,TaxAmt,ContactCreditCardCreditCardID)
VALUES(
	3,
    1,
	'2021-12-25 00:00:00',
    4,
    1,
    1,
    1,
    32.99,
    0,
    1
);



SELECT * FROM salesterritory;
Show columns FROM salesterritory;

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'NorthWest',
    'US',
    'North America',
    0,
    0,
    0,
    0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'NorthEast',
    'US',
    'North America',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'Central',
    'US',
    'North America',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)VALUES(
	'SouthWest',
    'US',
    'North America',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'SouthEast',
    'US',
    'North America',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'Canada',
    'CA',
    'North America',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'France',
    'FR',
    'Europe',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'Germany',
    'DE',
    'Europe',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'Australia',
    'AU',
    'Pacific',
    0,0,0,0
);

INSERT INTO salesterritory (Name, CountryRegionCode, `Group`,SalesYTD,SalesLastYear,CostYTD,CostLastYear)
VALUES(
	'United Kingdom',
    'GB',
    'Europe',
    0,0,0,0
);








