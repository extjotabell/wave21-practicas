package com.bootcamp.autos.exception;

import com.bootcamp.autos.dto.SiniestroDTO;

public class SiniestroNotFoundException extends RuntimeException{

    public SiniestroNotFoundException(String message){super(message);}
}
