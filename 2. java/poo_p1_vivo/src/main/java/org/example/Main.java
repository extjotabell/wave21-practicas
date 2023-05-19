package org.example;

public class Main {
    public static void main(String[] args) {
        Person personVoid = new Person();
        Person personIncomplete = new Person("Lean", 193, "123456789-0");
        Person personComplete = new Person("Lean", 193, "123456789-0", 390.3f, 3.4f);
        System.out.println(personVoid.getName());
        System.out.println(personVoid.getAge());
        System.out.println(personVoid.getDni());
        System.out.println(personVoid.getWeigth());
        System.out.println(personVoid.getHeight());

        System.out.println(personIncomplete.getName());
        System.out.println(personIncomplete.getAge());
        System.out.println(personIncomplete.getDni());
        System.out.println(personIncomplete.getWeigth());
        System.out.println(personIncomplete.getHeight());

        System.out.println(personComplete.getName());
        System.out.println(personComplete.getAge());
        System.out.println(personComplete.getDni());
        System.out.println(personComplete.getWeigth());
        System.out.println(personComplete.getHeight());

        // Person personError = new Person("Lean", 193);
        int personCompleteBMI = personComplete.calculateBMI();
        boolean isAdultPersonComplete = personComplete.isAdult();

        System.out.println("Índice de masa corporal (IMC)\n");
        System.out.println("Nivel de peso\t\t\t\t\t\tDescripción");
        System.out.println("-------------------------------------------------");
        System.out.println("Por debajo de 20\t\t\t\t\tBajo peso");
        System.out.println("Entre 20 y 25 inclusive\t\t\tPeso saludable");
        System.out.println("Mayor de 25\t\t\t\t\t\tSobrepeso");

        StringBuilder sb = new StringBuilder();
        sb.append(personComplete.getName());
        sb.append(" has ");
        sb.append(personComplete.getAge());
        sb.append(" years old");
        String bmiMsg = personCompleteBMI < -1 ? "Underweight" : personCompleteBMI == 0 ? "Healthy Weight" : "Overweight";
        sb.append(". His BMI: ");
        sb.append(bmiMsg);
        sb.append(". Is adult: ");
        sb.append(isAdultPersonComplete ? "si" : "no");
        String result = sb.toString();
        System.out.println(result);
    }
}