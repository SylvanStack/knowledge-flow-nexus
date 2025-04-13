package com.knowledge.nexus.trigger.http.controller;

import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceConfigRequest;
import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceCreateRequest;
import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceQueryRequest;
import com.knowledge.nexus.api.request.knowledge.KnowledgeSourceUpdateRequest;
import com.knowledge.nexus.api.response.knowledge.KnowledgeSourceConfigVO;
import com.knowledge.nexus.api.response.knowledge.KnowledgeSourceVO;
import com.knowledge.nexus.api.service.KnowledgeSourceService;
import com.knowledge.nexus.types.response.PageResult;
import com.knowledge.nexus.types.response.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 知识源控制器
 */
@RestController
@RequestMapping("/api/knowledge-source")
@RequiredArgsConstructor
public class KnowledgeSourceController {
    
    private final KnowledgeSourceService knowledgeSourceService;
    
    /**
     * 创建知识源
     */
    @PostMapping
    public Result<Long> createKnowledgeSource(@RequestBody KnowledgeSourceCreateRequest request) {
        return Result.success(knowledgeSourceService.createKnowledgeSource(request));
    }
    
    /**
     * 更新知识源
     */
    @PutMapping
    public Result<Boolean> updateKnowledgeSource(@RequestBody KnowledgeSourceUpdateRequest request) {
        return knowledgeSourceService.updateKnowledgeSource(request);
    }
    
    /**
     * 获取知识源详情
     */
    @GetMapping("/{id}")
    public Result<KnowledgeSourceVO> getKnowledgeSource(@PathVariable Long id) {
        return knowledgeSourceService.getKnowledgeSource(id);
    }
    
    /**
     * 分页查询知识源
     */
    @GetMapping("/page")
    public Result<PageResult<KnowledgeSourceVO>> pageKnowledgeSource(KnowledgeSourceQueryRequest request) {
        return knowledgeSourceService.pageKnowledgeSource(request);
    }
    
    /**
     * 删除知识源
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteKnowledgeSource(@PathVariable Long id) {
        return knowledgeSourceService.deleteKnowledgeSource(id);
    }
    
    /**
     * 启用知识源
     */
    @PostMapping("/{id}/enable")
    public Result<Boolean> enableKnowledgeSource(@PathVariable Long id) {
        return knowledgeSourceService.enableKnowledgeSource(id);
    }
    
    /**
     * 禁用知识源
     */
    @PostMapping("/{id}/disable")
    public Result<Boolean> disableKnowledgeSource(@PathVariable Long id) {
        return knowledgeSourceService.disableKnowledgeSource(id);
    }
    
    /**
     * 更新知识源配置
     */
    @PutMapping("/{knowledgeSourceId}/config")
    public Result<Boolean> updateKnowledgeSourceConfig(@PathVariable Long knowledgeSourceId, @RequestBody KnowledgeSourceConfigRequest request) {
        return knowledgeSourceService.updateKnowledgeSourceConfig(knowledgeSourceId, request);
    }
    
    /**
     * 获取知识源配置
     */
    @GetMapping("/{knowledgeSourceId}/config")
    public Result<KnowledgeSourceConfigVO> getKnowledgeSourceConfig(@PathVariable Long knowledgeSourceId) {
        return knowledgeSourceService.getKnowledgeSourceConfig(knowledgeSourceId);
    }
} 