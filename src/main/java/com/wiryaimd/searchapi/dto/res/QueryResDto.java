package com.wiryaimd.searchapi.dto.res;

import com.wiryaimd.searchapi.model.PageModel;

import java.util.List;

public class QueryResDto {

    private String uid;
    private String query;
    private int statusCode;
    private List<PageModel> pageList;

    public QueryResDto() {
    }

    public QueryResDto(String uid, String query, int statusCode, List<PageModel> pageList) {
        this.uid = uid;
        this.query = query;
        this.statusCode = statusCode;
        this.pageList = pageList;
    }

    public String getUid() {
        return uid;
    }

    public String getQuery() {
        return query;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<PageModel> getPageList() {
        return pageList;
    }
}
