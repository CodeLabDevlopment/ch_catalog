package com.coffeehub.catalog_ms.infrastructure.web.controller.v2;

import com.coffeehub.catalog_ms.application.usecases.product.CreateProductCase;
import com.coffeehub.catalog_ms.application.usecases.product.DeleteProductCase;
import com.coffeehub.catalog_ms.application.usecases.product.FindByProductIdCase;
import com.coffeehub.catalog_ms.application.usecases.product.ListProductsCase;
import com.coffeehub.catalog_ms.application.usecases.product.UpdateProductCase;
import com.coffeehub.catalog_ms.domain.model.Product;
import com.coffeehub.catalog_ms.infrastructure.mapper.ProductMapper;
import com.coffeehub.catalog_ms.infrastructure.web.request.CreateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.request.UpdateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductResponseList;
import com.coffeehub.catalog_ms.infrastructure.web.routes.ProductRoutesV2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerV2 implements ProductRoutesV2 {

    private final FindByProductIdCase findProductByIdCase;
    private final ListProductsCase getProductsCase;
    private final CreateProductCase createProductCase;
    private final DeleteProductCase deleteProductCase;
    private final UpdateProductCase updateProductCase;

    @Override
    public ResponseEntity<Page<ProductResponseList>> listProductsToAdmin(String search, Pageable pageable) {
        List<Product> products = this.getProductsCase.execute(search);
        List<ProductResponseList> response = ProductMapper.toResponseListV2(products);
        return ResponseEntity.ok().body(new PageImpl<>(response, pageable, response.size()));
    }

    @Override
    public ResponseEntity<ProductDetails> getProductByIdToAdmin(String productId) {
        Product product = this.findProductByIdCase.execute(productId);
        ProductDetails response = ProductMapper.toDetailsV2(product);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Void> createProduct(CreateProductRequest request) {
        Product product = ProductMapper.toDomain(request);
        this.createProductCase.execute(product);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> updateProduct(String productId, UpdateProductRequest request) {
        Product product = ProductMapper.toDomain(request);
        this.updateProductCase.execute(productId, product);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteProduct(String productId) {
        this.deleteProductCase.execute(productId);
        return ResponseEntity.noContent().build();
    }

}
