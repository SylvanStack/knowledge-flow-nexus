package com.knowledge.nexus.api.response.knowledge;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 知识源视图对象
 */
@Data
public class KnowledgeSourceVO {
    
    /**
     * 知识源ID
     */
    private Long id;
    
    /**
     * 知识源名称
     */
    private String name;
    
    /**
     * 知识源描述
     */
    private String description;
    
    /**
     * 知识源类型编码
     */
    private Integer typeCode;
    
    /**
     * 知识源类型名称
     */
    private String typeName;
    
    /**
     * 知识源状态编码
     */
    private Integer statusCode;
    
    /**
     * 知识源状态名称
     */
    private String statusName;
    
    /**
     * 连接配置，JSON格式
     */
    private Map<String, Object> connectionConfig;
    
    /**
     * 创建者ID
     */
    private Long creatorId;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 文件数量
     */
    private Integer fileCount;
    
    /**
     * 知识源配置
     */
    private KnowledgeSourceConfigVO config;
} 