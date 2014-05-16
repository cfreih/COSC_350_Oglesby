DROP DATABASE IF EXISTS LOO_database;
CREATE DATABASE IF NOT EXISTS LOO_database;

USE LOO_Database;

DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS auction_paintings;
DROP TABLE IF EXISTS inventory_paintings;

CREATE TABLE artists (
	artistID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (21),
	lastName varchar (21),
	fashionability INT,
	PRIMARY KEY(artistID)
)	
;

CREATE TABLE auction_paintings (	
	auctionPaintingID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (21),
	lastName varchar (21),
	title varchar (41),
	dateOfWork varchar (5),
	dateOfAuction INT(8),
	salePrice DECIMAL(10,2),
	height DECIMAL(10,2),
	width DECIMAL(10,2),
	medium varchar (25),
	subject varchar (25),	
	INDEX(medium),
	INDEX(subject),	
	PRIMARY KEY(auctionPaintingID)
)
;

CREATE TABLE inventory_paintings (
	inventoryPaintingID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (21),
	lastName varchar (21),
	title varchar (41),
	dateOfWork varchar (5),
	classification varchar(30),
	height DECIMAL(10,2),
	width DECIMAL(10,2),
	medium varchar (25),
	subject varchar (25),
	dateOfPurchase INT(8),
	nameOfSeller varchar(30) ,
	addressOfSeller varchar(40) ,
	maximumPurchasePrice DECIMAL(10,2),
	actualPurchasePrice DECIMAL(10,2),
	dateOfSale INT(8),
	nameOfBuyer varchar(42),
	addressOfBuyer varchar(42),
	actualSellingPrice DECIMAL(10,2),
	INDEX(dateOfPurchase),
	INDEX(dateOfSale),
	PRIMARY KEY(inventoryPaintingID)
)
;
 
insert into artists (firstName, lastName, fashionability) values ('Sam','Bock','5522');
insert into artists (firstName, lastName, fashionability) values ('Claudio','Arce','4000');
insert into artists (firstName, lastName, fashionability) values ('Tim','Burwitz','6000');
insert into artists (firstName, lastName, fashionability) values ('Clint','Freiheit','8900');
insert into artists (firstName, lastName, fashionability) values ('Jessica','Spalding','4250');
insert into artists (firstName, lastName, fashionability) values ('Heidi','Engebrestsen','7500');
insert into artists (firstName, lastName, fashionability) values ('Katie','Jesperson','9500');
insert into artists (firstName, lastName, fashionability) values ('Steve','Shum','9999');



insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Sam','Bock', 'Painting1-1', '1995', '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Sam','Bock', 'Painting1-2', '1997', '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Sam','Bock', 'Painting1-3', '1985', '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Claudio','Arce', 'Painting1-1', '1995?', '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Claudio','Arce', 'Painting1-2', '1997?', '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Claudio','Arce', 'Painting1-3', '1985', '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Tim','Burwitz', 'Painting1-1', '1995', '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Tim','Burwitz', 'Painting1-2', '1997', '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Tim','Burwitz', 'Painting1-3', '1985', '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Clint','Freiheit', 'Painting1-1', '1995', '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Clint','Freiheit', 'Painting1-2', '1997', '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (firstName, lastName, title, dateOfWork, dateOfAuction, salePrice, height, width, medium, subject)
values ('Clint','Freiheit', 'Painting1-3', '1985', '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');



insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Sam', 'Bock', 'TestPainting-1', '1825', 'Masterwork', 12.0, 34.0, 'Oil', 'computers', 20140122, 'Steve Shum', 'GSC', 100000, 50600, 20140128, 'Jessica Spalding', 'Costelo', 400000.54);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Sam','Bock', 'TestPainting-2', '2004',     'Masterwork',  12.0,     34.0,   'Oil',   'computers', 20140123,         'Steve Shum', 'GSC',           90000,                80000,               20140129,   'Jessica Spalding', 'Costelo',      4000000.54);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Claudio',     'Arce',   'TestPainting-3', '1600?',     'Other',  12.0,     34.0,   'Oil',   'computers', 20130124,         'Steve Shum', 'GSC',           20000,                50000,               null,   null, null,      null);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Clint',     'Freiheit',   'TestPainting-4', '1756',     'Other',  12.0,     34.0,   'Oil',   'computers', 20140125,         'Steve Shum', 'GSC',           60000,                50000,               20140127,   'Jessica Spalding', 'Costelo',      1400000.54);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Clint',     'Freiheit',   'TestPainting-5', '1754',     'Masterwork',  12.0,     34.0,   'Oil',   'computers', 20140126,         'Steve Shum', 'GSC',           10000,                50000,               20140126,   'Jessica Spalding', 'Costelo',      200000.54);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Steve',     'Shum',   'TestPainting-6', '1564',     'Masterwork',  12.0,     34.0,   'Oil',   'computers', 20140127,         'Steve Shum', 'GSC',           10000,                50000,               null,   null, null,      null);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Sam',     'Bock',   'TestPainting-7', '1801',     'Masterpiece',  12.0,     34.0,   'Oil',   'computers', 20130822,         'Steve Shum', 'GSC',           40000,                50000,               20140125,   'Jessica Spalding', 'Costelo',      40000.54);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Tim',     'Burwitz',   'TestPainting-8', '2001',     'Masterwork',  12.0,     34.0,   'Oil',   'computers', 20140922,         'Steve Shum', 'GSC',           10000,                50000,               null,   null, null,      null);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Tim',     'Burwitz',   'TestPainting-9', '1525',     'Masterpiece',  12.0,     34.0,   'Oil',   'computers', 20140222,         'Steve Shum', 'GSC',           100000,                50000,               20140124,   'Jessica Spalding', 'Costelo',      90000.54);

insert into inventory_paintings (firstName, lastName, title, dateOfWork, classification, height, width, medium, subject, dateOfPurchase, nameOfSeller, addressOfSeller, maximumPurchasePrice, actualPurchasePrice, dateOfSale, nameOfBuyer, addressOfBuyer, actualSellingPrice)
values ('Steve',     'Shum',   'TestPainting-10', '1725',     'Masterpiece',  12.0,     34.0,   'Oil',   'computers', 20140122,         'Steve Shum', 'GSC',           10000,                50000,               null,   null, null,      null);            
