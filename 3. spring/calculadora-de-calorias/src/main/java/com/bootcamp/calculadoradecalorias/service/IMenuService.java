package com.bootcamp.calculadoradecalorias.service;

import com.bootcamp.calculadoradecalorias.dto.DishRequestDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuMultiResponseDTO;

import java.util.List;

public interface IMenuService {
    MenuDTO getNutritionalFacts(String name, String weight);

    List<MenuMultiResponseDTO> getNutritionalFactsMulti(List<DishRequestDTO> names);
}
