public class Persona {
    // Atributos
    String nombre;
    int edad;
    String dni;
    double altura;
    double peso;
    public Persona(){}
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    // Metodos Publicos

    // Ejercicio 5
    public int calcularIMC(){
        int retorno;
        double valorIMC = (peso/Math.pow(altura,2));

        if (valorIMC < 20){
            retorno = -1;
        } else if (valorIMC > 25) {
            retorno =  1;
        }
        else {
            retorno = 0;
        }

        return retorno;
    }

    public boolean esMayorDeEdad(){
        return edad > 18 ? true : false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
