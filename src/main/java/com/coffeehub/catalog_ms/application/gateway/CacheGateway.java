package com.coffeehub.catalog_ms.application.gateway;

import com.coffeehub.catalog_ms.domain.model.Product;

import java.util.List;

public interface CacheGateway {

    void save(String key, Object value);

    List<Product> findAll(String key);

    Product findProductById(String productId);

    void delete(String key);

}
