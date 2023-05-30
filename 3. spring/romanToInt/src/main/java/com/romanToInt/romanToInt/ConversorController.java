package com.romanToInt.romanToInt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
public class ConversorController {


    @GetMapping("/{romano}")
    public String convertirARomano(@PathVariable String romano){

       return "ROMANO: " + romano + "---->" + "DECIMAL: " + romanoADecimal(romano);
    }

    //La logica es que que siempre que se tenga un numero mas chico por detras, entonces hay que restar
    public int romanoADecimal(String numRomano) {
        int ret = 0;
        HashMap<Character, Integer> transformacion = new HashMap<>();
        transformacion.put('I', 1);
        transformacion.put('V', 5);
        transformacion.put('X', 10);
        transformacion.put('L', 50);
        transformacion.put('C', 100);
        transformacion.put('D', 500);
        transformacion.put('M', 1000);

        for (int i = 0; i < numRomano.length(); i++) {
            if (i < numRomano.length() - 1 && transformacion.get(numRomano.charAt(i)) < transformacion.get(numRomano.charAt(i + 1))) {
                //si el numero i es menor al numero i + 1 -> hay que restar
                ret -= transformacion.get(numRomano.charAt(i));
            } else {
                ret += transformacion.get(numRomano.charAt(i));
            }
        }

        return ret;

}
}
