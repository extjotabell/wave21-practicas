package com.practicasIntegradoras.Deportistas.entities;

public class Sport {

    public String name;
    public Integer level;

    public String getName() {
        return name;
    }

    public Sport(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
