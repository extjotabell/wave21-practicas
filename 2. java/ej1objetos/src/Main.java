public class Main {
    public static void main(String[] args) {
        Persona persona= new Persona();
        Persona juan= new Persona("Juan","34343223","20");
        Persona roberto= new Persona("Roberto","43243242","18",70d,1.68d);

        System.out.println("Calculo de IMC: si es -1 está por debajo del peso, si es 0 tiene un peso normal y si es 1 está en sobrepeso: \n"+roberto.calcularImc());
        System.out.println("¿Roberto es mayor de edad?, "+String.valueOf(roberto.esMayorDeEdad()).replace("true","Si").replace("false","No"));
        System.out.println(roberto.toString());
    }
}