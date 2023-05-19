package entity;

//Competidores de la carrera
public class Competitor {
    private int number;
    private String name;
    private String lastName;
    private int age;
    private String dni;
    private String phone;
    private String bloodType;
    private String emergencyNumber;

    public Competitor(int number, String name, String lastName, int age, String dni, String phone, String bloodType, String emergencyNumber) {
        this.number = number;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
        this.phone = phone;
        this.bloodType = bloodType;
        this.emergencyNumber = emergencyNumber;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
