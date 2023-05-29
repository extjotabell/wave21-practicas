package org.example;
public class Main {
  public static void main(String[] args) {
    Entero e = new Entero();
    e.set(3);
    System.out.println(e.next());
    System.out.println(e.next());
    System.out.println(e.next());
    System.out.println(e.next());
    e.reset(1);
    System.out.println(e.next());
    System.out.println(e.next());
    System.out.println(e.next());
    System.out.println(e.next());
  }
}