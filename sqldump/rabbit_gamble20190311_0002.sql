-- MySQL dump 10.16  Distrib 10.1.31-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: rabbit_gamble
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `gbl_about`
--

DROP TABLE IF EXISTS `gbl_about`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gbl_about` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbl_about`
--

LOCK TABLES `gbl_about` WRITE;
/*!40000 ALTER TABLE `gbl_about` DISABLE KEYS */;
INSERT INTO `gbl_about` VALUES (1,'Gambling','0.1','2018-04-30 23:00:00','2018-04-30 23:00:00','manpakhong','manpakhong',NULL);
/*!40000 ALTER TABLE `gbl_about` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gbl_authorities`
--

DROP TABLE IF EXISTS `gbl_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gbl_authorities` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `role_id` int(11) NOT NULL,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbl_authorities`
--

LOCK TABLES `gbl_authorities` WRITE;
/*!40000 ALTER TABLE `gbl_authorities` DISABLE KEYS */;
INSERT INTO `gbl_authorities` VALUES (1,0,0,'2018-06-09 23:00:00','2018-06-09 23:00:00','system','system',NULL),(2,0,0,'2018-06-09 23:00:00','2018-06-09 23:00:00','root','root',NULL);
/*!40000 ALTER TABLE `gbl_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gbl_baccarat`
--

DROP TABLE IF EXISTS `gbl_baccarat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gbl_baccarat` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `session` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `round` int(11) unsigned DEFAULT NULL,
  `bank_player` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `result` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `odd_even` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `count` int(11) unsigned DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `updated_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbl_baccarat`
--

LOCK TABLES `gbl_baccarat` WRITE;
/*!40000 ALTER TABLE `gbl_baccarat` DISABLE KEYS */;
INSERT INTO `gbl_baccarat` VALUES (1,'2019-02-27 19:00:00','20190228',1,'B','BBB','Odd',3,'2019-02-28 18:45:18','2019-02-28 18:45:18','admin','admin'),(2,'2019-03-09 11:11:02','20190228',2,'P','PPPP','Event',4,'2019-02-28 18:57:44','2019-02-28 18:57:44','admin','admin'),(3,'2019-03-02 19:00:00','20190303',1,'B','BBBB','Event',4,'2019-03-02 20:47:30','2019-03-02 20:47:30','admin','admin'),(4,'2019-03-09 11:11:02','20190303',2,'P','PPPP','Event',4,'2019-03-02 20:47:57','2019-03-02 20:47:57','admin','admin'),(5,'2019-03-02 17:52:57','20190303',3,'B','BBBB','Event',4,'2019-03-02 20:51:51','2019-03-02 20:51:51','admin','admin'),(6,'2019-03-02 19:00:00','20190303',4,'P','PPPP','Event',4,'2019-03-02 20:53:11','2019-03-02 20:53:11','admin','admin'),(7,'2019-03-02 19:00:00','20190303',5,'B','B','Odd',1,'2019-03-02 20:54:33','2019-03-02 20:54:33','admin','admin'),(8,'2019-03-02 19:00:00','20190303',6,'P','P','Odd',1,'2019-03-02 20:55:48','2019-03-02 20:55:48','admin','admin'),(9,'2019-03-09 11:11:02','20190303',7,'B','B','Odd',1,'2019-03-02 20:56:29','2019-03-02 20:56:29','admin','admin'),(10,'2019-03-02 19:00:00','20190303',8,'P','PP','Event',2,'2019-03-02 20:57:05','2019-03-02 20:57:05','admin','admin'),(11,'2019-03-09 11:11:02','20190303',9,'B','BB','Event',2,'2019-03-02 20:57:56','2019-03-02 20:57:56','admin','admin'),(12,'2019-03-02 19:00:00','20190303',10,'P','PPP','Odd',3,'2019-03-02 20:59:18','2019-03-02 20:59:18','admin','admin'),(13,'2019-03-09 11:11:02','20190303',11,'B','BBB','Odd',3,'2019-03-02 21:01:56','2019-03-02 21:01:56','admin','admin'),(14,'2019-03-02 19:00:00','20190303',12,'P','PPP','Odd',3,'2019-03-02 21:04:10','2019-03-02 21:04:10','admin','admin'),(15,'2019-03-02 19:00:00','20190303',13,'B','BBBBBBB','Odd',7,'2019-03-02 22:23:08','2019-03-02 22:23:08','admin','admin'),(16,'2019-03-09 11:11:02','20190303',14,'P','PPP','Odd',3,'2019-03-03 12:25:30','2019-03-03 12:25:30','admin','admin'),(17,'2019-03-09 11:11:02','20190303',15,'B','BBB','Odd',3,'2019-03-03 12:26:47','2019-03-03 12:26:47','admin','admin'),(18,'2019-03-09 11:11:02','20190303',16,'P','PPPPPPPPPPPP','Odd',13,'2019-03-03 12:28:39','2019-03-03 12:28:39','admin','admin'),(19,'2019-03-02 19:00:00','20190303',17,'B','BBBBBBBBBB','Event',10,'2019-03-03 12:31:11','2019-03-03 12:31:11','admin','admin'),(20,'2019-03-09 11:11:02','20190303',18,'P','PPPPPPPPPPP','Odd',11,'2019-03-03 12:32:33','2019-03-03 12:32:33','admin','admin'),(21,'2019-03-02 19:00:00','20190303',19,'B','B','Odd',1,'2019-03-03 12:37:09','2019-03-03 12:37:09','admin','admin'),(22,'2019-03-02 19:00:00','20190303',20,'P','PPPP','Event',4,'2019-03-03 12:37:23','2019-03-03 12:37:23','admin','admin'),(23,'2019-03-02 19:00:00','20190303',21,'B','BBBBBB','Event',6,'2019-03-03 12:41:24','2019-03-03 12:41:24','admin','admin'),(24,'2019-03-09 11:11:02','20190303',22,'P','PPPPPPPPPPPP','Event',12,'2019-03-03 12:42:10','2019-03-03 12:42:10','admin','admin'),(25,'2019-03-02 19:00:00','20190303',23,'B','BBB','Odd',3,'2019-03-03 14:08:59','2019-03-03 14:08:59','admin','admin'),(26,'2019-03-02 19:00:00','20190303',24,'P','PPPP','Event',4,'2019-03-03 14:09:52','2019-03-03 14:09:52','admin','admin'),(27,'2019-03-02 19:00:00','20190303',25,'B','BBB','Odd',3,'2019-03-03 14:21:42','2019-03-03 14:21:42','admin','admin'),(28,'2019-03-05 19:00:00','20190306',1,'B','BBB','Odd',3,'2019-03-05 20:22:05','2019-03-05 20:22:05','admin','admin'),(29,'2019-03-05 19:00:00','20190306',2,'P','PPP','Odd',3,'2019-03-05 20:23:48','2019-03-05 20:23:48','admin','admin'),(30,'2019-03-05 19:00:00','20190306',3,'B','BBB','Odd',3,'2019-03-05 20:25:16','2019-03-05 20:25:16','admin','admin'),(31,'2019-03-05 19:00:00','20190306',4,'B','BBBBBBB','Odd',7,'2019-03-05 20:26:09','2019-03-05 20:26:09','admin','admin'),(32,'2019-03-05 19:00:00','20190306',5,'P','PPPPP','Odd',5,'2019-03-05 20:26:27','2019-03-05 20:26:27','admin','admin'),(33,'2019-03-05 17:34:56','20190306',6,'B','BBB','Odd',3,'2019-03-05 20:33:50','2019-03-05 20:33:50','admin','admin'),(34,'2019-03-09 11:11:02','20190306',7,'P','PPPP','Event',4,'2019-03-05 20:35:03','2019-03-05 20:35:03','admin','admin'),(35,'2019-03-09 11:11:02','20190306',8,'B','BBBB','Event',4,'2019-03-05 20:35:21','2019-03-05 20:35:21','admin','admin'),(36,'2019-03-05 19:00:00','20190306',9,'P','PPPPPPP','Odd',7,'2019-03-05 20:35:40','2019-03-05 20:35:40','admin','admin'),(37,'2019-03-10 04:51:57','20190307',1,'B','BB','Event',2,'2019-03-07 18:45:22','2019-03-07 18:45:22','admin','admin'),(40,'2019-03-09 19:00:00','20190310',1,'P','PPPPP','Odd',5,'2019-03-10 18:20:52','2019-03-10 18:20:52','admin','admin'),(41,'2019-03-09 19:00:00','20190310',2,'B','BBBBBBBBBBBBBBBBB','Odd',17,'2019-03-10 18:26:04','2019-03-10 18:26:04','admin','admin'),(42,'2019-03-09 19:00:00','20190310',3,'P','P','Odd',1,'2019-03-10 18:26:53','2019-03-10 18:26:53','admin','admin'),(43,'2019-03-09 19:00:00','20190310',4,'B','BBBB','Event',4,'2019-03-10 18:29:20','2019-03-10 18:29:20','admin','admin'),(44,'2019-03-09 19:00:00','20190310',5,'P','PPP','Odd',3,'2019-03-10 18:31:59','2019-03-10 18:31:59','admin','admin'),(45,'2019-03-09 19:00:00','20190310',6,'B','BB','Event',2,'2019-03-10 18:37:35','2019-03-10 18:37:35','admin','admin'),(46,'2019-03-09 19:00:00','20190310',7,'P','PPPPP','Odd',5,'2019-03-10 18:37:44','2019-03-10 18:37:44','admin','admin'),(47,'2019-03-09 19:00:00','20190310',8,'B','BBBBBB','Event',6,'2019-03-10 18:37:52','2019-03-10 18:37:52','admin','admin'),(48,'2019-03-09 19:00:00','20190310',9,'P','P','Odd',1,'2019-03-10 18:38:01','2019-03-10 18:38:01','admin','admin'),(49,'2019-03-09 19:00:00','20190310',10,'B','BB','Event',2,'2019-03-10 18:38:07','2019-03-10 18:38:07','admin','admin'),(50,'2019-03-09 19:00:00','20190310',11,'P','P','Odd',1,'2019-03-10 18:38:14','2019-03-10 18:38:14','admin','admin'),(51,'2019-03-09 19:00:00','20190310',12,'B','B','Odd',1,'2019-03-10 18:38:18','2019-03-10 18:38:18','admin','admin'),(52,'2019-03-09 19:00:00','20190310',13,'P','P','Odd',1,'2019-03-10 18:38:23','2019-03-10 18:38:23','admin','admin'),(53,'2019-03-09 19:00:00','20190310',14,'B','BBBB','Event',4,'2019-03-10 18:38:28','2019-03-10 18:38:28','admin','admin'),(54,'2019-03-09 19:00:00','20190310',15,'P','PP','Event',2,'2019-03-10 18:38:34','2019-03-10 18:38:34','admin','admin'),(55,'2019-03-09 19:00:00','20190310',16,'B','B','Odd',1,'2019-03-10 18:52:25','2019-03-10 18:52:25','admin','admin'),(56,'2019-03-09 19:00:00','20190310',17,'P','P','Odd',1,'2019-03-10 18:53:06','2019-03-10 18:53:06','admin','admin'),(57,'2019-03-09 19:00:00','20190310',18,'B','B','Odd',1,'2019-03-10 18:53:16','2019-03-10 18:53:16','admin','admin'),(58,'2019-03-09 19:00:00','20190310',19,'P','P','Odd',1,'2019-03-10 18:53:25','2019-03-10 18:53:25','admin','admin'),(59,'2019-03-09 19:00:00','20190310',20,'B','B','Odd',1,'2019-03-10 18:53:38','2019-03-10 18:53:38','admin','admin'),(60,'2019-03-09 19:00:00','20190310',21,'P','PPP','Odd',3,'2019-03-10 18:53:44','2019-03-10 18:53:44','admin','admin'),(61,'2019-03-09 19:00:00','20190310',22,'B','B','Odd',1,'2019-03-10 18:56:33','2019-03-10 18:56:33','admin','admin'),(62,'2019-03-09 19:00:00','20190310',23,'P','PP','Event',2,'2019-03-10 18:56:39','2019-03-10 18:56:39','admin','admin'),(63,'2019-03-09 19:00:00','20190310',24,'B','BBBB','Event',4,'2019-03-10 18:56:45','2019-03-10 18:56:45','admin','admin'),(64,'2019-03-09 19:00:00','20190310',25,'P','PPPP','Event',4,'2019-03-10 18:56:54','2019-03-10 18:56:54','admin','admin'),(65,'2019-03-09 19:00:00','20190310',26,'B','B','Odd',1,'2019-03-10 18:57:19','2019-03-10 18:57:19','admin','admin'),(66,'2019-03-09 19:00:00','20190310',27,'P','PP','Event',2,'2019-03-10 18:57:27','2019-03-10 18:57:27','admin','admin'),(67,'2019-03-09 19:00:00','20190310',28,'B','B','Odd',1,'2019-03-10 18:57:35','2019-03-10 18:57:35','admin','admin'),(68,'2019-03-09 19:00:00','20190310',29,'P','PPPPP','Odd',5,'2019-03-10 18:57:42','2019-03-10 18:57:42','admin','admin'),(69,'2019-03-09 19:00:00','20190310',30,'B','BBBB','Event',4,'2019-03-10 18:57:50','2019-03-10 18:57:50','admin','admin');
/*!40000 ALTER TABLE `gbl_baccarat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gbl_big_small`
--

DROP TABLE IF EXISTS `gbl_big_small`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gbl_big_small` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `round` varchar(255) NOT NULL,
  `point` int(11) DEFAULT NULL,
  `result` varchar(255) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `bank_player` varchar(45) DEFAULT NULL,
  `count` int(11) unsigned DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `odd_even` varchar(45) DEFAULT NULL,
  `session` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbl_big_small`
--

LOCK TABLES `gbl_big_small` WRITE;
/*!40000 ALTER TABLE `gbl_big_small` DISABLE KEYS */;
INSERT INTO `gbl_big_small` VALUES (1,'1',NULL,'big','2018-06-17 10:25:18','2018-05-03 23:00:00','','',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(2,'2',NULL,'big','2018-06-17 10:25:18','2018-05-03 23:01:00','','',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(3,'3',NULL,'big','2018-06-17 10:25:18','2018-05-03 23:03:00','','',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(4,'4',NULL,'small','2018-06-17 10:25:18','2018-05-03 23:04:00','','',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(5,'5',NULL,'small','2018-06-17 10:25:18','2018-05-03 23:05:00','','',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(6,'6',13,'big','2018-08-18 10:26:00','2018-08-18 10:26:00','admin','admin',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(7,'7',15,'big','2019-02-17 18:23:41','2019-02-17 18:23:41','admin','admin',NULL,NULL,NULL,'2019-02-17 23:35:31',NULL,NULL),(8,'8',15,'big','2019-02-17 19:00:35','2019-02-17 19:00:35','admin','admin',NULL,NULL,NULL,'2019-02-18 00:00:35',NULL,NULL);
/*!40000 ALTER TABLE `gbl_big_small` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gbl_role`
--

DROP TABLE IF EXISTS `gbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gbl_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_by` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbl_role`
--

LOCK TABLES `gbl_role` WRITE;
/*!40000 ALTER TABLE `gbl_role` DISABLE KEYS */;
INSERT INTO `gbl_role` VALUES (1,'sysadm','System Administrator','system root user','2018-06-09 23:00:00','2018-06-09 23:00:00','manpakhong','manpakhong',NULL);
/*!40000 ALTER TABLE `gbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gbl_user`
--

DROP TABLE IF EXISTS `gbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gbl_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(255) COLLATE utf8_bin NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(255) COLLATE utf8_bin NOT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gbl_user`
--

LOCK TABLES `gbl_user` WRITE;
/*!40000 ALTER TABLE `gbl_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `gbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t1`
--

DROP TABLE IF EXISTS `t1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t1` (
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t1`
--

LOCK TABLES `t1` WRITE;
/*!40000 ALTER TABLE `t1` DISABLE KEYS */;
/*!40000 ALTER TABLE `t1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-11  0:03:07
