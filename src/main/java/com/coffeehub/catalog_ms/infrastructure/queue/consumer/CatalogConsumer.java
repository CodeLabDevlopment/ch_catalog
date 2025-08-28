package com.coffeehub.catalog_ms.infrastructure.queue.consumer;

import com.coffeehub.catalog_ms.application.gateway.OrchestratorMessage;
import com.coffeehub.catalog_ms.domain.model.MessageContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class CatalogConsumer {

    private final OrchestratorMessage orchestratorMessage;

    public CatalogConsumer(OrchestratorMessage orchestratorMessage) {
        this.orchestratorMessage = orchestratorMessage;
    }

    @Bean
    public Consumer<Message<MessageContext>> fromStockService() {
        return orchestratorMessage::processMessage;
    }

}
