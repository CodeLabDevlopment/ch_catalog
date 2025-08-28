package com.coffeehub.catalog_ms.infrastructure.client;

import com.coffeehub.catalog_ms.infrastructure.web.response.ProductResponseList;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "stock-client", url = "${feign.client.config.stock-ms.url}")
public interface StockClient {

    @GetMapping("/list")
    List<ProductResponseList> listProducts(@RequestParam(required = false) String search);

    @GetMapping("/{productId}")
    Response getProductById(@PathVariable String productId);

}
