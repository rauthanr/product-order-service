package com.raone.shoppingcart;

import com.raone.shoppingcart.data.ShoppingCart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ShoppingCartServiceApplication {

    public static Map<Integer, ShoppingCart> SHOPPINGCARTMAP = populateShoppingCart();

    private static Map<Integer, ShoppingCart> populateShoppingCart() {
        Map<Integer, ShoppingCart> shoppingCartMap = new HashMap<>();

        shoppingCartMap.put(1, new ShoppingCart(1,10,5,123));
        shoppingCartMap.put(2, new ShoppingCart(2,11,3,123));
        shoppingCartMap.put(3, new ShoppingCart(3,12,4,123));
        return shoppingCartMap;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartServiceApplication.class, args);
    }
}
