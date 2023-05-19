public class Main {
    public static void main(String[] args) {


        Persona persona_full = new Persona("Juan", 20, "12345678A", 70, 1.80);

        Persona persona_vacia = new Persona();

        Persona persona_minima = new Persona("Juan", 20, "12345678A");

//        ERROR: java: no suitable constructor found for Persona
        Persona persona_prueba = new Persona("juan", 30);



        double imc = persona_full.calcularIMC();

        boolean es_mayor_de_edad = persona_full.esMayorDeEdad();

        if (es_mayor_de_edad){
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        if (imc < 20){
            System.out.println("Bajo peso");
        }
        else if (imc >= 20 && imc <= 25){
            System.out.println("Peso saludable");
        }
        else {
            System.out.println("Sobrepeso");
        }


    }
}
