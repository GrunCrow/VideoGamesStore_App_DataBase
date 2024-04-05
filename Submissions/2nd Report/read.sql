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