package com.knowledge.nexus.api.request.knowledge;

import lombok.Data;

import java.util.Map;

/**
 * 知识源更新请求DTO
 */
@Data
public class KnowledgeSourceUpdateRequest {
    
    /**
     * 知识源ID
     */
    private Long id;
    
    /**
     * 知识源名称
     */
    private String name;
    
    /**
     * 知识源类型
     */
    private String type;
    
    /**
     * 知识源描述
     */
    private String description;
    
    /**
     * 连接配置，JSON格式
     */
    private Map<String, Object> connectionConfig;
    
    /**
     * 知识源配置
     */
    private KnowledgeSourceConfigRequest config;
} 