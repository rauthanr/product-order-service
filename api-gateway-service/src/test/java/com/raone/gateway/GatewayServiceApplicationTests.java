package com.raone.gateway;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.raone.gateway.controller.AggregationController;
import com.raone.gateway.data.CustomerRequest;
import com.raone.gateway.service.APIGatewayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(AggregationController.class)
public class GatewayServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests

    @MockBean
    private APIGatewayService apiGatewayService; // Mock the ProductService
    @Autowired
    private ObjectMapper objectMapper; // Used to convert Java objects to JSON and vice versa


    @Test
    public void testGetAggregatedResponses() throws Exception {
        // Arrange: Create a sample request body
        CustomerRequest customerRequest = new CustomerRequest ();
        customerRequest.setCustomerId("123");

        // Act & Assert: Simulate POST request and assert the result
        mockMvc.perform(post("/customershoppingcart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerRequest)))
                .andExpect(status().isOk()); // Expect HTTP 200 OK

    }

}
