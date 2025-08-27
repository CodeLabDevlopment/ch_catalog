package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.PersistenceGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

public record DeleteProductCase(PersistenceGateway persistenceGateway, LogsGateway log) {

    public void execute(String productId) {
        log.debug("Deleting product with id {}", productId);
        Product product = this.persistenceGateway.findProductById(productId);
        this.persistenceGateway.delete(product);
        this.log.info("Product with id {} deleted", productId);
    }

}
