public class Main {
    public static void main(String[] args) {
        // Creacion Animales
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        
        // Metodos de que comen
        System.out.println("--- Animales Comen ---");
        System.out.println(perro.comerCarne());
        System.out.println(gato.comerCarne());
        System.out.println(vaca.comerHierba());

        // Metodo de sonido
        System.out.println("--- Animales hacen el ruido ---");
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        // Animal instancia de otro animal...
        System.out.println("--- Metodo comerAnimal ---");
        System.out.println(comerAnimal(gato));
        System.out.println(comerAnimal(perro));
        System.out.println(comerAnimal(vaca));



    }

    public static String comerAnimal(Animal animal){
        // Pregunto de que instancia es Animal para retornar que come cada animal

        if (animal instanceof Gato){
            return ((Gato) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            return ((Vaca) animal).comerHierba();
        } else if (animal instanceof Perro) {
            return ((Perro) animal).comerCarne();
        }
        // En caso de que no sea ninguna de esas instancias
        return "";
    }


}