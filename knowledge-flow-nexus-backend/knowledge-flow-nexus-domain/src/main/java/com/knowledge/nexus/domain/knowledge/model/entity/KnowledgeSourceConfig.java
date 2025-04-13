package com.knowledge.nexus.domain.knowledge.model.entity;

import com.knowledge.nexus.domain.knowledge.model.valobj.ProcessingDepth;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 知识源配置实体
 */
@Data
@Accessors(chain = true)
public class KnowledgeSourceConfig {
    
    /**
     * 配置ID
     */
    private Long id;
    
    /**
     * 知识源ID
     */
    private Long knowledgeSourceId;
    
    /**
     * 同步频率（hourly, daily, weekly, monthly）
     */
    private String syncFrequency;
    
    /**
     * 处理深度（basic, standard, deep）
     */
    private ProcessingDepth processingDepth;
    
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
    
    /**
     * 上次同步时间
     */
    private LocalDateTime lastSyncTime;
    
    /**
     * 下次同步时间
     */
    private LocalDateTime nextSyncTime;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否默认配置
     */
    private Boolean isDefault;
    
    /**
     * 计算下次同步时间
     */
    public void calculateNextSyncTime() {
        if (lastSyncTime == null) {
            nextSyncTime = LocalDateTime.now();
            return;
        }
        
        LocalDateTime next = LocalDateTime.now();
        switch (syncFrequency) {
            case "hourly":
                next = lastSyncTime.plusHours(1);
                break;
            case "daily":
                next = lastSyncTime.plusDays(1);
                break;
            case "weekly":
                next = lastSyncTime.plusWeeks(1);
                break;
            case "monthly":
                next = lastSyncTime.plusMonths(1);
                break;
            default:
                next = lastSyncTime.plusDays(1); // 默认每天
        }
        
        // 如果计算出的下次同步时间已经过去，则设置为当前时间
        if (next.isBefore(LocalDateTime.now())) {
            next = LocalDateTime.now();
        }
        
        this.nextSyncTime = next;
    }
    
    /**
     * 判断是否需要同步
     */
    public boolean needSync() {
        return autoSync && (nextSyncTime == null || nextSyncTime.isBefore(LocalDateTime.now()));
    }
} 