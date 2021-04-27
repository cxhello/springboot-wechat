CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `open_id` varchar(50) NOT NULL COMMENT '普通用户的标识，对当前开发者帐号唯一',
  `nick_name` varchar(20) NOT NULL COMMENT '昵称',
  `head_img_url` varchar(200) NOT NULL COMMENT '用户头像',
  `union_id` varchar(50) NOT NULL COMMENT '用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `update_time` datetime NULL COMMENT '更新人',
  `update_user` varchar(50) NULL COMMENT '更新人',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) COMMENT = '用户表';

