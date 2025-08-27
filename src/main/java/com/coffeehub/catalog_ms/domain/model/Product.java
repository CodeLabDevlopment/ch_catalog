package com.coffeehub.catalog_ms.domain.model;

import com.coffeehub.catalog_ms.domain.enums.ProductCategory;
import com.coffeehub.catalog_ms.domain.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record Product(
        String id,
        String name,
        String description,
        BigDecimal price,
        ProductCategory category,
        Integer stockQuantity,
        ProductStatus status,
        Drink drink,
        CoffeeMaker coffeeMaker,
        Accessory accessory,
        List<String> imageUrls,
        List<String> tags,
        double rating,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
