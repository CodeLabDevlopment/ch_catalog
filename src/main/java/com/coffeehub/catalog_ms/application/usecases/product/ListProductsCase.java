package com.coffeehub.catalog_ms.application.usecases.product;

import com.coffeehub.catalog_ms.application.gateway.CacheGateway;
import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.StockGateway;
import com.coffeehub.catalog_ms.domain.model.Product;

import java.util.List;

import static com.coffeehub.catalog_ms.domain.utils.Constants.REDIS_KEY_PRODUCTS;

public record ListProductsCase(StockGateway stockGateway, LogsGateway log, CacheGateway cacheGateway) {

    public List<Product> execute(String search) {
        log.debug("Get all products");
        List<Product> redisProducts = this.cacheGateway.findAll(REDIS_KEY_PRODUCTS);

        if (redisProducts.isEmpty()) {
            return this.fetchFromStockService(search);
        }

        log.debug("Products found in Redis");
        return search == null || search.isBlank()
                ? redisProducts
                : redisProducts.stream()
                        .filter(it -> it.name().toLowerCase().contains(search.toLowerCase()))
                        .toList();
    }

    private List<Product> fetchFromStockService(String search) {
        log.debug("No products found in Redis, fetching from stock service");
        List<Product> products = this.stockGateway.findAll(search);
        this.cacheGateway.save(REDIS_KEY_PRODUCTS, products);
        return products;
    }

}
