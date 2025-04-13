package com.knowledge.nexus.api.request.knowledge;

import lombok.Data;

/**
 * 知识源配置请求DTO
 */
@Data
public class KnowledgeSourceConfigRequest {
    
    /**
     * 同步频率（hourly, daily, weekly, monthly）
     */
    private String syncFrequency;
    
    /**
     * 处理深度（basic, standard, deep）
     */
    private String processingDepth;
    
    /**
     * 提取方式（title, summary, full）
     */
    private String extractMethod;
    
    /**
     * 语言设置（auto, zh_CN, en_US等）
     */
    private String language;
    
    /**
     * 访问权限设置（admin_only, all_users, specific_users）
     */
    private String accessPermission;
    
    /**
     * 自动同步（true/false）
     */
    private Boolean autoSync;
} 