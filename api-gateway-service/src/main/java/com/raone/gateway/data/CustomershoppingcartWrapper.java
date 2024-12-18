package com.raone.gateway.data;

import java.util.ArrayList;
import java.util.List;

public class CustomershoppingcartWrapper {

    private Double totalPrice = 0.0;
    private List<Customershoppingcart> shoppingCarts = new ArrayList<>();

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Customershoppingcart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<Customershoppingcart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }
}
