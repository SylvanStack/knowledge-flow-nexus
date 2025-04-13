package com.knowledge.nexus.api.request.knowledge;

import lombok.Data;

/**
 * 知识源查询请求DTO
 */
@Data
public class KnowledgeSourceQueryRequest {
    
    /**
     * 知识源名称（模糊匹配）
     */
    private String name;
    
    /**
     * 知识源类型编码
     */
    private Integer typeCode;
    
    /**
     * 知识源状态编码
     */
    private Integer statusCode;
    
    /**
     * 页码
     */
    private Integer pageNum = 1;
    
    /**
     * 每页数量
     */
    private Integer pageSize = 10;
} 