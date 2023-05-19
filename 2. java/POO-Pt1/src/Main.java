import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Demian", 27,39114071);
        Persona p3 = new Persona("Belen", 25, 33801739, 1.7,72.4);
        int option = 0;
        Scanner keyboar = new Scanner(System.in);

        do{
            System.out.println("SELECCIONE UNA OPCION:");
            System.out.println("1: Calcular IMC");
            System.out.println("2: Verificar edad");
            System.out.println("3: Mostrar informacion de la persona ingresada");
            System.out.println("4: Salir");
            option = keyboar.nextInt();
        switch (option){
            case 1: {
                int imc = p3.calcularIMC();
                if(imc == -1){
                    System.out.println("Bajo Peso");
                }
                else if(imc == 0){
                    System.out.println("Peso Saludable");
                }
                else
                    System.out.println("Sobrepeso");
            }break;
            case 2: {
                if(p3.esMayorDeEdad())
                    System.out.println("La persona ingresada es mayor de edad.");
                else
                    System.out.println("La persona ingresada es menor de edad");
            }break;
            case 3 : {
                System.out.println(p3.toString());
            }break;
        }
        }while(option != 4);




    }
}