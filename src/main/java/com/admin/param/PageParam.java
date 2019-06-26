package com.admin.param;

public class PageParam {
    private int beginLine;//起始⾏
     private Integer pageSize = 3;
     private Integer currentPage = 1;// 当前⻚

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginLine() {
        return pageSize * (currentPage - 1);//⾃自动计算起始⾏
    }
}
