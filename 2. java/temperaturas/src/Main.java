public class Main {
    public static void main(String[] args) {

        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int menor=temperaturas[0][0],mayor=0,posMenor=0,posMayor=0;
        for(int i=0;i<temperaturas.length;i++){
            if (temperaturas[i][1]>mayor) {
                posMayor=i;
                mayor = temperaturas[i][1];
            }
            if (temperaturas[i][0]<menor) {
                posMenor=i;
                menor = temperaturas[i][0];
            }
        }
        System.out.println("La menor temperatura se encuentra en la ciudad de "+ciudades[posMenor]+" con "+temperaturas[posMenor][0]);
        System.out.println("La mayor temperatura se encuentra en la ciudad de "+ciudades[posMayor]+" con "+temperaturas[posMayor][1]);

    }
}