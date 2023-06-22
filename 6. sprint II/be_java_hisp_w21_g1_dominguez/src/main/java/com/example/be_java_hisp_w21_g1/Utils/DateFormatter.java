package com.example.be_java_hisp_w21_g1.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static LocalDate stringToLocalDate(String date){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date,formatters);
    }

    public static String revertLocalDate(String date){
        String [] dateParts = date.split("-");
        return (dateParts[2]+"-"+dateParts[1]+"-"+dateParts[0]);
    }
}
