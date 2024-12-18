package com.raone.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raone.product.controller.ProductController;
import com.raone.product.data.IdsRequest;
import com.raone.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

//@SpringBootTest
@WebMvcTest(ProductController.class)
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc; // Used to simulate HTTP requests

	@MockBean
	private ProductService productService; // Mock the ProductService
	@Autowired
	private ObjectMapper objectMapper; // Used to convert Java objects to JSON and vice versa

	@Test
	public  void testUpdateProductPrices() throws Exception {

		mockMvc.perform(get("/updateprice")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()); // Expect HTTP 200 OK
	}

	@Test
	public void testProcessIds() throws Exception {
		// Arrange: Create a sample request body
		IdsRequest idsRequest = new IdsRequest();
		idsRequest.setIds(Arrays.asList(10, 11, 12));

		// Act & Assert: Simulate POST request and assert the result
		mockMvc.perform(post("/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(idsRequest)))
				.andExpect(status().isOk()); // Expect HTTP 200 OK

	}

}
