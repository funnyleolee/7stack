package me.sevenstack.web.model;

import org.apache.ibatis.session.RowBounds;

/**
 * 分页信息
 * 
 * @author lijinlong
 * 
 */
public class Pagination {
    private int pageNo;
    private int pageSize;
    private int pageCount;
    private int count;

    // private String pageContent;

    public int getPageNo() {
        return pageNo < 1 ? 1 : pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize < 1 ? 17 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return (getPageNo() - 1) * getPageSize() + 1;
    }

    public int getLimit() {

        return getPageNo() * getPageSize();
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPageContent() {
        pageCount = (count % getPageSize() == 0) ? (count / getPageSize()) : (count / getPageSize() + 1);
        if (pageCount <= 1) {
            return "";
        }
        String page = "<div class='pagination'><ul>";
        if(getPageNo() <= 1){
            page += "<li class='disabled' ><span>«</span></li>";
        }else{
            //getPageNo()-1
            page += "<li class='disabled' ><a href='#'>«</a></li>";
        }
        for (int i = 1; i <= pageCount; i++) {

            if (pageCount < 10 || i <= 5 || i > pageCount - 2) {
                if (getPageNo() == i) {
                    page += "<li class='active' ><span>" + i + "</span></li>";
                } else {
                    page += "<li><a href='#'>" + i + "</a></li>";
                }
            } else if (i == 6) {
                page += "<li class='disabled' ><span>...</span></li>";
            }
            
        }
        if(getPageNo() == pageCount){
            page += "<li class='disabled' ><span>»</span></li>";
        }else{
            //getPageNo()+1
            page += "<li><a href='#'>»</a></li>";
        }
        page += "</ul></div>";
        return page;

    }

    public static void main(String[] args) {
        Pagination p = new Pagination();
        p.setPageNo(2);
        System.out.println(0%343);
    }

}
