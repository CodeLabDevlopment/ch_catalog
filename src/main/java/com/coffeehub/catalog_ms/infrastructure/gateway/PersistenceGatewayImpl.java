package com.coffeehub.catalog_ms.infrastructure.gateway;

import com.coffeehub.catalog_ms.application.gateway.PersistenceGateway;
import com.coffeehub.catalog_ms.domain.model.Product;
import com.coffeehub.catalog_ms.infrastructure.db.entity.ProductEntity;
import com.coffeehub.catalog_ms.infrastructure.db.repository.ProductRepository;
import com.coffeehub.catalog_ms.infrastructure.mapper.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PersistenceGatewayImpl implements PersistenceGateway {

    private final ProductRepository productRepository;

    public PersistenceGatewayImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public List<Product> searchProductsByName(String search) {
        return this.productRepository.findByNameContainingIgnoreCase(search)
                .stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public Product findProductById(String productId) {
        return this.productRepository.findById(productId)
                .map(ProductMapper::toDomain)
                .orElseThrow(() -> {
                    log.error("Product with id {} not found", productId);
                    return new RuntimeException("Product not found");
                });
    }

    @Override
    public void save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        this.productRepository.save(entity);
        log.debug("Product with id {} saved", product.id());
    }

    @Override
    public void delete(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        this.productRepository.delete(entity);
    }

}
