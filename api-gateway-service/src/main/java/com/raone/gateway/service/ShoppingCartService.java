package com.raone.gateway.service;


import com.raone.gateway.data.Root;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShoppingCartService {
    private final RestTemplate restTemplate;

    public ShoppingCartService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Root> callShoppingCartAPI(String url, Object requestBody) {
        HttpHeaders headers = new HttpHeaders();
        // Set content type if required (e.g., JSON)
        headers.setContentType(MediaType.APPLICATION_XML);

        // Add request body to HttpEntity
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

        // Use HttpMethod.POST for the POST request
        return restTemplate.exchange(url, HttpMethod.POST, entity, Root.class);
    }
}
