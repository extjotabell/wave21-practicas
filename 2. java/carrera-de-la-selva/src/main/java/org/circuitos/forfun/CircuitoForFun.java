package org.circuitos.forfun;

import org.circuitos.Circuito;
import org.circuitos.Habilita;
import org.example.Participante;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CircuitoForFun extends Circuito {
  List<Habilita> habilitados = Arrays.asList(Habilita.GRUPOA);
  public CircuitoForFun(int id, String nombre, String descripcion) {
    super(id, nombre, descripcion);
  }

  @Override
  public float habilita(Participante p) {
    if(p.getGrupoSanguineo() == "A+")
      return this.monto().get(Habilita.GRUPOA);
    return 0f;
  }

  @Override
  public Map<Habilita, Float> monto() {
    return Map.ofEntries(
      Map.entry(Habilita.GRUPOA, 5000f)
    );
  }
}
