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

INSERT INTO `events` (`eventid`, `type`, `location`, `createdby`, `start`, `end`, `name`, `text`, `customevent`)
VALUES
	(1,NULL,'Location',1,'2014-12-24 10:00:00','2014-12-24 14:00:00','Test event','Test',NULL),
	(2,NULL,'Location',1,'2014-12-26 09:00:00','2014-12-26 12:00:00','Test event','Test',NULL),
	(3,NULL,'Location',1,'2015-01-01 09:00:00','2015-01-01 15:00:00','Test event','Test',NULL),
	(8,NULL,'Location',2,'2014-12-23 10:00:00','2014-12-23 12:00:00','Test event','Test',NULL),
	(9,NULL,'Location',2,'2014-12-28 09:00:00','2014-12-28 13:00:00','Test event','Test',NULL),
	(10,NULL,'Location',2,'2015-01-03 17:00:00','2015-01-03 21:00:00','Test event','Test',NULL),
	(11,NULL,'Location',3,'2014-12-29 12:00:00','2014-12-29 14:00:00','Test event','Test',NULL),
	(12,NULL,'Location',3,'2014-12-21 16:00:00','2014-12-21 19:00:00','Test event','Test',NULL),
	(13,NULL,'Location',3,'2015-01-04 09:00:00','2015-01-04 11:00:00','Test event','Test',NULL),
	(14,NULL,'Location',4,'2014-12-25 09:00:00','2014-12-25 14:00:00','Test event','Test',NULL),
	(15,NULL,'Location',4,'2014-01-01 10:00:00','2014-01-01 12:00:00','Test event','Test',NULL),
	(16,NULL,'Location',4,'2015-01-05 09:00:00','2015-01-05 14:00:00','Test event','Test',NULL);

UNLOCK TABLES;

DROP TABLE IF EXISTS `locationdata`;

CREATE TABLE `locationdata` (
  `locationdataid` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` int(11) NOT NULL,
  `latitude` int(11) DEFAULT NULL,
  PRIMARY KEY (`locationdataid`),
  UNIQUE KEY `latitude` (`latitude`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  CONSTRAINT `notes_ibfk_2` FOREIGN KEY (`createdby`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `type` varchar(200) NOT NULL,
  PRIMARY KEY (`roleid`),
  KEY `userid` (`userid`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `userevents`;

CREATE TABLE `userevents` (
  `userid` int(11) NOT NULL,
  `CalendarID` int(11) NOT NULL,
  KEY `CalendarID` (`CalendarID`),
  KEY `userid` (`userid`),
  CONSTRAINT `userevents_ibfk_1` FOREIGN KEY (`CalendarID`) REFERENCES `Calendar` (`CalendarID`) ON UPDATE NO ACTION,
  CONSTRAINT `userevents_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

INSERT INTO `users` (`userid`, `email`, `active`, `created`, `password`)
VALUES
	(1,'anli12ae',1,NULL,'6Cd4lu/dvicuH+4GvpEfzQ=='),
	(2,'alla13ad',1,NULL,'6Cd4lu/dvicuH+4GvpEfzQ=='),
	(3,'stma12af',1,NULL,'6Cd4lu/dvicuH+4GvpEfzQ=='),
	(4,'anlo13af',1,NULL,'6Cd4lu/dvicuH+4GvpEfzQ==');

UNLOCK TABLES;
