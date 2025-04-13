package com.knowledge.nexus.types.constants;

/**
 * 系统通用常量定义
 */
public class Constants {
    
    /**
     * 通用状态
     */
    public static class Status {
        // 启用
        public static final Integer ENABLED = 1;
        // 禁用
        public static final Integer DISABLED = 0;
    }
    
    /**
     * 日期格式
     */
    public static class DateFormat {
        public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        public static final String DATE_FORMAT = "yyyy-MM-dd";
        public static final String TIME_FORMAT = "HH:mm:ss";
    }
    
    /**
     * 分页参数
     */
    public static class Pagination {
        public static final Integer DEFAULT_PAGE_SIZE = 10;
        public static final Integer DEFAULT_PAGE_NUM = 1;
        public static final Integer MAX_PAGE_SIZE = 100;
    }
    
    /**
     * 安全相关
     */
    public static class Security {
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String TOKEN_HEADER = "Authorization";
        public static final String TOKEN_SECRET = "KFN_Secret_Key_For_JWT_Token_Generation";
        public static final long TOKEN_EXPIRATION = 60 * 60 * 24 * 1000; // 24小时
    }
    
    /**
     * 知识源相关常量
     */
    public static class KnowledgeSource {
        // 同步频率
        public static final String SYNC_FREQUENCY_HOURLY = "hourly";
        public static final String SYNC_FREQUENCY_DAILY = "daily";
        public static final String SYNC_FREQUENCY_WEEKLY = "weekly";
        public static final String SYNC_FREQUENCY_MONTHLY = "monthly";
        
        // 处理深度
        public static final String PROCESS_DEPTH_BASIC = "basic"; // 基本信息
        public static final String PROCESS_DEPTH_STANDARD = "standard"; // 标准处理
        public static final String PROCESS_DEPTH_DEEP = "deep"; // 深度处理
        
        // 提取方式
        public static final String EXTRACT_METHOD_TITLE = "title"; // 仅标题
        public static final String EXTRACT_METHOD_SUMMARY = "summary"; // 摘要
        public static final String EXTRACT_METHOD_FULL = "full"; // 全文
    }
} 