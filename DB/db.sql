-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: characterstats
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `enemy`
--

DROP TABLE IF EXISTS `enemy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enemy` (
  `enemy_id` char(3) NOT NULL,
  `enemy_name` varchar(10) NOT NULL,
  `enemy_idSprite` char(3) NOT NULL,
  `enemy_sprite` varchar(30) NOT NULL,
  `enemy_hp` int NOT NULL,
  `enemy_defense` int NOT NULL,
  `enemy_atk` int NOT NULL,
  `enemy_stamina` int NOT NULL,
  PRIMARY KEY (`enemy_name`),
  UNIQUE KEY `enemy_idSprite` (`enemy_idSprite`),
  KEY `enemy_id` (`enemy_id`),
  CONSTRAINT `enemy_ibfk_1` FOREIGN KEY (`enemy_id`) REFERENCES `stats` (`id`),
  CONSTRAINT `enemy_ibfk_2` FOREIGN KEY (`enemy_idSprite`) REFERENCES `entitysprite` (`sprite_id`),
  CONSTRAINT `enemy_chk_1` CHECK ((`enemy_hp` >= 50))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enemy`
--

LOCK TABLES `enemy` WRITE;
/*!40000 ALTER TABLE `enemy` DISABLE KEYS */;
/*!40000 ALTER TABLE `enemy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entitysprite`
--

DROP TABLE IF EXISTS `entitysprite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entitysprite` (
  `sprite_id` char(3) NOT NULL,
  `worldX` int NOT NULL,
  `worldY` int NOT NULL,
  `sprite1` varchar(30) NOT NULL,
  `sprite2` varchar(30) NOT NULL,
  `sprite3` varchar(30) NOT NULL,
  `sprite4` varchar(30) NOT NULL,
  PRIMARY KEY (`sprite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entitysprite`
--

LOCK TABLES `entitysprite` WRITE;
/*!40000 ALTER TABLE `entitysprite` DISABLE KEYS */;
/*!40000 ALTER TABLE `entitysprite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero`
--

DROP TABLE IF EXISTS `hero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hero` (
  `hero_id` char(3) NOT NULL,
  `hero_name` varchar(10) NOT NULL,
  `hero_idSprite` char(3) NOT NULL,
  `hero_sprite` varchar(30) NOT NULL,
  `hero_hp` int NOT NULL,
  `hero_defense` int NOT NULL,
  `hero_atk` int NOT NULL,
  `hero_stamina` int NOT NULL,
  PRIMARY KEY (`hero_name`),
  UNIQUE KEY `hero_idSprite` (`hero_idSprite`),
  KEY `hero_id` (`hero_id`),
  CONSTRAINT `hero_ibfk_1` FOREIGN KEY (`hero_id`) REFERENCES `stats` (`id`),
  CONSTRAINT `hero_ibfk_2` FOREIGN KEY (`hero_idSprite`) REFERENCES `entitysprite` (`sprite_id`),
  CONSTRAINT `hero_chk_1` CHECK ((`hero_hp` >= 50))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero`
--

LOCK TABLES `hero` WRITE;
/*!40000 ALTER TABLE `hero` DISABLE KEYS */;
/*!40000 ALTER TABLE `hero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `npc`
--

DROP TABLE IF EXISTS `npc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `npc` (
  `npc_id` char(3) NOT NULL,
  `npc_idDialogue` char(3) NOT NULL,
  `npc_idSprite` char(3) NOT NULL,
  `npc_sprite` varchar(30) NOT NULL,
  `npc_dialogue` varchar(100) DEFAULT NULL,
  `option1` varchar(10) NOT NULL,
  `option2` varchar(10) NOT NULL,
  PRIMARY KEY (`npc_id`),
  UNIQUE KEY `npc_idSprite` (`npc_idSprite`),
  UNIQUE KEY `npc_dialogue` (`npc_dialogue`),
  KEY `npc_idDialogue` (`npc_idDialogue`),
  CONSTRAINT `npc_ibfk_1` FOREIGN KEY (`npc_idDialogue`) REFERENCES `plot` (`id_dialogue`),
  CONSTRAINT `npc_ibfk_2` FOREIGN KEY (`npc_idSprite`) REFERENCES `entitysprite` (`sprite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `npc`
--

LOCK TABLES `npc` WRITE;
/*!40000 ALTER TABLE `npc` DISABLE KEYS */;
/*!40000 ALTER TABLE `npc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plot`
--

DROP TABLE IF EXISTS `plot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plot` (
  `id_dialogue` char(3) NOT NULL,
  `dialogue_iconPath` varchar(100) NOT NULL,
  `dialogue` varchar(100) NOT NULL,
  PRIMARY KEY (`id_dialogue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plot`
--

LOCK TABLES `plot` WRITE;
/*!40000 ALTER TABLE `plot` DISABLE KEYS */;
/*!40000 ALTER TABLE `plot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stats`
--

DROP TABLE IF EXISTS `stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stats` (
  `id` char(3) NOT NULL,
  `hp` int NOT NULL,
  `defense` int NOT NULL,
  `atk` int NOT NULL,
  `stamina` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stats`
--

LOCK TABLES `stats` WRITE;
/*!40000 ALTER TABLE `stats` DISABLE KEYS */;
/*!40000 ALTER TABLE `stats` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-03 12:55:32
