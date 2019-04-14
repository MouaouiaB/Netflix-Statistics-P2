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




INSERT INTO Series
VALUES
('Sherlock', '3',		12, 'Engels',			'Detective',	'Fargo'),
( 'Breaking Bad', '2',	16, 'Engels-Amerikaans', 'Spanning',		'Fargo'),
('Fargo', '2',			16, 'Engels-Amerikaans', 'Spanning',		'Breaking Bad');



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
/* Serie: "Fargo" */
( 'Fargo', 3, 'S01A01', 'The Crocodile`s Dilemma', 68),
( 'Fargo', 3, 'S01A02', 'The Rooster Prince', 68),
( 'Fargo', 3, 'S01A03', 'A Muddy Road', 68),
( 'Fargo', 3, 'S01A04', 'Eating the Blame', 68),
( 'Fargo', 3, 'S01A05', 'The Six Ungraspables', 68);




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
( 'Der Untergang',			 16,			'Duits',				178, 'Oorlog'),
( 'De helaasheid der dingen',  12,		'Vlaams',				108, 'Humor'),
( 'A Clockwork Orange',		 16,			'Engels',				136, 'SF');

/* ******** Programma's ******** */
/*ProgramID int IDENTITY (1,1) PRIMARY KEY,
Title nvarchar(50) NOT NULL,
MovieID int,
SerieID int,
EpisodeID int,
ProfileID int,
Precentage int*/
INSERT INTO Program
VALUES
/* Dit zijn alle Serie*/
/* Serie: "Sherlock" */
('A Study in Pink', null, 1, 1,1,40),
( 'The Blind Banker', null, 1, 2,1,80),
( 'The Great Game', null, 1, 3,1,50),
( 'A Scandal in Belgravia', null, 1, 4,1,40),
( 'The Hounds of Baskerville', null, 1, 5,1,40),
('The Reichenbach Fall', null, 1, 6,2,40),
( 'The Empty Hearse', null, 1, 7,2,40),
( 'The Sign of Three', null, 1, 8,2,60),
( 'His Last Vow', null, 1, 9,2,75),
/* Serie: "Breaking bad" */
( 'Pilot', null, 2, 10,1,40),
('Cat''s in the Bag...', null, 2, 11,1,40),
('...And the Bag''s in the River', null, 2, 12,1,40),
( 'Cancer Man', null, 2, 13,1,70),
( 'Gray Matter', null, 2, 14,1,50),
( 'Crazy Handful of Nothin''', null, 2, 15,2,100),
( 'A No-Rough-Stuff-Type Deal', null, 2, 16,2,60),
( 'Seven Thirty-Seven', null, 2, 17,2,75),
/* Serie: "Fargo" */
( 'The Crocodile`s Dilemma', null, 3, 18,1,100),
( 'The Rooster Prince', null, 3, 19,1,60),
( 'A Muddy Road', null, 3, 19,1,40),
('Eating the Blame', null, 3, 20,2,100),
( 'The Six Ungraspables', null, 3, 21,2,70),
/* Dit zijn alle Films */
( 'The Abominable Bride', 1, null, null,1,100),
( 'The Life of Brian', 2, null, null,1,40),
( 'Pulp Fiction', 3, null, null,1,100),
( 'Pruimebloesem', 4, null, null,1,75),
( 'Reservoir Dogs', 5, null, null,1,100),
( 'The Good, the Bad and the Ugly', 6, null, null,1,100),
( 'Andy Warhol`s Dracula', 7, null, null,2,100),
( 'Ober', 8, null, null,2,100),
( 'Der Untergang', 9, null, null,2,40),
( 'De helaasheid der dingen', 10, null, null,2,50),
('A Clockwork Orange', 11, null, null,2,75);

