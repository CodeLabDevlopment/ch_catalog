package com.coffeehub.catalog_ms.infrastructure.db.entity;

import com.coffeehub.catalog_ms.domain.enums.ProductCategory;
import com.coffeehub.catalog_ms.domain.enums.ProductStatus;
import com.coffeehub.catalog_ms.domain.model.Accessory;
import com.coffeehub.catalog_ms.domain.model.CoffeeMaker;
import com.coffeehub.catalog_ms.domain.model.Drink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategory category;
    private Integer stockQuantity;
    private ProductStatus status;
    private Drink drink;
    private CoffeeMaker coffeeMaker;
    private Accessory accessory;
    private List<String> imageUrls;
    private List<String> tags;
    private double rating;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
