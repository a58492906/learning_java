CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `question` varchar(50) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(50) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) DEFAULT '1' COMMENT '角色 0-管理员，1-普通用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `field_real_name` varchar(100) DEFAULT NULL COMMENT '字段映射的真实表内字段名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_center_metadata_rule`
--
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父类别 id-0说明是根结点',
  `name` varchar(100) DEFAULT NULL COMMENT '类别名称',
  `status` int(11) DEFAULT '1' COMMENT '类别状态 1-正常2，废弃',
  `sort_order` int(11) DEFAULT NULL COMMENT '排序编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `sub_title` varchar(100) DEFAULT NULL COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT NULL COMMENT '商品主图',
  `sub_images` text  COMMENT '图片地址，json格式',
  `detail` text  COMMENT '商品详情',
  `price` decimal(20,2) NOT NULL COMMENT '价格',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `status` int(11) DEFAULT '1' COMMENT '商品状态 1-在售，2下架，3删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE `transaction` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255)  NOT NULL COMMENT '交易单号',
  `member_id` bigint(20) NOT NULL COMMENT '交易的用户ID',
  `amount` decimal(20,2) NOT NULL COMMENT '交易金额',
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '使用的积分',
  `pay_state` tinyint(4) NOT NULL COMMENT '支付类型 0:余额 1:微信 2:支付宝 3:xxx',
  `source` varchar(255)  NOT NULL COMMENT '支付来源 wx app web wap',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付状态 -1：取消 0 未完成 1已完成 -2:异常',
  `completion_time` int(11) NOT NULL COMMENT '交易完成时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE `transaction_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255)  NOT NULL,
  `events` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件详情',
  `result` text COLLATE utf8mb4_unicode_ci COMMENT '结果详情',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
--
-- Table structure for table `data_center_metadata_rule_index`
--
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255)  NOT NULL COMMENT '订单号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ip',
  `shipping_id` int(10) unsigned NOT NULL COMMENT '收货id',
  `payment` decimal(20,2) NOT NULL COMMENT '付款金额',
  `transaction_id` int(10) unsigned NOT NULL COMMENT '交易id',
  `postage` int(10) unsigned NOT NULL COMMENT '运费',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态 -1：取消 0 未完成 1已完成 -2:异常',
  `payment_time` datetime DEFAULT NULL  COMMENT '支付时间',
  `send_time` datetime DEFAULT NULL  COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL  COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL  COMMENT '交易关闭时间',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

  CREATE TABLE `shipping` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ip',
  `receiver_name` varchar(50)  NOT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(50)  NOT NULL COMMENT '收货电话',
  `receiver_province` varchar(50)  NOT NULL COMMENT '省份',
  `receiver_city` varchar(50)  NOT NULL COMMENT '城市',
  `receiver_district` varchar(50)  NOT NULL COMMENT '区/县',
  `receiver_address` varchar(50)  NOT NULL COMMENT '详细地址',
  `receiver_code` varchar(50)  NOT NULL COMMENT '邮编',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;