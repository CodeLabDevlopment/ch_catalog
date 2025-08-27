package com.coffeehub.catalog_ms.infrastructure.gateway;

import com.coffeehub.catalog_ms.application.gateway.LogsGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LogsGatewayImpl implements LogsGateway {

    @Override
    public void info(String message, Object... args) {
        log.info(message, args);
    }

    @Override
    public void error(String message, Object... args) {
        log.error(message, args);
    }

    @Override
    public void debug(String message, Object... args) {
        log.debug(message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        log.warn(message, args);
    }

}
