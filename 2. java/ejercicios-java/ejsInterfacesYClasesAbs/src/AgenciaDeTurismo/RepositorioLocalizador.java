package AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements Repositorio<Localizador>{
    private List<Localizador> localizadores;

    @Override
    public void agregarAlRepositorio(Localizador obj) {
        localizadores.add(obj);
        System.out.println(obj.toString());
    }

    @Override
    public void search(Localizador obj) {
        /*
        boolean flag = false;
        for (Localizador l : localizadores){
            if(c.getDni() == obj.getDni()){
                System.out.println(c.toString());
                flag = true;
                break;
            }
            if(!flag)
                System.out.println("No se encontro el cliente en el repositorio!");

         */
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
                l.setTotal(l.getTotal()*0.05);
            }
        }
    }

    public RepositorioLocalizador() {
        this.localizadores = new ArrayList<Localizador>();
    }
}
