// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Creación de personas
        Persona persona = new Persona();

        Persona persona2 = new Persona("Laura",15,"132456");

        Persona persona3 = new Persona("Caterin",27,"456789",58,1.70);
        //genera un error de compilación al intentar crear el objeto ya que el constructor no existía
        Persona persona4= new Persona("Nataly",25);

        //imprimir información de la persona
        System.out.println(persona3.toString());

        //Clasificar si es mayor o menor de edad
        if(persona3.esMayorDeEdad()) System.out.println("Es mayor de edad");
        else System.out.println("Es menor de edad");

        //Muestra el nivel de peso
        if(persona3.calcularIMC()== -1){
            System.out.println("El IMC indica que está baja(o) de peso");
        }else if(persona3.calcularIMC()== 0){
            System.out.println("El IMC indica que está con peso saludable");
        }else{
            System.out.println("El IMC indica que está alta(o) de peso");
        }


    }
}