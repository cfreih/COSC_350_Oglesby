DROP DATABASE IF EXISTS LOO_database;
CREATE DATABASE IF NOT EXISTS LOO_database;

USE LOO_Database;

DROP TABLE IF EXISTS painters;
DROP TABLE IF EXISTS auction_paintings;
DROP TABLE IF EXISTS inventory_paintings;

CREATE TABLE artists (
	artistID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (20),
	lastName varchar (20),
	fashionability DECIMAL,
	PRIMARY KEY(artistID)
) ENGINE=InnoDB
;

CREATE TABLE auction_paintings (
	artistID INT NOT NULL,
	title varchar (40),
	dateOfWork INT,
	dateOfAuction DATE,
	salePrice DECIMAL,
	height DECIMAL,
	width DECIMAL,
	medium varchar (25),
	subject varchar (25),
	INDEX(medium),
	INDEX(subject),
	FOREIGN KEY(artistID) REFERENCES painters(artistID)
) ENGINE=InnoDB
;

CREATE TABLE inventory_paintings (
	artistID INT NOT NULL,
	title varchar (40),
	dateOfWork INT,
	clasification varchar(30),
	height DECIMAL,
	width DECIMAL,
	medium varchar (25),
	subject varchar (25),
	dateOfPurchase DATE,
	nameOfSeller varchar(30) ,
	addressOfSeller varchar(40) ,
	maximunPurchasePrice DECIMAL,
	actualPurchasePrice DECIMAL,
	targetSellingPrice DECIMAL,
	sold BOOLEAN DEFAULT FALSE,
	dateOfSale DATE,
	nameOfBuyer varchar(30),
	addressOfBuyer varchar(40),
	actualSellingPrice DECIMAL,
	flagBoughtReport BOOLEAN DEFAULT FALSE,
	flagSoldReport BOOLEAN DEFAULT FALSE,
	INDEX(dateOfPurchase),
	INDEX(dateOfSale),
	FOREIGN KEY(artistID) REFERENCES painters(artistID)
) ENGINE=InnoDB
;
/* 
insert into painters (firstName, lastName, fashionability) values ('Sam','Bock','10');
insert into painters (firstName, lastName, fashionability) values ('Claudio','Arce','11');
insert into painters (firstName, lastName, fashionability) values ('Tim','Burwitz','20');
insert into painters (firstName, lastName, fashionability) values ('Clint','Freiheit','15');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (1, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (1, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (1, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (2, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (2, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (2, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (3, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (3, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (3, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (4, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (4, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (artistID, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values (4, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into inventory_paintings (artistID, title, dateOfWork, clasification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximunPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting1', 2001, 'Masterpiece', 12.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, 1, '20140128', 'Jessica Spalding',
			'Costelo', 400000.54);
			
			
insert into inventory_paintings (artistID, title, dateOfWork, clasification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximunPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting2', 2001, 'Masterpiece', 12.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, 1, '20110128', 'Jessica Spalding',
			'Costelo', 400000.73);

insert into inventory_paintings (artistID, title, dateOfWork, clasification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximunPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting3', 1981, 'Masterpiece', 110.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, 1, '20110128', 'Jessica Spalding',
			'Costelo', 400000.99); */