package com.coffeehub.catalog_ms.infrastructure.mapper;

import com.coffeehub.catalog_ms.domain.model.Product;
import com.coffeehub.catalog_ms.infrastructure.web.response.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.ProductResponseList;

import java.util.List;

public final class ProductMapper {

    public static Product toDomain(ProductResponseList product) {
        return new Product(
                product.id(),
                product.name(),
                null,
                product.price(),
                product.category(),
                null,
                product.status(),
                null,
                null,
                null,
                null,
                product.tags(),
                0.0,
                null,
                null
        );
    }

    public static Product toDomain(ProductDetails product) {
        return new Product(
                product.id(),
                product.name(),
                product.description(),
                product.price(),
                product.category(),
                null,
                product.status(),
                product.drink(),
                product.coffeeMaker(),
                product.accessory(),
                product.imageUrls(),
                product.tags(),
                product.rating(),
                null,
                null
        );
    }

    public static List<ProductResponseList> toResponseList(List<Product> products) {
        return products.stream()
                .map(it -> new ProductResponseList(
                        it.id(),
                        it.name(),
                        it.price(),
                        it.category(),
                        it.status(),
                        it.tags()
                ))
                .toList();
    }

    public static ProductDetails toDetails(Product product) {
        return new ProductDetails(
                product.id(),
                product.name(),
                product.description(),
                product.price(),
                product.category(),
                product.status(),
                product.drink(),
                product.coffeeMaker(),
                product.accessory(),
                product.imageUrls(),
                product.tags(),
                product.rating()
        );
    }

}
