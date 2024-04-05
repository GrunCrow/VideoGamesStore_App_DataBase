ALTER TABLE territory
ADD COLUMN GroupName VARCHAR(50) AFTER CountryRegionCode;

ALTER TABLE STATEPROVINCE
ADD COLUMN StateProvinceCode char(3) AFTER StateProvinceID;


SELECT * FROM GAMEAUDIOVISUALS ;

ALTER TABLE GameAudiovisuals
DROP COLUMN GameID;

ALTER TABLE GameAudiovisuals
ADD COLUMN GameID int NOT NULL First ;

ALTER TABLE GameAudiovisuals
ADD COLUMN GameAudiovisualsID int PRIMARY KEY UNIQUE NOT NULL Auto_increment FIRST;

ALTER TABLE salesterritory RENAME COLUMN territoryid TO SalesTerritoryID;

