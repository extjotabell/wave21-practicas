package org.example;

import java.util.List;

public class Garaje {

  private Integer id;

  private List<Vehiculo> vehiculos;

  public Garaje(int id,List<Vehiculo> vehiculos){
    this.id=id;
    this.vehiculos = vehiculos;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }


}
