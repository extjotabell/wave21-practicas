package entity;

//Categorias posibles de la carrera
public class Category {
    private int id;
    private String name;
    private String description;
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }
}
