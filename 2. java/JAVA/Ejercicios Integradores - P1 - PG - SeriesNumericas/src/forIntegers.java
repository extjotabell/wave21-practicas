public class forIntegers extends Prototype<Integer> {

    public forIntegers(Integer increment) {
        super(increment);
    }

    public forIntegers() {
    }

    @Override
    public Integer sum(Integer x, Integer y) {
        return x + y;
    }
}
