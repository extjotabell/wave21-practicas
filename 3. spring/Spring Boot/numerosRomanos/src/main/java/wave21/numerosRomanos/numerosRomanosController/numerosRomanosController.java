package wave21.numerosRomanos.numerosRomanosController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class numerosRomanosController {
    @GetMapping("/numerosRomanos/{decimal}")
    public String decimalToRoman(@PathVariable Integer decimal){
        if(decimal > 0 && decimal < 3999){
            String roman = "";
            String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] numerosDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            for (int i = 0; i < numerosDecimales.length; i++){
                while (decimal >= numerosDecimales[i]) {
                    roman += numerosRomanos[i];
                    decimal -= numerosDecimales[i];
                }
            }
            return roman;
        }else{
            return "Ingrese un numero entre 1 y 3999";
        }

    }
}
