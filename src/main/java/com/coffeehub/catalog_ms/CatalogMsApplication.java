package com.coffeehub.catalog_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableFeignClients
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class CatalogMsApplication {

	public static void main(String[] args) {
        SpringApplication.run(CatalogMsApplication.class, args);
	}

}
