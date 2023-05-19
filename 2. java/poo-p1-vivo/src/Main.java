public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jose",23,"1234567");
        Persona persona3 = new Persona("Jose",23,"1234567",80,1.80);
        // Error necesitamos construir el constructor con ambos atributos
        //Persona persona4 = new Persona("Jose",23);

        int imc = persona3.calcularIMC();
        boolean edad = persona3.esMayorDeEdad();
        //System.out.println(persona3.calcularIMC());
        //System.out.println(persona3.esMayorDeEdad());
        //System.out.println(persona3.toString());

        if(imc == -1){
            System.out.println("La persona tien bajo peso");
        } else if (imc == 0) {
            System.out.println("La persona tiene peso saludable");
        }else {
            System.out.println("La persona tiene peso sobrepeso");
        }
        if(edad){
            System.out.println("La persona es mayor de edad");
        }else {
            System.out.println("La persona no es mayor de edad");
        }

        System.out.println("Datos de la persona:");
        System.out.println(persona3.toString());

    }
}