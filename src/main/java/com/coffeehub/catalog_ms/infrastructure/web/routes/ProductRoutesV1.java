package com.coffeehub.catalog_ms.infrastructure.web.routes;

import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductResponseList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/product")
public interface ProductRoutesV1 {

    @GetMapping("/list")
    ResponseEntity<Page<ProductResponseList>> listProducts(@RequestParam(required = false) String search, Pageable pageable);

    @GetMapping("/{productId}")
    ResponseEntity<ProductDetails> getProductById(@PathVariable String productId);

}
