
public class Main {
    public static void main(String[] args) {
        Persona persona_vacio = new Persona();
        Persona persona_algunos = new Persona("Juanito", 20, "130645211");
        Persona persona_todos = new Persona("Pedro", 21, "200993942", 76.5F, 1.75F);
        System.out.println(persona_todos.toString());

        // Person personError = new Person("Lean", 193);
        int imc = persona_todos.calcularIMC();
        boolean mayorDeEdad = persona_todos.esMayorDeEdad();

        System.out.println("Índice de masa corporal (IMC)\n");
        System.out.println("Nivel de peso\t\t\t\t\t\tDescripción");
        System.out.println("-------------------------------------------------");
        System.out.println("Por debajo de 20\t\t\t\t\tBajo peso");
        System.out.println("Entre 20 y 25 inclusive\t\t\tPeso saludable");
        System.out.println("Mayor de 25\t\t\t\t\t\tSobrepeso");

        StringBuilder sb = new StringBuilder();
        sb.append(persona_todos.getNombre());
        sb.append(" tiene ");
        sb.append(persona_todos.getEdad());
        sb.append(" años");
        String bmiMsg = imc < -1 ? "Bajo peso" : imc == 0 ? "Peso saludable" : "Sobrepeso";
        sb.append(". su IMC: ");
        sb.append(bmiMsg);
        sb.append(". Es adulto: ");
        sb.append(mayorDeEdad ? "si" : "no");
        String result = sb.toString();
        System.out.println(result);
    }
}