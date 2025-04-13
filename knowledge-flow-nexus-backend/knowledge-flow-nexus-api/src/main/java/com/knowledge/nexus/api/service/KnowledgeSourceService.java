package com.knowledge.nexus.api.service;

import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceConfigRequest;
import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceCreateRequest;
import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceQueryRequest;
import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceUpdateRequest;
import com.knowledge.nexus.api.response.knowledge.KnowledgeSourceConfigVO;
import com.knowledge.nexus.api.response.knowledge.KnowledgeSourceVO;
import com.knowledge.nexus.types.response.PageResult;
import com.knowledge.nexus.types.response.Result;

/**
 * 知识源服务接口
 */
public interface KnowledgeSourceService {
    
    /**
     * 创建知识源
     *
     * @param request 创建请求
     * @return 知识源ID
     */
    Long createKnowledgeSource(KnowledgeSourceCreateRequest request);
    
    /**
     * 更新知识源
     *
     * @param request 更新请求
     * @return 是否成功
     */
    Result<Boolean> updateKnowledgeSource(KnowledgeSourceUpdateRequest request);
    
    /**
     * 获取知识源详情
     *
     * @param id 知识源ID
     * @return 知识源详情
     */
    Result<KnowledgeSourceVO> getKnowledgeSource(Long id);
    
    /**
     * 分页查询知识源
     *
     * @param request 查询请求
     * @return 知识源列表
     */
    Result<PageResult<KnowledgeSourceVO>> pageKnowledgeSource(KnowledgeSourceQueryRequest request);
    
    /**
     * 删除知识源
     *
     * @param id 知识源ID
     * @return 是否成功
     */
    Result<Boolean> deleteKnowledgeSource(Long id);
    
    /**
     * 启用知识源
     *
     * @param id 知识源ID
     * @return 是否成功
     */
    Result<Boolean> enableKnowledgeSource(Long id);
    
    /**
     * 禁用知识源
     *
     * @param id 知识源ID
     * @return 是否成功
     */
    Result<Boolean> disableKnowledgeSource(Long id);
    
    /**
     * 更新知识源配置
     *
     * @param knowledgeSourceId 知识源ID
     * @param request 配置请求
     * @return 是否成功
     */
    Result<Boolean> updateKnowledgeSourceConfig(Long knowledgeSourceId, KnowledgeSourceConfigRequest request);
    
    /**
     * 获取知识源配置
     *
     * @param knowledgeSourceId 知识源ID
     * @return 知识源配置
     */
    Result<KnowledgeSourceConfigVO> getKnowledgeSourceConfig(Long knowledgeSourceId);
} 