package com.raone.product.controller;

import com.raone.product.data.IdsRequest;
import com.raone.product.data.Product;
import com.raone.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> list = productService.getAllProductList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestBody IdsRequest idsRequest) {
        List<Integer> inputIds = idsRequest.getIds();
        List<Product> resultList = productService.getProductList(inputIds);

        return new ResponseEntity<>(resultList,HttpStatus.OK);
    }

    @PostMapping("/updateprice")
    public ResponseEntity<Product> updateProductPrices(@RequestBody Product product){
        Product updatedProduct = productService.updateProductPrice(product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @GetMapping("/updateprice")
    public ResponseEntity<List<Product>> updateProductPrices(){
        List<Product> updatedProductList = productService.updateAllProductPrices();
        return new ResponseEntity<>(updatedProductList,HttpStatus.OK);
    }

}
