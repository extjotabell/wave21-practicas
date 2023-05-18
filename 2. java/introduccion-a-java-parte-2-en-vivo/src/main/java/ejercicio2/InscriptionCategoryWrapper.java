package ejercicio2;

public class InscriptionCategoryWrapper {

    private Inscription inscription;
    private Category category;

    public InscriptionCategoryWrapper(Inscription inscription, Category category) {
        this.inscription = inscription;
        this.category = category;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
