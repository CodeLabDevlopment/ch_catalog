package com.coffeehub.catalog_ms.infrastructure.usecases;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import com.coffeehub.catalog_ms.application.gateway.PersistenceGateway;
import com.coffeehub.catalog_ms.application.usecases.product.CreateProductCase;
import com.coffeehub.catalog_ms.application.usecases.product.DeleteProductCase;
import com.coffeehub.catalog_ms.application.usecases.product.FindByProductIdCase;
import com.coffeehub.catalog_ms.application.usecases.product.ListProductsCase;
import com.coffeehub.catalog_ms.application.usecases.product.UpdateProductCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCase {

    @Bean
    public FindByProductIdCase findProductByIdCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new FindByProductIdCase(persistenceGateway, logsGateway);
    }

    @Bean
    public ListProductsCase getProductsCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new ListProductsCase(persistenceGateway, logsGateway);
    }

    @Bean
    public CreateProductCase createProductCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new CreateProductCase(persistenceGateway, logsGateway);
    }

    @Bean
    public DeleteProductCase deleteProductCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new DeleteProductCase(persistenceGateway, logsGateway);
    }

    @Bean
    public UpdateProductCase updateProductCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new UpdateProductCase(persistenceGateway, logsGateway);
    }

}
