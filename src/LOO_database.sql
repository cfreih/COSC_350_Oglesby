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
) /* ENGINE=InnoDB */
;

CREATE TABLE auction_paintings (	
	auctionPaintingID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (20),
	lastName varchar (20),
	title varchar (40),
	dateOfWork INT,
	dateOfAuction INT(18),
	salePrice DECIMAL(18,2),
	height DECIMAL(10,2),
	width DECIMAL(10,2),
	medium varchar (25),
	subject varchar (25),	
	INDEX(medium),
	INDEX(subject),	
	PRIMARY KEY(auctionPaintingID)
) /* ENGINE=InnoDB */
;

CREATE TABLE inventory_paintings (
	inventoryPaintingID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (20),
	lastName varchar (20),
	title varchar (40),
	dateOfWork INT,
	classification varchar(30),
	height DECIMAL(10,2),
	width DECIMAL(10,2),
	medium varchar (25),
	subject varchar (25),
	dateOfPurchase INT,
	nameOfSeller varchar(30) ,
	addressOfSeller varchar(40) ,
	maximumPurchasePrice DECIMAL(18,2),
	actualPurchasePrice DECIMAL(18,2),
	dateOfSale INT,
	nameOfBuyer varchar(30),
	addressOfBuyer varchar(40),
	actualSellingPrice DECIMAL(18,2),
	flagBoughtReport BOOLEAN DEFAULT FALSE,
	flagSoldReport BOOLEAN DEFAULT FALSE,	
	INDEX(dateOfPurchase),
	INDEX(dateOfSale),	
	INDEX(dateOfPurchase),
	INDEX(dateOfSale),
	PRIMARY KEY(inventoryPaintingID)
) /* ENGINE=InnoDB */
;
 
/* insert into artists (firstName, lastName, fashionability) values ('Sam','Bock','5522');
insert into artists (firstName, lastName, fashionability) values ('Claudio','Arce','4000');
insert into artists (firstName, lastName, fashionability) values ('Tim','Burwitz','6000');
insert into artists (firstName, lastName, fashionability) values ('Clint','Freiheit','8900');
insert into artists (firstName, lastName, fashionability) values ('Jessica','Spalding','4250');
insert into artists (firstName, lastName, fashionability) values ('Heidi','Engebrestsen','7500');
insert into artists (firstName, lastName, fashionability) values ('Katie','Jesperson','9500');
insert into artists (firstName, lastName, fashionability) values ('Steve','Shum','9999');



insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Sam','Bock', 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Sam','Bock', 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Sam','Bock', 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Claudio','Arce', 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Claudio','Arce', 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Claudio','Arce', 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Tim','Burwitz', 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Tim','Burwitz', 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Tim','Burwitz', 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Clint','Freiheit', 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Clint','Freiheit', 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Clint','Freiheit', 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values ('Sam','Bock', 'TestPainting1', 2001, 'Masterpiece', 12.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, '20140128', 'Jessica Spalding',
			'Costelo', 400000.54);
			
			
insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values ('Sam','Bock', 'TestPainting2', 2001, 'Masterpiece', 12.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, NULL, '',
			'', 0);


insert into inventory_paintings (artistID, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, targetSellingPrice, sold, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values (1, 'TestPainting3', 1981, 'Masterpiece', 110.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, 200000, true, '20110128', 'Jessica Spalding',
			'Costelo', 400000.99); */

/* insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, 
			nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, 
			nameOfBuyer, addressOfBuyer, actualSellingPrice) values ('Sam','Bock', 'TestPainting3', 1981, 'Masterpiece', 110.0, 34.0, 
			'Oil', 'computers', '20140122', 'Steve Shum', 'GSC', 10000, 50000, '20110128', 'Jessica Spalding',
			'Costelo', 400000.99);
 */
