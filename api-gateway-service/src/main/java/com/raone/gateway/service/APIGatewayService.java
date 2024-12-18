package com.raone.gateway.service;


import com.raone.gateway.data.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class APIGatewayService {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    public APIGatewayService(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @Cacheable(value = "shoppingCart", key = "#customerRequest.customerId", unless = "#result == null")
    public CustomershoppingcartWrapper getCustomershoppingcartWrapper(CustomerRequest customerRequest) {


        // Call second API
        ResponseEntity<Root> api2Response = shoppingCartService.callShoppingCartAPI("http://localhost:8082/getshoppingcarts", customerRequest);

       if(api2Response == null || !(api2Response.getBody().getShoppingCartList().size()>0)){

            return null;
        }

        List<Integer> ids = api2Response.getBody().getShoppingCartList().stream()
                .map(element -> element.getProductId())
                .collect(Collectors.toList());


        // Call first API
        IdsRequest idsRequest = new IdsRequest();
        idsRequest.setIds(ids);
        ResponseEntity<List<Product>> api1Response = productService.callProductAPI("http://localhost:8081/products", idsRequest);


        // Aggregate responses
        CustomershoppingcartWrapper aggregatedResponseResult = aggregateResponses(api1Response.getBody(), api2Response.getBody());
        return aggregatedResponseResult;
    }


    private CustomershoppingcartWrapper aggregateResponses(List<Product> productList, Root cartRoot) {

        CustomershoppingcartWrapper customershoppingcartWrapper = new CustomershoppingcartWrapper();
        Map<Integer, Product> productMap = new HashMap<>();
        Double totalPrice = 0.0;
        productList.forEach(product -> {
            productMap.put(product.getId(), product);
        });
        cartRoot.getShoppingCartList().forEach(cartElement -> {

            Customershoppingcart customershoppingcart = new Customershoppingcart();
            customershoppingcart.setId(cartElement.getId());
            customershoppingcart.setProductId(cartElement.getProductId());
            customershoppingcart.setQuantity(cartElement.getQuantity());
            customershoppingcart.setCustomerId(cartElement.getCustomerId());
            customershoppingcart.setName(productMap.get(cartElement.getProductId()).getName());
            customershoppingcart.setPrice(productMap.get(cartElement.getProductId()).getPrice());
            customershoppingcartWrapper.setTotalPrice( customershoppingcartWrapper.getTotalPrice() + (customershoppingcart.getPrice() * customershoppingcart.getQuantity()));
            customershoppingcartWrapper.getShoppingCarts().add(customershoppingcart);
        });

        return customershoppingcartWrapper;
    }

}
