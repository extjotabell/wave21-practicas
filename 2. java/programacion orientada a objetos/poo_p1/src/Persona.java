public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;
    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public float calcularImc(){
        double imc = this.peso/(this.altura*this.altura);
        if (imc > 25) return 1;
        else if (imc < 20) return -1;
        else return 0;
    }

    public boolean esMayorDeEdad(){
        if (edad<18) return false;
        else return true;
    }

    @Override
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

