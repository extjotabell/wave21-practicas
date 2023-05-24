package EjercicioClasesAbstractas;

public class ParaInts extends Prototipo<Integer> {
    Integer currentInSeries;
    @Override
    public void next(){

    }

    @Override
    public void reset(){

    }

    @Override
    public void initialize(Integer num){
        this.currentInSeries = num;
    }
}
