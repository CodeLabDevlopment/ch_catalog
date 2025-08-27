package com.coffeehub.catalog_ms.infrastructure.web.routes;

import com.coffeehub.catalog_ms.infrastructure.web.request.CreateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.request.UpdateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductResponseList;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v2/product")
public interface ProductRoutesV2 {

    @GetMapping("/list")
    ResponseEntity<Page<ProductResponseList>> listProductsToAdmin(@RequestParam(required = false) String search, Pageable pageable);

    @GetMapping("/{productId}")
    ResponseEntity<ProductDetails> getProductByIdToAdmin(@PathVariable String productId);

    @PostMapping("/create")
    ResponseEntity<Void> createProduct(@Valid @RequestBody CreateProductRequest request);

    // TODO: Implementar rota para subir imagens do produto

    @PatchMapping("/{productId}/update")
    ResponseEntity<Void> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest request);

    @DeleteMapping("/{productId}/delete")
    ResponseEntity<Void> deleteProduct(@PathVariable String productId);

}
