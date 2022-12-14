package com.wiryaimd.searchapi.dto.res;

public record AuthResDto(
        String token,
        long expiredAt
) {
}
