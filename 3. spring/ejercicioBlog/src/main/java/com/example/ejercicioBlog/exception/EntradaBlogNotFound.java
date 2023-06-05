package com.example.ejercicioBlog.exception;

public class EntradaBlogNotFound extends RuntimeException {
    public EntradaBlogNotFound(String mensaje) {
        super(mensaje);
    }
}
