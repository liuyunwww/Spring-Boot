/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.32 : Database - af
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`af` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `af`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(11) DEFAULT NULL COMMENT '用户账号',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `birthdate` date DEFAULT NULL COMMENT '生日',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `token` varchar(256) DEFAULT NULL COMMENT '融云token',
  `longitude` decimal(10,7) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,7) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`password`,`nickname`,`gender`,`birthdate`,`address`,`email`,`token`,`longitude`,`latitude`) values 
(5,'15736013349','e10adc3949ba59abbe56e057f20f883e','小红',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(7,'17721889526','123456','阿尔法','公','2005-07-30','德阳市岷江西路一段683号','764584171@qq.com','RhAoBlCbdj3vHSnZy95l1/MZ359NkaBZAjYQ2srQvzY5LLhCO28Pd2BuAct7Qo8Rexr75zNAS9rWOtXwphE56SxS27IqECGz',NULL,NULL),
(13,'13688376168','6270',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(18,'13688488471','e10adc3949ba59abbe56e057f20f883e','阿福','男','2018-04-09','成都市双流区','993149323@qq.com','CdY+lONbRIUEhfqAvSa5wP1YOP7QNZw8uYjMnA/+u1RdwtuY4h38KS9f/RiIylBi8YwbPjT9DsoqWz9179r/gx4JxbwdP95Q',NULL,NULL),
(19,'18380481654','e10adc3949ba59abbe56e057f20f883e','神话','男','2018-07-09','黑龙江省大兴安岭地区漠河县','1245','fAKT9t0tNrY2C7rNfIM6nfMZ359NkaBZAjYQ2srQvzbq86H/YlbYAHcm/P/RBMGtTup1xuSClWyJQrOMN7RPxE+j1ybIOaEN',NULL,NULL),
(20,'17380041092','e10adc3949ba59abbe56e057f20f883e','小阿福','女','1970-03-12','成都市成华区龙潭寺工业园华实路2号','764584171@qq.com',NULL,NULL,NULL),
(21,'18782079163','08cfbc3bf1f199a9607a872d827ee025','schnappi','女','1998-10-22','四川省成都市温江区','523688908@qq.com',NULL,NULL,NULL),
(22,'17781482160','ef200e4f0f27910c73c436c185ae50ab','emmm','男','2018-04-10','成都市','未设置',NULL,NULL,NULL),
(23,'18508108004','e10adc3949ba59abbe56e057f20f883e','一','男',NULL,NULL,'','PTCrSH7PKhnWCeib33U60r+sCa7gV1D+xv9aAcLals9+z6cC+XCO9vUnCvWGA6rMQz5q4z7RyOpInG8TZlv7gYFURC17zYCP',NULL,NULL),
(24,'15680805508','8020e26e3b8e31d30364197902ca6b03',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(25,'13438133788','620a8e039cd43cffa36a690f0acd655f','1621510033835',NULL,NULL,NULL,NULL,'f1c4363e18266bde3d7a06e49363de45dfb14f79c142868fd0a2903fb75dbfa6',30.6814400,103.8559000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
