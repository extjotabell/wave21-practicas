import javax.imageio.stream.FileImageInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        //Practica 4
        Persona persona_sin_atributos = new Persona();
        Persona persona_algunos_atributos = new Persona("Claudia", 60, "20456834");
        Persona persona = new Persona("Marcelo", 18, "30452349", 88, 1.67);


        //Practica 5
        System.out.println(persona.toString());

        //Practica 6
        if(persona.esMayorDeEdad()){
            System.out.print("Es Mayor de edad ");
        }else{
            System.out.print("No es Mayor de edad ");
        }
        mostrar_imc(persona.calcularIMC());
    }

    //Pre: IMC es -1, 0 o 1
    //Post: indica si esta en bajo peso (-1), peso saludable (0) o sobrepeso (1)
    private static void mostrar_imc(double imc) {
        if (imc == -1){
            System.out.print("Bajo de Peso");

        }else if (imc == 0){
            System.out.print("Saludable");

        }else{
            System.out.print("Sobrepeso");
        }
    }
}