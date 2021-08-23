package com.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//The embedded server starts on a random port beacuse of webEnvironment, and the actual
//port is configured automatically in the base URL for the TestRestTemplate.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getHello() {
        ResponseEntity<String> reponse = template.getForEntity("/",String.class);
        assertThat(reponse.getBody()).isEqualTo("Greetings from Spring Boot!");
    }
}
