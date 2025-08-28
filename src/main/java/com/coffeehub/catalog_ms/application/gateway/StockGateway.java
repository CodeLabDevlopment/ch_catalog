package com.coffeehub.catalog_ms.application.gateway;

import com.coffeehub.catalog_ms.domain.model.Product;

import java.util.List;

public interface StockGateway {

    List<Product> findAll(String search);

    Product findProductById(String productId);

}
