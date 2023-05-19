public class Persona {

    public String nombre;
    public int edad;
    public String dni;
    public int peso;
    public int altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        int IMC = (this.peso / (this.altura*this.altura));
        if(IMC < 20){
            System.out.println("Bajo peso");
            return -1;
        } else if (20 <= IMC && IMC <= 25) {
            System.out.println("Peso saludable");
            return 0;
        }else{
            System.out.println("sobrepeso");
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
