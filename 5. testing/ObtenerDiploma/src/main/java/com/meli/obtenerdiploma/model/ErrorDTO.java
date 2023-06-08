package com.meli.obtenerdiploma.model;

import lombok.*;

import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ErrorDTO {

        String explanation;
        List<String> messages;

}
