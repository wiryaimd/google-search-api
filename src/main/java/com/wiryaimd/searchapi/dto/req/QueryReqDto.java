package com.wiryaimd.searchapi.dto.req;

public class QueryReqDto {

    private String uid;
    private String query;
    private boolean isComplete;

    public QueryReqDto() {
    }

    public QueryReqDto(String uid, String query, boolean isComplete) {
        this.uid = uid;
        this.query = query;
        this.isComplete = isComplete;
    }

    public String getUid() {
        return uid;
    }

    public String getQuery() {
        return query;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
