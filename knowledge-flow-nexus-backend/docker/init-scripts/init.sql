-- 创建数据库
CREATE DATABASE IF NOT EXISTS knowledge_flow_nexus DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE knowledge_flow_nexus;

-- 知识源表
CREATE TABLE IF NOT EXISTS `t_data_source` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '知识源ID',
    `name` varchar(100) NOT NULL COMMENT '知识源名称',
    `description` varchar(500) DEFAULT NULL COMMENT '知识源描述',
    `type_code` int(11) NOT NULL COMMENT '知识源类型编码',
    `status_code` int(11) NOT NULL COMMENT '知识源状态编码',
    `connection_config` text COMMENT '连接配置(JSON格式)',
    `creator_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `file_count` int(11) DEFAULT '0' COMMENT '文件数量',
    PRIMARY KEY (`id`),
    KEY `idx_name` (`name`),
    KEY `idx_type` (`type_code`),
    KEY `idx_status` (`status_code`),
    KEY `idx_creator` (`creator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='知识源表';

-- 知识源配置表
CREATE TABLE IF NOT EXISTS `t_data_source_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置ID',
    `data_source_id` bigint(20) NOT NULL COMMENT '知识源ID',
    `sync_frequency` varchar(20) NOT NULL COMMENT '同步频率(hourly, daily, weekly, monthly)',
    `processing_depth` varchar(20) NOT NULL COMMENT '处理深度(basic, standard, deep)',
    `extract_method` varchar(20) NOT NULL COMMENT '提取方式(title, summary, full)',
    `language` varchar(20) NOT NULL COMMENT '语言设置(auto, zh_CN, en_US等)',
    `access_permission` varchar(20) NOT NULL COMMENT '访问权限设置(admin_only, all_users, specific_users)',
    `auto_sync` tinyint(1) NOT NULL DEFAULT '1' COMMENT '自动同步',
    `last_sync_time` datetime DEFAULT NULL COMMENT '上次同步时间',
    `next_sync_time` datetime DEFAULT NULL COMMENT '下次同步时间',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_default` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否默认配置',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_data_source_id` (`data_source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='知识源配置表';

-- 文档表
CREATE TABLE IF NOT EXISTS `t_document` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文档ID',
    `data_source_id` bigint(20) NOT NULL COMMENT '知识源ID',
    `name` varchar(255) NOT NULL COMMENT '文档名称',
    `path` varchar(500) NOT NULL COMMENT '文档路径',
    `type` varchar(50) DEFAULT NULL COMMENT '文档类型',
    `size` bigint(20) DEFAULT NULL COMMENT '文档大小(字节)',
    `parent_id` bigint(20) DEFAULT NULL COMMENT '父文件夹ID',
    `is_directory` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为文件夹',
    `status` varchar(20) NOT NULL COMMENT '文档状态(not_indexed, indexing, indexed, index_failed)',
    `index_info` text COMMENT '索引信息',
    `content_hash` varchar(64) DEFAULT NULL COMMENT '文档内容哈希值',
    `url` varchar(500) DEFAULT NULL COMMENT '文档URL',
    `title` varchar(255) DEFAULT NULL COMMENT '文档标题',
    `summary` text COMMENT '文档摘要',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `last_modified` datetime DEFAULT NULL COMMENT '最后修改时间',
    `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    KEY `idx_data_source_id` (`data_source_id`),
    KEY `idx_parent_id` (`parent_id`),
    KEY `idx_path` (`path`(255)),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文档表';

-- 网页表
CREATE TABLE IF NOT EXISTS `t_webpage` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '网页ID',
    `data_source_id` bigint(20) NOT NULL COMMENT '知识源ID',
    `url` varchar(500) NOT NULL COMMENT '网页URL',
    `title` varchar(255) DEFAULT NULL COMMENT '网页标题',
    `summary` text COMMENT '网页摘要',
    `content_hash` varchar(64) DEFAULT NULL COMMENT '网页内容哈希值',
    `status` varchar(20) NOT NULL COMMENT '网页状态(not_crawled, crawling, crawled, crawl_failed)',
    `depth` int(11) DEFAULT '0' COMMENT '爬取深度',
    `last_crawled_time` datetime DEFAULT NULL COMMENT '上次爬取时间',
    `content_type` varchar(50) DEFAULT NULL COMMENT '网页内容类型',
    `language` varchar(20) DEFAULT NULL COMMENT '网页语言',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_indexed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否索引',
    `index_info` text COMMENT '索引信息',
    `metadata` text COMMENT '元数据(JSON格式)',
    PRIMARY KEY (`id`),
    KEY `idx_data_source_id` (`data_source_id`),
    KEY `idx_url` (`url`(255)),
    KEY `idx_status` (`status`),
    KEY `idx_indexed` (`is_indexed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='网页表';

-- 用户表
CREATE TABLE IF NOT EXISTS `t_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '密码',
    `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
    `avatar` varchar(255) DEFAULT NULL COMMENT '头像URL',
    `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态(0:禁用,1:启用)',
    `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 插入初始管理员用户(密码: admin123)
INSERT INTO `t_user` (`username`, `password`, `nickname`, `email`, `status`, `create_time`, `update_time`)
VALUES ('admin', '$2a$10$XeEqGv5UEWHyTvGOxWH0.efTlMVlUiU5Y78BRNUX3XWaPjVhxUXE2', '管理员', 'admin@example.com', 1, NOW(), NOW()); 