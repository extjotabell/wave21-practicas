public class Persona {

    public String nombre;
    public int edad;
    public String dni;
    public int peso;
    public double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double IMC = (this.peso / Math.pow(this.altura,2));
        if(IMC < 20){
            return -1;
        } else if (20 <= IMC && IMC <= 25) {
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){

        return edad >= 18;
    }

    public String toString(){
        return "Nombre: " + this.nombre + ". Edad: " + this.edad + ". Dni: " + this.dni + ". Peso: " + this.peso + ". Altura: " + this.altura;
    }

}
