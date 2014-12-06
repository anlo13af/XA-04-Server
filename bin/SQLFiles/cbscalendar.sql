# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.20)
# Database: cbscalendar
# Generation Time: 2014-12-06 10:59:47 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Calendar
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS cbscalendar;
use cbscalendar;
SET SESSION FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `Calendar`;

CREATE TABLE `Calendar` (
  `CalendarID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `CreatedBy` varchar(255) NOT NULL,
  `PrivatePublic` tinyint(4) NOT NULL COMMENT '1 = public\n	2 = private',
  PRIMARY KEY (`CalendarID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table dailyupdate
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dailyupdate`;

CREATE TABLE `dailyupdate` (
  `date` datetime NOT NULL,
  `apparentTemperature` double DEFAULT NULL,
  `summary` text,
  `windspeed` double DEFAULT NULL,
  `qotd` varchar(500) NOT NULL DEFAULT '',
  `msg_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`date`),
  UNIQUE KEY `date` (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `dailyupdate` WRITE;
/*!40000 ALTER TABLE `dailyupdate` DISABLE KEYS */;

INSERT INTO `dailyupdate` (`date`, `apparentTemperature`, `summary`, `windspeed`, `qotd`, `msg_type`)
VALUES
	('2014-12-06 09:00:00',5.65,'broken clouds',5.67,'You cannot expect to achieve new goals or move beyond your present circumstances unless you change.',NULL),
	('2014-12-06 12:00:00',5.89,'sky is clear',6.9,'Heroes to me are guys that sit in libraries. They absorb knowledge and then the risks they take are calculated on the basis of the courage it took to become replete with knowledge.',NULL),
	('2014-12-06 15:00:00',4.9,'sky is clear',5.81,'I have a weird sense of humour. My dad\'s the same. We love watching \'Monty Python\' together.',NULL),
	('2014-12-06 18:00:00',4.22,'sky is clear',5.61,'The real harm of term extension comes not from these famous works. The real harm is to the works that are not famous, not commercially exploited, and no longer available as a result.',NULL),
	('2014-12-06 21:00:00',3.88,'sky is clear',5.66,'The idea of being able to serve as an example, based upon how to process, how to think, how to realize our own dreams, we can pass that down to our children.',NULL),
	('2014-12-07 00:00:00',3.74,'sky is clear',6.31,'One of the things I learned the hard way was that it doesn\'t pay to get discouraged. Keeping busy and making optimism a way of life can restore your faith in yourself.',NULL),
	('2014-12-07 03:00:00',4.54,'few clouds',8.43,'I\'m not going to put out a Christmas CD until it\'s coming out of me naturally.',NULL),
	('2014-12-07 06:00:00',5.09,'scattered clouds',9.76,'My other family is Fleetwood Mac. I don\'t need the money, but there\'s an emotional need for me to go on the road again. There\'s a love there we\'re a band of brothers.',NULL),
	('2014-12-07 09:00:00',5.12,'light rain',11.81,'Expect the best, Prepare for the worst.',NULL),
	('2014-12-07 12:00:00',5.04,'light rain',13.6,'The right way to reign in healthcare costs is not by applying more government and more controls and making it more like the post office, it\'s by making it more like a consumer-driven market.',NULL),
	('2014-12-07 15:00:00',6.01,'light rain',12.16,'Age is strictly a case of mind over matter. If you don\'t mind, it doesn\'t matter.',NULL),
	('2014-12-07 18:00:00',7.25,'overcast clouds',7.82,'Success is not built on success. It\'s built on failure. It\'s built on frustration. Sometimes its built on catastrophe.',NULL),
	('2014-12-07 21:00:00',7.13,'overcast clouds',7.19,'Science never gives up searching for truth, since it never claims to have achieved it.',NULL),
	('2014-12-08 00:00:00',6.52,'overcast clouds',8.37,'I\'ve been to all 50 states, and traveled this whole country, and 90 percent of the people are good folks. The rest of them take after the other side of the family.',NULL),
	('2014-12-08 03:00:00',6.24,'light rain',8,'Singing is a way of releasing an emotion that you sometimes can\'t portray when you\'re acting. And music moves your soul, so music is the source of the most intense emotions you can feel. When you hear a song and you\'re acting it\'s incredible. But when you\'re singing a song and you\'re acting it\'s even more incredible.',NULL),
	('2014-12-08 06:00:00',5.99,'sky is clear',7.28,'I\'m well past the age where I\'m acceptable. You get to a certain age and you are forbidden access. You\'re not going to get the kind of coverage that you would like in music magazines, you\'re not going to get played on radio and you\'re not going to get played on television. I have to survive on word of mouth.',NULL),
	('2014-12-08 09:00:00',5.66,'broken clouds',7.91,'I feel like I have as good a shot as anybody out there and I have gotten close in the past, so why not have the attitude that I can come out and play great tennis and maybe even win this tournament.',NULL),
	('2014-12-08 12:00:00',6.62,'sky is clear',8.87,'Now this relaxation of the mind from work consists on playful words or deeds. Therefore it becomes a wise and virtuous man to have recourse to such things at times.',NULL),
	('2014-12-08 15:00:00',6.18,'overcast clouds',8.17,'You can\'t separate peace from freedom because no one can be at peace unless he has his freedom.',NULL),
	('2014-12-08 18:00:00',6.14,'broken clouds',7.32,'There\'s some things you just have to live with. Like twelve cars camping outside your house, and when you wake up in the morning, they\'re going to follow you wherever you go. It helps that I live in Valencia. It eliminates some. But they\'re still here.',NULL),
	('2014-12-08 21:00:00',5.99,'scattered clouds',6.56,'I do not believe that civilization will be wiped out in a war fought with the atomic bomb. Perhaps two-thirds of the people of the earth will be killed.',NULL),
	('2014-12-09 00:00:00',5.75,'broken clouds',5.62,'America\'s biggest export is media and I think that\'s a positive thing.',NULL),
	('2014-12-09 03:00:00',5.71,'scattered clouds',4.47,'When a noble life has prepared old age, it is not decline that it reveals, but the first days of immortality.',NULL),
	('2014-12-09 06:00:00',4.78,'few clouds',4.08,'Anyone who can walk to the welfare office can walk to work.',NULL),
	('2014-12-09 09:00:00',4.54,'sky is clear',2.26,'Future shock is the shattering stress and disorientation that we induce in individuals by subjecting them to too much change in too short a time.',NULL),
	('2014-12-09 12:00:00',6.16,'sky is clear',2.02,'Neither left nor right has focused adequately on maternal health.',NULL),
	('2014-12-09 15:00:00',5.2,'sky is clear',1.97,'I think it\'s important to have closure in any relationship that ends - from a romantic relationship to a friendship. You should always have a sense of clarity at the end and know why it began and why it ended. You need that in your life to move cleanly into your next phase.',NULL),
	('2014-12-09 18:00:00',4.47,'sky is clear',4.47,'But I know newspapers. They have the first amendment and they can tell any lie knowing it\'s a lie and they\'re protected if the person\'s famous or it\'s a company.',NULL),
	('2014-12-09 21:00:00',4.92,'sky is clear',6.31,'If it\'s natural to kill, how come men have to go into training to learn how?',NULL),
	('2014-12-10 00:00:00',6.01,'scattered clouds',7.97,'Poetry is truth in its Sunday clothes.',NULL),
	('2014-12-10 03:00:00',6.53,'broken clouds',9.4,'Some men are alive simply because it is against the law to kill them.',NULL),
	('2014-12-10 06:00:00',5.68,'overcast clouds',13.91,'The teacher is the one who gets the most out of the lessons, and the true teacher is the learner.',NULL),
	('2014-12-10 09:00:00',5.41,'overcast clouds',17.02,'Psychology keeps trying to vindicate human nature. History keeps undermining the effort.',NULL),
	('2014-12-10 15:00:00',7.81,'heavy intensity rain',8.17,'I was reading a book... \'the history of glue\' - I couldn\'t put it down.',NULL),
	('2014-12-10 18:00:00',7.04,'sky is clear',9.06,'I just hope that theaters remain. I think there\'s something very wonderful about getting into a dark room with a bunch of people. There\'s something cool about that. Brings us all together in one room where we can experience all those emotions.',NULL),
	('2014-12-10 21:00:00',6.7,'few clouds',9.86,'I enjoy privacy. I think it\'s nice to have a little mystery. I think because of technology a lot of the mystery is gone in life, and I\'d like to preserve some of that.',NULL),
	('2014-12-11 00:00:00',6.91,'broken clouds',12.45,'Research has shown time and time again that infants who receive the high-quality child care and early education programs do better in school, have more developed social skills, and display fewer behavior problems.',NULL);

/*!40000 ALTER TABLE `dailyupdate` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table events
# ------------------------------------------------------------

DROP TABLE IF EXISTS `events`;

CREATE TABLE `events` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `text` text NOT NULL,
  `customevent` tinyint(1) DEFAULT NULL COMMENT 'Decides wether the event is an import-event or user created\n',
  PRIMARY KEY (`eventid`),
  KEY `createdby` (`createdby`),
  CONSTRAINT `events_ibfk_3` FOREIGN KEY (`createdby`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;

INSERT INTO `events` (`eventid`, `type`, `location`, `createdby`, `start`, `end`, `name`, `text`, `customevent`)
VALUES
	(15,NULL,'marts',8,'2015-02-05 09:00:00','2015-02-05 11:00:00','marts test','marts',NULL),
	(16,NULL,'hej',8,'2014-12-15 10:00:00','2014-12-15 12:00:00','december test','hej',NULL),
	(17,NULL,'hej',8,'2015-01-10 10:00:00','2015-01-10 12:00:00','hej','januar test',NULL),
	(18,NULL,'oinawd',8,'2015-01-03 10:00:00','2015-01-03 11:00:00','fesoin','awdion',NULL),
	(19,NULL,'hej',8,'2014-12-31 10:00:00','2014-12-31 12:00:00','hej','sjov test',NULL),
	(20,NULL,'hej',8,'2015-01-01 10:00:00','2015-01-01 12:00:00','hej','fededyr',NULL),
	(21,NULL,'loc',8,'2014-12-30 10:00:00','2014-12-30 12:00:00','desc','name',NULL);

/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table locationdata
# ------------------------------------------------------------

DROP TABLE IF EXISTS `locationdata`;

CREATE TABLE `locationdata` (
  `locationdataid` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` int(11) NOT NULL,
  `latitude` int(11) DEFAULT NULL,
  PRIMARY KEY (`locationdataid`),
  UNIQUE KEY `latitude` (`latitude`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table notes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `notes`;

CREATE TABLE `notes` (
  `noteid` int(11) NOT NULL AUTO_INCREMENT,
  `eventid` int(11) NOT NULL,
  `createdby` int(11) NOT NULL,
  `text` text,
  `created` datetime NOT NULL,
  PRIMARY KEY (`noteid`),
  KEY `eventid` (`eventid`),
  KEY `createdby` (`createdby`),
  CONSTRAINT `notes_ibfk_1` FOREIGN KEY (`eventid`) REFERENCES `events` (`eventid`) ON UPDATE NO ACTION,
  CONSTRAINT `notes_ibfk_2` FOREIGN KEY (`createdBy`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `type` varchar(200) NOT NULL,
  PRIMARY KEY (`roleid`),
  KEY `userid` (`userid`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;

INSERT INTO `roles` (`roleid`, `userid`, `type`)
VALUES
	(1,1,'admin');

/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table userevents
# ------------------------------------------------------------

DROP TABLE IF EXISTS `userevents`;

CREATE TABLE `userevents` (
  `userid` int(11) NOT NULL,
  `CalendarID` int(11) NOT NULL,
  KEY `CalendarID` (`CalendarID`),
  KEY `userid` (`userid`),
  CONSTRAINT `userevents_ibfk_1` FOREIGN KEY (`CalendarID`) REFERENCES `Calendar` (`CalendarID`) ON UPDATE NO ACTION,
  CONSTRAINT `userevents_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`userid`, `email`, `active`, `created`, `password`)
VALUES
	(1,'hej',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(3,'anders',1,NULL,'lol'),
	(4,'andreas',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(5,'andras',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(6,'andras',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(7,'alex',1,NULL,'PZCUWJD90FuGFTDqR4nX5Q=='),
	(8,'anli12ae',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(20,'alex1',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(21,'alla13ad',1,NULL,'d6YSr320JnLXlp8YYxUcNQ=='),
	(22,'TEST <3',1,NULL,'fht1zPj44zP8t0zBS5d6KQ=='),
	(23,'alanlol',1,NULL,'OCXzVkNaypt43d0PX/N92Q=='),
	(24,'huehue',1,NULL,'dS6FeJs1ePS8gFxvPEbqAg==');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
