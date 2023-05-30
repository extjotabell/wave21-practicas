package com.ejercicio1Spring.NumerosRomanos;

public class Model {
    public String convertirARomano(int numero) {
        String numeroRomano = "";
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 ,5, 4, 1};
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < decimal.length; i++){
            while(numero >= decimal[i]){
                numeroRomano += romanos[i];
                numero -= decimal[i];
            }
        }
        return numeroRomano;
    }
}
