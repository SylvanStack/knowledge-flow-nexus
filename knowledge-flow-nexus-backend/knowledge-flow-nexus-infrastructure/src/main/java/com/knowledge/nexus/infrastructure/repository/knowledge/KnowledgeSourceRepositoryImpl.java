package com.knowledge.nexus.infrastructure.repository.knowledge;

import com.knowledge.nexus.domain.knowledge.model.aggregates.KnowledgeSource;
import com.knowledge.nexus.domain.knowledge.model.entity.Document;
import com.knowledge.nexus.domain.knowledge.model.entity.KnowledgeSourceConfig;
import com.knowledge.nexus.domain.knowledge.model.entity.Webpage;
import com.knowledge.nexus.domain.knowledge.repository.IKnowledgeSourceRepository;
import com.knowledge.nexus.types.enums.KnowledgeSourceTypeEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 知识源仓储接口内存实现
 * 注意：此实现仅用于示例和测试，实际生产环境应使用数据库存储
 */
@Repository
public class KnowledgeSourceRepositoryImpl implements IKnowledgeSourceRepository {
    
    // 模拟自增ID生成器
    private final AtomicLong knowledgeSourceIdGenerator = new AtomicLong(1);
    private final AtomicLong configIdGenerator = new AtomicLong(1);
    private final AtomicLong documentIdGenerator = new AtomicLong(1);
    private final AtomicLong webpageIdGenerator = new AtomicLong(1);
    
    // 模拟存储
    private final Map<Long, KnowledgeSource> knowledgeSourceMap = new ConcurrentHashMap<>();
    private final Map<Long, KnowledgeSourceConfig> configMap = new ConcurrentHashMap<>();
    private final Map<Long, Document> documentMap = new ConcurrentHashMap<>();
    private final Map<Long, Webpage> webpageMap = new ConcurrentHashMap<>();
    
    @Override
    public Long saveKnowledgeSource(KnowledgeSource knowledgeSource) {
        Long id = knowledgeSource.getId();
        if (id == null) {
            id = knowledgeSourceIdGenerator.getAndIncrement();
            knowledgeSource.setId(id);
        }
        knowledgeSourceMap.put(id, knowledgeSource);
        return id;
    }
    
    @Override
    public boolean updateKnowledgeSource(KnowledgeSource knowledgeSource) {
        Long id = knowledgeSource.getId();
        if (id == null || !knowledgeSourceMap.containsKey(id)) {
            return false;
        }
        knowledgeSourceMap.put(id, knowledgeSource);
        return true;
    }
    
    @Override
    public KnowledgeSource findKnowledgeSourceById(Long id) {
        return knowledgeSourceMap.get(id);
    }
    
    @Override
    public List<KnowledgeSource> findKnowledgeSourceByCondition(String name, KnowledgeSourceTypeEnum type, Integer status, Integer pageNum, Integer pageSize) {
        List<KnowledgeSource> result = knowledgeSourceMap.values().stream()
                .filter(ks -> (name == null || ks.getName().contains(name)) &&
                             (type == null || ks.getType() == type) &&
                             (status == null || ks.getStatus().getCode().equals(status)) &&
                             !ks.getIsDeleted())
                .collect(Collectors.toList());
        
        // 分页处理
        if (pageNum != null && pageSize != null) {
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, result.size());
            
            if (startIndex < result.size()) {
                result = result.subList(startIndex, endIndex);
            } else {
                result = new ArrayList<>();
            }
        }
        
        return result;
    }
    
    @Override
    public Long countKnowledgeSourceByCondition(String name, KnowledgeSourceTypeEnum type, Integer status) {
        return knowledgeSourceMap.values().stream()
                .filter(ks -> (name == null || ks.getName().contains(name)) &&
                             (type == null || ks.getType() == type) &&
                             (status == null || ks.getStatus().getCode().equals(status)) &&
                             !ks.getIsDeleted())
                .count();
    }
    
    @Override
    public boolean deleteKnowledgeSource(Long id) {
        KnowledgeSource knowledgeSource = knowledgeSourceMap.get(id);
        if (knowledgeSource == null) {
            return false;
        }
        
        // 逻辑删除
        knowledgeSource.setIsDeleted(true);
        knowledgeSourceMap.put(id, knowledgeSource);
        return true;
    }
    
    @Override
    public Long saveKnowledgeSourceConfig(KnowledgeSourceConfig config) {
        Long id = config.getId();
        if (id == null) {
            id = configIdGenerator.getAndIncrement();
            config.setId(id);
        }
        configMap.put(id, config);
        return id;
    }
    
    @Override
    public boolean updateKnowledgeSourceConfig(KnowledgeSourceConfig config) {
        Long id = config.getId();
        if (id == null || !configMap.containsKey(id)) {
            return false;
        }
        configMap.put(id, config);
        return true;
    }
    
    @Override
    public KnowledgeSourceConfig findConfigByKnowledgeSourceId(Long knowledgeSourceId) {
        return configMap.values().stream()
                .filter(config -> config.getKnowledgeSourceId().equals(knowledgeSourceId))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public Long saveDocument(Document document) {
        Long id = document.getId();
        if (id == null) {
            id = documentIdGenerator.getAndIncrement();
            document.setId(id);
        }
        documentMap.put(id, document);
        return id;
    }
    
    @Override
    public boolean saveBatchDocuments(List<Document> documents) {
        if (documents == null || documents.isEmpty()) {
            return false;
        }
        
        for (Document document : documents) {
            saveDocument(document);
        }
        
        return true;
    }
    
    @Override
    public boolean updateDocument(Document document) {
        Long id = document.getId();
        if (id == null || !documentMap.containsKey(id)) {
            return false;
        }
        documentMap.put(id, document);
        return true;
    }
    
    @Override
    public Document findDocumentById(Long id) {
        return documentMap.get(id);
    }
    
    @Override
    public Document findDocumentByPath(Long knowledgeSourceId, String path) {
        return documentMap.values().stream()
                .filter(doc -> doc.getKnowledgeSourceId().equals(knowledgeSourceId) && doc.getPath().equals(path))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Document> findDocumentsByParentId(Long knowledgeSourceId, Long parentId) {
        return documentMap.values().stream()
                .filter(doc -> doc.getKnowledgeSourceId().equals(knowledgeSourceId) &&
                              (parentId == null ? doc.getParentId() == null : parentId.equals(doc.getParentId())) &&
                              !doc.getIsDeleted())
                .collect(Collectors.toList());
    }
    
    @Override
    public Integer countDocumentsByKnowledgeSourceId(Long knowledgeSourceId) {
        return (int) documentMap.values().stream()
                .filter(doc -> doc.getKnowledgeSourceId().equals(knowledgeSourceId) && !doc.getIsDeleted())
                .count();
    }
    
    @Override
    public Long saveWebpage(Webpage webpage) {
        Long id = webpage.getId();
        if (id == null) {
            id = webpageIdGenerator.getAndIncrement();
            webpage.setId(id);
        }
        webpageMap.put(id, webpage);
        return id;
    }
    
    @Override
    public boolean saveBatchWebpages(List<Webpage> webpages) {
        if (webpages == null || webpages.isEmpty()) {
            return false;
        }
        
        for (Webpage webpage : webpages) {
            saveWebpage(webpage);
        }
        
        return true;
    }
    
    @Override
    public boolean updateWebpage(Webpage webpage) {
        Long id = webpage.getId();
        if (id == null || !webpageMap.containsKey(id)) {
            return false;
        }
        webpageMap.put(id, webpage);
        return true;
    }
    
    @Override
    public Webpage findWebpageById(Long id) {
        return webpageMap.get(id);
    }
    
    @Override
    public Webpage findWebpageByUrl(Long knowledgeSourceId, String url) {
        return webpageMap.values().stream()
                .filter(webpage -> webpage.getKnowledgeSourceId().equals(knowledgeSourceId) && webpage.getUrl().equals(url))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Webpage> findWebpagesByKnowledgeSourceId(Long knowledgeSourceId, Integer pageNum, Integer pageSize) {
        List<Webpage> result = webpageMap.values().stream()
                .filter(webpage -> webpage.getKnowledgeSourceId().equals(knowledgeSourceId))
                .collect(Collectors.toList());
        
        // 分页处理
        if (pageNum != null && pageSize != null) {
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, result.size());
            
            if (startIndex < result.size()) {
                result = result.subList(startIndex, endIndex);
            } else {
                result = new ArrayList<>();
            }
        }
        
        return result;
    }
    
    @Override
    public Integer countWebpagesByKnowledgeSourceId(Long knowledgeSourceId) {
        return (int) webpageMap.values().stream()
                .filter(webpage -> webpage.getKnowledgeSourceId().equals(knowledgeSourceId))
                .count();
    }
    
    @Override
    public List<KnowledgeSource> findKnowledgeSourcesNeedSync() {
        return knowledgeSourceMap.values().stream()
                .filter(ks -> !ks.getIsDeleted() && ks.isAvailable() && ks.getConfig() != null && ks.getConfig().needSync())
                .collect(Collectors.toList());
    }
} 