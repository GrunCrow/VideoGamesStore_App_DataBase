/*tests to delete*/

INSERT INTO address (AddressTypeID, AddressLine1,City,StateProvinceID,PostalCode)
VALUES(
	3,
    'test street',
    'Madrid',
	2,
    21000
);

SELECT * FROM ADDRESS;

DELETE FROM address
WhERE City='Madrid';

SELECT * FROM ADDRESS;

INSERT INTO address (AddressTypeID, AddressLine1,City,StateProvinceID,PostalCode)
VALUES(
	3,
    'test street',
    'Madrid',
	2,
    21000
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

INSERT INTO contact (TitleID, FirstName, LastName,EmailAdress,Phone,Password,AddressID)
VALUES(
	3,
    'Test',
    'Test Om',
    'email1@gmail.com',
	123456789,
    '123456789',
    2
);

SELECT * FROM Contact;

DELETE FROM contact
WHERE ContactID=4;

SELECT * FROM creditcard;

DELETE FROM CREDITCARD
WHERE CreditCardID = 3;

INSERT INTO game (Name,GameNumber,StandardCost,GenreID,PlatformID,Description,SellStartDate)
VALUES(
	'Test',
    5,
    0.99,
    3,
    'PC',
	'Test',
    current_timestamp()
);

SELECT * FROM game;

DELETE FROM game
WHERE GAMEID=7;
