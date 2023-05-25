public class forDoubles extends Prototype<Double>{

    public forDoubles(Double increment) {
        super(increment);
    }

    public forDoubles() {
    }

    @Override
    public Double sum(Double x, Double y) {
        return x + y;
    }
}
