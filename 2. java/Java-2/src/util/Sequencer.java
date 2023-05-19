package util;

//Secuenciador de int para el numero de inscripcion
public class Sequencer {
    private static int value = 1;

    public static int getNextValue(){
        return Sequencer.value++;
    }
}
