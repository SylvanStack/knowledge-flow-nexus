package com.knowledge.nexus.types.response;

import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 * @param <T> 列表数据类型
 */
@Data
public class PageResult<T> {
    /**
     * 当前页码
     */
    private Integer pageNum;
    
    /**
     * 每页数量
     */
    private Integer pageSize;
    
    /**
     * 总页数
     */
    private Integer totalPage;
    
    /**
     * 总记录数
     */
    private Long total;
    
    /**
     * 分页数据
     */
    private List<T> list;
    
    /**
     * 构造器
     */
    public PageResult() {
    }
    
    /**
     * 构造器
     *
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @param total 总记录数
     * @param list 分页数据
     */
    public PageResult(Integer pageNum, Integer pageSize, Long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
        this.totalPage = (int) Math.ceil((double) total / pageSize);
    }
    
    /**
     * 将PageResult转换为另一种类型的PageResult
     */
    public static <T> PageResult<T> convert(PageResult<?> pageResult, List<T> list) {
        return new PageResult<>(pageResult.getPageNum(), pageResult.getPageSize(), pageResult.getTotal(), list);
    }
} 