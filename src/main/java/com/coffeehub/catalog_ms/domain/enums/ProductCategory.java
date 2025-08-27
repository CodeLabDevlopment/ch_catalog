package com.coffeehub.catalog_ms.domain.enums;

import lombok.Getter;

@Getter
public enum ProductCategory {
    DRINK("Drink"),
    COFFEE_MAKER("Coffee Maker"),
    ACCESSORY("Accessory");

    private final String value;

    ProductCategory(String value) {
        this.value = value;
    }
}
