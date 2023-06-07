package Interfaces;

import Clases.Cliente;
import Clases.Localizador;

public interface CalculadorDescuento {
    double calcularDescuento(Cliente cliente, Localizador localizador);
}
