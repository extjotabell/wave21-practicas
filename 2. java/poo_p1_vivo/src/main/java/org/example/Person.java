package org.example;

// Exercise 1
public class Person {
    protected String name;
    protected int age;
    protected String dni;
    protected float weigth;
    protected float height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }
    public Person(String name, int age, String dni, float weigth, float height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weigth = weigth;
        this.height = height;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int calculateBMI() {
        float cal = (this.weigth / (this.height * this.height));
        return cal < 20 ? -1 : (cal >= 20 && cal <= 25) ? 0 : 1;
    }

    public boolean isAdult() {
        return this.age > 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weigth=" + weigth +
                ", height=" + height +
                '}';
    }
}
