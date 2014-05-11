DROP DATABASE IF EXISTS LOO_database;
CREATE DATABASE IF NOT EXISTS LOO_database;

USE LOO_Database;

DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS auction_paintings;
DROP TABLE IF EXISTS inventory_paintings;

CREATE TABLE artists (
	artistID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (20),
	lastName varchar (20),
	fashionability INT,
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
	FOREIGN KEY(artistID) REFERENCES artists(artistID)
) ENGINE=InnoDB
;

CREATE TABLE inventory_paintings (
	artistID INT NOT NULL,
	title varchar (40),
	dateOfWork INT,
	classification varchar(30),
	height DECIMAL,
	width DECIMAL,
	medium varchar (25),
	subject varchar (25),
	dateOfPurchase DATE,
	nameOfSeller varchar(30) ,
	addressOfSeller varchar(40) ,
	maximumPurchasePrice DECIMAL,
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
	FOREIGN KEY(artistID) REFERENCES artists(artistID)
) ENGINE=InnoDB
;
 
insert into artists (firstName, lastName, fashionability) values ('Sam','Bock','5522');
insert into artists (firstName, lastName, fashionability) values ('Claudio','Arce','4000');
insert into artists (firstName, lastName, fashionability) values ('Tim','Burwitz','6000');
insert into artists (firstName, lastName, fashionability) values ('Clint','Freiheit','8900');
insert into artists (firstName, lastName, fashionability) values ('Jessica','Spalding','4250');
insert into artists (firstName, lastName, fashionability) values ('Heidi','Engebrestsen','7500');
insert into artists (firstName, lastName, fashionability) values ('Katie','Jesperson','9500');
insert into artists (firstName, lastName, fashionability) values ('Steve','Shum','9999');



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

insert into inventory_paintings (artistID, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting1', 2001, 'Masterpiece', 12.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, true, '20140128', 'Jessica Spalding',
			'Costelo', 400000.54);
			
			
insert into inventory_paintings (artistID, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting2', 2001, 'Masterpiece', 12.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, false, NULL, '',
			'', 0);

insert into inventory_paintings (artistID, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting3', 1981, 'Masterpiece', 110.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, true, '20110128', 'Jessica Spalding',
			'Costelo', 400000.99);