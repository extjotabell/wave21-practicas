package org.circuitos;

import org.example.Participante;

public interface Habilitable {


  /**
   * Determina el monto a pagar por participante. Si no tiene un monto definido retorna 0f
   * @param p Participante
   * @return
   */
  float habilita(Participante p);
}
