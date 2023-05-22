// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Persona martin = new Persona();
        Persona martin2 = new Persona("martin", 12 , "3999991.");
        Persona martin3 = new Persona("martin3",12,"123123",80,1.83);

        if (martin3.esMayorDeEdad() == true)
            System.out.println("Es mayor de edad");
        else
            System.out.println("es menor de edad");

        
        int IMC = martin3.calcularIMC();
        switch (IMC) {
            case -1:
                System.out.println("bajo peso");
            break;
            case 0:
                System.out.println("peso normal");
            break;
            case 1:
                System.out.println("peso alto");
            break;
        }




    }
}