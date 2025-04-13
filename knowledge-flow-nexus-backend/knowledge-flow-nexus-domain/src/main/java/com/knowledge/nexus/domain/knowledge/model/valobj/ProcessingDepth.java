package com.knowledge.nexus.domain.knowledge.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 处理深度值对象
 */
@Getter
@AllArgsConstructor
public enum ProcessingDepth {
    
    BASIC("basic", "基本处理", "仅处理基本元数据"),
    STANDARD("standard", "标准处理", "处理内容和基本结构"),
    DEEP("deep", "深度处理", "处理内容、结构和关系");
    
    /**
     * 深度编码
     */
    private final String code;
    
    /**
     * 深度名称
     */
    private final String name;
    
    /**
     * 深度描述
     */
    private final String description;
    
    /**
     * 根据编码获取枚举
     */
    public static ProcessingDepth getByCode(String code) {
        for (ProcessingDepth item : ProcessingDepth.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return STANDARD; // 默认返回标准处理
    }
} 