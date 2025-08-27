package com.coffeehub.catalog_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.util.TimeZone;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableMongoAuditing
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class CatalogMsApplication {

    // TODO: Esse serviço irá precisar receber eventos do ms de pedidos para atualizar o estoque dos produtos

	public static void main(String[] args) {
        SpringApplication.run(CatalogMsApplication.class, args);
	}

}
