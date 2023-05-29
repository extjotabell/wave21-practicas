package clases;

public class Serie3 extends Prototipo{
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
        this.contador=this.valorInicial;
    }

    @Override
    public void reiniciarSerie() {
        if(this.valorInicial!=null)
            this.contador=this.valorInicial;
    }
}
