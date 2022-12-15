package com.wiryaimd.searchapi.dto.req;

public record QueryReqDto(
        String uid,
        String query,
        boolean isComplete
) {
}
