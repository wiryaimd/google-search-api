package com.wiryaimd.searchapi.dto.req;

public record UserReqDto(
        String username,
        String password,
        String roles
) {
}
