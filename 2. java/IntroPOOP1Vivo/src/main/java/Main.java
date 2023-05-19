public class Main {
    public static void main(String[] args) {
        //Objetos por cada uno de los constructores definidos
        Persona conPersona1 = new Persona();
        Persona conPersona2 = new Persona("Camilo",24,"123456D");
        Persona conPersona3 = new Persona("Marcos",40,"D344566",67,1.78);

        //Objeto pasando solamente el valor de nombre y otro Objeto pasando solamente edad
        //¿Es esto posible? --> No es posible ya que los constructores definidos no estan solo con nombre o edad
        //¿Qué sucede si tratamos de hacer esto? --> Esto genera error

        //Persona conPersonaNom = new Persona("Prueba Nom");
        //Persona ConPersonaEdad = new Persona(23);

        double imc = conPersona3.calcularIMC();
        System.out.println("El resultado del calculo IMC de la Persona es: "+conPersona3.calcularIMC());
        boolean esMayorDeEdad = conPersona3.esMayorDeEdad();

        if (esMayorDeEdad){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        if (imc == -1){
            System.out.println("Bajo Peso");
        }else if (imc == 0){
            System.out.println("Peso Saludable");
        }else {
            System.out.println("Sobrepeso");
        }
    }
}
