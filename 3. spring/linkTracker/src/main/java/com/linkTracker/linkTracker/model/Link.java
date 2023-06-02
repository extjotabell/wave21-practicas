package com.linkTracker.linkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Link {
    private String url;
    private int id;
    private int contadorRedireccion;
    private String contrasena;

    public Link(String url, int id, String contrasena) {
        this.url = url;
        this.id = id;
        this.contadorRedireccion = 0;
        this.contrasena = contrasena;
    }
}
