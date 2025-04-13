package com.knowledge.nexus.types.constants;

/**
 * 系统错误码定义
 */
public class ErrorCode {
    // 通用错误码 (1xxxx)
    public static final Integer SUCCESS = 0;
    public static final Integer SYSTEM_ERROR = 10000;
    public static final Integer PARAM_ERROR = 10001;
    public static final Integer UNAUTHORIZED = 10002;
    public static final Integer FORBIDDEN = 10003;
    public static final Integer NOT_FOUND = 10004;
    public static final Integer METHOD_NOT_ALLOWED = 10005;
    public static final Integer DATA_CONFLICT = 10006;
    public static final Integer TOO_MANY_REQUESTS = 10007;
    
    // 用户相关错误码 (2xxxx)
    public static final Integer USER_NOT_FOUND = 20001;
    public static final Integer USERNAME_EXISTS = 20002;
    public static final Integer PASSWORD_ERROR = 20003;
    public static final Integer ACCOUNT_LOCKED = 20004;
    
    // 知识源相关错误码 (3xxxx)
    public static final Integer DATASOURCE_NOT_FOUND = 30001;
    public static final Integer DATASOURCE_EXISTS = 30002;
    public static final Integer DATASOURCE_CONNECTION_ERROR = 30003;
    public static final Integer DATASOURCE_PERMISSION_ERROR = 30004;
    public static final Integer DATASOURCE_FORMAT_ERROR = 30005;
    public static final Integer DATASOURCE_SYNC_ERROR = 30006;
    public static final Integer DATASOURCE_READ_ERROR = 30007;
    public static final Integer DATASOURCE_WRITE_ERROR = 30008;
    
    // 内容创作相关错误码 (4xxxx)
    public static final Integer CONTENT_NOT_FOUND = 40001;
    public static final Integer CONTENT_FORMAT_ERROR = 40002;
    public static final Integer TEMPLATE_NOT_FOUND = 40003;
    
    // 发布相关错误码 (5xxxx)
    public static final Integer PUBLISH_FAILED = 50001;
    public static final Integer CHANNEL_NOT_FOUND = 50002;
    public static final Integer PUBLISH_PERMISSION_ERROR = 50003;
    
    // LLM相关错误码 (6xxxx)
    public static final Integer LLM_CONNECTION_ERROR = 60001;
    public static final Integer LLM_QUOTA_EXCEEDED = 60002;
    public static final Integer LLM_RESPONSE_ERROR = 60003;
    
    // RAG相关错误码 (7xxxx)
    public static final Integer RAG_BUILD_ERROR = 70001;
    public static final Integer KB_NOT_FOUND = 70002;
    public static final Integer VECTOR_INDEX_ERROR = 70003;
} 