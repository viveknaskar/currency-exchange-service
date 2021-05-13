package com.viveknaskar.microservices.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircuitBreakerController.class);

    /**
     * By default, the Retry annotation will call the endpoint 3 times
     * The number of retries can be modified by configuring in the application.properties
     * @return
     */
    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "otherResponse")
    public String sampleApi() {
        LOGGER.info("Sample api call received");
        ResponseEntity<String> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8080/some-other-api", null);
        return responseEntity.getBody();
    }

    private String otherResponse(Exception ex) {
        return "Fallback response";
    }
}
