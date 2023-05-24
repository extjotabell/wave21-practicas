package com.bootcamp.wave21;

public class Main {

    public static void main(String[] args) {
	SerieDeEntero serieDeEnteros;
	SerieDeDobles serieDeDobles;

	serieDeEnteros = new SerieDeEntero(2);
	System.out.println("Inicializamos con 1 la seria para que vaya 1,3,5,7....");
	serieDeEnteros.inicializarSerie(1);
    System.out.println("Ahora ejecutamos 10 veces para ver como avanza la serie");
	for(int i = 0; i < 10; i ++){
	    System.out.println("EL siguiente numero entero es :  " + serieDeEnteros.siguienteNumero());
    }
	System.out.println("Reiniciamos los valores y vemos como quedan las variables");
	serieDeEnteros.reiniciarNumero();
	System.out.println("El numero inicial es: " + serieDeEnteros.getNumeroInicial());
	System.out.println("La serie quedo reiniciada en : " + serieDeEnteros.getNumeroActual());
	System.out.println("El salto es de: " + serieDeEnteros.getNumeroDeSaltos());
	System.out.println("\n\n\n\nAhora vamos de 4 en 4 ");
	serieDeEnteros = new SerieDeEntero(4);
	System.out.println("Inicializamos con 3 la seria para que vaya 3,7,11...");
	serieDeEnteros.inicializarSerie(3);
	System.out.println("Ahora ejecutamos 10 veces para ver como avanza la serie");
	for(int i = 0; i < 10; i ++){
			System.out.println("EL siguiente numero entero es :  " + serieDeEnteros.siguienteNumero());
	}
	System.out.println("Reiniciamos los valores y vemos como quedan las variables");
	serieDeEnteros.reiniciarNumero();
	System.out.println("El numero inicial es: " + serieDeEnteros.getNumeroInicial());
	System.out.println("La serie quedo reiniciada en : " + serieDeEnteros.getNumeroActual());
	System.out.println("El salto es de: " + serieDeEnteros.getNumeroDeSaltos());
	System.out.println("\n\n\n\nAhora vamos con los double de 4.4 en 4.4 inicializando en 2.1");
	serieDeDobles = new SerieDeDobles(4.4);
	System.out.println("Inicializamos con 4.4");
	serieDeDobles.inicializarSerie(2.1);
	System.out.println("Ahora ejecutamos 10 veces para ver como avanza la serie");
	for(int i = 0; i < 10; i ++){
		System.out.println("EL siguiente numero entero es :  " + serieDeDobles.siguienteNumero());
	}
	System.out.println("Reiniciamos los valores y vemos como quedan las variables");
	serieDeDobles.reiniciarNumero();
	System.out.println("El numero inicial es: " + serieDeDobles.getNumeroInicial());
	System.out.println("La serie quedo reiniciada en : " + serieDeDobles.getNumeroActual());
	System.out.println("El salto es de: " + serieDeDobles.getNumeroDeSaltos());

    }
}
