package com.viveknaskar.microservices.currencyexchangeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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

    @GetMapping("/sample-api")
    /**
     * By default, the Retry annotation will call the endpoint 3 times
     * The number of retries can be modified by configuring in the application.properties
     * The fallback method will be executed to give the desired response instead of failure
     */
    // @Retry(name = "sample-api", fallbackMethod = "otherResponse")

    /**
     * Circuit Breaker lets the microservice application to continue operating when a
     * related service fails, preventing the failure from cascading and giving the
     * failing service time to recover.
     */
    //@CircuitBreaker(name = "default", fallbackMethod = "otherResponse")

    /**
     * Rate Limiting basically says that in 10 seconds, 500 calls to the default api
     */
    @RateLimiter(name = "default")
    public String sampleApi() {
        LOGGER.info("Sample api call received");
        /**
        ResponseEntity<String> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8080/some-other-api", null);
        return responseEntity.getBody();
        */

        return "Sample api";

    }

    private String otherResponse(Exception ex) {
        return "Fallback response";
    }
}
