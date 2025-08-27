package com.coffeehub.catalog_ms.application.gateway;

public interface LogsGateway {

    void info(String message, Object... args);
    void error(String message, Object... args);
    void debug(String message, Object... args);
    void warn(String message, Object... args);

}
