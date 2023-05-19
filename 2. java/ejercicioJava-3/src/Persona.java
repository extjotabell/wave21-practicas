public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


    public Persona() {

    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC() {

        double total = this.peso / (this.altura * this.altura);

        if (total < 20) {
            return -1;
        } else if (total >= 20 && total <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorEdad() {
        if (this.edad >= 18) {
            return true;
        } else {
            return false;
        }

    }

    public void tostring() {
        System.out.println("nombre: " + this.nombre);
        System.out.println("edad: " + this.edad);
        System.out.println("dni: " + this.dni);
        System.out.println("peso: " + this.peso);
        System.out.println("altura: " + this.altura);
        System.out.println("IMC: " + this.calcularIMC() + "\n");
    }
    public String messageIMC(){
        String message = "";
        if(this.calcularIMC() < 20){
            message = "Bajo peso";
        }else if (this.calcularIMC() >= 20 && this.calcularIMC() <= 25) {
            message = "Peso saludable";
        }else {
            message = "Sobrepeso";
        }
        return message;
    }
}
