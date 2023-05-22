import java.util.ArrayList;

public class Distribuidora {
    private ArrayList<Producto> listado = new ArrayList() ;

    public ArrayList<Producto> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Producto> listado) {
        this.listado = listado;
    }

    public Distribuidora(){
        Producto p1 = new Perecedero("leche", 360, 3);
        Producto p2 = new Perecedero("pan", 279, 1);
        Producto p3 = new Perecedero("queso", 160, 3);
        Producto p4 = new Perecedero("mayonesa", 220, 3);
        Producto p5 = new Perecedero("carne", 300, 3);

        listado.add(p1);
        listado.add(p2);
        listado.add(p3);
        listado.add(p4);
        listado.add(p5);

        Producto d1 = new NoPerecedero("arroz", 500, "NoPerecedero");
        Producto d2 = new NoPerecedero("lenteja", 1500, "NoPerecedero");
        Producto d3 = new NoPerecedero("poroto", 5200, "NoPerecedero");
        Producto d4 = new NoPerecedero("choclo", 5600, "NoPerecedero");
        Producto d5 = new NoPerecedero("jardinera", 3500, "NoPerecedero");
        listado.add(d1);
        listado.add(d2);
        listado.add(d3);
        listado.add(d4);
        listado.add(d5);

    }
}
