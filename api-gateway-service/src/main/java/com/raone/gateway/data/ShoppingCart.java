package com.raone.gateway.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


//@JacksonXmlRootElement
public class ShoppingCart {
    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @JacksonXmlProperty(localName = "productId")
    private Integer productId;

    @JacksonXmlProperty(localName = "quantity")
    private Integer quantity;

    @JacksonXmlProperty(localName = "customerId")
    private Integer customerId;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer id, Integer productId, Integer quantity, Integer customerId) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
