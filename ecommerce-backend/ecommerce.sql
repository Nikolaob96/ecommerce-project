/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.1.39-MariaDB : Database - ecommerce
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ecommerce` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ecommerce`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values 
(1,'Apple'),
(3,'Huawei'),
(4,'HTC'),
(5,'LG Mobiles'),
(6,'Samsung Mobiles');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `datecreated` date DEFAULT NULL,
  `shippinginformationid` int(50) DEFAULT NULL,
  `userid` int(50) DEFAULT NULL,
  `shoppingcartid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shippinginformationid` (`shippinginformationid`),
  KEY `userid` (`userid`),
  KEY `shoppingcartid` (`shoppingcartid`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`shippinginformationid`) REFERENCES `shippinginformation` (`id`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`shoppingcartid`) REFERENCES `shoppingcart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `order` */

insert  into `order`(`id`,`datecreated`,`shippinginformationid`,`userid`,`shoppingcartid`) values 
(1,NULL,NULL,1,NULL);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_ibfk_1` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`description`,`price`,`image`,`category_id`) values 
(2,'Samsung Galaxy S10',NULL,500,'https://www.khouryhome.com/media/catalog/product/s/a/samsung_s10_black.jpg',6),
(5,'Samsung Galaxy Note 3',NULL,250,'https://i.ebayimg.com/images/i/331514466427-0-1/s-l1000.jpg',6),
(6,'Apple iPhone 6 Plus',NULL,250,'https://drop.ndtv.com/TECH/product_database/images/910201410645AM_635_apple_iphone_6_plus.jpeg',1),
(7,'LG G3',NULL,230,'https://i.ebayimg.com/images/g/iE0AAOSwQ9lcCS2U/s-l640.jpg',5),
(8,'LG G4',NULL,360,'https://drop.ndtv.com/TECH/product_database/images/4282015101012PM_635_lg-g4.jpeg',5),
(9,'LG G5',NULL,380,'https://cf4.s3.souqcdn.com/item/2016/05/30/10/19/37/86/item_XL_10193786_14616505.jpg',5),
(10,'LG G6',NULL,400,'https://images-na.ssl-images-amazon.com/images/I/71Y798zkPPL._SX569_.jpg',5),
(11,'HTC One M8',NULL,260,'https://images-na.ssl-images-amazon.com/images/I/81t7zFcQ1rL._SX425_.jpg',4),
(12,'Huawei Mate 10 Lite',NULL,260,'https://drop.ndtv.com/TECH/product_database/images/1017201780922PM_635_huawei_mate_10_lite.jpeg',3),
(13,'Huawei P30 Pro',NULL,750,'https://images-na.ssl-images-amazon.com/images/I/51zDfRUUhHL._SX425_.jpg',3),
(15,'Samsung Galaxy J5',NULL,180,'https://cf3.s3.souqcdn.com/item/2015/07/27/87/07/91/0/item_XL_8707910_8738613.jpg',6);

/*Table structure for table `shippinginformation` */

DROP TABLE IF EXISTS `shippinginformation`;

CREATE TABLE `shippinginformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `addressline1` varchar(50) DEFAULT NULL,
  `addressline2` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shippinginformation` */

/*Table structure for table `shoppingcart` */

DROP TABLE IF EXISTS `shoppingcart`;

CREATE TABLE `shoppingcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datecreated` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;

/*Data for the table `shoppingcart` */

insert  into `shoppingcart`(`id`,`datecreated`) values 
(1,NULL),
(2,NULL),
(3,NULL),
(4,NULL),
(5,'2019-05-15'),
(6,'2019-05-17'),
(7,'2019-05-17'),
(8,'2019-05-17'),
(9,'2019-05-17'),
(10,'2019-05-17'),
(11,'2019-05-18'),
(12,'2019-05-18'),
(13,'2019-05-18'),
(14,'2019-05-18'),
(15,'2019-05-18'),
(16,'2019-05-20'),
(17,'2019-05-20'),
(18,'2019-05-20'),
(19,'2019-05-20'),
(20,'2019-05-20'),
(21,'2019-05-20'),
(22,'2019-05-20'),
(23,'2019-05-20'),
(24,'2019-05-20'),
(25,'2019-05-20'),
(26,'2019-05-20'),
(27,'2019-05-20'),
(28,'2019-05-20'),
(29,'2019-05-20'),
(30,'2019-05-20'),
(31,'2019-05-20'),
(32,'2019-05-20'),
(33,'2019-05-20'),
(34,'2019-05-20'),
(35,'2019-05-20'),
(36,'2019-05-20'),
(37,'2019-05-20'),
(38,'2019-05-20'),
(39,'2019-05-20'),
(40,'2019-05-20'),
(41,'2019-05-20'),
(42,'2019-05-20'),
(43,'2019-05-20'),
(44,'2019-05-20'),
(45,'2019-05-20'),
(46,'2019-05-20'),
(47,'2019-05-20'),
(48,'2019-05-20'),
(49,'2019-05-20'),
(50,'2019-05-20'),
(51,'2019-05-20'),
(52,'2019-05-20'),
(53,'2019-05-20'),
(54,'2019-05-20'),
(55,'2019-05-20'),
(56,'2019-05-20'),
(57,'2019-05-20'),
(58,'2019-05-20'),
(59,'2019-05-20'),
(60,'2019-05-20'),
(61,'2019-05-20'),
(62,'2019-05-20'),
(63,'2019-05-20'),
(64,'2019-05-20'),
(65,'2019-05-20'),
(66,'2019-05-20'),
(67,'2019-05-20'),
(68,'2019-05-20'),
(69,'2019-05-20'),
(70,'2019-05-20'),
(71,'2019-05-20'),
(72,'2019-05-20'),
(73,'2019-05-20'),
(74,'2019-05-20'),
(75,'2019-05-20'),
(76,'2019-05-20'),
(77,'2019-05-20'),
(78,'2019-05-20'),
(79,'2019-05-20'),
(80,'2019-05-20'),
(81,'2019-05-20'),
(82,'2019-05-20'),
(83,'2019-05-20'),
(84,'2019-05-23'),
(85,'2019-05-23'),
(86,'2019-05-23'),
(87,'2019-05-23'),
(88,'2019-05-23'),
(89,'2019-05-23'),
(90,'2019-05-23'),
(91,'2019-05-23'),
(92,'2019-05-23'),
(93,'2019-05-23'),
(94,'2019-05-23'),
(95,'2019-05-23'),
(96,'2019-05-23'),
(97,'2019-05-23'),
(98,'2019-05-23'),
(99,'2019-05-23'),
(100,'2019-05-23'),
(101,'2019-05-23'),
(102,'2019-05-23'),
(103,'2019-05-23'),
(104,'2019-05-23'),
(105,'2019-05-23'),
(106,'2019-05-23'),
(107,'2019-05-23'),
(108,'2019-05-23'),
(109,'2019-05-23'),
(110,'2019-05-23'),
(111,'2019-05-23'),
(112,'2019-05-23'),
(113,'2019-05-23');

/*Table structure for table `shoppingcartitem` */

DROP TABLE IF EXISTS `shoppingcartitem`;

CREATE TABLE `shoppingcartitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `shoppingcartid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shoppingcartid` (`shoppingcartid`),
  KEY `shoppingcartitem_ibfk_2` (`productid`),
  CONSTRAINT `shoppingcartitem_ibfk_1` FOREIGN KEY (`shoppingcartid`) REFERENCES `shoppingcart` (`id`),
  CONSTRAINT `shoppingcartitem_ibfk_2` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

/*Data for the table `shoppingcartitem` */

insert  into `shoppingcartitem`(`id`,`quantity`,`shoppingcartid`,`productid`) values 
(8,1,6,2),
(9,1,6,2),
(10,1,6,2),
(11,7,7,2),
(15,2,9,2),
(17,7,10,2),
(18,6,11,2),
(19,2,12,2),
(20,22,13,2),
(22,2,13,6),
(23,281,14,2),
(25,25,14,5),
(26,16,14,6),
(27,5,14,9),
(28,10,14,7),
(29,8,14,8),
(30,5,14,10),
(31,8,14,11),
(32,24,14,12),
(33,1,14,13),
(34,3,14,15),
(35,4,31,2),
(36,4,33,2),
(37,6,54,2),
(39,4,59,2),
(40,5,61,2),
(41,14,76,2),
(43,0,76,5),
(44,51,77,2),
(46,2,79,2),
(48,0,79,5),
(49,0,79,6),
(62,5,80,2),
(65,2,80,6),
(68,1,81,2),
(69,1,82,2),
(70,1,82,6),
(71,1,82,7),
(94,2,83,2),
(95,1,83,5),
(96,1,102,2),
(97,3,103,2),
(98,3,104,2),
(99,3,106,2),
(100,6,110,2),
(103,1,113,2),
(104,2,113,5);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(35) DEFAULT NULL,
  `password` varchar(35) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`) values 
(1,'nikola','nikola','nikola@nikola.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
