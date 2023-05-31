package com.example.codigoMorse.codigoMorse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseCodeController {

    @GetMapping("/{code}")
    public ResponseEntity<String> convertToNormalText(@PathVariable String code) {
        String normalText = toNormalText(code);
        if (normalText.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código Morse inválido.");
        }
        return ResponseEntity.ok(normalText);
    }

    private String toNormalText(String code) {
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
        String[] normalTexts = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        StringBuilder normalText = new StringBuilder();
        String[] words = code.split("\\s{2}");
        for (String word : words) {
            String[] letters = word.split("\\s");
            for (String letter : letters) {
                int index = getIndex(morseCodes, letter);
                if (index != -1) {
                    normalText.append(normalTexts[index]);
                } else {
                    return "";
                }
            }
            normalText.append(" ");
        }
        return normalText.toString().trim();
    }

    private int getIndex(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
