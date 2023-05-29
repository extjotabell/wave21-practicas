package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Carrera {

  private double distancia;
  private double premio;
  private String nombre;
  private int cupo;
  private List<Vehiculo> vehiculos = new ArrayList<>();
  private Socorrer<Moto> motoSocorro = new MotoSocorrista();
  private Socorrer<Auto> autoSocorro = new AutoSocorrista();

  /**
   *
   * @param distancia en kilometros
   * @param premio en dolares
   * @param nombre
   * @param cupo cantidad de participantes
   */
  public Carrera(double distancia, double premio, String nombre, int cupo) {
    this.distancia = distancia;
    this.premio = premio;
    this.nombre = nombre;
    this.cupo = cupo;
  }

  public void altaVehiculo(Vehiculo v) throws SinCupoException {
    if(this.vehiculos.size() == this.cupo)
      throw new SinCupoException("No hay cupo en la carrera. No se pudo inscribir al vehiculo "+v);

    vehiculos.add(v);
  }

  public void eliminarVehiculo(Vehiculo vehiculo) throws VehiculoNotFoundException {
    if(!vehiculos.remove(vehiculo))
      throw new VehiculoNotFoundException();
  }

  public void eliminarVehiculoPorPatente(String patente) throws VehiculoNotFoundException {
    Vehiculo vehiculo = this.vehiculos
      .stream()
      .filter(v -> v.getPatente().equals(patente))
      .findFirst().orElseThrow(VehiculoNotFoundException::new);

    this.eliminarVehiculo(vehiculo);
  }

  public Vehiculo ganador() throws NullPointerException, NoSuchElementException {
    Comparator<Vehiculo> c = Comparator.comparing(Vehiculo::calcularIndiceDeCarrera);

    return this.vehiculos
      .stream()
      .max(c)
      .orElseThrow(NoSuchElementException::new);
  }

  public void socorrerMoto(String patente) throws VehiculoNotFoundException {
    Moto vehiculo = this.vehiculos
      .stream()
      .filter(v -> v.getPatente().equals(patente))
      .filter(v -> v instanceof Moto)
      .findFirst()
      .map(v -> (Moto) v)
      .orElseThrow(VehiculoNotFoundException::new);

    this.eliminarVehiculo(vehiculo);

    this.motoSocorro.socorrer(vehiculo);
  }

  public void socorrerAuto(String patente) throws VehiculoNotFoundException {
    Auto vehiculo = this.vehiculos
      .stream()
      .filter(v -> v.getPatente().equals(patente))
      .filter(v -> v instanceof Auto)
      .findFirst()
      .map(v -> (Auto) v)
      .orElseThrow(VehiculoNotFoundException::new);

    this.eliminarVehiculo(vehiculo);

    this.autoSocorro.socorrer(vehiculo);
  }

  public void printVehiculos() {
    Comparator<Vehiculo> c = Comparator.comparing(Vehiculo::calcularIndiceDeCarrera);
    this.vehiculos.stream().sorted(c).forEach(Vehiculo::printStats);
  }
}
