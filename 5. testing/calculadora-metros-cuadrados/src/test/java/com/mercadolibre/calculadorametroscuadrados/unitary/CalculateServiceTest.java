package com.mercadolibre.calculadorametroscuadrados.unitary;

import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateServiceTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    CalculateService calculateService;


}
