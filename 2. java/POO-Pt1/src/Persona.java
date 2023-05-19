public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    private double altura;
    private double peso;

    public Persona(String nombre, int edad, int dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona() {
    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public int calcularIMC(){
        double resultado = (this.peso / (Math.pow(this.altura, 2)));
        System.out.println(resultado);
        if(resultado < 20){
            return -1;
        }
        else if(resultado >= 20 && resultado <= 25){
            return 0;
        }
        else
            return 1;
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
    public String toString(){
        String info = String.format("Nombre: %s\nEdad: %d\nDni: %d\nPeso: %f\nAltura: %f", this.nombre, this.edad, this.dni, this.peso, this.altura);
        return info;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
