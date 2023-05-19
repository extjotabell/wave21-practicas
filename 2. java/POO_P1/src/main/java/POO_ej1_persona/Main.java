package POO_ej1_persona;

public class Main {
    public static void main(String[] args) {
        //Ej 4
        Persona persona_sin_atributos = new Persona();
        Persona persona_algunos_atributos = new Persona("Juan", 23, "42983382");
        Persona persona = new Persona("Jose", 18, "49939939", 50, 1.67);

        //Persona persona_error = new Persona("jose", 23); De usar esta linea va a lanzar error ya que no existe un constructor con estas caracteristicas

        //Ej 5
        System.out.println(persona.toString());

        //Ej6
        if(persona.esMayorDeEdad()){
            System.out.print("Soy mayor de edad ");
        }else{
            System.out.print("No soy mayor de edad ");
        }
        mostrar_imc(persona.calcularIMC());
    }

    //Pre: IMC es -1, 0 o 1
    //Post: indica si esta en bajo peso (-1), peso saludable (0) o sobrepeso (1)
    private static void mostrar_imc(double imc) {
        if (imc == -1){
            System.out.print("y segun mi IMC estoy bajo peso");

        }else if (imc == 0){
            System.out.print("y segun mi IMC estoy en un peso saludable");

        }else{
            System.out.print("y segun mi IMC estoy en sobrepeso");
        }
    }
}
