# Host: localhost  (Version: 5.7.3-m13)
# Date: 2017-12-18 19:45:45
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin_user"
#

CREATE TABLE `admin_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) NOT NULL DEFAULT '',
  `user_password` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for table "product"
#

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_title` varchar(255) NOT NULL DEFAULT '',
  `product_info` varchar(4095) NOT NULL DEFAULT '',
  `product_price` double NOT NULL DEFAULT '0',
  `product_stock` int(11) NOT NULL DEFAULT '0',
  `product_img1` varchar(255) DEFAULT NULL,
  `product_img2` varchar(255) DEFAULT NULL,
  `product_img3` varchar(255) DEFAULT NULL,
  `product_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(255) NOT NULL DEFAULT '',
  `user_password` varchar(255) NOT NULL DEFAULT '',
  `user_avatar` varchar(255) DEFAULT NULL,
  `user_money` double DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

#
# Structure for table "product_comment"
#

CREATE TABLE `product_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) NOT NULL DEFAULT '',
  `comment_date_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `comment_uid` int(11) DEFAULT NULL,
  `comment_pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_uid` (`comment_uid`),
  KEY `comment_pid` (`comment_pid`),
  CONSTRAINT `comment_pid` FOREIGN KEY (`comment_pid`) REFERENCES `product` (`product_id`),
  CONSTRAINT `comment_uid` FOREIGN KEY (`comment_uid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Structure for table "user_address"
#

CREATE TABLE `user_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(255) NOT NULL DEFAULT '',
  `address_phone` varchar(255) NOT NULL DEFAULT '',
  `address_content` varchar(255) NOT NULL DEFAULT '',
  `address_uid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`address_id`),
  KEY `address_uid` (`address_uid`),
  CONSTRAINT `address_uid` FOREIGN KEY (`address_uid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Structure for table "user_order"
#

CREATE TABLE `user_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` int(11) NOT NULL DEFAULT '1',
  `order_status` int(11) NOT NULL DEFAULT '1',
  `order_date_time` datetime DEFAULT NULL,
  `order_pid` int(11) NOT NULL DEFAULT '0',
  `order_uid` int(11) NOT NULL DEFAULT '0',
  `order_person_name` varchar(255) DEFAULT NULL,
  `order_phone` varchar(255) DEFAULT NULL,
  `order_address` varchar(255) DEFAULT '',
  `order_message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_uid` (`order_uid`),
  KEY `order_pid` (`order_pid`),
  CONSTRAINT `order_pid` FOREIGN KEY (`order_pid`) REFERENCES `product` (`product_id`),
  CONSTRAINT `order_uid` FOREIGN KEY (`order_uid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;
