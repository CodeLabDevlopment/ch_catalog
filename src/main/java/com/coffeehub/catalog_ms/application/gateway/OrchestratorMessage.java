package com.coffeehub.catalog_ms.application.gateway;

import com.coffeehub.catalog_ms.domain.model.MessageContext;
import org.springframework.messaging.Message;

public interface OrchestratorMessage {
    void processMessage(Message<MessageContext> message);
}
