package com.coffeehub.catalog_ms.application.gateway;

import com.coffeehub.catalog_ms.domain.model.Product;

import java.util.List;

public interface PersistenceGateway {

    List<Product> findAllProducts();

    List<Product> searchProductsByName(String search);

    Product findProductById(String productId);

    void save(Product product);

    void delete(Product product);

}
