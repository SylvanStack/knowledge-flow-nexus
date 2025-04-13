package com.knowledge.nexus.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 知识源类型枚举
 */
@Getter
@AllArgsConstructor
public enum KnowledgeSourceTypeEnum {
    
    MINIO(1, "MINIO", "Minio对象存储"),
    ALIYUN_OSS(2, "ALIYUN_OSS", "阿里云OSS"),
    HUAWEI_OBS(3, "HUAWEI_OBS", "华为云OBS"),
    NAS(4, "NAS", "NAS存储"),
    SMB(5, "SMB", "SMB共享"),
    DOCUMENT(6, "DOCUMENT", "文档集合"),
    WEBSITE(7, "WEBSITE", "网站爬虫"),
    AUDIO(8, "AUDIO", "音频资料"),
    VIDEO(9, "VIDEO", "视频资料"),
    KNOWLEDGE_BASE(10, "KNOWLEDGE_BASE", "知识库"),
    API(11, "API", "API知识源");
    
    /**
     * 类型编码
     */
    private final Integer code;
    
    /**
     * 类型标识
     */
    private final String type;
    
    /**
     * 类型名称
     */
    private final String name;
    
    /**
     * 根据编码获取枚举
     */
    public static KnowledgeSourceTypeEnum getByCode(Integer code) {
        for (KnowledgeSourceTypeEnum item : KnowledgeSourceTypeEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * 根据标识获取枚举
     */
    public static KnowledgeSourceTypeEnum getByType(String type) {
        for (KnowledgeSourceTypeEnum item : KnowledgeSourceTypeEnum.values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
} 