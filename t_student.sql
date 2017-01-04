/*
Navicat MySQL Data Transfer

Source Server         : 120.55.96.222
Source Server Version : 50703
Source Host           : 120.55.96.222:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2017-01-03 17:58:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` bigint(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'Tom', '17', 'M');
INSERT INTO `t_student` VALUES ('2', 'Lily', '14', 'F');
INSERT INTO `t_student` VALUES ('3', 'Jack', '21', 'M');
INSERT INTO `t_student` VALUES ('4', 'Jane', '18', 'F');
