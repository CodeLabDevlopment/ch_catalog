package com.coffeehub.catalog_ms.infrastructure.web.response.v2;

import com.coffeehub.catalog_ms.domain.enums.ProductCategory;
import com.coffeehub.catalog_ms.domain.enums.ProductStatus;
import com.coffeehub.catalog_ms.domain.model.Accessory;
import com.coffeehub.catalog_ms.domain.model.CoffeeMaker;
import com.coffeehub.catalog_ms.domain.model.Drink;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ProductDetails(
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
