CREATE DATABASE  IF NOT EXISTS `society_app` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `society_app`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: society_app
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `sa_address`
--

DROP TABLE IF EXISTS `sa_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sa_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_text` varchar(500) DEFAULT NULL,
  `area_name` varchar(100) DEFAULT NULL,
  `plot_no` int(11) DEFAULT NULL,
  `sector_no` int(11) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sa_address`
--

LOCK TABLES `sa_address` WRITE;
/*!40000 ALTER TABLE `sa_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `sa_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sa_person`
--

DROP TABLE IF EXISTS `sa_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sa_person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `contact_number` varchar(100) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sa_person`
--

LOCK TABLES `sa_person` WRITE;
/*!40000 ALTER TABLE `sa_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `sa_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sa_role`
--

DROP TABLE IF EXISTS `sa_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sa_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sa_role`
--

LOCK TABLES `sa_role` WRITE;
/*!40000 ALTER TABLE `sa_role` DISABLE KEYS */;
INSERT INTO `sa_role` VALUES (1,'Owner'),(2,'Admin');
/*!40000 ALTER TABLE `sa_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sa_society`
--

DROP TABLE IF EXISTS `sa_society`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sa_society` (
  `society_id` int(11) NOT NULL AUTO_INCREMENT,
  `society_name` varchar(500) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`society_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `sa_society_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `sa_address` (`address_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sa_society`
--

LOCK TABLES `sa_society` WRITE;
/*!40000 ALTER TABLE `sa_society` DISABLE KEYS */;
/*!40000 ALTER TABLE `sa_society` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sa_society_member`
--

DROP TABLE IF EXISTS `sa_society_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sa_society_member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `society_id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `society_id` (`society_id`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `sa_society_member_ibfk_1` FOREIGN KEY (`society_id`) REFERENCES `sa_society` (`society_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sa_society_member_ibfk_2` FOREIGN KEY (`person_id`) REFERENCES `sa_person` (`person_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sa_society_member`
--

LOCK TABLES `sa_society_member` WRITE;
/*!40000 ALTER TABLE `sa_society_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `sa_society_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sa_user`
--

DROP TABLE IF EXISTS `sa_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sa_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `society_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKh5d3x39ydrwogdskint5hx2aj` (`role_id`),
  KEY `society_id` (`society_id`),
  CONSTRAINT `FKh5d3x39ydrwogdskint5hx2aj` FOREIGN KEY (`role_id`) REFERENCES `sa_role` (`role_id`),
  CONSTRAINT `sa_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sa_role` (`role_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sa_user_ibfk_2` FOREIGN KEY (`society_id`) REFERENCES `sa_society` (`society_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sa_user`
--

LOCK TABLES `sa_user` WRITE;
/*!40000 ALTER TABLE `sa_user` DISABLE KEYS */;
INSERT INTO `sa_user` VALUES (1,'vikas','123',1,NULL),(2,'crystal','123',2,NULL);
/*!40000 ALTER TABLE `sa_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-10 23:04:24
