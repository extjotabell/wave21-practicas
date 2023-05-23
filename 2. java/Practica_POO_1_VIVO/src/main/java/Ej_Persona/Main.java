package Ej_Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona_constructor_1 = new Persona();
        Persona persona_constructor_2 = new Persona("Nombre de la Persona", 30, "DNI de la persona");
        Persona persona_constructor_3 = new Persona("Nombre de la Persona", 30, "DNI de la persona", 60.0, 1.65);
        //Persona persona_constructor_4 = new Persona("Nombre de la Persona", 35); No permite ya que ninguno de los constructores admite solo dos parámetros

        int imc = persona_constructor_3.calcularIMC(persona_constructor_3.getAltura(), persona_constructor_3.getPeso());
        boolean esMayor = persona_constructor_3.esMayorDeEdad(persona_constructor_3.getEdad());
        String mensajeIMC = "";
        String mensajeEsMayor;

        switch (imc) {
            case -1:
                mensajeIMC = "Bajo Peso";
                break;
            case 0:
                mensajeIMC = "Peso saludable";
                break;
            case 1:
                mensajeIMC = "Sobre peso";
                break;
        }

        if(esMayor) {
            mensajeEsMayor = "Mayor de edad";
        } else {
            mensajeEsMayor = "Menor de edad";
        }

        System.out.println(persona_constructor_3.toString() + "\n Su índice de masa corporal indica: " + mensajeIMC + "\n Su edad indica que es: " + mensajeEsMayor);
    }
}

