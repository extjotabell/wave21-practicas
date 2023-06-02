package com.mercadolibre.redireclinks.exception;

public class LinkInvalidException extends RuntimeException{
    public LinkInvalidException(String mesage) {
        super (mesage);
    }
}
