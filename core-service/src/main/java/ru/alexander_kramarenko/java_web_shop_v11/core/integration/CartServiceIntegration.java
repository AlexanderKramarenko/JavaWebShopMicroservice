package ru.alexander_kramarenko.java_web_shop_v11.core.integration;

import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    @Value("${integration.cart-service.url}")
    private String cartServiceUrl;

    public CartDto getUserCartDto(String username) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("username", username);
        return restTemplate.exchange(cartServiceUrl, HttpMethod.GET, new HttpEntity(headers), CartDto.class).getBody();
    }

    public void clearUserCart(String username) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("username", username);
        restTemplate.exchange(cartServiceUrl + "/clear", HttpMethod.GET, new HttpEntity(headers), void.class);
    }
}
