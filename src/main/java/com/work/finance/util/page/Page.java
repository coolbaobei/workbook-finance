package com.work.finance.util.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author lxb
 */
public class Page<T> {
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 起始条数
     */
    private long startNum;
    /**
     * 步长
     */
    private int pageSize = 10;
    private long totalPage;
    /**
     * 总条数
     */
    private long totalCount;

    private List<T> data = new ArrayList<>();
    private Map<String, Object> params = new HashMap<>();


    public Page() {
        super();
    }

    public Page(int currentPage, int pageSize) {
        super();
        this.currentPage = currentPage;
        this.startNum = (currentPage - 1) * pageSize;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getStartNum() {
        return startNum;
    }

    public void setStartNum(long startNum) {
        this.startNum = startNum;
    }

    public int getPageSize() {
        return pageSize == -1 ? 10 : this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }


    @Override
    public String toString() {
        return "Page [startNum=" + startNum + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", totalCount="
                + totalCount + "]";
    }
}
