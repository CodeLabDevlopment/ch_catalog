package com.coffeehub.catalog_ms.infrastructure.web.controller.v1;

import com.coffeehub.catalog_ms.application.usecases.product.FindByProductIdCase;
import com.coffeehub.catalog_ms.application.usecases.product.ListProductsCase;
import com.coffeehub.catalog_ms.domain.model.Product;
import com.coffeehub.catalog_ms.infrastructure.mapper.ProductMapper;
import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductResponseList;
import com.coffeehub.catalog_ms.infrastructure.web.routes.ProductRoutesV1;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerV1 implements ProductRoutesV1 {

    private final FindByProductIdCase findProductByIdCase;
    private final ListProductsCase getProductsCase;

    @Override
    public ResponseEntity<Page<ProductResponseList>> listProducts(String search, Pageable pageable) {
        List<Product> products = this.getProductsCase.execute(search);
        List<ProductResponseList> response = ProductMapper.toResponseList(products);
        return ResponseEntity.ok().body(new PageImpl<>(response, pageable, response.size()));
    }

    @Override
    public ResponseEntity<ProductDetails> getProductById(String productId) {
        Product product = this.findProductByIdCase.execute(productId);
        ProductDetails response = ProductMapper.toDetails(product);
        return ResponseEntity.ok().body(response);
    }

}
