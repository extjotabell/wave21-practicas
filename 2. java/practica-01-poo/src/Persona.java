public class Persona {
    String nombre;
    int edad;
    String dni;
    int peso;
    Double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        Double valorImc= this.peso / (Math.pow(this.altura,2));
        int estadoIMC = 1;
        if(valorImc < 20){
            estadoIMC = -1;
        }else if(valorImc>=20 && valorImc<=25){
            estadoIMC = 0;
        }
        return estadoIMC;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
    public String infoToString(){
        String infoPersona= this.nombre + " tiene " + this.edad + " años. El dni es " + this.dni + ", pesa " + this.peso + "kg y mide "+ this.altura+ "m";
        return  infoPersona;
    }


}
