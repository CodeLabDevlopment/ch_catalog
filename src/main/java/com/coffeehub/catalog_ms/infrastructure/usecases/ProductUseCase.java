package com.coffeehub.catalog_ms.infrastructure.usecases;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.StockGateway;
import com.coffeehub.catalog_ms.application.usecases.product.FindByProductIdCase;
import com.coffeehub.catalog_ms.application.usecases.product.ListProductsCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCase {

    @Bean
    public FindByProductIdCase findProductByIdCase(StockGateway stockGateway, LogsGateway logsGateway) {
        return new FindByProductIdCase(stockGateway, logsGateway);
    }

    @Bean
    public ListProductsCase getProductsCase(StockGateway stockGateway, LogsGateway logsGateway) {
        return new ListProductsCase(stockGateway, logsGateway);
    }

}
