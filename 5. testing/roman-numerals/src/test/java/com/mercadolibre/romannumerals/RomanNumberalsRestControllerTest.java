package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanNumberalsRestControllerTest {

    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @Test
    void test1ToRoman(){
        runTest(1,"I");
    }

    @Test
    void test3554ToRoman(){
        runTest(3554,"MMMDLIV");
    }
    private void runTest(int number, String roman){
        String result = controller.toRoman(number);
        assertEquals(roman,result);
    }

}
