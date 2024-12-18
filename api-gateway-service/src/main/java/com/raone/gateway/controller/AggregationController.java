package com.raone.gateway.controller;


import com.raone.gateway.data.*;
import com.raone.gateway.service.APIGatewayService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/customershoppingcart")
public class AggregationController {

    private final APIGatewayService apiGatewayService;

    public AggregationController(APIGatewayService apiGatewayService) {
        this.apiGatewayService = apiGatewayService;
    }

    @PostMapping
    public ResponseEntity<CustomershoppingcartWrapper> getAggregatedResponses(@RequestBody CustomerRequest customerRequest) {

        CustomershoppingcartWrapper aggregatedResponseResult = apiGatewayService.getCustomershoppingcartWrapper(customerRequest);
        return ResponseEntity.ok(aggregatedResponseResult);

    }

}
