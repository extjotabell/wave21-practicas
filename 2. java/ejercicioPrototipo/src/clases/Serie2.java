package clases;

public class Serie2 extends Prototipo{
    @Override
    public int valorSiguiente() {
        if(this.contador==null || this.contador==0){
            return 0;
        }else{
            this.contador+=this.valorInicial;
            return this.contador;
        }
    }

    @Override
    public void setValorInicial(Integer valorInicial) {
        this.valorInicial=valorInicial;
        this.contador=valorInicial;
    }

    @Override
    public void reiniciarSerie() {
        this.contador=this.valorInicial;
    }
}
