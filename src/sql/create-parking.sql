DROP SCHEMA IF EXISTS onlinePurchaseDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA onlinePurchaseDB;
CREATE USER 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON onlinePurchaseDB.* TO 'spq'@'localhost';
