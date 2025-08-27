package com.coffeehub.catalog_ms.infrastructure.web.request;

import com.coffeehub.catalog_ms.domain.enums.ProductCategory;
import com.coffeehub.catalog_ms.domain.model.Accessory;
import com.coffeehub.catalog_ms.domain.model.CoffeeMaker;
import com.coffeehub.catalog_ms.domain.model.Drink;
import com.coffeehub.catalog_ms.infrastructure.annotation.ValidProduct;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@ValidProduct
public record CreateProductRequest(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Description is required")
        String description,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        BigDecimal price,
        @NotNull(message = "Category is required")
        ProductCategory category,
        Drink drink,
        CoffeeMaker coffeeMaker,
        Accessory accessory,
        List<String> tags
) {

}
