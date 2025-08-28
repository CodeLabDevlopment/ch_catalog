package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.StockGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

public record FindByProductIdCase(StockGateway stockGateway, LogsGateway log) {

    public Product execute(String productId) {
        log.debug("Find product by id: {}", productId);
        return this.stockGateway.findProductById(productId);
    }

}
