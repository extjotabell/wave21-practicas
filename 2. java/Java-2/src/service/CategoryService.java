package service;

import entity.Category;

public class CategoryService {
    //Singleton
    private CategoryService(){};
    private static CategoryService instance = new CategoryService();
    public static CategoryService getInstance() { return CategoryService.instance; }

    //Categorias posibles
    private Category small = new Category(1, "Circuito chico", "2km por selva y arroyos"); // Circuito chico
    private Category medium = new Category(2, "Circuito medio", "5km por selva, arroyos y barro"); // Circuito medio
    private Category advanced = new Category(3, "Circuito avanzado", "10km por selva, arroyos, barro y escalada de piedra"); // Circuito avanzado

    //Devuelve la categoria segun su id
    public Category getCategoryById(int id){
        switch (id){
            case 1:
                return this.small;
            case 2:
                return this.medium;
            case 3:
                return this.advanced;
            default:
                return null;
        }
    }
}
