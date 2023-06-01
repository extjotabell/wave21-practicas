package com.example.consesionariadeautos.service.sequence;

public class CarSequence {
    private static int value = 1;

    public static int getNextValue(){
        return value++;
    }
}
