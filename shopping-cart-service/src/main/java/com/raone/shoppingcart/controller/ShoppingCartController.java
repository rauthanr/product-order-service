package com.raone.shoppingcart.controller;


import com.raone.shoppingcart.data.CustomerRequest;
import com.raone.shoppingcart.data.Root;
import com.raone.shoppingcart.data.ShoppingCart;
import com.raone.shoppingcart.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping(value = "/getshoppingcarts", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Root> getshoppingcarts(@RequestBody CustomerRequest customerRequest) {

        Root  resultList = new Root();
        resultList.setShoppingCartList(shoppingCartService.getshoppingcarts(customerRequest));

        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
}
