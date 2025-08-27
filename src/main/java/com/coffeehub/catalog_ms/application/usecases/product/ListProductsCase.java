package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.PersistenceGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

import java.util.List;

public record ListProductsCase(PersistenceGateway persistenceGateway, LogsGateway log) {

    public List<Product> execute(String search) {
        log.debug("Get all products");
        return search == null || search.isBlank()
                ? persistenceGateway.findAllProducts()
                : persistenceGateway.searchProductsByName(search);
    }

}
