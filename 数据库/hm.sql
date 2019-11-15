/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.19 : Database - hm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hm`;

/*Table structure for table `t_fenlei` */

DROP TABLE IF EXISTS `t_fenlei`;

CREATE TABLE `t_fenlei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `deletestatus` int(11) NOT NULL,
  `jiage` double NOT NULL,
  `leixing` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `t_fenlei` */

insert  into `t_fenlei`(`id`,`createtime`,`deletestatus`,`jiage`,`leixing`) values (6,'2017-11-21 13:51:13',0,156,'大床房'),(7,'2017-11-21 13:51:23',1,256,'双床房'),(8,'2017-11-21 13:51:34',1,688,'情侣房'),(9,'2017-11-21 13:51:50',0,1068,'总统套房'),(10,'2017-12-19 17:31:31',0,568,'家庭房'),(11,'2017-12-19 17:31:55',0,234,'标间'),(17,'2017-12-19 17:31:55',0,128,'家庭温馨旅馆'),(18,'2017-12-19 17:31:55',0,128,'家庭温馨旅馆'),(19,'2017-12-19 17:31:55',0,128,'家庭温馨旅馆'),(20,'2017-12-19 17:31:55',0,128,'家庭温馨旅馆'),(21,'2017-12-19 17:31:55',0,128,'家庭温馨旅馆'),(22,'2017-12-19 17:31:55',1,111111.11111,'傻瓜面馆');

/*Table structure for table `t_kaifang` */

DROP TABLE IF EXISTS `t_kaifang`;

CREATE TABLE `t_kaifang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beizhu` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `jiezhangstatus` varchar(255) DEFAULT NULL,
  `kehuname` varchar(255) DEFAULT NULL,
  `ruzhutime` datetime DEFAULT NULL,
  `tianshu` int(11) NOT NULL,
  `tuifangtime` datetime DEFAULT NULL,
  `xiaofei` double NOT NULL,
  `yajin` double NOT NULL,
  `kefangid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE682DF1CAFDBF4E2` (`kefangid`),
  CONSTRAINT `FKE682DF1CAFDBF4E2` FOREIGN KEY (`kefangid`) REFERENCES `t_kefang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_kaifang` */

insert  into `t_kaifang`(`id`,`beizhu`,`idcard`,`jiezhangstatus`,`kehuname`,`ruzhutime`,`tianshu`,`tuifangtime`,`xiaofei`,`yajin`,`kefangid`) values (2,'','371921786234523','已结账','张贝贝','2017-12-19 18:13:37',2,'2017-12-20 18:36:52',2136,200,10),(3,'','330234196743211123','未结账','萱萱','2017-12-20 17:33:54',0,NULL,0,0,11);

/*Table structure for table `t_kefang` */

DROP TABLE IF EXISTS `t_kefang`;

CREATE TABLE `t_kefang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deletestatus` int(11) NOT NULL,
  `fangjianhao` varchar(255) DEFAULT NULL,
  `fangjianstatus` varchar(255) DEFAULT NULL,
  `miaoshu` varchar(255) DEFAULT NULL,
  `fenleiid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3932E659AE2F5C48` (`fenleiid`),
  CONSTRAINT `FK3932E659AE2F5C48` FOREIGN KEY (`fenleiid`) REFERENCES `t_fenlei` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_kefang` */

insert  into `t_kefang`(`id`,`deletestatus`,`fangjianhao`,`fangjianstatus`,`miaoshu`,`fenleiid`) values (7,0,'B301','空房','一张大床，有独卫，有阳台',6),(8,1,'A102','空房','--',7),(9,1,'A103','空房','--',8),(10,0,'E501','空房','高级家具，含早餐，所有设施齐全',9),(11,0,'C301','已入住','一张大床，一张单人床，有独卫，有阳台，有客厅，有厨房',10),(12,0,'B201','空房','两张单人床，有独卫，无阳台',11),(13,0,'B302','空房','一张大床，无阳台',6),(14,0,'B202','空房','两张单人床',11),(15,0,'C102','已预定','设备齐全，两张床，一大一小',10);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `lianxifangshi` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `truename` varchar(255) DEFAULT NULL,
  `userlock` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`createtime`,`lianxifangshi`,`password`,`role`,`truename`,`userlock`,`username`,`xingbie`) values (10,NULL,NULL,'123',1,'admin',0,'admin',NULL),(11,'2017-11-21 11:56:33','111','123',0,'111',1,'test','男'),(12,'2017-12-19 16:33:16','13345276548','123',0,'萱萱',0,'Cassie','女'),(13,'2017-12-19 17:29:31','13422345643','123123',0,'王小轩',0,'小轩','男'),(14,'2017-11-21 11:56:33','234223435345','1234',0,'黑猫警长',0,'happysmile','男'),(15,'2019-11-08 15:24:30','123','123',0,'张三',0,'demo','男'),(16,'2019-11-08 15:29:40','123','123',0,'张三2',0,'测试','男');

/*Table structure for table `t_yuding` */

DROP TABLE IF EXISTS `t_yuding`;

CREATE TABLE `t_yuding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beizhu` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `lianxifangshi` varchar(255) DEFAULT NULL,
  `truename` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `yudingidcard` varchar(255) DEFAULT NULL,
  `yudingstatus` int(11) NOT NULL,
  `yudingtime` varchar(255) DEFAULT NULL,
  `kefangid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK51F76C65AFDBF4E2` (`kefangid`),
  KEY `FK51F76C657614FDC` (`userid`),
  CONSTRAINT `FK51F76C657614FDC` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK51F76C65AFDBF4E2` FOREIGN KEY (`kefangid`) REFERENCES `t_kefang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_yuding` */

insert  into `t_yuding`(`id`,`beizhu`,`createtime`,`lianxifangshi`,`truename`,`xingbie`,`yudingidcard`,`yudingstatus`,`yudingtime`,`kefangid`,`userid`) values (6,'','2017-12-20 16:34:03','13345276548','萱萱','女','330234196743211123',1,NULL,15,12),(11,'','2017-12-20 17:22:40','13345276548','萱萱','','330234196743211123',2,'2017-12-20 17:22:40',11,12),(12,'','2017-12-20 18:35:50','13422345643','王小轩','男','3344223967490234',0,'2017-12-20 18:35:50',15,13);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
