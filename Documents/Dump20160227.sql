CREATE DATABASE  IF NOT EXISTS `mmt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mmt`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mmt
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `ADDRESS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` varchar(6) NOT NULL,
  `ADDRESS_TYPE_ID` smallint(5) unsigned NOT NULL,
  `ADDRESS_LINE_1` varchar(32) NOT NULL,
  `ADDRESS_LINE_2` varchar(32) DEFAULT NULL,
  `COUNTRY` varchar(16) NOT NULL,
  `POSTAL_CODE` varchar(8) DEFAULT NULL,
  `IS_MAILING_ADDRESS` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`ADDRESS_ID`),
  UNIQUE KEY `ADDRESS_ID_UNIQUE` (`ADDRESS_ID`),
  KEY `ADDR_MEMBER_REF_idx` (`MEMBER_ID`),
  KEY `ADDR_TYPE_REF_idx` (`ADDRESS_TYPE_ID`),
  CONSTRAINT `ADDR_MEMBER_REF` FOREIGN KEY (`MEMBER_ID`) REFERENCES `member` (`MEMBER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ADDR_TYPE_REF` FOREIGN KEY (`ADDRESS_TYPE_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='This table contains the address of the member. A member can have at max 2 address "Residential" and "Foreign". For a member, any one of the address is considered as "Mailing" address';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (4,'A1',200,'addressLine1','addressLine2','country','postal',1),(5,'A1',200,'addressLine1','addressLine2','country','postal',1),(6,'A1',200,'addressLine1','addressLine2','country','postal',0),(7,'A1',200,'addressLine1','addressLine2','country','postal',0),(8,'A1',201,'addressLine1_UP','addressLine2_UP','country_UP','post_UP',1),(9,'A1',201,'addressLine1_**','addressLine2_**','country_**','post_UP',0),(10,'A1',200,'addressLine1','addressLine2','country','postal',0),(11,'A1',200,'addressLine1','addressLine2','country','postal',0),(12,'A1',200,'addressLine1','addressLine2','country','postal',0),(13,'A1',200,'addressLine1','addressLine2','country','postal',0),(14,'A1',200,'addressLine1','addressLine2','country','postal',0),(15,'A1',200,'addressLine1','addressLine2','country','postal',0),(16,'A1',200,'addressLine1','addressLine2','country','postal',0),(17,'A1',200,'addressLine1','addressLine2','country','postal',0),(18,'A1',200,'addressLine1','addressLine2','country','postal',0),(19,'A1',200,'addressLine1','addressLine2','country','postal',0),(20,'A1',200,'addressLine1','addressLine2','country','postal',0),(21,'A1',200,'addressLine1','addressLine2','country','postal',0);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `global_constant`
--

DROP TABLE IF EXISTS `global_constant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `global_constant` (
  `CONSTANT_ID` smallint(5) unsigned NOT NULL,
  `CONSTANT_TYPE` varchar(24) NOT NULL,
  `CONSTANT_NAME` varchar(24) NOT NULL,
  PRIMARY KEY (`CONSTANT_ID`),
  UNIQUE KEY `CONSTANT_ID_UNIQUE` (`CONSTANT_ID`),
  UNIQUE KEY `CONST_TYPE_NAME_UNIQ` (`CONSTANT_TYPE`,`CONSTANT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table contains the constant values of "Nationality", "Dialect Group", "Religion", "Reason for Leaving" etc.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `global_constant`
--

LOCK TABLES `global_constant` WRITE;
/*!40000 ALTER TABLE `global_constant` DISABLE KEYS */;
INSERT INTO `global_constant` VALUES (201,'ADDRESS_TYPE','Foreign'),(200,'ADDRESS_TYPE','Residential'),(303,'DIALECT','English'),(301,'DIALECT','Malay'),(300,'DIALECT','Mandarin'),(304,'DIALECT','Others'),(302,'DIALECT','Tamil'),(605,'IDENTITY_TYPE','EP'),(606,'IDENTITY_TYPE','Others'),(601,'IDENTITY_TYPE','PR'),(600,'IDENTITY_TYPE','SC'),(604,'IDENTITY_TYPE','SP'),(602,'IDENTITY_TYPE','SVP'),(603,'IDENTITY_TYPE','WP'),(500,'LEAVING_REASON','Expired'),(501,'LEAVING_REASON','Fees_Unpaid'),(503,'LEAVING_REASON','Others'),(502,'LEAVING_REASON','Withdrawn'),(701,'MEMBER_TYPE','Buddhist Monk'),(703,'MEMBER_TYPE','Individual'),(702,'MEMBER_TYPE','Lifetime / Permanent'),(700,'MEMBER_TYPE','Organization'),(101,'NATIONALITY','Chinese'),(103,'NATIONALITY','Indian'),(102,'NATIONALITY','Malaysian'),(104,'NATIONALITY','Others'),(100,'NATIONALITY','Singaporean'),(400,'RELIGION','Buddhism'),(402,'RELIGION','Catholicism'),(401,'RELIGION','Christianity'),(404,'RELIGION','Hinduism'),(405,'RELIGION','Islam'),(407,'RELIGION','No Religion'),(408,'RELIGION','Others'),(403,'RELIGION','Protestantism'),(406,'RELIGION','Taoism');
/*!40000 ALTER TABLE `global_constant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `MEMBER_ID` varchar(6) NOT NULL,
  `MEMBER_TYPE_ID` smallint(6) unsigned NOT NULL,
  `TITLE` varchar(8) DEFAULT NULL,
  `NAME_ENGLIGH` varchar(32) DEFAULT NULL,
  `NAME_CHINESE` varchar(32) DEFAULT NULL,
  `GENDER` varchar(4) DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `IDENTITY_TYPE_ID` smallint(6) unsigned DEFAULT NULL,
  `IDENTITY_NUMBER` varchar(24) DEFAULT NULL,
  `COLOR` varchar(8) DEFAULT NULL,
  `NATIONALITY_ID` smallint(6) unsigned DEFAULT NULL,
  `DIALECT_GROUP_ID` smallint(6) unsigned DEFAULT NULL,
  `RELIGION_ID` smallint(6) unsigned DEFAULT NULL,
  `HOME_PHONE` varchar(16) DEFAULT NULL,
  `OFFICE_PHONE` varchar(16) DEFAULT NULL,
  `MOBILE` varchar(16) DEFAULT NULL,
  `FAX_NUMBER` varchar(16) DEFAULT NULL,
  `EMAIL` varchar(48) DEFAULT NULL,
  `DATE_JOIN` date DEFAULT NULL,
  `INTRODUCER_ID` varchar(6) DEFAULT NULL,
  `DATE_LEFT` date DEFAULT NULL,
  `LEAVING_REASON_ID` smallint(6) unsigned DEFAULT NULL,
  `OCCUPATION` varchar(32) DEFAULT NULL,
  `CONTACT_TITLE` varchar(8) DEFAULT NULL,
  `CONTACT_PERSON_NAME` varchar(32) DEFAULT NULL,
  `HIGHEST_EDUCATION` varchar(32) DEFAULT NULL,
  `BOARD_MEMBER` tinyint(1) unsigned DEFAULT '0',
  `OTHER_CHARITIES` varchar(64) DEFAULT NULL,
  `SERVED_YEAR_TO_YEAR` varchar(16) DEFAULT NULL,
  `ATTENDED_AGM` tinyint(1) unsigned DEFAULT '0',
  `YEARS_ATTENDED_AGM` varchar(48) DEFAULT NULL,
  `OTHER_CONTRIBUTION` varchar(64) DEFAULT NULL,
  `CREATED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MEMBER_ID`),
  UNIQUE KEY `MEMBER_ID_UNIQUE` (`MEMBER_ID`),
  KEY `MEMBER_TYPE_idx` (`MEMBER_TYPE_ID`),
  KEY `IDENTITY_TYPE_idx` (`IDENTITY_TYPE_ID`),
  KEY `NATIONALITY_REF_idx` (`NATIONALITY_ID`),
  KEY `DIALECT_REF_idx` (`DIALECT_GROUP_ID`),
  KEY `RELIGION_REF_idx` (`RELIGION_ID`),
  KEY `REASON_REF_idx` (`LEAVING_REASON_ID`),
  KEY `INTRO_REF_idx` (`INTRODUCER_ID`),
  CONSTRAINT `DIALECT_REF` FOREIGN KEY (`DIALECT_GROUP_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IDENTITY_TYPE_REF` FOREIGN KEY (`IDENTITY_TYPE_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `INTRO_REF` FOREIGN KEY (`INTRODUCER_ID`) REFERENCES `member` (`MEMBER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MEMBER_TYPE_REF` FOREIGN KEY (`MEMBER_TYPE_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `NATIONALITY_REF` FOREIGN KEY (`NATIONALITY_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `REASON_REF` FOREIGN KEY (`LEAVING_REASON_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RELIGION_REF` FOREIGN KEY (`RELIGION_ID`) REFERENCES `global_constant` (`CONSTANT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table contains the main details of the member';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('A1',703,'title','nameEngligh','MaheName in Chinese','M','1952-10-25',605,'identityNumber','color',103,302,404,'homePhone','officePhone','mobile123','faxNumber','abcd.1234@gmail.com','1992-08-05','A1','2002-04-19',503,'occupation','C_Title','contactPersonName','highestEducation',1,'otherCharities','servedYearToYear',1,'yearsAttendedAgm','otherContribution','2016-02-23 23:56:45','2016-02-26 01:35:59'),('abcd',703,'title','nameEngligh','nameChinese','M','1952-10-25',605,'identityNumber','color',103,302,404,'homePhone','officePhone','mobile123','faxNumber','abcd.1234@gmail.com','1992-08-05','A1','2002-04-19',503,'occupation','C_Title','contactPersonName','highestEducation',1,'otherCharities','servedYearToYear',0,'yearsAttendedAgm','otherContribution','2016-02-26 01:11:07','2016-02-26 01:11:07'),('CHECK',702,'mr','mahendran','chinese','M','2009-10-12',604,'Gytu3890','brown',102,301,403,'59020+0','1234Uol','8012KK','fa3m9-','afdsf@gmail.com','2010-01-23','abcd',NULL,NULL,'c;f;dsfsd','c_rsadf','adsfads','d;afasdadsf',NULL,'fasdfads','asdfasd',NULL,'dfsdafafsda','afdsfds','2016-02-27 01:23:12','2016-02-27 01:23:12');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `PAYMENT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` varchar(6) NOT NULL,
  `DUE_DATE` date DEFAULT NULL,
  `DUE_AMOUNT` float(8,2) DEFAULT '0.00',
  `PAID_DATE` date DEFAULT NULL,
  `PAID_AMOUNT` float(8,2) DEFAULT '0.00',
  `PAYMENT_MODE` varchar(8) DEFAULT NULL,
  `CHEQUE_NUMBER` varchar(16) DEFAULT NULL,
  `RECEIPT_NUMBER` varchar(16) DEFAULT NULL,
  `ACCOUNTING_REF_VOUCHER` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`PAYMENT_ID`),
  UNIQUE KEY `PAYMENT_ID_UNIQUE` (`PAYMENT_ID`),
  KEY `MEMBER_PAYMENT_REF_idx` (`MEMBER_ID`),
  CONSTRAINT `PAYMENT_MEMBER_REF` FOREIGN KEY (`MEMBER_ID`) REFERENCES `member` (`MEMBER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='This table contains the payment history of the members.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'A1','2222-10-25',111.99,'2333-11-22',55.76,'***Mode','***queNumber','***receiptNo','***untingRefVoucher'),(2,'A1','3222-10-25',353.99,'4333-11-22',656.76,'##Mode','##queNumber','##receiptNo','##untingRefVoucher'),(3,'A1','8888-10-25',910104.00,'8899-11-22',6060.76,'@@Mode','@@queNumber','@@receiptNo','@@untingRefVoucher'),(4,'A1','2016-10-25',9999.99,'2016-11-22',8888.76,'paymntMd','chequeNumber','receiptNumber','accountingRefVoucher'),(5,'A1','2016-10-25',9999.99,'2016-11-22',8888.76,'paymntMd','chequeNumber','receiptNumber','accountingRefVoucher'),(6,'A1','2016-10-25',9999.99,'2016-11-22',8888.76,'paymntMd','chequeNumber','receiptNumber','accountingRefVoucher'),(7,'A1','2016-10-25',9999.99,'2016-11-22',8888.76,'paymntMd','chequeNumber','receiptNumber','accountingRefVoucher'),(8,'A1','2016-10-25',9999.99,'2016-11-22',8888.76,'paymntMd','chequeNumber','receiptNumber','accountingRefVoucher'),(9,'A1','2016-10-25',9999.99,'2016-11-22',8888.76,'paymntMd','chequeNumber','receiptNumber','accountingRefVoucher');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-27  2:50:00
