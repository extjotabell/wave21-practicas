package com.ejercicio1.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {
    @GetMapping("/{number}")
    public String toRomanNumber(@PathVariable(value = "number") Integer number){
        StringBuilder str= new StringBuilder();
        if(number<=0){
            str.append("Ingrese un numero mayor a 0!");
        }else{
            while(number>0){
                if(number>=1000) {
                    str.append("M");
                    number -= 1000;
                } else if (number>=900) {
                    str.append("CM");
                    number-=900;
                } else if(number >=500) {
                    str.append("D");
                    number -= 500;
                } else if (number>=400) {
                    str.append("CD");
                    number-=400;
                }else if(number>=100) {
                    str.append("C");
                    number -= 100;
                } else if (number>=90) {
                    str.append("XC");
                    number-=90;
                }else if(number>=50) {
                    str.append("L");
                    number -= 50;
                } else if (number>=40) {
                    str.append("XL");
                    number-=40;
                } else if(number>=10){
                    str.append("X");
                    number-=10;
                }else if(number==9){
                    str.append("IX");
                    number-=9;
                }else if(number==8){
                    str.append("VIII");
                    number-=8;
                }else if(number==7){
                    str.append("VII");
                    number-=7;
                }else if(number==6){
                    str.append("VI");
                    number-=6;
                } else if (number==5) {
                    str.append("V");
                    number-=5;
                }else if(number==4){
                    str.append("IV");
                    number-=4;
                } else if (number==3) {
                    str.append("III");
                    number-=3;
                } else if (number==2) {
                    str.append("II");
                    number-=2;
                } else if (number==1) {
                    str.append("I");
                    number-=1;
                }
            }
        }
        return str.toString();
    }
}
