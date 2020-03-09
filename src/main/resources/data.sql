-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movies_db
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (101,'Ryan Gosling'),(102,'Emma Stone'),(103,'Daisy Ridley'),(104,'Joaquin Phoenix'),(105,'Scarlett Johansson'),(106,'Adam Sandler'),(107,'Ethan Hawke'),(108,'Vin Diesel'),(109,'Amy Adams'),(110,'Adam Driver');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (101,'Jorge','34351354','jorge123'),(102,'Carlos','54654131','cc'),(103,'Mario','45444864','mabc'),(104,'Ignacio','24448868','igg'),(105,'Hugo','12312325','hh'),(106,'MonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonicaMonica','21332534','mca'),(107,'FernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernandaFernanda','75343554','fba'),(108,'AliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAliciaAlicia','54654854','alice'),(109,'RaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquelRaquel','43454515','raq'),(110,'IsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabelIsabel','45343544','isa');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL,
  `deleted` bit(1) NOT NULL,
  `description` varchar(255) NOT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `year` datetime(6) NOT NULL,
  `registering_user` int DEFAULT NULL,
  `updating_user` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqljphq29q3b6vpc156g3akwq8` (`registering_user`),
  KEY `FKmoi5thmlx3iolvbi2ufndk4cw` (`updating_user`),
  CONSTRAINT `FKmoi5thmlx3iolvbi2ufndk4cw` FOREIGN KEY (`updating_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqljphq29q3b6vpc156g3akwq8` FOREIGN KEY (`registering_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (101,_binary '','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','G','La La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La LandLa La Land','2016-01-01 00:00:00.000000',101,101),(102,_binary '\0','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','R','JokerJokerJokerJokerJokerJokerJokerJokerJokerJokerJokerJokerJokerJokerJokerJoker','2015-01-01 00:00:00.000000',101,104),(103,_binary '','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','R','FirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstManFirstMan','2003-01-01 00:00:00.000000',102,101),(104,_binary '\0','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','G','Star WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar WarsStar Wars','2001-01-01 00:00:00.000000',105,103),(105,_binary '','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','NC-17','Blade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade RunnerBlade Runner','1995-01-01 00:00:00.000000',107,101),(106,_binary '\0','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','G','First ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst ReformedFirst Reformed','1997-01-01 00:00:00.000000',102,105),(107,_binary '','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','PG-13','Fast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and FuriousFast and Furious','1990-01-01 00:00:00.000000',101,105),(108,_binary '\0','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','G','Spider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-ManSpider-Man','2020-01-01 00:00:00.000000',105,104),(109,_binary '','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','PG-13','SplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplitSplit','2019-01-01 00:00:00.000000',102,103),(110,_binary '\0','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','NC-17','InsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOutInsideOut','2018-01-01 00:00:00.000000',105,104);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_actor` (
  `movie_id` int NOT NULL,
  `actor_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`actor_id`),
  KEY `FK69qnqd5hnjn2aykvxcj72r9i5` (`actor_id`),
  CONSTRAINT `FK69qnqd5hnjn2aykvxcj72r9i5` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`),
  CONSTRAINT `FKhedvt8u16luotgyoel4fqy7t1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
INSERT INTO `movie_actor` VALUES (101,101),(102,101),(102,102),(104,102),(104,103),(106,103),(106,104),(108,104),(108,105),(110,105),(101,106),(110,106),(101,107),(103,107),(103,108),(105,108),(105,109),(107,109),(107,110),(109,110);
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_catalog`
--

DROP TABLE IF EXISTS `movie_catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_catalog` (
  `movie_id` int NOT NULL,
  `number_of_copies` int NOT NULL,
  `price_id` int NOT NULL,
  PRIMARY KEY (`movie_id`),
  KEY `FKfl9h3d7tsk7boe9nji716x7x8` (`price_id`),
  CONSTRAINT `FKfl9h3d7tsk7boe9nji716x7x8` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`),
  CONSTRAINT `FKi9yf5xepcva2mf10i2g98d14d` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_catalog`
--

LOCK TABLES `movie_catalog` WRITE;
/*!40000 ALTER TABLE `movie_catalog` DISABLE KEYS */;
INSERT INTO `movie_catalog` VALUES (101,2,101),(102,2,106),(103,20,102),(104,3,107),(105,15,103),(106,6,101),(107,3,104),(108,8,102),(109,1,105);
/*!40000 ALTER TABLE `movie_catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_rental`
--

DROP TABLE IF EXISTS `movie_rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_rental` (
  `id` int NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `returned_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `to_return_date` datetime(6) DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `price_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKejxd1u2rykofdx7nd9b7uske2` (`member_id`),
  KEY `FKn4pn625o84xtdhgxidge4k1qj` (`movie_id`),
  KEY `FKhed5u4r76jv6ap9lwov93625` (`price_id`),
  CONSTRAINT `FKejxd1u2rykofdx7nd9b7uske2` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `FKhed5u4r76jv6ap9lwov93625` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`),
  CONSTRAINT `FKn4pn625o84xtdhgxidge4k1qj` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_rental`
--

LOCK TABLES `movie_rental` WRITE;
/*!40000 ALTER TABLE `movie_rental` DISABLE KEYS */;
INSERT INTO `movie_rental` VALUES (101,'2019-05-01 00:00:00.000000',NULL,'Rented','2019-07-15 00:00:00.000000',101,101,101),(102,'2019-05-01 00:00:00.000000','2019-06-05 00:00:00.000000','Returned','2019-07-15 00:00:00.000000',103,104,107),(103,'2019-05-01 00:00:00.000000',NULL,'Rented','2019-07-15 00:00:00.000000',105,106,101),(104,'2019-05-01 00:00:00.000000','2019-06-05 00:00:00.000000','Returned','2019-07-15 00:00:00.000000',107,103,102),(105,'2019-05-01 00:00:00.000000',NULL,'Rented','2019-07-15 00:00:00.000000',109,105,103),(106,'2019-05-01 00:00:00.000000',NULL,'Rented','2019-07-15 00:00:00.000000',102,107,104),(107,'2019-05-01 00:00:00.000000','2019-06-05 00:00:00.000000','Returned','2019-07-15 00:00:00.000000',104,102,106),(108,'2019-05-01 00:00:00.000000',NULL,'Rented','2019-07-15 00:00:00.000000',106,108,101),(109,'2019-05-01 00:00:00.000000','2019-06-05 00:00:00.000000','Returned','2019-07-15 00:00:00.000000',108,109,105),(110,'2019-05-01 00:00:00.000000',NULL,'Rented','2019-07-15 00:00:00.000000',110,109,105);
/*!40000 ALTER TABLE `movie_rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price` (
  `id` int NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (101,'2020-04-15 00:00:00.000000',10),(102,'2020-03-14 00:00:00.000000',25),(103,'2020-01-01 00:00:00.000000',40),(104,'2020-09-02 00:00:00.000000',100),(105,'2020-09-01 00:00:00.000000',20),(106,'2020-05-25 00:00:00.000000',60),(107,'2020-06-11 00:00:00.000000',40);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gj2fy3dcix7ph7k8684gka40c` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (101,'Alejandra'),(102,'Erika'),(103,'Juan'),(104,'Luis'),(105,'Marcelo'),(106,'Michelle'),(107,'Pedro');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-07 19:59:03
