package com.example.lasPerlasJoyeria.service;

import com.example.lasPerlasJoyeria.dto.JewelDTO;
import com.example.lasPerlasJoyeria.model.Jewel;

import java.util.List;

public interface IJewerlyService {
    List<JewelDTO> getJewelryList ();
    public void saveJewel (JewelDTO jewel);
    public void deleteJewel (long id);
    public JewelDTO findJewel (long id);
}
