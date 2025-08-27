package com.coffeehub.catalog_ms.infrastructure.annotation;

import com.coffeehub.catalog_ms.infrastructure.annotation.impl.ProductValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductValidator.class)
public @interface ValidProduct {
    String message() default "Invalid product data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
