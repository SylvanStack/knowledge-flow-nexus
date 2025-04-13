package com.knowledge.nexus.domain.knowledge.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 文档实体
 */
@Data
@Accessors(chain = true)
public class Document {
    
    /**
     * 文档ID
     */
    private Long id;
    
    /**
     * 知识源ID
     */
    private Long knowledgeSourceId;
    
    /**
     * 文档名称
     */
    private String name;
    
    /**
     * 文档路径
     */
    private String path;
    
    /**
     * 文档类型
     */
    private String type;
    
    /**
     * 文档大小（字节）
     */
    private Long size;
    
    /**
     * 父文件夹ID
     */
    private Long parentId;
    
    /**
     * 是否为文件夹
     */
    private Boolean isDirectory;
    
    /**
     * 文档状态：not_indexed, indexing, indexed, index_failed
     */
    private String status;
    
    /**
     * 索引信息
     */
    private String indexInfo;
    
    /**
     * 文档内容哈希值
     */
    private String contentHash;
    
    /**
     * 文档URL
     */
    private String url;
    
    /**
     * 文档标题
     */
    private String title;
    
    /**
     * 文档摘要
     */
    private String summary;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 最后修改时间
     */
    private LocalDateTime lastModified;
    
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    
    /**
     * 判断是否为文件夹
     */
    public boolean isDirectory() {
        return isDirectory != null && isDirectory;
    }
    
    /**
     * 判断是否需要索引
     */
    public boolean needIndex() {
        return !isDirectory() && ("not_indexed".equals(status) || "index_failed".equals(status));
    }
    
    /**
     * 判断是否已索引
     */
    public boolean isIndexed() {
        return "indexed".equals(status);
    }
    
    /**
     * 判断是否正在索引
     */
    public boolean isIndexing() {
        return "indexing".equals(status);
    }
} 