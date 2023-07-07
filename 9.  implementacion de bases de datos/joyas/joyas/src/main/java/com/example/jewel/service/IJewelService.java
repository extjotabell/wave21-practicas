package com.example.jewel.service;

import com.example.jewel.model.Jewel;

import java.util.List;

public interface IJewelService {

    public String saveJewel(Jewel jewel);
    public List<Jewel> getJewels();
    public Jewel findJewel(Long id);
    public String deleteJewel(Long id);
    public String editJewel(Long id, Jewel newJewel);

}
