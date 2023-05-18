package java_ej2;

public class Inscripcion {
    Categoria categoria;
    Participante participante;
    int numero;
    float monto_a_abonar;

    public Inscripcion(Categoria categoria, Participante participante, int numero) {
        this.categoria = categoria;
        this.participante = participante;
        this.numero = numero;

        switch (categoria.id){
            case 1:
                if(participante.edad > 18){
                    monto_a_abonar = 1300;
                }else{
                    monto_a_abonar = 1500;
                }
                break;
            case 2:
                if(participante.edad > 18){
                    monto_a_abonar = 2300;
                }else{
                    monto_a_abonar = 2000;
                }
                break;
            case 3:
                if(participante.edad > 18){
                    monto_a_abonar = 2800;
                }else{
                    monto_a_abonar = -1;
                }
                break;
        }
    }
}
