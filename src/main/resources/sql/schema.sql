CREATE DATABASE mall;
USE mall;

--创建表
--1.商品表
CREATE TABLE goods_info(
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
	`name` varchar(120) NOT NULL COMMENT '名称',
	`title` varchar(300) NOT NULL COMMENT '标题',
	`number` int NOT NULL COMMENT '数量',
	`price` decimal NOT NULL COMMENT '单价',
	`introduce` text NOT NULL COMMENT '介绍',
	`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',	
	`gmt_modified` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`),
	KEY idx_name(`name`),
	KEY idx_gmt_create(`gmt_create`),
	KEY idx_gmt_modified(`gmt_modified`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品详情表';

INSERT INTO goods_info(name,title,number,price,introduce) VALUES 
('Intel G4560 处理器','超强性能和超高性价比的组合',10,308.00,'你买不了吃亏买不了上当，你知道伐'),
('迪兰 RX 470D','史上最具性价比的GPU',20,1099.00,'可以开核到470，超高性价比'),
('AMD G4560 处理器','有这个型号么',10,338.00,'农企日常翻身'),
('蓝宝石 RX 470D','史上最具性价比的GPU',20,1149.00,'可以开核到470，超高性价比');

--新增照片字段
ALTER TABLE goods_info ADD img varchar(200) COMMENT '商品图片';

--2.用户表
CREATE TABLE user_info(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `phone` varchar(11) NOT NULL COMMENT '电话',
    `name` varchar(20) NOT NULL COMMENT '账号',
    `password` varchar(100) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`),
    KEY idx_phone(`phone`),
    KEY idx_user_name(`name`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
INSERT INTO user_info(phone,name,password) VALUES ('15181010990','Yong','e10adc3949ba59abbe56e057f20f883e');
INSERT INTO user_info(phone,name,password) VALUES ('15181010999','Lee','e10adc3949ba59abbe56e057f20f883e');

--3.角色表
CREATE TABLE role_info(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `name` varchar(20) NOT NULL COMMENT '角色名称',
    `introduce` varchar(100) NOT NULL COMMENT '简介',
    PRIMARY KEY (`id`),
    KEY idx_name(`name`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户角色表';
INSERT INTO role_info(name,introduce) VALUES ('admin','系统管理员'); 
INSERT INTO role_info(name,introduce) VALUES ('guest','工作人员'); 

--4.系统模块
CREATE TABLE sys_module(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '模块ID',
    `name` varchar(20) NOT NULL COMMENT '模块名称',
    `link` varchar(255) NOT NULL COMMENT 'URL链接',
    `number` int NOT NULL COMMENT '顺序',
    PRIMARY KEY (`id`),
    KEY idx_name(`name`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='系统模块';
INSERT INTO sys_module(name,link,number) VALUES ('用户管理','admin/user/list',1);
INSERT INTO sys_module(name,link,number) VALUES ('角色管理','admin/user/role/list',2);
INSERT INTO sys_module(name,link,number) VALUES ('商品管理','admin/goods/list',3);

--5.角色模块关联表
CREATE TABLE role_module(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '关联id',
    `role_id` bigint NOT NULL COMMENT '角色id',
    `module_id` bigint NOT NULL COMMENT '模块id',
    PRIMARY KEY (`id`),
    KEY idx_role_id(`role_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色模块关联表';
INSERT INTO role_module(role_id,module_id) VALUES (1000,1000); 
INSERT INTO role_module(role_id,module_id) VALUES (1000,1001); 
INSERT INTO role_module(role_id,module_id) VALUES (1000,1002); 
INSERT INTO role_module(role_id,module_id) VALUES (1001,1002); 

--6.用户角色关联表
CREATE TABLE user_role(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '关联id',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `role_id` bigint NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`),
    KEY idx_user_id(`user_id`),
    KEY idx_role_id(`role_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';
INSERT INTO user_role(user_id,role_id) VALUES (1000,1000);
INSERT INTO user_role(user_id,role_id) VALUES (1001,1001);

--7.系统权限表
CREATE TABLE operation_auth(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限id',
    `name` varchar(20) NOT NULL COMMENT '权限名称',
    PRIMARY KEY (`id`),
    KEY idx_name(`name`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';
INSERT INTO operation_auth(name) VALUES ('新增商品');
INSERT INTO operation_auth(name) VALUES ('修改商品');
INSERT INTO operation_auth(name) VALUES ('删除商品');

--8.角色权限关联表
CREATE TABLE role_auth(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限id',
    `role_id` bigint NOT NULL COMMENT '角色id',
    `auth_id` bigint NOT NULL COMMENT '权限id',
    PRIMARY KEY(`id`),
    KEY indx_role_id(`role_id`),
    KEY indx_auth_id(`auth_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';
INSERT INTO role_auth(role_id,auth_id) VALUES (1000,1000);
INSERT INTO role_auth(role_id,auth_id) VALUES (1000,1001);