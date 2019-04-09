USE master
DROP DATABASE IF EXISTS NetflixStatistics;
CREATE DATABASE NetflixStatistics;
GO
USE NetflixStatistics

/*------------------------------------*/
/*  Hier maken we tabellen - zie ERD  */
/*------------------------------------*/

/* Een tabel voor abonnement/ accounts */
CREATE TABLE Account(
AccountID int IDENTITY (1,1) PRIMARY KEY,
AccountName nvarchar(30) NOT NULL,
Email nvarchar(50) NOT NULL,
Wachtwoord nvarchar(50) NOT NULL,
Straat nvarchar(50) NOT NULL,
Huisnummer nvarchar(6) NOT NULL,
Postcode nvarchar(7) NOT NULL,
AbonneeWoonplaats nvarchar(50) NOT NULL
)

/* Een tabel voor profiels */
CREATE TABLE Profile(
ProfileID int IDENTITY (1,1) PRIMARY KEY,
Profilename nvarchar(50) NOT NULL,
AccountID int NOT NULL,
Age int NOT NULL,

CONSTRAINT Profile_twoFK
	FOREIGN KEY (AccountID)
	REFERENCES Account(AccountID) ON DELETE CASCADE ON UPDATE CASCADE

)


/* Een tabel voor films */
CREATE TABLE Movie(
MovieID int NOT NULL PRIMARY KEY,
Title nvarchar(50) NOT NULL,
AgeIndication int NOT NULL,
Language nvarchar(30) NOT NULL,
Length int NOT NULL,
Genre nvarchar(30) NOT NULL,

);

/* Een tabel voor series */
CREATE TABLE Series(
SerieID int PRIMARY KEY,
Title nvarchar(30) NOT NULL,
Seasons int NOT NULL,
AgeIndication int NOT NULL,
Language nvarchar(30) NOT NULL,
Genre nvarchar(30) NOT NULL,
LooksLike nvarchar(50),



);

/* Een tabel voor afleveringen van series*/
CREATE TABLE Episode(
EpisodeID int NOT NULL PRIMARY KEY,
Serie nvarchar(50) NOT NULL,
SerieID int NOT NULL,
SeasonAndEpisode nvarchar(20) NOT NULL,
Title nvarchar(50) NOT NULL,
Length int NOT NULL,

CONSTRAINT Serie_TwoFK
	FOREIGN KEY(SerieID)
	REFERENCES Series(SerieID),
);

/* Een tabel voor programma's */
CREATE TABLE Program(
ProgramID int NOT NULL PRIMARY KEY,
Title nvarchar(50) NOT NULL,
MovieID int,
SerieID int,
EpisodeID int,
ProfileID int,


CONSTRAINT MovieFK
	FOREIGN KEY(MovieID)
	REFERENCES Movie (MovieID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT SerieFK
	FOREIGN KEY(SerieID)
	REFERENCES Series (SerieID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT ProfileFK
	FOREIGN KEY(ProfileID)
	REFERENCES Profile (ProfileID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT EpisodeFK
	FOREIGN KEY(EpisodeID)
	REFERENCES Episode (EpisodeID) ON DELETE CASCADE ON UPDATE CASCADE,
);

/* Een tabel voor bekeken programma's */


/*---------------------------------------------------------------*/
/* Hier geven we content/ inhoud aan alle tabellen die we hebben gemaakt */
/*---------------------------------------------------------------*/

/*  Abonnement/ Accounts + Profiel */

/* De abonnement van M. Bouhtala + proefiel ---------*/
INSERT INTO Account
VALUES ('M. Bouhtala','zakelijk.mb@hotmail.com','wachtwoord','Nederbrakelstraat','55','4826 CR','Breda');

INSERT INTO Profile
VALUES
('Mouaouia',1,21);


/* ******** Programma's ******** */
/*ProgrammaID int NOT NULL PRIMARY KEY,
Title nvarchar(50) NOT NULL,
FilmID int,
SerieID int,
AfleveringID int,
ProfileID int,*/

INSERT INTO Program
VALUES
/* Dit zijn alle Serie*/
(1001, 'A Study in Pink', null, null, null,null),
(1002, 'The Blind Banker', null, null, null,null),
(1003, 'The Great Game', null, null, null,null),
(1004, 'A Scandal in Belgravia', null, null, null,null),
(1005, 'The Hounds of Baskerville', null, null, null,null),
(1006, 'The Reichenbach Fall', null, null, null,null),
(1007, 'The Empty Hearse', null, null, null,null),
(1008, 'The Sign of Three', null, null, null,null),
(1009, 'His Last Vow', null, null, null,null),
(2000, 'Pilot', null, null, null,null),
(2001, 'Cat''s in the Bag...', null, null, null,null),
(2002, '...And the Bag''s in the River', null, null, null,null),
(2003, 'Cancer Man', null, null, null,null),
(2004, 'Gray Matter', null, null, null,null),
(2005, 'Crazy Handful of Nothin''', null, null, null,null),
(2006, 'A No-Rough-Stuff-Type Deal', null, null, null,null),
(2007, 'Seven Thirty-Seven', null, null, null,null),
(2008, 'Grilled', null, null, null,null),
(2009, 'Bit by a Dead Bee', null, null, null,null),
(2010, 'Down', null, null, null,null),
(2011, 'Breakage', null, null, null,null),
(2012, 'Peekaboo', null, null, null,null),
(2013, 'Negro Y Azul', null, null, null,null),
(2014, 'Better Call Saul', null, null, null,null),
(2015, '4 Days Out', null, null, null,null),
(2016, 'Over', null, null, null,null),
(2017, 'Mandala', null, null, null,null),
(2018, 'Phoenix', null, null, null,null),
(2019, 'ABQ', null, null, null,null),
(3001, 'The Crocodile`s Dilemma', null, null, null,null),
(3002, 'The Rooster Prince', null, null, null,null),
(3003, 'A Muddy Road', null, null, null,null),
(3004, 'Eating the Blame', null, null, null,null),
(3005, 'The Six Ungraspables', null, null, null,null),
(3006, 'Buridan''s Ass', null, null, null,null),
(3007, 'Who Shaves the Barber?', null, null, null,null),
(3008, 'The Heap', null, null, null,null),
(3009, 'A Fox, a Rabbit, and a Cabbage', null, null, null,null),
(3010, 'Morton`s Fork', null, null, null,null),
(3101, 'Waiting for Dutch', null, null, null,null),
(3102, 'Before the Law', null, null, null,null),
(3103, 'The Myth of Sisyphus', null, null, null,null),
(3104, 'The Gift of the Magi', null, null, null,null),
(3105, 'Fear and Trembling', null, null, null,null),
(3106, 'Rhinoceros', null, null, null,null),
(3107, 'Did you do this? No, you did it!', null, null, null,null),
(3108, 'Loplop', null, null, null,null),
(3109, 'The Castle', null, null, null,null),
(3110, 'Palindrome', null, null, null,null),
/* Dit zijn alle Films */
(1010, 'The Abominable Bride', null, null, null,null),
(8001, 'The Life of Brian', null, null, null,null),
(8002, 'Pulp Fiction', null, null, null,null),
(8004, 'Pruimebloesem', null, null, null,null),
(8008, 'Reservoir Dogs', null, null, null,null),
(8010, 'The Good, the Bad and the Ugly', null, null, null,null),
(8011, 'Andy Warhol`s Dracula', null, null, null,null),
(8012, 'Ober', null, null, null,null),
(8014, 'Der Untergang', null, null, null,null),
(8016, 'De helaasheid der dingen', null, null, null,null),
(8017, 'A Clockwork Orange', null, null, null,null);

/* ******** Series ******** */
/*SerieID int NOT NULL PRIMARY KEY,
Title nvarchar(30) NOT NULL,
Seizoenen int NOT NULL,
LeeftijdsIndicatie int NOT NULL,
Genre nvarchar(30) NOT NULL,
Taal nvarchar(30) NOT NULL,
Lijktop nvarchar(50),  */
INSERT INTO Series
VALUES
(111,'Sherlock', '3',		'+12', 'Engels',			'Detective',	'Fargo'),
(112, 'Breaking Bad', '2',	'+16', 'Engels-Amerikaans', 'Spanning',		'Fargo'),
(113,'Fargo', '2',			'+16', 'Engels-Amerikaans', 'Spanning',		'Breaking Bad');


/* ******** Afleveringen ******** */
/*AfleveringID int NOT NULL PRIMARY KEY,
Serie nvarchar(50) NOT NULL,
SerieID int NOT NULL,
Title nvarchar(50) NOT NULL,
SeizoenEnAflevering nvarchar(7) NOT NULL,
Tijdsduur int NOT NULL,*/


INSERT INTO Episode
VALUES
/* Serie: "Sherlock" */
(01001, 'Sherlock', 111, 'S01A01', 'A Study in Pink', 90),
(01002, 'Sherlock', 111, 'S01A02', 'The Blind Banker', 90),
(01003, 'Sherlock', 111, 'S01A03', 'The Great Game', 90),
(01004, 'Sherlock', 111, 'S02A01', 'A Scandal in Belgravia', 90),
(01005, 'Sherlock', 111, 'S02A02', 'The Hounds of Baskerville', 90),
(01006, 'Sherlock', 111, 'S02A03', 'The Reichenbach Fall', 90),
(01007, 'Sherlock', 111, 'S03A01', 'The Empty Hearse', 90),
(01008, 'Sherlock', 111, 'S03A02', 'The Sign of Three', 90),
(01009, 'Sherlock', 111, 'S03A03', 'His Last Vow', 90),
/* Serie: "Breaking Bad" */
(02001, 'Breaking Bad', 112, 'S01A01', 'Pilot', 58),
(02002, 'Breaking Bad', 112, 'S01A02', 'Cat`s in the Bag...', 48),
(02003, 'Breaking Bad', 112, 'S01A03', '...And the Bag`s in the River', 48),
(02004, 'Breaking Bad', 112, 'S01A04', 'Cancer Man', 48),
(02005, 'Breaking Bad', 112, 'S01A05', 'Gray Matter', 48),
(02006, 'Breaking Bad', 112, 'S01A06', 'Crazy Handful of Nothin`', 48),
(02007, 'Breaking Bad', 112, 'S01A07', 'A No-Rough-Stuff-Type Deal', 48),
(02008, 'Breaking Bad', 112, 'S02A01', 'Seven Thirty-Seven', 48),
(02009, 'Breaking Bad', 112, 'S02A02', 'Grilled', 48),
(02010, 'Breaking Bad', 112, 'S02A03', 'Bit by a Dead Bee', 48),
(02011, 'Breaking Bad', 112, 'S02A04', 'Down', 48),
(02012, 'Breaking Bad', 112, 'S02A05', 'Breakage', 48),
(02013, 'Breaking Bad', 112, 'S02A06', 'Peekaboo', 48),
(02014, 'Breaking Bad', 112, 'S02A07', 'Negro Y Azul', 48),
(02015, 'Breaking Bad', 112, 'S02A08', 'Better Call Saul', 48),
(02016, 'Breaking Bad', 112, 'S02A09', '4 Days Out', 48),
(02017, 'Breaking Bad', 112, 'S02A10', 'Over', 48),
(02018, 'Breaking Bad', 112, 'S02A11', 'Mandala', 48),
(02019, 'Breaking Bad', 112, 'S02A12', 'Phoenix', 48),
(02020, 'Breaking Bad', 112, 'S02A13', 'ABQ', 48),
/* Serie: "Fargo" */
(03001, 'Fargo', 113, 'S01A01', 'The Crocodile`s Dilemma', 68),
(03002, 'Fargo', 113, 'S01A02', 'The Rooster Prince', 68),
(03003, 'Fargo', 113, 'S01A03', 'A Muddy Road', 68),
(03004, 'Fargo', 113, 'S01A04', 'Eating the Blame', 68),
(03005, 'Fargo', 113, 'S01A05', 'The Six Ungraspables', 68),
(03006, 'Fargo', 113, 'S01A06', 'Buridan`s Ass', 68),
(03007, 'Fargo', 113, 'S01A07', 'Who Shaves the Barber?', 68),
(03008, 'Fargo', 113, 'S01A08', 'The Heap', 68),
(03009, 'Fargo', 113, 'S01A09', 'A Fox, a Rabbit, and a Cabbage', 68),
(03010, 'Fargo', 113, 'S01A10', 'Morton`s Fork', 68),
(03011, 'Fargo', 113, 'S02A01', 'Waiting for Dutch', 68),
(03012, 'Fargo', 113, 'S02A02', 'Before the Law', 68),
(03013, 'Fargo', 113, 'S02A03', 'The Myth of Sisyphus', 68),
(03014, 'Fargo', 113, 'S02A04', 'The Gift of the Magi', 68),
(03015, 'Fargo', 113, 'S02A05', 'Fear and Trembling', 68),
(03016, 'Fargo', 113, 'S02A06', 'Rhinoceros', 68),
(03017, 'Fargo', 113, 'S02A07', 'Did you do this? No, you did it!', 68),
(03018, 'Fargo', 113, 'S02A08', 'Loplop', 68),
(03019, 'Fargo', 113, 'S02A09', 'The Castle', 68),
(03020, 'Fargo', 113, 'S02A10', 'Palindrome', 68);



/* Films */






INSERT INTO Movie
VALUES
(00001, 'The Abominable Bride',	 '+12',			'Engels',				90, 'Detective'),
(00002, 'The Life of Brian',		'+12',			'Engels',				94, 'Humor'),
(00003, 'Pulp Fiction',			 '+16',			'Engels-Amerikaans',	154, 'Misdaad'),
(00004, 'Pruimebloesem',			 '+18',			'Nederlands',			80, 'Erotiek'),
(00005, 'Reservoir Dogs',			 '+16',			'Engels-Amerikaans',	99, 'Misdaad'),
(00006, 'The Good, the Bad and the Ugly',  '+12',	'Engels-Amerikaans',	151, 'Western'),
(00007, 'Andy Warhol`s Dracula',	 '+16',			'Engels-Amerikaans',	103, 'Humor'),
(00008, 'Ober',					 '+6',			'Nederlands',			97, 'Humor'),
(00009, 'Der Untergang',			 '+6',			'Duits',				178, 'Oorlog'),
(00010, 'De helaasheid der dingen',  '+12',		'Vlaams',				108, 'Humor'),
(00011, 'A Clockwork Orange',		 '+16',			'Engels',				136, 'SF');

