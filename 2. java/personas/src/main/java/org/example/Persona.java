package org.example;

public class Persona {
  private static final Integer LEGALIDAD = 18;
  String nombre;
  int edad;
  String dni;
  float peso;
  float altura;

  public Persona() { }
  public Persona(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public Persona(String nombre, int edad, String dni) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
  }

  /**
   * Instancia una persona con todos sus datos. Las unidades son kilogramos y metros respectivamente
   * @param nombre
   * @param edad
   * @param dni
   * @param peso en kilogramos
   * @param altura en metros
   */
  public Persona(String nombre, int edad, String dni, float peso, float altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    this.peso = peso;
    this.altura = altura;
  }

  public int calcularImc() {
    double imc = this.peso/Math.pow(this.altura, 2);
    if(imc < 20)
      return -1;
    if(imc >= 20 && imc <= 25)
      return 0;

    return 1;
  }

  public boolean esMayorDeEdad() {
    return this.edad >= Persona.LEGALIDAD;
  }

  @Override
  public String toString() {
    return "Nombre: "+this.nombre+"\nEdad:"+this.edad+"\nDni:"+this.dni+"\nPeso: "+this.peso+"\nAltura: "+this.altura;
  }
}
