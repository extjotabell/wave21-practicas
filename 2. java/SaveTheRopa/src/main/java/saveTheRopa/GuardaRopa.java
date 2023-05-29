package saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas = new HashMap<>();
    private int identificador;

    public Map<Integer, List<Prenda>> getMap() {
        return prendas;
    }

    public void setMap(Map<Integer, List<Prenda>> map) {
        this.prendas = map;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public GuardaRopa(Map<Integer, List<Prenda>> map, int identificador) {
        this.prendas = map;
        this.identificador = identificador;
    }

    public GuardaRopa() {
    }

    public Integer guardarPrendas (List<Prenda> listaDePrendas)
    {
        int cantidad = this.prendas.size() +1;
        prendas.put(cantidad, listaDePrendas);
        return cantidad;
    }

    public void mostrarPrendas()
    {
        for (Map.Entry<Integer, List<Prenda>> prendasListado :prendas.entrySet())
        {
            Integer clave = prendasListado.getKey();
            List<Prenda> prenda = prendasListado.getValue();
            System.out.println("La clave de la lista es: " + clave);
            System.out.println("Las prendas para la clave " + clave + " son: " );
            for (int i = 0; i < prenda.size(); i++)
            {
                System.out.println(prenda.get(i).toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        return prendas.get(numero);
    }
}
