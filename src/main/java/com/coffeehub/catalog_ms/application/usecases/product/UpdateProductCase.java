package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.PersistenceGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

import java.time.Instant;
import java.time.LocalDateTime;

public record UpdateProductCase(PersistenceGateway persistenceGateway, LogsGateway log) {

    public void execute(String productId, Product product) {
        Product existingProduct = this.persistenceGateway.findProductById(productId);

        if (existingProduct == null) {
            log.error("Product with ID {} not found for update.", productId);
            throw new RuntimeException("Product with ID " + productId + " not found.");
        }

        Product updatedProduct = new Product(
                productId,
                product.name() != null ? product.name() : existingProduct.name(),
                product.description() != null ? product.description() : existingProduct.description(),
                product.price() != null ? product.price() : existingProduct.price(),
                existingProduct.category(),
                product.stockQuantity() != null ? product.stockQuantity() : existingProduct.stockQuantity(),
                product.status() != null ? product.status() : existingProduct.status(),
                existingProduct.drink(),
                existingProduct.coffeeMaker(),
                existingProduct.accessory(),
                existingProduct.imageUrls(),
                product.tags() != null ? product.tags() : existingProduct.tags(),
                existingProduct.rating(),
                existingProduct.createdAt(),
                LocalDateTime.now()
        );

        this.persistenceGateway.save(updatedProduct);
        log.debug("Product with ID {} updated successfully.", productId);
    }

}
