package clases;

public class Client {
    String dni;
    String name;
    String lastName;

    public Client(String dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public String getDni(){
        return this.dni;
    }

    @Override
    public String toString(){
        return new StringBuilder("DNI: ").append(this.dni).append("\n")
                .append("Nombre: ").append(this.name).append(" ").append(this.lastName).append("\n")
                .toString();
    }
}
