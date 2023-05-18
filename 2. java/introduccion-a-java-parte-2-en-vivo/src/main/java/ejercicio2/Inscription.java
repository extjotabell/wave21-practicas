package ejercicio2;

public class Inscription {
    private int inscriptionNumber;
    private int categoryId;
    private int competitorId;
    private int amountToPay;

    public Inscription(int inscriptionNumber, int categoryId, int competitorId, int amountToPay) {
        this.inscriptionNumber = inscriptionNumber;
        this.categoryId = categoryId;
        this.competitorId = competitorId;
        this.amountToPay = amountToPay;
    }

    public Inscription() {
    }

    public int getInscriptionNumber() {
        return inscriptionNumber;
    }

    public void setInscriptionNumber(int inscriptionNumber) {
        this.inscriptionNumber = inscriptionNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }
}
