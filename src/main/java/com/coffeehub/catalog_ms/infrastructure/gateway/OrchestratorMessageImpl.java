package com.coffeehub.catalog_ms.infrastructure.gateway;

import com.coffeehub.catalog_ms.application.gateway.CacheGateway;
import com.coffeehub.catalog_ms.application.gateway.OrchestratorMessage;
import com.coffeehub.catalog_ms.domain.model.MessageContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import static com.coffeehub.catalog_ms.domain.utils.Constants.REDIS_KEY_PRODUCTS;

@Log4j2
@Service
public class OrchestratorMessageImpl implements OrchestratorMessage {

    private final CacheGateway cacheGateway;

    public OrchestratorMessageImpl(CacheGateway cacheGateway) {
        this.cacheGateway = cacheGateway;
    }

    @Override
    public void processMessage(Message<MessageContext> message) {
        log.debug("Received message: {}", message.getPayload());
        this.cacheGateway.delete(REDIS_KEY_PRODUCTS);
    }

}
