-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: dbms_mini_project
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academicachievements`
--

DROP TABLE IF EXISTS `academicachievements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academicachievements` (
  `USN` varchar(10) NOT NULL,
  `SNoProj` int DEFAULT '0',
  `SInternShip` int DEFAULT '0',
  `SBACKLOGS` int DEFAULT '0',
  PRIMARY KEY (`USN`),
  CONSTRAINT `academicachievements_ibfk_1` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academicachievements`
--

LOCK TABLES `academicachievements` WRITE;
/*!40000 ALTER TABLE `academicachievements` DISABLE KEYS */;
INSERT INTO `academicachievements` VALUES ('4SF19CS178',0,0,15),('4SF20CS004',5,4,7),('4SF20CS005',0,0,5),('4SF20CS007',0,0,15),('4SF20CS010',0,0,15),('4SF20CS030',2,1,5),('4SF20CS034',0,0,2),('4SF20CS056',0,0,0),('4SF20CS068',0,0,0),('4SF20CS093',0,0,15),('4SF20CS134',0,0,0),('4SF20CS146',0,0,0),('4SF20CS158',0,0,0),('4SF20CS189',0,0,0),('4SF20CS190',0,0,0),('4SF20CS200',0,0,0),('4SF20CS424',0,0,0);
/*!40000 ALTER TABLE `academicachievements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `academiceligibility`
--

DROP TABLE IF EXISTS `academiceligibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academiceligibility` (
  `USN` varchar(10) NOT NULL,
  `SUBCODE` varchar(10) NOT NULL,
  `status` varchar(4) DEFAULT NULL,
  `eligibility` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`USN`,`SUBCODE`),
  KEY `SUBCODE` (`SUBCODE`),
  CONSTRAINT `academiceligibility_ibfk_3` FOREIGN KEY (`SUBCODE`) REFERENCES `subjects` (`subcode`) ON DELETE CASCADE,
  CONSTRAINT `academiceligibility_ibfk_4` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academiceligibility`
--

LOCK TABLES `academiceligibility` WRITE;
/*!40000 ALTER TABLE `academiceligibility` DISABLE KEYS */;
INSERT INTO `academiceligibility` VALUES ('4SF19CS178','18CIV59','FAIL','Not Eligible'),('4SF19CS178','18CPC49','FAIL','Not Eligible'),('4SF19CS178','18CS33','FAIL','Not Eligible'),('4SF19CS178','18CS42','FAIL','Not Eligible'),('4SF19CS178','18CS43','FAIL','Not Eligible'),('4SF19CS178','18CS44','FAIL','Not Eligible'),('4SF19CS178','18CS45','FAIL','Not Eligible'),('4SF19CS178','18CS46','FAIL','Not Eligible'),('4SF19CS178','18CS51','FAIL','Not Eligible'),('4SF19CS178','18CS52','FAIL','Not Eligible'),('4SF19CS178','18CS53','FAIL','Not Eligible'),('4SF19CS178','18CS54','FAIL','Not Eligible'),('4SF19CS178','18CS55','FAIL','Not Eligible'),('4SF19CS178','18CS56','FAIL','Not Eligible'),('4SF19CS178','18CS61','FAIL','Not Eligible'),('4SF19CS178','18CS71','FAIL','Eligible'),('4SF19CS178','18CS81','FAIL','Not Eligible'),('4SF19CS178','18CSL47','FAIL','Not Eligible'),('4SF19CS178','18CSL48','FAIL','Not Eligible'),('4SF19CS178','18CSL57','FAIL','Not Eligible'),('4SF19CS178','18CSL58','FAIL','Not Eligible'),('4SF19CS178','18MAT41','FAIL','Not Eligible'),('4SF20CS004','18CIV59','FAIL','Not Eligible'),('4SF20CS004','18CPC49','FAIL','Not Eligible'),('4SF20CS004','18CS33','FAIL','Not Eligible'),('4SF20CS004','18CS42','FAIL','Not Eligible'),('4SF20CS004','18CS43','FAIL','Not Eligible'),('4SF20CS004','18CS44','FAIL','Not Eligible'),('4SF20CS004','18CS45','FAIL','Not Eligible'),('4SF20CS004','18CS46','FAIL','Not Eligible'),('4SF20CS004','18CS51','PASS','Eligible'),('4SF20CS004','18CS52','PASS','Eligible'),('4SF20CS004','18CS53','FAIL','Eligible'),('4SF20CS004','18CS54','PASS','Not Eligible'),('4SF20CS004','18CS55','PASS','Not Eligible'),('4SF20CS004','18CS56','FAIL','Eligible'),('4SF20CS004','18CSL47','FAIL','Not Eligible'),('4SF20CS004','18CSL48','FAIL','Not Eligible'),('4SF20CS004','18CSL57','FAIL','Not Eligible'),('4SF20CS004','18CSL58','PASS','Not Eligible'),('4SF20CS004','18MAT41','FAIL','Not Eligible'),('4SF20CS005','18CPC49','FAIL','Not Eligible'),('4SF20CS005','18CS33','FAIL','Not Eligible'),('4SF20CS005','18CS42','FAIL','Not Eligible'),('4SF20CS005','18CS43','FAIL','Not Eligible'),('4SF20CS005','18CS44','FAIL','Not Eligible'),('4SF20CS005','18CS45','FAIL','Not Eligible'),('4SF20CS005','18CS46','FAIL','Not Eligible'),('4SF20CS005','18CS51','FAIL','Eligible'),('4SF20CS005','18CS52','FAIL','Eligible'),('4SF20CS005','18CS53','FAIL','Eligible'),('4SF20CS005','18CSL47','FAIL','Not Eligible'),('4SF20CS005','18CSL48','FAIL','Not Eligible'),('4SF20CS005','18MAT41','FAIL','Not Eligible'),('4SF20CS007','18CIV59','FAIL','Not Eligible'),('4SF20CS007','18CPC49','FAIL','Not Eligible'),('4SF20CS007','18CS33','FAIL','Not Eligible'),('4SF20CS007','18CS42','FAIL','Not Eligible'),('4SF20CS007','18CS43','FAIL','Not Eligible'),('4SF20CS007','18CS44','FAIL','Not Eligible'),('4SF20CS007','18CS45','FAIL','Not Eligible'),('4SF20CS007','18CS46','FAIL','Not Eligible'),('4SF20CS007','18CS51','PASS','Not Eligible'),('4SF20CS007','18CS52','PASS','Not Eligible'),('4SF20CS007','18CS53','PASS','Not Eligible'),('4SF20CS007','18CS54','PASS','Not Eligible'),('4SF20CS007','18CS55','PASS','Not Eligible'),('4SF20CS007','18CS56','FAIL','Not Eligible'),('4SF20CS007','18CS61','FAIL','Not Eligible'),('4SF20CS007','18CS71','FAIL','Not Eligible'),('4SF20CS007','18CS81','FAIL','Not Eligible'),('4SF20CS007','18CSL47','FAIL','Not Eligible'),('4SF20CS007','18CSL48','FAIL','Not Eligible'),('4SF20CS007','18CSL57','PASS','Not Eligible'),('4SF20CS007','18CSL58','PASS','Not Eligible'),('4SF20CS007','18MAT41','FAIL','Not Eligible'),('4SF20CS010','18CIV59','FAIL','Not Eligible'),('4SF20CS010','18CPC49','FAIL','Not Eligible'),('4SF20CS010','18CS33','FAIL','Not Eligible'),('4SF20CS010','18CS42','FAIL','Not Eligible'),('4SF20CS010','18CS43','FAIL','Not Eligible'),('4SF20CS010','18CS44','FAIL','Eligible'),('4SF20CS010','18CS45','FAIL','Not Eligible'),('4SF20CS010','18CS46','FAIL','Not Eligible'),('4SF20CS010','18CS51','FAIL','Not Eligible'),('4SF20CS010','18CS52','FAIL','Not Eligible'),('4SF20CS010','18CS53','FAIL','Not Eligible'),('4SF20CS010','18CS54','FAIL','Not Eligible'),('4SF20CS010','18CS55','FAIL','Not Eligible'),('4SF20CS010','18CS56','FAIL','Not Eligible'),('4SF20CS010','18CS61','FAIL','Not Eligible'),('4SF20CS010','18CS71','FAIL','Not Eligible'),('4SF20CS010','18CS81','FAIL','Not Eligible'),('4SF20CS010','18CSL47','FAIL','Not Eligible'),('4SF20CS010','18CSL48','FAIL','Not Eligible'),('4SF20CS010','18CSL57','FAIL','Not Eligible'),('4SF20CS010','18CSL58','FAIL','Not Eligible'),('4SF20CS010','18MAT41','FAIL','Not Eligible'),('4SF20CS030','18CPC49','FAIL','Not Eligible'),('4SF20CS030','18CS33','FAIL','Not Eligible'),('4SF20CS030','18CS42','FAIL','Not Eligible'),('4SF20CS030','18CS43','FAIL','Not Eligible'),('4SF20CS030','18CS44','FAIL','Not Eligible'),('4SF20CS030','18CS45','FAIL','Not Eligible'),('4SF20CS030','18CS46','FAIL','Not Eligible'),('4SF20CS030','18CS51','PASS','Eligible'),('4SF20CS030','18CS52','FAIL','Eligible'),('4SF20CS030','18CS53','FAIL','Eligible'),('4SF20CS030','18CS54','FAIL','Eligible'),('4SF20CS030','18CSL47','FAIL','Not Eligible'),('4SF20CS030','18CSL48','FAIL','Not Eligible'),('4SF20CS030','18MAT41','FAIL','Not Eligible'),('4SF20CS034','18CPC49','FAIL','Not Eligible'),('4SF20CS034','18CS33','FAIL','Not Eligible'),('4SF20CS034','18CS42','FAIL','Not Eligible'),('4SF20CS034','18CS43','FAIL','Not Eligible'),('4SF20CS034','18CS44','FAIL','Not Eligible'),('4SF20CS034','18CS45','FAIL','Not Eligible'),('4SF20CS034','18CS46','FAIL','Not Eligible'),('4SF20CS034','18CSL47','FAIL','Not Eligible'),('4SF20CS034','18CSL48','FAIL','Not Eligible'),('4SF20CS034','18MAT41','FAIL','Not Eligible'),('4SF20CS056','18CIV59','FAIL','Not Eligible'),('4SF20CS056','18CPC49','FAIL','Not Eligible'),('4SF20CS056','18CS33','FAIL','Not Eligible'),('4SF20CS056','18CS42','FAIL','Not Eligible'),('4SF20CS056','18CS43','FAIL','Not Eligible'),('4SF20CS056','18CS44','FAIL','Not Eligible'),('4SF20CS056','18CS45','FAIL','Not Eligible'),('4SF20CS056','18CS46','FAIL','Not Eligible'),('4SF20CS056','18CS51','PASS','Not Eligible'),('4SF20CS056','18CS52','PASS','Not Eligible'),('4SF20CS056','18CS53','FAIL','Not Eligible'),('4SF20CS056','18CS54','PASS','Not Eligible'),('4SF20CS056','18CS55','PASS','Not Eligible'),('4SF20CS056','18CS56','FAIL','Not Eligible'),('4SF20CS056','18CS61','FAIL','Not Eligible'),('4SF20CS056','18CS71','FAIL','Not Eligible'),('4SF20CS056','18CS81','FAIL','Not Eligible'),('4SF20CS056','18CSL47','FAIL','Not Eligible'),('4SF20CS056','18CSL48','FAIL','Not Eligible'),('4SF20CS056','18CSL57','PASS','Not Eligible'),('4SF20CS056','18CSL58','FAIL','Not Eligible'),('4SF20CS056','18MAT11','FAIL','Not Eligible'),('4SF20CS056','18MAT41','FAIL','Not Eligible'),('4SF20CS056','18PHY12','FAIL','Not Eligible'),('4SF20CS068','18CIV59','FAIL','Not Eligible'),('4SF20CS068','18CPC49','FAIL','Not Eligible'),('4SF20CS068','18CS33','FAIL','Not Eligible'),('4SF20CS068','18CS42','FAIL','Not Eligible'),('4SF20CS068','18CS43','FAIL','Not Eligible'),('4SF20CS068','18CS44','FAIL','Not Eligible'),('4SF20CS068','18CS45','FAIL','Not Eligible'),('4SF20CS068','18CS46','FAIL','Not Eligible'),('4SF20CS068','18CS51','PASS','Not Eligible'),('4SF20CS068','18CS52','PASS','Not Eligible'),('4SF20CS068','18CS53','PASS','Not Eligible'),('4SF20CS068','18CS54','PASS','Not Eligible'),('4SF20CS068','18CS55','FAIL','Eligible'),('4SF20CS068','18CS56','FAIL','Not Eligible'),('4SF20CS068','18CS61','FAIL','Not Eligible'),('4SF20CS068','18CS71','FAIL','Not Eligible'),('4SF20CS068','18CS81','FAIL','Not Eligible'),('4SF20CS068','18CSL47','FAIL','Not Eligible'),('4SF20CS068','18CSL48','FAIL','Not Eligible'),('4SF20CS068','18CSL57','PASS','Not Eligible'),('4SF20CS068','18CSL58','FAIL','Not Eligible'),('4SF20CS068','18MAT11','FAIL','Not Eligible'),('4SF20CS068','18MAT41','FAIL','Not Eligible'),('4SF20CS068','18PHY12','FAIL','Not Eligible'),('4SF20CS093','18CIV59','FAIL','Not Eligible'),('4SF20CS093','18CPC49','FAIL','Not Eligible'),('4SF20CS093','18CS33','FAIL','Not Eligible'),('4SF20CS093','18CS42','FAIL','Not Eligible'),('4SF20CS093','18CS43','FAIL','Not Eligible'),('4SF20CS093','18CS44','FAIL','Not Eligible'),('4SF20CS093','18CS45','FAIL','Not Eligible'),('4SF20CS093','18CS46','FAIL','Not Eligible'),('4SF20CS093','18CS51','FAIL','Not Eligible'),('4SF20CS093','18CS52','PASS','Not Eligible'),('4SF20CS093','18CS53','PASS','Not Eligible'),('4SF20CS093','18CS54','PASS','Not Eligible'),('4SF20CS093','18CS55','PASS','Eligible'),('4SF20CS093','18CS56','FAIL','Not Eligible'),('4SF20CS093','18CS61','FAIL','Not Eligible'),('4SF20CS093','18CS71','FAIL','Not Eligible'),('4SF20CS093','18CS81','FAIL','Not Eligible'),('4SF20CS093','18CSL47','FAIL','Not Eligible'),('4SF20CS093','18CSL48','FAIL','Not Eligible'),('4SF20CS093','18CSL57','PASS','Not Eligible'),('4SF20CS093','18CSL58','FAIL','Not Eligible'),('4SF20CS093','18MAT41','FAIL','Not Eligible'),('4SF20CS134','18CIV59','FAIL','Not Eligible'),('4SF20CS134','18CPC49','FAIL','Not Eligible'),('4SF20CS134','18CS33','FAIL','Not Eligible'),('4SF20CS134','18CS42','FAIL','Not Eligible'),('4SF20CS134','18CS43','FAIL','Not Eligible'),('4SF20CS134','18CS44','FAIL','Not Eligible'),('4SF20CS134','18CS45','FAIL','Not Eligible'),('4SF20CS134','18CS46','FAIL','Not Eligible'),('4SF20CS134','18CS51','PASS','Not Eligible'),('4SF20CS134','18CS52','PASS','Not Eligible'),('4SF20CS134','18CS53','PASS','Not Eligible'),('4SF20CS134','18CS54','FAIL','Not Eligible'),('4SF20CS134','18CS55','FAIL','Eligible'),('4SF20CS134','18CS56','FAIL','Not Eligible'),('4SF20CS134','18CS61','FAIL','Not Eligible'),('4SF20CS134','18CS71','FAIL','Not Eligible'),('4SF20CS134','18CS81','FAIL','Not Eligible'),('4SF20CS134','18CSL47','FAIL','Not Eligible'),('4SF20CS134','18CSL48','FAIL','Not Eligible'),('4SF20CS134','18CSL57','PASS','Not Eligible'),('4SF20CS134','18CSL58','PASS','Not Eligible'),('4SF20CS134','18MAT11','FAIL','Not Eligible'),('4SF20CS134','18MAT41','FAIL','Not Eligible'),('4SF20CS134','18PHY12','FAIL','Not Eligible'),('4SF20CS146','18CIV59','FAIL','Not Eligible'),('4SF20CS146','18CPC49','FAIL','Not Eligible'),('4SF20CS146','18CS32','FAIL','Not Eligible'),('4SF20CS146','18CS33','FAIL','Not Eligible'),('4SF20CS146','18CS42','FAIL','Not Eligible'),('4SF20CS146','18CS43','FAIL','Not Eligible'),('4SF20CS146','18CS44','FAIL','Not Eligible'),('4SF20CS146','18CS45','FAIL','Not Eligible'),('4SF20CS146','18CS46','FAIL','Not Eligible'),('4SF20CS146','18CS51','PASS','Not Eligible'),('4SF20CS146','18CS52','PASS','Not Eligible'),('4SF20CS146','18CS53','PASS','Not Eligible'),('4SF20CS146','18CS54','PASS','Not Eligible'),('4SF20CS146','18CS55','FAIL','Eligible'),('4SF20CS146','18CS56','FAIL','Not Eligible'),('4SF20CS146','18CS61','FAIL','Not Eligible'),('4SF20CS146','18CS71','FAIL','Not Eligible'),('4SF20CS146','18CS81','FAIL','Not Eligible'),('4SF20CS146','18CSL47','FAIL','Not Eligible'),('4SF20CS146','18CSL48','FAIL','Not Eligible'),('4SF20CS146','18CSL57','PASS','Not Eligible'),('4SF20CS146','18CSL58','FAIL','Not Eligible'),('4SF20CS146','18MAT11','FAIL','Not Eligible'),('4SF20CS146','18MAT41','FAIL','Not Eligible'),('4SF20CS146','18PHY12','FAIL','Not Eligible'),('4SF20CS158','18CIV59','FAIL','Not Eligible'),('4SF20CS158','18CPC49','FAIL','Not Eligible'),('4SF20CS158','18CS33','FAIL','Not Eligible'),('4SF20CS158','18CS42','FAIL','Not Eligible'),('4SF20CS158','18CS43','FAIL','Not Eligible'),('4SF20CS158','18CS44','FAIL','Not Eligible'),('4SF20CS158','18CS45','FAIL','Not Eligible'),('4SF20CS158','18CS46','FAIL','Not Eligible'),('4SF20CS158','18CS51','FAIL','Not Eligible'),('4SF20CS158','18CS52','PASS','Not Eligible'),('4SF20CS158','18CS53','PASS','Not Eligible'),('4SF20CS158','18CS54','FAIL','Not Eligible'),('4SF20CS158','18CS55','PASS','Eligible'),('4SF20CS158','18CS56','FAIL','Not Eligible'),('4SF20CS158','18CS61','FAIL','Not Eligible'),('4SF20CS158','18CS71','FAIL','Not Eligible'),('4SF20CS158','18CS81','FAIL','Not Eligible'),('4SF20CS158','18CSL47','FAIL','Not Eligible'),('4SF20CS158','18CSL48','FAIL','Not Eligible'),('4SF20CS158','18CSL57','PASS','Not Eligible'),('4SF20CS158','18CSL58','FAIL','Not Eligible'),('4SF20CS158','18MAT11','FAIL','Not Eligible'),('4SF20CS158','18MAT41','FAIL','Not Eligible'),('4SF20CS158','18PHY12','FAIL','Not Eligible'),('4SF20CS189','18CIV59','FAIL','Not Eligible'),('4SF20CS189','18CPC49','FAIL','Not Eligible'),('4SF20CS189','18CS33','FAIL','Not Eligible'),('4SF20CS189','18CS42','FAIL','Not Eligible'),('4SF20CS189','18CS43','FAIL','Not Eligible'),('4SF20CS189','18CS44','FAIL','Not Eligible'),('4SF20CS189','18CS45','FAIL','Not Eligible'),('4SF20CS189','18CS46','FAIL','Not Eligible'),('4SF20CS189','18CS51','PASS','Not Eligible'),('4SF20CS189','18CS52','PASS','Not Eligible'),('4SF20CS189','18CS53','PASS','Not Eligible'),('4SF20CS189','18CS54','FAIL','Not Eligible'),('4SF20CS189','18CS55','FAIL','Eligible'),('4SF20CS189','18CS56','FAIL','Not Eligible'),('4SF20CS189','18CS61','FAIL','Not Eligible'),('4SF20CS189','18CS71','FAIL','Not Eligible'),('4SF20CS189','18CS81','FAIL','Not Eligible'),('4SF20CS189','18CSL47','FAIL','Not Eligible'),('4SF20CS189','18CSL48','FAIL','Not Eligible'),('4SF20CS189','18CSL57','PASS','Not Eligible'),('4SF20CS189','18CSL58','PASS','Not Eligible'),('4SF20CS189','18MAT11','FAIL','Not Eligible'),('4SF20CS189','18MAT41','FAIL','Not Eligible'),('4SF20CS189','18PHY12','FAIL','Not Eligible'),('4SF20CS190','18CIV59','FAIL','Not Eligible'),('4SF20CS190','18CPC49','FAIL','Not Eligible'),('4SF20CS190','18CS33','FAIL','Not Eligible'),('4SF20CS190','18CS42','FAIL','Not Eligible'),('4SF20CS190','18CS43','FAIL','Not Eligible'),('4SF20CS190','18CS44','FAIL','Not Eligible'),('4SF20CS190','18CS45','FAIL','Not Eligible'),('4SF20CS190','18CS46','FAIL','Not Eligible'),('4SF20CS190','18CS51','PASS','Not Eligible'),('4SF20CS190','18CS52','PASS','Not Eligible'),('4SF20CS190','18CS53','PASS','Not Eligible'),('4SF20CS190','18CS54','PASS','Not Eligible'),('4SF20CS190','18CS55','PASS','Eligible'),('4SF20CS190','18CS56','FAIL','Not Eligible'),('4SF20CS190','18CS61','FAIL','Not Eligible'),('4SF20CS190','18CS71','FAIL','Not Eligible'),('4SF20CS190','18CS81','FAIL','Not Eligible'),('4SF20CS190','18CSL47','FAIL','Not Eligible'),('4SF20CS190','18CSL48','FAIL','Not Eligible'),('4SF20CS190','18CSL57','PASS','Not Eligible'),('4SF20CS190','18CSL58','FAIL','Not Eligible'),('4SF20CS190','18MAT11','FAIL','Not Eligible'),('4SF20CS190','18MAT41','FAIL','Not Eligible'),('4SF20CS190','18PHY12','FAIL','Not Eligible'),('4SF20CS200','18CIV59','FAIL','Not Eligible'),('4SF20CS200','18CPC49','FAIL','Not Eligible'),('4SF20CS200','18CS33','FAIL','Not Eligible'),('4SF20CS200','18CS42','FAIL','Not Eligible'),('4SF20CS200','18CS43','FAIL','Not Eligible'),('4SF20CS200','18CS44','FAIL','Not Eligible'),('4SF20CS200','18CS45','FAIL','Not Eligible'),('4SF20CS200','18CS46','FAIL','Not Eligible'),('4SF20CS200','18CS51','PASS','Not Eligible'),('4SF20CS200','18CS52','PASS','Not Eligible'),('4SF20CS200','18CS53','PASS','Not Eligible'),('4SF20CS200','18CS54','FAIL','Not Eligible'),('4SF20CS200','18CS55','PASS','Eligible'),('4SF20CS200','18CS56','FAIL','Not Eligible'),('4SF20CS200','18CS61','FAIL','Not Eligible'),('4SF20CS200','18CS71','FAIL','Not Eligible'),('4SF20CS200','18CS81','FAIL','Not Eligible'),('4SF20CS200','18CSL47','FAIL','Not Eligible'),('4SF20CS200','18CSL48','FAIL','Not Eligible'),('4SF20CS200','18CSL57','FAIL','Not Eligible'),('4SF20CS200','18CSL58','PASS','Not Eligible'),('4SF20CS200','18MAT11','FAIL','Not Eligible'),('4SF20CS200','18MAT41','FAIL','Not Eligible'),('4SF20CS200','18PHY12','FAIL','Not Eligible'),('4SF20CS424','18CIV59','FAIL','Not Eligible'),('4SF20CS424','18CPC49','FAIL','Not Eligible'),('4SF20CS424','18CS33','FAIL','Not Eligible'),('4SF20CS424','18CS42','FAIL','Not Eligible'),('4SF20CS424','18CS43','FAIL','Not Eligible'),('4SF20CS424','18CS44','FAIL','Not Eligible'),('4SF20CS424','18CS45','FAIL','Not Eligible'),('4SF20CS424','18CS46','FAIL','Not Eligible'),('4SF20CS424','18CS51','FAIL','Not Eligible'),('4SF20CS424','18CS52','PASS','Not Eligible'),('4SF20CS424','18CS53','FAIL','Not Eligible'),('4SF20CS424','18CS54','PASS','Not Eligible'),('4SF20CS424','18CS55','FAIL','Eligible'),('4SF20CS424','18CS56','FAIL','Not Eligible'),('4SF20CS424','18CS61','FAIL','Not Eligible'),('4SF20CS424','18CS71','FAIL','Not Eligible'),('4SF20CS424','18CS81','FAIL','Not Eligible'),('4SF20CS424','18CSL47','FAIL','Not Eligible'),('4SF20CS424','18CSL48','FAIL','Not Eligible'),('4SF20CS424','18CSL57','PASS','Not Eligible'),('4SF20CS424','18CSL58','PASS','Not Eligible'),('4SF20CS424','18MAT11','FAIL','Not Eligible'),('4SF20CS424','18MAT41','FAIL','Not Eligible'),('4SF20CS424','18PHY12','FAIL','Not Eligible');
/*!40000 ALTER TABLE `academiceligibility` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_academicachievements` AFTER INSERT ON `academiceligibility` FOR EACH ROW BEGIN
update academicachievements set SBACKLOGS = SBACKLOGS+1 where USN=new.USN and new.STATUS="FAIL";
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `academicyear`
--

DROP TABLE IF EXISTS `academicyear`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academicyear` (
  `YEARID` varchar(10) NOT NULL,
  `YEARSTDCOUNT` int DEFAULT NULL,
  `YEARFCTCOUNT` int DEFAULT NULL,
  `JOINYEAR` int NOT NULL,
  `PASSOUTYEAR` int NOT NULL,
  PRIMARY KEY (`YEARID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academicyear`
--

LOCK TABLES `academicyear` WRITE;
/*!40000 ALTER TABLE `academicyear` DISABLE KEYS */;
INSERT INTO `academicyear` VALUES ('2019-23',2000,200,2019,2023),('2020-24',2000,200,2020,2024),('2021-25',2000,200,2021,2025);
/*!40000 ALTER TABLE `academicyear` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `CID` varchar(2) NOT NULL,
  `CSEM` int NOT NULL,
  `SECTION` varchar(1) NOT NULL,
  `CLASSSTDCOUNT` int DEFAULT NULL,
  `YEAROFSTUDY` int DEFAULT NULL,
  `YEARID` varchar(10) NOT NULL,
  PRIMARY KEY (`YEARID`,`CID`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`YEARID`) REFERENCES `academicyear` (`YEARID`),
  CONSTRAINT `class_chk_1` CHECK (((`YEAROFSTUDY` >= 1) and (`YEAROFSTUDY` <= 4))),
  CONSTRAINT `class_chk_2` CHECK ((`CSEM` in (1,2,3,4,5,6,7,8))),
  CONSTRAINT `class_chk_3` CHECK ((`SECTION` in (_utf8mb4'A',_utf8mb4'B',_utf8mb4'C',_utf8mb4'D',_utf8mb4'E',_utf8mb4'F',_utf8mb4'G',_utf8mb4'H',_utf8mb4'I',_utf8mb4'J',_utf8mb4'K',_utf8mb4'L')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('7B',7,'B',65,4,'2019-23'),('8B',8,'B',65,4,'2019-23'),('4A',4,'A',47,2,'2020-24'),('4C',4,'C',66,2,'2020-24'),('5A',5,'A',65,3,'2020-24'),('5C',5,'C',68,3,'2020-24'),('6C',6,'C',68,3,'2020-24'),('3A',3,'A',58,2,'2021-25');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `DID` int NOT NULL AUTO_INCREMENT,
  `DNAME` varchar(20) NOT NULL,
  `DEPTSTDCOUNT` int DEFAULT NULL,
  `DEPTFCTCOUNT` int DEFAULT NULL,
  `YEARID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`DID`),
  UNIQUE KEY `DNAME` (`DNAME`),
  KEY `YEARID` (`YEARID`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`YEARID`) REFERENCES `academicyear` (`YEARID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'CSE',180,20,'2020-24'),(2,'ISE',60,5,'2020-24'),(3,'AIML',60,7,'2020-24');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `FID` int NOT NULL AUTO_INCREMENT,
  `FFNAME` varchar(10) NOT NULL,
  `FLNAME` varchar(10) NOT NULL,
  `FDESIGNATION` varchar(20) NOT NULL,
  `FSALARY` varchar(10) DEFAULT NULL,
  `FPHNO` varchar(12) DEFAULT NULL,
  `FCITY` varchar(10) DEFAULT NULL,
  `FGENDER` varchar(10) NOT NULL,
  `FDOB` date DEFAULT NULL,
  `FEMAIL` varchar(20) DEFAULT NULL,
  `DID` int NOT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(10) NOT NULL,
  `join_year` int NOT NULL,
  PRIMARY KEY (`FID`),
  UNIQUE KEY `PASSWORD` (`PASSWORD`),
  UNIQUE KEY `USERNAME` (`USERNAME`),
  UNIQUE KEY `USERNAME_2` (`USERNAME`),
  UNIQUE KEY `FPHNO` (`FPHNO`),
  UNIQUE KEY `FEMAIL` (`FEMAIL`),
  UNIQUE KEY `FEMAIL_2` (`FEMAIL`),
  UNIQUE KEY `USERNAME_3` (`USERNAME`),
  KEY `DID` (`DID`),
  CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`DID`) REFERENCES `department` (`DID`),
  CONSTRAINT `faculty_chk_1` CHECK ((`FGENDER` in (_utf8mb4'Male',_utf8mb4'Female')))
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (2,'Rajesh','HRN','HOD','200k-300k','9728347823','Mangalore','Male','1974-09-23','raj123@gmail.com',1,'Rajesh HR','Rajes@123',2018),(3,'Ramesh','Hasan','Assistant Professor','100k-150k','9899726384','Mangalore','Male','1982-03-04','ramesh12@gmail.com',1,'Ramesh Hasan','Rames@123',2015),(4,'Roseria','Moore','Associate Professor','100k-150k','9873478273','Mangalore','Female','1982-09-29','rosym123@gmail.com',2,'Roseria Moore','Roser@123',2017),(5,'Pushpaltha','K','HOD','200k-300k','9283789234','Mangalore','Female','1975-03-06','pushpa123@gmail.com',3,'Pushpalatha K','Pushp@123',2010),(6,'Prem Kumar','BC','Associate Professor','150k-200k','9928839239','Mangalore','Male','1958-09-23','prem123@gmail.com',1,'Prem Kumar BC','Prem @123',2011),(7,'Namita','AA','Associate Professor','150k-200k','929839939','Mangalore','Female','1983-09-23','namita123@gmail.com',1,'Namita AA','Namit@123',2014),(8,'Rachitha','M','Associate Professor','50k-100k','9928828293','Mangalore','Female','1982-03-29','rachita12@gmail.com',1,'Rachitha M','Rachi@123',2016),(9,'Bhavana','A','Assistant Professor','150k-200k','929829929','Mangalore','Female','1987-09-29','bhavana12@gmail.com',1,'Bhavana A','Bhava@123',2008),(10,'Keerthy','Suresh','Assistant Professor','100k-150k','9822838822','Mangalore','Female','2002-08-25','keerthy12@gmail.com',1,'Keerthy Suresh','Keert@123',2017),(11,'Manish','Chandra','Assistant Professor','100k-150k','9283882929','Mangalore','Male','1995-03-23','manish2@gmail.com',1,'Manish Chandra','Manis@123',2022),(12,'Mary Jency','Shinto','Associate Professor','100k-150k','9929820982','Mangalore','Female','1978-03-24','maryjc12@gmail.com',1,'Mary Jency Shinto','Mary @123',2012),(13,'Chaitanya','Laxmi','Assistant Professor','100k-150k','9288228202','Mangalore','Female','1991-09-23','chait123@gmail.com',1,'Chaitanya Laxmi','Chait@123',2021),(14,'Shruti','K','Assistant Professor','100k-150k','9929839299','Mangalore','Female','1974-09-23','shruti12@gmail.com',1,'Shruti K','Shrut@123',2021),(15,'Sharath','Chandra','Associate Professor','150k-200k','9289239939','Mangalore','Male','1972-09-02','sharath12@gmail.com',1,'Sharath Chandra','Shara@123',2012),(16,'Nikesh','Shetty','Assistant Professor','100k-150k','9287299222','Mangalore','Male','1994-08-23','nikesh12@gmail.com',1,'Nikesh Shetty','Nikes@123',2017);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `SI_ID` varchar(10) NOT NULL,
  `FID` int NOT NULL,
  `SUBCODE` varchar(10) NOT NULL,
  `USN` varchar(10) NOT NULL,
  `Punctuality` varchar(20) DEFAULT NULL,
  `Regularity` varchar(20) DEFAULT NULL,
  `Communication` varchar(20) DEFAULT NULL,
  `Confidence` varchar(20) DEFAULT NULL,
  `Rating` int DEFAULT NULL,
  `Review` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SI_ID`,`FID`,`SUBCODE`,`USN`),
  KEY `FID` (`FID`),
  KEY `SUBCODE` (`SUBCODE`),
  KEY `USN` (`USN`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`SI_ID`) REFERENCES `stud_info` (`SI_ID`) ON DELETE CASCADE,
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`FID`) REFERENCES `faculty` (`FID`) ON DELETE CASCADE,
  CONSTRAINT `feedback_ibfk_3` FOREIGN KEY (`SUBCODE`) REFERENCES `subjects` (`subcode`) ON DELETE CASCADE,
  CONSTRAINT `feedback_ibfk_4` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('20CS5C',2,'18CS55','4SF20CS004','Good','Very Good','Very Good','Very Good',9,'Excellent Faculty'),('20CS5C',6,'18CS51','4SF20CS004','Good','Very Good','Excellent','Excellent',8,NULL);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpa`
--

DROP TABLE IF EXISTS `gpa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpa` (
  `USN` varchar(10) NOT NULL,
  `SEM` int NOT NULL,
  `sgpa` decimal(5,3) DEFAULT '0.000',
  PRIMARY KEY (`USN`,`SEM`),
  CONSTRAINT `gpa_ibfk_1` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE,
  CONSTRAINT `gpa_chk_1` CHECK ((`SEM` in (1,2,3,4,5,6,7,8))),
  CONSTRAINT `gpa_chk_2` CHECK (((`sgpa` >= 0) and (`sgpa` <= 10)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpa`
--

LOCK TABLES `gpa` WRITE;
/*!40000 ALTER TABLE `gpa` DISABLE KEYS */;
INSERT INTO `gpa` VALUES ('4SF19CS178',1,0.000),('4SF19CS178',2,0.000),('4SF19CS178',3,0.000),('4SF19CS178',4,0.000),('4SF19CS178',5,0.000),('4SF19CS178',6,0.000),('4SF19CS178',7,0.000),('4SF19CS178',8,0.000),('4SF20CS004',1,9.333),('4SF20CS004',2,0.000),('4SF20CS004',3,7.875),('4SF20CS004',4,8.958),('4SF20CS004',5,8.720),('4SF20CS004',6,0.000),('4SF20CS004',7,0.000),('4SF20CS004',8,0.000),('4SF20CS005',1,0.000),('4SF20CS005',2,0.000),('4SF20CS005',3,0.000),('4SF20CS005',4,0.000),('4SF20CS005',5,0.000),('4SF20CS005',6,0.000),('4SF20CS005',7,0.000),('4SF20CS005',8,0.000),('4SF20CS007',1,0.000),('4SF20CS007',2,0.000),('4SF20CS007',3,0.000),('4SF20CS007',4,0.000),('4SF20CS007',5,0.000),('4SF20CS007',6,0.000),('4SF20CS007',7,0.000),('4SF20CS007',8,0.000),('4SF20CS010',1,0.000),('4SF20CS010',2,0.000),('4SF20CS010',3,0.000),('4SF20CS010',4,0.000),('4SF20CS010',5,0.000),('4SF20CS010',6,0.000),('4SF20CS010',7,0.000),('4SF20CS010',8,0.000),('4SF20CS030',1,8.143),('4SF20CS030',2,9.400),('4SF20CS030',3,9.400),('4SF20CS030',4,9.400),('4SF20CS030',5,5.760),('4SF20CS030',6,0.000),('4SF20CS030',7,0.000),('4SF20CS030',8,0.000),('4SF20CS034',1,0.000),('4SF20CS034',2,0.000),('4SF20CS034',3,0.000),('4SF20CS034',4,0.000),('4SF20CS034',5,0.000),('4SF20CS034',6,0.000),('4SF20CS034',7,0.000),('4SF20CS034',8,0.000),('4SF20CS056',1,0.000),('4SF20CS056',2,0.000),('4SF20CS056',3,0.000),('4SF20CS056',4,0.000),('4SF20CS056',5,0.000),('4SF20CS056',6,0.000),('4SF20CS056',7,0.000),('4SF20CS056',8,0.000),('4SF20CS068',1,0.000),('4SF20CS068',2,0.000),('4SF20CS068',3,0.000),('4SF20CS068',4,0.000),('4SF20CS068',5,0.000),('4SF20CS068',6,0.000),('4SF20CS068',7,0.000),('4SF20CS068',8,0.000),('4SF20CS093',1,0.000),('4SF20CS093',2,0.000),('4SF20CS093',3,0.000),('4SF20CS093',4,0.000),('4SF20CS093',5,0.000),('4SF20CS093',6,0.000),('4SF20CS093',7,0.000),('4SF20CS093',8,0.000),('4SF20CS134',1,0.000),('4SF20CS134',2,0.000),('4SF20CS134',3,0.000),('4SF20CS134',4,0.000),('4SF20CS134',5,0.000),('4SF20CS134',6,0.000),('4SF20CS134',7,0.000),('4SF20CS134',8,0.000),('4SF20CS146',1,0.000),('4SF20CS146',2,0.000),('4SF20CS146',3,0.000),('4SF20CS146',4,0.000),('4SF20CS146',5,0.000),('4SF20CS146',6,0.000),('4SF20CS146',7,0.000),('4SF20CS146',8,0.000),('4SF20CS158',1,0.000),('4SF20CS158',2,0.000),('4SF20CS158',3,0.000),('4SF20CS158',4,0.000),('4SF20CS158',5,0.000),('4SF20CS158',6,0.000),('4SF20CS158',7,0.000),('4SF20CS158',8,0.000),('4SF20CS189',1,0.000),('4SF20CS189',2,0.000),('4SF20CS189',3,0.000),('4SF20CS189',4,0.000),('4SF20CS189',5,0.000),('4SF20CS189',6,0.000),('4SF20CS189',7,0.000),('4SF20CS189',8,0.000),('4SF20CS190',1,0.000),('4SF20CS190',2,0.000),('4SF20CS190',3,0.000),('4SF20CS190',4,0.000),('4SF20CS190',5,0.000),('4SF20CS190',6,0.000),('4SF20CS190',7,0.000),('4SF20CS190',8,0.000),('4SF20CS200',1,0.000),('4SF20CS200',2,0.000),('4SF20CS200',3,0.000),('4SF20CS200',4,0.000),('4SF20CS200',5,0.000),('4SF20CS200',6,0.000),('4SF20CS200',7,0.000),('4SF20CS200',8,0.000),('4SF20CS424',1,0.000),('4SF20CS424',2,0.000),('4SF20CS424',3,0.000),('4SF20CS424',4,0.000),('4SF20CS424',5,0.000),('4SF20CS424',6,0.000),('4SF20CS424',7,0.000),('4SF20CS424',8,0.000);
/*!40000 ALTER TABLE `gpa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iamarks`
--

DROP TABLE IF EXISTS `iamarks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iamarks` (
  `USN` varchar(10) NOT NULL,
  `SUBCODE` varchar(10) NOT NULL,
  `IA1` int DEFAULT '0',
  `IA2` int DEFAULT '0',
  `IA3` int DEFAULT '0',
  `AssgnMrks` int DEFAULT '0',
  `FinalIA` int DEFAULT '0',
  `SEE` int DEFAULT '0',
  `TotalMrks` int DEFAULT '0',
  `Attendance` int DEFAULT '0',
  `Remarks` varchar(100) DEFAULT '',
  PRIMARY KEY (`USN`,`SUBCODE`),
  KEY `SUBCODE` (`SUBCODE`),
  CONSTRAINT `iamarks_ibfk_1` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE,
  CONSTRAINT `iamarks_ibfk_2` FOREIGN KEY (`SUBCODE`) REFERENCES `subjects` (`subcode`) ON DELETE CASCADE,
  CONSTRAINT `assgnmrks_constraint` CHECK ((`AssgnMrks` <= 10)),
  CONSTRAINT `finalia_constraint` CHECK ((`FinalIA` <= 40)),
  CONSTRAINT `iamarks_chk_1` CHECK (((`IA1` >= 0) and (`IA1` <= 30))),
  CONSTRAINT `iamarks_chk_2` CHECK (((`IA2` >= 0) and (`IA2` <= 30))),
  CONSTRAINT `iamarks_chk_3` CHECK (((`IA3` >= 0) and (`IA3` <= 30))),
  CONSTRAINT `iamarks_chk_4` CHECK (((`AssgnMrks` >= 0) and (`AssgnMrks` <= 10))),
  CONSTRAINT `iamarks_chk_5` CHECK (((`FinalIA` >= 0) and (`FinalIA` <= 40))),
  CONSTRAINT `iamarks_chk_6` CHECK (((`SEE` >= 0) and (`SEE` <= 60))),
  CONSTRAINT `iamarks_chk_7` CHECK (((`TotalMrks` >= 0) and (`TotalMrks` <= 100))),
  CONSTRAINT `iamarks_chk_8` CHECK (((`Attendance` >= 0) and (`Attendance` <= 100))),
  CONSTRAINT `iamarks_constraint` CHECK (((`IA1` <= 30) and (`IA2` <= 30) and (`IA3` <= 30))),
  CONSTRAINT `SEE_constraint` CHECK ((`SEE` <= 60)),
  CONSTRAINT `TotalMA_constraint` CHECK (((`TotalMrks` <= 100) and (`Attendance` <= 100)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iamarks`
--

LOCK TABLES `iamarks` WRITE;
/*!40000 ALTER TABLE `iamarks` DISABLE KEYS */;
INSERT INTO `iamarks` VALUES ('4SF19CS178','18CIV59',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CPC49',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS33',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS42',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS43',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS44',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS45',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS46',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS51',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS52',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS53',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS54',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS55',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS56',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS61',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CS71',0,0,0,0,0,0,0,100,''),('4SF19CS178','18CS81',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CSL47',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CSL48',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CSL57',0,0,0,0,0,0,0,0,''),('4SF19CS178','18CSL58',0,0,0,0,0,0,0,0,''),('4SF19CS178','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CS51',30,30,30,10,40,50,90,95,'Very Good!! Keep it up!!'),('4SF20CS004','18CS52',30,20,26,10,35,58,93,87,'Very Good!! Keep it up!!'),('4SF20CS004','18CS53',15,15,15,2,17,21,38,85,'Very Good!! Keep it up!!'),('4SF20CS004','18CS54',20,30,30,10,36,34,70,30,'Very Good!! Keep it up!!'),('4SF20CS004','18CS55',20,25,30,10,35,58,93,75,'very good!!\n'),('4SF20CS004','18CS56',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS004','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS004','18CSL57',30,28,28,10,38,20,58,0,'Good'),('4SF20CS004','18CSL58',30,29,28,10,39,43,82,0,'Good!!'),('4SF20CS004','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CS51',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS005','18CS52',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS005','18CS53',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS005','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS005','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS005','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS51',28,29,30,10,39,57,96,0,'Good'),('4SF20CS007','18CS52',30,29,28,10,39,47,86,0,'Good'),('4SF20CS007','18CS53',30,29,28,10,39,35,74,0,'Good!!'),('4SF20CS007','18CS54',30,29,28,10,39,40,79,0,'Good!!'),('4SF20CS007','18CS55',29,20,18,10,32,27,59,50,'Good!! Keep it Up'),('4SF20CS007','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS007','18CSL57',30,29,30,10,39,58,97,0,'Good'),('4SF20CS007','18CSL58',30,29,27,10,38,45,83,0,'Good!!'),('4SF20CS007','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS44',0,0,0,0,0,0,0,100,''),('4SF20CS010','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS51',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS52',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS53',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS54',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS55',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CSL57',0,0,0,0,0,0,0,0,''),('4SF20CS010','18CSL58',0,0,0,0,0,0,0,0,''),('4SF20CS010','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CS51',10,30,30,10,33,21,54,85,'Very Good!! Keep it up!!'),('4SF20CS030','18CS52',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS030','18CS53',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS030','18CS54',10,10,10,0,10,21,31,85,'Very Good!! Keep it up!!'),('4SF20CS030','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS030','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS030','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS034','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS034','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS51',27,28,29,10,38,23,61,0,'Nice'),('4SF20CS056','18CS52',30,29,28,10,39,47,86,0,'Good'),('4SF20CS056','18CS53',29,19,20,10,32,20,52,0,'Good!!'),('4SF20CS056','18CS54',30,30,30,10,40,53,93,0,'Good!!'),('4SF20CS056','18CS55',20,28,16,9,30,50,80,50,'Need to Improve!!'),('4SF20CS056','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS056','18CSL57',30,29,28,10,39,24,63,0,'Good'),('4SF20CS056','18CSL58',0,0,0,0,0,0,0,0,''),('4SF20CS056','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS056','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS056','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS51',28,29,30,10,39,35,74,0,'Good Job'),('4SF20CS068','18CS52',30,29,17,10,35,44,79,0,'Good'),('4SF20CS068','18CS53',30,29,30,10,39,55,94,0,'Good!!'),('4SF20CS068','18CS54',29,30,27,10,38,23,61,0,'Good!!'),('4SF20CS068','18CS55',10,5,0,10,15,18,33,100,'You need to Work hard!!!'),('4SF20CS068','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS068','18CSL57',30,29,28,10,39,37,76,0,'Good'),('4SF20CS068','18CSL58',28,27,26,10,37,18,55,0,'Good!!'),('4SF20CS068','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS068','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS068','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS51',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS52',28,28,29,10,38,22,60,0,'Good'),('4SF20CS093','18CS53',27,26,25,10,36,56,92,0,'Good!!'),('4SF20CS093','18CS54',30,28,27,10,38,43,81,0,'Good!!'),('4SF20CS093','18CS55',25,29,20,10,34,36,70,100,'Good!! Keep it Up'),('4SF20CS093','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS093','18CSL57',28,29,26,10,37,57,94,0,'Good'),('4SF20CS093','18CSL58',30,28,17,10,35,18,53,0,'Good!!'),('4SF20CS093','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS51',30,30,29,10,39,27,66,0,'Good'),('4SF20CS134','18CS52',20,29,28,10,35,43,78,0,'Good'),('4SF20CS134','18CS53',18,19,20,10,29,48,77,0,'Good!!'),('4SF20CS134','18CS54',27,18,29,10,34,17,51,0,'Good!!'),('4SF20CS134','18CS55',18,14,1,5,16,13,29,100,'Poor Performance!! Need to Improve'),('4SF20CS134','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS134','18CSL57',29,28,25,10,37,50,87,0,'Good'),('4SF20CS134','18CSL58',29,29,20,10,36,42,78,0,'Good!!'),('4SF20CS134','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS134','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS134','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS32',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS51',30,20,30,9,35,30,65,0,'Good'),('4SF20CS146','18CS52',28,29,20,10,35,56,91,0,'Good'),('4SF20CS146','18CS53',30,28,30,10,39,52,91,0,'Good!!'),('4SF20CS146','18CS54',30,30,30,10,40,44,84,0,'Good!!'),('4SF20CS146','18CS55',0,0,0,0,0,0,0,100,''),('4SF20CS146','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS146','18CSL57',30,30,29,10,39,46,85,0,'Good'),('4SF20CS146','18CSL58',30,27,29,10,38,20,58,0,'Good!!'),('4SF20CS146','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS146','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS146','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS51',30,28,28,10,38,19,57,0,'Good\n'),('4SF20CS158','18CS52',30,29,28,10,39,50,89,0,'Good'),('4SF20CS158','18CS53',30,29,20,10,36,33,69,0,'Good!!'),('4SF20CS158','18CS54',29,28,20,10,35,20,55,0,'Good!!'),('4SF20CS158','18CS55',10,15,8,9,20,53,73,100,'Very Poor Performance!!'),('4SF20CS158','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS158','18CSL57',30,29,30,10,39,34,73,0,'Good'),('4SF20CS158','18CSL58',20,27,19,10,32,17,49,0,'Good!!'),('4SF20CS158','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS158','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS158','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS51',30,28,29,10,39,48,87,0,'Keep it up\n'),('4SF20CS189','18CS52',30,28,29,10,39,24,63,0,'Good'),('4SF20CS189','18CS53',28,19,29,10,35,48,83,0,'Good!!'),('4SF20CS189','18CS54',20,30,30,10,36,17,53,0,'Good!!'),('4SF20CS189','18CS55',28,27,25,10,36,6,42,100,'Good!!'),('4SF20CS189','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS189','18CSL57',30,29,28,10,39,34,73,0,'Good'),('4SF20CS189','18CSL58',30,30,30,10,40,32,72,0,'Good!!'),('4SF20CS189','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS189','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS189','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS51',30,29,30,10,39,27,66,0,'Good'),('4SF20CS190','18CS52',30,29,28,10,39,28,67,0,'Good'),('4SF20CS190','18CS53',30,19,20,10,33,25,58,0,'Good!!'),('4SF20CS190','18CS54',30,27,28,10,38,21,59,0,'Good!!'),('4SF20CS190','18CS55',30,30,30,10,40,7,47,100,'Excellent!! Keep it Up.'),('4SF20CS190','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS190','18CSL57',30,29,28,10,39,57,96,0,'Good'),('4SF20CS190','18CSL58',30,29,20,10,36,17,53,0,'Good!!'),('4SF20CS190','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS190','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS190','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS51',30,30,30,10,40,37,77,0,'Good'),('4SF20CS200','18CS52',30,29,28,10,39,30,69,0,'Good'),('4SF20CS200','18CS53',30,29,18,10,35,31,66,0,'Good!!'),('4SF20CS200','18CS54',28,27,26,10,37,16,53,0,'Good!!'),('4SF20CS200','18CS55',28,17,30,10,35,27,62,100,'Good'),('4SF20CS200','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS200','18CSL57',30,30,29,10,39,19,58,0,'Good'),('4SF20CS200','18CSL58',30,27,28,10,38,55,93,0,'Good!!'),('4SF20CS200','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS200','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS200','18PHY12',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CIV59',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CPC49',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS33',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS42',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS43',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS44',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS45',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS46',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS51',30,30,28,10,39,19,58,0,'Good'),('4SF20CS424','18CS52',29,28,20,10,35,60,95,0,'Good'),('4SF20CS424','18CS53',28,27,29,10,38,19,57,0,'Good!!'),('4SF20CS424','18CS54',30,28,27,10,38,37,75,0,'Good!!'),('4SF20CS424','18CS55',23,29,30,10,37,5,42,100,'Good!!'),('4SF20CS424','18CS56',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS61',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS71',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CS81',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CSL47',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CSL48',0,0,0,0,0,0,0,0,''),('4SF20CS424','18CSL57',30,28,29,10,39,34,73,0,'Good'),('4SF20CS424','18CSL58',20,19,20,10,29,35,64,0,'Good!!'),('4SF20CS424','18MAT11',0,0,0,0,0,0,0,0,''),('4SF20CS424','18MAT41',0,0,0,0,0,0,0,0,''),('4SF20CS424','18PHY12',0,0,0,0,0,0,0,0,'');
/*!40000 ALTER TABLE `iamarks` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `insert_into_acadelig` AFTER INSERT ON `iamarks` FOR EACH ROW BEGIN
insert into academiceligibility(USN,SUBCODE) values(new.usn,new.subcode);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `status_trigger_afterinsert` AFTER INSERT ON `iamarks` FOR EACH ROW BEGIN
UPDATE academiceligibility set status="PASS" where (USN,SUBCODE) in ( select USN,SUBCODE from iamarks where FinalIA>=16 and SEE>=21 and TotalMrks>=40);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `eligibility_trigger_afterinsert` AFTER INSERT ON `iamarks` FOR EACH ROW BEGIN
UPDATE academiceligibility set eligibility="Eligible" where (USN,SUBCODE) in (select USN,SUBCODE from iamarks where attendance>=85);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `status_trigger_afterupdate1` AFTER UPDATE ON `iamarks` FOR EACH ROW BEGIN
UPDATE academiceligibility set status="PASS" where (USN,SUBCODE) in ( select USN,SUBCODE from iamarks where FinalIA>=16 and SEE>=21 and TotalMrks>=40);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `status_trigger_afterupdate2` AFTER UPDATE ON `iamarks` FOR EACH ROW BEGIN
UPDATE academiceligibility set status="FAIL" where (USN,SUBCODE) in ( select USN,SUBCODE from iamarks where FinalIA<16 and SEE<21 and TotalMrks<40);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `eligibility_trigger_afterupdate1` AFTER UPDATE ON `iamarks` FOR EACH ROW BEGIN
UPDATE academiceligibility set eligibility="Eligible" where (USN,SUBCODE) in (select USN,SUBCODE from iamarks where attendance>=85);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `eligibility_trigger_afterupdate2` AFTER UPDATE ON `iamarks` FOR EACH ROW BEGIN
UPDATE academiceligibility set eligibility="Not Eligible" where (USN,SUBCODE) in (select USN,SUBCODE from iamarks where attendance<85);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `stud_info`
--

DROP TABLE IF EXISTS `stud_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stud_info` (
  `SI_ID` varchar(10) NOT NULL,
  `CID` varchar(2) NOT NULL,
  `YEARID` varchar(10) NOT NULL,
  `DID` int NOT NULL,
  PRIMARY KEY (`SI_ID`),
  KEY `CID` (`CID`),
  KEY `DID` (`DID`),
  KEY `stud_info_ibfk_4` (`YEARID`,`CID`),
  CONSTRAINT `stud_info_ibfk_2` FOREIGN KEY (`DID`) REFERENCES `department` (`DID`),
  CONSTRAINT `stud_info_ibfk_3` FOREIGN KEY (`YEARID`) REFERENCES `academicyear` (`YEARID`),
  CONSTRAINT `stud_info_ibfk_4` FOREIGN KEY (`YEARID`, `CID`) REFERENCES `class` (`YEARID`, `CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_info`
--

LOCK TABLES `stud_info` WRITE;
/*!40000 ALTER TABLE `stud_info` DISABLE KEYS */;
INSERT INTO `stud_info` VALUES ('19CS7B','7B','2019-23',1),('19CS8B','8B','2019-23',1),('20AI4A','4A','2020-24',3),('20CS4C','4C','2020-24',1),('20CS5A','5A','2020-24',1),('20CS5C','5C','2020-24',1),('20CS6C','6C','2020-24',1),('21CS3A','3A','2021-25',1);
/*!40000 ALTER TABLE `stud_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `SID` int NOT NULL AUTO_INCREMENT,
  `SFNAME` varchar(10) NOT NULL,
  `SLNAME` varchar(10) NOT NULL,
  `USN` varchar(10) NOT NULL,
  `SPHNO` varchar(12) DEFAULT NULL,
  `SCITY` varchar(10) DEFAULT NULL,
  `SGENDER` varchar(10) NOT NULL,
  `SDOB` date DEFAULT NULL,
  `SEMAIL` varchar(20) DEFAULT NULL,
  `si_id` varchar(10) NOT NULL,
  `SUSERNAME` varchar(15) NOT NULL,
  `SPASSWORD` varchar(16) NOT NULL,
  PRIMARY KEY (`SID`,`USN`),
  UNIQUE KEY `USN` (`USN`),
  UNIQUE KEY `SUSERNAME` (`SUSERNAME`),
  UNIQUE KEY `SPASSWORD` (`SPASSWORD`),
  UNIQUE KEY `SPHNO` (`SPHNO`),
  UNIQUE KEY `SEMAIL` (`SEMAIL`),
  KEY `si_id` (`si_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`si_id`) REFERENCES `stud_info` (`SI_ID`),
  CONSTRAINT `student_chk_1` CHECK ((`SGENDER` in (_utf8mb4'Male',_utf8mb4'Female')))
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (16,'Anil','Kapoor','4SF20CS004','9876348394','Mangalore','Male','2002-03-23','anilk123@gmail.com','20CS5C','4SF20CS004','4SF20CS004'),(26,'Devika','Shetty','4SF20CS030','9283992293','Mangalore','Female','2002-03-23','devikas123@gmail.com','20CS5A','4SF20CS030','4SF20CS030'),(28,'Anup','Kher','4SF20CS005','9238428432','Mangalore','Male','2002-03-23','anup01@gmail.com','20CS5A','4SF20CS005','4SF20CS005'),(29,'Himanshu','Rao','4SF20CS034','9288949923','Mangalore','Male','2002-03-23','himanshu1@gmail.com','20CS5A','4SF20CS034','4SF20CS034'),(31,'Anita','Kumari','4SF20CS007','929399234','Mangalore','Female','2002-07-20','anitak123@gmail.com','20CS5C','4SF20CS007','4SF20CS007'),(32,'Athiya','Shetty','4SF20CS010','9322038203','Mangalore','Female','2002-08-23','athiya123@gmail.com','20CS4C','4SF20CS010','4SF20CS010'),(33,'Sarah','Khan','4SF19CS178','9882392348','Mangalore','Female','2002-09-23','sarahk123@gmail.com','19CS7B','4SF19CS178','4SF19CS178'),(34,'Pushpa','Raj','4SF20CS093','9293930022','Mangalore','Male','2003-09-23','pushpa123@gmail.com','20CS5C','4SF20CS093','4SF20CS093'),(35,'Rahul','VK','4SF20CS424','9298270282','Mangalore','Male','1982-02-09','rahul01@gmail.com','20CS5C','4SF20CS424','4SF20CS424'),(36,'Mohith','K','4SF20CS134','9020902902','Mangalore','Male','2002-03-02','mohit12@gmail.com','20CS5C','4SF20CS134','4SF20CS134'),(37,'Chetan','Bhagat','4SF20CS056','9929793939','Mangalore','Male','2002-03-24','chetan12@gmail.com','20CS5C','4SF20CS056','4SF20CS056'),(38,'Sudha','Murthy','4SF20CS158','9020303022','Mangalore','Female','2002-10-23','sudham12@gmail.com','20CS5C','4SF20CS158','4SF20CS158'),(39,'Suresh','Rao','4SF20CS200','9388493992','Mangalore','Male','2002-11-23','suresh12@gmail.com','20CS5C','4SF20CS200','4SF20CS200'),(40,'Sunil','Shetty','4SF20CS189','9982882382','Mangalore','Male','2002-12-03','sunil12@gmail.com','20CS5C','4SF20CS189','4SF20CS189'),(41,'Sunitha','K','4SF20CS190','9288290323','Mangalore','Female','2002-12-02','sunita12@gmail.com','20CS5C','4SF20CS190','4SF20CS190'),(42,'Charles','Huges','4SF20CS068','9828929223','Mangalore','Male','2002-03-27','charles12@gmail.com','20CS5C','4SF20CS068','4SF20CS068'),(43,'Sourav','Ganguly','4SF20CS146','9288382929','Mangalore','Male','2002-09-12','sourav12@gmail.com','20CS5C','4SF20CS146','4SF20CS146');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `insert_into_academicachievements` AFTER INSERT ON `student` FOR EACH ROW BEGIN
insert into academicachievements(USN) values(new.USN);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `studentattendance`
--

DROP TABLE IF EXISTS `studentattendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentattendance` (
  `USN` varchar(10) NOT NULL,
  `SUBCODE` varchar(10) NOT NULL,
  `23_01` varchar(5) DEFAULT NULL,
  `24_01` varchar(5) DEFAULT NULL,
  `25_01` varchar(5) DEFAULT NULL,
  `26_01` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`USN`,`SUBCODE`),
  KEY `SUBCODE` (`SUBCODE`),
  CONSTRAINT `studentattendance_ibfk_1` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE,
  CONSTRAINT `studentattendance_ibfk_2` FOREIGN KEY (`SUBCODE`) REFERENCES `subjects` (`subcode`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentattendance`
--

LOCK TABLES `studentattendance` WRITE;
/*!40000 ALTER TABLE `studentattendance` DISABLE KEYS */;
INSERT INTO `studentattendance` VALUES ('4SF19CS178','18CIV59',NULL,NULL,NULL,NULL),('4SF19CS178','18CPC49',NULL,NULL,NULL,NULL),('4SF19CS178','18CS33',NULL,NULL,NULL,NULL),('4SF19CS178','18CS42',NULL,NULL,NULL,NULL),('4SF19CS178','18CS43',NULL,NULL,NULL,NULL),('4SF19CS178','18CS44',NULL,NULL,NULL,NULL),('4SF19CS178','18CS45',NULL,NULL,NULL,NULL),('4SF19CS178','18CS46',NULL,NULL,NULL,NULL),('4SF19CS178','18CS51',NULL,NULL,NULL,NULL),('4SF19CS178','18CS52',NULL,NULL,NULL,NULL),('4SF19CS178','18CS53',NULL,NULL,NULL,NULL),('4SF19CS178','18CS54',NULL,NULL,NULL,NULL),('4SF19CS178','18CS55',NULL,NULL,NULL,NULL),('4SF19CS178','18CS56',NULL,NULL,NULL,NULL),('4SF19CS178','18CS61',NULL,NULL,NULL,NULL),('4SF19CS178','18CS71','P',NULL,'P',NULL),('4SF19CS178','18CS81',NULL,NULL,NULL,NULL),('4SF19CS178','18CSL47',NULL,NULL,NULL,NULL),('4SF19CS178','18CSL48',NULL,NULL,NULL,NULL),('4SF19CS178','18CSL57',NULL,NULL,NULL,NULL),('4SF19CS178','18CSL58',NULL,NULL,NULL,NULL),('4SF19CS178','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS004','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS004','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS004','18CS33',NULL,NULL,NULL,NULL),('4SF20CS004','18CS42',NULL,NULL,NULL,NULL),('4SF20CS004','18CS43',NULL,NULL,NULL,NULL),('4SF20CS004','18CS44',NULL,NULL,NULL,NULL),('4SF20CS004','18CS45',NULL,NULL,NULL,NULL),('4SF20CS004','18CS46',NULL,NULL,NULL,NULL),('4SF20CS004','18CS51',NULL,NULL,NULL,NULL),('4SF20CS004','18CS52',NULL,NULL,NULL,NULL),('4SF20CS004','18CS53',NULL,NULL,NULL,NULL),('4SF20CS004','18CS54',NULL,NULL,NULL,NULL),('4SF20CS004','18CS55','P','AB','P','P'),('4SF20CS004','18CS56',NULL,NULL,NULL,NULL),('4SF20CS004','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS004','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS004','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS004','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS004','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS005','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS005','18CS33',NULL,NULL,NULL,NULL),('4SF20CS005','18CS42',NULL,NULL,NULL,NULL),('4SF20CS005','18CS43',NULL,NULL,NULL,NULL),('4SF20CS005','18CS44',NULL,NULL,NULL,NULL),('4SF20CS005','18CS45',NULL,NULL,NULL,NULL),('4SF20CS005','18CS46',NULL,NULL,NULL,NULL),('4SF20CS005','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS005','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS005','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS007','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS007','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS007','18CS33',NULL,NULL,NULL,NULL),('4SF20CS007','18CS42',NULL,NULL,NULL,NULL),('4SF20CS007','18CS43',NULL,NULL,NULL,NULL),('4SF20CS007','18CS44',NULL,NULL,NULL,NULL),('4SF20CS007','18CS45',NULL,NULL,NULL,NULL),('4SF20CS007','18CS46',NULL,NULL,NULL,NULL),('4SF20CS007','18CS51',NULL,NULL,NULL,NULL),('4SF20CS007','18CS52',NULL,NULL,NULL,NULL),('4SF20CS007','18CS53',NULL,NULL,NULL,NULL),('4SF20CS007','18CS54',NULL,NULL,NULL,NULL),('4SF20CS007','18CS55','AB','P','P','AB'),('4SF20CS007','18CS56',NULL,NULL,NULL,NULL),('4SF20CS007','18CS61',NULL,NULL,NULL,NULL),('4SF20CS007','18CS71',NULL,NULL,NULL,NULL),('4SF20CS007','18CS81',NULL,NULL,NULL,NULL),('4SF20CS007','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS007','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS007','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS007','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS007','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS010','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS010','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS010','18CS33',NULL,NULL,NULL,NULL),('4SF20CS010','18CS42',NULL,NULL,NULL,NULL),('4SF20CS010','18CS43',NULL,NULL,NULL,NULL),('4SF20CS010','18CS44',NULL,'P',NULL,NULL),('4SF20CS010','18CS45',NULL,NULL,NULL,NULL),('4SF20CS010','18CS46',NULL,NULL,NULL,NULL),('4SF20CS010','18CS51',NULL,NULL,NULL,NULL),('4SF20CS010','18CS52',NULL,NULL,NULL,NULL),('4SF20CS010','18CS53',NULL,NULL,NULL,NULL),('4SF20CS010','18CS54',NULL,NULL,NULL,NULL),('4SF20CS010','18CS55',NULL,NULL,NULL,NULL),('4SF20CS010','18CS56',NULL,NULL,NULL,NULL),('4SF20CS010','18CS61',NULL,NULL,NULL,NULL),('4SF20CS010','18CS71',NULL,NULL,NULL,NULL),('4SF20CS010','18CS81',NULL,NULL,NULL,NULL),('4SF20CS010','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS010','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS010','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS010','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS010','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS030','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS030','18CS33',NULL,NULL,NULL,NULL),('4SF20CS030','18CS42',NULL,NULL,NULL,NULL),('4SF20CS030','18CS43',NULL,NULL,NULL,NULL),('4SF20CS030','18CS44',NULL,NULL,NULL,NULL),('4SF20CS030','18CS45',NULL,NULL,NULL,NULL),('4SF20CS030','18CS46',NULL,NULL,NULL,NULL),('4SF20CS030','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS030','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS030','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS034','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS034','18CS33',NULL,NULL,NULL,NULL),('4SF20CS034','18CS42',NULL,NULL,NULL,NULL),('4SF20CS034','18CS43',NULL,NULL,NULL,NULL),('4SF20CS034','18CS44',NULL,NULL,NULL,NULL),('4SF20CS034','18CS45',NULL,NULL,NULL,NULL),('4SF20CS034','18CS46',NULL,NULL,NULL,NULL),('4SF20CS034','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS034','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS034','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS056','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS056','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS056','18CS33',NULL,NULL,NULL,NULL),('4SF20CS056','18CS42',NULL,NULL,NULL,NULL),('4SF20CS056','18CS43',NULL,NULL,NULL,NULL),('4SF20CS056','18CS44',NULL,NULL,NULL,NULL),('4SF20CS056','18CS45',NULL,NULL,NULL,NULL),('4SF20CS056','18CS46',NULL,NULL,NULL,NULL),('4SF20CS056','18CS51',NULL,NULL,NULL,NULL),('4SF20CS056','18CS52',NULL,NULL,NULL,NULL),('4SF20CS056','18CS53',NULL,NULL,NULL,NULL),('4SF20CS056','18CS54',NULL,NULL,NULL,NULL),('4SF20CS056','18CS55',NULL,NULL,'AB','P'),('4SF20CS056','18CS56',NULL,NULL,NULL,NULL),('4SF20CS056','18CS61',NULL,NULL,NULL,NULL),('4SF20CS056','18CS71',NULL,NULL,NULL,NULL),('4SF20CS056','18CS81',NULL,NULL,NULL,NULL),('4SF20CS056','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS056','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS056','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS056','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS056','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS056','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS056','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS068','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS068','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS068','18CS33',NULL,NULL,NULL,NULL),('4SF20CS068','18CS42',NULL,NULL,NULL,NULL),('4SF20CS068','18CS43',NULL,NULL,NULL,NULL),('4SF20CS068','18CS44',NULL,NULL,NULL,NULL),('4SF20CS068','18CS45',NULL,NULL,NULL,NULL),('4SF20CS068','18CS46',NULL,NULL,NULL,NULL),('4SF20CS068','18CS51',NULL,NULL,NULL,NULL),('4SF20CS068','18CS52',NULL,NULL,NULL,NULL),('4SF20CS068','18CS53',NULL,NULL,NULL,NULL),('4SF20CS068','18CS54',NULL,NULL,NULL,NULL),('4SF20CS068','18CS55',NULL,NULL,'P','P'),('4SF20CS068','18CS56',NULL,NULL,NULL,NULL),('4SF20CS068','18CS61',NULL,NULL,NULL,NULL),('4SF20CS068','18CS71',NULL,NULL,NULL,NULL),('4SF20CS068','18CS81',NULL,NULL,NULL,NULL),('4SF20CS068','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS068','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS068','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS068','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS068','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS068','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS068','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS093','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS093','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS093','18CS33',NULL,NULL,NULL,NULL),('4SF20CS093','18CS42',NULL,NULL,NULL,NULL),('4SF20CS093','18CS43',NULL,NULL,NULL,NULL),('4SF20CS093','18CS44',NULL,NULL,NULL,NULL),('4SF20CS093','18CS45',NULL,NULL,NULL,NULL),('4SF20CS093','18CS46',NULL,NULL,NULL,NULL),('4SF20CS093','18CS51',NULL,NULL,NULL,NULL),('4SF20CS093','18CS52',NULL,NULL,NULL,NULL),('4SF20CS093','18CS53',NULL,NULL,NULL,NULL),('4SF20CS093','18CS54',NULL,NULL,NULL,NULL),('4SF20CS093','18CS55',NULL,NULL,'P','P'),('4SF20CS093','18CS56',NULL,NULL,NULL,NULL),('4SF20CS093','18CS61',NULL,NULL,NULL,NULL),('4SF20CS093','18CS71',NULL,NULL,NULL,NULL),('4SF20CS093','18CS81',NULL,NULL,NULL,NULL),('4SF20CS093','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS093','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS093','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS093','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS093','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS134','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS134','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS134','18CS33',NULL,NULL,NULL,NULL),('4SF20CS134','18CS42',NULL,NULL,NULL,NULL),('4SF20CS134','18CS43',NULL,NULL,NULL,NULL),('4SF20CS134','18CS44',NULL,NULL,NULL,NULL),('4SF20CS134','18CS45',NULL,NULL,NULL,NULL),('4SF20CS134','18CS46',NULL,NULL,NULL,NULL),('4SF20CS134','18CS51',NULL,NULL,NULL,NULL),('4SF20CS134','18CS52',NULL,NULL,NULL,NULL),('4SF20CS134','18CS53',NULL,NULL,NULL,NULL),('4SF20CS134','18CS54',NULL,NULL,NULL,NULL),('4SF20CS134','18CS55',NULL,NULL,'P','P'),('4SF20CS134','18CS56',NULL,NULL,NULL,NULL),('4SF20CS134','18CS61',NULL,NULL,NULL,NULL),('4SF20CS134','18CS71',NULL,NULL,NULL,NULL),('4SF20CS134','18CS81',NULL,NULL,NULL,NULL),('4SF20CS134','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS134','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS134','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS134','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS134','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS134','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS134','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS146','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS146','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS146','18CS32',NULL,NULL,NULL,NULL),('4SF20CS146','18CS33',NULL,NULL,NULL,NULL),('4SF20CS146','18CS42',NULL,NULL,NULL,NULL),('4SF20CS146','18CS43',NULL,NULL,NULL,NULL),('4SF20CS146','18CS44',NULL,NULL,NULL,NULL),('4SF20CS146','18CS45',NULL,NULL,NULL,NULL),('4SF20CS146','18CS46',NULL,NULL,NULL,NULL),('4SF20CS146','18CS51',NULL,NULL,NULL,NULL),('4SF20CS146','18CS52',NULL,NULL,NULL,NULL),('4SF20CS146','18CS53',NULL,NULL,NULL,NULL),('4SF20CS146','18CS54',NULL,NULL,NULL,NULL),('4SF20CS146','18CS55',NULL,NULL,'P','P'),('4SF20CS146','18CS56',NULL,NULL,NULL,NULL),('4SF20CS146','18CS61',NULL,NULL,NULL,NULL),('4SF20CS146','18CS71',NULL,NULL,NULL,NULL),('4SF20CS146','18CS81',NULL,NULL,NULL,NULL),('4SF20CS146','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS146','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS146','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS146','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS146','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS146','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS146','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS158','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS158','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS158','18CS33',NULL,NULL,NULL,NULL),('4SF20CS158','18CS42',NULL,NULL,NULL,NULL),('4SF20CS158','18CS43',NULL,NULL,NULL,NULL),('4SF20CS158','18CS44',NULL,NULL,NULL,NULL),('4SF20CS158','18CS45',NULL,NULL,NULL,NULL),('4SF20CS158','18CS46',NULL,NULL,NULL,NULL),('4SF20CS158','18CS51',NULL,NULL,NULL,NULL),('4SF20CS158','18CS52',NULL,NULL,NULL,NULL),('4SF20CS158','18CS53',NULL,NULL,NULL,NULL),('4SF20CS158','18CS54',NULL,NULL,NULL,NULL),('4SF20CS158','18CS55',NULL,NULL,'P','P'),('4SF20CS158','18CS56',NULL,NULL,NULL,NULL),('4SF20CS158','18CS61',NULL,NULL,NULL,NULL),('4SF20CS158','18CS71',NULL,NULL,NULL,NULL),('4SF20CS158','18CS81',NULL,NULL,NULL,NULL),('4SF20CS158','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS158','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS158','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS158','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS158','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS158','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS158','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS189','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS189','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS189','18CS33',NULL,NULL,NULL,NULL),('4SF20CS189','18CS42',NULL,NULL,NULL,NULL),('4SF20CS189','18CS43',NULL,NULL,NULL,NULL),('4SF20CS189','18CS44',NULL,NULL,NULL,NULL),('4SF20CS189','18CS45',NULL,NULL,NULL,NULL),('4SF20CS189','18CS46',NULL,NULL,NULL,NULL),('4SF20CS189','18CS51',NULL,NULL,NULL,NULL),('4SF20CS189','18CS52',NULL,NULL,NULL,NULL),('4SF20CS189','18CS53',NULL,NULL,NULL,NULL),('4SF20CS189','18CS54',NULL,NULL,NULL,NULL),('4SF20CS189','18CS55',NULL,NULL,'P','P'),('4SF20CS189','18CS56',NULL,NULL,NULL,NULL),('4SF20CS189','18CS61',NULL,NULL,NULL,NULL),('4SF20CS189','18CS71',NULL,NULL,NULL,NULL),('4SF20CS189','18CS81',NULL,NULL,NULL,NULL),('4SF20CS189','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS189','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS189','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS189','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS189','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS189','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS189','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS190','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS190','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS190','18CS33',NULL,NULL,NULL,NULL),('4SF20CS190','18CS42',NULL,NULL,NULL,NULL),('4SF20CS190','18CS43',NULL,NULL,NULL,NULL),('4SF20CS190','18CS44',NULL,NULL,NULL,NULL),('4SF20CS190','18CS45',NULL,NULL,NULL,NULL),('4SF20CS190','18CS46',NULL,NULL,NULL,NULL),('4SF20CS190','18CS51',NULL,NULL,NULL,NULL),('4SF20CS190','18CS52',NULL,NULL,NULL,NULL),('4SF20CS190','18CS53',NULL,NULL,NULL,NULL),('4SF20CS190','18CS54',NULL,NULL,NULL,NULL),('4SF20CS190','18CS55',NULL,NULL,'P','P'),('4SF20CS190','18CS56',NULL,NULL,NULL,NULL),('4SF20CS190','18CS61',NULL,NULL,NULL,NULL),('4SF20CS190','18CS71',NULL,NULL,NULL,NULL),('4SF20CS190','18CS81',NULL,NULL,NULL,NULL),('4SF20CS190','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS190','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS190','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS190','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS190','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS190','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS190','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS200','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS200','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS200','18CS33',NULL,NULL,NULL,NULL),('4SF20CS200','18CS42',NULL,NULL,NULL,NULL),('4SF20CS200','18CS43',NULL,NULL,NULL,NULL),('4SF20CS200','18CS44',NULL,NULL,NULL,NULL),('4SF20CS200','18CS45',NULL,NULL,NULL,NULL),('4SF20CS200','18CS46',NULL,NULL,NULL,NULL),('4SF20CS200','18CS51',NULL,NULL,NULL,NULL),('4SF20CS200','18CS52',NULL,NULL,NULL,NULL),('4SF20CS200','18CS53',NULL,NULL,NULL,NULL),('4SF20CS200','18CS54',NULL,NULL,NULL,NULL),('4SF20CS200','18CS55',NULL,NULL,'P','P'),('4SF20CS200','18CS56',NULL,NULL,NULL,NULL),('4SF20CS200','18CS61',NULL,NULL,NULL,NULL),('4SF20CS200','18CS71',NULL,NULL,NULL,NULL),('4SF20CS200','18CS81',NULL,NULL,NULL,NULL),('4SF20CS200','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS200','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS200','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS200','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS200','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS200','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS200','18PHY12',NULL,NULL,NULL,NULL),('4SF20CS424','18CIV59',NULL,NULL,NULL,NULL),('4SF20CS424','18CPC49',NULL,NULL,NULL,NULL),('4SF20CS424','18CS33',NULL,NULL,NULL,NULL),('4SF20CS424','18CS42',NULL,NULL,NULL,NULL),('4SF20CS424','18CS43',NULL,NULL,NULL,NULL),('4SF20CS424','18CS44',NULL,NULL,NULL,NULL),('4SF20CS424','18CS45',NULL,NULL,NULL,NULL),('4SF20CS424','18CS46',NULL,NULL,NULL,NULL),('4SF20CS424','18CS51',NULL,NULL,NULL,NULL),('4SF20CS424','18CS52',NULL,NULL,NULL,NULL),('4SF20CS424','18CS53',NULL,NULL,NULL,NULL),('4SF20CS424','18CS54',NULL,NULL,NULL,NULL),('4SF20CS424','18CS55',NULL,NULL,'P','P'),('4SF20CS424','18CS56',NULL,NULL,NULL,NULL),('4SF20CS424','18CS61',NULL,NULL,NULL,NULL),('4SF20CS424','18CS71',NULL,NULL,NULL,NULL),('4SF20CS424','18CS81',NULL,NULL,NULL,NULL),('4SF20CS424','18CSL47',NULL,NULL,NULL,NULL),('4SF20CS424','18CSL48',NULL,NULL,NULL,NULL),('4SF20CS424','18CSL57',NULL,NULL,NULL,NULL),('4SF20CS424','18CSL58',NULL,NULL,NULL,NULL),('4SF20CS424','18MAT11',NULL,NULL,NULL,NULL),('4SF20CS424','18MAT41',NULL,NULL,NULL,NULL),('4SF20CS424','18PHY12',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `studentattendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subcode` varchar(10) NOT NULL,
  `SNAME` varchar(15) NOT NULL,
  `DID` int NOT NULL,
  `SCHEME` int DEFAULT NULL,
  `SCREDITS` int DEFAULT NULL,
  `SEM` int NOT NULL,
  PRIMARY KEY (`subcode`),
  KEY `DID` (`DID`),
  CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`DID`) REFERENCES `department` (`DID`),
  CONSTRAINT `subjects_chk_1` CHECK ((`SEM` in (1,2,3,4,5,6,7,8)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('18CIV59','ENV',1,2018,1,5),('18CPC49','CPS',1,2018,1,4),('18CS32','DS',1,2018,4,3),('18CS33','ADE',1,2018,3,5),('18CS42','DAA',1,2018,4,4),('18CS43','OS',1,2018,3,4),('18CS44','MC',1,2018,3,4),('18CS45','OOC',1,2018,3,4),('18CS46','DC',1,2018,3,4),('18CS51','MGMT',1,2018,3,5),('18CS52','CNS',1,2018,4,5),('18CS53','DBMS',1,2018,4,5),('18CS54','ATC',1,2018,3,5),('18CS55','Python',1,2018,3,5),('18CS56','Unix',1,2018,3,5),('18CS61','SSC',1,2018,4,6),('18CS71','AIML',1,2018,4,7),('18CS81','IoT',1,2018,3,8),('18CSL47','DAA Lab',1,2018,2,4),('18CSL48','MC Lab',1,2018,2,4),('18CSL57','CNS Labb',1,2018,2,5),('18CSL58','DBMS LAB',1,2018,2,5),('18IS35','Information',2,2015,3,3),('18MAT11','Math-I',1,2018,3,1),('18MAT41','MATH-IV',1,2018,3,4),('18PHY12','Physics',1,2018,4,1);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaches`
--

DROP TABLE IF EXISTS `teaches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaches` (
  `SI_ID` varchar(10) NOT NULL,
  `FID` int NOT NULL,
  `SUBCODE` varchar(10) NOT NULL,
  `FAcademicYear` int NOT NULL,
  KEY `SI_ID` (`SI_ID`),
  KEY `FID` (`FID`),
  KEY `SUBCODE` (`SUBCODE`),
  CONSTRAINT `teaches_ibfk_1` FOREIGN KEY (`SI_ID`) REFERENCES `stud_info` (`SI_ID`),
  CONSTRAINT `teaches_ibfk_2` FOREIGN KEY (`FID`) REFERENCES `faculty` (`FID`),
  CONSTRAINT `teaches_ibfk_3` FOREIGN KEY (`SUBCODE`) REFERENCES `subjects` (`subcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaches`
--

LOCK TABLES `teaches` WRITE;
/*!40000 ALTER TABLE `teaches` DISABLE KEYS */;
INSERT INTO `teaches` VALUES ('20CS5C',2,'18CS55',2022),('20AI4A',5,'18CS44',2022),('20CS5A',3,'18CS54',2022),('20CS4C',2,'18CS44',2021),('19CS7B',2,'18CS71',2022),('19CS8B',3,'18CS81',2023),('21CS3A',2,'18CS32',2022),('20CS5C',6,'18CS51',2022),('20CS5C',7,'18CS52',2022),('20CS5C',8,'18CS53',2022),('20CS5C',10,'18CS54',2022),('20CS5C',9,'18CS56',2022),('20CS5C',7,'18CSL57',2022),('20CS5C',8,'18CSL58',2022),('20CS5C',11,'18CIV59',2022),('20CS4C',12,'18MAT41',2021),('20CS4C',13,'18CS42',2021),('20CS4C',14,'18CS43',2021),('20CS4C',4,'18CS45',2021),('20CS4C',9,'18CS46',2021),('20CS4C',13,'18CSL47',2021),('20CS4C',2,'18CSL48',2021),('20CS4C',16,'18CPC49',2021);
/*!40000 ALTER TABLE `teaches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-26 10:41:40
