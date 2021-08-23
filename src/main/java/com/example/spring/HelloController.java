package com.example.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// In this case, our class is a web @Controller, so Spring considers it when handling incoming web requests.
@RestController
@EnableAutoConfiguration
public class HelloController {

//    The @RequestMapping annotation provides “routing” information. It tells Spring that any HTTP request
//    with the / path should be mapped to the home method. The @RestController annotation tells Spring to
//    render the resulting string directly back to the caller.
    @GetMapping("/")
    String home(){
        return "Hello World!";
    }

}
