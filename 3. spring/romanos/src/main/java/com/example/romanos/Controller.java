package com.example.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/numeros")
public class Controller {

    @GetMapping("{number}")
    public String getRomanos(@PathVariable Integer number){

        String romano ="";
        HashMap<Integer,String> romanos = generarRomanos();
        int temporal;
        while(number != 0){

            if(number >= 1000){

                temporal = (number / 1000) * 1000;
                romano += romanos.get(temporal);
                number -= temporal;
            }else{
                if(number >=100){
                    temporal = (number/100) * 100;
                    romano += romanos.get(temporal);
                    number -= temporal;
                }else{
                    if(number >= 10){
                        temporal = (number /10 )*10;
                        romano += romanos.get(temporal);
                        number -= temporal;
                    }else{
                        romano += romanos.get(number);
                        number = 0;
                    }
                }

            }



        }


        return romano;
    }

    private HashMap<Integer, String> generarRomanos(){
        HashMap<Integer, String> romanos = new HashMap<>();
        romanos.put(1,"I");
        romanos.put(2,"II");
        romanos.put(3,"III");
        romanos.put(4,"IV");
        romanos.put(5,"V");
        romanos.put(6,"VI");
        romanos.put(7,"VII");
        romanos.put(8,"VIII");
        romanos.put(9,"IX");
        romanos.put(10,"X");
        romanos.put(20,"XX");
        romanos.put(30,"XXX");
        romanos.put(40,"XL");
        romanos.put(50,"L");
        romanos.put(60,"LX");
        romanos.put(70,"LXX");
        romanos.put(80,"LXXX");
        romanos.put(90,"XC");
        romanos.put(100,"C");
        romanos.put(200,"CC");
        romanos.put(300,"CCC");
        romanos.put(400,"CD");
        romanos.put(500,"D");
        romanos.put(600,"DC");
        romanos.put(700,"DCC");
        romanos.put(800,"DCCC");
        romanos.put(900,"CM");
        romanos.put(1000,"M");
        romanos.put(2000,"MM");
        romanos.put(3000,"MMM");





        return romanos;


    }
}
