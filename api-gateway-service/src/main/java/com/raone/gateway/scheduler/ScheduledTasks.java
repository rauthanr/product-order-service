package com.raone.gateway.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

    private static String UPDATEURL = "http://localhost:8081/updateprice";
    private final RestTemplate restTemplate;

    @Autowired
    public ScheduledTasks(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 60000) // 60000 milliseconds = 1 minute
    public void performTask() {
        // Your task logic here
        System.out.println("Scheduled task executed at: " + System.currentTimeMillis());

        restTemplate.getForObject(UPDATEURL, Object.class);

    }



}
