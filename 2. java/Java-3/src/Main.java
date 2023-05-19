public class Main {
    public static void main(String[] args) {
        Person juan = new Person();
        Person pepe = new Person("Pepe", 23, "5.064.861.4");
        Person carlos = new Person("Carlos", 24, "5.064.861.4", 85.5, 174);

        System.out.println(carlos);
        if(carlos.esMayorDeEdad()) System.out.println("Es mayor de edad.");

        switch (carlos.cacularIMC()){
            case -1:
                System.out.println("Indice de masa corporal (IMC): Bajo peso");
                break;
            case 0:
                System.out.println("Indice de masa corporal (IMC): Peso saludable");
                break;
            case 1:
                System.out.println("Indice de masa corporal (IMC): Sobrepeso");
                break;
            default:
                System.out.println("Error al calcular el indice de masa corporal (IMC)");
                break;
        }
    }
}