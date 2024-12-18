package com.raone.gateway.service;


import com.raone.gateway.data.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<List<Product>> callProductAPI(String url, Object requestBody) {

        HttpHeaders headers = new HttpHeaders();
        // Set content type if required (e.g., JSON)
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Add request body to HttpEntity
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

        // Use HttpMethod.POST for the POST request
        return restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<List<Product>>() {});
    }
}
