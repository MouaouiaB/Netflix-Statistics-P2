
CREATE DATABASE NetflixStatistics;
DROP TABLE IF EXISTS Abonnement;
DROP TABLE IF EXISTS Profiel;
DROP TABLE IF EXISTS Programma;
DROP TABLE IF EXISTS Film;
DROP TABLE IF EXISTS Serie;
DROP TABLE IF EXISTS Aflevering;
DROP TABLE IF EXISTS BekekenProgramma;

GO

/*------------------------------------*/
/*  Hier maken we tabellen - zie ERD  */
/*------------------------------------*/

/* Een tabel voor abonnement/ accounts */
CREATE TABLE Abonnement(
AbonneeID int NOT NULL PRIMARY KEY,
AbonneeNaam nvarchar(30) NOT NULL,
Email nvarchar(50) NOT NULL,
Wachtwoord nvarchar(50) NOT NULL,
Straat nvarchar(50) NOT NULL,             
Huisnummer nvarchar(6) NOT NULL,
Postcode nvarchar(7) NOT NULL,
AbonneeWoonplaats nvarchar(50) NOT NULL
);

/* Een tabel voor profiels */
CREATE TABLE Profiel(
Profielnaam nvarchar(30) NOT NULL,
Geboortedatum date NOT NULL,
AbonneeID int 

CONSTRAINT ProfielPK 
	PRIMARY KEY (Profielnaam, AbonneeID),
CONSTRAINT ProfielFK 
	FOREIGN KEY (AbonneeID)
	REFERENCES Abonnement(AbonneeID) ON DELETE CASCADE ON UPDATE CASCADE,

);

/* Een tabel voor programma's */
CREATE TABLE Programma(
ProgrammaID int NOT NULL,
Title nvarchar(50) NOT NULL,

CONSTRAINT ProgrammaPK
	PRIMARY KEY(ProgrammaID, Title)
);

/* Een tabel voor films */
CREATE TABLE Film(
FilmID int NOT NULL PRIMARY KEY,
Title nvarchar(50) NOT NULL,
Tijdsduur time(7) NOT NULL,
Genre nvarchar(30) NOT NULL,
Taal nvarchar(30) NOT NULL,
LeeftijdsIndicatie int NOT NULL,
ProgrammaID int NOT NULL,

CONSTRAINT FilmFK
	FOREIGN KEY(ProgrammaID,Title) 
	REFERENCES Programma(ProgrammaID,Title) ON DELETE CASCADE ON UPDATE CASCADE,
);

/* Een tabel voor series */
CREATE TABLE Serie(
Title nvarchar(50) NOT NULL PRIMARY KEY, 
Genre nvarchar(30) NOT NULL,
Taal nvarchar(30) NOT NULL,
Seizoenen int NOT NULL,
LeeftijdsIndicatie int NOT NULL,
Lijktop nvarchar(50), 
ProgrammaID int NOT NULL,

CONSTRAINT SerieFK
	FOREIGN KEY(ProgrammaID,Title) 
	REFERENCES Programma(ProgrammaID,Title) ON DELETE CASCADE ON UPDATE CASCADE,

);

/* Een tabel voor afleveringen van series*/
CREATE TABLE Aflevering(
AfleveringID int NOT NULL PRIMARY KEY,
Serie nvarchar(50) NOT NULL,
ProgrammaID int NOT NULL,
Title nvarchar(50) NOT NULL,
SeizoenEnAflevering nvarchar(7) NOT NULL,	
Tijdsduur time(7) NOT NULL,

CONSTRAINT AfleveringFK
	FOREIGN KEY(ProgrammaID,Title) 
	REFERENCES Programma(ProgrammaID,Title) ON DELETE CASCADE ON UPDATE CASCADE,
);

/* Een tabel voor bekeken programma's */
CREATE TABLE BekekenProgramma(
AbonneeID int NOT NULL,
Profielnaam nvarchar(30) NOT NULL,
ProgrammaID int NOT NULL,
Title nvarchar(50) NOT NULL,
LaatstBekeken datetime NOT NULL,
Percentage int NOT NULL,

CONSTRAINT BekekenProgrammaFK
	FOREIGN KEY(Profielnaam,AbonneeID) REFERENCES Profiel(Profielnaam,AbonneeID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(ProgrammaID,Title) REFERENCES Programma(ProgrammaID,Title) ON DELETE CASCADE ON UPDATE CASCADE,
);

/*---------------------------------------------------------------*/
/* Hier geven we content/ inhoud aan alle tabellen die we hebben gemaakt */
/*---------------------------------------------------------------*/

/*  Abonnement/ Accounts + Profiel */

/* De abonnement van M. Bouhtala + proefiel ---------*/
INSERT INTO Abonnement (AbonneeID,Email,Wachtwoord,AbonneeNaam,Straat,Huisnummer,Postcode,AbonneeWoonplaats) 
VALUES ('2129074','zakelijk.mb@hotmail.com','mb.zakelijk','M. Bouhtala','Nederbrakelstraat','55','4826 CR','Breda');

INSERT INTO Profiel(Profielnaam,Geboortedatum,AbonneeID) 
VALUES 
('Mouaouia','08-08-1998','2129074'),
('Louki','01-06-2000','2129074');

/* De abonnement van P. Heuvel + proefiel ---------*/
INSERT INTO Abonnement (AbonneeID,Email,Wachtwoord,AbonneeNaam,Straat,Huisnummer,Postcode,AbonneeWoonplaats) 
VALUES ('2127856','pieter.heuvel@hotmail.com','heuvel123','P. Heuvel','Argemidiestraat','10','4826 CR','Breda');

INSERT INTO Profiel(Profielnaam,Geboortedatum,AbonneeID) 
VALUES 
('Pieter','12-01-1994','2127856'),
('Lina','07-11-1999','2127856');

/* De abonnement van S. Siemons + proefiel ---------*/
INSERT INTO Abonnement (AbonneeID, Email, Wachtwoord, AbonneeNaam, Straat, Huisnummer, Postcode, AbonneeWoonplaats)
VALUES ('2086046', 'netflixchill@gmail.com', 'hetgeim12', 'S. Siemons', 'Kalishoek', '1A', '4835 PA', 'Breda');

INSERT INTO Profiel (ProfielNaam, Geboortedatum, AbonneeID) 
VALUES ('Sabrina', '30-07-1996', '2086046');

/* De abonnement van H. van Gertsen + proefiel ---------*/
INSERT INTO Abonnement (AbonneeID, Email, Wachtwoord, AbonneeNaam, Straat, Huisnummer, Postcode, AbonneeWoonplaats)
VALUES ('2140526', 'henkjanVG@outlook.com', 'netflixTijd', 'H. van Gertsen', 'Beekselaan', '22', '3012 JS', 'Den Bosch');

INSERT INTO Profiel (ProfielNaam, Geboortedatum, AbonneeID) 
VALUES ('Henkjan', '16--11-1966', '2140526');

/* De abonnement van V. Claesen + proefiel ---------*/
INSERT INTO Abonnement (AbonneeID, Email, Wachtwoord, AbonneeNaam, Straat, Huisnummer, Postcode, AbonneeWoonplaats)
VALUES ('8049232', 'vatim@gmail.com', 'Vietamines', 'V. Claesen', 'Wilheminastraat', '41', '3282 TT', 'Den Bosch');

INSERT INTO Profiel (ProfielNaam, Geboortedatum, AbonneeID) 
VALUES ('Vatim', '21-02-1989', '8049232');

/* De abonnement van Z. UijtdeHaag + proefiel ---------*/
INSERT INTO Abonnement (AbonneeID, Email, Wachtwoord, AbonneeNaam, Straat, Huisnummer, Postcode, AbonneeWoonplaats)
VALUES ('4569822', 'deHeervanZ@hotmail.com', 'ZakelijkAntwoord', 'Z. UijtdeHaag', 'Marktplein', '14', '2901 RS', 'Roosendaal');

INSERT INTO Profiel (ProfielNaam, Geboortedatum, AbonneeID) 
VALUES ('Zander', '25-10-195', '4569822');


/* ******** Programma's ******** */
INSERT INTO Programma (ProgrammaID,Title) 
VALUES 
/* Dit zijn alle Serie*/
('1001', 'A Study in Pink'),
('1002', 'The Blind Banker'),
('1003', 'The Great Game'),
('1004', 'A Scandal in Belgravia'),
('1005', 'The Hounds of Baskerville'),
('1006', 'The Reichenbach Fall'),
('1007', 'The Empty Hearse'),
('1008', 'The Sign of Three'),
('1009', 'His Last Vow'),
('2000', 'Pilot'),
('2001', 'Cat''s in the Bag...'),
('2002', '...And the Bag''s in the River'),
('2003', 'Cancer Man'),
('2004', 'Gray Matter'),
('2005', 'Crazy Handful of Nothin'''),
('2006', 'A No-Rough-Stuff-Type Deal'),
('2007', 'Seven Thirty-Seven'),
('2008', 'Grilled'),
('2009', 'Bit by a Dead Bee'),
('2010', 'Down'),
('2011', 'Breakage'),
('2012', 'Peekaboo'),
('2013', 'Negro Y Azul'),
('2014', 'Better Call Saul'),
('2015', '4 Days Out'),
('2016', 'Over'),
('2017', 'Mandala'),
('2018', 'Phoenix'),
('2019', 'ABQ'),
('3001', 'The Crocodile`s Dilemma'),
('3002', 'The Rooster Prince'),
('3003', 'A Muddy Road'),
('3004', 'Eating the Blame'),
('3005', 'The Six Ungraspables'),
('3006', 'Buridan''s Ass'),
('3007', 'Who Shaves the Barber?'),
('3008', 'The Heap'),
('3009', 'A Fox, a Rabbit, and a Cabbage'),
('3010', 'Morton`s Fork'),
('3101', 'Waiting for Dutch'),
('3102', 'Before the Law'),
('3103', 'The Myth of Sisyphus'),
('3104', 'The Gift of the Magi'),
('3105', 'Fear and Trembling'),
('3106', 'Rhinoceros'),
('3107', 'Did you do this? No, you did it!'),
('3108', 'Loplop'),
('3109', 'The Castle'),
('3110', 'Palindrome'),
/* Dit zijn alle Films */
('1010', 'The Abominable Bride'),
('8001', 'The Life of Brian'),
('8002', 'Pulp Fiction'),
('8004', 'Pruimebloesem'),
('8008', 'Reservoir Dogs'),
('8010', 'The Good, the Bad and the Ugly'),
('8011', 'Andy Warhol`s Dracula'),
('8012', 'Ober'),
('8014', 'Der Untergang'),
('8016', 'De helaasheid der dingen'),
('8017', 'A Clockwork Orange');

/* ******** Series ******** */
INSERT INTO Serie (Title, Seizoenen, LeeftijdsIndicatie, Taal, Genre, Lijktop) 
VALUES 
('Sherlock', '3',		'+12', 'Engels',			'Detective',	'Fargo'),
('Breaking Bad', '2',	'+16', 'Engels-Amerikaans', 'Spanning',		'Fargo'),
('Fargo', '2',			'+16', 'Engels-Amerikaans', 'Spanning',		'Breaking Bad');


/* ******** Afleveringen ******** */
INSERT INTO Aflevering (AfleveringID, Serie, ProgrammaID, SeizoenEnAflevering, Title, Tijdsduur) 
VALUES 
/* Serie: "Sherlock" */
('01001', 'Sherlock', '1001', 'S01A01', 'A Study in Pink', '01:28:00'),
('01002', 'Sherlock', '1002', 'S01A02', 'The Blind Banker', '01:28:00'),
('01003', 'Sherlock', '1003', 'S01A03', 'The Great Game', '01:28:00'),
('01004', 'Sherlock', '1004', 'S02A01', 'A Scandal in Belgravia', '01:28:00'),
('01005', 'Sherlock', '1005', 'S02A02', 'The Hounds of Baskerville', '01:28:00'),
('01006', 'Sherlock', '1006', 'S02A03', 'The Reichenbach Fall', '01:28:00'),
('01007', 'Sherlock', '1007', 'S03A01', 'The Empty Hearse', '01:28:00'),
('01008', 'Sherlock', '1008', 'S03A02', 'The Sign of Three', '01:28:00'),
('01009', 'Sherlock', '1009', 'S03A03', 'His Last Vow', '01:28:00'),
/* Serie: "Breaking Bad" */
('02001', 'Breaking Bad', '2000', 'S01A01', 'Pilot', '00:58:00'),
('02002', 'Breaking Bad', '2001', 'S01A02', 'Cat`s in the Bag...', '00:48:00'),
('02003', 'Breaking Bad', '2002', 'S01A03', '...And the Bag`s in the River', '00:48:00'),
('02004', 'Breaking Bad', '2003', 'S01A04', 'Cancer Man', '00:48:00'),
('02005', 'Breaking Bad', '2004', 'S01A05', 'Gray Matter', '00:48:00'),
('02006', 'Breaking Bad', '2005', 'S01A06', 'Crazy Handful of Nothin`', '00:48:00'),
('02007', 'Breaking Bad', '2006', 'S01A07', 'A No-Rough-Stuff-Type Deal', '00:48:00'),
('02008', 'Breaking Bad', '2007', 'S02A01', 'Seven Thirty-Seven', '00:48:00'),
('02009', 'Breaking Bad', '2008', 'S02A02', 'Grilled', '00:48:00'),
('02010', 'Breaking Bad', '2009', 'S02A03', 'Bit by a Dead Bee', '00:48:00'),
('02011', 'Breaking Bad', '2010', 'S02A04', 'Down', '00:48:00'),
('02012', 'Breaking Bad', '2011', 'S02A05', 'Breakage', '00:48:00'),
('02013', 'Breaking Bad', '2012', 'S02A06', 'Peekaboo', '00:48:00'),
('02014', 'Breaking Bad', '2013', 'S02A07', 'Negro Y Azul', '00:48:00'),
('02015', 'Breaking Bad', '2014', 'S02A08', 'Better Call Saul', '00:48:00'),
('02016', 'Breaking Bad', '2015', 'S02A09', '4 Days Out', '00:48:00'),
('02017', 'Breaking Bad', '2016', 'S02A10', 'Over', '00:48:00'),
('02018', 'Breaking Bad', '2017', 'S02A11', 'Mandala', '00:48:00'),
('02019', 'Breaking Bad', '2018', 'S02A12', 'Phoenix', '00:48:00'),
('02020', 'Breaking Bad', '2019', 'S02A13', 'ABQ', '00:48:00'),
/* Serie: "Fargo" */
('03001', 'Fargo', '3001', 'S01A01', 'The Crocodile`s Dilemma', '01:08:00'),
('03002', 'Fargo', '3002', 'S01A02', 'The Rooster Prince', '01:08:00'),
('03003', 'Fargo', '3003', 'S01A03', 'A Muddy Road', '01:08:00'),
('03004', 'Fargo', '3004', 'S01A04', 'Eating the Blame', '01:08:00'),
('03005', 'Fargo', '3005', 'S01A05', 'The Six Ungraspables', '01:08:00'),
('03006', 'Fargo', '3006', 'S01A06', 'Buridan`s Ass', '01:08:00'),
('03007', 'Fargo', '3007', 'S01A07', 'Who Shaves the Barber?', '01:08:00'),
('03008', 'Fargo', '3008', 'S01A08', 'The Heap', '01:08:00'),
('03009', 'Fargo', '3009', 'S01A09', 'A Fox, a Rabbit, and a Cabbage', '01:08:00'),
('03010', 'Fargo', '3010', 'S01A10', 'Morton`s Fork', '01:08:00'),
('03011', 'Fargo', '3101', 'S02A01', 'Waiting for Dutch', '01:08:00'),
('03012', 'Fargo', '3102', 'S02A02', 'Before the Law', '01:08:00'),
('03013', 'Fargo', '3103', 'S02A03', 'The Myth of Sisyphus', '01:08:00'),
('03014', 'Fargo', '3104', 'S02A04', 'The Gift of the Magi', '01:08:00'),
('03015', 'Fargo', '3105', 'S02A05', 'Fear and Trembling', '01:08:00'),
('03016', 'Fargo', '3106', 'S02A06', 'Rhinoceros', '01:08:00'),
('03017', 'Fargo', '3107', 'S02A07', 'Did you do this? No, you did it!', '01:08:00'),
('03018', 'Fargo', '3108', 'S02A08', 'Loplop', '01:08:00'),
('03019', 'Fargo', '3109', 'S02A09', 'The Castle', '01:08:00'),
('03020', 'Fargo', '3110', 'S02A10', 'Palindrome', '01:08:00');



/* Films */
INSERT INTO Film (FilmID, Title, ProgrammaID, LeeftijdsIndicatie, Taal, Tijdsduur, Genre) 
VALUES
('00001', 'The Abominable Bride',	'1010', '+12',			'Engels',				'01:29:00', 'Detective'),
('00002', 'The Life of Brian',		'8001', '+12',			'Engels',				'01:34:00', 'Humor'),
('00003', 'Pulp Fiction',			'8002', '+16',			'Engels-Amerikaans',	'02:34:00', 'Misdaad'),
('00004', 'Pruimebloesem',			'8004', '+18',			'Nederlands',			'01:20:00', 'Erotiek'),
('00005', 'Reservoir Dogs',			'8008', '+16',			'Engels-Amerikaans',	'01:39:00', 'Misdaad'),
('00006', 'The Good, the Bad and the Ugly', '8010', '+12',	'Engels-Amerikaans',	'02:41:00', 'Western'),
('00007', 'Andy Warhol`s Dracula',	'8011', '+16',			'Engels-Amerikaans',	'01:43:00', 'Humor'),
('00008', 'Ober',					'8012', '+6',			'Nederlands',			'01:37:00', 'Humor'),
('00009', 'Der Untergang',			'8014', '+6',			'Duits',				'02:58:00', 'Oorlog'),
('00010', 'De helaasheid der dingen', '8016', '+12',		'Vlaams',				'01:48:00', 'Humor'),
('00011', 'A Clockwork Orange',		'8017', '+16',			'Engels',				'02:16:00', 'SF');


/* Bekeken Films en Series/ aflevering */
INSERT INTO BekekenProgramma (AbonneeID, Profielnaam, ProgrammaID, Title, LaatstBekeken, Percentage) 
VALUES
/* Bekeken Films: */
('2129074', 'Mouaouia',	'1010', 'The Abominable Bride',	'07-11-2018', 100),
('2129074', 'Louki',	'8001', 'The Life of Brian',	'02-11-2018', 77),
('2127856', 'Pieter',	'8002', 'Pulp Fiction',			'22-12-2018', 10),
('2127856', 'Lina',		'8004', 'Pruimebloesem',		'21-12-2018', 98),
('2086046', 'Sabrina',	'8008', 'Reservoir Dogs',		'30-11-2018', 12),
('2086046', 'Sabrina',	'8010', 'The Good, the Bad and the Ugly', '01-12-2018', 69),
('2140526', 'Henkjan',	'8011', 'Andy Warhol`s Dracula','05-01-2019', 25),
('8049232', 'Vatin',	'8012', 'Ober',					'17-01-2019', 100),
('2127856', 'Lina',		'8014', 'Der Untergang',		'08-08-2018', 55),
('2129074', 'Louki',	'8016', 'De helaasheid der dingen', '14-11-2018', 4),
('4569822', 'Zander',	'8017', 'A Clockwork Orange',	'02-01-2019', 99),
/* Bekeken Series/ aflevering */
('2129074', 'Mouaouia', '1001', 'A Study in Pink',		'07-11-2018', 100),
('2129074', 'Mouaouia',	'1002', 'The Blind Banker',		'08-11-2018', 100),
('2129074', 'Mouaouia',	'1003', 'The Great Game',		'09-11-2018', 05),

('2129074', 'Louki',	'1007', 'The Empty Hearse',		'02-11-2018', 77),
('2129074', 'Louki',	'1008', 'The Sign of Three',	'03-11-2018', 45),
('2129074', 'Louki',	'1009', 'His Last Vow',			'04-11-2018', 99),

('2127856', 'Pieter',	'2008', 'Grilled',				'22-12-2018', 10),
('2127856', 'Pieter',	'2009', 'Bit by a Dead Bee',	'23-12-2018', 83),
('2127856', 'Pieter',	'2010', 'Down',					'24-12-2018', 99),

('2127856', 'Lina',		'2015', '4 Days Out',			'21-12-2018', 100),
('2127856', 'Lina',		'2017', 'Mandala',				'25-12-2018', 100),
('2127856', 'Lina',		'2018', 'Phoenix',				'26-12-2018', 98),

('2086046', 'Sabrina',	'3002', 'The Rooster Prince',	'30-11-2018', 14),
('2086046', 'Sabrina',	'3003', 'A Muddy Road',			'01-12-2018', 87),
('2086046', 'Sabrina',	'3004', 'Eating the Blame',		'02-12-2018', 69),

('2140526', 'Henkjan',	'3008', 'The Heap',				'05-01-2019', 52),
('2140526', 'Henkjan',	'3010', 'Morton`s Fork',		'06-01-2019', 63),
('2140526', 'Henkjan',	'3101', 'Waiting for Dutch',	'07-01-2019', 15),

('8049232', 'Vatin',	'2019', 'ABQ',					'17-01-2019', 72),
('8049232', 'Vatin',    '3001', 'The Crocodile`s Dilemma', '18-01-2019', 35),
('8049232', 'Vatin',	'3002', 'The Rooster Prince',	'19-01-2019', 100),

('4569822', 'Zander',	'3108', 'Loplop',				'02-01-2019', 99),
('4569822', 'Zander',	'3109', 'The Castle',			'03-01-2019', 91),	
('4569822', 'Zander',	'3110', 'Palindrome',			'04-01-2019', 25);	