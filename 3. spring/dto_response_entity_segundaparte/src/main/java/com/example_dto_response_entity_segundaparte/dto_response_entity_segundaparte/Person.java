package com.example_dto_response_entity_segundaparte.dto_response_entity_segundaparte;
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Sport sport;

    public Person(String firstName, String lastName, int age, Sport sport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sport = sport;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}