package com.coffeehub.catalog_ms.infrastructure.web.routes;

import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v1.ProductResponseList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/product")
@Tag(name = "Product V1", description = "Open access endpoints on products")
public interface ProductRoutesV1 {

    @Operation(summary = "List Products", description = "Retrieve a paginated list of products with optional search filtering.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of products")
    @Parameters(value = {
            @Parameter(name = "search", description = "Optional search term to filter products by name or description", required = false),
            @Parameter(name = "page", description = "Page number for pagination (0-based)", required = false),
            @Parameter(name = "size", description = "Number of items per page for pagination", required = false),
            @Parameter(name = "sort", description = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.", required = false)
    })
    @GetMapping("/list")
    ResponseEntity<Page<ProductResponseList>> listProducts(@RequestParam(required = false) String search, Pageable pageable);

    @Operation(summary = "Get Product by ID", description = "Retrieve detailed information about a specific product by its ID.")
    @Parameter(name = "productId", description = "The ID of the product to retrieve", required = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product details"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{productId}")
    ResponseEntity<ProductDetails> getProductById(@PathVariable String productId);

}
