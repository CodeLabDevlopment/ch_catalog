package com.coffeehub.catalog_ms.domain.model;

import com.coffeehub.catalog_ms.domain.enums.UpdateType;

import java.time.LocalDateTime;

public record MessageContext(
        LocalDateTime timestamp,
        UpdateType updateType
) {

}
