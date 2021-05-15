-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qlns
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `de_id` int NOT NULL AUTO_INCREMENT,
  `de_name` varchar(255) DEFAULT NULL,
  `de_code` varchar(255) DEFAULT NULL,
  `de_desc` mediumtext,
  `client_list` tinyblob,
  PRIMARY KEY (`de_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (8,'Sales','SL25','Chuyên bán hàng ',NULL),(14,'Lập trình ','LT01','Thiết kế và phân tích hệ thống',NULL),(20,'Kế toán','KT20','Hoạch toán chi phí',NULL);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `em_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `general` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `result` mediumtext,
  `it` mediumtext,
  `language` varchar(255) DEFAULT NULL,
  `major` mediumtext,
  PRIMARY KEY (`em_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Hoàng Huy Đức','2000-02-16',1,'New York, New York, USA','2021-05-09','2021-05-15','demo','jk','anh','IT'),(2,'Nguyễn Bá Phúc','1998-05-22',0,'New York, New York, USA','2021-05-01','2021-05-15','Giai nhat huyen','Coco','Tiếng Nhật','Marketing chiến lược'),(3,'Nguyễn Thùy Dung','1999-05-22',1,'Thị trấn Thiên Cầm - Cẩm Xuyên - Hà Tĩnh','2021-05-01','2021-05-23','Code Fist War','city','Hàn','Bán hàng'),(4,'Hoàng Huy Đức','2000-02-16',0,'New York, New York, USA','2021-05-01','2021-05-27','demo','jk','anh','IT'),(5,'Nguyễn Khải','2021-05-20',0,'1487 Rocky Horse Carrefour Arlington, TX 16819','2021-05-15','2021-05-12','f','jk','anh','Marketing chiến lược'),(6,'Đỗ Văn Tú','1999-05-22',0,'New York, New York, USA','2021-05-07','2021-05-22','Code War giải nhất','Coco','Tiếng Nhật','Quản trị kinh doanh'),(7,'Hoàng Huy Đức','2021-05-21',1,'1487 Rocky Horse Carrefour Arlington, TX 16819','2021-05-13','2021-05-11','demo','jk','Tiếng Nhật','Quản trị kinh doanh'),(8,'News and Event','2021-05-11',0,'1487 Rocky Horse Carrefour Arlington, TX 16819','2021-05-28','2021-04-27','d','Coco','Tiếng Nhật','Marketing chiến lược'),(9,'Hoàng Huy Đức','2000-02-16',1,'New York, New York, USA','2021-05-01','2021-05-27','demo','jk','anh','IT'),(10,'Nguyễn Bá Phúc','1996-05-22',0,'New York, New York, USA','2021-05-13','2021-05-22','Giai nhat huyen','Coco','Tiếng Nhật','Marketing chiến lược'),(11,'demo date','2022-02-22',1,'New York, New York, USA','2021-05-09','2021-05-15','demo','jk','anh','IT'),(12,'demo date','2022-02-22',1,'New York, New York, USA','2021-05-09','2021-05-15','demo','jk','anh','IT'),(13,'Hoàng Huy Đức','2000-11-12',1,'New York, New York, USA','2022-10-09','2021-05-15','demo','jk','anh','IT'),(14,'Hoàng Huy Đức','2000-02-16',1,'New York, New York, USA','2021-05-09','2021-05-15','demo','jk','anh','IT'),(15,'Hoàng Huy Đức','2000-02-16',1,'New York, New York, USA','2021-05-09','2021-05-15','demo','jk','anh','IT'),(16,'Hoàng Huy Đức 2222','2000-09-05',1,'New York, New York, USA','2021-05-09','2023-03-04','demo','jk','anh','IT');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_department`
--

DROP TABLE IF EXISTS `employee_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_department` (
  `em_id` int NOT NULL,
  `de_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_employee_has_department_department1_idx` (`de_id`),
  KEY `fk_employee_has_department_employee1_idx` (`em_id`),
  CONSTRAINT `fk_employee_has_department_department1` FOREIGN KEY (`de_id`) REFERENCES `department` (`de_id`),
  CONSTRAINT `fk_employee_has_department_employee1` FOREIGN KEY (`em_id`) REFERENCES `employee` (`em_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_department`
--

LOCK TABLES `employee_department` WRITE;
/*!40000 ALTER TABLE `employee_department` DISABLE KEYS */;
INSERT INTO `employee_department` VALUES (1,8,1),(2,8,2),(3,8,3),(4,14,4),(5,8,5),(6,14,6),(7,8,7),(8,8,8);
/*!40000 ALTER TABLE `employee_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `pos_id` int NOT NULL AUTO_INCREMENT,
  `pos_name` varchar(255) DEFAULT NULL,
  `pos_code` varchar(255) DEFAULT NULL,
  `pos_desc` mediumtext,
  PRIMARY KEY (`pos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (2,'Giám đốc ','GD','Quản lý và điều phối công việc'),(4,'Leader','LD05','3 năm kinh nghiệm Java'),(9,'Nhân viên','NV01','Nhận task từ Leader');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_employee`
--

DROP TABLE IF EXISTS `position_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position_employee` (
  `pos_id` int NOT NULL,
  `em_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_position_has_employee_employee1_idx` (`em_id`),
  KEY `fk_position_has_employee_position_idx` (`pos_id`),
  CONSTRAINT `fk_position_has_employee_employee1` FOREIGN KEY (`em_id`) REFERENCES `employee` (`em_id`),
  CONSTRAINT `fk_position_has_employee_position` FOREIGN KEY (`pos_id`) REFERENCES `position` (`pos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_employee`
--

LOCK TABLES `position_employee` WRITE;
/*!40000 ALTER TABLE `position_employee` DISABLE KEYS */;
INSERT INTO `position_employee` VALUES (2,1,1),(2,2,2),(9,3,3),(2,4,4),(2,5,5),(2,6,6),(2,7,7),(2,8,8);
/*!40000 ALTER TABLE `position_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `role_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'Quyen admin','ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'huyduc1602@gmail.com','$2a$10$obCJBFQnRD.1kc1zOrz/OOfTCojHDLV864IgmJA60sUBnTe.7IbFy'),(2,'huyduk19@gmail.com','$2a$10$xqaoJ.R8nUwf8ZCWbu8RvOOZpaf6AIu7O2apIXZXe3MN5cF8iSQae'),(3,'phuc@gmail.com','$2a$10$BJqgsWhWzGbhVcnW9xJfDud3OKU9YOfZ9n4RWXkgr2r4CZVyEWVze'),(4,'admin@gmail.com','$2a$10$GDxVWcc2zz9ecHyKDQQjre69M4lTXbQT4NqoiTPICwW8uB5Kv2Y/y');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_role_role1_idx` (`role_id`),
  KEY `fk_user_has_role_user_idx` (`user_id`),
  CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `fk_user_has_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,2,2),(2,2,3),(3,2,4),(4,2,5);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-15 19:11:53
