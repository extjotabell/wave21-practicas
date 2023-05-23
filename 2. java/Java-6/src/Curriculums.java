import java.util.List;

public class Curriculums implements Imprimble{
    private String name;
    private int age;
    private List<String> skills;

    public Curriculums(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public void imprimir() {
        System.out.println(
                new StringBuilder("Nombre: ").append(this.name).append("\n")
                        .append("Edad: ").append(this.age).append("\n")
                        .append("Habilidades: ").append(String.join(" - ", this.skills)).append("\n")
        );
    }
}
