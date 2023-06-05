package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/{decimalNumber}")
    public String getRomanNumeral(@PathVariable int decimalNumber) {
        int centena, decena, unidad,miles;
        String romanNumber = "";

        unidad=decimalNumber%10;
        decena=(decimalNumber%100-decimalNumber%10)/10;
        centena=(decimalNumber%1000-decimalNumber%100)/100;
        miles =(decimalNumber%10000-decimalNumber%1000)/1000;

        if(miles >= 4){
            romanNumber = "No es posible calcular el numero";
        }else{
            //Calcular miles
            for(int i = 0; i<miles;i++){
                romanNumber+="M";
            }
            //Calcular centena
            romanNumber += calculateUnits(centena,"C","D","M");

            //Calcular decena
            romanNumber += calculateUnits(decena,"X","L","C");

            //Calcular unidades
            romanNumber += calculateUnits(unidad,"I","V","X");
        }

        return romanNumber;
    }

    private String calculateUnits(int number, String unit, String nextUnit, String lastUnit){
        String result = "";
        if(number<=3){
            for(int i = 0; i<number;i++){
                result+=unit;
            }
        } else if (number==4) {
            result = unit + nextUnit;
        } else if (number>=5 && number <=8) {
            result=nextUnit;
            for(int i = 0; i<(number-5);i++){
                result+=unit;
            }
        }else{
            result = unit + lastUnit;
        }
        return result;
    }

}
