-- MySQL dump 10.13  Distrib 5.6.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mobile_store
-- ------------------------------------------------------
-- Server version	5.6.31-0ubuntu0.15.10.1

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
-- Table structure for table `mobile_specs`
--

DROP TABLE IF EXISTS `mobile_specs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mobile_specs` (
  `slno` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(50) DEFAULT NULL,
  `mobile_name` varchar(50) DEFAULT NULL,
  `specs` varchar(2000) CHARACTER SET utf8 DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL,
  `screen_size` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `camera_front` int(11) DEFAULT NULL,
  `camera_rear` int(11) DEFAULT NULL,
  `pics` varchar(100) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`slno`),
  UNIQUE KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile_specs`
--

LOCK TABLES `mobile_specs` WRITE;
/*!40000 ALTER TABLE `mobile_specs` DISABLE KEYS */;
INSERT INTO `mobile_specs` VALUES (1,'mob001','xiomi redmi 2 prime','2 gb ram, 8 gb rom, quad core processor,4.7 inch screen,2200maH battery','xiomi','4.7\'',6999,0,2,8,'images/mob001.jpg',0),(3,'mob002','micromax canvas xl2 A109','1 gb ram, 10 gb rom,5.5 inch screen,2500maH battery','micromax','5.5\'',9999,10,2,5,'images/mob002.jpg',10),(4,'mob003','LG G3 Stylus','2 gb ram, 4 gb rom, quad core processor,5.5 inch screen,2500maH battery','LG','5.5\'',14999,0,1,13,'images/mob003.jpg',10),(5,'mob004','xiomi redmi 3','2 gb ram, 16 gb rom, quad core processor,5.5 inch screen,4000maH battery','xiomi','5.5',9999,0,5,16,'images/mob004.jpg',10),(7,'mob005','xiomi redmi 3s','3 gb ram, 16 gb rom, snapdragon430,5.0 inch screen,4100maH battery','xiomi','5.0',9999,0,5,13,'images/mob005.jpg',10),(8,'mob006','xiomi mi 4','3 gb ram, 16/64 gb rom, snapdragon430,5.0 inch screen,3080maH battery','xiomi','5.0',10999,0,5,13,'images/mob006.jpg',10),(10,'mob007','LG G5','4 gb ram, 32 gb rom, snap dragon 820,5.5 inch screen,2800maH battery','LG','5.3\'',20999,0,5,13,'images/mob007.jpg',10),(11,'mob008','LG G4','3 gb ram, 32 gb rom, snap dragon 808,5.5 inch screen,3000maH battery','LG','5.5\'',14442,0,5,16,'images/mob008.jpg',10);
/*!40000 ALTER TABLE `mobile_specs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-10 11:36:47
