package com.example.romanos.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RomanoService {
  private static final Map<String, String> DIC = Map.ofEntries(
    Map.entry("1", "I"),
    Map.entry("2", "II"),
    Map.entry("3", "III"),
    Map.entry("4", "IV"),
    Map.entry("5", "V"),
    Map.entry("6", "VI"),
    Map.entry("7", "VII"),
    Map.entry("8", "VIII"),
    Map.entry("9", "IX"),
    Map.entry("10", "X"),
    Map.entry("50", "L"),
    Map.entry("100", "C"),
    Map.entry("500", "D"),
    Map.entry("1000", "M"),
    Map.entry("5000", "V^"),
    Map.entry("10000", "X^"),
    Map.entry("50000", "L^")
  );

  /**
   * Parseo de decimal a numeros romanos. Limite en 89999
   * @param caracteres Lista de los caracteres del numero
   * @return
   */
  public static List<String> decimalARomano(List<String> caracteres) {

    List<Integer> numeroEnDigitos = RomanoService.separarDigitos(caracteres);

    List<String> number = new ArrayList<>();

    for(int i=0;i<numeroEnDigitos.size();++i) {
      int v = numeroEnDigitos.get(i);
      number.add(String.valueOf(RomanoService.parse(v, i)));
    }

    return number;
  }

  /**
   * Separa en centenas decenas, unidades con los ceros correspondientes
   * [1, 2, 0] -> [100, 20, 0]
   * @param c
   * @return
   */
  private static List<Integer> separarDigitos(List<String> c) {
    List<Integer> l = new ArrayList<>();

    for(int lvl=c.size()-1;lvl>=0;--lvl)
      l.add(Integer.valueOf(c.get(lvl) + "0".repeat(c.size()-1-lvl)));

    return l;
  }


  /**
   * Separo en la raiz y la cantidad de 0. La raiz me indica la cantidad de veces que se va a representar un digito romano.
   * CASOS ESPECIALES
   * Si el digito es un 4 se representa con una resta en digitos romanos
   * Si el digito es un 9 se representa con una resta en digitos romanos
   * Si el digito es un 1 se representa con un solo digito romano
   * Si el digito es un 5 se representa con un solo digito romano
   *
   * @param number
   * @param zeros
   * @return
   */
  private static String parse(int number, int zeros) {

    String cantZeros = "0".repeat(zeros);
    int raiz = (number/Integer.valueOf("1"+cantZeros));

    if(raiz == 4) return RomanoService.DIC.getOrDefault("1" + cantZeros, "none") + RomanoService.DIC.getOrDefault("5" + cantZeros, "none");
    else if(raiz == 9) return RomanoService.DIC.getOrDefault("1" + cantZeros, "none")+RomanoService.DIC.getOrDefault("1" + cantZeros+"0", "none");
    else if(raiz == 5) return RomanoService.DIC.getOrDefault("5" + cantZeros, "none");
    else if(raiz == 1) return RomanoService.DIC.getOrDefault("1" + cantZeros, "none");
    else if(raiz > 5) return RomanoService.DIC.getOrDefault("5" + cantZeros, "none") + RomanoService.DIC.getOrDefault("1" + cantZeros, "none").repeat(raiz % 5);

    return RomanoService.DIC.getOrDefault("1" + cantZeros, "none").repeat(raiz);
  }
}
