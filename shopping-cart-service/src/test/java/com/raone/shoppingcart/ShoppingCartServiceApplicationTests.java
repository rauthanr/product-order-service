package com.raone.shoppingcart;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.raone.shoppingcart.controller.ShoppingCartController;
import com.raone.shoppingcart.data.CustomerRequest;
import com.raone.shoppingcart.data.XmlConfig;
import com.raone.shoppingcart.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShoppingCartController.class)
@Import(XmlConfig.class) // Explicitly import the configuration
public class ShoppingCartServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests

    @MockBean
    private ShoppingCartService shoppingCartService; // Mock the ProductService
    @Autowired
    private ObjectMapper objectMapper; // Used to convert Java objects to JSON and vice versa

    @Autowired
    private XmlMapper xmlMapper; // Use XmlMapper for XML serialization

    @Test
    public void testGetshoppingcarts() throws Exception {
        // Arrange: Create a sample request body
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerId("123");

        String xmlRequestBody = xmlMapper.writeValueAsString(customerRequest);

        // Act & Assert: Simulate POST request and assert the result
        mockMvc.perform(post("/getshoppingcarts")
                        .contentType(MediaType.APPLICATION_XML)
                        .content(xmlRequestBody))
                .andExpect(status().isOk()); // Expect HTTP 200 OK

    }
}
