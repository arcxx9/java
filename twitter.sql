CREATE DATABASE  IF NOT EXISTS `dbtwitter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbtwitter`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: dbtwitter
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
-- Table structure for table `follower`
--

DROP TABLE IF EXISTS `follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follower` (
  `username` varchar(40) NOT NULL,
  `follow` varchar(45) NOT NULL,
  PRIMARY KEY (`follow`),
  CONSTRAINT `username` FOREIGN KEY (`follow`) REFERENCES `utente` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
INSERT INTO `follower` VALUES ('gigino96','gigi98'),('gigino96','mario97');
/*!40000 ALTER TABLE `follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gioco`
--

DROP TABLE IF EXISTS `gioco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gioco` (
  `idgioco` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgioco`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gioco`
--

LOCK TABLES `gioco` WRITE;
/*!40000 ALTER TABLE `gioco` DISABLE KEYS */;
INSERT INTO `gioco` VALUES (1,'Poker','Gioco da Tavolo'),(2,'Monopoly','Multiplayer'),(3,'Scopa','Due Giocatori'),(4,'Scopone','4 Giocatori');
/*!40000 ALTER TABLE `gioco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messaggi`
--

DROP TABLE IF EXISTS `messaggi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messaggi` (
  `idmessaggi` int NOT NULL AUTO_INCREMENT,
  `inviato_user` varchar(45) DEFAULT NULL,
  `ricevuto_user` varchar(45) DEFAULT NULL,
  `testo` varchar(45) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idmessaggi`),
  KEY `inviato_user_idx` (`inviato_user`),
  KEY `ricevuto_user_idx` (`ricevuto_user`),
  CONSTRAINT `inviato_user` FOREIGN KEY (`inviato_user`) REFERENCES `utente` (`username`),
  CONSTRAINT `ricevuto_user` FOREIGN KEY (`ricevuto_user`) REFERENCES `utente` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messaggi`
--

LOCK TABLES `messaggi` WRITE;
/*!40000 ALTER TABLE `messaggi` DISABLE KEYS */;
INSERT INTO `messaggi` VALUES (1,'gigi98','gigino96','ciao','SMS'),(2,'gigino96','gigi98','oh','SMS'),(3,'gigi98','gigino96','ed','SMS'),(4,'gigino96','gigi98','ciao tutto bene come va?','Mail'),(5,'gigino96','gigi98','come va ?','Mail'),(6,'gigino96','mario97','21','SMS'),(7,'gigino96','mario97','ciao come va?','Mail');
/*!40000 ALTER TABLE `messaggi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partecipazione`
--

DROP TABLE IF EXISTS `partecipazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partecipazione` (
  `idpartecipazione` int NOT NULL AUTO_INCREMENT,
  `idTorneo` int DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `metododipagamento` varchar(45) DEFAULT NULL,
  `OrarioAcq` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idpartecipazione`),
  KEY `idTorneo_idx` (`idTorneo`),
  KEY `username_idx` (`username`),
  CONSTRAINT `idTorneo` FOREIGN KEY (`idTorneo`) REFERENCES `torneo` (`idtorneo`),
  CONSTRAINT `utente` FOREIGN KEY (`username`) REFERENCES `utente` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partecipazione`
--

LOCK TABLES `partecipazione` WRITE;
/*!40000 ALTER TABLE `partecipazione` DISABLE KEYS */;
INSERT INTO `partecipazione` VALUES (1,3,'gigino96','Contanti','2020-04-24 18:07:16'),(2,4,'gigino96','Contanti','2020-04-26 17:22:58');
/*!40000 ALTER TABLE `partecipazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `idpost` int NOT NULL AUTO_INCREMENT,
  `pubblicato` varchar(45) DEFAULT NULL,
  `testo` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`idpost`),
  KEY `pubblicato_idx` (`pubblicato`),
  CONSTRAINT `pubblicato` FOREIGN KEY (`pubblicato`) REFERENCES `utente` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (8,'gigino96','Ciao a tutti'),(9,'gigino96','Ciao a tutti come va'),(10,'gigino96','funziona?'),(11,'gigino96','non funziona sicuramente'),(12,'gigino96','ora funziona'),(13,'gigino96','tutti quanti'),(14,'gigino96','aedae'),(15,'gigino96','Sasdas'),(16,'gigino96','ciao prova'),(17,'gigino96','1232334'),(18,'mario97','1234');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneo`
--

DROP TABLE IF EXISTS `torneo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `torneo` (
  `idtorneo` int NOT NULL AUTO_INCREMENT,
  `idgioco` int DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `prezzo` float DEFAULT NULL,
  PRIMARY KEY (`idtorneo`),
  KEY `idgioco_idx` (`idgioco`),
  CONSTRAINT `idgioco` FOREIGN KEY (`idgioco`) REFERENCES `gioco` (`idgioco`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneo`
--

LOCK TABLES `torneo` WRITE;
/*!40000 ALTER TABLE `torneo` DISABLE KEYS */;
INSERT INTO `torneo` VALUES (1,2,'02-05-2020 20:00:00',10),(2,4,'30-04-2020 13:45:04',10),(3,1,'03-04-2020 19:30:00',10),(4,4,'05-05-2020 19:00:00',20);
/*!40000 ALTER TABLE `torneo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('mario','rossi','arcondo','arcondo',1),('gigi','esposito','gigi98','gigino',0),('luigi','rossi','gigino96','gigino96',0),('mario','esposito','mario97','mario97',0);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dbtwitter'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-29 20:29:51
