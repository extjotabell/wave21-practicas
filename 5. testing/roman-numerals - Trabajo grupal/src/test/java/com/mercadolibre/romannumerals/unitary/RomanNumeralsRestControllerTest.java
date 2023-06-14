package com.mercadolibre.romannumerals.unitary;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Convert to Roman number - Under one")
    void convertToRomanUnderOne() throws Exception{
        // x > 3999
        Integer number = 0;
        performTest(number, "");
    }

    @Test
    @DisplayName("Convert to Roman number - Under Four Thousands")
    void convertToRomanUnderFourThousands() throws Exception{
        // x > 3999
        Integer number = 3999;
        performTest(number, "MMMCMXCIX");
    }

    @Test
    @DisplayName("Convert to Roman number - 2001 Year")
    void convertToRomanYearLuz() throws Exception{
        // x = 2001
        Integer number = 2001;
        performTest(number, "MMI");
    }

    @Test
    @DisplayName("Convert to Roman number - 1994 Year")
    void convertToRomanYearGonzalo() throws Exception{
        // x = 1994
        Integer number = 1994;
        performTest(number, "MCMXCIV");
    }

    @Test
    @DisplayName("Convert to Roman number - 1996 Year")
    void convertToRomanYearMartin() throws Exception{
        // x = 1996
        Integer number = 1996;
        performTest(number, "MCMXCVI");
    }

    @Test
    @DisplayName("Convert to Roman number - Above Four Thousands")
    void convertToRomanAboveFourThousands() throws Exception{
        Integer number = 5000;
        performTest(number, "");
    }

    private void performTest(Integer decimal, String roman) throws Exception {
        this.mockMvc.perform(get("/{number}", decimal))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(roman)));
    }
}
