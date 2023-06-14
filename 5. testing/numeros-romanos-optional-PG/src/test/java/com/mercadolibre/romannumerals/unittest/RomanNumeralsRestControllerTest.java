package com.mercadolibre.romannumerals.unittest;

import com.mercadolibre.romannumerals.controller.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsRestControllerTest {

    @InjectMocks
    RomanNumeralsRestController controller;

    @Test
    @DisplayName("Expecting roman number: I")
    public void romanNumberTestI() {
        // Arrange
        Integer arabicNumber = 1;
        String expectedNumber = "I";

        // Act
        String romanNumber = toRoman(arabicNumber);

        // Assert
        Assertions.assertEquals(romanNumber, expectedNumber);
    }

    @Test
    @DisplayName("Expecting roman number: III")
    public void romanNumberTestIII() {
        // Arrange
        Integer arabicNumber = 3;
        String expectedNumber = "III";

        // Act
        String romanNumber = toRoman(arabicNumber);

        // Assert
        Assertions.assertEquals(romanNumber, expectedNumber);
    }

    @Test
    @DisplayName("Expecting roman number: V")
    public void romanNumberTestV() {
        // Arrange
        Integer arabicNumber = 5;
        String expectedNumber = "V";

        // Act
        String romanNumber = toRoman(arabicNumber);

        // Assert
        Assertions.assertEquals(romanNumber, expectedNumber);
    }

    @Test
    @DisplayName("Expecting roman number: VII")
    public void romanNumberTestVII() {
        // Arrange
        Integer arabicNumber = 7;
        String expectedNumber = "VII";

        // Act
        String romanNumber = toRoman(arabicNumber);

        // Assert
        Assertions.assertEquals(romanNumber, expectedNumber);
    }

    @Test
    @DisplayName("Expecting roman number: X")
    public void romanNumberTestX() {
        // Arrange
        Integer arabicNumber = 10;
        String expectedNumber = "X";

        // Act
        String romanNumber = toRoman(arabicNumber);

        // Assert
        Assertions.assertEquals(romanNumber, expectedNumber);
    }

    @Test
    @DisplayName("Expecting roman number: L")
    public void romanNumberTestL() {
        // Arrange
        Integer arabicNumber = 50;
        String expectedNumber = "L";

        // Act
        String romanNumber = toRoman(arabicNumber);

        // Assert
        Assertions.assertEquals(romanNumber, expectedNumber);
    }

    @Test
    public void romanNumberTestNull() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            toRoman(null);
        });
    }

    private String toRoman(Integer arabicNumber){
        return controller.toRoman(arabicNumber);
    }
}