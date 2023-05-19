package org.circuitos.medio;

import org.circuitos.Circuito;
import org.circuitos.Habilita;
import org.example.Participante;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CircuitoMedio extends Circuito {
  List<Habilita> habilitados = Arrays.asList(Habilita.MAYOR, Habilita.MENOR);

  public CircuitoMedio(int id, String nombre, String descripcion) {
    super(id, nombre, descripcion);
  }

  @Override
  public Map<Habilita, Float> monto() {
    return Map.ofEntries(
      Map.entry(Habilita.MENOR, 2000f),
      Map.entry(Habilita.MAYOR, 2300f)
    );
  }

  /**
   * Determina el monto a pagar por participante. Si no tiene un monto definido retorna 0f
   * @param p Participante
   * @return
   */
  public float habilita(Participante p) {
    if(p.esMenor() && this.habilitados.contains(Habilita.MENOR))
      return this.monto().get(Habilita.MENOR);
    else if(p.esMayor() && this.habilitados.contains(Habilita.MAYOR))
      return this.monto().get(Habilita.MAYOR);
    return 0f;
  }
}
