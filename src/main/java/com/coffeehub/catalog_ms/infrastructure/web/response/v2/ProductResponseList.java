package com.coffeehub.catalog_ms.infrastructure.web.response.v2;

import com.coffeehub.catalog_ms.domain.enums.ProductCategory;
import com.coffeehub.catalog_ms.domain.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ProductResponseList(
        String id,
        String name,
        BigDecimal price,
        ProductCategory category,
        Integer stockQuantity,
        ProductStatus status,
        List<String> tags,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
