package com.knowledge.nexus.domain.knowledge.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 网页实体
 */
@Data
@Accessors(chain = true)
public class Webpage {
    
    /**
     * 网页ID
     */
    private Long id;
    
    /**
     * 知识源ID
     */
    private Long knowledgeSourceId;
    
    /**
     * 网页URL
     */
    private String url;
    
    /**
     * 网页标题
     */
    private String title;
    
    /**
     * 网页摘要
     */
    private String summary;
    
    /**
     * 网页内容哈希值
     */
    private String contentHash;
    
    /**
     * 网页状态：not_crawled, crawling, crawled, crawl_failed
     */
    private String status;
    
    /**
     * 爬取深度
     */
    private Integer depth;
    
    /**
     * 上次爬取时间
     */
    private LocalDateTime lastCrawledTime;
    
    /**
     * 网页内容类型
     */
    private String contentType;
    
    /**
     * 网页语言
     */
    private String language;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否索引
     */
    private Boolean isIndexed;
    
    /**
     * 索引信息
     */
    private String indexInfo;
    
    /**
     * 元数据，JSON格式存储
     */
    private String metadata;
    
    /**
     * 判断是否需要爬取
     */
    public boolean needCrawl() {
        return "not_crawled".equals(status) || "crawl_failed".equals(status);
    }
    
    /**
     * 判断是否已爬取
     */
    public boolean isCrawled() {
        return "crawled".equals(status);
    }
    
    /**
     * 判断是否正在爬取
     */
    public boolean isCrawling() {
        return "crawling".equals(status);
    }
} 