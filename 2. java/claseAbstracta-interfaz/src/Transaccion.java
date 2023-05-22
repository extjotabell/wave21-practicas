public interface Transaccion {

    public default void transaccionOK(){
        System.out.println("TRANSACCION OK");
    }

    public default void transaccionNoOK(){
        System.out.println("TRANSACCION NO OK");
    }

}
