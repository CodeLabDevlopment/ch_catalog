package com.coffeehub.catalog_ms.infrastructure.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Coffee Hub - Catalog Microservice API")
                        .description("API documentation for the Catalog Microservice of Coffee Hub application.")
                        .summary("Catalog Microservice API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Code Lab Devlopment")
                                .email("luksmnt1101@gmail.com")
                                .url("https://github.com/CodeLabDevlopment")
                        )
                        .license(new License()
                                .name("MIT License")
                                .identifier("MIT")
                        )
                )
                .servers(List.of(
                        new Server()
                                .description("Local Server")
                                .url("http://localhost:8080")
                ));
    }

}
