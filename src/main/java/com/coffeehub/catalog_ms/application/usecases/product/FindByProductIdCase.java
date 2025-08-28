package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.CacheGateway;
import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.StockGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

public record FindByProductIdCase(StockGateway stockGateway, LogsGateway log, CacheGateway cacheGateway) {

    public Product execute(String productId) {
        log.debug("Find product by id: {}", productId);
        Product product = this.cacheGateway.findProductById(productId);

        if (product != null) {
            log.debug("Product found in cache");
            return product;
        }

        log.debug("Product not found in cache, fetching from stock service");
        return this.stockGateway.findProductById(productId);
    }

}
