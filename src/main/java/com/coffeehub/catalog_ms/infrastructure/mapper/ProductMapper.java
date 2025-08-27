package com.coffeehub.catalog_ms.infrastructure.mapper;

import com.coffeehub.catalog_ms.domain.enums.ProductStatus;
import com.coffeehub.catalog_ms.domain.model.Product;
import com.coffeehub.catalog_ms.infrastructure.db.entity.ProductEntity;
import com.coffeehub.catalog_ms.infrastructure.web.request.CreateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.request.UpdateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductResponseList;

import java.util.List;

public final class ProductMapper {

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getStockQuantity(),
                entity.getStatus(),
                entity.getDrink(),
                entity.getCoffeeMaker(),
                entity.getAccessory(),
                entity.getImageUrls(),
                entity.getTags(),
                entity.getRating(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static Product toDomain(CreateProductRequest request) {
        return new Product(
                null,
                request.name(),
                request.description(),
                request.price(),
                request.category(),
                0,
                ProductStatus.INACTIVE,
                request.drink(),
                request.coffeeMaker(),
                request.accessory(),
                List.of(),
                request.tags(),
                0.0,
                null,
                null
        );
    }

    public static Product toDomain(UpdateProductRequest request) {
        return new Product(
                null,
                request.name(),
                request.description(),
                request.price(),
                null,
                request.stockQuantity(),
                request.status(),
                null,
                null,
                null,
                null,
                request.tags(),
                0.0,
                null,
                null
        );
    }

    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.id(),
                product.name(),
                product.description(),
                product.price(),
                product.category(),
                product.stockQuantity(),
                product.status(),
                product.drink(),
                product.coffeeMaker(),
                product.accessory(),
                product.imageUrls(),
                product.tags(),
                product.rating(),
                product.createdAt(),
                product.updatedAt()
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

    public static List<com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductResponseList> toResponseListV2(List<Product> products) {
        return products.stream()
                .map(it -> new com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductResponseList(
                        it.id(),
                        it.name(),
                        it.price(),
                        it.category(),
                        it.stockQuantity(),
                        it.status(),
                        it.tags(),
                        it.createdAt(),
                        it.updatedAt()
                ))
                .toList();
    }

    public static com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductDetails toDetailsV2(Product product) {
        return new com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductDetails(
                product.id(),
                product.name(),
                product.description(),
                product.price(),
                product.category(),
                product.stockQuantity(),
                product.status(),
                product.drink(),
                product.coffeeMaker(),
                product.accessory(),
                product.imageUrls(),
                product.tags(),
                product.rating(),
                product.createdAt(),
                product.updatedAt()
        );
    }

}
