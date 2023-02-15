

-- ----------------------------
-- Table structure for user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `user_wallet`;
CREATE TABLE `user_wallet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `wallet_amount` decimal(7,2) DEFAULT NULL COMMENT '钱包余额',
  `threshold` decimal(10,0) DEFAULT NULL COMMENT '支付金额阀值',
  `pay_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '支付密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_wallet_record
-- ----------------------------
DROP TABLE IF EXISTS `user_wallet_record`;
CREATE TABLE `user_wallet_record` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '钱包id',
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `amount` decimal(7,2) DEFAULT NULL COMMENT '金额',
  `old_amount` decimal(7,2) DEFAULT NULL COMMENT '旧的金额',
  `type` int DEFAULT NULL COMMENT '0-支出 1-退款 2-提现',
  `bank_serial_number` int DEFAULT NULL COMMENT '银行流水号',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;