package org.example;

public
class Participant {
    private int id;
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String cellphone;
    private String emergencyNumber;
    private String bloodGroup;
    public Participant(int id, String dni, String name, String surname, int age, String cellphone, String emergencyNumber, String bloodGroup) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cellphone = cellphone;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    // Add getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    // toString

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cellphone='" + cellphone + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }


    // Other methods as required
}
