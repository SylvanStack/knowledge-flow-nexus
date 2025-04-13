package com.knowledge.nexus.api.request.knowledge;

import lombok.Data;

import java.util.Map;

/**
 * 知识源创建请求DTO
 */
@Data
public class KnowledgeSourceCreateRequest {
    
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
     * 连接配置，JSON格式
     */
    private Map<String, Object> connectionConfig;
    
    /**
     * 知识源配置
     */
    private KnowledgeSourceConfigRequest config;
} 