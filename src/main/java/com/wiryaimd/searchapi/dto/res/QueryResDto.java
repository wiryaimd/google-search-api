package com.wiryaimd.searchapi.dto.res;

import java.util.List;

public record QueryResDto(
        String id,
        String query,
        int statusCode,
        List<String> result
) {
}
