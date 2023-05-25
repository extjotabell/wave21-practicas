public abstract class Prototype <T>{
    protected T value;
    protected T increment;

    public Prototype(T increment) {
        this.value = increment;
        this.increment = increment;
    }

    public Prototype() {
    }

    public void next(){
        System.out.println(sum(value, increment).toString());
        this.value = sum(value, increment);
    }
    public void reset(){
        System.out.println("Serie reiniciada!\n");
        value = increment;
        System.out.println(value);
    }
    public void initialize(T obj){
        value = obj;
        System.out.println(value);
    }

    public abstract T sum(T x, T y);
}
