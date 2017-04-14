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
