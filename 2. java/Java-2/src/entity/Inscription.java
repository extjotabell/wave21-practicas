package entity;

import entity.Category;
import util.Sequencer;

//Inscipciones a la carrera
public class Inscription {
    private int number;
    private Category category;
    private Competitor competitor;
    private int amountToPay;

    public Inscription(Category category, Competitor competitor) {
        if(category == null) return;

        switch (category.getId()){
            case 1:
                if(competitor.getAge() < 18){
                    amountToPay = 1300;
                }else {
                    amountToPay = 1500;
                }
                break;
            case 2:
                if(competitor.getAge() < 18){
                    amountToPay = 2000;
                }else {
                    amountToPay = 2300;
                }
                break;
            case 3:
                if(competitor.getAge() < 18){
                    //invalid age
                    return;
                }else {
                    amountToPay = 2800;
                }
                break;
            default:
                //invalid category
                amountToPay = 0;
                return;
        }

        this.number = Sequencer.getNextValue();
        this.category = category;
        this.competitor = competitor;
    }

    public int getCategoryId() {
        return this.category == null ? 0 : this.category.getId();
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    //Devuelve la informacion de la inscripcion
    public String getInformation(){
        return new StringBuilder("Numero de Inscricion: ")
                .append(this.number)
                .append(". Nombre de Inscripto: ")
                .append(this.competitor.getName())
                .append(" ")
                .append(this.competitor.getLastName())
                .append(". Edad de inscripto: ")
                .append(this.competitor.getAge())
                .toString();
    }
}
