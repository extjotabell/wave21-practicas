package com.blog.blog.exception;


// F nombre de la excepcion
public class EntradaBlogExisteException extends RuntimeException{
    public EntradaBlogExisteException(String mensaje){
        super(mensaje);
    }
}
