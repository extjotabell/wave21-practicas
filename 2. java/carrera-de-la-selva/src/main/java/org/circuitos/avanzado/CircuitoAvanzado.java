package org.circuitos.avanzado;

import org.circuitos.Circuito;
import org.circuitos.Habilita;
import org.circuitos.Pagable;
import org.example.Participante;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CircuitoAvanzado extends Circuito {
  List<Habilita> habilitados = Arrays.asList(Habilita.MAYOR);

  public CircuitoAvanzado(int id, String nombre, String descripcion) {
    super(id, nombre, descripcion);
  }

  public Map<Habilita, Float> monto() {
    return Map.ofEntries(
      Map.entry(Habilita.MAYOR, 2800f)
    );
  }

  /**
   * Determina el monto a pagar por participante. Si no tiene un monto definido retorna 0f
   * @param p Participante
   * @return
   */
  @Override
  public float habilita(Participante p) {
    if(p.esMayor() && this.habilitados.contains(Habilita.MAYOR))
      return this.monto().get(Habilita.MAYOR);
    return 0f;
  }
}
