-- ----------------------------
-- Table structure for t_prod_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_brand`;
CREATE TABLE `t_prod_brand`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌编号',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品品牌' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_brand
-- ----------------------------
INSERT INTO `t_prod_brand` VALUES ('45d57d7fe8f911ea9fb1000c299a2318', '水星（MERCURY）', 'B0014090020200828', '0', '1', NULL, '2020-08-28 14:39:54', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('4a170550e8f911ea9fb1000c299a2318', '腾达（Tenda）', 'B0014100020200828', '0', '1', NULL, '2020-08-28 14:40:01', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('4f69ab6ee8f911ea9fb1000c299a2318', '海康威视（HIKVISION）', 'B0014110020200828', '0', '1', NULL, '2020-08-28 14:40:10', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('53ed19c8e8f911ea9fb1000c299a2318', '思科（CISCO）', 'B0014120020200828', '0', '1', NULL, '2020-08-28 14:40:17', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('586c23fde8f911ea9fb1000c299a2318', '网件（NETGEAR）', 'B0014130020200828', '0', '1', NULL, '2020-08-28 14:40:25', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('5c74ecf4e8f911ea9fb1000c299a2318', '锐捷（Ruijie）', 'B0014140020200828', '0', '1', NULL, '2020-08-28 14:40:32', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('60f21808e8f911ea9fb1000c299a2318', 'FAST 友讯（D-Link）', 'B0014150020200828', '0', '1', NULL, '2020-08-28 14:40:39', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('662593fae8f911ea9fb1000c299a2318', 'keepLINK 磊科（netcore）', 'B0014160020200828', '0', '1', NULL, '2020-08-28 14:40:48', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('6a4b18f4e8f911ea9fb1000c299a2318', '威联通（QNAP）', 'B0014170020200828', '0', '1', NULL, '2020-08-28 14:40:55', NULL, NULL, NULL);
INSERT INTO `t_prod_brand` VALUES ('b60a64aee8f411ea9fb1000c299a2318', '戴尔（DELL）', 'B0014080020200828', '0', '1', NULL, '2020-08-28 14:07:14', NULL, '2020-08-28 14:41:11', NULL);
INSERT INTO `t_prod_brand` VALUES ('c8b2052ce6b311ea9fb1000c299a2318', '普联（TP-LINK）', 'B0014050020200828', '0', '1', NULL, '2020-08-25 17:17:24', NULL, '2020-08-28 14:39:34', '普联（TP-LINK）');
INSERT INTO `t_prod_brand` VALUES ('d2937be1e6b311ea9fb1000c299a2318', '华为（HUAWEI）', 'B0014060020200828', '0', '1', NULL, '2020-08-25 17:17:41', NULL, '2020-08-28 14:38:52', '华为（HUAWEI）');
INSERT INTO `t_prod_brand` VALUES ('e0e094a7e6b311ea9fb1000c299a2318', '华三（H3C）', 'B0014070020200828', '0', '1', NULL, '2020-08-25 17:18:05', NULL, '2020-08-28 14:39:45', ' 华三（H3C）');

-- ----------------------------
-- Table structure for t_prod_category
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_category`;
CREATE TABLE `t_prod_category`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型编号',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `alias` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型别名',
  `pid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父ID',
  `icon` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型图标',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `ancestors` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '祖级列表',
  `full_name` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '全名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_category
-- ----------------------------
INSERT INTO `t_prod_category` VALUES ('0560ae68e86211ea9fb1000c299a2318', 'C0014050020200828', '机架服务器', NULL, 'db852365e86111ea9fb1000c299a2318', NULL, '0', '1', NULL, '2020-08-27 20:37:10', NULL, '2020-08-28 14:03:54', NULL, '0,db852365e86111ea9fb1000c299a2318', '/服务器/机架服务器');
INSERT INTO `t_prod_category` VALUES ('0b1da376e86211ea9fb1000c299a2318', 'C0014060020200828', '塔式服务器', NULL, 'db852365e86111ea9fb1000c299a2318', NULL, '0', '1', NULL, '2020-08-27 20:37:20', NULL, '2020-08-28 14:04:04', NULL, '0,db852365e86111ea9fb1000c299a2318', '/服务器/塔式服务器');
INSERT INTO `t_prod_category` VALUES ('7dcc57dbe8f411ea9fb1000c299a2318', 'C0014110020200828', '其他设备', NULL, '0', NULL, '0', '1', NULL, '2020-08-28 14:05:40', NULL, NULL, NULL, '0', '/其他设备');
INSERT INTO `t_prod_category` VALUES ('db852365e86111ea9fb1000c299a2318', 'C0014040020200828', '服务器', NULL, '0', NULL, '0', '1', NULL, '2020-08-27 20:36:00', NULL, '2020-08-28 14:03:41', NULL, '0', '/服务器');
INSERT INTO `t_prod_category` VALUES ('dc178e57e92411ea9fb1000c299a2318', 'C0014120020200828', '打印机', NULL, '7dcc57dbe8f411ea9fb1000c299a2318', NULL, '0', '1', NULL, '2020-08-28 19:51:54', NULL, NULL, NULL, '0,7dcc57dbe8f411ea9fb1000c299a2318', '/其他设备/打印机');
INSERT INTO `t_prod_category` VALUES ('e4c521b9e86211ea9fb1000c299a2318', 'C0014080020200828', '防火墙', NULL, 'f4f3bcb2e86111ea9fb1000c299a2318', NULL, '0', '1', NULL, '2020-08-27 20:43:25', NULL, '2020-08-28 14:04:27', NULL, '0,f4f3bcb2e86111ea9fb1000c299a2318', '/安全设备/防火墙');
INSERT INTO `t_prod_category` VALUES ('ed1e6c1de86211ea9fb1000c299a2318', 'C0014100020200828', '交换机', NULL, 'fa35d62de86111ea9fb1000c299a2318', NULL, '0', '1', NULL, '2020-08-27 20:43:39', NULL, '2020-08-28 14:04:50', NULL, '0,fa35d62de86111ea9fb1000c299a2318', '/网络设备/交换机');
INSERT INTO `t_prod_category` VALUES ('f4f3bcb2e86111ea9fb1000c299a2318', 'C0014070020200828', '安全设备', NULL, '0', NULL, '0', '1', NULL, '2020-08-27 20:36:43', NULL, '2020-08-28 14:04:14', NULL, '0', '/安全设备');
INSERT INTO `t_prod_category` VALUES ('fa35d62de86111ea9fb1000c299a2318', 'C0014090020200828', '网络设备', NULL, '0', NULL, '0', '1', NULL, '2020-08-27 20:36:52', NULL, '2020-08-28 14:04:39', NULL, '0', '/网络设备');

-- ----------------------------
-- Table structure for t_prod_category_prop_rlt
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_category_prop_rlt`;
CREATE TABLE `t_prod_category_prop_rlt`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `prod_category_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品类型ID',
  `prod_prop_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品扩展属性ID',
  `prop_sort` int(10) NULL DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品类型属性关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_category_prop_rlt
-- ----------------------------
INSERT INTO `t_prod_category_prop_rlt` VALUES ('59057a21e92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '1fc9e77de90611ea9fb1000c299a2318', 1);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('5906babde92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 2);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('5907bc0ae92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '3fe1d7d9e90511ea9fb1000c299a2318', 3);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('5908bee8e92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '3fe28ee5e86811ea9fb1000c299a2318', 4);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('5909d3e6e92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '4cc29896e86811ea9fb1000c299a2318', 5);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('590ab1e0e92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '6ac41402e90611ea9fb1000c299a2318', 6);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('590c1d59e92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '72259dcae90511ea9fb1000c299a2318', 7);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('590d060ce92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '7ac5c528e90611ea9fb1000c299a2318', 8);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('590e5c5ee92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '816df620e90611ea9fb1000c299a2318', 9);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('590f9721e92811ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '8ab4103be90511ea9fb1000c299a2318', 10);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('765dcf76e86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 1);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('765fbf20e86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', '3fe28ee5e86811ea9fb1000c299a2318', 2);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('76636448e86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', '4cc29896e86811ea9fb1000c299a2318', 3);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('7665f52de86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', 'a41c16dae86711ea9fb1000c299a2318', 4);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('76687fd7e86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', 'afa3c4c6e86711ea9fb1000c299a2318', 5);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('7669cd86e86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', 'bb76ecb4e86711ea9fb1000c299a2318', 6);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('766af7cbe86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', 'c7b95843e86711ea9fb1000c299a2318', 7);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('766f515be86811ea9fb1000c299a2318', '0560ae68e86211ea9fb1000c299a2318', 'd28b4dafe86711ea9fb1000c299a2318', 8);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('89de9a81ed1011ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '89d9b33ced1011ea9fb1000c299a2318', 20);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('9bf6e4ceed0a11ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', '9bf339e5ed0a11ea9fb1000c299a2318', 11);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('b9c1f9e4ed1b11ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'b9bc1d34ed1b11ea9fb1000c299a2318', 21);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('babc76bbed1911ea9fb1000c299a2318', 'dc178e57e92411ea9fb1000c299a2318', 'bab95a5bed1911ea9fb1000c299a2318', 12);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d1405b83e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '1fc9e77de90611ea9fb1000c299a2318', 1);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d149e283e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 2);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d14beab6e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '3fe1d7d9e90511ea9fb1000c299a2318', 3);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d1501d71e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '6ac41402e90611ea9fb1000c299a2318', 4);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d1539261e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '72259dcae90511ea9fb1000c299a2318', 5);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d15743c8e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '7ac5c528e90611ea9fb1000c299a2318', 6);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d15858fbe90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '816df620e90611ea9fb1000c299a2318', 7);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d1598b7de90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '8ab4103be90511ea9fb1000c299a2318', 8);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d890fad1e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '8dd27cece90611ea9fb1000c299a2318', 9);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d893b796e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '93ed4ebbe90611ea9fb1000c299a2318', 10);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d89525c5e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', '9edced69e90611ea9fb1000c299a2318', 11);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d898072ee90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'a2967614e90611ea9fb1000c299a2318', 12);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d89b8bd7e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'aec2b9b9e90611ea9fb1000c299a2318', 13);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('d89f3491e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'af4d1897e90511ea9fb1000c299a2318', 14);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('dda95cd0e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 1);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddaf7f78e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', 'afa3c4c6e86711ea9fb1000c299a2318', 2);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddb20f55e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', 'bb76ecb4e86711ea9fb1000c299a2318', 3);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddb5ea14e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', 'd28b4dafe86711ea9fb1000c299a2318', 4);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddb9bb38e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', 'c7b95843e86711ea9fb1000c299a2318', 5);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddbd9631e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', 'a41c16dae86711ea9fb1000c299a2318', 6);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddc148e5e86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', '4cc29896e86811ea9fb1000c299a2318', 7);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddc507fae86811ea9fb1000c299a2318', '0b1da376e86211ea9fb1000c299a2318', '3fe28ee5e86811ea9fb1000c299a2318', 8);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddf54e51e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'b52317cee90611ea9fb1000c299a2318', 15);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddf95b2ee90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'c080e0f1e90611ea9fb1000c299a2318', 16);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('ddfb24afe90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'd7997f96e90411ea9fb1000c299a2318', 17);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('e69fd925e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'e89efaa6e90511ea9fb1000c299a2318', 18);
INSERT INTO `t_prod_category_prop_rlt` VALUES ('e6aac109e90611ea9fb1000c299a2318', 'ed1e6c1de86211ea9fb1000c299a2318', 'f57a3966e90411ea9fb1000c299a2318', 19);

-- ----------------------------
-- Table structure for t_prod_enum
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_enum`;
CREATE TABLE `t_prod_enum`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `enum_sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `pid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父ID',
  `prod_prop_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展属性ID',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `enum_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '枚举标签',
  `enum_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '枚举键值',
  `flag_default` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否默认',
  `css_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '枚举属性表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_enum
-- ----------------------------
INSERT INTO `t_prod_enum` VALUES ('26cfc1dfed1411ea9fb1000c299a2318', 1, NULL, '1fc9e77de90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:02:21', NULL, NULL, NULL, '微型网络', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('26d49938ed1411ea9fb1000c299a2318', 1, NULL, '1fc9e77de90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:02:21', NULL, NULL, NULL, '小型网络', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('26d733c0ed1411ea9fb1000c299a2318', 1, NULL, '1fc9e77de90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:02:21', NULL, NULL, NULL, '中小型网络', '3', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('26d858bded1411ea9fb1000c299a2318', 1, NULL, '1fc9e77de90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:02:21', NULL, NULL, NULL, '中大型网络', '4', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('26d9ca53ed1411ea9fb1000c299a2318', 1, NULL, '1fc9e77de90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:02:21', NULL, NULL, NULL, '大型网络', '5', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('6ac6ba10e90611ea9fb1000c299a2318', 1, NULL, '6ac41402e90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:13:59', NULL, NULL, NULL, '桌面式交换机', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('6ac9065de90611ea9fb1000c299a2318', 1, NULL, '6ac41402e90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:13:59', NULL, NULL, NULL, '19英寸（标准机架）', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('6acb7db8e90611ea9fb1000c299a2318', 1, NULL, '6ac41402e90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:13:59', NULL, NULL, NULL, '框架式交换机', '3', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('6acebcaae90611ea9fb1000c299a2318', 1, NULL, '6ac41402e90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:13:59', NULL, NULL, NULL, '13英寸', '4', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('6ad1ebdae90611ea9fb1000c299a2318', 1, NULL, '6ac41402e90611ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:13:59', NULL, NULL, NULL, '11英寸', '5', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('7228a35fe90511ea9fb1000c299a2318', 1, NULL, '72259dcae90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:07:02', NULL, NULL, NULL, '百兆', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('722b0618e90511ea9fb1000c299a2318', 1, NULL, '72259dcae90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:07:02', NULL, NULL, NULL, '千兆', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('722d928be90511ea9fb1000c299a2318', 1, NULL, '72259dcae90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:07:02', NULL, NULL, NULL, '万兆', '3', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('722ea370e90511ea9fb1000c299a2318', 1, NULL, '72259dcae90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:07:02', NULL, NULL, NULL, '40G', '4', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('8ab86bdfe90511ea9fb1000c299a2318', 1, NULL, '8ab4103be90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:07:43', NULL, NULL, NULL, '网管', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('8abb08e2e90511ea9fb1000c299a2318', 1, NULL, '8ab4103be90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:07:43', NULL, NULL, NULL, '非网管', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('af514300e90511ea9fb1000c299a2318', 1, NULL, 'af4d1897e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:08:45', NULL, NULL, NULL, 'POE供电', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('af53cf23e90511ea9fb1000c299a2318', 1, NULL, 'af4d1897e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:08:45', NULL, NULL, NULL, '非POE供电', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('babebf95ed1911ea9fb1000c299a2318', 1, NULL, 'bab95a5bed1911ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:42:16', NULL, NULL, NULL, '30CM', '1', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('bac0fe1bed1911ea9fb1000c299a2318', 2, NULL, 'bab95a5bed1911ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:42:16', NULL, NULL, NULL, '40CM', '2', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('bac25b71ed1911ea9fb1000c299a2318', 3, NULL, 'bab95a5bed1911ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 20:42:16', NULL, NULL, NULL, '50CM', '3', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('c9b3a38fe90511ea9fb1000c299a2318', 1, NULL, '3fe1d7d9e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:09:29', NULL, NULL, NULL, '千兆', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('c9b64b7be90511ea9fb1000c299a2318', 1, NULL, '3fe1d7d9e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:09:29', NULL, NULL, NULL, '百兆', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('c9b8c8a3e90511ea9fb1000c299a2318', 1, NULL, '3fe1d7d9e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:09:29', NULL, NULL, NULL, '万兆', '3', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('c9bb483ae90511ea9fb1000c299a2318', 1, NULL, '3fe1d7d9e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:09:29', NULL, NULL, NULL, '千百兆组合', '4', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('dc9db52ae92811ea9fb1000c299a2318', 1, NULL, '2978bfa7e86811ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 20:20:30', NULL, NULL, NULL, '5口', '1', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('dca040b0e92811ea9fb1000c299a2318', 2, NULL, '2978bfa7e86811ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 20:20:30', NULL, NULL, NULL, '8口', '2', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('dca2cc42e92811ea9fb1000c299a2318', 3, NULL, '2978bfa7e86811ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 20:20:30', NULL, NULL, NULL, '16口', '3', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('dca46773e92811ea9fb1000c299a2318', 4, NULL, '2978bfa7e86811ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 20:20:30', NULL, NULL, NULL, '24口', '4', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('dca54d52e92811ea9fb1000c299a2318', 5, NULL, '2978bfa7e86811ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 20:20:30', NULL, NULL, NULL, '大于48口', '5', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('e8a436b0e90511ea9fb1000c299a2318', 1, NULL, 'e89efaa6e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:10:21', NULL, NULL, NULL, '以太网交换机', '1', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('e8a6da39e90511ea9fb1000c299a2318', 1, NULL, 'e89efaa6e90511ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:10:21', NULL, NULL, NULL, '光纤网交换机', '2', '2', NULL);
INSERT INTO `t_prod_enum` VALUES ('fd37675ced0a11ea9fb1000c299a2318', 1, NULL, 'fd319f4ced0a11ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 18:56:45', NULL, NULL, NULL, '30CM', '1', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('fd39aa39ed0a11ea9fb1000c299a2318', 1, NULL, 'fd319f4ced0a11ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 18:56:45', NULL, NULL, NULL, '40CM', '2', '1', NULL);
INSERT INTO `t_prod_enum` VALUES ('fd3a89f7ed0a11ea9fb1000c299a2318', 1, NULL, 'fd319f4ced0a11ea9fb1000c299a2318', '0', NULL, NULL, '2020-09-02 18:56:45', NULL, NULL, NULL, '50CM', '3', '2', NULL);

-- ----------------------------
-- Table structure for t_prod_exp
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_exp`;
CREATE TABLE `t_prod_exp`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `regular_exp` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正则表达式',
  `regular_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校验失败信息',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '正则表达式' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_exp
-- ----------------------------
INSERT INTO `t_prod_exp` VALUES ('0', '手机号', '^1[3|4|5|7|8][0-9]{9}$', '请输入正确的手机号', '0', NULL, NULL, '2020-08-24 17:43:33', NULL, '2020-08-26 18:49:52', NULL);
INSERT INTO `t_prod_exp` VALUES ('1a859332e8d311ea9fb1000c299a2318', '长度为3到20的字符', '^.{3,20}$', '请输入长度为3到20的字符', '0', NULL, NULL, '2020-08-28 10:06:40', NULL, '2020-09-01 11:07:18', NULL);
INSERT INTO `t_prod_exp` VALUES ('2c2a45c8e8d311ea9fb1000c299a2318', '英文字符', '^[A-Za-z]+$', '请输入英文字符', '0', NULL, NULL, '2020-08-28 10:07:09', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('3d55a0aee8d311ea9fb1000c299a2318', '大写英文字符', '^[A-Z]+$', '请输入大写英文字符', '0', NULL, NULL, '2020-08-28 10:07:38', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('5076797ee8d211ea9fb1000c299a2318', '邮政编码', '[1-9]\\d{5}(?!\\d) ', '请输入正确邮政编码', '0', NULL, NULL, '2020-08-28 10:01:01', NULL, '2020-08-28 10:01:57', NULL);
INSERT INTO `t_prod_exp` VALUES ('517934f9e8d311ea9fb1000c299a2318', '小写英文字符', '^[a-z]+$', '请输入小写引文字符', '0', NULL, NULL, '2020-08-28 10:08:12', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('7d88d712e8d311ea9fb1000c299a2318', '身份证号', '^((\\d{18})|([0-9x]{18})|([0-9X]{18}))$', '请输入正确的身份证号', '0', NULL, NULL, '2020-08-28 10:09:26', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('7fab8cfbe8d211ea9fb1000c299a2318', 'Email地址', '^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$', '请输入正确的Email地址', '0', NULL, NULL, '2020-08-28 10:02:20', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('90ee9ba6e8d211ea9fb1000c299a2318', '域名', '[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?', '请输入正确的域名', '0', NULL, NULL, '2020-08-28 10:02:49', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('e0be0180e8d211ea9fb1000c299a2318', '中文', '^[\\u4e00-\\u9fa5]{0,}$', '请输入中文', '0', NULL, NULL, '2020-08-28 10:05:03', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('f5f13edfe8d211ea9fb1000c299a2318', '英文和数字', '^[A-Za-z0-9]{4,40}$', '请输入英文和数字', '0', NULL, NULL, '2020-08-28 10:05:39', NULL, NULL, NULL);
INSERT INTO `t_prod_exp` VALUES ('f7326411e67911ea9fb1000c299a2318', 'IP地址', '/^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$/', '请输入正确的IP地址', '0', NULL, NULL, '2020-08-25 10:23:31', NULL, '2020-08-25 13:45:38', NULL);

-- ----------------------------
-- Table structure for t_prod_industry
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_industry`;
CREATE TABLE `t_prod_industry`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '行业名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '行业编号',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品行业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_industry
-- ----------------------------
INSERT INTO `t_prod_industry` VALUES ('752ed4fce6b411ea9fb1000c299a2318', '金融', 'I0014040020200828', '0', '1', NULL, '2020-08-25 17:22:14', NULL, '2020-08-28 14:07:38', '金融');
INSERT INTO `t_prod_industry` VALUES ('7b99fd67e6b411ea9fb1000c299a2318', '医疗', 'I0014050020200828', '0', '1', NULL, '2020-08-25 17:22:24', NULL, '2020-08-28 14:07:46', '医疗');
INSERT INTO `t_prod_industry` VALUES ('8234f2bce6b411ea9fb1000c299a2318', '公安', 'I0014060020200828', '0', '1', NULL, '2020-08-25 17:22:36', NULL, '2020-08-28 14:07:54', '公安');
INSERT INTO `t_prod_industry` VALUES ('e3283065e8f411ea9fb1000c299a2318', '运营商', 'I0014070020200828', '0', '1', NULL, '2020-08-28 14:08:30', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_prod_manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_manufacturer`;
CREATE TABLE `t_prod_manufacturer`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商编号',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商名称',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商地址',
  `contact` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contact_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品厂商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_manufacturer
-- ----------------------------
INSERT INTO `t_prod_manufacturer` VALUES ('17323ae6e8f011ea9fb1000c299a2318', 'M0015040020200828', '中国电信股份有限公司江苏分公司', '华南', '张磊表', '15332402366', '0', '1', NULL, '2020-08-28 13:34:10', NULL, '2020-08-28 14:49:22', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('1eff58e7e8f411ea9fb1000c299a2318', 'M0015070020200828', '思科系统(中国)网络技术有限公司', '美国', '张零', '16534235676', '0', '1', NULL, '2020-08-28 14:03:01', NULL, '2020-08-28 14:44:48', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('2b4c2d92e8fa11ea9fb1000c299a2318', 'M0015150020200828', '深圳市吉祥腾达科技有限公司', '上海', '王闯', '15332402345', '0', '1', NULL, '2020-08-28 14:46:19', NULL, '2020-08-28 19:15:59', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('34e2f001e8fa11ea9fb1000c299a2318', 'M0015160020200828', '友讯电子设备(上海)有限公司', '西安', '王天国', '15434235567', '0', '1', NULL, '2020-08-28 14:46:35', NULL, '2020-08-28 19:16:14', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('6e7ebb0ae6b611ea9fb1000c299a2318', 'M0015050020200828', '华为技术有限公司', '北京', '李三按', '16734567654', '0', '1', NULL, '2020-08-25 17:36:21', NULL, '2020-08-28 14:48:02', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('78c2a32ae6b611ea9fb1000c299a2318', 'M0015060020200828', '杭州海康威视数字技术股份有限公司 ', '上海', '王万林', '18734567654', '0', '1', NULL, '2020-08-25 17:36:39', NULL, '2020-08-28 14:48:34', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('c25112b4e8f911ea9fb1000c299a2318', 'M0015080020200828', '成都泽楷科技有限公司', '北京', '郑明富', '14356543345', '0', '1', NULL, '2020-08-28 14:43:23', NULL, '2020-08-28 19:16:31', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('d09e0f7ce8f911ea9fb1000c299a2318', 'M0015100020200828', '中兴通讯股份有限公司', '海南', '姚政超', '16756543323', '0', '1', NULL, '2020-08-28 14:43:47', NULL, '2020-08-28 19:17:14', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('d63b5691e8f911ea9fb1000c299a2318', 'M0015110020200828', '福建星网锐捷通讯股份有限公司', '天津', '王福军', '13878786678', '0', '1', NULL, '2020-08-28 14:43:56', NULL, '2020-08-28 19:17:45', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('dc79bf78e8f911ea9fb1000c299a2318', 'M0015120020200828', '普联技术有限公司', '西安', '王大海', '13566564534', '0', '1', NULL, '2020-08-28 14:44:06', NULL, '2020-08-28 19:18:06', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('e203a7d2e8f911ea9fb1000c299a2318', 'M0015130020200828', '网件(北京)网络技术有限公司', '海南', '谢傲', '15655454455', '0', '1', NULL, '2020-08-28 14:44:16', NULL, '2020-08-28 19:18:31', NULL);
INSERT INTO `t_prod_manufacturer` VALUES ('e6d1a2e3e8f911ea9fb1000c299a2318', 'M0015140020200828', 'JUNIPER瞻博', '惠州', '徐媛媛', '13456789909', '0', '1', NULL, '2020-08-28 14:44:24', NULL, '2020-08-28 19:18:52', NULL);

-- ----------------------------
-- Table structure for t_prod_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_order_detail`;
CREATE TABLE `t_prod_order_detail`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `order_master_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单主表ID',
  `prod_sku_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '产品细分ID',
  `prod_price` decimal(8, 2) NOT NULL COMMENT '产品价格',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `prod_qty` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_order_detail
-- ----------------------------
INSERT INTO `t_prod_order_detail` VALUES ('06e032b3e91311ea9fb1000c299a2318', '0675d021e91311ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 12999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `t_prod_order_detail` VALUES ('06e2e2a2e91311ea9fb1000c299a2318', '0675d021e91311ea9fb1000c299a2318', 'ccf2b299e8d811ea9fb1000c299a2318', 10000.12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('32621e61e91211ea9fb1000c299a2318', '325ed025e91211ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('7ea41a70e91011ea9fb1000c299a2318', '73cfb36ee91011ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('a6ed1574e91211ea9fb1000c299a2318', 'a6e88e5fe91211ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('afadcf73e91011ea9fb1000c299a2318', 'ad4bba43e91011ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('bb9d97f9e91211ea9fb1000c299a2318', 'bb9bc4a5e91211ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('bfe69c89e91011ea9fb1000c299a2318', 'bfe283a6e91011ea9fb1000c299a2318', '4aa3d343e8d811ea9fb1000c299a2318', 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('ed13e072f10b11ea9a87000c299a2318', 'ed070548f10b11ea9a87000c299a2318', '2907c17cee4f11ea9fb1000c299a2318', 9999.12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `t_prod_order_detail` VALUES ('ed17b288f10b11ea9a87000c299a2318', 'ed070548f10b11ea9a87000c299a2318', 'db123583ece011ea9fb1000c299a2318', 12999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_prod_order_detail` VALUES ('ffd5b540f0f111ea9a87000c299a2318', 'ab8454daecfc11ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', 10000.12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `t_prod_order_detail` VALUES ('ffd8e555f0f111ea9a87000c299a2318', 'ab8454daecfc11ea9fb1000c299a2318', '780bf03aee4f11ea9fb1000c299a2318', 100.12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for t_prod_order_master
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_order_master`;
CREATE TABLE `t_prod_order_master`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
  `charge_person` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单负责人',
  `order_money` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '订单金额',
  `order_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '交易时间',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单名称',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `pay_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否回款',
  `first_party_contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '甲方联系人',
  `first_party_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '甲方联系电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_order_master
-- ----------------------------
INSERT INTO `t_prod_order_master` VALUES ('ab8454daecfc11ea9fb1000c299a2318', 'OD0015320020200902', '姚正超', 0.00, '2020-09-02 17:14:14', '台式电脑', '1', NULL, NULL, '2020-09-02 17:14:15', NULL, '2020-09-07 18:07:56', NULL, '1', NULL, NULL);
INSERT INTO `t_prod_order_master` VALUES ('ed070548f10b11ea9a87000c299a2318', 'OD0015350020200907', '姚正超', 0.00, '2020-09-07 21:13:31', '华为服务器rh2288hv5节点机架式服务器主机机箱深度学习GPU服务器企业级', '2', NULL, NULL, '2020-09-07 21:13:31', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_prod_order_prop_rlt
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_order_prop_rlt`;
CREATE TABLE `t_prod_order_prop_rlt`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `prod_enum_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性枚举ID',
  `prod_order_detail_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单明细ID',
  `prod_prop_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单产品属性关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_order_prop_rlt
-- ----------------------------
INSERT INTO `t_prod_order_prop_rlt` VALUES ('06e8cb52e91311ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', '06e032b3e91311ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('06eb5816e91311ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', '06e2e2a2e91311ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('0976dbf0e91e11ea9fb1000c299a2318', 'ade91053e8f811ea9fb1000c299a2318', '09729f79e91e11ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('12d86959e92211ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', '12d4b6aae92211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('12d9713de92211ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', '12d75693e92211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('2f74c1bce92211ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', '2f73435fe92211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('2f75be07e92211ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', '2f73c321e92211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('32669377e91211ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', '32621e61e91211ea9fb1000c299a2318', NULL);
INSERT INTO `t_prod_order_prop_rlt` VALUES ('3d059b7ae92211ea9fb1000c299a2318', 'ade91053e8f811ea9fb1000c299a2318', '3d02ab74e92211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('422a0fc4e92411ea9fb1000c299a2318', 'ade91053e8f811ea9fb1000c299a2318', '4224bdb3e92411ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('422ba943e92411ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', '4227bac9e92411ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('88462f56e91411ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', '88401d74e91411ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('88488bd1e91411ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', '88421aebe91411ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('9dd30257e92611ea9fb1000c299a2318', 'ade91053e8f811ea9fb1000c299a2318', '9dccf672e92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('9dd522b8e92611ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', '9dd09748e92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('b0a2fd61e92611ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', 'b09b7c0ee92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('b0a55156e92611ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', 'b09c3cf6e92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('b6762ee0e92611ea9fb1000c299a2318', 'ade91053e8f811ea9fb1000c299a2318', 'b673bc6ae92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('b67af5cbe92611ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', 'b6747312e92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('ba38e494e92611ea9fb1000c299a2318', 'ade91053e8f811ea9fb1000c299a2318', 'ba36655be92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('ba3a2ffde92611ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', 'ba3759c3e92611ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('baa3888ee92111ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', 'ba93d44ce92111ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('bab86b5ce92111ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', 'ba9d7cf6e92111ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('bba09750e91211ea9fb1000c299a2318', 'ade7c3c9e8f811ea9fb1000c299a2318', 'bb9d97f9e91211ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('ea3d1e7ae92111ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', 'ea33a4b5e92111ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('ea41082de92111ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', 'ea38b199e92111ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('fe2e0928e92111ea9fb1000c299a2318', 'ade68d99e8f811ea9fb1000c299a2318', 'fe25a3ade92111ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_order_prop_rlt` VALUES ('fe31c14fe92111ea9fb1000c299a2318', 'ade19f11e8f811ea9fb1000c299a2318', 'fe2ac354e92111ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');

-- ----------------------------
-- Table structure for t_prod_prop
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_prop`;
CREATE TABLE `t_prod_prop`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性编号',
  `prop_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性类型',
  `is_multiple` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否多选',
  `pub_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否公共',
  `prop_default` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性默认值',
  `valid_exp_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正则表达式ID',
  `required_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否必填',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `prop_sort` int(255) NULL DEFAULT NULL COMMENT '排序字段',
  `seo_flag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否检索',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品属性' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_prop
-- ----------------------------
INSERT INTO `t_prod_prop` VALUES ('1fc9e77de90611ea9fb1000c299a2318', '应用场景', 'P0014220020200828', 'enum', '1', '2', NULL, NULL, '2', '2020-09-02 20:02:21', NULL, '2020-08-28 16:11:53', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('2978bfa7e86811ea9fb1000c299a2318', '端口数量', 'P0014060020200828', 'enum', '1', '2', NULL, NULL, '1', '2020-08-28 20:20:30', NULL, '2020-08-27 21:21:07', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('3fe1d7d9e90511ea9fb1000c299a2318', '下行端口速率', 'P0014170020200828', 'enum', '2', '2', NULL, NULL, '2', '2020-08-28 16:09:29', NULL, '2020-08-28 16:05:38', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('3fe28ee5e86811ea9fb1000c299a2318', '保修期', 'P0014070020200828', 'Number', NULL, '2', NULL, '', '1', '2020-08-28 14:09:14', NULL, '2020-08-27 21:21:45', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('4cc29896e86811ea9fb1000c299a2318', '保修联系方式', 'P0014080020200828', 'String', NULL, '2', NULL, '0', '1', '2020-08-28 14:09:23', NULL, '2020-08-27 21:22:06', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('6ac41402e90611ea9fb1000c299a2318', '类型', 'P0014230020200828', 'enum', '2', '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:13:59', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('72259dcae90511ea9fb1000c299a2318', '上行端口速率', 'P0014180020200828', 'enum', '2', '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:07:02', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('7ac5c528e90611ea9fb1000c299a2318', '型号', 'P0014240020200828', 'String', NULL, '2', NULL, '1a859332e8d311ea9fb1000c299a2318', '2', '2020-09-01 10:45:13', NULL, '2020-08-28 16:14:26', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('816df620e90611ea9fb1000c299a2318', '认证型号', 'P0014250020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:14:37', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('89d9b33ced1011ea9fb1000c299a2318', '测试属性', 'P0014360020200902', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-09-02 19:36:29', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('8ab4103be90511ea9fb1000c299a2318', '网关类型', 'P0014190020200828', 'enum', '2', '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:07:43', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('8dd27cece90611ea9fb1000c299a2318', 'MAC地址', 'P0014260020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:14:58', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('93ed4ebbe90611ea9fb1000c299a2318', '产品尺寸', 'P0014270020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:15:08', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('9bf339e5ed0a11ea9fb1000c299a2318', '运行内存', 'P0014330020200902', 'String', NULL, '2', NULL, '', '1', '2020-09-02 19:13:43', NULL, '2020-09-02 18:54:02', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('9edced69e90611ea9fb1000c299a2318', '网络标准', 'P0014280020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:15:27', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('a2967614e90611ea9fb1000c299a2318', '速度', 'P0014290020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:15:33', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('a41c16dae86711ea9fb1000c299a2318', '内存容量', 'P0014090020200828', 'String', NULL, '2', NULL, NULL, '1', '2020-08-28 14:09:32', NULL, '2020-08-27 21:17:23', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('aec2b9b9e90611ea9fb1000c299a2318', '缓存', 'P0014300020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:15:53', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('af4d1897e90511ea9fb1000c299a2318', '端口供电功能', 'P0014200020200828', 'enum', '2', '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:08:45', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('afa3c4c6e86711ea9fb1000c299a2318', '硬盘容量', 'P0014100020200828', 'String', NULL, '2', NULL, NULL, '1', '2020-08-28 14:09:41', NULL, '2020-08-27 21:17:43', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('b52317cee90611ea9fb1000c299a2318', 'LEDS', 'P0014310020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:16:04', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('b9bc1d34ed1b11ea9fb1000c299a2318', '网络知识', 'P0014380020200902', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-09-02 20:56:33', NULL, '0', '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('bab95a5bed1911ea9fb1000c299a2318', '高度', 'P0014370020200902', 'enum', '1', '2', NULL, NULL, '2', NULL, NULL, '2020-09-02 20:42:16', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('bb76ecb4e86711ea9fb1000c299a2318', '电源功率', 'P0014110020200828', 'String', NULL, '2', NULL, NULL, '1', '2020-08-28 14:09:50', NULL, '2020-08-27 21:18:02', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('c080e0f1e90611ea9fb1000c299a2318', 'VLAN', 'P0014320020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:16:23', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('c7b95843e86711ea9fb1000c299a2318', '发布日期', 'P0014120020200828', 'Datetime', NULL, '2', NULL, NULL, '1', '2020-08-28 14:10:01', NULL, '2020-08-27 21:18:23', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('d28b4dafe86711ea9fb1000c299a2318', '生产日期', 'P0014130020200828', 'Date', NULL, '2', NULL, NULL, '1', '2020-08-28 14:10:14', NULL, '2020-08-27 21:18:41', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('d7997f96e90411ea9fb1000c299a2318', '产品毛重', 'P0014150020200828', 'Number', NULL, '2', NULL, NULL, '2', '2020-08-28 16:03:11', NULL, '2020-08-28 16:02:43', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('dd3aaa25e86711ea9fb1000c299a2318', '显卡系列', 'P0014140020200828', 'String', NULL, '2', NULL, NULL, '1', '2020-08-28 14:10:22', NULL, '2020-08-27 21:18:59', NULL, NULL, '0', NULL, 1, '1');
INSERT INTO `t_prod_prop` VALUES ('e89efaa6e90511ea9fb1000c299a2318', '下行接口类型', 'P0014210020200828', 'enum', '2', '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:10:21', NULL, NULL, '0', NULL, 1, '0');
INSERT INTO `t_prod_prop` VALUES ('f57a3966e90411ea9fb1000c299a2318', '产品产地', 'P0014160020200828', 'String', NULL, '2', NULL, NULL, '2', NULL, NULL, '2020-08-28 16:03:33', NULL, NULL, '0', NULL, 1, '1');

-- ----------------------------
-- Table structure for t_prod_prop_enum_value
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_prop_enum_value`;
CREATE TABLE `t_prod_prop_enum_value`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `prod_prop_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性ID',
  `prod_enum_id` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性值',
  `prod_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品枚举属性值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_prop_enum_value
-- ----------------------------
INSERT INTO `t_prod_prop_enum_value` VALUES ('091a7494ee4f11ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 'dc9db52ae92811ea9fb1000c299a2318', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('091c4630ee4f11ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 'dca040b0e92811ea9fb1000c299a2318', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('091fc543ee4f11ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 'dca2cc42e92811ea9fb1000c299a2318', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e29a3faded1511ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 'dc9db52ae92811ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e29cd4c5ed1511ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 'dca040b0e92811ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e29f644aed1511ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318', 'dca2cc42e92811ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e2a1e910ed1511ea9fb1000c299a2318', '3fe1d7d9e90511ea9fb1000c299a2318', 'c9b3a38fe90511ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e2a4b1caed1511ea9fb1000c299a2318', '6ac41402e90611ea9fb1000c299a2318', '6ac9065de90611ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e2a7049fed1511ea9fb1000c299a2318', '72259dcae90511ea9fb1000c299a2318', '722b0618e90511ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e2a9800aed1511ea9fb1000c299a2318', '8ab4103be90511ea9fb1000c299a2318', '8ab86bdfe90511ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e2ac358eed1511ea9fb1000c299a2318', 'af4d1897e90511ea9fb1000c299a2318', 'af514300e90511ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_enum_value` VALUES ('e2ae9a13ed1511ea9fb1000c299a2318', 'e89efaa6e90511ea9fb1000c299a2318', 'e8a6da39e90511ea9fb1000c299a2318', '3b48e9b2e90811ea9fb1000c299a2318');

-- ----------------------------
-- Table structure for t_prod_prop_value
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_prop_value`;
CREATE TABLE `t_prod_prop_value`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `prod_prop_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性ID',
  `prod_prop_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性值',
  `prod_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品属性值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_prop_value
-- ----------------------------
INSERT INTO `t_prod_prop_value` VALUES ('09227272ee4f11ea9fb1000c299a2318', '3fe28ee5e86811ea9fb1000c299a2318', '1', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('0926ed92ee4f11ea9fb1000c299a2318', '4cc29896e86811ea9fb1000c299a2318', '18220488634', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('0929f6f5ee4f11ea9fb1000c299a2318', 'a41c16dae86711ea9fb1000c299a2318', '64GB', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('092b1cbcee4f11ea9fb1000c299a2318', 'afa3c4c6e86711ea9fb1000c299a2318', '5T', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('092da306ee4f11ea9fb1000c299a2318', 'bb76ecb4e86711ea9fb1000c299a2318', '105W', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('0932b66dee4f11ea9fb1000c299a2318', 'c7b95843e86711ea9fb1000c299a2318', '2020-09-04  09:40:12', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('09350994ee4f11ea9fb1000c299a2318', 'd28b4dafe86711ea9fb1000c299a2318', '2020-09-04', '0916a1aaee4f11ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2b20d8ded1511ea9fb1000c299a2318', '7ac5c528e90611ea9fb1000c299a2318', 'SG105M', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2b71f88ed1511ea9fb1000c299a2318', '816df620e90611ea9fb1000c299a2318', 'SG105M', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2b9b0cbed1511ea9fb1000c299a2318', '93ed4ebbe90611ea9fb1000c299a2318', '105mm x 70mm x 25mm', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2bbbc24ed1511ea9fb1000c299a2318', '9edced69e90611ea9fb1000c299a2318', 'IEEE 802.3、IEEE 802.3u、IEEE 802.3ab、IEEE 802.3x', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2bcf9beed1511ea9fb1000c299a2318', 'a2967614e90611ea9fb1000c299a2318', '10/100/1000M', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2be4eb5ed1511ea9fb1000c299a2318', 'aec2b9b9e90611ea9fb1000c299a2318', '存储转发(Store-and-Forward)', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2c012eded1511ea9fb1000c299a2318', 'b52317cee90611ea9fb1000c299a2318', '电源、状态指示灯', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2c295d4ed1511ea9fb1000c299a2318', 'c080e0f1e90611ea9fb1000c299a2318', '以官网为准', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2c3d3aced1511ea9fb1000c299a2318', 'd7997f96e90411ea9fb1000c299a2318', '0.08', '3b48e9b2e90811ea9fb1000c299a2318');
INSERT INTO `t_prod_prop_value` VALUES ('e2c51754ed1511ea9fb1000c299a2318', 'f57a3966e90411ea9fb1000c299a2318', '中国大陆', '3b48e9b2e90811ea9fb1000c299a2318');

-- ----------------------------
-- Table structure for t_prod_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_sku`;
CREATE TABLE `t_prod_sku`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品标题',
  `code` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品细分编号',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `quoted_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '供应商报价',
  `discount` decimal(10, 2) NULL DEFAULT NULL COMMENT '折扣',
  `prod_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品ID',
  `prod_manufacturer_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '供应商',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品细分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_sku
-- ----------------------------
INSERT INTO `t_prod_sku` VALUES ('2907c17cee4f11ea9fb1000c299a2318', '端口数量:[8口]', NULL, '0', NULL, NULL, '2020-09-04 09:37:15', NULL, '2020-09-04 09:38:38', NULL, 111.00, 12.33, '0916a1aaee4f11ea9fb1000c299a2318', '1eff58e7e8f411ea9fb1000c299a2318');
INSERT INTO `t_prod_sku` VALUES ('4ffb0ed3ed2111ea9fb1000c299a2318', '端口数量:[5口]', NULL, '0', NULL, NULL, '2020-09-02 21:36:33', NULL, NULL, NULL, 12000.00, 100.00, '1ba35ae1ed2011ea9fb1000c299a2318', '1eff58e7e8f411ea9fb1000c299a2318');
INSERT INTO `t_prod_sku` VALUES ('780bf03aee4f11ea9fb1000c299a2318', '端口数量:[8口]', NULL, '0', NULL, NULL, '2020-09-04 09:39:28', NULL, NULL, NULL, 100.00, 1.20, '0916a1aaee4f11ea9fb1000c299a2318', '1eff58e7e8f411ea9fb1000c299a2318');
INSERT INTO `t_prod_sku` VALUES ('b892cbb6ece011ea9fb1000c299a2318', '应用场景:[小型网络]端口数量:[16口]下行端口速率:[千兆]类型:[19英寸（标准机架）]上行端口速率:[千兆]网关类型:[网管]端口供电功能:[POE供电]下行接口类型:[光纤网交换机]', NULL, '0', NULL, NULL, '2020-09-02 13:54:12', NULL, '2020-09-02 16:24:46', NULL, 33.00, 33.00, '3b48e9b2e90811ea9fb1000c299a2318', '1eff58e7e8f411ea9fb1000c299a2318');
INSERT INTO `t_prod_sku` VALUES ('db123583ece011ea9fb1000c299a2318', '应用场景:[小型网络]端口数量:[16口]下行端口速率:[千兆]类型:[19英寸（标准机架）]上行端口速率:[千兆]网关类型:[网管]端口供电功能:[POE供电]下行接口类型:[光纤网交换机]', NULL, '0', NULL, NULL, '2020-09-02 13:55:09', NULL, '2020-09-02 16:25:23', NULL, 44.00, 44.00, '3b48e9b2e90811ea9fb1000c299a2318', '6e7ebb0ae6b611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku` VALUES ('f7fad717ed0b11ea9fb1000c299a2318', '应用场景:[大型网络]端口数量:[8口]下行端口速率:[百兆]类型:[桌面式交换机]上行端口速率:[百兆]网关类型:[非网管]高度:[40CM]', NULL, '0', NULL, NULL, '2020-09-02 19:03:46', NULL, NULL, NULL, 12000.00, 1.00, '49cd743ced0b11ea9fb1000c299a2318', '1eff58e7e8f411ea9fb1000c299a2318');

-- ----------------------------
-- Table structure for t_prod_sku_value
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_sku_value`;
CREATE TABLE `t_prod_sku_value`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `prod_sku_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品细ID',
  `prod_enum_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性值ID(eumId或者属性值ID)',
  `prod_prop_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品属性ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品细分属性值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_sku_value
-- ----------------------------
INSERT INTO `t_prod_sku_value` VALUES ('4fffb6f4ed2111ea9fb1000c299a2318', '4ffb0ed3ed2111ea9fb1000c299a2318', 'dc9db52ae92811ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('5a21d89dee4f11ea9fb1000c299a2318', '2907c17cee4f11ea9fb1000c299a2318', 'dca040b0e92811ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('780f9928ee4f11ea9fb1000c299a2318', '780bf03aee4f11ea9fb1000c299a2318', 'dca040b0e92811ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c1799cb7ecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', '1fce9cdde90611ea9fb1000c299a2318', '1fc9e77de90611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c17bb386ecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', 'dca2cc42e92811ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c17d011fecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', 'c9b3a38fe90511ea9fb1000c299a2318', '3fe1d7d9e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c17e3d77ecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', '6ac9065de90611ea9fb1000c299a2318', '6ac41402e90611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c17f63e6ecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', '722b0618e90511ea9fb1000c299a2318', '72259dcae90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c180cecaecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', '8ab86bdfe90511ea9fb1000c299a2318', '8ab4103be90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c181eec6ecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', 'af514300e90511ea9fb1000c299a2318', 'af4d1897e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('c183c3e3ecf511ea9fb1000c299a2318', 'b892cbb6ece011ea9fb1000c299a2318', 'e8a6da39e90511ea9fb1000c299a2318', 'e89efaa6e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d793bcc6ecf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', '1fce9cdde90611ea9fb1000c299a2318', '1fc9e77de90611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d7972a01ecf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', 'dca2cc42e92811ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d799ac2decf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', 'c9b3a38fe90511ea9fb1000c299a2318', '3fe1d7d9e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d79b326decf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', '6ac9065de90611ea9fb1000c299a2318', '6ac41402e90611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d79dc056ecf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', '722b0618e90511ea9fb1000c299a2318', '72259dcae90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d7a028c1ecf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', '8ab86bdfe90511ea9fb1000c299a2318', '8ab4103be90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d7a2aea0ecf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', 'af514300e90511ea9fb1000c299a2318', 'af4d1897e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('d7a545e7ecf511ea9fb1000c299a2318', 'db123583ece011ea9fb1000c299a2318', 'e8a6da39e90511ea9fb1000c299a2318', 'e89efaa6e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f7ff42dced0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', '1fd60a04e90611ea9fb1000c299a2318', '1fc9e77de90611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f8014546ed0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', 'dca040b0e92811ea9fb1000c299a2318', '2978bfa7e86811ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f802761ded0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', 'c9b64b7be90511ea9fb1000c299a2318', '3fe1d7d9e90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f804fd38ed0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', '6ac6ba10e90611ea9fb1000c299a2318', '6ac41402e90611ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f8078ecced0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', '7228a35fe90511ea9fb1000c299a2318', '72259dcae90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f80b7259ed0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', '8abb08e2e90511ea9fb1000c299a2318', '8ab4103be90511ea9fb1000c299a2318');
INSERT INTO `t_prod_sku_value` VALUES ('f80ca3c8ed0b11ea9fb1000c299a2318', 'f7fad717ed0b11ea9fb1000c299a2318', 'fd39aa39ed0a11ea9fb1000c299a2318', 'fd319f4ced0a11ea9fb1000c299a2318');

-- ----------------------------
-- Table structure for t_prod_spu
-- ----------------------------
DROP TABLE IF EXISTS `t_prod_spu`;
CREATE TABLE `t_prod_spu`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `code` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品编号',
  `prod_category_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品类型ID',
  `alias` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品别名',
  `prod_industry_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品行业ID',
  `prod_brand_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品品牌ID',
  `prod_manufacturer_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品厂商ID',
  `status` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `self_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自营',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '产品标准信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_prod_spu
-- ----------------------------
INSERT INTO `t_prod_spu` VALUES ('0916a1aaee4f11ea9fb1000c299a2318', '华为服务器', 'S0015210020200904', '0560ae68e86211ea9fb1000c299a2318', '华为服务器rh2288hv5节点机架式服务器主机机箱深度学习GPU服务器企业级', NULL, NULL, NULL, '0', NULL, NULL, '2020-09-04 09:36:22', NULL, '2020-09-04 09:36:22', NULL, '台', '1');
INSERT INTO `t_prod_spu` VALUES ('3b48e9b2e90811ea9fb1000c299a2318', '水星SG105M交换机', 'S0015050020200828', 'ed1e6c1de86211ea9fb1000c299a2318', '水星SG105M交换机', '8234f2bce6b411ea9fb1000c299a2318', '45d57d7fe8f911ea9fb1000c299a2318', 'd63b5691e8f911ea9fb1000c299a2318', '0', NULL, NULL, '2020-08-28 16:26:59', NULL, '2020-09-02 20:14:45', NULL, '台', '2');
