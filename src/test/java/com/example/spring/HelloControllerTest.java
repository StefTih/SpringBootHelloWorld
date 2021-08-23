package com.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//By configuring those two annotations we allow InteliJ to inject a MockMvc instance
//With SpringBootTest we are asking for the whole application context to be created. An alternative would be to ask
//        Spring Boot to create only the web layers of the context by using @WebMvcTest.
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

//    MockMvc comes from SpringTest and lets you, through a set of convenient builder classes,
//    send HTTP requests into the DispatcherServlet and make assertions about the result.
    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect((ResultMatcher) content().string("Gereetings" +
                "from Spring Boot!"));
    }


}
