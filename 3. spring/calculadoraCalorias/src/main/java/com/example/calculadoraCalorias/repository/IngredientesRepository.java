package com.example.calculadoraCalorias.repository;


import com.example.calculadoraCalorias.entitys.Ingrediente;
import com.example.calculadoraCalorias.entitys.Plato;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientesRepository {

    @Autowired
            PlatosRepository platosRepository;
    List<Ingrediente> listaIngredientes = new ArrayList<>();
    List<Plato> listaPlatos = new ArrayList<>();

    public IngredientesRepository(){

        initData();

    }

    public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void initData(){
        Ingrediente i1 = new Ingrediente("Aceitunas negras", 349);
        Ingrediente i2 = new Ingrediente("Aceitunas verdes", 132);
        Ingrediente i3 = new Ingrediente("Acelgas", 33);
        Ingrediente i4 = new Ingrediente("Ajos", 169);
        Ingrediente i5 = new Ingrediente("Alcachofas", 64);
        Ingrediente i6 = new Ingrediente("Apio", 20);
        Ingrediente i7 = new Ingrediente("Berenjena", 29);
        Ingrediente i8 = new Ingrediente("Berros", 21);
        Ingrediente i9 = new Ingrediente("Brócoli", 31);
        Ingrediente i10 = new Ingrediente("Calabacín", 31);
        Ingrediente i11 = new Ingrediente("Calabaza", 24);
        Ingrediente i12 = new Ingrediente("Cebolla", 47);
        Ingrediente i13 = new Ingrediente("Cebolla tierna", 39);
        Ingrediente i14 = new Ingrediente("Champiñón y otras setas", 28);
        Ingrediente i15 = new Ingrediente("Col", 28);
        Ingrediente i16 = new Ingrediente("Col de Bruselas", 54);
        Ingrediente i17 = new Ingrediente("Coliflor", 30);
        Ingrediente i18 = new Ingrediente("Endibia", 22);
        Ingrediente i19 = new Ingrediente("Escarola", 37);
        Ingrediente i20 = new Ingrediente("Espárragos", 26);
        Ingrediente i21 = new Ingrediente("Espárragos en lata", 24);
        Ingrediente i22 = new Ingrediente("Espinaca", 32);
        Ingrediente i23 = new Ingrediente("Espinacas congeladas", 25);
        Ingrediente i24 = new Ingrediente("Habas tiernas", 64);
        Ingrediente i25 = new Ingrediente("Hinojo", 16);
        Ingrediente i26 = new Ingrediente("Lechuga", 18);
        Ingrediente i27 = new Ingrediente("Nabos", 29);
        Ingrediente i28 = new Ingrediente("Papas cocidas", 86);
        Ingrediente i29 = new Ingrediente("Pepino", 12);
        Ingrediente i30 = new Ingrediente("Perejil", 55);
        Ingrediente i31 = new Ingrediente("Pimiento", 22);
        Ingrediente i32 = new Ingrediente("Porotos verdes", 21);
        Ingrediente i33 = new Ingrediente("Puerros", 42);
        Ingrediente i34 = new Ingrediente("Rábanos", 20);
        Ingrediente i35 = new Ingrediente("Remolacha", 40);
        Ingrediente i36 = new Ingrediente("Repollo", 19);
        Ingrediente i37 = new Ingrediente("Rúcula", 37);
        Ingrediente i38 = new Ingrediente("Soja, Brotes de", 50);
        Ingrediente i39 = new Ingrediente("Tomate triturado en conserva", 39);
        Ingrediente i40 = new Ingrediente("Tomates", 22);
        Ingrediente i41 = new Ingrediente("Trufa", 92);
        Ingrediente i42 = new Ingrediente("Zanahoria", 42);
        Ingrediente i43 = new Ingrediente("Zumo de tomate", 21);
        Ingrediente i44 = new Ingrediente("Arándanos", 41);
        Ingrediente i45 = new Ingrediente("Caqui", 64);
        Ingrediente i46 = new Ingrediente("Cereza", 47);
        Ingrediente i47 = new Ingrediente("Chirimoya", 78);
        Ingrediente i48 = new Ingrediente("Ciruela", 44);
        Ingrediente i49 = new Ingrediente("Ciruela seca", 290);
        Ingrediente i50 = new Ingrediente("Coco", 646);
        Ingrediente i51 = new Ingrediente("Dátil", 279);
        Ingrediente i52 = new Ingrediente("Dátil seco", 306);
        Ingrediente i53 = new Ingrediente("Frambuesa", 40);
        Ingrediente i54 = new Ingrediente("Fresas", 36);
        Ingrediente i55 = new Ingrediente("Granada", 65);
        Ingrediente i56 = new Ingrediente("Grosella", 37);
        Ingrediente i57 = new Ingrediente("Higos", 80);
        Ingrediente i58 = new Ingrediente("Higos secos", 275);
        Ingrediente i59 = new Ingrediente("Kiwi", 51);
        Ingrediente i60 = new Ingrediente("Limón", 39);
        Ingrediente i61 = new Ingrediente("Mandarina", 40);
        Ingrediente i62 = new Ingrediente("Mango", 57);
        Ingrediente i63 = new Ingrediente("Manzana", 52);
        Ingrediente i64 = new Ingrediente("Melón", 31);
        Ingrediente i65 = new Ingrediente("Mora", 37);
        Ingrediente i66 = new Ingrediente("Naranja", 44);
        Ingrediente i67 = new Ingrediente("Nectarina", 64);
        Ingrediente i68 = new Ingrediente("Nísperos", 97);
        Ingrediente i69 = new Ingrediente("Papaya", 45);
        Ingrediente i70 = new Ingrediente("Pera", 61);
        Ingrediente i71 = new Ingrediente("Piña", 51);
        listaIngredientes.add(i1);
        listaIngredientes.add(i2);
        listaIngredientes.add(i3);
        listaIngredientes.add(i4);
        listaIngredientes.add(i5);
        listaIngredientes.add(i6);
        listaIngredientes.add(i7);
        listaIngredientes.add(i8);
        listaIngredientes.add(i9);
        listaIngredientes.add(i10);
        listaIngredientes.add(i11);
        listaIngredientes.add(i12);
        listaIngredientes.add(i13);
        listaIngredientes.add(i14);
        listaIngredientes.add(i15);
        listaIngredientes.add(i16);
        listaIngredientes.add(i17);
        listaIngredientes.add(i18);
        listaIngredientes.add(i19);
        listaIngredientes.add(i20);
        listaIngredientes.add(i21);
        listaIngredientes.add(i22);
        listaIngredientes.add(i23);
        listaIngredientes.add(i24);
        listaIngredientes.add(i25);
        listaIngredientes.add(i26);
        listaIngredientes.add(i27);
        listaIngredientes.add(i28);
        listaIngredientes.add(i29);
        listaIngredientes.add(i30);
        listaIngredientes.add(i31);
        listaIngredientes.add(i32);
        listaIngredientes.add(i33);
        listaIngredientes.add(i34);
        listaIngredientes.add(i35);
        listaIngredientes.add(i36);
        listaIngredientes.add(i37);
        listaIngredientes.add(i38);
        listaIngredientes.add(i39);
        listaIngredientes.add(i40);
        listaIngredientes.add(i41);
        listaIngredientes.add(i42);
        listaIngredientes.add(i43);
        listaIngredientes.add(i44);
        listaIngredientes.add(i45);
        listaIngredientes.add(i46);
        listaIngredientes.add(i47);
        listaIngredientes.add(i48);
        listaIngredientes.add(i49);
        listaIngredientes.add(i50);
        listaIngredientes.add(i51);
        listaIngredientes.add(i52);
        listaIngredientes.add(i53);
        listaIngredientes.add(i54);
        listaIngredientes.add(i55);
        listaIngredientes.add(i56);
        listaIngredientes.add(i57);
        listaIngredientes.add(i58);
        listaIngredientes.add(i59);
        listaIngredientes.add(i60);
        listaIngredientes.add(i61);
        listaIngredientes.add(i62);
        listaIngredientes.add(i63);
        listaIngredientes.add(i64);
        listaIngredientes.add(i65);
        listaIngredientes.add(i66);
        listaIngredientes.add(i67);
        listaIngredientes.add(i68);
        listaIngredientes.add(i69);
        listaIngredientes.add(i70);
        listaIngredientes.add(i71);

        List<Ingrediente> lista1 = new ArrayList<>(List.of(i1, i2, i3, i4, i5));
        List<Ingrediente> lista2 = new ArrayList<>(List.of(i6, i7, i8, i9, i10));
        List<Ingrediente> lista3 = new ArrayList<>(List.of(i11, i12, i13, i14, i15));
        List<Ingrediente> lista4 = new ArrayList<>(List.of(i16, i17, i18, i19, i20));
        List<Ingrediente> lista5 = new ArrayList<>(List.of(i21, i22, i23, i24, i25));
        List<Ingrediente> lista6 = new ArrayList<>(List.of(i26, i27, i28, i29, i30));
        List<Ingrediente> lista7 = new ArrayList<>(List.of(i31, i32, i33, i34, i35));
        List<Ingrediente> lista8 = new ArrayList<>(List.of(i36, i37, i38, i39, i40));
        List<Ingrediente> lista9 = new ArrayList<>(List.of(i41, i42, i43, i44, i45));
        List<Ingrediente> lista10 = new ArrayList<>(List.of(i46, i47, i48, i49, i50));
        List<Ingrediente> lista11 = new ArrayList<>(List.of(i51, i52, i53, i54, i55));
        List<Ingrediente> lista12 = new ArrayList<>(List.of(i56, i57, i58, i59, i60));
        List<Ingrediente> lista13 = new ArrayList<>(List.of(i61, i62, i63, i64, i65));
        List<Ingrediente> lista14 = new ArrayList<>(List.of(i66, i67, i68, i69, i70));

        Plato plato1 = new Plato("Plato1", List.of(i1,i2,i3,i4,i5));
        Plato plato2 = new Plato("Plato2", List.of(i6,i7,i8,i9,i10));
        Plato plato3 = new Plato("Plato3", List.of(i11,i12,i13,i14,i15));
        Plato plato4 = new Plato("Plato4", List.of(i16, i17, i18, i19, i20));

        listaPlatos.add(plato1);
        listaPlatos.add(plato2);
        listaPlatos.add(plato3);
        listaPlatos.add(plato4);



    }





}
