CREATE DATABASE IF NOT EXISTS LOO_database;

USE LOO_Database;

DROP TABLE IF EXISTS painters;
DROP TABLE IF EXISTS auction_paintings;
DROP TABLE IF EXISTS inventory_paintings;

CREATE TABLE painters (
	painterID INT NOT NULL AUTO_INCREMENT,
	firstName varchar (20) NOT NULL,
	lastName varchar (20) NOT NULL,
	fashionability INT NOT NULL,
	PRIMARY KEY(painterID)
) ENGINE=InnoDB
;

CREATE TABLE auction_paintings (
	painterID INT NOT NULL,
	title varchar (40) NOT NULL,
	dateOfWork INT,
	dateOfAuction DATE,
	salePrice INT,
	height INT,
	widht INT,
	medium varchar (25),
	subject varchar (25),
	INDEX(medium),
	INDEX(subject),
	FOREIGN KEY(painterID) REFERENCES painters(painterID)
) ENGINE=InnoDB
;

CREATE TABLE inventory_paintings (
	painterID INT NOT NULL,
	title varchar (40) NOT NULL,
	dateOfWork INT,
	clasification varchar(30) NOT NULL,
	height INT,
	widht INT,
	medium varchar (25),
	subject varchar (25),
	dateOfPurchase DATE,
	nameOfSeller varchar(30) NOT NULL,
	addressOfSeller varchar(40) NOT NULL,
	maximunPurchasePrice INT,
	actualPurchasePrice INT,
	targetSellingPrice INT,
	sold CHAR(1),
	dateOfSale DATE,
	nameOfBuyer varchar(30),
	addressOfBuyer varchar(40),
	actualSellingPrice INT,
	INDEX(clasification),
	FOREIGN KEY(painterID) REFERENCES painters(painterID)
) ENGINE=InnoDB
;

insert into painters (firstName, lastName, fashionability) values ('Sam','Bock','10');
insert into painters (firstName, lastName, fashionability) values ('Claudio','Arce','11');
insert into painters (firstName, lastName, fashionability) values ('Tim','Burwitz','20');
insert into painters (firstName, lastName, fashionability) values ('Clint','Freiheit','15');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (1, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (1, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (1, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (2, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (2, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (2, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (3, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (3, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (3, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (4, 'Painting1-1', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (4, 'Painting1-2', 1997, '20100422', 3100000.55, 24.10, 15.10, 'Canvas', 'Room');

insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject)
values (4, 'Painting1-3', 1985, '20020322', 5000000.55, 23.10, 75.10, 'Water', 'House');