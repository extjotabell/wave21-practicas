public abstract class Documento implements Imprimible {
    //una clase abstracta al menos debe contener un metodo abstracto

    public abstract void imprimir();

    @Override
    public void imprimirTipoDoc(){
        System.out.println("----"+ getClass().getSimpleName().toUpperCase() + "----");
    }


}
