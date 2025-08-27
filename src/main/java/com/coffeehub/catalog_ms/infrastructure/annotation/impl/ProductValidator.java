package com.coffeehub.catalog_ms.infrastructure.annotation.impl;

import com.coffeehub.catalog_ms.domain.enums.ProductCategory;
import com.coffeehub.catalog_ms.infrastructure.annotation.ValidProduct;
import com.coffeehub.catalog_ms.infrastructure.web.request.CreateProductRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ValidProduct, CreateProductRequest> {

    @Override
    public boolean isValid(CreateProductRequest request, ConstraintValidatorContext context) {
        if (ProductCategory.DRINK.equals(request.category()) && request.drink() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Drink is required when category is DRINK")
                    .addPropertyNode("drink")
                    .addConstraintViolation();
            return false;
        }

        if (ProductCategory.COFFEE_MAKER.equals(request.category()) && request.coffeeMaker() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("CoffeeMaker is required when category is COFFEE_MAKER")
                    .addPropertyNode("coffeeMaker")
                    .addConstraintViolation();
            return false;
        }

        if (ProductCategory.ACCESSORY.equals(request.category()) && request.accessory() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Accessory is required when category is ACCESSORY")
                    .addPropertyNode("accessory")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
