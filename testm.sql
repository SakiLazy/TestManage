/*
Navicat MySQL Data Transfer

Source Server         : clx
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : testm

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2022-12-17 15:47:16
*/
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('skiii', '123123');

-- ----------------------------
-- Table structure for examination_reg
-- ----------------------------
DROP TABLE IF EXISTS `examination_reg`;
CREATE TABLE `examination_reg` (
  `id` int(10) NOT NULL,
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `now_num` int(11) DEFAULT '0',
  `max_num` int(11) NOT NULL,
  `begin_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `place` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  PRIMARY KEY (`test_id`,`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of examination_reg
-- ----------------------------
INSERT INTO `examination_reg` VALUES ('1', '2', '计算机', '1', '50', '2022-11-27 00:00:00', '2022-11-28 00:00:00', 'E302', 'asd');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `name` varchar(255) NOT NULL DEFAULT '1',
  `state` int(10) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES ('addnewTest', '1');
INSERT INTO `permissions` VALUES ('manageTest', '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `now_num` int(11) DEFAULT '0',
  `max_num` int(11) NOT NULL,
  `begin_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `place` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('2', '计算机', '1', '50', '2022-11-27 00:00:00', '2022-11-28 00:00:00', 'E302', 'asd');
INSERT INTO `test` VALUES ('5', '离散数学', '0', '50', '2022-11-27 20:04:20', '2022-11-27 22:05:23', 'C201', 'awfe');
INSERT INTO `test` VALUES ('6', '线性代数', '0', '35', '2022-12-10 20:54:40', '2022-12-11 20:54:44', 'E211', 'awfe');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123123', '1');
INSERT INTO `user` VALUES ('2', '123123', '123123', '1');
INSERT INTO `user` VALUES ('3', '123123123', '123123', '1');
INSERT INTO `user` VALUES ('6', 'asd', 'asdasd', '2');
INSERT INTO `user` VALUES ('7', 'awfe', 'awefsdaf', '2');
INSERT INTO `user` VALUES ('8', '123', '132132', '1');
