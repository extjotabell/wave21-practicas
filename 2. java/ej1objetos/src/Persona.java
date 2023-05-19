public class Persona {
    String nombre;
    String dni;
    String edad;
    Double peso;
    Double altura;

    public Persona() {
    }

    public Persona(String nombre, String dni, String edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, String edad, Double peso, Double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularImc(){
        double calculo = this.peso/(Math.pow(this.altura,2));
        if(calculo<20){
            return -1;
        }else if(calculo>=20 && calculo<=25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if(Integer.valueOf(this.edad)>=18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + '\n' +
                "Dni=" + dni + '\n' +
                "Edad=" + edad + '\n' +
                "Peso=" + peso + "\n"+
                "Altura=" + altura;
    }
}
