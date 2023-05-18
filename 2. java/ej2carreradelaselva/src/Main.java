import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Categoria chico= new Categoria(1,"Circuito Chico","2 km por selva y arroyos.");
        Categoria medio= new Categoria(2,"Circuito Medio","5 km por selva, arroyos y barro.");
        Categoria avanzado= new Categoria(3,"Circuito Avanzado","10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1= new Participante(1,"43232432","Juan","Lopez",21,341312312l,3213213123l,"A+");
        Participante participante2= new Participante(2,"43232231","Maria","Alarcon",15,3412131l,3215464l,"B-");
        Participante participante3= new Participante(3,"43232243","Marcos","Lis",18,341312131232l,321322325l,"0+");

        Inscripcion inscripcionParticipante1Chico= new Inscripcion(1,chico,participante1);
        Inscripcion inscripcionParticipante2Chico= new Inscripcion(2,chico,participante2);
        Inscripcion inscripcionParticipante3Chico= new Inscripcion(3,chico,participante3);

        Inscripcion inscripcionParticipante1Medio= new Inscripcion(4,medio,participante1);
        Inscripcion inscripcionParticipante2Medio= new Inscripcion(5,medio,participante2);
        Inscripcion inscripcionParticipante3Medio= new Inscripcion(6,medio,participante3);

        Inscripcion inscripcionParticipante1Avanzado= new Inscripcion(7,avanzado,participante1);
        Inscripcion inscripcionParticipante2Avanzado= new Inscripcion(8,avanzado,participante2);
        Inscripcion inscripcionParticipante3Avanzado= new Inscripcion(9,avanzado,participante3);

        List<Inscripcion> inscripciones = new ArrayList<>(Arrays.asList(inscripcionParticipante1Chico,inscripcionParticipante2Chico,inscripcionParticipante3Chico,inscripcionParticipante1Avanzado,inscripcionParticipante2Avanzado,inscripcionParticipante3Avanzado,inscripcionParticipante1Medio,inscripcionParticipante2Medio,inscripcionParticipante3Medio));

        for(Inscripcion inscripcion: inscripciones){
            if(inscripcion.getCategoria().getNombre()=="Circuito Chico"){
                System.out.println(inscripcion.toString());
            }
        }

        inscripciones.remove(inscripcionParticipante1Chico);

        for(Inscripcion inscripcion: inscripciones){
            if(inscripcion.getCategoria().getNombre()=="Circuito Chico"){
                System.out.println(inscripcion.toString());
            }
        }

        Double acumChico=0d;
        Double acumMedio=0d;
        Double acumAvanzado=0d;

        for(Inscripcion inscripcion: inscripciones){
            if(inscripcion.getCategoria().getNombre()=="Circuito Chico"){
                acumChico+=inscripcion.getMonto();
            }else if(inscripcion.getCategoria().getNombre()=="Circuito Medio"){
                acumMedio+=inscripcion.getMonto();
            }else{
                acumAvanzado+=inscripcion.getMonto();
            }
        }

        System.out.println("El total recaudado por Circuito Chico es: "+acumChico);
        System.out.println("El total recaudado por Circuito Medio es: "+acumMedio);
        System.out.println("El total recaudado por Circuito Avanzado es: "+acumAvanzado);
        System.out.println("El total recaudado por todas las carreras es: "+(acumChico+acumAvanzado+acumMedio));
    }
}