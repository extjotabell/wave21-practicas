package com.roman.numerals.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParserService {
    private Map<Integer, String> values = new HashMap<>();
    private final int max = 3999;

    public ParserService(){
        this.values.put(1, "I");
        this.values.put(5, "V");
        this.values.put(10, "X");
        this.values.put(50, "L");
        this.values.put(100, "C");
        this.values.put(500, "D");
        this.values.put(1000, "M");
    }

    public String parse(int number){
        if(number > this.max) return "Invalid number";

        int thousands   =number / 1000;
        int hundreds    = (number - (thousands * 1000))/100;
        int tens        = (number - (thousands * 1000 + hundreds * 100)) / 10;
        int units       = number - (thousands * 1000 + hundreds * 100 + tens * 10);

        return new StringBuilder(this.process(thousands, 1000, 0, 0))
                .append(this.process(hundreds, 100, 500, 1000))
                .append(this.process(tens, 10, 50, 100))
                .append(this.process(units, 1, 5, 10))
                .toString();
    }

    private String process(int number, Integer value1, Integer value2, Integer value3){
        String romanNumeral1 = values.get(value1);
        String romanNumeral2 = values.get(value2);
        String romanNumeral3 = values.get(value3);

        switch (number){
            case 0:
                return StringUtils.EMPTY;
            case 1:
                return romanNumeral1;
            case 2:
                return romanNumeral1 + romanNumeral1;
            case 3:
                return romanNumeral1 + romanNumeral1 + romanNumeral1;
            case 4:
                return romanNumeral1 + romanNumeral2;
            case 5:
                return romanNumeral2;
            case 6:
                return romanNumeral2 + romanNumeral1;
            case 7:
                return romanNumeral2 + romanNumeral1 + romanNumeral1;
            case 8:
                return romanNumeral2 + romanNumeral1 + romanNumeral1 + romanNumeral1;
            case 9:
                return romanNumeral1 + romanNumeral3;
            default:
                throw new IllegalArgumentException("Invalid iteration");
        }
    }
}
