package com.knowledge.nexus.domain.knowledge.model.aggregates;

import com.knowledge.nexus.domain.knowledge.model.entity.KnowledgeSourceConfig;
import com.knowledge.nexus.domain.knowledge.model.valobj.KnowledgeSourceStatus;
import com.knowledge.nexus.types.enums.KnowledgeSourceTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 知识源聚合根
 */
@Data
@Accessors(chain = true)
public class KnowledgeSource {
    
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
     * 知识源类型
     */
    private KnowledgeSourceTypeEnum type;
    
    /**
     * 知识源状态
     */
    private KnowledgeSourceStatus status;
    
    /**
     * 连接配置，JSON格式存储
     * 例如：
     * {
     *   "endpoint": "http://minio.example.com:9000",
     *   "bucket": "knowledge",
     *   "accessKey": "minioadmin",
     *   "secretKey": "minioadmin"
     * }
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
     * 是否删除
     */
    private Boolean isDeleted;
    
    /**
     * 文件数量
     */
    private Integer fileCount;
    
    /**
     * 知识源配置
     */
    private KnowledgeSourceConfig config;
    
    /**
     * 构造函数
     */
    public KnowledgeSource() {
        this.connectionConfig = new HashMap<>();
        this.status = KnowledgeSourceStatus.CREATED;
        this.isDeleted = false;
        this.fileCount = 0;
    }
    
    /**
     * 获取连接配置值
     */
    public Object getConnectionConfigValue(String key) {
        return connectionConfig != null ? connectionConfig.get(key) : null;
    }
    
    /**
     * 设置连接配置值
     */
    public KnowledgeSource setConnectionConfigValue(String key, Object value) {
        if (connectionConfig == null) {
            connectionConfig = new HashMap<>();
        }
        connectionConfig.put(key, value);
        return this;
    }
    
    /**
     * 判断知识源是否可用
     */
    public boolean isAvailable() {
        return status != null && status.isAvailable();
    }
    
    /**
     * 知识源连接成功
     */
    public void markConnected() {
        this.status = KnowledgeSourceStatus.CONNECTED;
        this.updateTime = LocalDateTime.now();
    }
    
    /**
     * 知识源连接失败
     */
    public void markConnectionError() {
        this.status = KnowledgeSourceStatus.CONNECTION_ERROR;
        this.updateTime = LocalDateTime.now();
    }
    
    /**
     * 知识源同步中
     */
    public void markSyncing() {
        this.status = KnowledgeSourceStatus.SYNCING;
        this.updateTime = LocalDateTime.now();
    }
    
    /**
     * 知识源同步完成
     */
    public void markSynced() {
        this.status = KnowledgeSourceStatus.SYNCED;
        this.updateTime = LocalDateTime.now();
        if (this.config != null) {
            this.config.setLastSyncTime(LocalDateTime.now());
            this.config.calculateNextSyncTime();
        }
    }
    
    /**
     * 知识源同步失败
     */
    public void markSyncError() {
        this.status = KnowledgeSourceStatus.SYNC_ERROR;
        this.updateTime = LocalDateTime.now();
    }
    
    /**
     * 禁用知识源
     */
    public void disable() {
        this.status = KnowledgeSourceStatus.DISABLED;
        this.updateTime = LocalDateTime.now();
    }
    
    /**
     * 启用知识源
     */
    public void enable() {
        this.status = KnowledgeSourceStatus.CREATED;
        this.updateTime = LocalDateTime.now();
    }
} 