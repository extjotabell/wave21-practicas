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
        double IMC = (this.peso /(this.altura* this.altura));
        if(IMC <20)
            return -1;

        if(IMC > 25)
            return 1;

        return 0;
    }

    public boolean esMayorDeEdad(){
        if(this.edad<18) return false;
        else return true;
    }

}
