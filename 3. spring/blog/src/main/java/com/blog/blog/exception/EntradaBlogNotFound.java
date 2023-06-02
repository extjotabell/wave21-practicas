package com.blog.blog.exception;



public class EntradaBlogNotFound extends RuntimeException {
    public EntradaBlogNotFound(String mensaje) {
        super(mensaje);
    }
}