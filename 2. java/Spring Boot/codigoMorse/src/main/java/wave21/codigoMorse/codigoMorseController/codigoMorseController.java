package wave21.codigoMorse.codigoMorseController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class codigoMorseController {
    @GetMapping("/morseToString/{morse}")
    public String morseToString(@PathVariable String morse) {

        Map<String, String> morseCodeMap = new HashMap<String, String>() {
            {
                put(".-", "A");
                put("-...", "B");
                put("-.-.", "C");
                put("-..", "D");
                put(".", "E");
                put("..-.", "F");
                put("--.", "G");
                put("....", "H");
                put("..", "I");
                put(".---", "J");
                put("-.-", "K");
                put(".-..", "L");
                put("--", "M");
                put("-.", "N");
                put("---", "O");
                put(".--.", "P");
                put("--.-", "Q");
                put(".-.", "R");
                put("...", "S");
                put("-", "T");
                put("..-", "U");
                put("...-", "V");
                put(".--", "W");
                put("-..-", "X");
                put("-.--", "Y");
                put("--..", "Z");
                put("-----", "0");
                put(".----", "1");
                put("..---", "2");
                put("...--", "3");
                put("....-", "4");
                put(".....", "5");
                put("-....", "6");
                put("--...", "7");
                put("---..", "8");
                put("----.", "9");
                put(".-.-.-", ".");
                put("--..--", ",");
                put("..--..", "?");
                put(".----.", "'");
                put("-.-.--", "!");
            }
        };

        String aRetornar = "";

        //Se divide el string morse en sus palabras separadas por 3 espacion.
        String[] palabrasEnMorse = morse.split("   ");
        for(String palabraEnMorse : palabrasEnMorse){

            //Se divide el string palabraEnMorse en sus letras separadas por un espacio.
            String[] letras = palabraEnMorse.split(" ");

            //Por cada letra de cada palabra, se busca su value correspondiente.
            for(String letraEnMorse : letras){
                String texto = morseCodeMap.get(letraEnMorse);
                if(texto != null){
                    aRetornar += texto;
                }
            }

            aRetornar += " ";
        }

        return aRetornar;
    }
}
