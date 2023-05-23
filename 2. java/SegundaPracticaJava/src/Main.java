
public class Main {
    public static void main(String[] args) {
        Categoria categoriaChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyo");
        Categoria categoriaMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyo y barro");
        Categoria categoriaGrande = new Categoria(3, "Circuito grande", "10 km por selva, arroyo y escalada en piedra");

        Participante participante1 = new Participante(1, 4564544, "Juan", "Perez", 27, "061565657", 24548468, "A+");

        Inscripcion inscripcionPart1 = new Inscripcion(1, categoriaChico,participante1, 456);
    }
}