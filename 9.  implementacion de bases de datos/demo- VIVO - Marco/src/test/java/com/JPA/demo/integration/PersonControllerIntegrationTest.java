package com.JPA.demo.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

public class PersonControllerIntegrationTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;
}
