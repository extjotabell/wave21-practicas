package org.example;

public class ExceptionPractice {

    private int a = 0;
    private int b = 300;

    public void calculateQuotient() {
        try {
            int result = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Cannot divide by zero", e);
        } finally {
            System.out.println("Program finished");
        }
    }
}
