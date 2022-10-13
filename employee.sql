/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.5.62 : Database - employee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employee` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `employee`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `ID` int(100) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_NAME` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `DATE_OF_JOIN` date DEFAULT NULL,
  `DEPARTMENT` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `PHOTOS` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL DEFAULT '0',
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '1',
  `CREATED_ON` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `employee` */

insert  into `employee`(`ID`,`EMPLOYEE_NAME`,`DATE_OF_BIRTH`,`DATE_OF_JOIN`,`DEPARTMENT`,`PHOTOS`,`IS_ACTIVE`,`IS_DELETED`,`CREATED_ON`) values 
(4,'ronu','2022-01-15','2022-01-11','sales',NULL,1,0,NULL),
(5,'ronu','2022-06-15','2022-07-11','sales',NULL,1,0,NULL),
(6,'ronu','2022-06-15','2022-07-11','sales',NULL,1,0,NULL),
(7,'ronu','2022-06-15','2022-07-11','sales','image',1,0,NULL),
(8,'ronu','2022-06-15','2022-07-11','sales','image',1,0,'2022-10-13'),
(9,'ronu','2022-06-15','2022-07-11','sales','image',1,0,'2022-10-13'),
(10,'ronu','2022-06-15','2022-07-11','sales','image',1,0,'2022-10-13');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
