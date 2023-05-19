public class NoPerecedero extends Producto{
    private String type;

    public NoPerecedero(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(super.toString()).append("\n")
                .append("Tipo: ").append(this.type)
                .toString();
    }
}
