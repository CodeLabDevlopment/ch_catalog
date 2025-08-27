package com.coffeehub.catalog_ms.infrastructure.web.request;

import com.coffeehub.catalog_ms.domain.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.List;

public record UpdateProductRequest(
        String name,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        ProductStatus status,
        List<String> tags
) {

}
