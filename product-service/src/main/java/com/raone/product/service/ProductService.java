package com.raone.product.service;


import com.raone.product.ProductServiceApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.raone.product.data.Product;

@Service
public class ProductService {

    public List<Product> getAllProductList(){
        List<Product> productList = new ArrayList<Product>(ProductServiceApplication.PRODUCTMAP.values());

        return productList;
    }


    public List<Product> getProductList( List<Integer> inputIds){
        Map<Integer, Product> productMap = ProductServiceApplication.PRODUCTMAP;
        List<Integer> keys = new ArrayList<>(productMap.keySet());
        List<Product> productList = new ArrayList<>();
        for(Integer id:inputIds){
            if(keys.contains(id)){
                productList.add(productMap.get(id));
            }

        }

        return productList;
    }

    public Product updateProductPrice(Product product) {
        Map<Integer, Product> productMap = ProductServiceApplication.PRODUCTMAP;
        // Random Number between 100 and 1000
        Double price = Math.round((Math.random() * 901)* 100.0)/100.0 + 100.0;
        productMap.get(product.getId()).setPrice(price);

        return  productMap.get(product.getId());
    }

    public List<Product> updateAllProductPrices() {
        Map<Integer, Product> productMap = ProductServiceApplication.PRODUCTMAP;
        List<Product> productList = new ArrayList<>(productMap.values());
        productList.forEach(product -> product.setPrice(Math.round((Math.random() * 901)* 100.0)/100.0 + 100.0));

        return productList;
    }

}
