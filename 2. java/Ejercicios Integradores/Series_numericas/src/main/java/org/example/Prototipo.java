package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class Prototipo<T extends Number>{

    public T valorSemilla;
    public T valorPaso;
    public ArrayList<T> sucesion = new ArrayList<>();
    public abstract void valorSiguiente();

    public void reiniciarSucesion() {
        sucesion.clear();
        sucesion.add(valorSemilla);
    }

    public void establecerSemilla(T semilla) {
        valorSemilla = semilla;
    }

    public void establecerValorPaso(T paso) {
        valorPaso = paso;
    }

    public Prototipo(T valorSemilla, T valorPaso) {
        this.valorSemilla = valorSemilla;
        this.valorPaso = valorPaso;
        sucesion.add(valorSemilla);
    }

    public T getValorSemilla() {
        return valorSemilla;
    }

    public T getValorPaso() {
        return valorPaso;
    }

    public List<T> getSucesion() {
        return sucesion;
    }

    public void setSucesion(ArrayList<T> sucesion) {
        this.sucesion = sucesion;
    }
}
