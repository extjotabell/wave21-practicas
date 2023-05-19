public class Person {
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Person(){ }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int cacularIMC(){
        double imc = this.weight / (Math.pow(this.height, 2));

        return imc < 20 ? -1 : imc > 25 ? 1 : 0;
    }

    public boolean esMayorDeEdad(){
        return this.age >= 18;
    }

    public String toString(){
        return new StringBuilder()
                .append("Nombre: ").append(this.name).append("\n")
                .append("Edad: ").append(this.age).append("\n")
                .append("DNI :").append(this.dni).append("\n")
                .append("Peso: ").append(this.weight).append("\n")
                .append("Altura: ").append(this.height).append("\n")
                .toString();
    }
}
