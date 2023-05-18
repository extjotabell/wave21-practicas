package ejercicio2;

public class Competitor {
    private int competitorNumber;
    private String competitorDNI;
    private String name;
    private String lastname;
    private int age;
    private String phoneNumber;
    private String emergencyPhoneNumber;
    private String bloodType;

    public Competitor(int competitorNumber, String competitorDNI, String name, String lastname, int age, String phoneNumber, String emergencyPhoneNumber, String bloodType) {
        this.competitorNumber = competitorNumber;
        this.competitorDNI = competitorDNI;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
        this.bloodType = bloodType;
    }

    public Competitor() {
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public String getCompetitorDNI() {
        return competitorDNI;
    }

    public void setCompetitorDNI(String competitorDNI) {
        this.competitorDNI = competitorDNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
