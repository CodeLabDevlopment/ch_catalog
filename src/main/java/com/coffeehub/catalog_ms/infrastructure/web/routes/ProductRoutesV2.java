package com.coffeehub.catalog_ms.infrastructure.web.routes;

import com.coffeehub.catalog_ms.infrastructure.web.request.CreateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.request.UpdateProductRequest;
import com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductDetails;
import com.coffeehub.catalog_ms.infrastructure.web.response.v2.ProductResponseList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Product V2", description = "Private Access Endpoints for Product Management")
public interface ProductRoutesV2 {

    @Operation(
            summary = "List Products to Admin",
            description = "Retrieve a paginated list of products with optional search filtering. Admin access required."
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of products")
    @Parameter(name = "search", description = "Optional search term to filter products by name or description", required = false)
    @GetMapping("/list")
    ResponseEntity<Page<ProductResponseList>> listProductsToAdmin(@RequestParam(required = false) String search, Pageable pageable);

    @Operation(
            summary = "Get Product by ID to Admin",
            description = "Retrieve detailed information about a specific product by its ID. Admin access required."
    )
    @Parameter(name = "productId", description = "The ID of the product to retrieve", required = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product details"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{productId}")
    ResponseEntity<ProductDetails> getProductByIdToAdmin(@PathVariable String productId);

    @Operation(
            summary = "Create New Product",
            description = "Create a new product with the provided details. Admin access required."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/create")
    ResponseEntity<Void> createProduct(@Valid @RequestBody CreateProductRequest request);

    // TODO: Implementar rota para subir imagens do produto

    @Operation(
            summary = "Update Existing Product",
            description = "Update the details of an existing product by its ID. Admin access required."
    )
    @Parameter(name = "productId", description = "The ID of the product to update", required = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PatchMapping("/{productId}/update")
    ResponseEntity<Void> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest request);

    @Operation(
            summary = "Delete Product",
            description = "Delete a product by its ID. Admin access required."
    )
    @Parameter(name = "productId", description = "The ID of the product to delete", required = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{productId}/delete")
    ResponseEntity<Void> deleteProduct(@PathVariable String productId);

}
