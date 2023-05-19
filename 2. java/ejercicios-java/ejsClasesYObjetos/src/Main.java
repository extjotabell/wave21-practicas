public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Javier", 24, "345345");
        Persona persona3 = new Persona("Diego", 23, "123345", 79, 168);
        Persona persona4 = new Persona();

        int indiceP3 = persona3.calcularIMC();
        boolean mayoria = persona3.esMayorDeEdad();
        String datos = persona3.toString();

        switch(indiceP3){
            case -1:
                System.out.println("Peso bajo");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        if(mayoria){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }

        System.out.println(datos);
    }
}