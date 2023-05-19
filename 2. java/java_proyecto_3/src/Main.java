public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaComun = new Persona("Juan", 22, "123456789");
        Persona personaFull =  new Persona("Juan", 22, "123456789", 72, 177);

//        Persona personaError = new Persona("Juan", 22);

        int imc = personaFull.calcularIMC();
        if (imc == -1){
            System.out.println("Bajo peso");
        }
        if (imc == 0){
            System.out.println("Peso saludable");
        }
        if (imc == 1){
            System.out.println("Sobrepeso");
        }

        boolean mayoriaEdad = personaFull.esMayorDeEdad();
        if(mayoriaEdad){
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        System.out.println(personaFull.toString());
    }
}