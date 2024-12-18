package com.raone.shoppingcart.service;


import com.raone.shoppingcart.ShoppingCartServiceApplication;
import com.raone.shoppingcart.data.CustomerRequest;
import com.raone.shoppingcart.data.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {
    public List<ShoppingCart> getshoppingcarts(CustomerRequest customerRequest) {

        Map<Integer, ShoppingCart> shoppingCartMap = ShoppingCartServiceApplication.SHOPPINGCARTMAP;
        List<Integer> keys = new ArrayList<>(shoppingCartMap.keySet());
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        Integer customerIdInt = Integer.parseInt(customerRequest.getCustomerId());
        for (Integer key : keys) {
            if (shoppingCartMap.get(key).getCustomerId().equals(customerIdInt)) {
                shoppingCartList.add(shoppingCartMap.get(key));
            }

        }

        return shoppingCartList;

    }
}
