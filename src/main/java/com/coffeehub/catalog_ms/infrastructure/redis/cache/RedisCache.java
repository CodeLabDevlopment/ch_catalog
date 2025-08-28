package com.coffeehub.catalog_ms.infrastructure.redis.cache;

import com.coffeehub.catalog_ms.application.gateway.CacheGateway;
import com.coffeehub.catalog_ms.domain.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.coffeehub.catalog_ms.domain.utils.Constants.REDIS_KEY_PRODUCTS;

@Log4j2
@Service
public class RedisCache implements CacheGateway {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisCache(RedisTemplate<String, Object> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void save(String key, Object value) {
        try {
            log.debug("Saving key: {} in cache with value: {}", key, value);
            redisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(value));
        } catch (JsonProcessingException ex) {
            log.error("Error serializing value for key: {}. Error: {}", key, ex.getMessage());
        }
    }

    @Override
    public List<Product> findAll(String key) {
        log.debug("Retrieving key: {} from cache", key);
        String value = (String) redisTemplate.opsForValue().get(key);

        if (value == null) {
            return List.of();
        }

        try {
            return objectMapper.readValue(
                    value,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class)
            );
        } catch (JsonProcessingException ex) {
            log.error("Error deserializing value for key: {}", key, ex);
            return List.of();
        }
    }

    @Override
    public Product findProductById(String productId) {
        List<Product> products = this.findAll(REDIS_KEY_PRODUCTS);
        return products.stream()
                .filter(it -> it.id().equals(productId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String key) {
        log.debug("Deleting key: {} from cache", key);
        redisTemplate.delete(key);
    }

}
