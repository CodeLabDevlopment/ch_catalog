package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.StockGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

import java.util.List;

public record ListProductsCase(StockGateway stockGateway, LogsGateway log) {

    public List<Product> execute(String search) {
        log.debug("Get all products");
        return this.stockGateway.findAll(search);
    }

}
