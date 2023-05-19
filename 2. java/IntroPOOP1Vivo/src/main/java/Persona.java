public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){

        double calculoIMC;
        int resulIMC;

        //Calcular IMC
        calculoIMC = this.peso / (Math.pow(this.altura,2));

        if (calculoIMC < 20.0){
            resulIMC = -1;
        } else if (calculoIMC >= 20.0 && calculoIMC <=25.0) {
            resulIMC = 0;
        }else {
            resulIMC = 1;
        }

        return resulIMC;
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
