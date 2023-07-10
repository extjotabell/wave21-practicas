package com.jewelry.jewelry.service;

import com.jewelry.jewelry.dto.request.JewelryRequestDto;
import com.jewelry.jewelry.dto.response.JewelryResponseDto;

import java.util.List;

public interface IJewelryService {
    Long addItem(JewelryRequestDto item);
    List<JewelryResponseDto> getAllItems();
    void deleteItem(Long itemId);
    JewelryResponseDto updateItem(Long id, JewelryRequestDto item);

}
