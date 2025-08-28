package com.coffeehub.catalog_ms.infrastructure.gateway;

import com.coffeehub.catalog_ms.application.gateway.StockGateway;
import com.coffeehub.catalog_ms.domain.model.Product;
import com.coffeehub.catalog_ms.infrastructure.client.StockClient;
import com.coffeehub.catalog_ms.infrastructure.mapper.ProductMapper;
import com.coffeehub.catalog_ms.infrastructure.web.response.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.ProductResponseList;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Log4j2
@Service
public class StockGatewayImpl implements StockGateway {

    private final StockClient stockClient;
    private final ObjectMapper objectMapper;

    public StockGatewayImpl(StockClient stockClient, ObjectMapper objectMapper) {
        this.stockClient = stockClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Product> findAll(String search) {
        log.debug("Fetching products from Stock MS with search: {}", search);
        List<ProductResponseList> response = this.stockClient.listProducts(search);

        return response.stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public Product findProductById(String productId) {
        log.debug("Fetching product by ID from Stock MS: {}", productId);
        Response response = this.stockClient.getProductById(productId);
        ProductDetails stockDetails = this.mapperStockDetails(response);

        return ProductMapper.toDomain(stockDetails);
    }

    private ProductDetails mapperStockDetails(Response res) {
        try (InputStream bodyStream = res.body().asInputStream()) {
            return objectMapper.readValue(bodyStream, ProductDetails.class);
        } catch (Exception e) {
            log.error("Error parsing product details from response", e);
            throw new RuntimeException("Failed to parse product details from Stock service", e);
        }
    }

}
