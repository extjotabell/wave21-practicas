package com.example.be_java_hisp_w21_g02.dto;import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ErrL {
    private Date timestamp;
    private int status;
    private String path;
    private List<String> errors = new ArrayList<>();

    public void addError(String message) {
        this.errors.add(message);
    }
}
