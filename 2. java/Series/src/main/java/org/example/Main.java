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

    Decimal d = new Decimal();
    d.set(3.1d);
    System.out.println(d.next());
    System.out.println(d.next());
    System.out.println(d.next());
    System.out.println(d.next());
    d.reset(1d);
    System.out.println(d.next());
    System.out.println(d.next());
    System.out.println(d.next());
    System.out.println(d.next());
  }
}