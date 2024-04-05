SELECT * FROM address;
SELECT * FROM addresstype;
SELECT * FROM cardtype;
SELECT * FROM contact;
SELECT * FROM contactcreditcard;
SELECT * FROM countryregion;
SELECT * FROM countryregioncurrency;
SELECT * FROM creditcard;
SELECT * FROM currency;
SELECT * FROM customer;
SELECT * FROM game;
SELECT * FROM game_shoppingcartitem;
SELECT * FROM gameaudiovisuals;
SELECT * FROM gamelistpricehistory;
SELECT * FROM gamephoto;
SELECT * FROM gamereview;
SELECT * FROM gamevideo;
SELECT * FROM genre;
SELECT * FROM saga;
SELECT * FROM salesorderdetail;
SELECT * FROM salesorderheader;
SELECT * FROM salesterritory;
SELECT * FROM shoppingcartitem;
SELECT * FROM specialoff;
SELECT * FROM specialoffergame;
SELECT * FROM stateprovince;
SELECT * FROM territory;
SELECT * FROM title;

select * from address
where City='Wroclaw';

select * from territory
where CountryRegionCode='US';

select city from address as ad
join stateprovince as st on ad.StateProvinceID=st.StateProvinceID
where st.CountryRegionCode='PL';

Select * from contact where EmailAdress="?";

SELECT contact.FirstName, contact.EmailAdress FROM contact WHERE contact.FirstName = "Alba" and contact.password = "123456789";

Select at.Name, a.AddressLine1, a.AddressLine2, a.City,sp.name, a.PostalCode, t.Name, c.FirstName, c.MiddleName, c.LastName, c.EmailAdress, c.Phone
from contact as c INNER JOIN
address as a on c.AddressID = a.AddressID INNER JOIN
addresstype as at on a.AddressTypeID = at.AddressTypeID INNER JOIN
stateprovince as sp on a.StateProvinceID = sp.StateProvinceID INNER JOIN
title as t on c.TitleID=t.TitleID
where EmailAdress="albamrqz751@gmail.com" and Password="123456789";

Select at.Name, a.AddressLine1, a.AddressLine2, a.City, sp.name, a.PostalCode, t.name, c.ContactID 
from contact as c INNER JOIN
address as a on c.AddressID = a.AddressID INNER JOIN
addresstype as at on a.AddressTypeID = at.AddressTypeID INNER JOIN
stateprovince as sp on c.StateProvinceID = sp.StateProvinceID INNER JOIN

where EmailAdress="albamrqz751@gmail.com" and Password="123456789" 