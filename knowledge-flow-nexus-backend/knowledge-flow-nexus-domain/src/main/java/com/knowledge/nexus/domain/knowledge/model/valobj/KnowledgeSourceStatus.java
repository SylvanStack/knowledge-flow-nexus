package com.knowledge.nexus.domain.knowledge.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 知识源状态值对象
 */
@Getter
@AllArgsConstructor
public enum KnowledgeSourceStatus {
    
    CREATED(1, "已创建", "知识源已创建但尚未连接"),
    CONNECTED(2, "已连接", "知识源连接成功"),
    CONNECTING(3, "连接中", "知识源正在尝试连接"),
    SYNC_ERROR(4, "同步错误", "知识源同步过程中出现错误"),
    CONNECTION_ERROR(5, "连接错误", "知识源连接失败"),
    SYNCING(6, "同步中", "知识源正在同步数据"),
    SYNCED(7, "已同步", "知识源数据已同步"),
    DISABLED(8, "已禁用", "知识源已被禁用");
    
    /**
     * 状态编码
     */
    private final Integer code;
    
    /**
     * 状态名称
     */
    private final String name;
    
    /**
     * 状态描述
     */
    private final String description;
    
    /**
     * 根据编码获取枚举
     */
    public static KnowledgeSourceStatus getByCode(Integer code) {
        for (KnowledgeSourceStatus item : KnowledgeSourceStatus.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * 判断是否为可用状态
     */
    public boolean isAvailable() {
        return this == CONNECTED || this == SYNCED;
    }
} 