-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: cl1104764
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `cl1104764`
--

/*!40000 DROP DATABASE IF EXISTS `cl1104764`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl1104764` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl1104764`;

--
-- Table structure for table `binglidan`
--

DROP TABLE IF EXISTS `binglidan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binglidan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiuzhenshijian` date DEFAULT NULL COMMENT '就诊时间',
  `zhusu` varchar(200) DEFAULT NULL COMMENT '主诉',
  `bingshi` varchar(200) DEFAULT NULL COMMENT '病史',
  `zhenduan` varchar(200) DEFAULT NULL COMMENT '诊断',
  `fujian` longtext COMMENT '附件',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361287330 DEFAULT CHARSET=utf8 COMMENT='病例单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binglidan`
--

LOCK TABLES `binglidan` WRITE;
/*!40000 ALTER TABLE `binglidan` DISABLE KEYS */;
INSERT INTO `binglidan` VALUES (71,'2024-02-19 16:40:31','2024-02-20','主诉1','病史1','诊断1','','用户账号1','用户姓名1'),(72,'2024-02-19 16:40:31','2024-02-20','主诉2','病史2','诊断2','','用户账号2','用户姓名2'),(73,'2024-02-19 16:40:31','2024-02-20','主诉3','病史3','诊断3','','用户账号3','用户姓名3'),(74,'2024-02-19 16:40:31','2024-02-20','主诉4','病史4','诊断4','','用户账号4','用户姓名4'),(75,'2024-02-19 16:40:31','2024-02-20','主诉5','病史5','诊断5','','用户账号5','用户姓名5'),(76,'2024-02-19 16:40:31','2024-02-20','主诉6','病史6','诊断6','','用户账号6','用户姓名6'),(1708361287329,'2024-02-19 16:48:06','2024-02-20','输入信息','输入信息','输入信息','file/1708361286007.jpg','123','李李');
/*!40000 ALTER TABLE `binglidan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'swiper1','file/swiperPicture1.jpg'),(2,'swiper2','file/swiperPicture2.jpg'),(3,'swiper3','file/swiperPicture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangjihua`
--

DROP TABLE IF EXISTS `jiankangjihua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangjihua` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `riqi` date DEFAULT NULL COMMENT '日期',
  `jihuamingcheng` varchar(200) DEFAULT NULL COMMENT '计划名称',
  `jihuaneirong` longtext COMMENT '计划内容',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361308150 DEFAULT CHARSET=utf8 COMMENT='健康计划';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangjihua`
--

LOCK TABLES `jiankangjihua` WRITE;
/*!40000 ALTER TABLE `jiankangjihua` DISABLE KEYS */;
INSERT INTO `jiankangjihua` VALUES (81,'2024-02-19 16:40:31','2024-02-20','计划名称1','计划内容1','用户账号1','用户姓名1'),(82,'2024-02-19 16:40:31','2024-02-20','计划名称2','计划内容2','用户账号2','用户姓名2'),(83,'2024-02-19 16:40:31','2024-02-20','计划名称3','计划内容3','用户账号3','用户姓名3'),(84,'2024-02-19 16:40:31','2024-02-20','计划名称4','计划内容4','用户账号4','用户姓名4'),(85,'2024-02-19 16:40:31','2024-02-20','计划名称5','计划内容5','用户账号5','用户姓名5'),(86,'2024-02-19 16:40:31','2024-02-20','计划名称6','计划内容6','用户账号6','用户姓名6'),(1708361308149,'2024-02-19 16:48:27','2024-02-20','输入信息','输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息','123','李李');
/*!40000 ALTER TABLE `jiankangjihua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangshipu`
--

DROP TABLE IF EXISTS `jiankangshipu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangshipu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shipumingcheng` varchar(200) NOT NULL COMMENT '食谱名称',
  `fengmian` longtext COMMENT '封面',
  `shiherenqun` varchar(200) NOT NULL COMMENT '适合人群',
  `cailiao` varchar(200) DEFAULT NULL COMMENT '材料',
  `shipugongxiao` varchar(200) DEFAULT NULL COMMENT '食谱功效',
  `zhizuofangfa` longtext COMMENT '制作方法',
  `storeupnum` int(11) DEFAULT NULL COMMENT '收藏数量',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT NULL COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='健康食谱';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangshipu`
--

LOCK TABLES `jiankangshipu` WRITE;
/*!40000 ALTER TABLE `jiankangshipu` DISABLE KEYS */;
INSERT INTO `jiankangshipu` VALUES (91,'2024-02-19 16:40:31','食谱名称1','file/jiankangshipuFengmian1.jpg,file/jiankangshipuFengmian2.jpg,file/jiankangshipuFengmian3.jpg','适合人群1','材料1','食谱功效1','制作方法1',1,'2024-02-20 00:40:31',1),(92,'2024-02-19 16:40:31','食谱名称2','file/jiankangshipuFengmian2.jpg,file/jiankangshipuFengmian3.jpg,file/jiankangshipuFengmian4.jpg','适合人群2','材料2','食谱功效2','制作方法2',2,'2024-02-20 00:40:31',2),(93,'2024-02-19 16:40:31','食谱名称3','file/jiankangshipuFengmian3.jpg,file/jiankangshipuFengmian4.jpg,file/jiankangshipuFengmian5.jpg','适合人群3','材料3','食谱功效3','制作方法3',3,'2024-02-20 00:40:31',3),(94,'2024-02-19 16:40:31','食谱名称4','file/jiankangshipuFengmian4.jpg,file/jiankangshipuFengmian5.jpg,file/jiankangshipuFengmian6.jpg','适合人群4','材料4','食谱功效4','制作方法4',4,'2024-02-20 00:40:31',4),(95,'2024-02-19 16:40:31','食谱名称5','file/jiankangshipuFengmian5.jpg,file/jiankangshipuFengmian6.jpg,file/jiankangshipuFengmian7.jpg','适合人群5','材料5','食谱功效5','制作方法5',5,'2024-02-20 00:40:31',5),(96,'2024-02-19 16:40:31','食谱名称6','file/jiankangshipuFengmian6.jpg','适合人群6','材料6','食谱功效6','<p>制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6制作方法6</p>',6,'2024-02-20 00:49:35',7);
/*!40000 ALTER TABLE `jiankangshipu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangshuju`
--

DROP TABLE IF EXISTS `jiankangshuju`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangshuju` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `riqi` datetime DEFAULT NULL COMMENT '日期',
  `bushu` varchar(200) DEFAULT NULL COMMENT '步数',
  `xinlv` varchar(200) DEFAULT NULL COMMENT '心率',
  `xueya` varchar(200) DEFAULT NULL COMMENT '血压',
  `xuetang` varchar(200) DEFAULT NULL COMMENT '血糖',
  `tizhong` varchar(200) DEFAULT NULL COMMENT '体重',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361171537 DEFAULT CHARSET=utf8 COMMENT='健康数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangshuju`
--

LOCK TABLES `jiankangshuju` WRITE;
/*!40000 ALTER TABLE `jiankangshuju` DISABLE KEYS */;
INSERT INTO `jiankangshuju` VALUES (51,'2024-02-19 16:40:31','2024-02-20 00:40:31','步数1','心率1','血压1','血糖1','体重1','用户账号1','用户姓名1'),(52,'2024-02-19 16:40:31','2024-02-20 00:40:31','步数2','心率2','血压2','血糖2','体重2','用户账号2','用户姓名2'),(53,'2024-02-19 16:40:31','2024-02-20 00:40:31','步数3','心率3','血压3','血糖3','体重3','用户账号3','用户姓名3'),(54,'2024-02-19 16:40:31','2024-02-20 00:40:31','步数4','心率4','血压4','血糖4','体重4','用户账号4','用户姓名4'),(55,'2024-02-19 16:40:31','2024-02-20 00:40:31','步数5','心率5','血压5','血糖5','体重5','用户账号5','用户姓名5'),(56,'2024-02-19 16:40:31','2024-02-20 00:40:31','步数6','心率6','血压6','血糖6','体重6','用户账号6','用户姓名6'),(1708361171536,'2024-02-19 16:46:10','2024-02-20 00:45:19','333','44','44','44','44','123','李李');
/*!40000 ALTER TABLE `jiankangshuju` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangzhishi`
--

DROP TABLE IF EXISTS `jiankangzhishi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangzhishi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `tupian` longtext COMMENT '图片',
  `jianjie` longtext COMMENT '简介',
  `neirong` longtext COMMENT '内容',
  `fabiaoriqi` date NOT NULL COMMENT '发表日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='健康知识';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangzhishi`
--

LOCK TABLES `jiankangzhishi` WRITE;
/*!40000 ALTER TABLE `jiankangzhishi` DISABLE KEYS */;
INSERT INTO `jiankangzhishi` VALUES (111,'2024-02-19 16:40:31','标题1','file/jiankangzhishiTupian1.jpg,file/jiankangzhishiTupian2.jpg,file/jiankangzhishiTupian3.jpg','简介1','内容1','2024-02-20'),(112,'2024-02-19 16:40:31','标题2','file/jiankangzhishiTupian2.jpg,file/jiankangzhishiTupian3.jpg,file/jiankangzhishiTupian4.jpg','简介2','内容2','2024-02-20'),(113,'2024-02-19 16:40:31','标题3','file/jiankangzhishiTupian3.jpg,file/jiankangzhishiTupian4.jpg,file/jiankangzhishiTupian5.jpg','简介3','内容3','2024-02-20'),(114,'2024-02-19 16:40:31','标题4','file/jiankangzhishiTupian4.jpg,file/jiankangzhishiTupian5.jpg,file/jiankangzhishiTupian6.jpg','简介4','内容4','2024-02-20'),(115,'2024-02-19 16:40:31','标题5','file/jiankangzhishiTupian5.jpg,file/jiankangzhishiTupian6.jpg,file/jiankangzhishiTupian7.jpg','简介5','内容5','2024-02-20'),(116,'2024-02-19 16:40:31','标题6','file/jiankangzhishiTupian6.jpg,file/jiankangzhishiTupian7.jpg,file/jiankangzhishiTupian8.jpg','输入信息输入信息输入信息输入信息','<p>输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息输入信息</p>','2024-02-20');
/*!40000 ALTER TABLE `jiankangzhishi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-02-19 16:40:31','[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common47\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"},{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"}],\"fontClass\":\"icon-common8\",\"menu\":\"系统用户管理\",\"unicode\":\"&#xedb6;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"回复\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"fontClass\":\"icon-common44\",\"menu\":\"留言板管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康知识\",\"menuJump\":\"列表\",\"tableName\":\"jiankangzhishi\"}],\"fontClass\":\"icon-common47\",\"menu\":\"健康知识管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康食谱\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshipu\"}],\"fontClass\":\"icon-common50\",\"menu\":\"健康食谱管理\",\"unicode\":\"&#xef96;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康数据管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"饮食建议\"],\"menu\":\"体检报告\",\"menuJump\":\"列表\",\"tableName\":\"tijianbaogao\"}],\"fontClass\":\"icon-common12\",\"menu\":\"体检报告管理\",\"unicode\":\"&#xedf4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"病例单\",\"menuJump\":\"列表\",\"tableName\":\"binglidan\"}],\"fontClass\":\"icon-common29\",\"menu\":\"病例单管理\",\"unicode\":\"&#xee2e;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康计划\",\"menuJump\":\"列表\",\"tableName\":\"jiankangjihua\"}],\"fontClass\":\"icon-common47\",\"menu\":\"健康计划管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common48\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xef65;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"fontClass\":\"icon-common44\",\"menu\":\"留言板管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康数据管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"体检报告\",\"menuJump\":\"列表\",\"tableName\":\"tijianbaogao\"}],\"fontClass\":\"icon-common12\",\"menu\":\"体检报告管理\",\"unicode\":\"&#xedf4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"病例单\",\"menuJump\":\"列表\",\"tableName\":\"binglidan\"}],\"fontClass\":\"icon-common29\",\"menu\":\"病例单管理\",\"unicode\":\"&#xee2e;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-flashlightopen\",\"buttons\":[\"查看\"],\"menu\":\"饮食建议\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"fontClass\":\"icon-common21\",\"menu\":\"饮食建议管理\",\"unicode\":\"&#xee03;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"健康计划\",\"menuJump\":\"列表\",\"tableName\":\"jiankangjihua\"}],\"fontClass\":\"icon-common47\",\"menu\":\"健康计划管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"查看\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common48\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xef65;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '留言人id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `content` longtext NOT NULL COMMENT '留言内容',
  `cpicture` longtext COMMENT '留言图片',
  `reply` longtext COMMENT '回复内容',
  `rpicture` longtext COMMENT '回复图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361102680 DEFAULT CHARSET=utf8 COMMENT='留言板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (31,'2024-02-19 16:40:31',1,'用户名1','file/messagesAvatarurl1.jpg','留言内容1','file/messagesCpicture1.jpg','回复内容1','file/messagesRpicture1.jpg'),(32,'2024-02-19 16:40:31',2,'用户名2','file/messagesAvatarurl2.jpg','留言内容2','file/messagesCpicture2.jpg','回复内容2','file/messagesRpicture2.jpg'),(33,'2024-02-19 16:40:31',3,'用户名3','file/messagesAvatarurl3.jpg','留言内容3','file/messagesCpicture3.jpg','回复内容3','file/messagesRpicture3.jpg'),(34,'2024-02-19 16:40:31',4,'用户名4','file/messagesAvatarurl4.jpg','留言内容4','file/messagesCpicture4.jpg','回复内容4','file/messagesRpicture4.jpg'),(35,'2024-02-19 16:40:31',5,'用户名5','file/messagesAvatarurl5.jpg','留言内容5','file/messagesCpicture5.jpg','回复内容5','file/messagesRpicture5.jpg'),(36,'2024-02-19 16:40:31',6,'用户名6','file/messagesAvatarurl6.jpg','留言内容6','file/messagesCpicture6.jpg','回复内容6','file/messagesRpicture6.jpg'),(1708361102679,'2024-02-19 16:45:02',1708361056935,'123','file/1708361050795.jpeg','<p>你好</p>','','<p>你也好</p>',NULL);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT NULL COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tijianbaogao`
--

DROP TABLE IF EXISTS `tijianbaogao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tijianbaogao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tijianriqi` date DEFAULT NULL COMMENT '体检日期',
  `zhuyaobingshi` varchar(200) DEFAULT NULL COMMENT '主要病史',
  `shengao` varchar(200) DEFAULT NULL COMMENT '身高/cm',
  `tizhong` varchar(200) DEFAULT NULL COMMENT '体重/kg',
  `jianchaxiangmu` varchar(200) DEFAULT NULL COMMENT '检查项目',
  `jianchajieguo` longtext COMMENT '检查结果',
  `jianchayijian` varchar(200) DEFAULT NULL COMMENT '检查意见',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `fujian` longtext COMMENT '附件',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `sfsh` varchar(200) DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361266603 DEFAULT CHARSET=utf8 COMMENT='体检报告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tijianbaogao`
--

LOCK TABLES `tijianbaogao` WRITE;
/*!40000 ALTER TABLE `tijianbaogao` DISABLE KEYS */;
INSERT INTO `tijianbaogao` VALUES (61,'2024-02-19 16:40:31','2024-02-20','主要病史1','身高/cm1','体重/kg1','检查项目1','','检查意见1','备注1','','用户账号1','用户姓名1','是',''),(62,'2024-02-19 16:40:31','2024-02-20','主要病史2','身高/cm2','体重/kg2','检查项目2','','检查意见2','备注2','','用户账号2','用户姓名2','是',''),(63,'2024-02-19 16:40:31','2024-02-20','主要病史3','身高/cm3','体重/kg3','检查项目3','','检查意见3','备注3','','用户账号3','用户姓名3','是',''),(64,'2024-02-19 16:40:31','2024-02-20','主要病史4','身高/cm4','体重/kg4','检查项目4','','检查意见4','备注4','','用户账号4','用户姓名4','是',''),(65,'2024-02-19 16:40:31','2024-02-20','主要病史5','身高/cm5','体重/kg5','检查项目5','','检查意见5','备注5','','用户账号5','用户姓名5','是',''),(66,'2024-02-19 16:40:31','2024-02-20','主要病史6','身高/cm6','体重/kg6','检查项目6','','检查意见6','备注6','','用户账号6','用户姓名6','是',''),(1708361266602,'2024-02-19 16:47:45','2024-02-20','输入信息','166','66','输入信息','file/1708361264313.jpg','输入信息','输入信息','','123','李李','是','1111');
/*!40000 ALTER TABLE `tijianbaogao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1708361056935,'123','yonghu','用户','3uzjsb8fldojb46ckiwoe5osj1ldts1i','2024-02-19 16:44:53','2024-02-19 17:44:53'),(2,1,'admin','users','管理员','ovmzul5529nfqs4z35pbhmjitp2hqqxc','2024-02-19 16:48:43','2024-02-19 17:48:43');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-02-19 16:40:31','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yinshijianyi`
--

DROP TABLE IF EXISTS `yinshijianyi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yinshijianyi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `riqi` datetime DEFAULT NULL COMMENT '日期',
  `yinshijianyi` longtext COMMENT '饮食建议',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361425346 DEFAULT CHARSET=utf8 COMMENT='饮食建议';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yinshijianyi`
--

LOCK TABLES `yinshijianyi` WRITE;
/*!40000 ALTER TABLE `yinshijianyi` DISABLE KEYS */;
INSERT INTO `yinshijianyi` VALUES (121,'2024-02-19 16:40:31','用户账号1','用户姓名1','2024-02-20 00:40:31','饮食建议1'),(122,'2024-02-19 16:40:31','用户账号2','用户姓名2','2024-02-20 00:40:31','饮食建议2'),(123,'2024-02-19 16:40:31','用户账号3','用户姓名3','2024-02-20 00:40:31','饮食建议3'),(124,'2024-02-19 16:40:31','用户账号4','用户姓名4','2024-02-20 00:40:31','饮食建议4'),(125,'2024-02-19 16:40:31','用户账号5','用户姓名5','2024-02-20 00:40:31','饮食建议5'),(126,'2024-02-19 16:40:31','用户账号6','用户姓名6','2024-02-20 00:40:31','饮食建议6'),(1708361425345,'2024-02-19 16:50:24','123','李李','2024-02-20 00:50:27','<p>输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议输入建议</p>');
/*!40000 ALTER TABLE `yinshijianyi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) NOT NULL COMMENT '用户账号',
  `yonghumima` varchar(200) NOT NULL COMMENT '用户密码',
  `yonghuxingming` varchar(200) NOT NULL COMMENT '用户姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuzhanghao` (`yonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1708361056936 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (41,'2024-02-19 16:40:31','用户账号1','e10adc3949ba59abbe56e057f20f883e','用户姓名1','file/yonghuTouxiang1.jpg','男','19819881111'),(42,'2024-02-19 16:40:31','用户账号2','e10adc3949ba59abbe56e057f20f883e','用户姓名2','file/yonghuTouxiang2.jpg','男','19819881112'),(43,'2024-02-19 16:40:31','用户账号3','e10adc3949ba59abbe56e057f20f883e','用户姓名3','file/yonghuTouxiang3.jpg','男','19819881113'),(44,'2024-02-19 16:40:31','用户账号4','e10adc3949ba59abbe56e057f20f883e','用户姓名4','file/yonghuTouxiang4.jpg','男','19819881114'),(45,'2024-02-19 16:40:31','用户账号5','e10adc3949ba59abbe56e057f20f883e','用户姓名5','file/yonghuTouxiang5.jpg','男','19819881115'),(46,'2024-02-19 16:40:31','用户账号6','e10adc3949ba59abbe56e057f20f883e','用户姓名6','file/yonghuTouxiang6.jpg','男','19819881116'),(1708361056935,'2024-02-19 16:44:16','123','202cb962ac59075b964b07152d234b70','李李','file/1708361050795.jpeg','女','13555555555');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-23 17:29:56
