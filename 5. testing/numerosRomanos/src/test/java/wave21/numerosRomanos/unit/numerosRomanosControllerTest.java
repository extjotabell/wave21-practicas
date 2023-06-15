package wave21.numerosRomanos.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import wave21.numerosRomanos.numerosRomanosController.numerosRomanosController;

@ExtendWith(MockitoExtension.class)

public class numerosRomanosControllerTest {
    @Mock
    numerosRomanosController controller;

    @Test
    @DisplayName("decimalToRoman 1 Unit Test")
    void decimalToRomanTest1(){
        Integer number = 1;
        String expected = "I";

        Mockito.when(controller.decimalToRoman(number))
                .thenReturn(expected);

        String response = controller.decimalToRoman(number);

        Assertions.assertEquals(response,expected);
    }

    @Test
    @DisplayName("decimalToRoman 3 Unit Test")
    void decimalToRomanTest3(){
        Integer number = 3;
        String expected = "III";

        Mockito.when(controller.decimalToRoman(number))
                .thenReturn(expected);

        String response = controller.decimalToRoman(number);

        Assertions.assertEquals(response,expected);
    }

    @Test
    @DisplayName("decimalToRoman 5 Unit Test")
    void decimalToRomanTest5(){
        Integer number = 5;
        String expected = "V";

        Mockito.when(controller.decimalToRoman(number))
                .thenReturn(expected);

        String response = controller.decimalToRoman(number);

        Assertions.assertEquals(response,expected);
    }

    @Test
    @DisplayName("decimalToRoman 7 Unit Test")
    void decimalToRomanTest7(){
        Integer number = 7;
        String expected = "VII";

        Mockito.when(controller.decimalToRoman(number))
                .thenReturn(expected);

        String response = controller.decimalToRoman(number);

        Assertions.assertEquals(response,expected);
    }

    @Test
    @DisplayName("decimalToRoman 10 Unit Test")
    void decimalToRomanTest10(){
        Integer number = 10;
        String expected = "X";

        Mockito.when(controller.decimalToRoman(number))
                .thenReturn(expected);

        String response = controller.decimalToRoman(number);

        Assertions.assertEquals(response,expected);
    }

    @Test
    @DisplayName("decimalToRoman 50 Unit Test")
    void decimalToRomanTest50(){
        Integer number = 50;
        String expected = "L";

        Mockito.when(controller.decimalToRoman(number))
                .thenReturn(expected);

        String response = controller.decimalToRoman(number);

        Assertions.assertEquals(response,expected);
    }
}
