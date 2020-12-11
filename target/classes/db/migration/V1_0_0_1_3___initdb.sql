/** 约会管理 */
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hun_dating
-- ----------------------------
DROP TABLE IF EXISTS `hun_dating`;
CREATE TABLE `hun_dating` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标记，0-存在，1-删除',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `parse1` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `parse2` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `parse3` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `parse4` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `parse5` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `mid` varchar(32) DEFAULT NULL COMMENT '男id',
  `wid` varchar(32) DEFAULT NULL COMMENT '女id',
  `mmid` varchar(32) DEFAULT NULL COMMENT '红娘id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `dating_time` datetime DEFAULT NULL COMMENT '约会时间',
  `result` varchar(1048) DEFAULT NULL COMMENT '约会经过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='相亲管理';

-- ----------------------------
-- Records of hun_dating
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

insert into sys_menu (menu_name, menu_key, component, parent_id, target, order_num, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('相亲管理', 'dating', 'pts/dating/HunDatingList','1', '', '1', 'C', '0', 'dating:hunDating:view', '#', 'admin', '2020-11-21 17:00:15', 'ry', '2020-11-21 17:00:15', '相亲菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, menu_key, component, parent_id, target, order_num, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('相亲查询', '', NULL, @parentId, '', '1',  'F', '0', 'dating:hunDating:list',         '#', 'admin', '2020-11-21 17:00:15', 'ry', '2020-11-21 17:00:15', '');

insert into sys_menu  (menu_name, menu_key, component, parent_id, target, order_num, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('相亲新增', '', NULL, @parentId, '', '2',  'F', '0', 'dating:hunDating:add',          '#', 'admin', '2020-11-21 17:00:15', 'ry', '2020-11-21 17:00:15', '');

insert into sys_menu  (menu_name, menu_key, component, parent_id, target, order_num, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('相亲修改', '', NULL, @parentId, '', '3',  'F', '0', 'dating:hunDating:edit',         '#', 'admin', '2020-11-21 17:00:15', 'ry', '2020-11-21 17:00:15', '');

insert into sys_menu  (menu_name, menu_key, component, parent_id, target, order_num, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('相亲删除', '', NULL, @parentId, '', '4',  'F', '0', 'dating:hunDating:remove',       '#', 'admin', '2020-11-21 17:00:15', 'ry', '2020-11-21 17:00:15', '');
UPDATE `sys_menu` SET `menu_name` = '相亲管理', `menu_key` = 'dating', `component` = 'pts/dating/HunDatingList', `parent_id` = 2203, `target` = '', `order_num` = 1, `menu_type` = 'C', `visible` = '0', `perms` = 'dating:hunDating:view', `icon` = '#', `path` = NULL, `redirect` = NULL, `hidden_children` = NULL, `hidden_header` = NULL, `create_by` = 'admin', `create_time` = '2020-11-21 17:00:15', `update_by` = 'ry', `update_time` = '2020-11-21 17:17:16', `remark` = '相亲菜单' WHERE `menu_id` = 2230;
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES (2, 2230);
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES (2, 2231);
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES (2, 2232);
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES (2, 2233);
INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES (2, 2234);
INSERT INTO `sys_top_menu_setting`(`id`, `top_menu_id`, `menu_id`) VALUES (5725, 7, 2230);
INSERT INTO `sys_top_menu_setting`(`id`, `top_menu_id`, `menu_id`) VALUES (5726, 7, 2231);
INSERT INTO `sys_top_menu_setting`(`id`, `top_menu_id`, `menu_id`) VALUES (5727, 7, 2232);
INSERT INTO `sys_top_menu_setting`(`id`, `top_menu_id`, `menu_id`) VALUES (5728, 7, 2233);
INSERT INTO `sys_top_menu_setting`(`id`, `top_menu_id`, `menu_id`) VALUES (5729, 7, 2234);
