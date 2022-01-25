-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 103.82.242.16    Database: BookStoreDB_JonathanandShravan
-- ------------------------------------------------------
-- Server version	5.7.35-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book_identity`
--

DROP TABLE IF EXISTS `book_identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_identity` (
  `book_id` int(11) NOT NULL,
  `book_title` varchar(255) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_identity`
--

LOCK TABLES `book_identity` WRITE;
/*!40000 ALTER TABLE `book_identity` DISABLE KEYS */;
INSERT INTO `book_identity` VALUES (1,'Harry Potter and the Deadly Hollows',607,'Fantasy',17.71,100),(2,'Pirates of the Carribean',771,'Action',100.99,3),(3,'Da Vinci Code',689,'Action',99.99,200),(4,'Python Basics',1000,'Education',101,30),(5,'Your Name',400,'Romance',30.99,500),(6,'Sherlock Holmes Volume 1',1000,'Romance',59.99,500),(7,'Botchan',500,'Romance',50.78,200),(8,'Java Basics',1090,'Education',199.99,500);
/*!40000 ALTER TABLE `book_identity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-22 23:15:40
