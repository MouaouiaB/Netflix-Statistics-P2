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
AccountName nvarchar(40)  NOT NULL,
FullName nvarchar(40)  NOT NULL,
Email nvarchar(40) NOT NULL,
Password nvarchar(40) NOT NULL,
Street nvarchar(40) NOT NULL,
HouseNumber nvarchar(40) NOT NULL,
ZipCode nvarchar(40) NOT NULL,
City nvarchar(40) NOT NULL
)

/* Een tabel voor profiels */
CREATE TABLE Profile(
ProfileID int IDENTITY (1,1) PRIMARY KEY,
Profilename nvarchar(30) UNIQUE  NOT NULL,
AccountName nvarchar(40),
AccountID int NOT NULL,
Age int NOT NULL,

CONSTRAINT Profile_twoFK
	FOREIGN KEY (AccountID)
	REFERENCES Account(AccountID) ON DELETE CASCADE ON UPDATE CASCADE

)


/* Een tabel voor films */
CREATE TABLE Movie(
MovieID int IDENTITY (1,1) PRIMARY KEY,
Title nvarchar(30) NOT NULL,
AgeIndication int NOT NULL,
Language nvarchar(30) NOT NULL,
Length int NOT NULL,
Genre nvarchar(30) NOT NULL,

);

/* Een tabel voor series */
CREATE TABLE Series(
SerieID int IDENTITY (1,1) PRIMARY KEY,
Title nvarchar(30) NOT NULL,
Seasons int NOT NULL,
AgeIndication int NOT NULL,
Language nvarchar(30) NOT NULL,
Genre nvarchar(30) NOT NULL,
LooksLike nvarchar(50),



);

/* Een tabel voor afleveringen van series*/
CREATE TABLE Episode(
EpisodeID int IDENTITY (1,1) PRIMARY KEY,
Serie nvarchar(30) NOT NULL,
SerieID int NOT NULL,
SeasonAndEpisode nvarchar(20) NOT NULL,
Title nvarchar(50) NOT NULL,
Length int NOT NULL,

CONSTRAINT Serie_TwoFK
	FOREIGN KEY(SerieID)
	REFERENCES Series(SerieID)

);

/* Een tabel voor programma's */
CREATE TABLE Program(
ProgramID int IDENTITY (1,1) PRIMARY KEY,
Title nvarchar(50) NOT NULL,
MovieID int,
SerieID int,
EpisodeID int,
ProfileID int,
Precentage int


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
VALUES
('BouhtalaAccount','M. Bouhtala','zakelijk.mb@hotmail.com','wachtwoord','Nederbrakelstraat','55','4826 CR','Breda'),
('AymanAccount','Ayman El Bouhazzaoui','ayman@hotmail.com','wachtwoord','Pootlaan','17','4707 JA','Roosendaal');

INSERT INTO Profile
VALUES
('Mouaouia', 'BouhtalaAccount',1,21),
('Ayman', 'AymanAccount' ,2,22);


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
('A Study in Pink', null, null, null,null,40),
( 'The Blind Banker', null, null, null,null,40),
( 'The Great Game', null, null, null,null,40),
( 'A Scandal in Belgravia', null, null, null,null,40),
( 'The Hounds of Baskerville', null, null, null,null,40),
('The Reichenbach Fall', null, null, null,null,40),
( 'The Empty Hearse', null, null, null,null,40),
( 'The Sign of Three', null, null, null,null,40),
( 'His Last Vow', null, null, null,null,40),
( 'Pilot', null, null, null,null,40),
('Cat''s in the Bag...', null, null, null,null,40),
('...And the Bag''s in the River', null, null, null,null,40),
( 'Cancer Man', null, null, null,null,40),
( 'Gray Matter', null, null, null,null,40),
( 'Crazy Handful of Nothin''', null, null, null,null,40),
( 'A No-Rough-Stuff-Type Deal', null, null, null,null,40),
( 'Seven Thirty-Seven', null, null, null,null,40),
( 'Grilled', null, null, null,null,40),
( 'Bit by a Dead Bee', null, null, null,null,40),
( 'Down', null, null, null,null,40),
( 'Breakage', null, null, null,null,40),
( 'Peekaboo', null, null, null,null,40),
('Negro Y Azul', null, null, null,null,40),
( 'Better Call Saul', null, null, null,null,40),
( '4 Days Out', null, null, null,null,40),
( 'Over', null, null, null,null,40),
( 'Mandala', null, null, null,null,40),
( 'Phoenix', null, null, null,null,40),
( 'ABQ', null, null, null,null,40),
( 'The Crocodile`s Dilemma', null, null, null,null,40),
( 'The Rooster Prince', null, null, null,null,40),
( 'A Muddy Road', null, null, null,null,40),
('Eating the Blame', null, null, null,null,40),
( 'The Six Ungraspables', null, null, null,null,40),
( 'Buridan''s Ass', null, null, null,null,40),
( 'Who Shaves the Barber?', null, null, null,null,40),
( 'The Heap', null, null, null,null,40),
( 'A Fox, a Rabbit, and a Cabbage', null, null, null,null,40),
( 'Morton`s Fork', null, null, null,null,40),
( 'Waiting for Dutch', null, null, null,null,40),
( 'Before the Law', null, null, null,null,40),
( 'The Myth of Sisyphus', null, null, null,null,40),
( 'The Gift of the Magi', null, null, null,null,40),
( 'Fear and Trembling', null, null, null,null,40),
( 'Rhinoceros', null, null, null,null,40),
( 'Did you do this? No, you did it!', null, null, null,null,40),
( 'Loplop', null, null, null,null,40),
( 'The Castle', null, null, null,null,40),
( 'Palindrome', null, null, null,null,40),
/* Dit zijn alle Films */
( 'The Abominable Bride', null, null, null,null,40),
( 'The Life of Brian', null, null, null,null,40),
( 'Pulp Fiction', null, null, null,null,40),
( 'Pruimebloesem', null, null, null,null,40),
( 'Reservoir Dogs', null, null, null,null,40),
( 'The Good, the Bad and the Ugly', null, null, null,null,40),
( 'Andy Warhol`s Dracula', null, null, null,null,40),
( 'Ober', null, null, null,null,40),
( 'Der Untergang', null, null, null,null,40),
( 'De helaasheid der dingen', null, null, null,null,40),
('A Clockwork Orange', null, null, null,null,40);

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
('Sherlock', '3',		12, 'Engels',			'Detective',	'Fargo'),
( 'Breaking Bad', '2',	16, 'Engels-Amerikaans', 'Spanning',		'Fargo'),
('Fargo', '2',			16, 'Engels-Amerikaans', 'Spanning',		'Breaking Bad');


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
( 'Sherlock', 1 ,'S01A01', 'A Study in Pink', 90),
( 'Sherlock', 1 ,'S01A02', 'The Blind Banker', 90),
( 'Sherlock', 1 ,'S01A03', 'The Great Game', 90),
( 'Sherlock', 1 ,'S02A01', 'A Scandal in Belgravia', 90),
( 'Sherlock', 1 ,'S02A02', 'The Hounds of Baskerville', 90),
( 'Sherlock', 1 ,'S02A03', 'The Reichenbach Fall', 90),
( 'Sherlock', 1 ,'S03A01', 'The Empty Hearse', 90),
( 'Sherlock', 1 ,'S03A02', 'The Sign of Three', 90),
( 'Sherlock', 1 ,'S03A03', 'His Last Vow', 90),
/* Serie: "Breaking Bad" */
( 'Breaking Bad', 2, 'S01A01', 'Pilot', 58),
( 'Breaking Bad', 2, 'S01A02', 'Cat`s in the Bag...', 48),
( 'Breaking Bad', 2, 'S01A03', '...And the Bag`s in the River', 48),
( 'Breaking Bad', 2, 'S01A04', 'Cancer Man', 48),
( 'Breaking Bad', 2, 'S01A05', 'Gray Matter', 48),
( 'Breaking Bad', 2, 'S01A06', 'Crazy Handful of Nothin`', 48),
( 'Breaking Bad', 2, 'S01A07', 'A No-Rough-Stuff-Type Deal', 48),
( 'Breaking Bad', 2, 'S02A01', 'Seven Thirty-Seven', 48),
( 'Breaking Bad', 2, 'S02A02', 'Grilled', 48),
( 'Breaking Bad', 2, 'S02A03', 'Bit by a Dead Bee', 48),
( 'Breaking Bad', 2, 'S02A04', 'Down', 48),
( 'Breaking Bad', 2, 'S02A05', 'Breakage', 48),
( 'Breaking Bad', 2, 'S02A06', 'Peekaboo', 48),
( 'Breaking Bad', 2, 'S02A07', 'Negro Y Azul', 48),
( 'Breaking Bad', 2, 'S02A08', 'Better Call Saul', 48),
( 'Breaking Bad', 2, 'S02A09', '4 Days Out', 48),
( 'Breaking Bad', 2, 'S02A10', 'Over', 48),
( 'Breaking Bad', 2, 'S02A11', 'Mandala', 48),
( 'Breaking Bad', 2, 'S02A12', 'Phoenix', 48),
( 'Breaking Bad', 2, 'S02A13', 'ABQ', 48),
/* Serie: "Fargo" */
( 'Fargo', 3, 'S01A01', 'The Crocodile`s Dilemma', 68),
( 'Fargo', 3, 'S01A02', 'The Rooster Prince', 68),
( 'Fargo', 3, 'S01A03', 'A Muddy Road', 68),
( 'Fargo', 3, 'S01A04', 'Eating the Blame', 68),
( 'Fargo', 3, 'S01A05', 'The Six Ungraspables', 68),
( 'Fargo', 3, 'S01A06', 'Buridan`s Ass', 68),
( 'Fargo', 3, 'S01A07', 'Who Shaves the Barber?', 68),
( 'Fargo', 3, 'S01A08', 'The Heap', 68),
( 'Fargo', 3, 'S01A09', 'A Fox, a Rabbit, and a Cabbage', 68),
( 'Fargo', 3, 'S01A10', 'Morton`s Fork', 68),
( 'Fargo', 3, 'S02A01', 'Waiting for Dutch', 68),
( 'Fargo', 3, 'S02A02', 'Before the Law', 68),
( 'Fargo', 3, 'S02A03', 'The Myth of Sisyphus', 68),
( 'Fargo', 3, 'S02A04', 'The Gift of the Magi', 68),
( 'Fargo', 3, 'S02A05', 'Fear and Trembling', 68),
( 'Fargo', 3, 'S02A06', 'Rhinoceros', 68),
( 'Fargo', 3, 'S02A07', 'Did you do this? No, you did it!', 68),
( 'Fargo', 3, 'S02A08', 'Loplop', 68),
( 'Fargo', 3, 'S02A09', 'The Castle', 68),
( 'Fargo', 3, 'S02A10', 'Palindrome', 68);



/* Films */






INSERT INTO Movie
VALUES
( 'The Abominable Bride',	 12,			'Engels',				90, 'Detective'),
( 'The Life of Brian',		12,			'Engels',				94, 'Humor'),
( 'Pulp Fiction',			 16,			'Engels-Amerikaans',	154, 'Misdaad'),
( 'Pruimebloesem',			 18,			'Nederlands',			80, 'Erotiek'),
( 'Reservoir Dogs',			 16,			'Engels-Amerikaans',	99, 'Misdaad'),
( 'The Good, the Bad and the Ugly', 12,	'Engels-Amerikaans',	151, 'Western'),
( 'Andy Warhol`s Dracula',	 6,			'Engels-Amerikaans',	103, 'Humor'),
( 'Ober',					 6,			'Nederlands',			97, 'Humor'),
( 'Der Untergang',			 8,			'Duits',				178, 'Oorlog'),
( 'De helaasheid der dingen',  12,		'Vlaams',				108, 'Humor'),
( 'A Clockwork Orange',		 16,			'Engels',				136, 'SF');

