
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){}

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

    //Pre: el peso esta en kg y la altura en mts
    //Post: retorna -1 si da menos que 20, 0 si da entre 20 y 25 o 1 si es mayor a 25
    public int calcularIMC(){
        double imc = peso/Math.pow(altura, 2);
        int imc_id = -1;
        if(imc >= 20 && imc <= 25){
            imc_id = 0;
        }else if (imc > 25){
            imc_id = 1;
        }
        return imc_id;
    }

    public boolean esMayorDeEdad(){
        boolean esMayor = false;
        if(edad >= 18){
            esMayor = true;
        }
        return esMayor;
    }

    @Override
    public String toString() {
        return "Hola soy " + nombre  +
                " tengo " + edad  +
                " años y mi DNI es " + dni +
                ". Mi peso actual es de " + peso +
                "kg y mido " + altura + "m.";
    }
}