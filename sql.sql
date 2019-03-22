/*
SQLyog Ultimate v8.32 
MySQL - 5.7.24 : Database - schoolleavesystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`schoolleavesystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `schoolleavesystem`;

/*Table structure for table `t_notice` */

DROP TABLE IF EXISTS `t_notice`;

CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `n_name` varchar(255) DEFAULT NULL,
  `n_time` varchar(255) DEFAULT NULL,
  `n_neir` varchar(255) DEFAULT NULL,
  `n_bz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3EE4D5234BD3594C` (`user`),
  CONSTRAINT `FK3EE4D5234BD3594C` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_notice` */

insert  into `t_notice`(`id`,`user`,`n_name`,`n_time`,`n_neir`,`n_bz`) values (1,1,'水电费水电费','2019-03-01','水电费地方','打发斯蒂芬');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `jjlxr` varchar(255) DEFAULT NULL,
  `jjtel` varchar(255) DEFAULT NULL,
  `jg` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bm` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `by_1` varchar(255) DEFAULT NULL,
  `by_2` varchar(255) DEFAULT NULL,
  `by_3` varchar(255) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`name`,`birthday`,`sex`,`tel`,`jjlxr`,`jjtel`,`jg`,`address`,`bm`,`type`,`by_1`,`by_2`,`by_3`,`bz`) values (1,'admin','admin','admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin',NULL,NULL,NULL,NULL),(2,'xs1','admin','学生1','','男','','','','','','','user',NULL,NULL,NULL,''),(3,'xs2','admin','学生2','','男','','','','','','','user',NULL,NULL,NULL,''),(4,'fdy1','admin','辅导员1','','男','','','','','','','root',NULL,NULL,NULL,''),(5,'ls1','admin','老师1','','男','','','','','','','admin',NULL,NULL,NULL,'');

/*Table structure for table `t_userfile` */

DROP TABLE IF EXISTS `t_userfile`;

CREATE TABLE `t_userfile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userLeave` int(11) DEFAULT NULL,
  `tp` varchar(255) DEFAULT NULL,
  `wjm` varchar(255) DEFAULT NULL,
  `scsj` varchar(255) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `u_time` varchar(255) DEFAULT NULL,
  `u_bz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAA9E4F728B8C4382` (`userLeave`),
  CONSTRAINT `FKAA9E4F728B8C4382` FOREIGN KEY (`userLeave`) REFERENCES `t_userleave` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_userfile` */

insert  into `t_userfile`(`id`,`userLeave`,`tp`,`wjm`,`scsj`,`u_name`,`u_time`,`u_bz`) values (1,1,'QQ截图201903010945171551404734688.png','QQ截图20190301094517.png','2019-03-01','范甘迪发郭德纲 ','','的说法是否'),(2,2,'请事假1551405487069.png','请事假.png','2019-03-01','水电费水电费','士大夫','士大夫');

/*Table structure for table `t_userleave` */

DROP TABLE IF EXISTS `t_userleave`;

CREATE TABLE `t_userleave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `user1` int(11) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `u_time` varchar(255) DEFAULT NULL,
  `u_day` varchar(255) DEFAULT NULL,
  `u_type` varchar(255) DEFAULT NULL,
  `u_yuany` varchar(255) DEFAULT NULL,
  `u_status` varchar(255) DEFAULT NULL,
  `u_bz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA97E33815242FB47` (`user1`),
  KEY `FKA97E33814BD3594C` (`user`),
  CONSTRAINT `FKA97E33814BD3594C` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKA97E33815242FB47` FOREIGN KEY (`user1`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_userleave` */

insert  into `t_userleave`(`id`,`user`,`user1`,`u_name`,`u_time`,`u_day`,`u_type`,`u_yuany`,`u_status`,`u_bz`) values (1,2,1,'感冒请假','2019-03-01','3','病假','生病','老师同意','水电费地方'),(2,2,5,'士大夫','2019-03-20','4','事假','司法所发放','老师同意','这里辅导员也可以帮学生申请。&nbsp;&nbsp;');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
