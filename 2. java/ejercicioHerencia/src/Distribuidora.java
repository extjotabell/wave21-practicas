public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos= {
                new Perecedero("Manteca",1300d,4),
                new Perecedero("Huevos",4500d,3),
                new Perecedero("Leche",2333d,35),
                new Perecedero("Jamon",234d,1),
                new Perecedero("Queso",123d,2),
                new NoPerecedero("PC",40000d,"Informática"),
                new NoPerecedero("Notebook",24343d,"Informática"),
                new NoPerecedero("Heladera",221312d,"Hogar"),
                new NoPerecedero("Cargador",2324d,"Informática"),
                new NoPerecedero("Lapiz",40d,"Utiles")};

        for (int i=0;i<productos.length;i++){
            double suma=0;
            System.out.println("Precio al vender 5 "+productos[i].getNombre()+" ="+productos[i].calcular(5));
        }
    }
}