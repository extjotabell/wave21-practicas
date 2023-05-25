
import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador{
    private List<Localizador> localizadores;

    public void agregarAlRepositorio(Localizador obj) {
        localizadores.add(obj);
        //System.out.println(obj.toString());
    }


    //Funcion auxiliar para checkear si un cliente tiene al menos 2 localizadores
    public boolean clienteTieneAlMenosDosLocalizadores(Long dni){
        int cant = 0;
        for (Localizador loc : localizadores){
            if(loc.getCliente().getDni() == dni){
                cant++;
            }
        }
        if(cant >= 2)
            return true;
        else
            return false;
    }

    //Funcion para aplicar descuentos a todos los localizadores del repositorio
    public void aplicarDescuentos(){
        for (Localizador l : localizadores){
            l.aplicarDescuento();
            if (clienteTieneAlMenosDosLocalizadores( l.getCliente().getDni() )){
                l.setTotal(l.getTotal()*0.95);
            }
            System.out.println(l.toString());
        }
    }

    public RepositorioLocalizador() {
        this.localizadores = new ArrayList<Localizador>();
    }
}
