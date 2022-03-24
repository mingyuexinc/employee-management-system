CREATE DATABASE /*!32312 IF NOT EXISTS*/`manage`;
USE `manage`;

CREATE TABLE `department` (
                              `did` INT NOT NULL AUTO_INCREMENT,
                              `departmentName` VARCHAR(20) NOT NULL,
                              PRIMARY KEY (`did`)
) ENGINE=INNODB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

INSERT  INTO `department`(`did`,`departmentName`) VALUES (101,'教学部'),(102,'市场部'),(103,'教研部'),(104,'运营部'),(105,'后勤部');

CREATE TABLE `employee` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(20) NOT NULL,
                            `email` VARCHAR(20) NOT NULL,
                            `gender` INT NOT NULL,
                            `birth` DATE DEFAULT NULL,
                            `department` INT NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1015 DEFAULT CHARSET=utf8;

INSERT  INTO `employee`(`id`,`name`,`email`,`gender`,`birth`,`department`) VALUES
    (1001,'AA','121456qq.com',1,'2021-03-09',101),
    (1003,'BB','124561@qq.com',0,'2021-05-03',105),
    (1005,'zhangsan','1210418430@qq.com',1,'2021-07-04',102),
    (1006,'zhangsan','1210418430@qq.com',1,'2021-07-04',102),
    (1009,'zhangsans','a123456yy@qq.com',1,'2000-02-02',102),
    (1010,'20210704','14565430@qq.com',0,'2000-02-02',105),
    (1011,'djfihasf\'','1214546@qq.com',0,'2000-02-02',103),
    (1014,'sadasdsad','456430@qq.com',0,'2000-02-02',103);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `username` VARCHAR(20) NOT NULL,
                        `password` VARCHAR(20) NOT NULL,
                        `perms` VARCHAR(20) NOT NULL DEFAULT 'guest',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `u_user` */

insert  into `user`(`id`,`username`,`password`,`perms`) values
(1,'admin','123456','admin'),
(2,'xiaoming','111111','guest');