package com.knowledge.nexus.domain.knowledge.repository;

import com.knowledge.nexus.domain.knowledge.model.aggregates.KnowledgeSource;
import com.knowledge.nexus.domain.knowledge.model.entity.KnowledgeSourceConfig;
import com.knowledge.nexus.domain.knowledge.model.entity.Document;
import com.knowledge.nexus.domain.knowledge.model.entity.Webpage;
import com.knowledge.nexus.types.enums.KnowledgeSourceTypeEnum;

import java.util.List;

/**
 * 知识源仓储接口
 */
public interface IKnowledgeSourceRepository {
    
    /**
     * 保存知识源
     *
     * @param knowledgeSource 知识源
     * @return 保存后的知识源ID
     */
    Long saveKnowledgeSource(KnowledgeSource knowledgeSource);
    
    /**
     * 更新知识源
     *
     * @param knowledgeSource 知识源
     * @return 是否更新成功
     */
    boolean updateKnowledgeSource(KnowledgeSource knowledgeSource);
    
    /**
     * 根据ID查询知识源
     *
     * @param id 知识源ID
     * @return 知识源
     */
    KnowledgeSource findKnowledgeSourceById(Long id);
    
    /**
     * 根据条件分页查询知识源
     *
     * @param name 名称（模糊匹配）
     * @param type 类型
     * @param status 状态
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 知识源列表
     */
    List<KnowledgeSource> findKnowledgeSourceByCondition(String name, KnowledgeSourceTypeEnum type, Integer status, Integer pageNum, Integer pageSize);
    
    /**
     * 根据条件统计知识源数量
     *
     * @param name 名称（模糊匹配）
     * @param type 类型
     * @param status 状态
     * @return 知识源数量
     */
    Long countKnowledgeSourceByCondition(String name, KnowledgeSourceTypeEnum type, Integer status);
    
    /**
     * 逻辑删除知识源
     *
     * @param id 知识源ID
     * @return 是否删除成功
     */
    boolean deleteKnowledgeSource(Long id);
    
    /**
     * 保存知识源配置
     *
     * @param config 知识源配置
     * @return 保存后的配置ID
     */
    Long saveKnowledgeSourceConfig(KnowledgeSourceConfig config);
    
    /**
     * 更新知识源配置
     *
     * @param config 知识源配置
     * @return 是否更新成功
     */
    boolean updateKnowledgeSourceConfig(KnowledgeSourceConfig config);
    
    /**
     * 根据知识源ID查询配置
     *
     * @param knowledgeSourceId 知识源ID
     * @return 知识源配置
     */
    KnowledgeSourceConfig findConfigByKnowledgeSourceId(Long knowledgeSourceId);
    
    /**
     * 保存文档
     *
     * @param document 文档
     * @return 保存后的文档ID
     */
    Long saveDocument(Document document);
    
    /**
     * 批量保存文档
     *
     * @param documents 文档列表
     * @return 是否保存成功
     */
    boolean saveBatchDocuments(List<Document> documents);
    
    /**
     * 更新文档
     *
     * @param document 文档
     * @return 是否更新成功
     */
    boolean updateDocument(Document document);
    
    /**
     * 根据ID查询文档
     *
     * @param id 文档ID
     * @return 文档
     */
    Document findDocumentById(Long id);
    
    /**
     * 根据知识源ID和路径查询文档
     *
     * @param knowledgeSourceId 知识源ID
     * @param path 路径
     * @return 文档
     */
    Document findDocumentByPath(Long knowledgeSourceId, String path);
    
    /**
     * 根据知识源ID和父ID查询文档列表
     *
     * @param knowledgeSourceId 知识源ID
     * @param parentId 父ID
     * @return 文档列表
     */
    List<Document> findDocumentsByParentId(Long knowledgeSourceId, Long parentId);
    
    /**
     * 根据知识源ID查询文档数量
     *
     * @param knowledgeSourceId 知识源ID
     * @return 文档数量
     */
    Integer countDocumentsByKnowledgeSourceId(Long knowledgeSourceId);
    
    /**
     * 保存网页
     *
     * @param webpage 网页
     * @return 保存后的网页ID
     */
    Long saveWebpage(Webpage webpage);
    
    /**
     * 批量保存网页
     *
     * @param webpages 网页列表
     * @return 是否保存成功
     */
    boolean saveBatchWebpages(List<Webpage> webpages);
    
    /**
     * 更新网页
     *
     * @param webpage 网页
     * @return 是否更新成功
     */
    boolean updateWebpage(Webpage webpage);
    
    /**
     * 根据ID查询网页
     *
     * @param id 网页ID
     * @return 网页
     */
    Webpage findWebpageById(Long id);
    
    /**
     * 根据URL查询网页
     *
     * @param knowledgeSourceId 知识源ID
     * @param url URL
     * @return 网页
     */
    Webpage findWebpageByUrl(Long knowledgeSourceId, String url);
    
    /**
     * 根据知识源ID查询网页列表
     *
     * @param knowledgeSourceId 知识源ID
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 网页列表
     */
    List<Webpage> findWebpagesByKnowledgeSourceId(Long knowledgeSourceId, Integer pageNum, Integer pageSize);
    
    /**
     * 根据知识源ID查询网页数量
     *
     * @param knowledgeSourceId 知识源ID
     * @return 网页数量
     */
    Integer countWebpagesByKnowledgeSourceId(Long knowledgeSourceId);
    
    /**
     * 查询需要同步的知识源列表
     *
     * @return 知识源列表
     */
    List<KnowledgeSource> findKnowledgeSourcesNeedSync();
} 