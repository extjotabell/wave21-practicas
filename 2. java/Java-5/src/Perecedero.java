public class Perecedero extends Producto{
    private int daysBeforeExpire;

    public Perecedero(String name, double price, int daysBeforeExpire) {
        super(name, price);
        this.daysBeforeExpire = daysBeforeExpire;
    }

    public int getDaysBeforeExpire() {
        return daysBeforeExpire;
    }

    public void setDaysBeforeExpire(int daysBeforeExpire) {
        this.daysBeforeExpire = daysBeforeExpire;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(super.toString()).append("\n")
                .append("Cantidad antes de caducar: ").append(this.daysBeforeExpire)
                .toString();
    }

    @Override
    public double calculate(int quantity){
        return daysBeforeExpire == 1 ?  super.calculate(quantity)/4 : daysBeforeExpire == 2 ? super.calculate(quantity)/3 : daysBeforeExpire == 3 ? super.calculate(quantity)/2 : super.calculate(quantity);
    }
}
