package com.raone.product;

import com.raone.product.data.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ProductServiceApplication {

	public static Map<Integer, Product> PRODUCTMAP = populateProductMap();

	private static Map<Integer, Product> populateProductMap() {
		Map<Integer, Product> productMap = new HashMap<>();
		productMap.put(10, new Product(10, "X", 500.0));
		productMap.put(11, new Product(11, "Y", 400.0));
		productMap.put(12, new Product(12, "Z", 300.0));

		return productMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
