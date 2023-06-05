package com.example_dto_response_entity_segundaparte.dto_response_entity_segundaparte;

public class SportsPersonDTO {
    private String firstName;
    private String lastName;
    private String sportName;

    public SportsPersonDTO() {
    }

    public SportsPersonDTO(String firstName, String lastName, String sportName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sportName = sportName;
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

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
