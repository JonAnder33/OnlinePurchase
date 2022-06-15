/* DELETE 'auctions_user' database*/
DROP SCHEMA IF EXISTS onlinePurchaseDB;
/* DELETE USER 'auctions_user' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'%';

/* CREATE ''auctionsdb' DATABASE */
CREATE SCHEMA onlinePurchaseDB;
/* CREATE THE USER 'auctions_user' AT LOCAL SERVER WITH PASSWORD 'auctions_user' */
CREATE USER 'spq'@'%' IDENTIFIED BY 'spq';
/* GRANT FULL ACCESS TO THE DATABASE 'auctionsdb' FOR THE USER 'auctions_user' AT LOCAL SERVER*/
GRANT ALL ON onlinePurchaseDB.* TO 'spq'@'%';