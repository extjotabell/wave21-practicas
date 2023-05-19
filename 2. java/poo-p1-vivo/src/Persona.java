public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        double resultado = this.peso/(Math.pow(this.altura,2));

        /*if(resultado < 20){
            return -1;
        } else if (resultado>=20 && resultado<=25) {
            return 0;
        }
        return 1;*/

        return resultado < 20 ? -1 : resultado >= 20 && resultado <=25 ? 0 : 1;

    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString(){
        return  "nombre:"+this.nombre+
                ",\nedad:"+this.edad+
                ",\ndni:"+this.dni+
                ",\npeso:"+this.peso+
                ",\naltura:"+this.altura;
    }

}
