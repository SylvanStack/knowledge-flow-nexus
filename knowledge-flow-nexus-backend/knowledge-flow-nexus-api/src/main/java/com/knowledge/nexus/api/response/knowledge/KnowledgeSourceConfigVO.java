package com.knowledge.nexus.api.response.knowledge;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 知识源配置视图对象
 */
@Data
public class KnowledgeSourceConfigVO {
    
    /**
     * 配置ID
     */
    private Long id;
    
    /**
     * 知识源ID
     */
    private Long knowledgeSourceId;
    
    /**
     * 同步频率
     */
    private String syncFrequency;
    
    /**
     * 处理深度
     */
    private String processingDepth;
    
    /**
     * 提取方式
     */
    private String extractMethod;
    
    /**
     * 语言设置
     */
    private String language;
    
    /**
     * 访问权限设置
     */
    private String accessPermission;
    
    /**
     * 自动同步
     */
    private Boolean autoSync;
    
    /**
     * 上次同步时间
     */
    private LocalDateTime lastSyncTime;
    
    /**
     * 下次同步时间
     */
    private LocalDateTime nextSyncTime;
    
    /**
     * 是否默认配置
     */
    private Boolean isDefault;
} 