// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaConAlgunosParametros = new Persona("Luz Deniz", 22, "12345678");
        Persona personaConTodosLosParametros = new Persona("Luz Deniz", 22, "12345678",70,1.68);

        //Persona personaCon2Parametros = new Persona("Luz Deniz",22);
        // No es posible crear una instancia de Persona con esos parametros dado que no existe un constructor con ese formato.
        //Arroja el error Cannot resolve constructor 'Persona(String, int)'


        String infoPersonaConParametros = personaConTodosLosParametros.infoToString();
        System.out.println(infoPersonaConParametros);

        int imcPersonaConParametros = personaConTodosLosParametros.calcularIMC();

        switch (imcPersonaConParametros){
            case -1:
                System.out.println("Tiene bajo peso");
                break;
            case 0:
                System.out.println("Tiene un peso saludable");
                break;
             default:
                 System.out.println("Tiene sobrepeso");
                break;
        }

        boolean esMayorPersonaConParametros = personaConTodosLosParametros.esMayorDeEdad();

        if(esMayorPersonaConParametros){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }
}
