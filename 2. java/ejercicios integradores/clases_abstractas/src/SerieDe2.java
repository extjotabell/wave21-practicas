public class SerieDe2 extends Prototipo{

    public SerieDe2(Number value) {
        super(value);
    }

    @Override
    public Number nextValue() {
        super.setActualValue(super.getValue().floatValue()+2);
        return super.getValue();
    }
}
