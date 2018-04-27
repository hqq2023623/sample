/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 127.0.0.1
 Source Database       : generate

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 04/27/2018 21:01:06 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(60) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '帐号，用户名',
  `password` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '真实姓名',
  `phone` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '电话号码',
  `email` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '邮箱',
  `enable` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否可用',
  `ip` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '上次登录ip',
  `creator` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '创建人用户名',
  `updater` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '更新人用户名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_idx_username` (`user_name`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
