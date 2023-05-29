package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
  private Map<Integer, List<Prenda>> directorio = new HashMap<>();
  private Integer identificador = 0;

  public Integer guardarPrendas(List<Prenda> prendas) {
    directorio.put(this.identificador, prendas);
    return this.identificador++;
  }

  public void mostrarPrendas() {
    this.directorio
      .keySet()
      .forEach(k -> System.out.printf("Prenda %s: %s", k, this.directorio.get(k)));
  }

  public List<Prenda> devolverPrenda(Integer id) {
    return this.directorio.get(id);
  }
}
