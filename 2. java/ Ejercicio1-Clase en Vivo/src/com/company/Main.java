package com.company;

public class Main {

    public static void main(String[] args) {

    String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","San Pablo","Lima","Santiago de Chile","Lisboa","Tokio"};
	double temp[][] = {{ -2 ,33 }, { -3 ,32 }, { -8 ,27 }, { 4 ,37 }, { 6 ,42 }, { 5 ,43 }, { 0 ,39 }, { -7 ,26 }, { -1 ,31 }, { -10 ,35 }};
    int pos_temp_max = 0;
    int pos_temp_min = 0;
    double temp_min = temp[0][0];
    double temp_max = temp[1][0];

    for(int i = 0 ; i < temp.length; i ++){
    // Aca busco los minimos
    if (temp[i][0] < temp_min){
        pos_temp_min = i;
        temp_min = temp[i][0];
    }
    //aca busco los maximos
    if(temp[i][1] > temp_max){
        pos_temp_max = i;
        temp_max =temp[i][1];
    }
    }


    //Resultados
    System.out.println("*******INFORME FINAL**********");
    System.out.println("La temperatura minima se encuentra en la ciudad de " + ciudades[pos_temp_min] + " y es de " + temp_min);
    System.out.println("La temperatura maxima se encuentra en la ciudad de "+ ciudades[pos_temp_max] + "y  es de " + temp_max);
    }

}
