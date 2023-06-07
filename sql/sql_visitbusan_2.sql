-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: busan
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cateCode` varchar(6) NOT NULL,
  `cateGroup` varchar(50) NOT NULL,
  `cateName` varchar(50) NOT NULL,
  PRIMARY KEY (`cateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('0101','여행','테마여행'),('0102','여행','테마여행'),('0201','공연','야구'),('0202','공연','국제영화제'),('0301','축제','봄'),('0302','축제','여름'),('0303','축제','가을'),('0304','축제','겨울');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(20) NOT NULL,
  `pw` varchar(300) NOT NULL,
  `name` varchar(20) NOT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `logCnt` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('admin','4D8TZ41Pmqq9ys02TS3O19/+zJmTBZ4NH/Xtj6ZRoAcJiS7iLWx4/VhWvawCN6Wsm9ewvQ==','관리자','01012341234','admin@naver.com','경기도 고양시 일산서구',2),('binbin','1234','이성빈','01012341234','binbin@naver.com','경기도 고양시 일산동구',0),('bklove','1234','정봉길','01012341234','bklove@naver.com','경기도 고양시 일산동구',0),('criminalcity','1234','마동석','01012341234','criminalcity@naver.com','경기도 화성시 중구',0),('faker','1234','이상혁','01012341234','faker@naver.com','경기도 고양시 일산동구',0),('jiny','1234','유지니','01012341234','jiny@naver.com','경기도 고양시 일산동구',0),('jungwoo','1234','박정우','01012341234','jungwoo@naver.com','경기도 고양시 일산동구',0),('narae','1234','김나래','01012341234','narae@naver.com','경기도 고양시 일산동구',0),('seonjeong','1234','최선정','01012341234','seonjeong@naver.com','경기도 고양시 일산동구',0),('tyler','4D8TZ41Pmqq9ys02TS3O19/+zJmTBZ4NH/Xtj6ZRoAcJiS7iLWx4/VhWvawCN6Wsm9ewvQ==','조교행','01012341234','tyler@naver.com','경기도 고양시 일산동구',1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `noticeId` varchar(8) NOT NULL,
  `noticeTitle` varchar(200) NOT NULL,
  `noticeContent` varchar(1000) NOT NULL,
  `writtenAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `writtenBy` varchar(20) DEFAULT NULL,
  `attachment` varchar(200) DEFAULT NULL,
  `readCnt` int DEFAULT '0',
  PRIMARY KEY (`noticeId`),
  KEY `writtenBy` (`writtenBy`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`writtenBy`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES ('000001','테스트 더미글 1','테스트 더미글 1번 입니다.','2023-05-22 15:27:55','admin','1.jpg',0),('000002','테스트 더미글 2','테스트 더미글 2번 입니다.','2023-05-22 15:27:55','admin','2.jpg',0),('000003','테스트 더미글 3','테스트 더미글 3번 입니다.','2023-05-22 15:27:55','admin','3.jpg',0),('000004','테스트 더미글 4','테스트 더미글 4번 입니다.','2023-05-22 15:27:55','admin','4.jpg',0),('000005','테스트 더미글 5','테스트 더미글 5번 입니다.','2023-05-22 15:27:55','admin','5.jpg',0),('000006','테스트 더미글 6','테스트 더미글 6번 입니다.','2023-05-22 15:27:55','admin','6.jpg',0),('000007','테스트 더미글 7','테스트 더미글 7번 입니다.','2023-05-22 15:27:55','admin','7.jpg',0),('000008','테스트 더미글 8','테스트 더미글 8번 입니다.','2023-05-22 15:27:55','admin','8.jpg',0),('000009','테스트 더미글 9','테스트 더미글 9번 입니다.','2023-05-22 15:27:55','admin','9.jpg',0),('000010','테스트 더미글 10','테스트 더미글 10번 입니다.','2023-05-22 15:27:55','admin','10.jpg',0),('000011','테스트 더미글 11','테스트 더미글 11번 입니다.','2023-05-22 15:27:55','admin','11.jpg',0),('000012','테스트 더미글 12','테스트 더미글 12번 입니다.','2023-05-22 15:27:55','admin','12.jpg',0),('000013','테스트 더미글 13','테스트 더미글 13번 입니다.','2023-05-22 15:27:55','admin','13.jpg',0),('000014','테스트 더미글 14','테스트 더미글 14번 입니다.','2023-05-22 15:27:55','admin','14.jpg',0),('000015','테스트 더미글 15','테스트 더미글 15번 입니다.','2023-05-22 15:27:55','admin','15.jpg',0);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poke`
--

DROP TABLE IF EXISTS `poke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poke` (
  `pokeId` varchar(8) NOT NULL,
  `pokedBy` varchar(20) DEFAULT NULL,
  `visitId` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`pokeId`),
  KEY `pokedBy` (`pokedBy`),
  KEY `visitId` (`visitId`),
  CONSTRAINT `poke_ibfk_1` FOREIGN KEY (`pokedBy`) REFERENCES `member` (`id`),
  CONSTRAINT `poke_ibfk_2` FOREIGN KEY (`visitId`) REFERENCES `visit` (`visitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poke`
--

LOCK TABLES `poke` WRITE;
/*!40000 ALTER TABLE `poke` DISABLE KEYS */;
INSERT INTO `poke` VALUES ('1','tyler','1'),('2','faker','2'),('3','narae','3');
/*!40000 ALTER TABLE `poke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qna`
--

DROP TABLE IF EXISTS `qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna` (
  `qId` varchar(8) NOT NULL,
  `qTitle` varchar(200) NOT NULL,
  `qContent` varchar(1000) DEFAULT NULL,
  `qType` varchar(6) NOT NULL,
  `qIdGroup` varchar(8) NOT NULL,
  `askedAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `askedBy` varchar(20) DEFAULT NULL,
  `readCnt` int DEFAULT '0',
  PRIMARY KEY (`qId`),
  KEY `askedBy` (`askedBy`),
  CONSTRAINT `qna_ibfk_1` FOREIGN KEY (`askedBy`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna`
--

LOCK TABLES `qna` WRITE;
/*!40000 ALTER TABLE `qna` DISABLE KEYS */;
INSERT INTO `qna` VALUES ('1','질문1','질문1입니다.','1','1','2023-05-22 17:03:16','faker',0),('2','답변1','답변1입니다.','2','1','2023-05-22 17:03:16','admin',0),('3','질문2','질문2입니다.','1','3','2023-05-22 17:03:16','faker',0),('4','답변2','답변2입니다.','2','3','2023-05-22 17:03:16','admin',0),('5','질문3','질문3입니다.','1','5','2023-05-22 17:03:16','faker',0),('6','답변3','답변3입니다.','2','5','2023-05-22 17:03:16','admin',0);
/*!40000 ALTER TABLE `qna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `regId` varchar(8) NOT NULL,
  `registeredBy` varchar(20) DEFAULT NULL,
  `visitId` varchar(8) DEFAULT NULL,
  `regDate` datetime NOT NULL,
  `rStatus` varchar(20) DEFAULT '여행신청',
  PRIMARY KEY (`regId`),
  KEY `registeredBy` (`registeredBy`),
  KEY `visitId` (`visitId`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`registeredBy`) REFERENCES `member` (`id`),
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`visitId`) REFERENCES `visit` (`visitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES ('000001','tyler','1','2023-06-03 00:00:00','여행완료'),('000002','tyler','2','2023-06-06 00:00:00','여행완료'),('000003','tyler','3','2023-06-13 00:00:00','여행완료'),('000004','faker','1','2023-06-16 00:00:00','여행완료'),('000005','faker','2','2023-06-30 00:00:00','여행완료'),('000006','faker','3','2023-07-03 00:00:00','여행완료'),('000007','narae','1','2023-08-03 00:00:00','여행완료'),('000008','narae','2','2023-09-03 00:00:00','여행완료'),('000009','narae','3','2023-10-03 00:00:00','여행완료'),('000010','seonjeong','1','2023-06-23 00:00:00','여행완료'),('000011','seonjeong','2','2023-06-09 00:00:00','여행완료'),('000012','seonjeong','3','2023-06-28 00:00:00','여행완료'),('000013','binbin','1','2023-06-03 00:00:00','여행완료'),('000014','binbin','1','2023-06-03 00:00:00','여행완료'),('000015','binbin','1','2023-06-03 00:00:00','여행완료');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewId` varchar(8) NOT NULL,
  `reviewTitle` varchar(200) NOT NULL,
  `reviewContent` varchar(1000) DEFAULT NULL,
  `reviewedAt` datetime DEFAULT CURRENT_TIMESTAMP,
  `reviewedBy` varchar(20) DEFAULT NULL,
  `visitId` varchar(20) DEFAULT NULL,
  `regid` varchar(8) NOT NULL,
  `point` int DEFAULT '5',
  `img` varchar(200) DEFAULT NULL,
  `likeCnt` int DEFAULT '0',
  PRIMARY KEY (`reviewId`),
  KEY `reviewedBy` (`reviewedBy`),
  KEY `visitId` (`visitId`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`reviewedBy`) REFERENCES `member` (`id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`visitId`) REFERENCES `visit` (`visitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES ('000001','리뷰 테스트 1','리뷰 테스트 글 1번 입니다.','2023-05-22 16:41:46','tyler','1','000001',5,'/1.jpg',0),('000002','리뷰 테스트 2','리뷰 테스트 글 2번 입니다.','2023-05-22 16:41:46','tyler','2','000002',4,'/2.jpg',0),('000003','리뷰 테스트 3','리뷰 테스트 글 3번 입니다.','2023-05-22 16:41:46','tyler','3','000003',5,'/3.jpg',0),('000004','리뷰 테스트 4','리뷰 테스트 글 4번 입니다.','2023-05-22 16:41:46','faker','1','000004',5,'/4.jpg',0),('000005','리뷰 테스트 5','리뷰 테스트 글 5번 입니다.','2023-05-22 16:41:46','faker','2','000005',3,'/5.jpg',0),('000006','리뷰 테스트 6','리뷰 테스트 글 6번 입니다.','2023-05-22 16:41:46','faker','3','000006',5,'/6.jpg',0),('000007','리뷰 테스트 7','리뷰 테스트 글 7번 입니다.','2023-05-22 16:41:46','narae','1','000007',5,'/7.jpg',0),('000008','리뷰 테스트 8','리뷰 테스트 글 8번 입니다.','2023-05-22 16:41:46','narae','2','000008',4,'/8.jpg',0),('000009','리뷰 테스트 9','리뷰 테스트 글 9번 입니다.','2023-05-22 16:41:46','narae','3','000009',5,'/9.jpg',0),('000010','리뷰 테스트 10','리뷰 테스트 글 10번 입니다.','2023-05-22 16:41:46','seonjeong','1','000010',5,'/10.jpg',0),('000011','리뷰 테스트 11','리뷰 테스트 글 11번 입니다.','2023-05-22 16:41:46','seonjeong','2','000011',2,'/11.jpg',0),('000012','리뷰 테스트 12','리뷰 테스트 글 12번 입니다.','2023-05-22 16:41:46','seonjeong','3','000012',5,'/12.jpg',0),('000013','리뷰 테스트 13','리뷰 테스트 글 13번 입니다.','2023-05-22 16:41:46','binbin','1','000013',1,'/13.jpg',0),('000014','리뷰 테스트 14','리뷰 테스트 글 14번 입니다.','2023-05-22 16:41:46','binbin','2','000014',5,'/14.jpg',0),('000015','리뷰 테스트 15','리뷰 테스트 글 15번 입니다.','2023-05-22 16:41:46','binbin','3','000015',5,'/15.jpg',0);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample1`
--

DROP TABLE IF EXISTS `sample1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sample1` (
  `item1` varchar(50) NOT NULL,
  `item2` int DEFAULT '0',
  `item3` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample1`
--

LOCK TABLES `sample1` WRITE;
/*!40000 ALTER TABLE `sample1` DISABLE KEYS */;
INSERT INTO `sample1` VALUES ('chokyohaeng',80,'2023-05-18 11:12:03'),('chotaejeong',60,'2023-05-18 11:12:30'),('kimkitae',90,'2023-05-18 11:12:28');
/*!40000 ALTER TABLE `sample1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit` (
  `visitId` varchar(8) NOT NULL,
  `visitTitle` varchar(200) NOT NULL,
  `visitCateCode` varchar(50) DEFAULT NULL,
  `visitAddr` varchar(100) NOT NULL,
  `visistImgMain` varchar(100) DEFAULT NULL,
  `visistImgSub1` varchar(100) DEFAULT NULL,
  `visistImgSub2` varchar(100) DEFAULT NULL,
  `likeCnt` int DEFAULT '0',
  PRIMARY KEY (`visitId`),
  KEY `visitCateCode` (`visitCateCode`),
  CONSTRAINT `visit_ibfk_1` FOREIGN KEY (`visitCateCode`) REFERENCES `category` (`cateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` VALUES ('1','세계적인 관광도시 부산 5대 매력','0101','SAMPLE주소','change1','change1','change1',0),('2','빠르게 만나는 부산 봄 여행 추천 10','0101','SAMPLE주소','change1','change1','change1',0),('3','일러스트로 만나는 \'뉴진스 코드 in 부산\' 추천여행','0101','SAMPLE주소','change1','change1','change1',0),('4','부산 아이와 가볼만한 곳(겨울편)','0101','SAMPLE주소','change1','change1','change1',0),('5','2022 드라마 촬영지 순례(ft.재벌집 막내아들)','0101','SAMPLE주소','change1','change1','change1',0),('6','속 시원한 해장 별미 3선','0102','SAMPLE주소','change1','change1','change1',0),('7','오롯이 즐기는 여유, 부산 한옥카페 3선','0102','SAMPLE주소','change1','change1','change1',0);
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-23 18:25:18
